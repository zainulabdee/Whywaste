package s2;

import l2.l;
import l2.p;
import e2.g$c;
import e2.g;
import e2.d;

public abstract class a<T> extends s1 implements d<T>, g0
{
    private final g f;
    
    public a(final g g, final boolean b, final boolean b2) {
        super(b2);
        if (b) {
            this.Y((l1)g.b((g$c)l1.d));
        }
        this.f = g.g((g)this);
    }
    
    protected void A0(final Throwable t, final boolean b) {
    }
    
    protected void B0(final T t) {
    }
    
    public final <R> void C0(final i0 i0, final R r, final p<? super R, ? super d<? super T>, ?> p3) {
        i0.e((p)p3, (Object)r, (d)this);
    }
    
    @Override
    protected String I() {
        final StringBuilder sb = new StringBuilder();
        sb.append(k0.a((Object)this));
        sb.append(" was cancelled");
        return sb.toString();
    }
    
    @Override
    public final void X(final Throwable t) {
        f0.a(this.f, t);
    }
    
    @Override
    public boolean a() {
        return super.a();
    }
    
    public g d() {
        return this.f;
    }
    
    @Override
    public String e0() {
        final String b = b0.b(this.f);
        if (b == null) {
            return super.e0();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append('\"');
        sb.append(b);
        sb.append("\":");
        sb.append(super.e0());
        return sb.toString();
    }
    
    public final g getContext() {
        return this.f;
    }
    
    @Override
    protected final void j0(final Object o) {
        if (o instanceof v) {
            final v v = (v)o;
            this.A0(v.a, v.a());
        }
        else {
            this.B0(o);
        }
    }
    
    public final void resumeWith(Object c0) {
        c0 = this.c0(z.d(c0, (l)null, 1, (Object)null));
        if (c0 == t1.b) {
            return;
        }
        this.z0(c0);
    }
    
    protected void z0(final Object o) {
        this.D(o);
    }
}
