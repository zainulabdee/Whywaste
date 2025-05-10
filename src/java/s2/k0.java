package s2;

import c2.k$a;
import c2.l;
import c2.k;
import kotlinx.coroutines.internal.f;
import e2.d;

public final class k0
{
    public static final String a(final Object o) {
        return o.getClass().getSimpleName();
    }
    
    public static final String b(final Object o) {
        return Integer.toHexString(System.identityHashCode(o));
    }
    
    public static final String c(final d<?> d) {
        String string;
        if (d instanceof f) {
            string = d.toString();
        }
        else {
            Object o = null;
            try {
                final k$a e = k.e;
                final StringBuilder sb = new StringBuilder();
                sb.append((Object)d);
                sb.append('@');
                sb.append(b(d));
                k.a((Object)sb.toString());
            }
            finally {
                final k$a e2 = k.e;
                final Throwable t;
                o = k.a(l.a(t));
            }
            if (k.b(o) != null) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(d.getClass().getName());
                sb2.append('@');
                sb2.append(b(d));
                o = sb2.toString();
            }
            string = (String)o;
        }
        return string;
    }
}
