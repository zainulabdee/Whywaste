package b2;

import n.b;

public final class f
{
    public static void a(final String s) {
        b.c(c(s));
    }
    
    public static void b(final String s, final int n) {
        b.a(c(s), n);
    }
    
    private static String c(String string) {
        if (string.length() >= 124) {
            final StringBuilder sb = new StringBuilder();
            sb.append(string.substring(0, 124));
            sb.append("...");
            string = sb.toString();
        }
        return string;
    }
    
    public static void d() {
        b.f();
    }
    
    public static void e(final String s, final int n) {
        b.d(c(s), n);
    }
}
