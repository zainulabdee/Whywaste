package io.sentry.android.core;

import androidx.lifecycle.ProcessLifecycleOwner$b;
import io.sentry.n0;
import io.sentry.util.n;
import io.sentry.q4;
import io.sentry.android.core.internal.util.b;
import io.sentry.a1;
import io.sentry.z0;
import io.sentry.l4;
import androidx.lifecycle.j;
import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.m0;
import java.io.Closeable;
import io.sentry.Integration;

public final class AppLifecycleIntegration implements Integration, Closeable
{
    volatile LifecycleWatcher e;
    private SentryAndroidOptions f;
    private final x0 g;
    
    public AppLifecycleIntegration() {
        this(new x0());
    }
    
    AppLifecycleIntegration(final x0 g) {
        this.g = g;
    }
    
    private void g(final m0 m0) {
        final SentryAndroidOptions f = this.f;
        if (f == null) {
            return;
        }
        this.e = new LifecycleWatcher(m0, ((q4)f).getSessionTrackingIntervalMillis(), ((q4)this.f).isEnableAutoSessionTracking(), this.f.isEnableAppLifecycleBreadcrumbs());
        try {
            ProcessLifecycleOwner.o().a().a((j)this.e);
            ((q4)this.f).getLogger().a(l4.DEBUG, "AppLifecycleIntegration installed.", new Object[0]);
            this.f();
        }
        finally {
            this.e = null;
            final Throwable t;
            ((q4)this.f).getLogger().d(l4.ERROR, "AppLifecycleIntegration failed to get Lifecycle and could not be installed.", t);
        }
    }
    
    private void j() {
        final LifecycleWatcher e = this.e;
        if (e != null) {
            ProcessLifecycleOwner.o().a().c((j)e);
            final SentryAndroidOptions f = this.f;
            if (f != null) {
                ((q4)f).getLogger().a(l4.DEBUG, "AppLifecycleIntegration removed.", new Object[0]);
            }
        }
        this.e = null;
    }
    
    public void close() {
        if (this.e == null) {
            return;
        }
        if (b.d().c()) {
            this.j();
        }
        else {
            this.g.b((Runnable)new h0(this));
        }
    }
    
    public void d(final m0 m0, final q4 q4) {
        n.c((Object)m0, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions;
        if (q4 instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions)q4;
        }
        else {
            sentryAndroidOptions = null;
        }
        final SentryAndroidOptions f = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f = f;
        final n0 logger = ((q4)f).getLogger();
        final l4 debug = l4.DEBUG;
        logger.a(debug, "enableSessionTracking enabled: %s", new Object[] { ((q4)this.f).isEnableAutoSessionTracking() });
        ((q4)this.f).getLogger().a(debug, "enableAppLifecycleBreadcrumbs enabled: %s", new Object[] { this.f.isEnableAppLifecycleBreadcrumbs() });
        if (!((q4)this.f).isEnableAutoSessionTracking()) {
            if (!this.f.isEnableAppLifecycleBreadcrumbs()) {
                return;
            }
        }
        try {
            final ProcessLifecycleOwner$b i = ProcessLifecycleOwner.m;
            if (b.d().c()) {
                this.g(m0);
            }
            else {
                this.g.b((Runnable)new i0(this, m0));
            }
        }
        catch (final IllegalStateException ex) {
            q4.getLogger().d(l4.ERROR, "AppLifecycleIntegration could not be installed", (Throwable)ex);
        }
        catch (final ClassNotFoundException ex2) {
            q4.getLogger().d(l4.INFO, "androidx.lifecycle is not available, AppLifecycleIntegration won't be installed", (Throwable)ex2);
        }
    }
    
    public /* synthetic */ void f() {
        z0.a((a1)this);
    }
}
