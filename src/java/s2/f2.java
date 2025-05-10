package s2;

import l2.p;
import e2.g;
import e2.g$b$a;
import e2.g$c;
import e2.g$b;

final class f2 implements g$b, g$c<f2>
{
    public static final f2 e;
    
    static {
        e = new f2();
    }
    
    private f2() {
    }
    
    public <E extends g$b> E b(final g$c<E> g$c) {
        return (E)g$b$a.b((g$b)this, (g$c)g$c);
    }
    
    public g g(final g g) {
        return g$b$a.d((g$b)this, g);
    }
    
    public g$c<?> getKey() {
        return (g$c<?>)this;
    }
    
    public <R> R t(final R r, final p<? super R, ? super g$b, ? extends R> p2) {
        return (R)g$b$a.a((g$b)this, (Object)r, (p)p2);
    }
    
    public g y(final g$c<?> g$c) {
        return g$b$a.c((g$b)this, (g$c)g$c);
    }
}
