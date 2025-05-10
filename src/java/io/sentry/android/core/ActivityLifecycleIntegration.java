package io.sentry.android.core;

import io.sentry.g5;
import java.lang.ref.Reference;
import android.view.View;
import io.sentry.z$a;
import io.sentry.r2$c;
import io.sentry.n0;
import io.sentry.q4;
import io.sentry.a1;
import io.sentry.z0;
import io.sentry.h5;
import io.sentry.a0;
import io.sentry.e;
import java.util.Iterator;
import java.util.Map$Entry;
import io.sentry.s2;
import java.util.concurrent.RejectedExecutionException;
import io.sentry.y0;
import io.sentry.p5;
import io.sentry.q5;
import io.sentry.r5;
import io.sentry.util.v;
import io.sentry.a2;
import android.os.Bundle;
import io.sentry.q1;
import io.sentry.q1$a;
import java.util.concurrent.TimeUnit;
import java.lang.ref.WeakReference;
import io.sentry.l4;
import io.sentry.r2;
import android.content.Context;
import io.sentry.util.n;
import android.os.Looper;
import io.sentry.v0;
import java.util.concurrent.Future;
import android.os.Handler;
import io.sentry.j3;
import android.app.Activity;
import java.util.WeakHashMap;
import io.sentry.u0;
import io.sentry.z;
import io.sentry.m0;
import android.app.Application;
import android.app.Application$ActivityLifecycleCallbacks;
import java.io.Closeable;
import io.sentry.Integration;

public final class ActivityLifecycleIntegration implements Integration, Closeable, Application$ActivityLifecycleCallbacks
{
    private final Application e;
    private final l0 f;
    private m0 g;
    private SentryAndroidOptions h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private final boolean m;
    private z n;
    private u0 o;
    private final WeakHashMap<Activity, u0> p;
    private final WeakHashMap<Activity, u0> q;
    private j3 r;
    private final Handler s;
    private Future<?> t;
    private final WeakHashMap<Activity, v0> u;
    private final h v;
    
    public ActivityLifecycleIntegration(Application e, final l0 l0, final h h) {
        this.i = false;
        this.j = false;
        this.l = false;
        this.n = null;
        this.p = (WeakHashMap<Activity, u0>)new WeakHashMap();
        this.q = (WeakHashMap<Activity, u0>)new WeakHashMap();
        this.r = io.sentry.android.core.s.a();
        this.s = new Handler(Looper.getMainLooper());
        this.t = null;
        this.u = (WeakHashMap<Activity, v0>)new WeakHashMap();
        e = (Application)io.sentry.util.n.c((Object)e, "Application is required");
        this.e = e;
        this.f = (l0)io.sentry.util.n.c((Object)l0, "BuildInfoProvider is required");
        this.v = (h)io.sentry.util.n.c((Object)h, "ActivityFramesTracker is required");
        if (l0.d() >= 29) {
            this.k = true;
        }
        this.m = io.sentry.android.core.m0.n((Context)e);
    }
    
    private String A(final boolean b) {
        if (b) {
            return "app.start.cold";
        }
        return "app.start.warm";
    }
    
    private String B(final u0 u0) {
        final String description = u0.getDescription();
        if (description != null && description.endsWith(" - Deadline Exceeded")) {
            return description;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(u0.getDescription());
        sb.append(" - Deadline Exceeded");
        return sb.toString();
    }
    
    private String C(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(" full display");
        return sb.toString();
    }
    
    private String D(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.append(" initial display");
        return sb.toString();
    }
    
    private boolean E(final SentryAndroidOptions sentryAndroidOptions) {
        return ((q4)sentryAndroidOptions).isTracingEnabled() && sentryAndroidOptions.isEnableAutoActivityLifecycleTracing();
    }
    
    private boolean F(final Activity activity) {
        return this.u.containsKey((Object)activity);
    }
    
    private void O(final u0 u0, final u0 u2) {
        final SentryAndroidOptions h = this.h;
        if (h != null && u2 != null) {
            final j3 a = ((q4)h).getDateProvider().a();
            final long millis = TimeUnit.NANOSECONDS.toMillis(a.e(u2.r()));
            final q1$a millisecond = q1$a.MILLISECOND;
            u2.p("time_to_initial_display", (Number)millis, (q1)millisecond);
            if (u0 != null && u0.e()) {
                u0.g(a);
                u2.p("time_to_full_display", (Number)millis, (q1)millisecond);
            }
            this.u(u2, a);
        }
        else {
            this.t(u2);
        }
    }
    
    private void P(final Bundle bundle) {
        if (!this.l) {
            j0.e().j(bundle == null);
        }
    }
    
    private void Q(final Activity activity) {
        final WeakReference weakReference = new WeakReference((Object)activity);
        if (this.g != null && !this.F(activity)) {
            final boolean i = this.i;
            if (!i) {
                this.u.put((Object)activity, (Object)a2.s());
                io.sentry.util.v.h(this.g);
            }
            else if (i) {
                this.R();
                final String y = this.y(activity);
                j3 d;
                if (this.m) {
                    d = j0.e().d();
                }
                else {
                    d = null;
                }
                final Boolean f = j0.e().f();
                final r5 r5 = new r5();
                if (this.h.isEnableActivityLifecycleTracingAutoFinish()) {
                    r5.k(((q4)this.h).getIdleTimeout());
                    ((g5)r5).d(true);
                }
                r5.n(true);
                r5.m((q5)new io.sentry.android.core.n(this, weakReference, y));
                j3 r6;
                if (!this.l && d != null && f != null) {
                    r6 = d;
                }
                else {
                    r6 = this.r;
                }
                r5.l(r6);
                final v0 j = this.g.i(new p5(y, io.sentry.protocol.z.COMPONENT, "ui.load"), r5);
                if (!this.l && d != null && f != null) {
                    this.o = ((u0)j).n(this.A(f), this.z(f), d, y0.SENTRY);
                    this.r();
                }
                final String d2 = this.D(y);
                final y0 sentry = y0.SENTRY;
                final u0 n = ((u0)j).n("ui.load.initial_display", d2, r6, sentry);
                this.p.put((Object)activity, (Object)n);
                if (this.j && this.n != null && this.h != null) {
                    final u0 n2 = ((u0)j).n("ui.load.full_display", this.C(y), r6, sentry);
                    try {
                        this.q.put((Object)activity, (Object)n2);
                        this.t = (Future<?>)((q4)this.h).getExecutorService().b((Runnable)new o(this, n2, n), 30000L);
                    }
                    catch (final RejectedExecutionException ex) {
                        ((q4)this.h).getLogger().d(l4.ERROR, "Failed to call the executor. Time to full display span will not be finished automatically. Did you call Sentry.close()?", (Throwable)ex);
                    }
                }
                this.g.l((s2)new p(this, j));
                this.u.put((Object)activity, (Object)j);
            }
        }
    }
    
    private void R() {
        for (final Map$Entry map$Entry : this.u.entrySet()) {
            this.x((v0)map$Entry.getValue(), (u0)this.p.get(map$Entry.getKey()), (u0)this.q.get(map$Entry.getKey()));
        }
    }
    
    private void S(final Activity activity, final boolean b) {
        if (this.i && b) {
            this.x((v0)this.u.get((Object)activity), null, null);
        }
    }
    
    private void m(final Activity activity, final String s) {
        final SentryAndroidOptions h = this.h;
        if (h != null && this.g != null && h.isEnableActivityLifecycleBreadcrumbs()) {
            final e e = new e();
            e.q("navigation");
            e.n("state", (Object)s);
            e.n("screen", (Object)this.y(activity));
            e.m("ui.lifecycle");
            e.o(l4.INFO);
            final a0 a0 = new a0();
            a0.j("android:activity", (Object)activity);
            this.g.k(e, a0);
        }
    }
    
    private void p() {
        final Future<?> t = this.t;
        if (t != null) {
            t.cancel(false);
            this.t = null;
        }
    }
    
    private void r() {
        final j3 a = j0.e().a();
        if (this.i && a != null) {
            this.u(this.o, a);
        }
    }
    
    private void s(final u0 u0, final u0 u2) {
        if (u0 != null) {
            if (!u0.e()) {
                u0.d(this.B(u0));
                j3 j3;
                if (u2 != null) {
                    j3 = u2.l();
                }
                else {
                    j3 = null;
                }
                if (j3 == null) {
                    j3 = u0.r();
                }
                this.v(u0, j3, h5.DEADLINE_EXCEEDED);
            }
        }
    }
    
    private void t(final u0 u0) {
        if (u0 != null && !u0.e()) {
            u0.o();
        }
    }
    
    private void u(final u0 u0, final j3 j3) {
        this.v(u0, j3, null);
    }
    
    private void v(final u0 u0, final j3 j3, h5 h5) {
        if (u0 != null && !u0.e()) {
            if (h5 == null) {
                if (u0.a() != null) {
                    h5 = u0.a();
                }
                else {
                    h5 = h5.OK;
                }
            }
            u0.m(h5, j3);
        }
    }
    
    private void w(final u0 u0, final h5 h5) {
        if (u0 != null && !u0.e()) {
            u0.j(h5);
        }
    }
    
    private void x(final v0 v0, final u0 u0, final u0 u2) {
        if (v0 != null) {
            if (((u0)v0).e()) {
                return;
            }
            this.w(u0, h5.DEADLINE_EXCEEDED);
            this.s(u2, u0);
            this.p();
            h5 h5;
            if ((h5 = ((u0)v0).a()) == null) {
                h5 = io.sentry.h5.OK;
            }
            ((u0)v0).j(h5);
            final m0 g = this.g;
            if (g != null) {
                g.l((s2)new k(this, v0));
            }
        }
    }
    
    private String y(final Activity activity) {
        return activity.getClass().getSimpleName();
    }
    
    private String z(final boolean b) {
        if (b) {
            return "Cold Start";
        }
        return "Warm Start";
    }
    
    public void close() {
        this.e.unregisterActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this);
        final SentryAndroidOptions h = this.h;
        if (h != null) {
            ((q4)h).getLogger().a(l4.DEBUG, "ActivityLifecycleIntegration removed.", new Object[0]);
        }
        this.v.p();
    }
    
    public void d(final m0 m0, final q4 q4) {
        SentryAndroidOptions sentryAndroidOptions;
        if (q4 instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions)q4;
        }
        else {
            sentryAndroidOptions = null;
        }
        this.h = (SentryAndroidOptions)io.sentry.util.n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.g = (m0)io.sentry.util.n.c((Object)m0, "Hub is required");
        final n0 logger = ((q4)this.h).getLogger();
        final l4 debug = l4.DEBUG;
        logger.a(debug, "ActivityLifecycleIntegration enabled: %s", new Object[] { this.h.isEnableActivityLifecycleBreadcrumbs() });
        this.i = this.E(this.h);
        this.n = ((q4)this.h).getFullyDisplayedReporter();
        this.j = ((q4)this.h).isEnableTimeToFullDisplayTracing();
        this.e.registerActivityLifecycleCallbacks((Application$ActivityLifecycleCallbacks)this);
        ((q4)this.h).getLogger().a(debug, "ActivityLifecycleIntegration installed.", new Object[0]);
        this.n();
    }
    
    public /* synthetic */ void n() {
        z0.a((a1)this);
    }
    
    void o(final r2 r2, final v0 v0) {
        r2.J((r2$c)new q(this, r2, v0));
    }
    
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
        synchronized (this) {
            this.P(bundle);
            this.m(activity, "created");
            this.Q(activity);
            final u0 u0 = (u0)this.q.get((Object)activity);
            this.l = true;
            final z n = this.n;
            if (n != null) {
                n.b((z$a)new l(this, u0));
            }
        }
    }
    
    public void onActivityDestroyed(final Activity activity) {
        synchronized (this) {
            if (this.i || this.h.isEnableActivityLifecycleBreadcrumbs()) {
                this.m(activity, "destroyed");
                this.w(this.o, h5.CANCELLED);
                final u0 u0 = (u0)this.p.get((Object)activity);
                final u0 u2 = (u0)this.q.get((Object)activity);
                this.w(u0, h5.DEADLINE_EXCEEDED);
                this.s(u2, u0);
                this.p();
                this.S(activity, true);
                this.o = null;
                this.p.remove((Object)activity);
                this.q.remove((Object)activity);
            }
            this.u.remove((Object)activity);
        }
    }
    
    public void onActivityPaused(final Activity activity) {
        synchronized (this) {
            if (!this.k) {
                final m0 g = this.g;
                if (g == null) {
                    this.r = io.sentry.android.core.s.a();
                }
                else {
                    this.r = g.r().getDateProvider().a();
                }
            }
            this.m(activity, "paused");
        }
    }
    
    public void onActivityPostResumed(final Activity activity) {
    }
    
    public void onActivityPrePaused(final Activity activity) {
        if (this.k) {
            final m0 g = this.g;
            if (g == null) {
                this.r = io.sentry.android.core.s.a();
            }
            else {
                this.r = g.r().getDateProvider().a();
            }
        }
    }
    
    public void onActivityResumed(final Activity activity) {
        synchronized (this) {
            if (this.i) {
                final j3 d = j0.e().d();
                final j3 a = j0.e().a();
                if (d != null && a == null) {
                    j0.e().g();
                }
                this.r();
                final u0 u0 = (u0)this.p.get((Object)activity);
                final u0 u2 = (u0)this.q.get((Object)activity);
                final View viewById = activity.findViewById(16908290);
                if (this.f.d() >= 16 && viewById != null) {
                    io.sentry.android.core.internal.util.l.e(viewById, (Runnable)new i(this, u2, u0), this.f);
                }
                else {
                    this.s.post((Runnable)new j(this, u2, u0));
                }
            }
            this.m(activity, "resumed");
        }
    }
    
    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        synchronized (this) {
            this.m(activity, "saveInstanceState");
        }
    }
    
    public void onActivityStarted(final Activity activity) {
        synchronized (this) {
            if (this.i) {
                this.v.e(activity);
            }
            this.m(activity, "started");
        }
    }
    
    public void onActivityStopped(final Activity activity) {
        synchronized (this) {
            this.m(activity, "stopped");
        }
    }
    
    void q(final r2 r2, final v0 v0) {
        r2.J((r2$c)new m(v0, r2));
    }
}
