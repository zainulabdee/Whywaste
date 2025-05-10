package io.sentry.util;

import java.util.Arrays;

public final class n
{
    public static boolean a(final Object o, final Object obj) {
        return o == obj || (o != null && o.equals(obj));
    }
    
    public static int b(final Object... array) {
        return Arrays.hashCode(array);
    }
    
    public static <T> T c(final T t, final String s) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(s);
    }
}
