package io.sentry.android.core;

import android.os.BaseBundle;
import io.sentry.q4;
import java.util.Arrays;
import java.util.Iterator;
import io.sentry.n0;
import android.os.Bundle;
import io.sentry.j4;
import io.sentry.protocol.o;
import java.util.List;
import java.util.Collections;
import io.sentry.l4;
import java.util.Locale;
import io.sentry.util.n;
import android.content.Context;

final class y0
{
    static void a(final Context context, final SentryAndroidOptions sentryAndroidOptions, final l0 l0) {
        n.c(context, "The application context is required.");
        n.c(sentryAndroidOptions, "The options object is required.");
        try {
            final Bundle b = b(context, ((q4)sentryAndroidOptions).getLogger(), l0);
            final n0 logger = ((q4)sentryAndroidOptions).getLogger();
            if (b != null) {
                ((q4)sentryAndroidOptions).setDebug(c(b, logger, "io.sentry.debug", ((q4)sentryAndroidOptions).isDebug()));
                if (((q4)sentryAndroidOptions).isDebug()) {
                    final String name = ((Enum)((q4)sentryAndroidOptions).getDiagnosticLevel()).name();
                    final Locale root = Locale.ROOT;
                    final String h = h(b, logger, "io.sentry.debug.level", name.toLowerCase(root));
                    if (h != null) {
                        ((q4)sentryAndroidOptions).setDiagnosticLevel(l4.valueOf(h.toUpperCase(root)));
                    }
                }
                sentryAndroidOptions.setAnrEnabled(c(b, logger, "io.sentry.anr.enable", sentryAndroidOptions.isAnrEnabled()));
                ((q4)sentryAndroidOptions).setEnableAutoSessionTracking(c(b, logger, "io.sentry.auto-session-tracking.enable", c(b, logger, "io.sentry.session-tracking.enable", ((q4)sentryAndroidOptions).isEnableAutoSessionTracking())));
                if (((q4)sentryAndroidOptions).getSampleRate() == null) {
                    final Double e = e(b, logger, "io.sentry.sample-rate");
                    if (e != -1.0) {
                        ((q4)sentryAndroidOptions).setSampleRate(e);
                    }
                }
                sentryAndroidOptions.setAnrReportInDebug(c(b, logger, "io.sentry.anr.report-debug", sentryAndroidOptions.isAnrReportInDebug()));
                sentryAndroidOptions.setAnrTimeoutIntervalMillis(g(b, logger, "io.sentry.anr.timeout-interval-millis", sentryAndroidOptions.getAnrTimeoutIntervalMillis()));
                final String h2 = h(b, logger, "io.sentry.dsn", ((q4)sentryAndroidOptions).getDsn());
                if (h2 == null) {
                    ((q4)sentryAndroidOptions).getLogger().a(l4.FATAL, "DSN is required. Use empty string to disable SDK.", new Object[0]);
                }
                else if (h2.isEmpty()) {
                    ((q4)sentryAndroidOptions).getLogger().a(l4.DEBUG, "DSN is empty, disabling sentry-android", new Object[0]);
                }
                ((q4)sentryAndroidOptions).setDsn(h2);
                ((q4)sentryAndroidOptions).setEnableNdk(c(b, logger, "io.sentry.ndk.enable", ((q4)sentryAndroidOptions).isEnableNdk()));
                ((q4)sentryAndroidOptions).setEnableScopeSync(c(b, logger, "io.sentry.ndk.scope-sync.enable", ((q4)sentryAndroidOptions).isEnableScopeSync()));
                ((q4)sentryAndroidOptions).setRelease(h(b, logger, "io.sentry.release", ((q4)sentryAndroidOptions).getRelease()));
                ((q4)sentryAndroidOptions).setEnvironment(h(b, logger, "io.sentry.environment", ((q4)sentryAndroidOptions).getEnvironment()));
                ((q4)sentryAndroidOptions).setSessionTrackingIntervalMillis(g(b, logger, "io.sentry.session-tracking.timeout-interval-millis", ((q4)sentryAndroidOptions).getSessionTrackingIntervalMillis()));
                sentryAndroidOptions.setEnableActivityLifecycleBreadcrumbs(c(b, logger, "io.sentry.breadcrumbs.activity-lifecycle", sentryAndroidOptions.isEnableActivityLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableAppLifecycleBreadcrumbs(c(b, logger, "io.sentry.breadcrumbs.app-lifecycle", sentryAndroidOptions.isEnableAppLifecycleBreadcrumbs()));
                sentryAndroidOptions.setEnableSystemEventBreadcrumbs(c(b, logger, "io.sentry.breadcrumbs.system-events", sentryAndroidOptions.isEnableSystemEventBreadcrumbs()));
                sentryAndroidOptions.setEnableAppComponentBreadcrumbs(c(b, logger, "io.sentry.breadcrumbs.app-components", sentryAndroidOptions.isEnableAppComponentBreadcrumbs()));
                ((q4)sentryAndroidOptions).setEnableUserInteractionBreadcrumbs(c(b, logger, "io.sentry.breadcrumbs.user-interaction", ((q4)sentryAndroidOptions).isEnableUserInteractionBreadcrumbs()));
                sentryAndroidOptions.setEnableNetworkEventBreadcrumbs(c(b, logger, "io.sentry.breadcrumbs.network-events", sentryAndroidOptions.isEnableNetworkEventBreadcrumbs()));
                ((q4)sentryAndroidOptions).setEnableUncaughtExceptionHandler(c(b, logger, "io.sentry.uncaught-exception-handler.enable", ((q4)sentryAndroidOptions).isEnableUncaughtExceptionHandler()));
                ((q4)sentryAndroidOptions).setAttachThreads(c(b, logger, "io.sentry.attach-threads", ((q4)sentryAndroidOptions).isAttachThreads()));
                sentryAndroidOptions.setAttachScreenshot(c(b, logger, "io.sentry.attach-screenshot", sentryAndroidOptions.isAttachScreenshot()));
                sentryAndroidOptions.setAttachViewHierarchy(c(b, logger, "io.sentry.attach-view-hierarchy", sentryAndroidOptions.isAttachViewHierarchy()));
                ((q4)sentryAndroidOptions).setSendClientReports(c(b, logger, "io.sentry.send-client-reports", ((q4)sentryAndroidOptions).isSendClientReports()));
                sentryAndroidOptions.setCollectAdditionalContext(c(b, logger, "io.sentry.additional-context", sentryAndroidOptions.isCollectAdditionalContext()));
                if (((q4)sentryAndroidOptions).getEnableTracing() == null) {
                    ((q4)sentryAndroidOptions).setEnableTracing(d(b, logger, "io.sentry.traces.enable", null));
                }
                if (((q4)sentryAndroidOptions).getTracesSampleRate() == null) {
                    final Double e2 = e(b, logger, "io.sentry.traces.sample-rate");
                    if (e2 != -1.0) {
                        ((q4)sentryAndroidOptions).setTracesSampleRate(e2);
                    }
                }
                ((q4)sentryAndroidOptions).setTraceSampling(c(b, logger, "io.sentry.traces.trace-sampling", ((q4)sentryAndroidOptions).isTraceSampling()));
                sentryAndroidOptions.setEnableAutoActivityLifecycleTracing(c(b, logger, "io.sentry.traces.activity.enable", sentryAndroidOptions.isEnableAutoActivityLifecycleTracing()));
                sentryAndroidOptions.setEnableActivityLifecycleTracingAutoFinish(c(b, logger, "io.sentry.traces.activity.auto-finish.enable", sentryAndroidOptions.isEnableActivityLifecycleTracingAutoFinish()));
                ((q4)sentryAndroidOptions).setProfilingEnabled(c(b, logger, "io.sentry.traces.profiling.enable", ((q4)sentryAndroidOptions).isProfilingEnabled()));
                if (((q4)sentryAndroidOptions).getProfilesSampleRate() == null) {
                    final Double e3 = e(b, logger, "io.sentry.traces.profiling.sample-rate");
                    if (e3 != -1.0) {
                        ((q4)sentryAndroidOptions).setProfilesSampleRate(e3);
                    }
                }
                ((q4)sentryAndroidOptions).setEnableUserInteractionTracing(c(b, logger, "io.sentry.traces.user-interaction.enable", ((q4)sentryAndroidOptions).isEnableUserInteractionTracing()));
                ((q4)sentryAndroidOptions).setEnableTimeToFullDisplayTracing(c(b, logger, "io.sentry.traces.time-to-full-display.enable", ((q4)sentryAndroidOptions).isEnableTimeToFullDisplayTracing()));
                final long g = g(b, logger, "io.sentry.traces.idle-timeout", -1L);
                if (g != -1L) {
                    ((q4)sentryAndroidOptions).setIdleTimeout(Long.valueOf(g));
                }
                final List<String> f = f(b, logger, "io.sentry.traces.trace-propagation-targets");
                final boolean containsKey = ((BaseBundle)b).containsKey("io.sentry.traces.trace-propagation-targets");
                List<String> f2 = f;
                Label_0859: {
                    if (!containsKey) {
                        if (f != null) {
                            f2 = f;
                            if (!f.isEmpty()) {
                                break Label_0859;
                            }
                        }
                        f2 = f(b, logger, "io.sentry.traces.tracing-origins");
                    }
                }
                if ((((BaseBundle)b).containsKey("io.sentry.traces.trace-propagation-targets") || ((BaseBundle)b).containsKey("io.sentry.traces.tracing-origins")) && f2 == null) {
                    ((q4)sentryAndroidOptions).setTracePropagationTargets((List<String>)Collections.emptyList());
                }
                else if (f2 != null) {
                    ((q4)sentryAndroidOptions).setTracePropagationTargets(f2);
                }
                sentryAndroidOptions.setEnableFramesTracking(c(b, logger, "io.sentry.traces.frames-tracking", true));
                ((q4)sentryAndroidOptions).setProguardUuid(h(b, logger, "io.sentry.proguard-uuid", ((q4)sentryAndroidOptions).getProguardUuid()));
                o sdkVersion;
                if ((sdkVersion = ((q4)sentryAndroidOptions).getSdkVersion()) == null) {
                    sdkVersion = new o("", "");
                }
                sdkVersion.i(i(b, logger, "io.sentry.sdk.name", sdkVersion.f()));
                sdkVersion.k(i(b, logger, "io.sentry.sdk.version", sdkVersion.h()));
                ((q4)sentryAndroidOptions).setSdkVersion(sdkVersion);
                ((q4)sentryAndroidOptions).setSendDefaultPii(c(b, logger, "io.sentry.send-default-pii", ((q4)sentryAndroidOptions).isSendDefaultPii()));
                final List<String> f3 = f(b, logger, "io.sentry.gradle-plugin-integrations");
                if (f3 != null) {
                    final Iterator iterator = f3.iterator();
                    while (iterator.hasNext()) {
                        j4.c().a((String)iterator.next());
                    }
                }
                sentryAndroidOptions.setEnableRootCheck(c(b, logger, "io.sentry.enable-root-check", sentryAndroidOptions.isEnableRootCheck()));
            }
            ((q4)sentryAndroidOptions).getLogger().a(l4.INFO, "Retrieving configuration from AndroidManifest.xml", new Object[0]);
        }
        finally {
            final Throwable t;
            ((q4)sentryAndroidOptions).getLogger().d(l4.ERROR, "Failed to read configuration from android manifest metadata.", t);
        }
    }
    
    private static Bundle b(final Context context, final n0 n0, l0 l0) {
        if (l0 == null) {
            l0 = new l0(n0);
        }
        return m0.a(context, 128L, l0).metaData;
    }
    
    private static boolean c(final Bundle bundle, final n0 n0, final String s, final boolean b) {
        final boolean boolean1 = bundle.getBoolean(s, b);
        n0.a(l4.DEBUG, "%s read: %s", s, boolean1);
        return boolean1;
    }
    
    private static Boolean d(final Bundle bundle, final n0 n0, final String s, final Boolean b) {
        if (bundle.getSerializable(s) != null) {
            final boolean boolean1 = bundle.getBoolean(s, b != null);
            n0.a(l4.DEBUG, "%s read: %s", s, boolean1);
            return boolean1;
        }
        n0.a(l4.DEBUG, "%s used default %s", s, b);
        return b;
    }
    
    private static Double e(final Bundle bundle, final n0 n0, final String s) {
        final Double value = (Double)bundle.getFloat(s, -1.0f);
        n0.a(l4.DEBUG, "%s read: %s", s, value);
        return value;
    }
    
    private static List<String> f(final Bundle bundle, final n0 n0, final String s) {
        final String string = ((BaseBundle)bundle).getString(s);
        n0.a(l4.DEBUG, "%s read: %s", s, string);
        if (string != null) {
            return (List<String>)Arrays.asList((Object[])string.split(",", -1));
        }
        return null;
    }
    
    private static long g(final Bundle bundle, final n0 n0, final String s, long n2) {
        n2 = ((BaseBundle)bundle).getInt(s, (int)n2);
        n0.a(l4.DEBUG, "%s read: %s", s, n2);
        return n2;
    }
    
    private static String h(final Bundle bundle, final n0 n0, final String s, final String s2) {
        final String string = ((BaseBundle)bundle).getString(s, s2);
        n0.a(l4.DEBUG, "%s read: %s", s, string);
        return string;
    }
    
    private static String i(final Bundle bundle, final n0 n0, final String s, final String s2) {
        final String string = ((BaseBundle)bundle).getString(s, s2);
        n0.a(l4.DEBUG, "%s read: %s", s, string);
        return string;
    }
}
