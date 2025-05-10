package u2;

import java.util.concurrent.locks.Lock;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.o$b;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.v;
import kotlinx.coroutines.internal.j0;
import c2.q;
import l2.l;
import java.util.concurrent.locks.ReentrantLock;

public class m<E> extends a<E>
{
    private final ReentrantLock e;
    private Object f;
    
    public m(final l<? super E, q> l) {
        super(l);
        this.e = new ReentrantLock();
        this.f = u2.b.a;
    }
    
    private final j0 x(final Object f) {
        final Object f2 = this.f;
        final b0 a = u2.b.a;
        j0 d = null;
        if (f2 != a) {
            final l2.l<E, q> b = (l2.l<E, q>)super.b;
            if (b != null) {
                d = v.d((l)b, f2, (j0)null, 2, (Object)null);
            }
        }
        this.f = f;
        return d;
    }
    
    @Override
    protected String c() {
        final ReentrantLock e = this.e;
        ((Lock)e).lock();
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append("(value=");
            sb.append(this.f);
            sb.append(')');
            return sb.toString();
        }
        finally {
            ((Lock)e).unlock();
        }
    }
    
    @Override
    protected Object i(final E e) {
        final ReentrantLock e2 = this.e;
        ((Lock)e2).lock();
        try {
            final j<?> d = this.d();
            if (d != null) {
                return d;
            }
            Label_0118: {
                if (this.f == u2.b.a) {
                    u2.q<E> l;
                    do {
                        l = this.l();
                        if (l == null) {
                            break Label_0118;
                        }
                        if (l instanceof j) {
                            return l;
                        }
                        i.b((Object)l);
                    } while (l.e((Object)e, (o$b)null) == null);
                    final q a = q.a;
                    ((Lock)e2).unlock();
                    l.b((Object)e);
                    return l.c();
                }
            }
            final j0 x = this.x(e);
            if (x == null) {
                return u2.b.b;
            }
            throw x;
        }
        finally {
            ((Lock)e2).unlock();
        }
    }
    
    @Override
    protected boolean q(final o<? super E> o) {
        final ReentrantLock e = this.e;
        ((Lock)e).lock();
        try {
            return super.q(o);
        }
        finally {
            ((Lock)e).unlock();
        }
    }
    
    @Override
    protected final boolean r() {
        return false;
    }
    
    @Override
    protected final boolean s() {
        final ReentrantLock e = this.e;
        ((Lock)e).lock();
        try {
            return this.f == u2.b.a;
        }
        finally {
            ((Lock)e).unlock();
        }
    }
    
    @Override
    protected Object v() {
        final ReentrantLock e = this.e;
        ((Lock)e).lock();
        try {
            final Object f = this.f;
            final b0 a = u2.b.a;
            if (f == a) {
                Object o;
                if ((o = this.d()) == null) {
                    o = u2.b.d;
                }
                return o;
            }
            this.f = a;
            final q a2 = q.a;
            return f;
        }
        finally {
            ((Lock)e).unlock();
        }
    }
}
