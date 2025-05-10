package s2;

import c2.q;
import l2.l;

final class i1 extends i
{
    private final l<Throwable, q> e;
    
    public i1(final l<? super Throwable, q> e) {
        this.e = (l<Throwable, q>)e;
    }
    
    @Override
    public void a(final Throwable t) {
        this.e.invoke((Object)t);
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("InvokeOnCancel[");
        sb.append(k0.a((Object)this.e));
        sb.append('@');
        sb.append(k0.b((Object)this));
        sb.append(']');
        return sb.toString();
    }
}
