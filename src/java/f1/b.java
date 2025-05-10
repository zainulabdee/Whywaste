package f1;

import android.util.Log;

public class b
{
    public static void a(final String s, final String s2) {
    }
    
    public static void b(final String s, final String s2) {
        Log.e(s, s2);
    }
    
    public static void c(final String s, final String s2, final Throwable t) {
        Log.e(s, s2, t);
    }
    
    public static String d(final Throwable t) {
        return Log.getStackTraceString(t);
    }
    
    public static void e(final String s, final String s2) {
    }
    
    public static void f(final String s, final String s2) {
    }
    
    public static void g(final String s, final String s2) {
        Log.w(s, s2);
    }
    
    public static void h(final String s, final String s2, final Throwable t) {
        Log.w(s, s2, t);
    }
}
