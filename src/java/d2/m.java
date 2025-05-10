package d2;

import kotlin.jvm.internal.i;
import java.util.List;

class m extends l
{
    public static <T> List<T> b() {
        return (List<T>)w.e;
    }
    
    public static <T> int c(final List<? extends T> list) {
        i.e((Object)list, "<this>");
        return list.size() - 1;
    }
    
    public static <T> List<T> d(final T... array) {
        i.e((Object)array, "elements");
        List list;
        if (array.length > 0) {
            list = e.b((Object[])array);
        }
        else {
            list = k.b();
        }
        return (List<T>)list;
    }
    
    public static <T> List<T> e(List<? extends T> list) {
        i.e((Object)list, "<this>");
        final int size = list.size();
        if (size != 0) {
            if (size == 1) {
                list = k.a(list.get(0));
            }
        }
        else {
            list = k.b();
        }
        return (List<T>)list;
    }
    
    public static void f() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
