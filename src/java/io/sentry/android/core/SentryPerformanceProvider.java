package io.sentry.android.core;

import android.content.ContentProvider;
import android.os.Bundle;
import android.app.Activity;
import android.net.Uri;
import android.content.pm.ProviderInfo;
import android.content.Context;
import android.os.SystemClock;
import android.app.Application;
import io.sentry.j3;
import android.app.Application$ActivityLifecycleCallbacks;

public final class SentryPerformanceProvider extends r0 implements Application$ActivityLifecycleCallbacks
{
    private static j3 i;
    private static long j;
    private boolean f;
    private boolean g;
    private Application h;
    
    static {
        SentryPerformanceProvider.i = s.a();
        SentryPerformanceProvider.j = SystemClock.uptimeMillis();
    }
    
    public SentryPerformanceProvider() {
        this.f = false;
        this.g = false;
        j0.e().i(SentryPerformanceProvider.j, SentryPerformanceProvider.i);
    }
    
    public void attachInfo(final Context context, final ProviderInfo providerInfo) {
        if (!SentryPerformanceProvider.class.getName().equals((Object)providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            return;
        }
        throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
    }
    
    public String getType(final Uri uri) {
        return null;
    }
    
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
        if (!this.f) {
            j0.e().j(bundle == null);
            this.f = true;
        }
    }
    
    public void onActivityDestroyed(final Activity activity) {
    }
    
    public void onActivityPaused(final Activity activity) {
    }
    
    public void onActivityResumed(final Activity activity) {
        if (!this.g) {
            this.g = true;
            j0.e().g();
        }
        final Application h = this.h;
        if (h != null) {
            h.unregisterActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this);
        }
    }
    
    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityStarted(final Activity activity) {
    }
    
    public void onActivityStopped(final Activity activity) {
    }
    
    public boolean onCreate() {
        final Context context = ((ContentProvider)this).getContext();
        if (context == null) {
            return false;
        }
        Context applicationContext = context;
        if (context.getApplicationContext() != null) {
            applicationContext = context.getApplicationContext();
        }
        if (applicationContext instanceof Application) {
            (this.h = (Application)applicationContext).registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this);
        }
        return true;
    }
}
