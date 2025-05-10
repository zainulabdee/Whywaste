package io.sentry.android.core;

import androidx.lifecycle.b;
import androidx.lifecycle.k;
import io.sentry.s2;
import io.sentry.a5;
import io.sentry.android.core.internal.util.c;
import io.sentry.l4;
import io.sentry.e;
import io.sentry.r2;
import io.sentry.transport.m;
import io.sentry.transport.o;
import io.sentry.m0;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;
import androidx.lifecycle.DefaultLifecycleObserver;

final class LifecycleWatcher implements DefaultLifecycleObserver
{
    private final AtomicLong e;
    private final long f;
    private TimerTask g;
    private final Timer h;
    private final Object i;
    private final m0 j;
    private final boolean k;
    private final boolean l;
    private final o m;
    
    LifecycleWatcher(final m0 m0, final long n, final boolean b, final boolean b2) {
        this(m0, n, b, b2, io.sentry.transport.m.b());
    }
    
    LifecycleWatcher(final m0 j, final long f, final boolean k, final boolean l, final o m) {
        this.e = new AtomicLong(0L);
        this.i = new Object();
        this.f = f;
        this.k = k;
        this.l = l;
        this.j = j;
        this.m = m;
        if (k) {
            this.h = new Timer(true);
        }
        else {
            this.h = null;
        }
    }
    
    private void e(final String s) {
        if (this.l) {
            final e e = new e();
            e.q("navigation");
            e.n("state", (Object)s);
            e.m("app.lifecycle");
            e.o(l4.INFO);
            this.j.f(e);
        }
    }
    
    private void f(final String s) {
        this.j.f(c.a(s));
    }
    
    private void g() {
        final Object i = this.i;
        synchronized (i) {
            final TimerTask g = this.g;
            if (g != null) {
                g.cancel();
                this.g = null;
            }
        }
    }
    
    private void i() {
        final Object i = this.i;
        synchronized (i) {
            this.g();
            if (this.h != null) {
                final LifecycleWatcher$a g = new LifecycleWatcher$a(this);
                this.g = (TimerTask)g;
                this.h.schedule((TimerTask)g, this.f);
            }
        }
    }
    
    private void j() {
        if (this.k) {
            this.g();
            final long a = this.m.a();
            this.j.l((s2)new v0(this));
            final long value = this.e.get();
            if (value == 0L || value + this.f <= a) {
                this.f("start");
                this.j.p();
            }
            this.e.set(a);
        }
    }
    
    public void onStart(final k k) {
        this.j();
        this.e("foreground");
        k0.a().c(false);
    }
    
    public void onStop(final k k) {
        if (this.k) {
            this.e.set(this.m.a());
            this.i();
        }
        k0.a().c(true);
        this.e("background");
    }
}
