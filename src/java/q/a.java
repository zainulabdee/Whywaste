package q;

import android.os.Build$VERSION;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public abstract class a implements v
{
    private static final Set<a> c;
    private final String a;
    private final String b;
    
    static {
        c = (Set)new HashSet();
    }
    
    a(final String a, final String b) {
        this.a = a;
        this.b = b;
        q.a.c.add((Object)this);
    }
    
    public static Set<a> e() {
        return (Set<a>)Collections.unmodifiableSet((Set)a.c);
    }
    
    public String a() {
        return this.a;
    }
    
    public boolean b() {
        return this.c() || this.d();
    }
    
    public abstract boolean c();
    
    public boolean d() {
        return y2.a.b((Collection)q.a.a$a.a, this.b);
    }
    
    public static class b extends a
    {
        b(final String s, final String s2) {
            super(s, s2);
        }
        
        @Override
        public final boolean c() {
            return Build$VERSION.SDK_INT >= 23;
        }
    }
    
    public static class c extends a
    {
        c(final String s, final String s2) {
            super(s, s2);
        }
        
        @Override
        public final boolean c() {
            return Build$VERSION.SDK_INT >= 24;
        }
    }
    
    public static class d extends a
    {
        d(final String s, final String s2) {
            super(s, s2);
        }
        
        @Override
        public final boolean c() {
            return false;
        }
    }
    
    public static class e extends a
    {
        e(final String s, final String s2) {
            super(s, s2);
        }
        
        @Override
        public final boolean c() {
            return Build$VERSION.SDK_INT >= 26;
        }
    }
    
    public static class f extends a
    {
        f(final String s, final String s2) {
            super(s, s2);
        }
        
        @Override
        public final boolean c() {
            return Build$VERSION.SDK_INT >= 27;
        }
    }
    
    public static class g extends a
    {
        g(final String s, final String s2) {
            super(s, s2);
        }
        
        @Override
        public final boolean c() {
            return Build$VERSION.SDK_INT >= 28;
        }
    }
    
    public static class h extends a
    {
        h(final String s, final String s2) {
            super(s, s2);
        }
        
        @Override
        public final boolean c() {
            return Build$VERSION.SDK_INT >= 29;
        }
    }
    
    public static class i extends a
    {
        i(final String s, final String s2) {
            super(s, s2);
        }
        
        @Override
        public final boolean c() {
            return Build$VERSION.SDK_INT >= 33;
        }
    }
}
