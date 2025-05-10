package z1;

import java.util.Map;
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
        Boolean a(final String p0, final Long p1);
        
        Map<String, Object> b(final String p0, final List<String> p1);
        
        Boolean c(final String p0, final String p1);
        
        Boolean d(final String p0, final List<String> p1);
        
        Boolean e(final String p0, final List<String> p1);
        
        Boolean f(final String p0, final Boolean p1);
        
        Boolean g(final String p0, final Double p1);
        
        Boolean remove(final String p0);
    }
}
