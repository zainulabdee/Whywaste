package io.sentry.util;

public final class q
{
    public static boolean a(final Double n) {
        return b(n, true);
    }
    
    private static boolean b(final Double n, final boolean b) {
        if (n == null) {
            return b;
        }
        return !n.isNaN() && n >= 0.0 && n <= 1.0;
    }
    
    public static boolean c(final Double n) {
        return b(n, true);
    }
    
    public static boolean d(final Double n) {
        return e(n, true);
    }
    
    public static boolean e(final Double n, final boolean b) {
        return b(n, b);
    }
}
