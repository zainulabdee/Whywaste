package u2;

import java.util.concurrent.locks.Lock;
import kotlinx.coroutines.internal.o$b;
import c2.i;
import kotlinx.coroutines.internal.b0;
import c2.q;
import l2.l;
import java.util.concurrent.locks.ReentrantLock;

public class d<E> extends a<E>
{
    private final int e;
    private final e f;
    private final ReentrantLock g;
    private Object[] h;
    private int i;
    private volatile int size;
    
    public d(final int e, final e f, final l<? super E, q> l) {
        super(l);
        this.e = e;
        this.f = f;
        boolean b = true;
        if (e < 1) {
            b = false;
        }
        if (b) {
            this.g = new ReentrantLock();
            final Object[] h = new Object[Math.min(e, 8)];
            d2.e.f(h, u2.b.a, 0, 0, 6, null);
            this.h = h;
            this.size = 0;
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("ArrayChannel capacity must be at least 1, but ");
        sb.append(e);
        sb.append(" was specified");
        throw new IllegalArgumentException(sb.toString().toString());
    }
    
    private final void x(final int n, final E e) {
        if (n < this.e) {
            this.y(n);
            final Object[] h = this.h;
            h[(this.i + n) % h.length] = e;
        }
        else {
            final Object[] h2 = this.h;
            final int i = this.i;
            h2[i % h2.length] = null;
            h2[(n + i) % h2.length] = e;
            this.i = (i + 1) % h2.length;
        }
    }
    
    private final void y(final int n) {
        final Object[] h = this.h;
        if (n >= h.length) {
            final int min = Math.min(h.length * 2, this.e);
            final Object[] h2 = new Object[min];
            for (int i = 0; i < n; ++i) {
                final Object[] h3 = this.h;
                h2[i] = h3[(this.i + i) % h3.length];
            }
            d2.e.e(h2, u2.b.a, n, min);
            this.h = h2;
            this.i = 0;
        }
    }
    
    private final b0 z(int n) {
        final int e = this.e;
        b0 b0 = null;
        if (n < e) {
            this.size = n + 1;
            return null;
        }
        n = d.d$a.a[((Enum)this.f).ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    throw new i();
                }
            }
            else {
                b0 = u2.b.b;
            }
        }
        else {
            b0 = u2.b.c;
        }
        return b0;
    }
    
    @Override
    protected String c() {
        final StringBuilder sb = new StringBuilder();
        sb.append("(buffer:capacity=");
        sb.append(this.e);
        sb.append(",size=");
        sb.append(this.size);
        sb.append(')');
        return sb.toString();
    }
    
    @Override
    protected Object i(final E e) {
        final ReentrantLock g = this.g;
        ((Lock)g).lock();
        try {
            final int size = this.size;
            final j<?> d = this.d();
            if (d != null) {
                return d;
            }
            final b0 z = this.z(size);
            if (z != null) {
                return z;
            }
            Label_0146: {
                if (size == 0) {
                    u2.q<E> l;
                    do {
                        l = this.l();
                        if (l == null) {
                            break Label_0146;
                        }
                        if (l instanceof j) {
                            this.size = size;
                            return l;
                        }
                        kotlin.jvm.internal.i.b((Object)l);
                    } while (l.e((Object)e, (o$b)null) == null);
                    this.size = size;
                    final q a = q.a;
                    ((Lock)g).unlock();
                    l.b((Object)e);
                    return l.c();
                }
            }
            this.x(size, e);
            return u2.b.b;
        }
        finally {
            ((Lock)g).unlock();
        }
    }
    
    @Override
    protected boolean q(final o<? super E> o) {
        final ReentrantLock g = this.g;
        ((Lock)g).lock();
        try {
            return super.q(o);
        }
        finally {
            ((Lock)g).unlock();
        }
    }
    
    @Override
    protected final boolean r() {
        return false;
    }
    
    @Override
    protected final boolean s() {
        return this.size == 0;
    }
    
    @Override
    protected Object v() {
        final ReentrantLock g = this.g;
        ((Lock)g).lock();
        try {
            final int size = this.size;
            if (size == 0) {
                Object o;
                if ((o = this.d()) == null) {
                    o = u2.b.d;
                }
                return o;
            }
            final Object[] h = this.h;
            final int i = this.i;
            final Object o2 = h[i];
            s s = null;
            h[i] = null;
            this.size = size - 1;
            final b0 d = u2.b.d;
            final int e = this.e;
            final boolean b = false;
            b0 b2 = d;
            int n = b ? 1 : 0;
            if (size == e) {
                s = null;
                while (true) {
                    final s m = this.m();
                    if (m == null) {
                        b2 = d;
                        n = (b ? 1 : 0);
                        break;
                    }
                    kotlin.jvm.internal.i.b((Object)m);
                    if (m.A(null) != null) {
                        final Object z = m.z();
                        s = m;
                        n = 1;
                        b2 = (b0)z;
                        break;
                    }
                    m.B();
                    s = m;
                }
            }
            if (b2 != u2.b.d && !(b2 instanceof j)) {
                this.size = size;
                final Object[] h2 = this.h;
                h2[(this.i + size) % h2.length] = b2;
            }
            this.i = (this.i + 1) % this.h.length;
            final q a = q.a;
            ((Lock)g).unlock();
            if (n != 0) {
                kotlin.jvm.internal.i.b((Object)s);
                s.y();
            }
            return o2;
        }
        finally {
            ((Lock)g).unlock();
        }
    }
}
