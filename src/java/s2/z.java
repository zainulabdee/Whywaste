package s2;

import kotlin.jvm.internal.e;
import c2.q;
import c2.k$a;
import c2.l;
import c2.k;
import e2.d;

public final class z
{
    public static final <T> Object a(Object o, final d<? super T> d) {
        if (o instanceof v) {
            final k$a e = k.e;
            o = k.a(l.a(((v)o).a));
        }
        else {
            o = k.a(o);
        }
        return o;
    }
    
    public static final <T> Object b(final Object o, final l2.l<? super Throwable, q> l) {
        final Throwable b = k.b(o);
        Object o2;
        if (b == null) {
            o2 = o;
            if (l != null) {
                o2 = new w(o, l);
            }
        }
        else {
            o2 = new v(b, false, 2, null);
        }
        return o2;
    }
    
    public static final <T> Object c(Object o, final s2.k<?> k) {
        final Throwable b = k.b(o);
        if (b != null) {
            o = new v(b, false, 2, null);
        }
        return o;
    }
}
