package s2;

import e2.d;
import e2.g$c;
import e2.e;
import l2.p;
import e2.h;
import kotlin.jvm.internal.r;
import e2.g;

public final class b0
{
    private static final g a(g g, final g e, final boolean b) {
        final boolean c = c(g);
        final boolean c2 = c(e);
        if (!c && !c2) {
            return g.g(e);
        }
        final r r = new r();
        r.e = e;
        final h e2 = h.e;
        g = (g)g.t((Object)e2, (p)new b0$b(r, b));
        if (c2) {
            r.e = ((g)r.e).t((Object)e2, (p)b0$a.e);
        }
        return g.g((g)r.e);
    }
    
    public static final String b(final g g) {
        return null;
    }
    
    private static final boolean c(final g g) {
        return (boolean)g.t((Object)Boolean.FALSE, (p)b0$c.e);
    }
    
    public static final g d(final g0 g0, g g2) {
        g g3;
        g2 = (g3 = a(g0.d(), g2, true));
        if (g2 != t0.a()) {
            g3 = g2;
            if (g2.b((g$c)e.b) == null) {
                g3 = g2.g((g)t0.a());
            }
        }
        return g3;
    }
    
    public static final e2<?> e(kotlin.coroutines.jvm.internal.e e) {
        while (!(e instanceof p0)) {
            final Object callerFrame = e.getCallerFrame();
            if (callerFrame == null) {
                return null;
            }
            e = (kotlin.coroutines.jvm.internal.e)callerFrame;
            if (callerFrame instanceof e2) {
                return (e2<?>)callerFrame;
            }
        }
        return null;
    }
    
    public static final e2<?> f(final d<?> d, final g g, final Object o) {
        if (!(d instanceof kotlin.coroutines.jvm.internal.e)) {
            return null;
        }
        if (g.b((g$c)f2.e) == null) {
            return null;
        }
        final e2<?> e = e((kotlin.coroutines.jvm.internal.e)d);
        if (e != null) {
            e.F0(g, o);
        }
        return e;
    }
}
