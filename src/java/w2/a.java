package w2;

import l2.p;
import e2.g$b;
import e2.g$c;
import e2.g;

public final class a implements g
{
    public final Throwable e;
    private final g f;
    
    public a(final Throwable e, final g f) {
        this.e = e;
        this.f = f;
    }
    
    public <E extends g$b> E b(final g$c<E> g$c) {
        return (E)this.f.b((g$c)g$c);
    }
    
    public g g(final g g) {
        return this.f.g(g);
    }
    
    public <R> R t(final R r, final p<? super R, ? super g$b, ? extends R> p2) {
        return (R)this.f.t((Object)r, (p)p2);
    }
    
    public g y(final g$c<?> g$c) {
        return this.f.y((g$c)g$c);
    }
}
