package io.sentry.util;

public final class p
{
    private static boolean a;
    static boolean b;
    
    static {
        try {
            p.a = "The Android Project".equals((Object)System.getProperty("java.vendor"));
        }
        finally {
            p.a = false;
        }
        try {
            final String property = System.getProperty("java.specification.version");
            if (property != null) {
                p.b = (Double.valueOf(property) >= 9.0);
            }
        }
        finally {
            p.b = false;
        }
    }
    
    public static boolean a() {
        return p.b;
    }
    
    public static boolean b() {
        return p.a ^ true;
    }
}
