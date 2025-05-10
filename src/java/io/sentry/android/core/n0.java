package io.sentry.android.core;

import java.lang.ref.Reference;
import android.app.Activity;
import java.lang.ref.WeakReference;

public class n0
{
    private static final n0 b;
    private WeakReference<Activity> a;
    
    static {
        b = new n0();
    }
    
    private n0() {
    }
    
    public static n0 c() {
        return n0.b;
    }
    
    public void a() {
        this.a = null;
    }
    
    public Activity b() {
        final WeakReference<Activity> a = this.a;
        if (a != null) {
            return (Activity)((Reference)a).get();
        }
        return null;
    }
    
    public void d(final Activity activity) {
        final WeakReference<Activity> a = this.a;
        if (a != null && ((Reference)a).get() == activity) {
            return;
        }
        this.a = (WeakReference<Activity>)new WeakReference((Object)activity);
    }
}
