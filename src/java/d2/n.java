package d2;

import java.util.Collection;
import kotlin.jvm.internal.i;

class n extends m
{
    public static <T> int g(final Iterable<? extends T> iterable, int size) {
        i.e((Object)iterable, "<this>");
        if (iterable instanceof Collection) {
            size = ((Collection)iterable).size();
        }
        return size;
    }
}
