package f;

import java.util.Iterator;
import java.util.Collection;
import java.util.Map$Entry;
import java.util.Set;
import java.util.Map;

public class a<K, V> extends e<K, V> implements Map<K, V>
{
    d<K, V> l;
    
    public a() {
    }
    
    public a(final int n) {
        super(n);
    }
    
    private d<K, V> m() {
        if (this.l == null) {
            this.l = new d<K, V>(this) {
                final a d;
                
                protected void a() {
                    this.d.clear();
                }
                
                protected Object b(final int n, final int n2) {
                    return this.d.f[(n << 1) + n2];
                }
                
                protected Map<K, V> c() {
                    return (Map<K, V>)this.d;
                }
                
                protected int d() {
                    return this.d.g;
                }
                
                protected int e(final Object o) {
                    return this.d.f(o);
                }
                
                protected int f(final Object o) {
                    return this.d.h(o);
                }
                
                protected void g(final K k, final V v) {
                    this.d.put((Object)k, (Object)v);
                }
                
                protected void h(final int n) {
                    this.d.j(n);
                }
                
                protected V i(final int n, final V v) {
                    return (V)this.d.k(n, (Object)v);
                }
            };
        }
        return this.l;
    }
    
    public Set<Map$Entry<K, V>> entrySet() {
        return (Set<Map$Entry<K, V>>)this.m().l();
    }
    
    public Set<K> keySet() {
        return (Set<K>)this.m().m();
    }
    
    public boolean n(final Collection<?> collection) {
        return d.p((Map)this, (Collection)collection);
    }
    
    public void putAll(final Map<? extends K, ? extends V> map) {
        this.c(super.g + map.size());
        for (final Map$Entry map$Entry : map.entrySet()) {
            this.put(map$Entry.getKey(), map$Entry.getValue());
        }
    }
    
    public Collection<V> values() {
        return (Collection<V>)this.m().n();
    }
}
