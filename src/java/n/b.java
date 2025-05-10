package n;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import android.os.Trace;
import java.lang.reflect.Method;

public final class b
{
    private static long a;
    private static Method b;
    private static Method c;
    private static Method d;
    
    public static void a(final String s, final int n) {
        while (true) {
            try {
                if (n.b.c == null) {
                    f.a(s, n);
                    return;
                }
                b(s, n);
            }
            catch (final NoSuchMethodError | NoClassDefFoundError noSuchMethodError | NoClassDefFoundError) {
                continue;
            }
            break;
        }
    }
    
    private static void b(final String s, final int n) {
        try {
            if (n.b.c == null) {
                n.b.c = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            n.b.c.invoke((Object)null, new Object[] { n.b.a, s, n });
        }
        catch (final Exception ex) {
            g("asyncTraceBegin", ex);
        }
    }
    
    public static void c(final String s) {
        n.c.a(s);
    }
    
    public static void d(final String s, final int n) {
        while (true) {
            try {
                if (n.b.d == null) {
                    f.b(s, n);
                    return;
                }
                e(s, n);
            }
            catch (final NoSuchMethodError | NoClassDefFoundError noSuchMethodError | NoClassDefFoundError) {
                continue;
            }
            break;
        }
    }
    
    private static void e(final String s, final int n) {
        try {
            if (n.b.d == null) {
                n.b.d = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            n.b.d.invoke((Object)null, new Object[] { n.b.a, s, n });
        }
        catch (final Exception ex) {
            g("asyncTraceEnd", ex);
        }
    }
    
    public static void f() {
        n.c.b();
    }
    
    private static void g(final String s, final Exception ex) {
        if (!(ex instanceof InvocationTargetException)) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unable to call ");
            sb.append(s);
            sb.append(" via reflection");
            Log.v("Trace", sb.toString(), (Throwable)ex);
            return;
        }
        final Throwable cause = ((Throwable)ex).getCause();
        if (cause instanceof RuntimeException) {
            throw (RuntimeException)cause;
        }
        throw new RuntimeException(cause);
    }
    
    public static boolean h() {
        try {
            if (n.b.b == null) {
                return n.a.a();
            }
            return i();
        }
        catch (final NoSuchMethodError | NoClassDefFoundError noSuchMethodError | NoClassDefFoundError) {
            return i();
        }
    }
    
    private static boolean i() {
        try {
            if (n.b.b == null) {
                n.b.a = Trace.class.getField("TRACE_TAG_APP").getLong((Object)null);
                n.b.b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return (boolean)n.b.b.invoke((Object)null, new Object[] { n.b.a });
        }
        catch (final Exception ex) {
            g("isTagEnabled", ex);
            return false;
        }
    }
}
