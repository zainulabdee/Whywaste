package s2;

import e2.g$c;
import e2.g;

public final class d2 extends c0
{
    public static final d2 g;
    
    static {
        g = new d2();
    }
    
    private d2() {
    }
    
    @Override
    public void p(final g g, final Runnable runnable) {
        final g2 g2 = (g2)g.b((g$c)s2.g2.g);
        if (g2 != null) {
            g2.f = true;
            return;
        }
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }
    
    @Override
    public String toString() {
        return "Dispatchers.Unconfined";
    }
    
    @Override
    public boolean v(final g g) {
        return false;
    }
}
