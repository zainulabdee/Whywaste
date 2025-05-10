package e2;

import kotlin.jvm.internal.i;
import l2.p;

public interface g
{
     <E extends g$b> E b(final c<E> p0);
    
    g g(final g p0);
    
     <R> R t(final R p0, final p<? super R, ? super g$b, ? extends R> p1);
    
    g y(final c<?> p0);
    
    public static final class a
    {
        public static g a(g g, final g g2) {
            i.e((Object)g2, "context");
            if (g2 != h.e) {
                g = g2.t(g, (l2.p<? super g, ? super g$b, ? extends g>)g$a$a.e);
            }
            return g;
        }
    }
    
    public interface c<E extends g$b>
    {
    }
}
