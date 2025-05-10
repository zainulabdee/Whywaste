package io.sentry.android.core;

import io.sentry.k3;
import io.sentry.n0;
import io.sentry.android.timber.SentryTimberIntegration;
import io.sentry.l4;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import android.app.Application;
import io.sentry.z2;
import io.sentry.Integration;
import io.sentry.x2;
import io.sentry.u2;
import io.sentry.y2;
import io.sentry.o0;
import io.sentry.cache.n;
import io.sentry.cache.w;
import io.sentry.s5;
import io.sentry.l;
import io.sentry.i0;
import io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter;
import java.util.List;
import io.sentry.compose.gestures.ComposeGestureTargetLocator;
import java.util.ArrayList;
import io.sentry.android.core.internal.modules.a;
import io.sentry.q4;
import io.sentry.android.core.internal.util.u;
import io.sentry.transport.q;
import io.sentry.x;
import io.sentry.cache.f;
import io.sentry.android.core.cache.b;
import io.sentry.transport.r;
import java.io.File;
import android.content.Context;
import android.content.pm.PackageInfo;

final class y
{
    private static String d(final PackageInfo packageInfo, final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(packageInfo.packageName);
        sb.append("@");
        sb.append(packageInfo.versionName);
        sb.append("+");
        sb.append(s);
        return sb.toString();
    }
    
    private static void e(final Context context, final SentryAndroidOptions sentryAndroidOptions) {
        ((q4)sentryAndroidOptions).setCacheDirPath(new File(context.getCacheDir(), "sentry").getAbsolutePath());
    }
    
    static void f(final SentryAndroidOptions sentryAndroidOptions, final Context context, final l0 l0, final w0 w0, final h h) {
        if (((q4)sentryAndroidOptions).getCacheDirPath() != null && ((q4)sentryAndroidOptions).getEnvelopeDiskCache() instanceof r) {
            ((q4)sentryAndroidOptions).setEnvelopeDiskCache((f)new b(sentryAndroidOptions));
        }
        ((q4)sentryAndroidOptions).addEventProcessor((x)new q0(context, l0, sentryAndroidOptions));
        ((q4)sentryAndroidOptions).addEventProcessor((x)new b1(sentryAndroidOptions, h));
        ((q4)sentryAndroidOptions).addEventProcessor((x)new ScreenshotEventProcessor(sentryAndroidOptions, l0));
        ((q4)sentryAndroidOptions).addEventProcessor((x)new ViewHierarchyEventProcessor(sentryAndroidOptions));
        ((q4)sentryAndroidOptions).addEventProcessor((x)new f0(context, sentryAndroidOptions, l0));
        ((q4)sentryAndroidOptions).setTransportGate((q)new c0(context, ((q4)sentryAndroidOptions).getLogger()));
        ((q4)sentryAndroidOptions).setTransactionProfiler((io.sentry.w0)new b0(context, sentryAndroidOptions, l0, new u(context, (q4)sentryAndroidOptions, l0)));
        ((q4)sentryAndroidOptions).setModulesLoader((io.sentry.internal.modules.b)new a(context, ((q4)sentryAndroidOptions).getLogger()));
        ((q4)sentryAndroidOptions).setDebugMetaLoader((io.sentry.internal.debugmeta.a)new io.sentry.android.core.internal.debugmeta.a(context, ((q4)sentryAndroidOptions).getLogger()));
        final boolean b = w0.b("androidx.core.view.ScrollingView", (q4)sentryAndroidOptions);
        final boolean b2 = w0.b("androidx.compose.ui.node.Owner", (q4)sentryAndroidOptions);
        if (((q4)sentryAndroidOptions).getGestureTargetLocators().isEmpty()) {
            final ArrayList gestureTargetLocators = new ArrayList(2);
            ((List)gestureTargetLocators).add((Object)new io.sentry.android.core.internal.gestures.a(b));
            if (b2 && w0.b("io.sentry.compose.gestures.ComposeGestureTargetLocator", (q4)sentryAndroidOptions)) {
                ((List)gestureTargetLocators).add((Object)new ComposeGestureTargetLocator(((q4)sentryAndroidOptions).getLogger()));
            }
            ((q4)sentryAndroidOptions).setGestureTargetLocators((List<io.sentry.internal.gestures.a>)gestureTargetLocators);
        }
        if (((q4)sentryAndroidOptions).getViewHierarchyExporters().isEmpty() && b2 && w0.b("io.sentry.compose.viewhierarchy.ComposeViewHierarchyExporter", (q4)sentryAndroidOptions)) {
            final ArrayList viewHierarchyExporters = new ArrayList(1);
            ((List)viewHierarchyExporters).add((Object)new ComposeViewHierarchyExporter(((q4)sentryAndroidOptions).getLogger()));
            ((q4)sentryAndroidOptions).setViewHierarchyExporters((List<io.sentry.internal.viewhierarchy.a>)viewHierarchyExporters);
        }
        ((q4)sentryAndroidOptions).setMainThreadChecker((io.sentry.util.thread.b)io.sentry.android.core.internal.util.b.d());
        if (((q4)sentryAndroidOptions).getCollectors().isEmpty()) {
            ((q4)sentryAndroidOptions).addCollector((i0)new io.sentry.android.core.u());
            ((q4)sentryAndroidOptions).addCollector((i0)new io.sentry.android.core.r(((q4)sentryAndroidOptions).getLogger(), l0));
        }
        ((q4)sentryAndroidOptions).setTransactionPerformanceCollector((s5)new l((q4)sentryAndroidOptions));
        if (((q4)sentryAndroidOptions).getCacheDirPath() != null) {
            ((q4)sentryAndroidOptions).addScopeObserver((io.sentry.q0)new w((q4)sentryAndroidOptions));
            ((q4)sentryAndroidOptions).addOptionsObserver((o0)new n((q4)sentryAndroidOptions));
        }
    }
    
    static void g(final Context context, final SentryAndroidOptions sentryAndroidOptions, final l0 l0, final w0 w0, final h h, final boolean b, final boolean b2) {
        final io.sentry.util.l i = new io.sentry.util.l((io.sentry.util.l.a<T>)new v(sentryAndroidOptions));
        ((q4)sentryAndroidOptions).addIntegration((Integration)new SendCachedEnvelopeIntegration((x2)new y2((u2)new io.sentry.android.core.w(sentryAndroidOptions)), i));
        Class<?> c;
        if (h(l0)) {
            c = w0.c("io.sentry.android.ndk.SentryNdk", ((q4)sentryAndroidOptions).getLogger());
        }
        else {
            c = null;
        }
        ((q4)sentryAndroidOptions).addIntegration((Integration)new NdkIntegration((Class)c));
        ((q4)sentryAndroidOptions).addIntegration((Integration)EnvelopeFileObserverIntegration.b());
        ((q4)sentryAndroidOptions).addIntegration((Integration)new SendCachedEnvelopeIntegration((x2)new z2((u2)new io.sentry.android.core.x(sentryAndroidOptions)), i));
        ((q4)sentryAndroidOptions).addIntegration((Integration)new AppLifecycleIntegration());
        ((q4)sentryAndroidOptions).addIntegration(e0.a(context, l0));
        if (context instanceof Application) {
            final Application application = (Application)context;
            ((q4)sentryAndroidOptions).addIntegration((Integration)new ActivityLifecycleIntegration(application, l0, h));
            ((q4)sentryAndroidOptions).addIntegration((Integration)new CurrentActivityIntegration(application));
            ((q4)sentryAndroidOptions).addIntegration((Integration)new UserInteractionIntegration(application, w0));
            if (b) {
                ((q4)sentryAndroidOptions).addIntegration((Integration)new FragmentLifecycleIntegration(application, true, true));
            }
        }
        else {
            ((q4)sentryAndroidOptions).getLogger().a(l4.WARNING, "ActivityLifecycle, FragmentLifecycle and UserInteraction Integrations need an Application class to be installed.", new Object[0]);
        }
        if (b2) {
            ((q4)sentryAndroidOptions).addIntegration((Integration)new SentryTimberIntegration());
        }
        ((q4)sentryAndroidOptions).addIntegration((Integration)new AppComponentsBreadcrumbsIntegration(context));
        ((q4)sentryAndroidOptions).addIntegration((Integration)new SystemEventsBreadcrumbsIntegration(context));
        ((q4)sentryAndroidOptions).addIntegration((Integration)new NetworkBreadcrumbsIntegration(context, l0, ((q4)sentryAndroidOptions).getLogger()));
        ((q4)sentryAndroidOptions).addIntegration((Integration)new TempSensorBreadcrumbsIntegration(context));
        ((q4)sentryAndroidOptions).addIntegration((Integration)new PhoneStateBreadcrumbsIntegration(context));
    }
    
    private static boolean h(final l0 l0) {
        return l0.d() >= 16;
    }
    
    static void l(final SentryAndroidOptions sentryAndroidOptions, final Context context, final n0 logger, final l0 l0) {
        io.sentry.util.n.c(context, "The context is required.");
        Context applicationContext = context;
        if (context.getApplicationContext() != null) {
            applicationContext = context.getApplicationContext();
        }
        io.sentry.util.n.c(sentryAndroidOptions, "The options object is required.");
        io.sentry.util.n.c(logger, "The ILogger object is required.");
        ((q4)sentryAndroidOptions).setLogger(logger);
        ((q4)sentryAndroidOptions).setDateProvider((k3)new f1());
        y0.a(applicationContext, sentryAndroidOptions, l0);
        e(applicationContext, sentryAndroidOptions);
        m(sentryAndroidOptions, applicationContext, l0);
    }
    
    private static void m(final SentryAndroidOptions sentryAndroidOptions, final Context context, final l0 l0) {
        final PackageInfo j = m0.j(context, ((q4)sentryAndroidOptions).getLogger(), l0);
        if (j != null) {
            if (((q4)sentryAndroidOptions).getRelease() == null) {
                ((q4)sentryAndroidOptions).setRelease(d(j, m0.l(j, l0)));
            }
            final String packageName = j.packageName;
            if (packageName != null && !packageName.startsWith("android.")) {
                ((q4)sentryAndroidOptions).addInAppInclude(packageName);
            }
        }
        if (((q4)sentryAndroidOptions).getDistinctId() == null) {
            try {
                ((q4)sentryAndroidOptions).setDistinctId(u0.a(context));
            }
            catch (final RuntimeException ex) {
                ((q4)sentryAndroidOptions).getLogger().d(l4.ERROR, "Could not generate distinct Id.", (Throwable)ex);
            }
        }
    }
}
