package s2;

import kotlinx.coroutines.internal.b0;

public final class t1
{
    private static final b0 a;
    public static final b0 b;
    private static final b0 c;
    private static final b0 d;
    private static final b0 e;
    private static final v0 f;
    private static final v0 g;
    
    static {
        a = new b0("COMPLETING_ALREADY");
        b = new b0("COMPLETING_WAITING_CHILDREN");
        c = new b0("COMPLETING_RETRY");
        d = new b0("TOO_LATE_TO_CANCEL");
        e = new b0("SEALED");
        f = new v0(false);
        g = new v0(true);
    }
    
    public static final Object g(final Object o) {
        Object o2 = o;
        if (o instanceof g1) {
            o2 = new h1((g1)o);
        }
        return o2;
    }
}
