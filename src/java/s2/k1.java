package s2;

import c2.q;
import l2.l;

final class k1 extends r1
{
    private final l<Throwable, q> i;
    
    public k1(final l<? super Throwable, q> i) {
        this.i = (l<Throwable, q>)i;
    }
    
    @Override
    public void y(final Throwable t) {
        this.i.invoke((Object)t);
    }
}
