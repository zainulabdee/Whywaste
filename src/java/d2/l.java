package d2;

import kotlin.jvm.internal.i;
import java.util.Collections;
import java.util.List;

class l
{
    public static <T> List<T> a(final T t) {
        final List singletonList = Collections.singletonList((Object)t);
        i.d((Object)singletonList, "singletonList(element)");
        return (List<T>)singletonList;
    }
}
