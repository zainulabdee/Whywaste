package s2;

import kotlinx.coroutines.internal.t;
import kotlinx.coroutines.internal.c0;

public final class m0
{
    private static final boolean a;
    private static final n0 b;
    
    static {
        a = c0.e("kotlinx.coroutines.main.delay", false);
        b = b();
    }
    
    public static final n0 a() {
        return m0.b;
    }
    
    private static final n0 b() {
        if (!m0.a) {
            return (n0)l0.l;
        }
        final v1 c = t0.c();
        Object l;
        if (!t.c(c) && c instanceof n0) {
            l = c;
        }
        else {
            l = l0.l;
        }
        return (n0)l;
    }
}
