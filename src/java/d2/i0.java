package d2;

import kotlin.jvm.internal.i;
import java.util.Set;

class i0 extends h0
{
    public static <T> Set<T> b() {
        return (Set<T>)y.e;
    }
    
    public static final <T> Set<T> c(Set<? extends T> set) {
        i.e((Object)set, "<this>");
        final int size = set.size();
        if (size != 0) {
            if (size == 1) {
                set = h0.a(set.iterator().next());
            }
        }
        else {
            set = g0.b();
        }
        return (Set<T>)set;
    }
}
