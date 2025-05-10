package d2;

import java.util.NoSuchElementException;

class i extends h
{
    public static <T> T g(final T[] array) {
        kotlin.jvm.internal.i.e((Object)array, "<this>");
        if (array.length != 0) {
            return array[0];
        }
        throw new NoSuchElementException("Array is empty.");
    }
    
    public static final <T> int h(final T[] array) {
        kotlin.jvm.internal.i.e((Object)array, "<this>");
        return array.length - 1;
    }
    
    public static char i(final char[] array) {
        kotlin.jvm.internal.i.e((Object)array, "<this>");
        final int length = array.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return array[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }
    
    public static <T> T j(final T[] array) {
        kotlin.jvm.internal.i.e((Object)array, "<this>");
        T t;
        if (array.length == 1) {
            t = array[0];
        }
        else {
            t = null;
        }
        return t;
    }
}
