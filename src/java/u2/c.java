package u2;

import kotlinx.coroutines.internal.b0;
import s2.k0;
import kotlinx.coroutines.internal.o$b;
import java.util.ArrayList;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.m;
import c2.q;
import l2.l;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class c<E> implements t<E>
{
    private static final AtomicReferenceFieldUpdater d;
    protected final l<E, q> b;
    private final m c;
    private volatile Object onCloseHandler;
    
    static {
        d = AtomicReferenceFieldUpdater.newUpdater((Class)c.class, (Class)Object.class, "onCloseHandler");
    }
    
    public c(final l<? super E, q> b) {
        this.b = (l<E, q>)b;
        this.c = new m();
        this.onCloseHandler = null;
    }
    
    private final int b() {
        final m c = this.c;
        o p = (o)((o)c).o();
        int n = 0;
        while (!i.a((Object)p, (Object)c)) {
            int n2 = n;
            if (p instanceof o) {
                n2 = n + 1;
            }
            p = p.p();
            n = n2;
        }
        return n;
    }
    
    private final String f() {
        final o p = ((o)this.c).p();
        if (p == this.c) {
            return "EmptyQueue";
        }
        String s;
        if (p instanceof j) {
            s = p.toString();
        }
        else if (p instanceof u2.o) {
            s = "ReceiveQueued";
        }
        else if (p instanceof s) {
            s = "SendQueued";
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append("UNEXPECTED:");
            sb.append((Object)p);
            s = sb.toString();
        }
        final o q = ((o)this.c).q();
        String s2 = s;
        if (q != p) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s);
            sb2.append(",queueSize=");
            sb2.append(this.b());
            s2 = sb2.toString();
            if (q instanceof j) {
                final StringBuilder sb3 = new StringBuilder();
                sb3.append(s2);
                sb3.append(",closedForSend=");
                sb3.append((Object)q);
                s2 = sb3.toString();
            }
        }
        return s2;
    }
    
    private final void g(final j<?> j) {
        Object o = kotlinx.coroutines.internal.j.b((Object)null, 1, (e)null);
        while (true) {
            final o q = j.q();
            u2.o o2;
            if (q instanceof u2.o) {
                o2 = (u2.o)q;
            }
            else {
                o2 = null;
            }
            if (o2 == null) {
                break;
            }
            if (!o2.u()) {
                o2.r();
            }
            else {
                o = kotlinx.coroutines.internal.j.c(o, (Object)o2);
            }
        }
        if (o != null) {
            if (!(o instanceof ArrayList)) {
                ((u2.o)o).z(j);
            }
            else {
                final ArrayList list = (ArrayList)o;
                for (int n = list.size() - 1; -1 < n; --n) {
                    ((u2.o)list.get(n)).z(j);
                }
            }
        }
        this.j(j);
    }
    
    private final Throwable h(final j<?> j) {
        this.g(j);
        return j.F();
    }
    
    public final Object a(final E e) {
        final Object i = this.i(e);
        Object o;
        if (i == u2.b.b) {
            o = u2.i.a.c((Object)q.a);
        }
        else if (i == u2.b.c) {
            final j<?> d = this.d();
            if (d == null) {
                return u2.i.a.b();
            }
            o = u2.i.a.a(this.h(d));
        }
        else {
            if (!(i instanceof j)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("trySend returned ");
                sb.append(i);
                throw new IllegalStateException(sb.toString().toString());
            }
            o = u2.i.a.a(this.h((j<?>)i));
        }
        return o;
    }
    
    protected String c() {
        return "";
    }
    
    protected final j<?> d() {
        final o q = ((o)this.c).q();
        final boolean b = q instanceof j;
        j<?> j = null;
        j i;
        if (b) {
            i = (j)q;
        }
        else {
            i = null;
        }
        if (i != null) {
            this.g(i);
            j = i;
        }
        return j;
    }
    
    protected final m e() {
        return this.c;
    }
    
    protected Object i(final E e) {
        u2.q<E> l;
        do {
            l = this.l();
            if (l == null) {
                return u2.b.c;
            }
        } while (l.e((Object)e, (o$b)null) == null);
        l.b((Object)e);
        return l.c();
    }
    
    protected void j(final o o) {
    }
    
    protected final u2.q<?> k(final E e) {
        final m c = this.c;
        o q;
        do {
            q = ((o)c).q();
            if (q instanceof u2.q) {
                return (u2.q<?>)q;
            }
        } while (!q.j((o)new a<Object>(e), (o)c));
        return null;
    }
    
    protected u2.q<E> l() {
        final m c = this.c;
        o o;
        while (true) {
            o = (o)((o)c).o();
            if (o == c || !(o instanceof u2.q)) {
                o = null;
                break;
            }
            if (((u2.q)o) instanceof j && !o.t()) {
                break;
            }
            final o v = o.v();
            if (v == null) {
                break;
            }
            v.s();
        }
        return (u2.q<E>)o;
    }
    
    protected final s m() {
        final m c = this.c;
        o o;
        while (true) {
            o = (o)((o)c).o();
            if (o == c || !(o instanceof s)) {
                o = null;
                break;
            }
            if (((s)o) instanceof j && !o.t()) {
                break;
            }
            final o v = o.v();
            if (v == null) {
                break;
            }
            v.s();
        }
        return (s)o;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(k0.a((Object)this));
        sb.append('@');
        sb.append(k0.b((Object)this));
        sb.append('{');
        sb.append(this.f());
        sb.append('}');
        sb.append(this.c());
        return sb.toString();
    }
    
    public static final class a<E> extends s
    {
        public final E h;
        
        public a(final E h) {
            this.h = h;
        }
        
        @Override
        public b0 A(final o$b o$b) {
            return s2.m.a;
        }
        
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("SendBuffered@");
            sb.append(k0.b((Object)this));
            sb.append('(');
            sb.append((Object)this.h);
            sb.append(')');
            return sb.toString();
        }
        
        @Override
        public void y() {
        }
        
        @Override
        public Object z() {
            return this.h;
        }
    }
}
