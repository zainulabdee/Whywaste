package s2;

public final class c2
{
    public static final c2 a;
    private static final ThreadLocal<w0> b;
    
    static {
        a = new c2();
        b = new ThreadLocal();
    }
    
    private c2() {
    }
    
    public final w0 a() {
        final ThreadLocal<w0> b = c2.b;
        w0 a;
        if ((a = (w0)b.get()) == null) {
            a = z0.a();
            b.set((Object)a);
        }
        return a;
    }
    
    public final void b() {
        c2.b.set((Object)null);
    }
    
    public final void c(final w0 w0) {
        c2.b.set((Object)w0);
    }
}
