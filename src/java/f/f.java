package f;

public class f<E> implements Cloneable
{
    private static final Object i;
    private boolean e;
    private int[] f;
    private Object[] g;
    private int h;
    
    static {
        i = new Object();
    }
    
    public f() {
        this(10);
    }
    
    public f(int d) {
        this.e = false;
        if (d == 0) {
            this.f = c.a;
            this.g = c.c;
        }
        else {
            d = c.d(d);
            this.f = new int[d];
            this.g = new Object[d];
        }
    }
    
    private void d() {
        final int h = this.h;
        final int[] f = this.f;
        final Object[] g = this.g;
        int i = 0;
        int h2 = 0;
        while (i < h) {
            final Object o = g[i];
            int n = h2;
            if (o != f.f.i) {
                if (i != h2) {
                    f[h2] = f[i];
                    g[h2] = o;
                    g[i] = null;
                }
                n = h2 + 1;
            }
            ++i;
            h2 = n;
        }
        this.e = false;
        this.h = h2;
    }
    
    public void b() {
        final int h = this.h;
        final Object[] g = this.g;
        for (int i = 0; i < h; ++i) {
            g[i] = null;
        }
        this.h = 0;
        this.e = false;
    }
    
    public f<E> c() {
        try {
            final f f = (f)super.clone();
            f.f = this.f.clone();
            f.g = this.g.clone();
            return f;
        }
        catch (final CloneNotSupportedException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    public E e(final int n) {
        return this.g(n, null);
    }
    
    public E g(int a, final E e) {
        a = c.a(this.f, this.h, a);
        if (a >= 0) {
            final Object o = this.g[a];
            if (o != f.f.i) {
                return (E)o;
            }
        }
        return e;
    }
    
    public int h(final int n) {
        if (this.e) {
            this.d();
        }
        return c.a(this.f, this.h, n);
    }
    
    public int i(final int n) {
        if (this.e) {
            this.d();
        }
        return this.f[n];
    }
    
    public void j(final int n, final E e) {
        final int a = c.a(this.f, this.h, n);
        if (a >= 0) {
            this.g[a] = e;
        }
        else {
            final int n2 = ~a;
            final int h = this.h;
            if (n2 < h) {
                final Object[] g = this.g;
                if (g[n2] == f.f.i) {
                    this.f[n2] = n;
                    g[n2] = e;
                    return;
                }
            }
            int n3 = n2;
            if (this.e) {
                n3 = n2;
                if (h >= this.f.length) {
                    this.d();
                    n3 = ~c.a(this.f, this.h, n);
                }
            }
            final int h2 = this.h;
            if (h2 >= this.f.length) {
                final int d = c.d(h2 + 1);
                final int[] f = new int[d];
                final Object[] g2 = new Object[d];
                final int[] f2 = this.f;
                System.arraycopy((Object)f2, 0, (Object)f, 0, f2.length);
                final Object[] g3 = this.g;
                System.arraycopy((Object)g3, 0, (Object)g2, 0, g3.length);
                this.f = f;
                this.g = g2;
            }
            final int h3 = this.h;
            if (h3 - n3 != 0) {
                final int[] f3 = this.f;
                final int n4 = n3 + 1;
                System.arraycopy((Object)f3, n3, (Object)f3, n4, h3 - n3);
                final Object[] g4 = this.g;
                System.arraycopy((Object)g4, n3, (Object)g4, n4, this.h - n3);
            }
            this.f[n3] = n;
            this.g[n3] = e;
            ++this.h;
        }
    }
    
    public void k(int a) {
        a = c.a(this.f, this.h, a);
        if (a >= 0) {
            final Object[] g = this.g;
            final Object o = g[a];
            final Object i = f.f.i;
            if (o != i) {
                g[a] = i;
                this.e = true;
            }
        }
    }
    
    public int l() {
        if (this.e) {
            this.d();
        }
        return this.h;
    }
    
    public E m(final int n) {
        if (this.e) {
            this.d();
        }
        return (E)this.g[n];
    }
    
    @Override
    public String toString() {
        if (this.l() <= 0) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        for (int i = 0; i < this.h; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.i(i));
            sb.append('=');
            final E m = this.m(i);
            if (m != this) {
                sb.append((Object)m);
            }
            else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
