package s2;

import java.util.concurrent.CancellationException;
import e2.g$c;
import kotlinx.coroutines.internal.b0;
import androidx.concurrent.futures.b;
import c2.q;
import kotlinx.coroutines.internal.f;
import e2.g;
import e2.d;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.jvm.internal.e;

public class l<T> extends q0<T> implements k<T>, e
{
    private static final AtomicIntegerFieldUpdater k;
    private static final AtomicReferenceFieldUpdater l;
    private volatile int _decision;
    private volatile Object _state;
    private final d<T> h;
    private final g i;
    private u0 j;
    
    static {
        k = AtomicIntegerFieldUpdater.newUpdater((Class)l.class, "_decision");
        l = AtomicReferenceFieldUpdater.newUpdater((Class)l.class, (Class)Object.class, "_state");
    }
    
    public l(final d<? super T> h, final int n) {
        super(n);
        this.h = (d<T>)h;
        this.i = h.getContext();
        this._decision = 0;
        this._state = s2.d.e;
    }
    
    private final boolean A() {
        return r0.c(super.g) && ((f)this.h).m();
    }
    
    private final i B(final l2.l<? super Throwable, q> l) {
        i i;
        if (l instanceof i) {
            i = (i)l;
        }
        else {
            i = new i1(l);
        }
        return i;
    }
    
    private final void C(final l2.l<? super Throwable, q> l, final Object o) {
        final StringBuilder sb = new StringBuilder();
        sb.append("It's prohibited to register multiple handlers, tried to register ");
        sb.append((Object)l);
        sb.append(", already has ");
        sb.append(o);
        throw new IllegalStateException(sb.toString().toString());
    }
    
    private final void F() {
        final d<T> h = this.h;
        f f;
        if (h instanceof f) {
            f = (f)h;
        }
        else {
            f = null;
        }
        if (f != null) {
            final Throwable q = f.q((k)this);
            if (q != null) {
                this.q();
                this.n(q);
            }
        }
    }
    
    private final void H(final Object o, final int n, final l2.l<? super Throwable, q> l) {
        Object state;
        do {
            state = this._state;
            if (state instanceof y1) {
                continue;
            }
            if (state instanceof o) {
                final o o2 = (o)state;
                if (o2.c()) {
                    if (l != null) {
                        this.m(l, o2.a);
                    }
                    return;
                }
            }
            this.i(o);
            throw new c2.d();
        } while (!b.a(l.l, (Object)this, state, this.J((y1)state, o, n, l, null)));
        this.r();
        this.s(n);
    }
    
    static /* synthetic */ void I(final l l, final Object o, final int n, l2.l i, final int n2, final Object o2) {
        if (o2 == null) {
            if ((n2 & 0x4) != 0x0) {
                i = null;
            }
            l.H(o, n, i);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
    }
    
    private final Object J(final y1 y1, final Object o, final int n, final l2.l<? super Throwable, q> l, final Object o2) {
        Object o3;
        if (o instanceof v) {
            o3 = o;
        }
        else if (!r0.b(n) && o2 == null) {
            o3 = o;
        }
        else {
            if (l == null && (!(y1 instanceof i) || y1 instanceof s2.e)) {
                o3 = o;
                if (o2 == null) {
                    return o3;
                }
            }
            i i;
            if (y1 instanceof i) {
                i = (i)y1;
            }
            else {
                i = null;
            }
            o3 = new u(o, i, (l2.l)l, o2, (Throwable)null, 16, (kotlin.jvm.internal.e)null);
        }
        return o3;
    }
    
    private final boolean K() {
        do {
            final int decision = this._decision;
            if (decision != 0) {
                if (decision == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!s2.l.k.compareAndSet((Object)this, 0, 2));
        return true;
    }
    
    private final b0 L(final Object o, final Object o2, final l2.l<? super Throwable, q> l) {
        Object state;
        do {
            state = this._state;
            if (state instanceof y1) {
                continue;
            }
            final boolean b = state instanceof u;
            b0 a;
            final b0 b2 = a = null;
            if (b) {
                a = b2;
                if (o2 != null) {
                    a = b2;
                    if (((u)state).d == o2) {
                        a = m.a;
                    }
                }
            }
            return a;
        } while (!b.a(l.l, (Object)this, state, this.J((y1)state, o, super.g, l, o2)));
        this.r();
        return m.a;
    }
    
    private final boolean M() {
        do {
            final int decision = this._decision;
            if (decision != 0) {
                if (decision == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!s2.l.k.compareAndSet((Object)this, 0, 1));
        return true;
    }
    
    private final Void i(final Object o) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Already resumed, but proposed with update ");
        sb.append(o);
        throw new IllegalStateException(sb.toString().toString());
    }
    
    private final void j(final l2.l<? super Throwable, q> l, final Throwable t) {
        try {
            l.invoke((Object)t);
        }
        finally {
            final g context = this.getContext();
            final StringBuilder sb = new StringBuilder();
            sb.append("Exception in invokeOnCancellation handler for ");
            sb.append((Object)this);
            final Throwable t2;
            f0.a(context, (Throwable)new y(sb.toString(), t2));
        }
    }
    
    private final boolean o(final Throwable t) {
        return this.A() && ((f)this.h).n(t);
    }
    
    private final void r() {
        if (!this.A()) {
            this.q();
        }
    }
    
    private final void s(final int n) {
        if (this.K()) {
            return;
        }
        r0.a((q0)this, n);
    }
    
    private final String y() {
        final Object w = this.w();
        String s;
        if (w instanceof y1) {
            s = "Active";
        }
        else if (w instanceof o) {
            s = "Cancelled";
        }
        else {
            s = "Completed";
        }
        return s;
    }
    
    private final u0 z() {
        final l1 l1 = (l1)this.getContext().b((g$c)s2.l1.d);
        if (l1 == null) {
            return null;
        }
        return this.j = l1$a.d(l1, true, false, (l2.l)new p(this), 2, (Object)null);
    }
    
    protected String D() {
        return "CancellableContinuation";
    }
    
    public final void E(final Throwable t) {
        if (this.o(t)) {
            return;
        }
        this.n(t);
        this.r();
    }
    
    public final boolean G() {
        final Object state = this._state;
        if (state instanceof u && ((u)state).d != null) {
            this.q();
            return false;
        }
        this._decision = 0;
        this._state = s2.d.e;
        return true;
    }
    
    @Override
    public void a(Object state, final Throwable t) {
        while (true) {
            state = this._state;
            if (state instanceof y1) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (state instanceof v) {
                return;
            }
            if (state instanceof u) {
                final u u = (u)state;
                if (!(u.c() ^ true)) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (b.a(s2.l.l, (Object)this, state, (Object)s2.u.b(u, (Object)null, (i)null, (l2.l)null, (Object)null, t, 15, (Object)null))) {
                    u.d(this, t);
                    return;
                }
                continue;
            }
            else {
                if (b.a(s2.l.l, (Object)this, state, (Object)new u(state, (i)null, (l2.l)null, (Object)null, t, 14, (kotlin.jvm.internal.e)null))) {
                    return;
                }
                continue;
            }
        }
    }
    
    @Override
    public final d<T> b() {
        return this.h;
    }
    
    @Override
    public Object c(final T t, final Object o) {
        return this.L(t, o, null);
    }
    
    @Override
    public Throwable d(final Object o) {
        Throwable d = super.d(o);
        if (d == null) {
            d = null;
        }
        return d;
    }
    
    @Override
    public Object e(final T t, final Object o, final l2.l<? super Throwable, q> l) {
        return this.L(t, o, l);
    }
    
    @Override
    public <T> T f(final Object o) {
        Object a = o;
        if (o instanceof u) {
            a = ((u)o).a;
        }
        return (T)a;
    }
    
    public e getCallerFrame() {
        final d<T> h = this.h;
        e e;
        if (h instanceof e) {
            e = (e)h;
        }
        else {
            e = null;
        }
        return e;
    }
    
    public g getContext() {
        return this.i;
    }
    
    @Override
    public Object h() {
        return this.w();
    }
    
    @Override
    public void k(final l2.l<? super Throwable, q> l) {
        final i b = this.B(l);
        while (true) {
            final Object state = this._state;
            if (state instanceof s2.d) {
                if (androidx.concurrent.futures.b.a(l.l, (Object)this, state, (Object)b)) {
                    return;
                }
                continue;
            }
            else if (state instanceof i) {
                this.C(l, state);
            }
            else {
                final boolean b2 = state instanceof v;
                if (b2) {
                    v v = (v)state;
                    if (!v.b()) {
                        this.C(l, state);
                    }
                    if (state instanceof o) {
                        Throwable a = null;
                        if (!b2) {
                            v = null;
                        }
                        if (v != null) {
                            a = v.a;
                        }
                        this.j(l, a);
                    }
                    return;
                }
                if (state instanceof u) {
                    final u u = (u)state;
                    if (u.b != null) {
                        this.C(l, state);
                    }
                    if (b instanceof s2.e) {
                        return;
                    }
                    if (u.c()) {
                        this.j(l, u.e);
                        return;
                    }
                    if (androidx.concurrent.futures.b.a(l.l, (Object)this, state, (Object)s2.u.b(u, (Object)null, b, (l2.l)null, (Object)null, (Throwable)null, 29, (Object)null))) {
                        return;
                    }
                    continue;
                }
                else {
                    if (b instanceof s2.e) {
                        return;
                    }
                    if (androidx.concurrent.futures.b.a(l.l, (Object)this, state, (Object)new u(state, b, (l2.l)null, (Object)null, (Throwable)null, 28, (kotlin.jvm.internal.e)null))) {
                        return;
                    }
                    continue;
                }
            }
        }
    }
    
    public final void l(final i i, final Throwable t) {
        try {
            i.a(t);
        }
        finally {
            final g context = this.getContext();
            final StringBuilder sb = new StringBuilder();
            sb.append("Exception in invokeOnCancellation handler for ");
            sb.append((Object)this);
            final Throwable t2;
            f0.a(context, (Throwable)new y(sb.toString(), t2));
        }
    }
    
    public final void m(final l2.l<? super Throwable, q> l, final Throwable t) {
        try {
            l.invoke((Object)t);
        }
        finally {
            final g context = this.getContext();
            final StringBuilder sb = new StringBuilder();
            sb.append("Exception in resume onCancellation handler for ");
            sb.append((Object)this);
            final Throwable t2;
            f0.a(context, (Throwable)new y(sb.toString(), t2));
        }
    }
    
    public boolean n(final Throwable t) {
        Object state;
        boolean b;
        do {
            state = this._state;
            if (!(state instanceof y1)) {
                return false;
            }
            b = (state instanceof i);
        } while (!androidx.concurrent.futures.b.a(s2.l.l, (Object)this, state, (Object)new o((d<?>)this, t, b)));
        i i;
        if (b) {
            i = (i)state;
        }
        else {
            i = null;
        }
        if (i != null) {
            this.l(i, t);
        }
        this.r();
        this.s(super.g);
        return true;
    }
    
    @Override
    public void p(final T t, final l2.l<? super Throwable, q> l) {
        this.H(t, super.g, l);
    }
    
    public final void q() {
        final u0 j = this.j;
        if (j == null) {
            return;
        }
        j.d();
        this.j = (u0)x1.e;
    }
    
    public void resumeWith(final Object o) {
        I(this, z.c(o, (k)this), super.g, null, 4, null);
    }
    
    public Throwable t(final l1 l1) {
        return (Throwable)l1.n();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.D());
        sb.append('(');
        sb.append(k0.c((d)this.h));
        sb.append("){");
        sb.append(this.y());
        sb.append("}@");
        sb.append(k0.b((Object)this));
        return sb.toString();
    }
    
    public final Object u() {
        final boolean a = this.A();
        if (this.M()) {
            if (this.j == null) {
                this.z();
            }
            if (a) {
                this.F();
            }
            return f2.b.c();
        }
        if (a) {
            this.F();
        }
        final Object w = this.w();
        if (!(w instanceof v)) {
            if (r0.b(super.g)) {
                final l1 l1 = (l1)this.getContext().b((g$c)s2.l1.d);
                if (l1 != null) {
                    if (!l1.a()) {
                        final CancellationException n = l1.n();
                        this.a(w, (Throwable)n);
                        throw n;
                    }
                }
            }
            return this.f(w);
        }
        throw ((v)w).a;
    }
    
    @Override
    public Object v(final Throwable t) {
        return this.L(new v(t, false, 2, (kotlin.jvm.internal.e)null), null, null);
    }
    
    public final Object w() {
        return this._state;
    }
    
    @Override
    public void x(final Object o) {
        this.s(super.g);
    }
}
