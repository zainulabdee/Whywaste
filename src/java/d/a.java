package d;

import java.util.Map$Entry;
import java.util.HashMap;

public class a<K, V> extends b<K, V>
{
    private final HashMap<K, b$c<K, V>> i;
    
    public a() {
        this.i = (HashMap<K, b$c<K, V>>)new HashMap();
    }
    
    public boolean contains(final K k) {
        return this.i.containsKey((Object)k);
    }
    
    protected b$c<K, V> i(final K k) {
        return (b$c<K, V>)this.i.get((Object)k);
    }
    
    public V m(final K k, final V v) {
        final b$c<K, V> i = this.i(k);
        if (i != null) {
            return (V)i.f;
        }
        this.i.put((Object)k, (Object)this.l((Object)k, (Object)v));
        return null;
    }
    
    public V n(final K k) {
        final Object n = super.n((Object)k);
        this.i.remove((Object)k);
        return (V)n;
    }
    
    public Map$Entry<K, V> o(final K k) {
        if (this.contains(k)) {
            return (Map$Entry<K, V>)((b$c)this.i.get((Object)k)).h;
        }
        return null;
    }
}
