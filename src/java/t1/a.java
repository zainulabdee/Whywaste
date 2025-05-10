package t1;

import java.nio.ByteBuffer;

public final class a<T>
{
    private final c a;
    private final String b;
    private final i<T> c;
    private final c.c d;
    
    public a(final c c, final String s, final i<T> i) {
        this(c, s, i, null);
    }
    
    public a(final c a, final String b, final i<T> c, final c.c d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public void c(final T t) {
        this.d(t, null);
    }
    
    public void d(final T t, final e<T> e) {
        final c a = this.a;
        final String b = this.b;
        final ByteBuffer a2 = this.c.a(t);
        Object o = null;
        if (e != null) {
            o = new a.a$c(this, (e)e, (a$a)null);
        }
        a.b(b, a2, (c.b)o);
    }
    
    public void e(final d<T> d) {
        final c.c d2 = this.d;
        final c.a a = null;
        final c.a a2 = null;
        if (d2 != null) {
            final c a3 = this.a;
            final String b = this.b;
            Object o;
            if (d == null) {
                o = a2;
            }
            else {
                o = new a.a$b(this, (d)d, (a$a)null);
            }
            a3.c(b, (c.a)o, this.d);
        }
        else {
            final c a4 = this.a;
            final String b2 = this.b;
            Object o2;
            if (d == null) {
                o2 = a;
            }
            else {
                o2 = new a.a$b(this, (d)d, (a$a)null);
            }
            a4.g(b2, (c.a)o2);
        }
    }
    
    public interface d<T>
    {
        void a(final T p0, final e<T> p1);
    }
    
    public interface e<T>
    {
        void a(final T p0);
    }
}
