package h2;

import kotlin.jvm.internal.i;

public class a extends g2.a
{
    private final boolean c(final int n) {
        final Integer b = a.a$a.b;
        return b == null || b >= n;
    }
    
    public void a(final Throwable t, final Throwable t2) {
        i.e((Object)t, "cause");
        i.e((Object)t2, "exception");
        if (this.c(19)) {
            t.addSuppressed(t2);
        }
        else {
            super.a(t, t2);
        }
    }
}
