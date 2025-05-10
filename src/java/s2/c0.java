package s2;

import e2.b;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.l;
import e2.g;
import kotlinx.coroutines.internal.f;
import e2.d;
import e2.e$a;
import e2.g$b;
import e2.g$c;
import e2.e;
import e2.a;

public abstract class c0 extends e2.a implements e
{
    public static final a f;
    
    static {
        f = new a(null);
    }
    
    public c0() {
        super((g$c<?>)e.b);
    }
    
    @Override
    public <E extends g$b> E b(final g$c<E> g$c) {
        return (E)e$a.a((e)this, (g$c)g$c);
    }
    
    @Override
    public final <T> d<T> h(final d<? super T> d) {
        return (d<T>)new f(this, (d)d);
    }
    
    @Override
    public final void m(final d<?> d) {
        ((f)d).o();
    }
    
    public abstract void p(final g p0, final Runnable p1);
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(k0.a((Object)this));
        sb.append('@');
        sb.append(k0.b((Object)this));
        return sb.toString();
    }
    
    public boolean v(final g g) {
        return true;
    }
    
    public c0 x(final int n) {
        l.a(n);
        return (c0)new k(this, n);
    }
    
    @Override
    public g y(final g$c<?> g$c) {
        return e$a.b((e)this, (g$c)g$c);
    }
    
    public static final class a extends b<e, c0>
    {
        private a() {
            super((g$c)e.b, (l2.l)c0$a$a.e);
        }
    }
}
