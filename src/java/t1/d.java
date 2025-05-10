package t1;

public final class d
{
    private final c a;
    private final String b;
    private final l c;
    private final c.c d;
    
    public d(final c c, final String s) {
        this(c, s, (l)s.b);
    }
    
    public d(final c c, final String s, final l l) {
        this(c, s, l, null);
    }
    
    public d(final c a, final String b, final l c, final c.c d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public void d(final d d) {
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
                o = new d$c(this, d);
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
                o2 = new d$c(this, d);
            }
            a4.g(b2, (c.a)o2);
        }
    }
    
    public interface b
    {
        void a(final Object p0);
    }
    
    public interface d
    {
        void a(final Object p0);
        
        void c(final Object p0, final b p1);
    }
}
