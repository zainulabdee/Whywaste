package c2;

import kotlin.jvm.internal.i;

public final class l
{
    public static final Object a(final Throwable t) {
        i.e((Object)t, "exception");
        return new k.b(t);
    }
    
    public static final void b(final Object o) {
        if (!(o instanceof k.b)) {
            return;
        }
        throw ((k.b)o).e;
    }
}
