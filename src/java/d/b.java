package d;

import java.util.Iterator;
import java.util.WeakHashMap;
import java.util.Map$Entry;

public class b<K, V> implements Iterable<Map$Entry<K, V>>
{
    c<K, V> e;
    private c<K, V> f;
    private final WeakHashMap<f<K, V>, Boolean> g;
    private int h;
    
    public b() {
        this.g = (WeakHashMap<f<K, V>, Boolean>)new WeakHashMap();
        this.h = 0;
    }
    
    public Iterator<Map$Entry<K, V>> descendingIterator() {
        final b.b$b b$b = new b.b$b((c)this.f, (c)this.e);
        this.g.put((Object)b$b, (Object)Boolean.FALSE);
        return (Iterator<Map$Entry<K, V>>)b$b;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (o == this) {
            return true;
        }
        if (!(o instanceof b)) {
            return false;
        }
        final b b2 = (b)o;
        if (this.size() != b2.size()) {
            return false;
        }
        final Iterator<Map$Entry<K, V>> iterator = this.iterator();
        final Iterator iterator2 = b2.iterator();
        while (iterator.hasNext() && iterator2.hasNext()) {
            final Map$Entry map$Entry = (Map$Entry)iterator.next();
            final Object next = iterator2.next();
            if ((map$Entry == null && next != null) || (map$Entry != null && !map$Entry.equals(next))) {
                return false;
            }
        }
        if (iterator.hasNext() || iterator2.hasNext()) {
            b = false;
        }
        return b;
    }
    
    public Map$Entry<K, V> h() {
        return (Map$Entry<K, V>)this.e;
    }
    
    @Override
    public int hashCode() {
        final Iterator<Map$Entry<K, V>> iterator = this.iterator();
        int n = 0;
        while (iterator.hasNext()) {
            n += ((Map$Entry)iterator.next()).hashCode();
        }
        return n;
    }
    
    protected c<K, V> i(final K obj) {
        c<K, V> c;
        for (c = this.e; c != null && !c.e.equals(obj); c = c.g) {}
        return c;
    }
    
    public Iterator<Map$Entry<K, V>> iterator() {
        final b.b$a b$a = new b.b$a((c)this.e, (c)this.f);
        this.g.put((Object)b$a, (Object)Boolean.FALSE);
        return (Iterator<Map$Entry<K, V>>)b$a;
    }
    
    public b.b$d j() {
        final b.b$d b$d = new b.b$d(this);
        this.g.put((Object)b$d, (Object)Boolean.FALSE);
        return b$d;
    }
    
    public Map$Entry<K, V> k() {
        return (Map$Entry<K, V>)this.f;
    }
    
    c<K, V> l(final K k, final V v) {
        final c c = new c((K)k, (V)v);
        ++this.h;
        final c<K, V> f = this.f;
        if (f == null) {
            this.e = c;
            return this.f = c;
        }
        f.g = c;
        c.h = (c<K, V>)f;
        return this.f = c;
    }
    
    public V m(final K k, final V v) {
        final c<K, V> i = this.i(k);
        if (i != null) {
            return i.f;
        }
        this.l(k, v);
        return null;
    }
    
    public V n(final K k) {
        final c<K, V> i = this.i(k);
        if (i == null) {
            return null;
        }
        --this.h;
        if (!this.g.isEmpty()) {
            final Iterator iterator = this.g.keySet().iterator();
            while (iterator.hasNext()) {
                ((f)iterator.next()).b((c)i);
            }
        }
        final c<K, V> h = (c<K, V>)i.h;
        if (h != null) {
            h.g = (c<K, V>)i.g;
        }
        else {
            this.e = i.g;
        }
        final c<K, V> g = (c<K, V>)i.g;
        if (g != null) {
            g.h = h;
        }
        else {
            this.f = (c<K, V>)h;
        }
        i.g = null;
        i.h = null;
        return i.f;
    }
    
    public int size() {
        return this.h;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        final Iterator<Map$Entry<K, V>> iterator = this.iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next().toString());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
    
    static class c<K, V> implements Map$Entry<K, V>
    {
        final K e;
        final V f;
        c<K, V> g;
        c<K, V> h;
        
        c(final K e, final V f) {
            this.e = e;
            this.f = f;
        }
        
        @Override
        public boolean equals(final Object o) {
            boolean b = true;
            if (o == this) {
                return true;
            }
            if (!(o instanceof c)) {
                return false;
            }
            final c c = (c)o;
            if (!this.e.equals(c.e) || !this.f.equals(c.f)) {
                b = false;
            }
            return b;
        }
        
        public K getKey() {
            return this.e;
        }
        
        public V getValue() {
            return this.f;
        }
        
        @Override
        public int hashCode() {
            return this.e.hashCode() ^ this.f.hashCode();
        }
        
        public V setValue(final V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append((Object)this.e);
            sb.append("=");
            sb.append((Object)this.f);
            return sb.toString();
        }
    }
    
    public abstract static class f<K, V>
    {
        abstract void b(final c<K, V> p0);
    }
}
