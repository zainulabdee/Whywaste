package x1;

import java.util.List;
import android.util.Log;
import java.util.ArrayList;

public class n
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
        void b(final List<String> p0, final e<Boolean> p1);
        
        void c(final e<g> p0);
        
        void d(final d p0);
        
        void e(final e<Void> p0);
        
        Boolean f();
        
        void g(final String p0, final Boolean p1, final e<String> p2);
        
        void h(final e<g> p0);
        
        void i(final String p0, final e<Void> p1);
        
        void j(final e<Void> p0);
    }
    
    public static final class d
    {
        private List<String> a;
        private f b;
        private String c;
        private String d;
        private String e;
        private Boolean f;
        
        d() {
        }
        
        static d a(final ArrayList<Object> list) {
            final d d = new d();
            d.k((List<String>)list.get(0));
            final Object value = list.get(1);
            f f;
            if (value == null) {
                f = null;
            }
            else {
                f = n.f.values()[(int)value];
            }
            d.m(f);
            d.j((String)list.get(2));
            d.h((String)list.get(3));
            d.l((String)list.get(4));
            d.i((Boolean)list.get(5));
            return d;
        }
        
        public String b() {
            return this.d;
        }
        
        public Boolean c() {
            return this.f;
        }
        
        public String d() {
            return this.c;
        }
        
        public List<String> e() {
            return this.a;
        }
        
        public String f() {
            return this.e;
        }
        
        public f g() {
            return this.b;
        }
        
        public void h(final String d) {
            this.d = d;
        }
        
        public void i(final Boolean f) {
            if (f != null) {
                this.f = f;
                return;
            }
            throw new IllegalStateException("Nonnull field \"forceCodeForRefreshToken\" is null.");
        }
        
        public void j(final String c) {
            this.c = c;
        }
        
        public void k(final List<String> a) {
            if (a != null) {
                this.a = a;
                return;
            }
            throw new IllegalStateException("Nonnull field \"scopes\" is null.");
        }
        
        public void l(final String e) {
            this.e = e;
        }
        
        public void m(final f b) {
            if (b != null) {
                this.b = b;
                return;
            }
            throw new IllegalStateException("Nonnull field \"signInType\" is null.");
        }
        
        ArrayList<Object> n() {
            final ArrayList list = new ArrayList(6);
            list.add((Object)this.a);
            final f b = this.b;
            Object value;
            if (b == null) {
                value = null;
            }
            else {
                value = b.e;
            }
            list.add(value);
            list.add((Object)this.c);
            list.add((Object)this.d);
            list.add((Object)this.e);
            list.add((Object)this.f);
            return (ArrayList<Object>)list;
        }
    }
    
    public interface e<T>
    {
        void a(final T p0);
        
        void b(final Throwable p0);
    }
    
    public enum f
    {
        f(0), 
        g(1);
        
        private static final f[] h;
        final int e;
        
        static {
            h = d();
        }
        
        private f(final int e) {
            this.e = e;
        }
        
        private static /* synthetic */ f[] d() {
            return new f[] { f.f, f.g };
        }
    }
    
    public static final class g
    {
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        
        g() {
        }
        
        static g a(final ArrayList<Object> list) {
            final g g = new g();
            g.b((String)list.get(0));
            g.c((String)list.get(1));
            g.d((String)list.get(2));
            g.f((String)list.get(3));
            g.e((String)list.get(4));
            g.g((String)list.get(5));
            return g;
        }
        
        public void b(final String a) {
            this.a = a;
        }
        
        public void c(final String b) {
            if (b != null) {
                this.b = b;
                return;
            }
            throw new IllegalStateException("Nonnull field \"email\" is null.");
        }
        
        public void d(final String c) {
            if (c != null) {
                this.c = c;
                return;
            }
            throw new IllegalStateException("Nonnull field \"id\" is null.");
        }
        
        public void e(final String e) {
            this.e = e;
        }
        
        public void f(final String d) {
            this.d = d;
        }
        
        public void g(final String f) {
            this.f = f;
        }
        
        ArrayList<Object> h() {
            final ArrayList list = new ArrayList(6);
            list.add((Object)this.a);
            list.add((Object)this.b);
            list.add((Object)this.c);
            list.add((Object)this.d);
            list.add((Object)this.e);
            list.add((Object)this.f);
            return (ArrayList<Object>)list;
        }
        
        public static final class a
        {
            private String a;
            private String b;
            private String c;
            private String d;
            private String e;
            private String f;
            
            public g a() {
                final g g = new g();
                g.b(this.a);
                g.c(this.b);
                g.d(this.c);
                g.f(this.d);
                g.e(this.e);
                g.g(this.f);
                return g;
            }
            
            public a b(final String a) {
                this.a = a;
                return this;
            }
            
            public a c(final String b) {
                this.b = b;
                return this;
            }
            
            public a d(final String c) {
                this.c = c;
                return this;
            }
            
            public a e(final String e) {
                this.e = e;
                return this;
            }
            
            public a f(final String d) {
                this.d = d;
                return this;
            }
            
            public a g(final String f) {
                this.f = f;
                return this;
            }
        }
    }
}
