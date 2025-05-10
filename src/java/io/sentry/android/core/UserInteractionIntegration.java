package io.sentry.android.core;

import android.os.Bundle;
import io.sentry.n0;
import io.sentry.a1;
import io.sentry.z0;
import android.view.Window;
import android.content.Context;
import android.view.Window$Callback;
import io.sentry.android.core.internal.gestures.h;
import io.sentry.android.core.internal.gestures.g;
import io.sentry.android.core.internal.gestures.b;
import io.sentry.l4;
import android.app.Activity;
import io.sentry.q4;
import io.sentry.util.n;
import io.sentry.m0;
import android.app.Application;
import android.app.Application$ActivityLifecycleCallbacks;
import java.io.Closeable;
import io.sentry.Integration;

public final class UserInteractionIntegration implements Integration, Closeable, Application$ActivityLifecycleCallbacks
{
    private final Application e;
    private m0 f;
    private SentryAndroidOptions g;
    private final boolean h;
    
    public UserInteractionIntegration(final Application application, final w0 w0) {
        this.e = (Application)n.c((Object)application, "Application is required");
        this.h = w0.b("androidx.core.view.GestureDetectorCompat", (q4)this.g);
    }
    
    private void c(final Activity activity) {
        final Window window = activity.getWindow();
        if (window == null) {
            final SentryAndroidOptions g = this.g;
            if (g != null) {
                ((q4)g).getLogger().a(l4.INFO, "Window was null in startTracking", new Object[0]);
            }
            return;
        }
        if (this.f != null && this.g != null) {
            Object callback;
            if ((callback = window.getCallback()) == null) {
                callback = new b();
            }
            window.setCallback((Window$Callback)new h((Window$Callback)callback, (Context)activity, new g(activity, this.f, this.g), (q4)this.g));
        }
    }
    
    private void f(final Activity activity) {
        final Window window = activity.getWindow();
        if (window == null) {
            final SentryAndroidOptions g = this.g;
            if (g != null) {
                ((q4)g).getLogger().a(l4.INFO, "Window was null in stopTracking", new Object[0]);
            }
            return;
        }
        final Window$Callback callback = window.getCallback();
        if (callback instanceof h) {
            final h h = (h)callback;
            h.c();
            if (h.a() instanceof b) {
                window.setCallback((Window$Callback)null);
            }
            else {
                window.setCallback(h.a());
            }
        }
    }
    
    public /* synthetic */ void b() {
        z0.a((a1)this);
    }
    
    public void close() {
        this.e.unregisterActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this);
        final SentryAndroidOptions g = this.g;
        if (g != null) {
            ((q4)g).getLogger().a(l4.DEBUG, "UserInteractionIntegration removed.", new Object[0]);
        }
    }
    
    public void d(final m0 m0, final q4 q4) {
        SentryAndroidOptions sentryAndroidOptions;
        if (q4 instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions)q4;
        }
        else {
            sentryAndroidOptions = null;
        }
        this.g = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f = (m0)n.c((Object)m0, "Hub is required");
        final boolean b = ((q4)this.g).isEnableUserInteractionBreadcrumbs() || ((q4)this.g).isEnableUserInteractionTracing();
        final n0 logger = ((q4)this.g).getLogger();
        final l4 debug = l4.DEBUG;
        logger.a(debug, "UserInteractionIntegration enabled: %s", new Object[] { b });
        if (b) {
            if (this.h) {
                this.e.registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this);
                ((q4)this.g).getLogger().a(debug, "UserInteractionIntegration installed.", new Object[0]);
                this.b();
            }
            else {
                q4.getLogger().a(l4.INFO, "androidx.core is not available, UserInteractionIntegration won't be installed", new Object[0]);
            }
        }
    }
    
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityDestroyed(final Activity activity) {
    }
    
    public void onActivityPaused(final Activity activity) {
        this.f(activity);
    }
    
    public void onActivityResumed(final Activity activity) {
        this.c(activity);
    }
    
    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityStarted(final Activity activity) {
    }
    
    public void onActivityStopped(final Activity activity) {
    }
}
