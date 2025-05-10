package io.sentry.android.core;

import io.sentry.protocol.e$b;
import io.sentry.a0;
import java.util.Locale;
import io.sentry.android.core.internal.util.j;
import android.content.res.Configuration;
import io.sentry.n0;
import io.sentry.q4;
import android.content.ComponentCallbacks;
import io.sentry.a1;
import io.sentry.z0;
import io.sentry.l4;
import io.sentry.e;
import io.sentry.util.n;
import io.sentry.m0;
import android.content.Context;
import android.content.ComponentCallbacks2;
import java.io.Closeable;
import io.sentry.Integration;

public final class AppComponentsBreadcrumbsIntegration implements Integration, Closeable, ComponentCallbacks2
{
    private final Context e;
    private m0 f;
    private SentryAndroidOptions g;
    
    public AppComponentsBreadcrumbsIntegration(final Context context) {
        this.e = (Context)n.c((Object)context, "Context is required");
    }
    
    private void c(final Integer n) {
        if (this.f != null) {
            final e e = new e();
            if (n != null) {
                if (n < 40) {
                    return;
                }
                e.n("level", (Object)n);
            }
            e.q("system");
            e.m("device.event");
            e.p("Low memory");
            e.n("action", (Object)"LOW_MEMORY");
            e.o(l4.WARNING);
            this.f.f(e);
        }
    }
    
    public /* synthetic */ void b() {
        z0.a((a1)this);
    }
    
    public void close() {
        try {
            this.e.unregisterComponentCallbacks((ComponentCallbacks)this);
        }
        finally {
            final SentryAndroidOptions g = this.g;
            if (g != null) {
                final Throwable t;
                ((q4)g).getLogger().c(l4.DEBUG, t, "It was not possible to unregisterComponentCallbacks", new Object[0]);
            }
        }
        final SentryAndroidOptions g2 = this.g;
        if (g2 != null) {
            ((q4)g2).getLogger().a(l4.DEBUG, "AppComponentsBreadcrumbsIntegration removed.", new Object[0]);
        }
    }
    
    public void d(final m0 m0, final q4 q4) {
        this.f = (m0)n.c((Object)m0, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions;
        if (q4 instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions)q4;
        }
        else {
            sentryAndroidOptions = null;
        }
        final SentryAndroidOptions g = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.g = g;
        final n0 logger = ((q4)g).getLogger();
        final l4 debug = l4.DEBUG;
        logger.a(debug, "AppComponentsBreadcrumbsIntegration enabled: %s", new Object[] { this.g.isEnableAppComponentBreadcrumbs() });
        if (this.g.isEnableAppComponentBreadcrumbs()) {
            try {
                this.e.registerComponentCallbacks((ComponentCallbacks)this);
                q4.getLogger().a(debug, "AppComponentsBreadcrumbsIntegration installed.", new Object[0]);
                this.b();
            }
            finally {
                this.g.setEnableAppComponentBreadcrumbs(false);
                final Throwable t;
                q4.getLogger().c(l4.INFO, t, "ComponentCallbacks2 is not available.", new Object[0]);
            }
        }
    }
    
    public void onConfigurationChanged(final Configuration configuration) {
        if (this.f != null) {
            final e$b a = j.a(this.e.getResources().getConfiguration().orientation);
            String lowerCase;
            if (a != null) {
                lowerCase = ((Enum)a).name().toLowerCase(Locale.ROOT);
            }
            else {
                lowerCase = "undefined";
            }
            final e e = new e();
            e.q("navigation");
            e.m("device.orientation");
            e.n("position", (Object)lowerCase);
            e.o(l4.INFO);
            final a0 a2 = new a0();
            a2.j("android:configuration", (Object)configuration);
            this.f.k(e, a2);
        }
    }
    
    public void onLowMemory() {
        this.c(null);
    }
    
    public void onTrimMemory(final int n) {
        this.c(n);
    }
}
