package io.sentry.android.core;

import io.sentry.q4;
import java.util.HashMap;
import io.sentry.android.core.internal.util.b;
import io.sentry.n0;
import io.sentry.l4;
import android.util.SparseIntArray;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import android.app.Activity;
import io.sentry.protocol.q;
import java.util.Map;
import androidx.core.app.FrameMetricsAggregator;

public final class h
{
    private FrameMetricsAggregator a;
    private final SentryAndroidOptions b;
    private final Map<q, Map<String, io.sentry.protocol.h>> c;
    private final Map<Activity, b> d;
    private final x0 e;
    
    public h(final w0 w0, final SentryAndroidOptions sentryAndroidOptions) {
        this(w0, sentryAndroidOptions, new x0());
    }
    
    public h(final w0 w0, final SentryAndroidOptions b, final x0 e) {
        this.a = null;
        this.c = (Map<q, Map<String, io.sentry.protocol.h>>)new ConcurrentHashMap();
        this.d = (Map<Activity, b>)new WeakHashMap();
        if (w0.a("androidx.core.app.FrameMetricsAggregator", ((q4)b).getLogger())) {
            this.a = new FrameMetricsAggregator();
        }
        this.b = b;
        this.e = e;
    }
    
    private b f() {
        if (!this.h()) {
            return null;
        }
        final FrameMetricsAggregator a = this.a;
        if (a == null) {
            return null;
        }
        final SparseIntArray[] b = a.b();
        int n = 0;
        int i = 0;
        if (b != null && b.length > 0) {
            final SparseIntArray sparseIntArray = b[0];
            if (sparseIntArray != null) {
                n = 0;
                int n2 = 0;
                int n3 = 0;
                while (i < sparseIntArray.size()) {
                    final int key = sparseIntArray.keyAt(i);
                    final int value = sparseIntArray.valueAt(i);
                    n += value;
                    int n4;
                    int n5;
                    if (key > 700) {
                        n4 = n3 + value;
                        n5 = n2;
                    }
                    else {
                        n5 = n2;
                        n4 = n3;
                        if (key > 16) {
                            n5 = n2 + value;
                            n4 = n3;
                        }
                    }
                    ++i;
                    n2 = n5;
                    n3 = n4;
                }
                return new b(n, n2, n3);
            }
        }
        int n2 = 0;
        int n3 = 0;
        return new b(n, n2, n3);
    }
    
    private b g(final Activity activity) {
        final b b = (b)this.d.remove((Object)activity);
        if (b == null) {
            return null;
        }
        final b f = this.f();
        if (f == null) {
            return null;
        }
        return new b(f.a - b.a, f.b - b.b, f.c - b.c);
    }
    
    private void m(final Runnable runnable, final String s) {
        try {
            if (io.sentry.android.core.internal.util.b.d().c()) {
                runnable.run();
            }
            else {
                this.e.b((Runnable)new g(this, runnable, s));
            }
        }
        finally {
            if (s != null) {
                final n0 logger = ((q4)this.b).getLogger();
                final l4 warning = l4.WARNING;
                final StringBuilder sb = new StringBuilder();
                sb.append("Failed to execute ");
                sb.append(s);
                logger.a(warning, sb.toString(), new Object[0]);
            }
        }
    }
    
    private void o(final Activity activity) {
        final b f = this.f();
        if (f != null) {
            this.d.put((Object)activity, (Object)f);
        }
    }
    
    public void e(final Activity activity) {
        synchronized (this) {
            if (!this.h()) {
                return;
            }
            this.m((Runnable)new d(this, activity), "FrameMetricsAggregator.add");
            this.o(activity);
        }
    }
    
    public boolean h() {
        return this.a != null && this.b.isEnableFramesTracking();
    }
    
    public void n(final Activity activity, final q q) {
        synchronized (this) {
            if (!this.h()) {
                return;
            }
            this.m((Runnable)new e(this, activity), null);
            final b g = this.g(activity);
            if (g != null && (g.a != 0 || g.b != 0 || g.c != 0)) {
                final io.sentry.protocol.h h = new io.sentry.protocol.h((Number)g.a, "none");
                final io.sentry.protocol.h h2 = new io.sentry.protocol.h((Number)g.b, "none");
                final io.sentry.protocol.h h3 = new io.sentry.protocol.h((Number)g.c, "none");
                final HashMap hashMap = new HashMap();
                ((Map)hashMap).put((Object)"frames_total", (Object)h);
                ((Map)hashMap).put((Object)"frames_slow", (Object)h2);
                ((Map)hashMap).put((Object)"frames_frozen", (Object)h3);
                this.c.put((Object)q, (Object)hashMap);
            }
        }
    }
    
    public void p() {
        synchronized (this) {
            if (this.h()) {
                this.m((Runnable)new f(this), "FrameMetricsAggregator.stop");
                this.a.d();
            }
            this.c.clear();
        }
    }
    
    public Map<String, io.sentry.protocol.h> q(final q q) {
        synchronized (this) {
            if (!this.h()) {
                return null;
            }
            final Map map = (Map)this.c.get((Object)q);
            this.c.remove((Object)q);
            return (Map<String, io.sentry.protocol.h>)map;
        }
    }
    
    private static final class b
    {
        private final int a;
        private final int b;
        private final int c;
        
        private b(final int a, final int b, final int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}
