package y1;

import java.util.List;
import android.util.Log;
import java.util.ArrayList;

public class a
{
    protected static ArrayList<Object> a(final Throwable t) {
        final ArrayList list = new ArrayList(3);
        if (t instanceof a) {
            final a a = (a)t;
            list.add((Object)a.e);
            list.add((Object)((Throwable)a).getMessage());
            list.add(a.f);
        }
        else {
            list.add((Object)t.toString());
            list.add((Object)t.getClass().getSimpleName());
            final StringBuilder sb = new StringBuilder();
            sb.append("Cause: ");
            sb.append((Object)t.getCause());
            sb.append(", Stacktrace: ");
            sb.append(Log.getStackTraceString(t));
            list.add((Object)sb.toString());
        }
        return (ArrayList<Object>)list;
    }
    
    public static class a extends RuntimeException
    {
        public final String e;
        public final Object f;
    }
    
    public interface b
    {
        List<String> a(final c p0);
        
        String b();
        
        String c();
        
        List<String> d();
        
        String e();
        
        String f();
    }
    
    public enum c
    {
        f(0), 
        g(1), 
        h(2), 
        i(3), 
        j(4), 
        k(5), 
        l(6), 
        m(7), 
        n(8), 
        o(9), 
        p(10);
        
        private static final c[] q;
        final int e;
        
        static {
            q = d();
        }
        
        private c(final int e) {
            this.e = e;
        }
        
        private static /* synthetic */ c[] d() {
            return new c[] { c.f, c.g, c.h, c.i, c.j, c.k, c.l, c.m, c.n, c.o, c.p };
        }
    }
}
