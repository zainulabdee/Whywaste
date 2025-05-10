package w2;

import kotlinx.coroutines.internal.z;
import s2.l1;
import l2.p;
import e2.g;

public final class e
{
    public static final void a(final c<?> c, final g g) {
        if (((Number)g.t((Object)0, (p)new e$a((c)c))).intValue() == c.g) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Flow invariant is violated:\n\t\tFlow was collected in ");
        sb.append((Object)c.f);
        sb.append(",\n\t\tbut emission happened in ");
        sb.append((Object)g);
        sb.append(".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead");
        throw new IllegalStateException(sb.toString().toString());
    }
    
    public static final l1 b(l1 d0, final l1 l1) {
        while (d0 != null) {
            if (d0 == l1) {
                return d0;
            }
            if (!(d0 instanceof z)) {
                return d0;
            }
            d0 = ((z)d0).D0();
        }
        return null;
    }
}
