package e2;

import kotlin.jvm.internal.i;
import l2.l;

public abstract class b<B extends g.b, E extends B> implements g$c<E>
{
    private final l<g.b, E> e;
    private final g$c<?> f;
    
    public b(final g$c<B> g$c, final l<? super g.b, ? extends E> e) {
        i.e((Object)g$c, "baseKey");
        i.e((Object)e, "safeCast");
        this.e = (l<g.b, E>)e;
        g$c<?> f = g$c;
        if (g$c instanceof b) {
            f = ((b)g$c).f;
        }
        this.f = f;
    }
    
    public final boolean a(final g$c<?> g$c) {
        i.e((Object)g$c, "key");
        return g$c == this || this.f == g$c;
    }
    
    public final E b(final g.b b) {
        i.e((Object)b, "element");
        return (E)this.e.invoke((Object)b);
    }
}
