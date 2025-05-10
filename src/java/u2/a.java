package u2;

import s2.e;
import s2.k0;
import kotlinx.coroutines.internal.b0;
import c2.k$a;
import kotlin.coroutines.jvm.internal.h;
import kotlinx.coroutines.internal.v;
import e2.d;
import kotlinx.coroutines.internal.a0;
import kotlinx.coroutines.internal.o$b;
import kotlinx.coroutines.internal.m;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.o$a;
import s2.k;
import c2.q;
import l2.l;

public abstract class a<E> extends u2.c<E> implements f<E>
{
    public a(final l<? super E, q> l) {
        super(l);
    }
    
    private final boolean p(final o<? super E> o) {
        final boolean q = this.q(o);
        if (q) {
            this.u();
        }
        return q;
    }
    
    private final void w(final k<?> k, final o<?> o) {
        k.k((l<? super Throwable, q>)new c(o));
    }
    
    public final g<E> iterator() {
        return (g<E>)new a((a<Object>)this);
    }
    
    @Override
    protected u2.q<E> l() {
        final u2.q<E> l = super.l();
        if (l != null && !(l instanceof j)) {
            this.t();
        }
        return l;
    }
    
    protected boolean q(final o<? super E> o) {
        final boolean r = this.r();
        final boolean b = false;
        if (!r) {
            final m e = this.e();
            final o$a o$a = new o$a(o, this) {
                final a d;
                
                public Object i(final kotlinx.coroutines.internal.o o) {
                    Object a;
                    if (this.d.s()) {
                        a = null;
                    }
                    else {
                        a = n.a();
                    }
                    return a;
                }
            };
            while (true) {
                final kotlinx.coroutines.internal.o q = ((kotlinx.coroutines.internal.o)e).q();
                if (!(q instanceof s ^ true)) {
                    break;
                }
                final int x = q.x((kotlinx.coroutines.internal.o)o, (kotlinx.coroutines.internal.o)e, (o$a)o$a);
                if (x == 1) {
                    return true;
                }
                final boolean b2 = b;
                if (x != 2) {
                    continue;
                }
                return b2;
            }
            return b;
        }
        final m e2 = this.e();
        kotlinx.coroutines.internal.o q2;
        do {
            q2 = ((kotlinx.coroutines.internal.o)e2).q();
            if (!(q2 instanceof s ^ true)) {
                return b;
            }
        } while (!q2.j((kotlinx.coroutines.internal.o)o, (kotlinx.coroutines.internal.o)e2));
        return true;
    }
    
    protected abstract boolean r();
    
    protected abstract boolean s();
    
    protected void t() {
    }
    
    protected void u() {
    }
    
    protected Object v() {
        while (true) {
            final s m = this.m();
            if (m == null) {
                return u2.b.d;
            }
            if (m.A(null) != null) {
                m.y();
                return m.z();
            }
            m.B();
        }
    }
    
    private static final class a<E> implements g<E>
    {
        public final u2.a<E> a;
        private Object b;
        
        public a(final u2.a<E> a) {
            this.a = a;
            this.b = u2.b.d;
        }
        
        private final boolean b(final Object o) {
            if (!(o instanceof j)) {
                return true;
            }
            final j j = (j)o;
            if (j.h == null) {
                return false;
            }
            throw a0.a(j.E());
        }
        
        private final Object c(final d<? super Boolean> d) {
            final s2.l a = s2.n.a(f2.b.b((d)d));
            final b b = new b((a)this, a);
            while (true) {
                while (!((u2.a<Object>)this.a).p(b)) {
                    final Object v = this.a.v();
                    this.d(v);
                    if (v instanceof j) {
                        final j j = (j)v;
                        if (j.h == null) {
                            final k$a e = c2.k.e;
                            ((d)a).resumeWith(c2.k.a((Object)kotlin.coroutines.jvm.internal.b.a(false)));
                        }
                        else {
                            final k$a e2 = c2.k.e;
                            ((d)a).resumeWith(c2.k.a(c2.l.a(j.E())));
                        }
                    }
                    else {
                        if (v == u2.b.d) {
                            continue;
                        }
                        final Boolean a2 = kotlin.coroutines.jvm.internal.b.a(true);
                        final l2.l<E, q> b2 = this.a.b;
                        l a3;
                        if (b2 != null) {
                            a3 = kotlinx.coroutines.internal.v.a((l)b2, v, ((d)a).getContext());
                        }
                        else {
                            a3 = null;
                        }
                        a.p(a2, a3);
                    }
                    final Object u = a.u();
                    if (u == f2.b.c()) {
                        h.c((d)d);
                    }
                    return u;
                }
                ((u2.a<Object>)this.a).w(a, b);
                continue;
            }
        }
        
        public Object a(final d<? super Boolean> d) {
            final Object b = this.b;
            final b0 d2 = u2.b.d;
            if (b != d2) {
                return kotlin.coroutines.jvm.internal.b.a(this.b(b));
            }
            final Object v = this.a.v();
            if ((this.b = v) != d2) {
                return kotlin.coroutines.jvm.internal.b.a(this.b(v));
            }
            return this.c(d);
        }
        
        public final void d(final Object b) {
            this.b = b;
        }
        
        public E next() {
            final Object b = this.b;
            if (b instanceof j) {
                throw a0.a(((j)b).E());
            }
            final b0 d = u2.b.d;
            if (b != d) {
                this.b = d;
                return (E)b;
            }
            throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
        }
    }
    
    private static class b<E> extends o<E>
    {
        public final a<E> h;
        public final k<Boolean> i;
        
        public b(final a<E> h, final k<? super Boolean> i) {
            this.h = h;
            this.i = (k<Boolean>)i;
        }
        
        public l<Throwable, q> A(final E e) {
            final l2.l<E, q> b = this.h.a.b;
            l a;
            if (b != null) {
                a = v.a((l)b, (Object)e, ((d)this.i).getContext());
            }
            else {
                a = null;
            }
            return (l<Throwable, q>)a;
        }
        
        public void b(final E e) {
            this.h.d(e);
            this.i.x(s2.m.a);
        }
        
        public b0 e(final E e, final o$b o$b) {
            if (this.i.e(Boolean.TRUE, null, this.A(e)) == null) {
                return null;
            }
            return s2.m.a;
        }
        
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("ReceiveHasNext@");
            sb.append(k0.b((Object)this));
            return sb.toString();
        }
        
        @Override
        public void z(final j<?> j) {
            Object o;
            if (j.h == null) {
                o = s2.k$a.a((k)this.i, (Object)Boolean.FALSE, (Object)null, 2, (Object)null);
            }
            else {
                o = this.i.v(j.E());
            }
            if (o != null) {
                this.h.d(j);
                this.i.x(o);
            }
        }
    }
    
    private final class c extends e
    {
        private final o<?> e;
        final a<E> f;
        
        public c(final a f, final o<?> e) {
            this.f = f;
            this.e = e;
        }
        
        @Override
        public void a(final Throwable t) {
            if (this.e.u()) {
                this.f.t();
            }
        }
        
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("RemoveReceiveOnCancel[");
            sb.append((Object)this.e);
            sb.append(']');
            return sb.toString();
        }
    }
}
