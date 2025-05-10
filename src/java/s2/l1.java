package s2;

import e2.g$c;
import java.util.concurrent.CancellationException;
import c2.q;
import l2.l;
import e2.g$b;

public interface l1 extends g$b
{
    public static final b d = b.e;
    
    boolean a();
    
    u0 i(final boolean p0, final boolean p1, final l<? super Throwable, q> p2);
    
    CancellationException n();
    
    s2.q o(final s p0);
    
    void r(final CancellationException p0);
    
    boolean start();
    
    public static final class b implements g$c<l1>
    {
        static final b e;
        
        static {
            e = new b();
        }
        
        private b() {
        }
    }
}
