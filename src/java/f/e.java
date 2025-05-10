package f;

import java.util.Map;
import java.util.ConcurrentModificationException;

public class e<K, V>
{
    static Object[] h;
    static int i;
    static Object[] j;
    static int k;
    int[] e;
    Object[] f;
    int g;
    
    public e() {
        this.e = c.a;
        this.f = c.c;
        this.g = 0;
    }
    
    public e(final int n) {
        if (n == 0) {
            this.e = c.a;
            this.f = c.c;
        }
        else {
            this.a(n);
        }
        this.g = 0;
    }
    
    private void a(final int n) {
        Label_0143: {
            if (n == 8) {
                synchronized (e.class) {
                    final Object[] j = f.e.j;
                    if (j != null) {
                        this.f = j;
                        f.e.j = (Object[])j[0];
                        this.e = (int[])j[1];
                        j[0] = (j[1] = null);
                        --f.e.k;
                        return;
                    }
                    break Label_0143;
                }
            }
            if (n == 4) {
                synchronized (e.class) {
                    final Object[] h = f.e.h;
                    if (h != null) {
                        this.f = h;
                        f.e.h = (Object[])h[0];
                        this.e = (int[])h[1];
                        h[0] = (h[1] = null);
                        --f.e.i;
                        return;
                    }
                }
            }
        }
        this.e = new int[n];
        this.f = new Object[n << 1];
    }
    
    private static int b(final int[] array, int a, final int n) {
        try {
            a = c.a(array, a, n);
            return a;
        }
        catch (final ArrayIndexOutOfBoundsException ex) {
            throw new ConcurrentModificationException();
        }
    }
    
    private static void d(final int[] array, final Object[] array2, int i) {
        if (array.length == 8) {
            synchronized (e.class) {
                if (e.k < 10) {
                    array2[0] = e.j;
                    array2[1] = array;
                    for (i = (i << 1) - 1; i >= 2; --i) {
                        array2[i] = null;
                    }
                    e.j = array2;
                    ++e.k;
                }
                return;
            }
        }
        if (array.length == 4) {
            synchronized (e.class) {
                if (e.i < 10) {
                    array2[0] = e.h;
                    array2[1] = array;
                    for (i = (i << 1) - 1; i >= 2; --i) {
                        array2[i] = null;
                    }
                    e.h = array2;
                    ++e.i;
                }
            }
        }
    }
    
    public void c(final int n) {
        final int g = this.g;
        final int[] e = this.e;
        if (e.length < n) {
            final Object[] f = this.f;
            this.a(n);
            if (this.g > 0) {
                System.arraycopy((Object)e, 0, (Object)this.e, 0, g);
                System.arraycopy((Object)f, 0, (Object)this.f, 0, g << 1);
            }
            d(e, f, g);
        }
        if (this.g == g) {
            return;
        }
        throw new ConcurrentModificationException();
    }
    
    public void clear() {
        final int g = this.g;
        if (g > 0) {
            final int[] e = this.e;
            final Object[] f = this.f;
            this.e = c.a;
            this.f = c.c;
            this.g = 0;
            d(e, f, g);
        }
        if (this.g <= 0) {
            return;
        }
        throw new ConcurrentModificationException();
    }
    
    public boolean containsKey(final Object o) {
        return this.f(o) >= 0;
    }
    
    public boolean containsValue(final Object o) {
        return this.h(o) >= 0;
    }
    
    int e(final Object o, final int n) {
        final int g = this.g;
        if (g == 0) {
            return -1;
        }
        int b = b(this.e, g, n);
        if (b < 0) {
            return b;
        }
        if (o.equals(this.f[b << 1])) {
            return b;
        }
        int n2;
        for (n2 = b + 1; n2 < g && this.e[n2] == n; ++n2) {
            if (o.equals(this.f[n2 << 1])) {
                return n2;
            }
        }
        --b;
        while (b >= 0 && this.e[b] == n) {
            if (o.equals(this.f[b << 1])) {
                return b;
            }
            --b;
        }
        return ~n2;
    }
    
    @Override
    public boolean equals(Object l) {
        if (this == l) {
            return true;
        }
        if (l instanceof e) {
            final e e = (e)l;
            if (this.size() != e.size()) {
                return false;
            }
            int i = 0;
            try {
                while (i < this.g) {
                    final K j = this.i(i);
                    l = this.l(i);
                    final Object value = e.get(j);
                    if (l == null) {
                        if (value != null || !e.containsKey(j)) {
                            return false;
                        }
                    }
                    else if (!l.equals(value)) {
                        return false;
                    }
                    ++i;
                }
                return true;
            }
            catch (final NullPointerException | ClassCastException ex) {
                return false;
            }
        }
        if (!(l instanceof Map)) {
            return false;
        }
        final Map map = (Map)l;
        if (this.size() != map.size()) {
            return false;
        }
        int k = 0;
        try {
            while (k < this.g) {
                final K m = this.i(k);
                final V l2 = this.l(k);
                final Object value2 = map.get((Object)m);
                if (l2 == null) {
                    if (value2 != null || !map.containsKey((Object)m)) {
                        return false;
                    }
                }
                else if (!l2.equals(value2)) {
                    return false;
                }
                ++k;
            }
            return true;
        }
        catch (final NullPointerException | ClassCastException ex2) {
            return false;
        }
    }
    
    public int f(final Object o) {
        int n;
        if (o == null) {
            n = this.g();
        }
        else {
            n = this.e(o, o.hashCode());
        }
        return n;
    }
    
    int g() {
        final int g = this.g;
        if (g == 0) {
            return -1;
        }
        int b = b(this.e, g, 0);
        if (b < 0) {
            return b;
        }
        if (this.f[b << 1] == null) {
            return b;
        }
        int n;
        for (n = b + 1; n < g && this.e[n] == 0; ++n) {
            if (this.f[n << 1] == null) {
                return n;
            }
        }
        --b;
        while (b >= 0 && this.e[b] == 0) {
            if (this.f[b << 1] == null) {
                return b;
            }
            --b;
        }
        return ~n;
    }
    
    public V get(final Object o) {
        return this.getOrDefault(o, null);
    }
    
    public V getOrDefault(final Object o, V v) {
        final int f = this.f(o);
        if (f >= 0) {
            v = (V)this.f[(f << 1) + 1];
        }
        return v;
    }
    
    int h(final Object o) {
        final int n = this.g * 2;
        final Object[] f = this.f;
        if (o == null) {
            for (int i = 1; i < n; i += 2) {
                if (f[i] == null) {
                    return i >> 1;
                }
            }
        }
        else {
            for (int j = 1; j < n; j += 2) {
                if (o.equals(f[j])) {
                    return j >> 1;
                }
            }
        }
        return -1;
    }
    
    @Override
    public int hashCode() {
        final int[] e = this.e;
        final Object[] f = this.f;
        final int g = this.g;
        int n = 1;
        int i = 0;
        int n2 = 0;
        while (i < g) {
            final Object o = f[n];
            final int n3 = e[i];
            int hashCode;
            if (o == null) {
                hashCode = 0;
            }
            else {
                hashCode = o.hashCode();
            }
            n2 += (hashCode ^ n3);
            ++i;
            n += 2;
        }
        return n2;
    }
    
    public K i(final int n) {
        return (K)this.f[n << 1];
    }
    
    public boolean isEmpty() {
        return this.g <= 0;
    }
    
    public V j(int g) {
        final Object[] f = this.f;
        final int n = g << 1;
        final Object o = f[n + 1];
        final int g2 = this.g;
        final int n2 = 0;
        if (g2 <= 1) {
            d(this.e, f, g2);
            this.e = c.a;
            this.f = c.c;
            g = n2;
        }
        else {
            final int n3 = g2 - 1;
            final int[] e = this.e;
            final int length = e.length;
            int n4 = 8;
            if (length > 8 && g2 < e.length / 3) {
                if (g2 > 8) {
                    n4 = g2 + (g2 >> 1);
                }
                this.a(n4);
                if (g2 != this.g) {
                    throw new ConcurrentModificationException();
                }
                if (g > 0) {
                    System.arraycopy((Object)e, 0, (Object)this.e, 0, g);
                    System.arraycopy((Object)f, 0, (Object)this.f, 0, n);
                }
                if (g < n3) {
                    final int n5 = g + 1;
                    final int[] e2 = this.e;
                    final int n6 = n3 - g;
                    System.arraycopy((Object)e, n5, (Object)e2, g, n6);
                    System.arraycopy((Object)f, n5 << 1, (Object)this.f, n, n6 << 1);
                }
            }
            else {
                if (g < n3) {
                    final int n7 = g + 1;
                    final int n8 = n3 - g;
                    System.arraycopy((Object)e, n7, (Object)e, g, n8);
                    final Object[] f2 = this.f;
                    System.arraycopy((Object)f2, n7 << 1, (Object)f2, n, n8 << 1);
                }
                final Object[] f3 = this.f;
                g = n3 << 1;
                f3[g + 1] = (f3[g] = null);
            }
            g = n3;
        }
        if (g2 == this.g) {
            this.g = g;
            return (V)o;
        }
        throw new ConcurrentModificationException();
    }
    
    public V k(int n, final V v) {
        n = (n << 1) + 1;
        final Object[] f = this.f;
        final Object o = f[n];
        f[n] = v;
        return (V)o;
    }
    
    public V l(final int n) {
        return (V)this.f[(n << 1) + 1];
    }
    
    public V put(final K k, final V v) {
        final int g = this.g;
        int n;
        int hashCode;
        if (k == null) {
            n = this.g();
            hashCode = 0;
        }
        else {
            hashCode = k.hashCode();
            n = this.e(k, hashCode);
        }
        if (n >= 0) {
            final int n2 = (n << 1) + 1;
            final Object[] f = this.f;
            final Object o = f[n2];
            f[n2] = v;
            return (V)o;
        }
        final int n3 = ~n;
        final int[] e = this.e;
        if (g >= e.length) {
            int n4 = 4;
            if (g >= 8) {
                n4 = (g >> 1) + g;
            }
            else if (g >= 4) {
                n4 = 8;
            }
            final Object[] f2 = this.f;
            this.a(n4);
            if (g != this.g) {
                throw new ConcurrentModificationException();
            }
            final int[] e2 = this.e;
            if (e2.length > 0) {
                System.arraycopy((Object)e, 0, (Object)e2, 0, e.length);
                System.arraycopy((Object)f2, 0, (Object)this.f, 0, f2.length);
            }
            d(e, f2, g);
        }
        if (n3 < g) {
            final int[] e3 = this.e;
            final int n5 = n3 + 1;
            System.arraycopy((Object)e3, n3, (Object)e3, n5, g - n3);
            final Object[] f3 = this.f;
            System.arraycopy((Object)f3, n3 << 1, (Object)f3, n5 << 1, this.g - n3 << 1);
        }
        final int g2 = this.g;
        if (g == g2) {
            final int[] e4 = this.e;
            if (n3 < e4.length) {
                e4[n3] = hashCode;
                final Object[] f4 = this.f;
                final int n6 = n3 << 1;
                f4[n6] = k;
                f4[n6 + 1] = v;
                this.g = g2 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }
    
    public V putIfAbsent(final K k, final V v) {
        Object o;
        if ((o = this.get(k)) == null) {
            o = this.put(k, v);
        }
        return (V)o;
    }
    
    public V remove(final Object o) {
        final int f = this.f(o);
        if (f >= 0) {
            return this.j(f);
        }
        return null;
    }
    
    public boolean remove(Object l, final Object o) {
        final int f = this.f(l);
        if (f >= 0) {
            l = this.l(f);
            if (o == l || (o != null && o.equals(l))) {
                this.j(f);
                return true;
            }
        }
        return false;
    }
    
    public V replace(final K k, final V v) {
        final int f = this.f(k);
        if (f >= 0) {
            return this.k(f, v);
        }
        return null;
    }
    
    public boolean replace(final K k, final V v, final V v2) {
        final int f = this.f(k);
        if (f >= 0) {
            final V l = this.l(f);
            if (l == v || (v != null && v.equals(l))) {
                this.k(f, v2);
                return true;
            }
        }
        return false;
    }
    
    public int size() {
        return this.g;
    }
    
    @Override
    public String toString() {
        if (this.isEmpty()) {
            return "{}";
        }
        final StringBuilder sb = new StringBuilder(this.g * 28);
        sb.append('{');
        for (int i = 0; i < this.g; ++i) {
            if (i > 0) {
                sb.append(", ");
            }
            final K j = this.i(i);
            if (j != this) {
                sb.append((Object)j);
            }
            else {
                sb.append("(this Map)");
            }
            sb.append('=');
            final V l = this.l(i);
            if (l != this) {
                sb.append((Object)l);
            }
            else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
