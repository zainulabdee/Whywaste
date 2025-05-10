package d2;

import kotlin.jvm.internal.i;
import java.util.Collections;
import java.util.Set;

class h0
{
    public static final <T> Set<T> a(final T t) {
        final Set singleton = Collections.singleton((Object)t);
        i.d((Object)singleton, "singleton(element)");
        return (Set<T>)singleton;
    }
}
