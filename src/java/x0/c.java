package x0;

import java.util.logging.Logger;

final class c
{
    private static final Logger a;
    private static final b b;
    
    static {
        a = Logger.getLogger(c.class.getName());
        b = b();
    }
    
    private c() {
    }
    
    static String a(final String s) {
        String s2 = s;
        if (c(s)) {
            s2 = null;
        }
        return s2;
    }
    
    private static b b() {
        return (b)new c.c$b((c$a)null);
    }
    
    static boolean c(final String s) {
        return s == null || s.isEmpty();
    }
}
