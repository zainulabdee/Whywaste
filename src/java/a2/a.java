package a2;

import java.util.Map;
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
        
        public a(final String e, final String s, final Object f) {
            super(s);
            this.e = e;
            this.f = f;
        }
    }
    
    public interface b
    {
        Boolean a(final String p0);
        
        void b();
        
        Boolean c(final String p0, final Map<String, String> p1);
        
        Boolean d(final String p0, final d p1);
    }
    
    public static final class d
    {
        private Boolean a;
        private Boolean b;
        private Map<String, String> c;
        
        d() {
        }
        
        static d a(final ArrayList<Object> list) {
            final d d = new d();
            d.f((Boolean)list.get(0));
            d.e((Boolean)list.get(1));
            d.g((Map<String, String>)list.get(2));
            return d;
        }
        
        public Boolean b() {
            return this.b;
        }
        
        public Boolean c() {
            return this.a;
        }
        
        public Map<String, String> d() {
            return this.c;
        }
        
        public void e(final Boolean b) {
            if (b != null) {
                this.b = b;
                return;
            }
            throw new IllegalStateException("Nonnull field \"enableDomStorage\" is null.");
        }
        
        public void f(final Boolean a) {
            if (a != null) {
                this.a = a;
                return;
            }
            throw new IllegalStateException("Nonnull field \"enableJavaScript\" is null.");
        }
        
        public void g(final Map<String, String> c) {
            if (c != null) {
                this.c = c;
                return;
            }
            throw new IllegalStateException("Nonnull field \"headers\" is null.");
        }
        
        ArrayList<Object> h() {
            final ArrayList list = new ArrayList(3);
            list.add((Object)this.a);
            list.add((Object)this.b);
            list.add((Object)this.c);
            return (ArrayList<Object>)list;
        }
    }
}
