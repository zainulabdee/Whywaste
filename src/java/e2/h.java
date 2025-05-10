package e2;

import l2.p;
import kotlin.jvm.internal.i;
import java.io.Serializable;

public final class h implements g, Serializable
{
    public static final h e;
    
    static {
        e = new h();
    }
    
    private h() {
    }
    
    public <E extends g.b> E b(final g$c<E> g$c) {
        i.e((Object)g$c, "key");
        return null;
    }
    
    public g g(final g g) {
        i.e((Object)g, "context");
        return g;
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    public <R> R t(final R r, final p<? super R, ? super g.b, ? extends R> p2) {
        i.e((Object)p2, "operation");
        return r;
    }
    
    @Override
    public String toString() {
        return "EmptyCoroutineContext";
    }
    
    public g y(final g$c<?> g$c) {
        i.e((Object)g$c, "key");
        return (g)this;
    }
}
