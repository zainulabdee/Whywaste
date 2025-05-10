package o2;

import kotlin.jvm.internal.e;

public final class c extends a
{
    public static final c.c$a i;
    private static final c j;
    
    static {
        i = new c.c$a((e)null);
        j = new c(1, 0);
    }
    
    public c(final int n, final int n2) {
        super(n, n2, 1);
    }
    
    public boolean equals(final Object o) {
        if (o instanceof c) {
            if (!this.isEmpty() || !((c)o).isEmpty()) {
                final int h = this.h();
                final c c = (c)o;
                if (h != c.h() || this.i() != c.i()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public int hashCode() {
        int n;
        if (this.isEmpty()) {
            n = -1;
        }
        else {
            n = this.h() * 31 + this.i();
        }
        return n;
    }
    
    public boolean isEmpty() {
        return this.h() > this.i();
    }
    
    public boolean m(final int n) {
        return this.h() <= n && n <= this.i();
    }
    
    public Integer n() {
        return this.i();
    }
    
    public Integer o() {
        return this.h();
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.h());
        sb.append("..");
        sb.append(this.i());
        return sb.toString();
    }
}
