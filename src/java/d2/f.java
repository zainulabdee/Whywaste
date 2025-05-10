package d2;

import java.lang.reflect.Array;
import kotlin.jvm.internal.i;

class f
{
    public static final <T> T[] a(final T[] array, final int n) {
        i.e((Object)array, "reference");
        final Object instance = Array.newInstance((Class)array.getClass().getComponentType(), n);
        i.c(instance, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.arrayOfNulls>");
        return (T[])instance;
    }
}
