package d0;

import f0.i;

public final class a<O extends d>
{
    private final a.a$a<?, O> a;
    private final a.a$g<?> b;
    private final String c;
    
    public <C extends a.a$f> a(final String c, final a.a$a<C, O> a, final a.a$g<C> b) {
        i.j(a, "Cannot construct an Api with a null ClientBuilder");
        i.j(b, "Cannot construct an Api with a null ClientKey");
        this.c = c;
        this.a = a;
        this.b = b;
    }
    
    public final a.a$a<?, O> a() {
        return this.a;
    }
    
    public final c<?> b() {
        return (c<?>)this.b;
    }
    
    public final String c() {
        return this.c;
    }
    
    public interface b
    {
    }
    
    public static class c<C extends b>
    {
    }
    
    public interface d
    {
        public static final d.a$d$c a = new d.a$d$c((o)null);
    }
    
    public abstract static class e<T extends b, O>
    {
    }
}
