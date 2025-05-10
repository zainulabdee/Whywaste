package q2;

import java.util.ArrayList;
import d2.k;
import java.util.List;
import java.util.Iterator;
import java.util.Collection;
import kotlin.jvm.internal.i;
import l2.l;

class h extends g
{
    public static <T, R> b<R> c(final b<? extends T> b, final l<? super T, ? extends R> l) {
        i.e((Object)b, "<this>");
        i.e((Object)l, "transform");
        return (b<R>)new q2.i(b, (l2.l<? super Object, ?>)l);
    }
    
    public static final <T, C extends Collection<? super T>> C d(final b<? extends T> b, final C c) {
        i.e((Object)b, "<this>");
        i.e((Object)c, "destination");
        final Iterator iterator = b.iterator();
        while (iterator.hasNext()) {
            c.add(iterator.next());
        }
        return c;
    }
    
    public static <T> List<T> e(final b<? extends T> b) {
        i.e((Object)b, "<this>");
        return (List<T>)k.e((List)f((q2.b<?>)b));
    }
    
    public static final <T> List<T> f(final b<? extends T> b) {
        i.e((Object)b, "<this>");
        return (List<T>)d((q2.b<?>)b, (List)new ArrayList());
    }
}
