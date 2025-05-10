package o2;

import d2.z;
import java.util.Iterator;
import g2.c;
import kotlin.jvm.internal.e;

public class a implements Iterable<Integer>
{
    public static final a h;
    private final int e;
    private final int f;
    private final int g;
    
    static {
        h = new a(null);
    }
    
    public a(final int e, final int n, final int g) {
        if (g == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (g != Integer.MIN_VALUE) {
            this.e = e;
            this.f = c.b(e, n, g);
            this.g = g;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof a) {
            if (!this.isEmpty() || !((a)o).isEmpty()) {
                final int e = this.e;
                final a a = (a)o;
                if (e != a.e || this.f != a.f || this.g != a.g) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    
    public final int h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        int n;
        if (this.isEmpty()) {
            n = -1;
        }
        else {
            n = (this.e * 31 + this.f) * 31 + this.g;
        }
        return n;
    }
    
    public final int i() {
        return this.f;
    }
    
    public boolean isEmpty() {
        final int g = this.g;
        boolean b = true;
        if (g > 0) {
            if (this.e > this.f) {
                return b;
            }
        }
        else if (this.e < this.f) {
            return b;
        }
        b = false;
        return b;
    }
    
    public final int j() {
        return this.g;
    }
    
    public z k() {
        return (z)new b(this.e, this.f, this.g);
    }
    
    @Override
    public String toString() {
        StringBuilder sb;
        int g;
        if (this.g > 0) {
            sb = new StringBuilder();
            sb.append(this.e);
            sb.append("..");
            sb.append(this.f);
            sb.append(" step ");
            g = this.g;
        }
        else {
            sb = new StringBuilder();
            sb.append(this.e);
            sb.append(" downTo ");
            sb.append(this.f);
            sb.append(" step ");
            g = -this.g;
        }
        sb.append(g);
        return sb.toString();
    }
    
    public static final class a
    {
        private a() {
        }
        
        public final o2.a a(final int n, final int n2, final int n3) {
            return new o2.a(n, n2, n3);
        }
    }
}
