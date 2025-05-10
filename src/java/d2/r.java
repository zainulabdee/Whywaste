package d2;

import java.util.Iterator;
import kotlin.jvm.internal.i;
import java.util.Collection;

class r extends q
{
    public static <T> boolean h(final Collection<? super T> collection, final Iterable<? extends T> iterable) {
        i.e((Object)collection, "<this>");
        i.e((Object)iterable, "elements");
        if (iterable instanceof Collection) {
            return collection.addAll((Collection)iterable);
        }
        boolean b = false;
        final Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            if (collection.add(iterator.next())) {
                b = true;
            }
        }
        return b;
    }
}
