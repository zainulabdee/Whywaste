package w0;

import java.util.concurrent.Executor;
import java.util.concurrent.CancellationException;
import f0.i;

final class z<TResult> extends g<TResult>
{
    private final Object a;
    private final w<TResult> b;
    private boolean c;
    private volatile boolean d;
    private TResult e;
    private Exception f;
    
    z() {
        this.a = new Object();
        this.b = (w<TResult>)new w();
    }
    
    private final void p() {
        i.l(this.c, (Object)"Task is not yet complete");
    }
    
    private final void q() {
        if (!this.d) {
            return;
        }
        throw new CancellationException("Task is already canceled.");
    }
    
    private final void r() {
        if (!this.c) {
            return;
        }
        throw w0.a.a((g)this);
    }
    
    private final void s() {
        final Object a = this.a;
        synchronized (a) {
            if (!this.c) {
                return;
            }
            monitorexit(a);
            this.b.b((g)this);
        }
    }
    
    public final g<TResult> a(final Executor executor, final b b) {
        this.b.a((v)new o(executor, b));
        this.s();
        return this;
    }
    
    public final g<TResult> b(final Executor executor, final c<TResult> c) {
        this.b.a((v)new q(executor, (w0.c<Object>)c));
        this.s();
        return this;
    }
    
    public final g<TResult> c(final c<TResult> c) {
        this.b.a((v)new q(w0.i.a, (w0.c<Object>)c));
        this.s();
        return this;
    }
    
    public final g<TResult> d(final Executor executor, final d d) {
        this.b.a((v)new s(executor, d));
        this.s();
        return this;
    }
    
    public final g<TResult> e(final Executor executor, final e<? super TResult> e) {
        this.b.a((v)new u(executor, (w0.e<? super Object>)e));
        this.s();
        return this;
    }
    
    public final Exception f() {
        final Object a = this.a;
        synchronized (a) {
            return this.f;
        }
    }
    
    public final TResult g() {
        final Object a = this.a;
        synchronized (a) {
            this.p();
            this.q();
            final Exception f = this.f;
            if (f == null) {
                return this.e;
            }
            throw new f((Throwable)f);
        }
    }
    
    public final <X extends Throwable> TResult h(final Class<X> clazz) throws X {
        final Object a = this.a;
        synchronized (a) {
            this.p();
            this.q();
            if (clazz.isInstance(this.f)) {
                throw (Throwable)clazz.cast(this.f);
            }
            final Exception f = this.f;
            if (f == null) {
                return this.e;
            }
            throw new f((Throwable)f);
        }
    }
    
    public final boolean i() {
        return this.d;
    }
    
    public final boolean j() {
        final Object a = this.a;
        synchronized (a) {
            return this.c;
        }
    }
    
    public final boolean k() {
        final Object a = this.a;
        synchronized (a) {
            final boolean c = this.c;
            boolean b2;
            final boolean b = b2 = false;
            if (c) {
                b2 = b;
                if (!this.d) {
                    b2 = b;
                    if (this.f == null) {
                        b2 = true;
                    }
                }
            }
            return b2;
        }
    }
    
    public final void l(final Exception f) {
        i.j((Object)f, (Object)"Exception must not be null");
        final Object a = this.a;
        synchronized (a) {
            this.r();
            this.c = true;
            this.f = f;
            monitorexit(a);
            this.b.b((g)this);
        }
    }
    
    public final void m(final TResult e) {
        final Object a = this.a;
        synchronized (a) {
            this.r();
            this.c = true;
            this.e = e;
            monitorexit(a);
            this.b.b((g)this);
        }
    }
    
    public final boolean n(final Exception f) {
        i.j((Object)f, (Object)"Exception must not be null");
        final Object a = this.a;
        synchronized (a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.f = f;
            monitorexit(a);
            this.b.b((g)this);
            return true;
        }
    }
    
    public final boolean o(final TResult e) {
        final Object a = this.a;
        synchronized (a) {
            if (this.c) {
                return false;
            }
            this.c = true;
            this.e = e;
            monitorexit(a);
            this.b.b((g)this);
            return true;
        }
    }
}
