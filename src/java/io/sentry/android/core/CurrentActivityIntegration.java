package io.sentry.android.core;

import android.os.Bundle;
import io.sentry.q4;
import io.sentry.m0;
import io.sentry.a1;
import io.sentry.z0;
import android.app.Activity;
import io.sentry.util.n;
import android.app.Application;
import android.app.Application$ActivityLifecycleCallbacks;
import java.io.Closeable;
import io.sentry.Integration;

public final class CurrentActivityIntegration implements Integration, Closeable, Application$ActivityLifecycleCallbacks
{
    private final Application e;
    
    public CurrentActivityIntegration(final Application application) {
        this.e = (Application)n.c((Object)application, "Application is required");
    }
    
    private void b(final Activity activity) {
        if (n0.c().b() == activity) {
            n0.c().a();
        }
    }
    
    private void c(final Activity activity) {
        n0.c().d(activity);
    }
    
    public void close() {
        this.e.unregisterActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this);
        n0.c().a();
    }
    
    public void d(final m0 m0, final q4 q4) {
        this.e.registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this);
    }
    
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
        this.c(activity);
    }
    
    public void onActivityDestroyed(final Activity activity) {
        this.b(activity);
    }
    
    public void onActivityPaused(final Activity activity) {
        this.b(activity);
    }
    
    public void onActivityResumed(final Activity activity) {
        this.c(activity);
    }
    
    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityStarted(final Activity activity) {
        this.c(activity);
    }
    
    public void onActivityStopped(final Activity activity) {
        this.b(activity);
    }
}
