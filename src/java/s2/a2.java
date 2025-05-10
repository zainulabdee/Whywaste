package s2;

import e2.g;
import c2.q;

class a2 extends a<q>
{
    public a2(final g g, final boolean b) {
        super(g, true, b);
    }
    
    @Override
    protected boolean W(final Throwable t) {
        f0.a(this.getContext(), t);
        return true;
    }
}
