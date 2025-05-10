package io.sentry.android.core;

import io.sentry.u0;
import io.sentry.r1;
import io.sentry.g;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.Collection;
import android.os.Build;
import java.util.ArrayList;
import android.os.Debug;
import android.os.Process;
import java.util.concurrent.RejectedExecutionException;
import android.os.SystemClock;
import io.sentry.android.core.internal.util.u$b;
import java.util.UUID;
import io.sentry.android.core.internal.util.h;
import io.sentry.i2;
import java.util.concurrent.TimeUnit;
import io.sentry.l4;
import android.app.ActivityManager;
import android.app.ActivityManager$MemoryInfo;
import java.util.List;
import io.sentry.util.n;
import java.util.HashMap;
import io.sentry.h0;
import io.sentry.v0;
import io.sentry.profilemeasurements.a;
import java.util.Map;
import io.sentry.profilemeasurements.b;
import java.util.ArrayDeque;
import io.sentry.m2;
import io.sentry.android.core.internal.util.u;
import io.sentry.m0;
import android.content.Context;
import io.sentry.l2;
import java.util.concurrent.Future;
import java.io.File;
import io.sentry.w0;

final class b0 implements w0
{
    private int a;
    private File b;
    private File c;
    private Future<?> d;
    private volatile l2 e;
    private final Context f;
    private final SentryAndroidOptions g;
    private final m0 h;
    private final l0 i;
    private long j;
    private long k;
    private boolean l;
    private int m;
    private String n;
    private final u o;
    private m2 p;
    private final ArrayDeque<b> q;
    private final ArrayDeque<b> r;
    private final ArrayDeque<b> s;
    private final Map<String, a> t;
    private v0 u;
    
    public b0(final Context context, final SentryAndroidOptions sentryAndroidOptions, final l0 l0, final u u) {
        this(context, sentryAndroidOptions, l0, u, (m0)h0.u());
    }
    
    public b0(final Context context, final SentryAndroidOptions sentryAndroidOptions, final l0 l0, final u u, final m0 m0) {
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.j = 0L;
        this.k = 0L;
        this.l = false;
        this.m = 0;
        this.q = (ArrayDeque<b>)new ArrayDeque();
        this.r = (ArrayDeque<b>)new ArrayDeque();
        this.s = (ArrayDeque<b>)new ArrayDeque();
        this.t = (Map<String, a>)new HashMap();
        this.u = null;
        this.f = (Context)io.sentry.util.n.c((Object)context, "The application context is required");
        this.g = (SentryAndroidOptions)io.sentry.util.n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.h = (m0)io.sentry.util.n.c((Object)m0, "Hub is required");
        this.o = (u)io.sentry.util.n.c((Object)u, "SentryFrameMetricsCollector is required");
        this.i = (l0)io.sentry.util.n.c((Object)l0, "The BuildInfoProvider is required.");
    }
    
    private ActivityManager$MemoryInfo i() {
        try {
            final ActivityManager activityManager = (ActivityManager)this.f.getSystemService("activity");
            final ActivityManager$MemoryInfo activityManager$MemoryInfo = new ActivityManager$MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(activityManager$MemoryInfo);
                return activityManager$MemoryInfo;
            }
            this.g.getLogger().a(l4.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        }
        finally {
            final Throwable t;
            this.g.getLogger().d(l4.ERROR, "Error getting MemoryInfo.", t);
            return null;
        }
    }
    
    private void j() {
        if (this.l) {
            return;
        }
        this.l = true;
        final String profilingTracesDirPath = this.g.getProfilingTracesDirPath();
        if (!this.g.isProfilingEnabled()) {
            this.g.getLogger().a(l4.INFO, "Profiling is disabled in options.", new Object[0]);
            return;
        }
        if (profilingTracesDirPath == null) {
            this.g.getLogger().a(l4.WARNING, "Disabling profiling because no profiling traces dir path is defined in options.", new Object[0]);
            return;
        }
        final int profilingTracesHz = this.g.getProfilingTracesHz();
        if (profilingTracesHz <= 0) {
            this.g.getLogger().a(l4.WARNING, "Disabling profiling because trace rate is set to %d", new Object[] { profilingTracesHz });
            return;
        }
        this.a = (int)TimeUnit.SECONDS.toMicros(1L) / profilingTracesHz;
        this.c = new File(profilingTracesDirPath);
    }
    
    private boolean m(final v0 u) {
        final File c = this.c;
        final StringBuilder sb = new StringBuilder();
        sb.append((Object)UUID.randomUUID());
        sb.append(".trace");
        this.b = new File(c, sb.toString());
        this.t.clear();
        this.q.clear();
        this.r.clear();
        this.s.clear();
        this.n = this.o.j((u$b)new u$b(this) {
            final long a = TimeUnit.SECONDS.toNanos(1L);
            final long b = TimeUnit.MILLISECONDS.toNanos(700L);
            float c = 0.0f;
            final b0 d;
            
            public void a(long n, final long n2, float c) {
                n = n - System.nanoTime() + SystemClock.elapsedRealtimeNanos() - this.d.j;
                if (n < 0L) {
                    return;
                }
                final boolean b = n2 > this.a / (c - 1.0f);
                c = (int)(c * 100.0f) / 100.0f;
                if (n2 > this.b) {
                    this.d.s.addLast((Object)new b(n, (Number)n2));
                }
                else if (b) {
                    this.d.r.addLast((Object)new b(n, (Number)n2));
                }
                if (c != this.c) {
                    this.c = c;
                    this.d.q.addLast((Object)new b(n, (Number)c));
                }
            }
        });
        this.u = u;
        try {
            this.d = (Future<?>)this.g.getExecutorService().b((Runnable)new a0(this, u), 30000L);
        }
        catch (final RejectedExecutionException ex) {
            this.g.getLogger().d(l4.ERROR, "Failed to call the executor. Profiling will not be automatically finished. Did you call Sentry.close()?", (Throwable)ex);
        }
        this.j = SystemClock.elapsedRealtimeNanos();
        this.k = Process.getElapsedCpuTime();
        this.p = new m2(u, this.j, this.k);
        try {
            Debug.startMethodTracingSampling(this.b.getPath(), 3000000, this.a);
            return true;
        }
        finally {
            this.a(u, null);
            final Throwable t;
            this.g.getLogger().d(l4.ERROR, "Unable to start a profile: ", t);
            return false;
        }
    }
    
    private l2 n(final v0 v0, final boolean b, final List<i2> list) {
        synchronized (this) {
            if (this.i.d() < 21) {
                return null;
            }
            final l2 e = this.e;
            final m2 p3 = this.p;
            if (p3 != null && p3.h().equals((Object)v0.f().toString())) {
                final int m = this.m;
                if (m > 0) {
                    this.m = m - 1;
                }
                this.g.getLogger().a(l4.DEBUG, "Transaction %s (%s) finished.", new Object[] { v0.getName(), ((u0)v0).i().j().toString() });
                if (this.m != 0 && !b) {
                    final m2 p4 = this.p;
                    if (p4 != null) {
                        p4.i(SystemClock.elapsedRealtimeNanos(), this.j, Process.getElapsedCpuTime(), this.k);
                    }
                    return null;
                }
                try {
                    Debug.stopMethodTracing();
                }
                finally {
                    final Throwable t;
                    this.g.getLogger().d(l4.ERROR, "Error while stopping profiling: ", t);
                }
                this.o.k(this.n);
                final long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                final long elapsedCpuTime = Process.getElapsedCpuTime();
                final long j = this.j;
                final ArrayList list2 = new ArrayList(1);
                final m2 p5 = this.p;
                if (p5 != null) {
                    ((List)list2).add((Object)p5);
                }
                this.p = null;
                this.m = 0;
                this.u = null;
                final Future<?> d = this.d;
                if (d != null) {
                    d.cancel(true);
                    this.d = null;
                }
                if (this.b == null) {
                    this.g.getLogger().a(l4.ERROR, "Trace file does not exists", new Object[0]);
                    return null;
                }
                String string = "0";
                final ActivityManager$MemoryInfo i = this.i();
                if (i != null) {
                    string = Long.toString(i.totalMem);
                }
                final String[] supported_ABIS = Build.SUPPORTED_ABIS;
                final Iterator iterator = ((List)list2).iterator();
                final long n = elapsedRealtimeNanos;
                while (iterator.hasNext()) {
                    ((m2)iterator.next()).i(n, this.j, elapsedCpuTime, this.k);
                }
                if (!this.r.isEmpty()) {
                    this.t.put((Object)"slow_frame_renders", (Object)new a("nanosecond", (Collection<b>)this.r));
                }
                if (!this.s.isEmpty()) {
                    this.t.put((Object)"frozen_frame_renders", (Object)new a("nanosecond", (Collection<b>)this.s));
                }
                if (!this.q.isEmpty()) {
                    this.t.put((Object)"screen_frame_rates", (Object)new a("hz", (Collection<b>)this.q));
                }
                this.o(list);
                final File b2 = this.b;
                final String string2 = Long.toString(elapsedRealtimeNanos - j);
                final int d2 = this.i.d();
                String s;
                if (supported_ABIS != null && supported_ABIS.length > 0) {
                    s = supported_ABIS[0];
                }
                else {
                    s = "";
                }
                final z z = new z();
                final String b3 = this.i.b();
                final String c = this.i.c();
                final String e2 = this.i.e();
                final Boolean f = this.i.f();
                final String proguardUuid = this.g.getProguardUuid();
                final String release = this.g.getRelease();
                final String environment = this.g.getEnvironment();
                String s2;
                if (b) {
                    s2 = "timeout";
                }
                else {
                    s2 = "normal";
                }
                return new l2(b2, (List<m2>)list2, v0, string2, d2, s, (Callable<List<Integer>>)z, b3, c, e2, f, string, proguardUuid, release, environment, s2, this.t);
            }
            else {
                if (e == null) {
                    this.g.getLogger().a(l4.INFO, "Transaction %s (%s) finished, but was not currently being profiled. Skipping", new Object[] { v0.getName(), ((u0)v0).i().j().toString() });
                    return null;
                }
                if (e.C().equals((Object)v0.f().toString())) {
                    this.e = null;
                    return e;
                }
                this.g.getLogger().a(l4.INFO, "A timed out profiling data exists, but the finishing transaction %s (%s) is not part of it", new Object[] { v0.getName(), ((u0)v0).i().j().toString() });
                return null;
            }
        }
    }
    
    private void o(final List<i2> list) {
        if (this.i.d() < 21) {
            return;
        }
        final long n = SystemClock.elapsedRealtimeNanos() - this.j - TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        if (list != null) {
            final ArrayDeque arrayDeque = new ArrayDeque(list.size());
            final ArrayDeque arrayDeque2 = new ArrayDeque(list.size());
            final ArrayDeque arrayDeque3 = new ArrayDeque(list.size());
            for (final i2 i2 : list) {
                final g c = i2.c();
                final r1 d = i2.d();
                if (c != null) {
                    arrayDeque3.add((Object)new b(TimeUnit.MILLISECONDS.toNanos(c.b()) + n, (Number)c.a()));
                }
                if (d != null && d.b() > -1L) {
                    arrayDeque.add((Object)new b(TimeUnit.MILLISECONDS.toNanos(d.a()) + n, (Number)d.b()));
                }
                if (d != null && d.c() > -1L) {
                    arrayDeque2.add((Object)new b(TimeUnit.MILLISECONDS.toNanos(d.a()) + n, (Number)d.c()));
                }
            }
            if (!arrayDeque3.isEmpty()) {
                this.t.put((Object)"cpu_usage", (Object)new a("percent", (Collection<b>)arrayDeque3));
            }
            if (!arrayDeque.isEmpty()) {
                this.t.put((Object)"memory_footprint", (Object)new a("byte", (Collection<b>)arrayDeque));
            }
            if (!arrayDeque2.isEmpty()) {
                this.t.put((Object)"memory_native_footprint", (Object)new a("byte", (Collection<b>)arrayDeque2));
            }
        }
    }
    
    public l2 a(final v0 v0, final List<i2> list) {
        synchronized (this) {
            return this.n(v0, false, list);
        }
    }
    
    public void b(final v0 v0) {
        synchronized (this) {
            if (this.i.d() < 21) {
                return;
            }
            this.j();
            if (this.c != null && this.a != 0) {
                final int m = this.m + 1;
                if ((this.m = m) == 1) {
                    if (this.m(v0)) {
                        this.g.getLogger().a(l4.DEBUG, "Transaction %s (%s) started and being profiled.", new Object[] { v0.getName(), ((u0)v0).i().j().toString() });
                    }
                }
                else {
                    this.m = m - 1;
                    this.g.getLogger().a(l4.WARNING, "A transaction is already being profiled. Transaction %s (%s) will be ignored.", new Object[] { v0.getName(), ((u0)v0).i().j().toString() });
                }
            }
        }
    }
    
    public void close() {
        final Future<?> d = this.d;
        if (d != null) {
            d.cancel(true);
            this.d = null;
        }
        final v0 u = this.u;
        if (u != null) {
            this.n(u, true, null);
        }
    }
}
