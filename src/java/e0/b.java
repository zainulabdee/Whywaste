package e0;

import f0.g;
import d0.a;

public final class b<O extends a.d>
{
    private final int a;
    private final a<O> b;
    private final O c;
    private final String d;
    
    private b(final a<O> b, final O c, final String d) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.a = g.c(b, c, d);
    }
    
    public static <O extends a.d> b<O> a(final a<O> a, final O o, final String s) {
        return new b<O>(a, o, s);
    }
    
    public final String b() {
        return this.b.c();
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (!(o instanceof b)) {
            return false;
        }
        final b b = (b)o;
        return g.b(this.b, b.b) && g.b(this.c, b.c) && g.b(this.d, b.d);
    }
    
    @Override
    public final int hashCode() {
        return this.a;
    }
}
