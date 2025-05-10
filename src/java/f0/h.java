package f0;

import w0.g;
import d0.l;

public class h
{
    private static final c0 a;
    
    static {
        a = (c0)new z();
    }
    
    public static <R extends l, T> g<T> a(final d0.h<R> h, final a<R, T> a) {
        final c0 a2 = h.a;
        final w0.h h2 = new w0.h();
        h.b((d0.h.a)new a0((d0.h)h, h2, (a)a, a2));
        return (g<T>)h2.a();
    }
    
    public static <R extends l> g<Void> b(final d0.h<R> h) {
        return a(h, (a<R, Void>)new b0());
    }
    
    public interface a<R extends l, T>
    {
        T a(final R p0);
    }
}
