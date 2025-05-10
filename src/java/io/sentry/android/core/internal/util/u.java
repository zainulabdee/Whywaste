package io.sentry.android.core.internal.util;

import java.lang.ref.Reference;
import java.lang.reflect.AccessibleObject;
import android.os.Bundle;
import android.app.Activity;
import java.util.UUID;
import java.util.Iterator;
import android.view.FrameMetrics;
import io.sentry.l4;
import android.os.Looper;
import android.os.HandlerThread;
import android.app.Application;
import io.sentry.util.n;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import android.content.Context;
import java.lang.reflect.Field;
import android.view.Choreographer;
import android.view.Window$OnFrameMetricsAvailableListener;
import java.util.Map;
import java.lang.ref.WeakReference;
import android.os.Handler;
import io.sentry.q4;
import android.view.Window;
import java.util.Set;
import io.sentry.android.core.l0;
import android.app.Application$ActivityLifecycleCallbacks;

public final class u implements Application$ActivityLifecycleCallbacks
{
    private final l0 e;
    private final Set<Window> f;
    private final q4 g;
    private Handler h;
    private WeakReference<Window> i;
    private final Map<String, b> j;
    private boolean k;
    private final c l;
    private Window$OnFrameMetricsAvailableListener m;
    private Choreographer n;
    private Field o;
    private long p;
    private long q;
    
    public u(final Context context, final q4 q4, final l0 l0) {
        this(context, q4, l0, (c)new u$a());
    }
    
    public u(final Context context, final q4 q4, final l0 l0, final c c) {
        this.f = (Set<Window>)new CopyOnWriteArraySet();
        this.j = (Map<String, b>)new ConcurrentHashMap();
        this.k = false;
        this.p = 0L;
        this.q = 0L;
        io.sentry.util.n.c(context, "The context is required");
        this.g = io.sentry.util.n.c(q4, "SentryOptions is required");
        this.e = io.sentry.util.n.c(l0, "BuildInfoProvider is required");
        this.l = io.sentry.util.n.c(c, "WindowFrameMetricsManager is required");
        if (!(context instanceof Application)) {
            return;
        }
        if (l0.d() < 24) {
            return;
        }
        this.k = true;
        final HandlerThread handlerThread = new HandlerThread("io.sentry.android.core.internal.util.SentryFrameMetricsCollector");
        ((Thread)handlerThread).setUncaughtExceptionHandler((Thread$UncaughtExceptionHandler)new r(q4));
        ((Thread)handlerThread).start();
        this.h = new Handler(handlerThread.getLooper());
        ((Application)context).registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this);
        new Handler(Looper.getMainLooper()).post((Runnable)new s(this));
        try {
            ((AccessibleObject)(this.o = Choreographer.class.getDeclaredField("mLastFrameTimeNanos"))).setAccessible(true);
        }
        catch (final NoSuchFieldException ex) {
            q4.getLogger().d(l4.ERROR, "Unable to get the frame timestamp from the choreographer: ", (Throwable)ex);
        }
        this.m = (Window$OnFrameMetricsAvailableListener)new t(this, l0);
    }
    
    private long d(final FrameMetrics frameMetrics) {
        return frameMetrics.getMetric(0) + frameMetrics.getMetric(1) + frameMetrics.getMetric(2) + frameMetrics.getMetric(3) + frameMetrics.getMetric(4) + frameMetrics.getMetric(5);
    }
    
    private long e(final FrameMetrics frameMetrics) {
        if (this.e.d() >= 26) {
            return frameMetrics.getMetric(10);
        }
        final Choreographer n = this.n;
        if (n == null) {
            return -1L;
        }
        final Field o = this.o;
        if (o == null) {
            return -1L;
        }
        try {
            final Long n2 = (Long)o.get((Object)n);
            if (n2 != null) {
                return n2;
            }
            return -1L;
        }
        catch (final IllegalAccessException ex) {
            return -1L;
        }
    }
    
    private void i(final Window window) {
        final WeakReference<Window> i = this.i;
        if (i != null && ((Reference)i).get() == window) {
            return;
        }
        this.i = (WeakReference<Window>)new WeakReference((Object)window);
        this.m();
    }
    
    private void l(final Window window) {
        if (this.f.contains((Object)window)) {
            if (this.e.d() >= 24) {
                try {
                    this.l.a(window, this.m);
                }
                catch (final Exception ex) {
                    this.g.getLogger().d(l4.ERROR, "Failed to remove frameMetricsAvailableListener", (Throwable)ex);
                }
            }
            this.f.remove((Object)window);
        }
    }
    
    private void m() {
        final WeakReference<Window> i = this.i;
        Window window;
        if (i != null) {
            window = (Window)((Reference)i).get();
        }
        else {
            window = null;
        }
        if (window != null) {
            if (this.k) {
                if (!this.f.contains((Object)window) && !this.j.isEmpty() && this.e.d() >= 24 && this.h != null) {
                    this.f.add((Object)window);
                    this.l.b(window, this.m, this.h);
                }
            }
        }
    }
    
    public String j(final b b) {
        if (!this.k) {
            return null;
        }
        final String string = UUID.randomUUID().toString();
        this.j.put((Object)string, (Object)b);
        this.m();
        return string;
    }
    
    public void k(final String s) {
        if (!this.k) {
            return;
        }
        if (s != null) {
            this.j.remove((Object)s);
        }
        final WeakReference<Window> i = this.i;
        Window window;
        if (i != null) {
            window = (Window)((Reference)i).get();
        }
        else {
            window = null;
        }
        if (window != null && this.j.isEmpty()) {
            this.l(window);
        }
    }
    
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityDestroyed(final Activity activity) {
    }
    
    public void onActivityPaused(final Activity activity) {
    }
    
    public void onActivityResumed(final Activity activity) {
    }
    
    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
    }
    
    public void onActivityStarted(final Activity activity) {
        this.i(activity.getWindow());
    }
    
    public void onActivityStopped(final Activity activity) {
        this.l(activity.getWindow());
        final WeakReference<Window> i = this.i;
        if (i != null && ((Reference)i).get() == activity.getWindow()) {
            this.i = null;
        }
    }
    
    public interface b
    {
        void a(final long p0, final long p1, final float p2);
    }
    
    public interface c
    {
        void a(final Window p0, final Window$OnFrameMetricsAvailableListener p1);
        
        void b(final Window p0, final Window$OnFrameMetricsAvailableListener p1, final Handler p2);
    }
}
