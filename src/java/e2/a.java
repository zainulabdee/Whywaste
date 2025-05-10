package e2;

import l2.p;
import kotlin.jvm.internal.i;

public abstract class a implements g$b
{
    private final g$c<?> e;
    
    public a(final g$c<?> e) {
        i.e((Object)e, "key");
        this.e = e;
    }
    
    public <E extends g$b> E b(final g$c<E> g$c) {
        return (E)g$b$a.b((g$b)this, (g$c)g$c);
    }
    
    public g g(final g g) {
        return g$b$a.d((g$b)this, g);
    }
    
    public g$c<?> getKey() {
        return this.e;
    }
    
    public <R> R t(final R r, final p<? super R, ? super g$b, ? extends R> p2) {
        return (R)g$b$a.a((g$b)this, (Object)r, (p)p2);
    }
    
    public g y(final g$c<?> g$c) {
        return g$b$a.c((g$b)this, (g$c)g$c);
    }
}
