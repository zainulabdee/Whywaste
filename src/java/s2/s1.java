package s2;

import java.util.ArrayList;
import l2.p;
import e2.g;
import e2.g$b;
import e2.g$c;
import kotlinx.coroutines.internal.w;
import kotlin.jvm.internal.i;
import l2.l;
import androidx.concurrent.futures.b;
import kotlin.jvm.internal.e;
import java.util.Iterator;
import java.util.Set;
import c2.a;
import java.util.concurrent.CancellationException;
import java.util.Map;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.o;
import kotlinx.coroutines.internal.o$a;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class s1 implements l1, s, z1
{
    private static final AtomicReferenceFieldUpdater e;
    private volatile Object _parentHandle;
    private volatile Object _state;
    
    static {
        e = AtomicReferenceFieldUpdater.newUpdater((Class)s1.class, (Class)Object.class, "_state");
    }
    
    public s1(final boolean b) {
        v0 state;
        if (b) {
            state = t1.c();
        }
        else {
            state = t1.d();
        }
        this._state = state;
        this._parentHandle = null;
    }
    
    private final boolean B(final Object o, final w1 w1, final r1 r1) {
        final o$a o$a = new o$a(r1, this, o) {
            final s1 d;
            final Object e;
            
            public Object i(final o o) {
                Object a;
                if (this.d.V() == this.e) {
                    a = null;
                }
                else {
                    a = n.a();
                }
                return a;
            }
        };
        boolean b;
        while (true) {
            final int x = ((o)w1).q().x((o)r1, (o)w1, (o$a)o$a);
            b = true;
            if (x == 1) {
                break;
            }
            if (x != 2) {
                continue;
            }
            b = false;
            break;
        }
        return b;
    }
    
    private final void C(final Throwable t, final List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        final Set setFromMap = Collections.newSetFromMap((Map)new IdentityHashMap(list.size()));
        for (final Throwable t2 : list) {
            if (t2 != t && t2 != t && !(t2 instanceof CancellationException) && setFromMap.add((Object)t2)) {
                c2.a.a(t, t2);
            }
        }
    }
    
    private final Object G(final Object o) {
        Object w0;
        do {
            final Object v = this.V();
            if (!(v instanceof g1) || (v instanceof b && ((b)v).g())) {
                return t1.a();
            }
            w0 = this.w0(v, new v(this.M(o), false, 2, (e)null));
        } while (w0 == t1.b());
        return w0;
    }
    
    private final boolean H(final Throwable t) {
        final boolean a0 = this.a0();
        final boolean b = true;
        if (a0) {
            return true;
        }
        final boolean b2 = t instanceof CancellationException;
        final q u = this.U();
        if (u != null && u != x1.e) {
            boolean b3 = b;
            if (!u.g(t)) {
                b3 = (b2 && b);
            }
            return b3;
        }
        return b2;
    }
    
    private final void K(final g1 g1, Object o) {
        final q u = this.U();
        if (u != null) {
            ((u0)u).d();
            this.o0(x1.e);
        }
        final boolean b = o instanceof v;
        Throwable a = null;
        v v;
        if (b) {
            v = (v)o;
        }
        else {
            v = null;
        }
        if (v != null) {
            a = v.a;
        }
        if (g1 instanceof r1) {
            try {
                ((r1)g1).y(a);
            }
            finally {
                o = new StringBuilder();
                ((StringBuilder)o).append("Exception in completion handler ");
                ((StringBuilder)o).append((Object)g1);
                ((StringBuilder)o).append(" for ");
                ((StringBuilder)o).append((Object)this);
                final Throwable t;
                this.X((Throwable)new y(((StringBuilder)o).toString(), t));
            }
        }
        else {
            final w1 h = g1.h();
            if (h != null) {
                this.h0(h, a);
            }
        }
    }
    
    private final void L(final b b, r f0, final Object o) {
        f0 = this.f0(f0);
        if (f0 != null && this.y0(b, f0, o)) {
            return;
        }
        this.D(this.N(b, o));
    }
    
    private final Throwable M(Object l) {
        if (l == null || l instanceof Throwable) {
            if ((l = l) == null) {
                l = new m1(this.I(), (Throwable)null, (l1)this);
            }
        }
        else {
            if (l == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            }
            l = ((z1)l).l();
        }
        return (Throwable)l;
    }
    
    private final Object N(final b b, Object o) {
        v v;
        if (o instanceof v) {
            v = (v)o;
        }
        else {
            v = null;
        }
        Throwable a;
        if (v != null) {
            a = v.a;
        }
        else {
            a = null;
        }
        synchronized (b) {
            final boolean f = b.f();
            final List<Throwable> j = b.j(a);
            final Throwable q = this.Q(b, j);
            if (q != null) {
                this.C(q, j);
            }
            monitorexit(b);
            boolean b2 = false;
            if (q != null) {
                if (q != a) {
                    o = new v(q, false, 2, (e)null);
                }
            }
            if (q != null) {
                if (this.H(q) || this.W(q)) {
                    b2 = true;
                }
                if (b2) {
                    if (o == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    }
                    ((v)o).b();
                }
            }
            if (!f) {
                this.i0(q);
            }
            this.j0(o);
            b.a(s1.e, (Object)this, (Object)b, t1.g(o));
            this.K((g1)b, o);
            return o;
        }
    }
    
    private final r O(final g1 g1) {
        final boolean b = g1 instanceof r;
        final r r = null;
        r r2;
        if (b) {
            r2 = (r)g1;
        }
        else {
            r2 = null;
        }
        r f0;
        if (r2 == null) {
            final w1 h = g1.h();
            f0 = r;
            if (h != null) {
                f0 = this.f0((o)h);
            }
        }
        else {
            f0 = r2;
        }
        return f0;
    }
    
    private final Throwable P(final Object o) {
        final boolean b = o instanceof v;
        Throwable a = null;
        v v;
        if (b) {
            v = (v)o;
        }
        else {
            v = null;
        }
        if (v != null) {
            a = v.a;
        }
        return a;
    }
    
    private final Throwable Q(final b b, final List<? extends Throwable> list) {
        final boolean empty = list.isEmpty();
        final Throwable t = null;
        if (empty) {
            if (b.f()) {
                return (Throwable)new m1(this.I(), (Throwable)null, (l1)this);
            }
            return null;
        }
        else {
            final Iterator iterator = ((Iterable)list).iterator();
            Object next;
            do {
                next = t;
                if (!iterator.hasNext()) {
                    break;
                }
                next = iterator.next();
            } while (!(((Throwable)next) instanceof CancellationException ^ true));
            final Throwable t2 = (Throwable)next;
            if (t2 != null) {
                return t2;
            }
            return (Throwable)list.get(0);
        }
    }
    
    private final w1 T(final g1 g1) {
        w1 h;
        if ((h = g1.h()) == null) {
            if (g1 instanceof v0) {
                h = new w1();
            }
            else {
                if (!(g1 instanceof r1)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("State should have list: ");
                    sb.append((Object)g1);
                    throw new IllegalStateException(sb.toString().toString());
                }
                this.m0((r1)g1);
                h = null;
            }
        }
        return h;
    }
    
    private final Object b0(Object o) {
        final Throwable t = null;
        Throwable t2 = null;
        while (true) {
            final Object v = this.V();
            if (v instanceof b) {
                synchronized (v) {
                    if (((b)v).i()) {
                        return t1.f();
                    }
                    final boolean f = ((b)v).f();
                    if (o != null || !f) {
                        Throwable m;
                        if ((m = t2) == null) {
                            m = this.M(o);
                        }
                        ((b)v).b(m);
                    }
                    final Throwable e = ((b)v).e();
                    Throwable t3 = t;
                    if (f ^ true) {
                        t3 = e;
                    }
                    monitorexit(v);
                    if (t3 != null) {
                        this.g0(((b)v).h(), t3);
                    }
                    return t1.a();
                }
            }
            if (!(v instanceof g1)) {
                return t1.f();
            }
            Throwable i;
            if ((i = t2) == null) {
                i = this.M(o);
            }
            final g1 g1 = (g1)v;
            if (g1.a()) {
                t2 = i;
                if (this.v0(g1, i)) {
                    return t1.a();
                }
                continue;
            }
            else {
                final Object w0 = this.w0(v, new v(i, false, 2, (e)null));
                if (w0 == t1.a()) {
                    o = new StringBuilder();
                    ((StringBuilder)o).append("Cannot happen in ");
                    ((StringBuilder)o).append(v);
                    throw new IllegalStateException(((StringBuilder)o).toString().toString());
                }
                t2 = i;
                if (w0 != t1.b()) {
                    return w0;
                }
                continue;
            }
        }
    }
    
    private final r1 d0(final l<? super Throwable, c2.q> l, final boolean b) {
        r1 r1 = null;
        n1 n1 = null;
        if (b) {
            if (l instanceof n1) {
                n1 = (n1)l;
            }
            if ((r1 = n1) == null) {
                r1 = new j1(l);
            }
        }
        else {
            if (l instanceof r1) {
                r1 = (r1)l;
            }
            if (r1 == null) {
                r1 = new k1(l);
            }
        }
        r1.A(this);
        return r1;
    }
    
    private final r f0(o q) {
        o p;
        while (true) {
            p = q;
            if (!q.t()) {
                break;
            }
            q = q.q();
        }
        while (true) {
            q = (p = p.p());
            if (!q.t()) {
                if (q instanceof r) {
                    return (r)q;
                }
                p = q;
                if (q instanceof w1) {
                    return null;
                }
                continue;
            }
        }
    }
    
    private final void g0(final w1 w1, final Throwable t) {
        this.i0(t);
        o p2 = (o)((o)w1).o();
        x x = null;
        while (!i.a((Object)p2, (Object)w1)) {
            Object o = x;
            if (p2 instanceof n1) {
                x x2 = (r1)p2;
                try {
                    x2.y(t);
                    x2 = x;
                }
                finally {
                    if (x != null) {
                        final Throwable t2;
                        c2.a.a((Throwable)x, t2);
                        o = x;
                    }
                    else {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Exception in completion handler ");
                        sb.append((Object)x2);
                        sb.append(" for ");
                        sb.append((Object)this);
                        final Throwable t2;
                        o = new y(sb.toString(), t2);
                        final c2.q a = c2.q.a;
                    }
                }
            }
            p2 = p2.p();
            x = (x)o;
        }
        if (x != null) {
            this.X((Throwable)x);
        }
        this.H(t);
    }
    
    private final void h0(final w1 w1, final Throwable t) {
        o p2 = (o)((o)w1).o();
        Throwable t2 = null;
        while (!i.a((Object)p2, (Object)w1)) {
            Object o = t2;
            if (p2 instanceof r1) {
                final r1 r1 = (r1)p2;
                try {
                    r1.y(t);
                }
                finally {
                    if (t2 != null) {
                        final Throwable t3;
                        c2.a.a(t2, t3);
                        o = t2;
                    }
                    else {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Exception in completion handler ");
                        sb.append((Object)r1);
                        sb.append(" for ");
                        sb.append((Object)this);
                        final Throwable t3;
                        o = new y(sb.toString(), t3);
                        final c2.q a = c2.q.a;
                    }
                }
            }
            p2 = p2.p();
            t2 = (Throwable)o;
        }
        if (t2 != null) {
            this.X(t2);
        }
    }
    
    private final void l0(final v0 v0) {
        Object o = new w1();
        if (!v0.a()) {
            o = new f1((w1)o);
        }
        androidx.concurrent.futures.b.a(s1.e, (Object)this, (Object)v0, o);
    }
    
    private final void m0(final r1 r1) {
        r1.k((o)new w1());
        androidx.concurrent.futures.b.a(s1.e, (Object)this, (Object)r1, (Object)r1.p());
    }
    
    private final int p0(final Object o) {
        if (o instanceof v0) {
            if (((v0)o).a()) {
                return 0;
            }
            if (!androidx.concurrent.futures.b.a(s1.e, (Object)this, o, (Object)t1.c())) {
                return -1;
            }
            this.k0();
            return 1;
        }
        else {
            if (!(o instanceof f1)) {
                return 0;
            }
            if (!androidx.concurrent.futures.b.a(s1.e, (Object)this, o, (Object)((f1)o).h())) {
                return -1;
            }
            this.k0();
            return 1;
        }
    }
    
    private final String q0(final Object o) {
        final boolean b = o instanceof b;
        final String s = "Active";
        String s2;
        if (b) {
            final b b2 = (b)o;
            if (b2.f()) {
                s2 = "Cancelling";
            }
            else {
                s2 = s;
                if (b2.g()) {
                    s2 = "Completing";
                }
            }
        }
        else if (o instanceof g1) {
            if (((g1)o).a()) {
                s2 = s;
            }
            else {
                s2 = "New";
            }
        }
        else if (o instanceof v) {
            s2 = "Cancelled";
        }
        else {
            s2 = "Completed";
        }
        return s2;
    }
    
    public static /* synthetic */ CancellationException s0(final s1 s1, final Throwable t, String s2, final int n, final Object o) {
        if (o == null) {
            if ((n & 0x1) != 0x0) {
                s2 = null;
            }
            return s1.r0(t, s2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
    }
    
    private final boolean u0(final g1 g1, final Object o) {
        if (!androidx.concurrent.futures.b.a(s1.e, (Object)this, (Object)g1, t1.g(o))) {
            return false;
        }
        this.i0(null);
        this.j0(o);
        this.K(g1, o);
        return true;
    }
    
    private final boolean v0(final g1 g1, final Throwable t) {
        final w1 t2 = this.T(g1);
        if (t2 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.b.a(s1.e, (Object)this, (Object)g1, (Object)new b(t2, false, t))) {
            return false;
        }
        this.g0(t2, t);
        return true;
    }
    
    private final Object w0(final Object o, final Object o2) {
        if (!(o instanceof g1)) {
            return t1.a();
        }
        if ((!(o instanceof v0) && !(o instanceof r1)) || o instanceof r || o2 instanceof v) {
            return this.x0((g1)o, o2);
        }
        if (this.u0((g1)o, o2)) {
            return o2;
        }
        return t1.b();
    }
    
    private final Object x0(final g1 g1, final Object o) {
        final w1 t = this.T(g1);
        if (t == null) {
            return t1.b();
        }
        final boolean b = g1 instanceof b;
        final Throwable t2 = null;
        b b2;
        if (b) {
            b2 = (b)g1;
        }
        else {
            b2 = null;
        }
        boolean b3 = false;
        b b4 = b2;
        if (b2 == null) {
            b4 = new b(t, false, null);
        }
        final kotlin.jvm.internal.r r = new kotlin.jvm.internal.r();
        synchronized (b4) {
            if (b4.g()) {
                return t1.a();
            }
            b4.k(true);
            if (b4 != g1 && !androidx.concurrent.futures.b.a(s1.e, (Object)this, (Object)g1, (Object)b4)) {
                return t1.b();
            }
            final boolean f = b4.f();
            v v;
            if (o instanceof v) {
                v = (v)o;
            }
            else {
                v = null;
            }
            if (v != null) {
                b4.b(v.a);
            }
            final Throwable e = b4.e();
            if (!f) {
                b3 = true;
            }
            Throwable e2 = t2;
            if ((boolean)b3) {
                e2 = e;
            }
            r.e = e2;
            final c2.q a = c2.q.a;
            monitorexit(b4);
            final Throwable t3 = e2;
            if (e2 != null) {
                this.g0(t, e2);
            }
            final r o2 = this.O(g1);
            if (o2 != null && this.y0(b4, o2, o)) {
                return t1.b;
            }
            return this.N(b4, o);
        }
    }
    
    private final boolean y0(final b b, r f0, final Object o) {
        while (l1$a.d((l1)f0.i, false, false, (l)new a(this, b, f0, o), 1, (Object)null) == x1.e) {
            if ((f0 = this.f0(f0)) == null) {
                return false;
            }
        }
        return true;
    }
    
    protected void D(final Object o) {
    }
    
    public final boolean E(final Object o) {
        Object o2 = t1.a();
        final boolean s = this.S();
        boolean b = true;
        if (s && (o2 = this.G(o)) == t1.b) {
            return true;
        }
        Object b2;
        if ((b2 = o2) == t1.a()) {
            b2 = this.b0(o);
        }
        if (b2 != t1.a()) {
            if (b2 != t1.b) {
                if (b2 == t1.f()) {
                    b = false;
                }
                else {
                    this.D(b2);
                }
            }
        }
        return b;
    }
    
    public void F(final Throwable t) {
        this.E(t);
    }
    
    protected String I() {
        return "Job was cancelled";
    }
    
    public boolean J(final Throwable t) {
        final boolean b = t instanceof CancellationException;
        boolean b2 = true;
        if (b) {
            return true;
        }
        if (!this.E(t) || !this.R()) {
            b2 = false;
        }
        return b2;
    }
    
    public boolean R() {
        return true;
    }
    
    public boolean S() {
        return false;
    }
    
    public final q U() {
        return (q)this._parentHandle;
    }
    
    public final Object V() {
        Object state;
        while (true) {
            state = this._state;
            if (!(state instanceof w)) {
                break;
            }
            ((w)state).c((Object)this);
        }
        return state;
    }
    
    protected boolean W(final Throwable t) {
        return false;
    }
    
    public void X(final Throwable t) {
        throw t;
    }
    
    protected final void Y(final l1 l1) {
        if (l1 == null) {
            this.o0(x1.e);
            return;
        }
        l1.start();
        final q o = l1.o(this);
        this.o0(o);
        if (this.Z()) {
            ((u0)o).d();
            this.o0(x1.e);
        }
    }
    
    public final boolean Z() {
        return this.V() instanceof g1 ^ true;
    }
    
    @Override
    public boolean a() {
        final Object v = this.V();
        return v instanceof g1 && ((g1)v).a();
    }
    
    protected boolean a0() {
        return false;
    }
    
    public <E extends g$b> E b(final g$c<E> g$c) {
        return (E)l1$a.c((l1)this, (g$c)g$c);
    }
    
    public final Object c0(final Object o) {
        Object w0;
        do {
            w0 = this.w0(this.V(), o);
            if (w0 != t1.a()) {
                continue;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Job ");
            sb.append((Object)this);
            sb.append(" is already complete or completing, but is being completed with ");
            sb.append(o);
            throw new IllegalStateException(sb.toString(), this.P(o));
        } while (w0 == t1.b());
        return w0;
    }
    
    public String e0() {
        return k0.a((Object)this);
    }
    
    public g g(final g g) {
        return l1$a.f((l1)this, g);
    }
    
    public final g$c<?> getKey() {
        return (g$c<?>)l1.d;
    }
    
    @Override
    public final u0 i(final boolean b, final boolean b2, final l<? super Throwable, c2.q> l) {
        final r1 d0 = this.d0(l, b);
        while (true) {
            final Object v = this.V();
            if (v instanceof v0) {
                final v0 v2 = (v0)v;
                if (v2.a()) {
                    if (b.a(s1.e, (Object)this, v, (Object)d0)) {
                        return (u0)d0;
                    }
                    continue;
                }
                else {
                    this.l0(v2);
                }
            }
            else {
                final boolean b3 = v instanceof g1;
                Object a = null;
                final Object o = null;
                if (!b3) {
                    if (b2) {
                        v v3;
                        if (v instanceof v) {
                            v3 = (v)v;
                        }
                        else {
                            v3 = null;
                        }
                        if (v3 != null) {
                            a = v3.a;
                        }
                        l.invoke(a);
                    }
                    return (u0)x1.e;
                }
                final w1 h = ((g1)v).h();
                if (h == null) {
                    if (v == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    }
                    this.m0((r1)v);
                }
                else {
                    final x1 e = x1.e;
                    Object e2 = o;
                    u0 u0 = (u0)e;
                    if (b) {
                        e2 = o;
                        u0 = (u0)e;
                        if (v instanceof b) {
                            synchronized (v) {
                                e2 = ((b)v).e();
                                Label_0244: {
                                    if (e2 != null) {
                                        u0 = (u0)e;
                                        if (!(l instanceof r)) {
                                            break Label_0244;
                                        }
                                        u0 = (u0)e;
                                        if (((b)v).g()) {
                                            break Label_0244;
                                        }
                                    }
                                    if (!this.B(v, h, d0)) {
                                        continue;
                                    }
                                    if (e2 == null) {
                                        return (u0)d0;
                                    }
                                    u0 = (u0)d0;
                                }
                                final c2.q a2 = c2.q.a;
                            }
                        }
                    }
                    if (e2 != null) {
                        if (b2) {
                            l.invoke(e2);
                        }
                        return u0;
                    }
                    if (this.B(v, h, d0)) {
                        return (u0)d0;
                    }
                    continue;
                }
            }
        }
    }
    
    protected void i0(final Throwable t) {
    }
    
    protected void j0(final Object o) {
    }
    
    protected void k0() {
    }
    
    @Override
    public CancellationException l() {
        final Object v = this.V();
        final boolean b = v instanceof b;
        CancellationException ex = null;
        Throwable t;
        if (b) {
            t = ((b)v).e();
        }
        else if (v instanceof v) {
            t = ((v)v).a;
        }
        else {
            if (v instanceof g1) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Cannot be cancelling child in this state: ");
                sb.append(v);
                throw new IllegalStateException(sb.toString().toString());
            }
            t = null;
        }
        if (t instanceof CancellationException) {
            ex = (CancellationException)t;
        }
        Object o;
        if ((o = ex) == null) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Parent job is ");
            sb2.append(this.q0(v));
            o = new m1(sb2.toString(), t, (l1)this);
        }
        return (CancellationException)o;
    }
    
    @Override
    public final CancellationException n() {
        final Object v = this.V();
        if (v instanceof b) {
            final Throwable e = ((b)v).e();
            if (e != null) {
                final StringBuilder sb = new StringBuilder();
                sb.append(k0.a((Object)this));
                sb.append(" is cancelling");
                final Object o = this.r0(e, sb.toString());
                if (o != null) {
                    return (CancellationException)o;
                }
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Job is still new or active: ");
            sb2.append((Object)this);
            throw new IllegalStateException(sb2.toString().toString());
        }
        if (v instanceof g1) {
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Job is still new or active: ");
            sb3.append((Object)this);
            throw new IllegalStateException(sb3.toString().toString());
        }
        Object o;
        if (v instanceof v) {
            o = s0(this, ((v)v).a, null, 1, null);
        }
        else {
            final StringBuilder sb4 = new StringBuilder();
            sb4.append(k0.a((Object)this));
            sb4.append(" has completed normally");
            o = new m1(sb4.toString(), (Throwable)null, (l1)this);
        }
        return (CancellationException)o;
    }
    
    public final void n0(final r1 r1) {
        Object v;
        do {
            v = this.V();
            if (!(v instanceof r1)) {
                if (v instanceof g1 && ((g1)v).h() != null) {
                    r1.u();
                }
                return;
            }
            if (v != r1) {
                return;
            }
        } while (!androidx.concurrent.futures.b.a(s1.e, (Object)this, v, (Object)t1.c()));
    }
    
    @Override
    public final q o(final s s) {
        return (q)l1$a.d((l1)this, true, false, (l)new r(s), 2, (Object)null);
    }
    
    public final void o0(final q parentHandle) {
        this._parentHandle = parentHandle;
    }
    
    @Override
    public void r(final CancellationException ex) {
        Object o = ex;
        if (ex == null) {
            o = new m1(this.I(), (Throwable)null, (l1)this);
        }
        this.F((Throwable)o);
    }
    
    protected final CancellationException r0(final Throwable t, final String s) {
        CancellationException ex;
        if (t instanceof CancellationException) {
            ex = (CancellationException)t;
        }
        else {
            ex = null;
        }
        Object o = ex;
        if (ex == null) {
            String z;
            if ((z = s) == null) {
                z = this.I();
            }
            o = new m1(z, t, (l1)this);
        }
        return (CancellationException)o;
    }
    
    @Override
    public final boolean start() {
        while (true) {
            final int p0 = this.p0(this.V());
            if (p0 == 0) {
                return false;
            }
            if (p0 != 1) {
                continue;
            }
            return true;
        }
    }
    
    public <R> R t(final R r, final p<? super R, ? super g$b, ? extends R> p2) {
        return (R)l1$a.b((l1)this, (Object)r, (p)p2);
    }
    
    public final String t0() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.e0());
        sb.append('{');
        sb.append(this.q0(this.V()));
        sb.append('}');
        return sb.toString();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.t0());
        sb.append('@');
        sb.append(k0.b((Object)this));
        return sb.toString();
    }
    
    @Override
    public final void u(final z1 z1) {
        this.E(z1);
    }
    
    public g y(final g$c<?> g$c) {
        return l1$a.e((l1)this, (g$c)g$c);
    }
    
    private static final class a extends r1
    {
        private final s1 i;
        private final b j;
        private final r k;
        private final Object l;
        
        public a(final s1 i, final b j, final r k, final Object l) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.l = l;
        }
        
        @Override
        public void y(final Throwable t) {
            this.i.L(this.j, this.k, this.l);
        }
    }
    
    private static final class b implements g1
    {
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;
        private volatile Object _rootCause;
        private final w1 e;
        
        public b(final w1 e, final boolean isCompleting, final Throwable rootCause) {
            this.e = e;
            this._isCompleting = (isCompleting ? 1 : 0);
            this._rootCause = rootCause;
            this._exceptionsHolder = null;
        }
        
        private final ArrayList<Throwable> c() {
            return (ArrayList<Throwable>)new ArrayList(4);
        }
        
        private final Object d() {
            return this._exceptionsHolder;
        }
        
        private final void l(final Object exceptionsHolder) {
            this._exceptionsHolder = exceptionsHolder;
        }
        
        public boolean a() {
            return this.e() == null;
        }
        
        public final void b(final Throwable t) {
            final Throwable e = this.e();
            if (e == null) {
                this.m(t);
                return;
            }
            if (t == e) {
                return;
            }
            final Object d = this.d();
            if (d == null) {
                this.l(t);
            }
            else if (d instanceof Throwable) {
                if (t == d) {
                    return;
                }
                final ArrayList<Throwable> c = this.c();
                c.add(d);
                c.add((Object)t);
                this.l(c);
            }
            else {
                if (!(d instanceof ArrayList)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("State is ");
                    sb.append(d);
                    throw new IllegalStateException(sb.toString().toString());
                }
                ((ArrayList)d).add((Object)t);
            }
        }
        
        public final Throwable e() {
            return (Throwable)this._rootCause;
        }
        
        public final boolean f() {
            return this.e() != null;
        }
        
        public final boolean g() {
            return this._isCompleting != 0;
        }
        
        public w1 h() {
            return this.e;
        }
        
        public final boolean i() {
            return this.d() == t1.e();
        }
        
        public final List<Throwable> j(final Throwable t) {
            final Object d = this.d();
            ArrayList list;
            if (d == null) {
                list = this.c();
            }
            else if (d instanceof Throwable) {
                list = this.c();
                list.add(d);
            }
            else {
                if (!(d instanceof ArrayList)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("State is ");
                    sb.append(d);
                    throw new IllegalStateException(sb.toString().toString());
                }
                list = (ArrayList)d;
            }
            final Throwable e = this.e();
            if (e != null) {
                list.add(0, (Object)e);
            }
            if (t != null && !i.a((Object)t, (Object)e)) {
                list.add((Object)t);
            }
            this.l(t1.e());
            return (List<Throwable>)list;
        }
        
        public final void k(final boolean isCompleting) {
            this._isCompleting = (isCompleting ? 1 : 0);
        }
        
        public final void m(final Throwable rootCause) {
            this._rootCause = rootCause;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Finishing[cancelling=");
            sb.append(this.f());
            sb.append(", completing=");
            sb.append(this.g());
            sb.append(", rootCause=");
            sb.append((Object)this.e());
            sb.append(", exceptions=");
            sb.append(this.d());
            sb.append(", list=");
            sb.append((Object)this.h());
            sb.append(']');
            return sb.toString();
        }
    }
}
