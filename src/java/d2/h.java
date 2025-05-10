package d2;

import java.util.Arrays;
import kotlin.jvm.internal.i;
import java.util.List;

class h extends g
{
    public static <T> List<T> b(final T[] array) {
        i.e((Object)array, "<this>");
        final List a = j.a((Object[])array);
        i.d((Object)a, "asList(this)");
        return (List<T>)a;
    }
    
    public static final <T> T[] c(final T[] array, final T[] array2, final int n, final int n2, final int n3) {
        i.e((Object)array, "<this>");
        i.e((Object)array2, "destination");
        System.arraycopy((Object)array, n2, (Object)array2, n, n3 - n2);
        return array2;
    }
    
    public static <T> void e(final T[] array, final T t, final int n, final int n2) {
        i.e((Object)array, "<this>");
        Arrays.fill((Object[])array, n, n2, (Object)t);
    }
}
