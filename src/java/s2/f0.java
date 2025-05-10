package s2;

import c2.a;
import e2.g$c;
import e2.g;

public final class f0
{
    public static final void a(final g g, final Throwable t) {
        try {
            final d0 d0 = (d0)g.b((g$c)s2.d0.c);
            if (d0 != null) {
                d0.q(g, t);
                return;
            }
            e0.a(g, t);
        }
        finally {
            final Throwable t2;
            e0.a(g, b(t, t2));
        }
    }
    
    public static final Throwable b(final Throwable t, final Throwable t2) {
        if (t == t2) {
            return t;
        }
        final RuntimeException ex = new RuntimeException("Exception while trying to handle coroutine exception", t2);
        a.a((Throwable)ex, t);
        return (Throwable)ex;
    }
}
