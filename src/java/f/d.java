package f;

import java.util.NoSuchElementException;
import java.lang.reflect.Array;
import java.util.Map$Entry;
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
import java.util.Map;

abstract class d<K, V>
{
    b a;
    c b;
    e c;
    
    public static <K, V> boolean j(final Map<K, V> map, final Collection<?> collection) {
        final Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!map.containsKey(iterator.next())) {
                return false;
            }
        }
        return true;
    }
    
    public static <T> boolean k(final Set<T> set, final Object o) {
        boolean b = true;
        if (set == o) {
            return true;
        }
        if (!(o instanceof Set)) {
            return false;
        }
        final Set set2 = (Set)o;
        try {
            if (set.size() != set2.size() || !set.containsAll((Collection)set2)) {
                b = false;
            }
            return b;
        }
        catch (final NullPointerException | ClassCastException ex) {
            return false;
        }
    }
    
    public static <K, V> boolean o(final Map<K, V> map, final Collection<?> collection) {
        final int size = map.size();
        final Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            map.remove(iterator.next());
        }
        return size != map.size();
    }
    
    public static <K, V> boolean p(final Map<K, V> map, final Collection<?> collection) {
        final int size = map.size();
        final Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            if (!collection.contains(iterator.next())) {
                iterator.remove();
            }
        }
        return size != map.size();
    }
    
    protected abstract void a();
    
    protected abstract Object b(final int p0, final int p1);
    
    protected abstract Map<K, V> c();
    
    protected abstract int d();
    
    protected abstract int e(final Object p0);
    
    protected abstract int f(final Object p0);
    
    protected abstract void g(final K p0, final V p1);
    
    protected abstract void h(final int p0);
    
    protected abstract V i(final int p0, final V p1);
    
    public Set<Map$Entry<K, V>> l() {
        if (this.a == null) {
            this.a = new b();
        }
        return (Set<Map$Entry<K, V>>)this.a;
    }
    
    public Set<K> m() {
        if (this.b == null) {
            this.b = new c();
        }
        return (Set<K>)this.b;
    }
    
    public Collection<V> n() {
        if (this.c == null) {
            this.c = new e();
        }
        return (Collection<V>)this.c;
    }
    
    public Object[] q(final int n) {
        final int d = this.d();
        final Object[] array = new Object[d];
        for (int i = 0; i < d; ++i) {
            array[i] = this.b(i, n);
        }
        return array;
    }
    
    public <T> T[] r(final T[] array, final int n) {
        final int d = this.d();
        Object[] array2 = array;
        if (array.length < d) {
            array2 = (Object[])Array.newInstance((Class)array.getClass().getComponentType(), d);
        }
        for (int i = 0; i < d; ++i) {
            array2[i] = this.b(i, n);
        }
        if (array2.length > d) {
            array2[d] = null;
        }
        return (T[])array2;
    }
    
    final class a<T> implements Iterator<T>
    {
        final int e;
        int f;
        int g;
        boolean h;
        final d i;
        
        a(final d i, final int e) {
            this.i = i;
            this.h = false;
            this.e = e;
            this.f = i.d();
        }
        
        public boolean hasNext() {
            return this.g < this.f;
        }
        
        public T next() {
            if (this.hasNext()) {
                final Object b = this.i.b(this.g, this.e);
                ++this.g;
                this.h = true;
                return (T)b;
            }
            throw new NoSuchElementException();
        }
        
        public void remove() {
            if (this.h) {
                final int g = this.g - 1;
                this.g = g;
                --this.f;
                this.h = false;
                this.i.h(g);
                return;
            }
            throw new IllegalStateException();
        }
    }
    
    final class b implements Set<Map$Entry<K, V>>
    {
        final d e;
        
        b(final d e) {
            this.e = e;
        }
        
        public boolean addAll(final Collection<? extends Map$Entry<K, V>> collection) {
            final int d = this.e.d();
            for (final Map$Entry map$Entry : collection) {
                this.e.g(map$Entry.getKey(), map$Entry.getValue());
            }
            return d != this.e.d();
        }
        
        public void clear() {
            this.e.a();
        }
        
        public boolean contains(final Object o) {
            if (!(o instanceof Map$Entry)) {
                return false;
            }
            final Map$Entry map$Entry = (Map$Entry)o;
            final int e = this.e.e(map$Entry.getKey());
            return e >= 0 && f.c.b(this.e.b(e, 1), map$Entry.getValue());
        }
        
        public boolean containsAll(final Collection<?> collection) {
            final Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (!this.contains(iterator.next())) {
                    return false;
                }
            }
            return true;
        }
        
        @Override
        public boolean equals(final Object o) {
            return d.k((java.util.Set<Object>)this, o);
        }
        
        public boolean h(final Map$Entry<K, V> map$Entry) {
            throw new UnsupportedOperationException();
        }
        
        @Override
        public int hashCode() {
            int i = this.e.d() - 1;
            int n = 0;
            while (i >= 0) {
                final Object b = this.e.b(i, 0);
                final Object b2 = this.e.b(i, 1);
                int hashCode;
                if (b == null) {
                    hashCode = 0;
                }
                else {
                    hashCode = b.hashCode();
                }
                int hashCode2;
                if (b2 == null) {
                    hashCode2 = 0;
                }
                else {
                    hashCode2 = b2.hashCode();
                }
                n += (hashCode ^ hashCode2);
                --i;
            }
            return n;
        }
        
        public boolean isEmpty() {
            return this.e.d() == 0;
        }
        
        public Iterator<Map$Entry<K, V>> iterator() {
            return (Iterator<Map$Entry<K, V>>)this.e.new d();
        }
        
        public boolean remove(final Object o) {
            throw new UnsupportedOperationException();
        }
        
        public boolean removeAll(final Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
        
        public boolean retainAll(final Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
        
        public int size() {
            return this.e.d();
        }
        
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }
        
        public <T> T[] toArray(final T[] array) {
            throw new UnsupportedOperationException();
        }
    }
    
    final class c implements Set<K>
    {
        final d e;
        
        c(final d e) {
            this.e = e;
        }
        
        public boolean add(final K k) {
            throw new UnsupportedOperationException();
        }
        
        public boolean addAll(final Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }
        
        public void clear() {
            this.e.a();
        }
        
        public boolean contains(final Object o) {
            return this.e.e(o) >= 0;
        }
        
        public boolean containsAll(final Collection<?> collection) {
            return d.j(this.e.c(), collection);
        }
        
        @Override
        public boolean equals(final Object o) {
            return d.k((java.util.Set<Object>)this, o);
        }
        
        @Override
        public int hashCode() {
            int i = this.e.d() - 1;
            int n = 0;
            while (i >= 0) {
                final Object b = this.e.b(i, 0);
                int hashCode;
                if (b == null) {
                    hashCode = 0;
                }
                else {
                    hashCode = b.hashCode();
                }
                n += hashCode;
                --i;
            }
            return n;
        }
        
        public boolean isEmpty() {
            return this.e.d() == 0;
        }
        
        public Iterator<K> iterator() {
            return (Iterator<K>)this.e.new a(0);
        }
        
        public boolean remove(final Object o) {
            final int e = this.e.e(o);
            if (e >= 0) {
                this.e.h(e);
                return true;
            }
            return false;
        }
        
        public boolean removeAll(final Collection<?> collection) {
            return d.o(this.e.c(), collection);
        }
        
        public boolean retainAll(final Collection<?> collection) {
            return d.p(this.e.c(), collection);
        }
        
        public int size() {
            return this.e.d();
        }
        
        public Object[] toArray() {
            return this.e.q(0);
        }
        
        public <T> T[] toArray(final T[] array) {
            return this.e.r(array, 0);
        }
    }
    
    final class d implements Iterator<Map$Entry<K, V>>, Map$Entry<K, V>
    {
        int e;
        int f;
        boolean g;
        final f.d h;
        
        d(final f.d h) {
            this.h = h;
            this.g = false;
            this.e = h.d() - 1;
            this.f = -1;
        }
        
        public Map$Entry<K, V> b() {
            if (this.hasNext()) {
                ++this.f;
                this.g = true;
                return (Map$Entry<K, V>)this;
            }
            throw new NoSuchElementException();
        }
        
        @Override
        public boolean equals(final Object o) {
            if (!this.g) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            final boolean b = o instanceof Map$Entry;
            final boolean b2 = false;
            if (!b) {
                return false;
            }
            final Map$Entry map$Entry = (Map$Entry)o;
            boolean b3 = b2;
            if (f.c.b(map$Entry.getKey(), this.h.b(this.f, 0))) {
                b3 = b2;
                if (f.c.b(map$Entry.getValue(), this.h.b(this.f, 1))) {
                    b3 = true;
                }
            }
            return b3;
        }
        
        public K getKey() {
            if (this.g) {
                return (K)this.h.b(this.f, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        
        public V getValue() {
            if (this.g) {
                return (V)this.h.b(this.f, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        
        public boolean hasNext() {
            return this.f < this.e;
        }
        
        @Override
        public int hashCode() {
            if (this.g) {
                final f.d h = this.h;
                final int f = this.f;
                int hashCode = 0;
                final Object b = h.b(f, 0);
                final Object b2 = this.h.b(this.f, 1);
                int hashCode2;
                if (b == null) {
                    hashCode2 = 0;
                }
                else {
                    hashCode2 = b.hashCode();
                }
                if (b2 != null) {
                    hashCode = b2.hashCode();
                }
                return hashCode2 ^ hashCode;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        
        public void remove() {
            if (this.g) {
                this.h.h(this.f);
                --this.f;
                --this.e;
                this.g = false;
                return;
            }
            throw new IllegalStateException();
        }
        
        public V setValue(final V v) {
            if (this.g) {
                return this.h.i(this.f, v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.getKey());
            sb.append("=");
            sb.append(this.getValue());
            return sb.toString();
        }
    }
    
    final class e implements Collection<V>
    {
        final d e;
        
        e(final d e) {
            this.e = e;
        }
        
        public boolean add(final V v) {
            throw new UnsupportedOperationException();
        }
        
        public boolean addAll(final Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }
        
        public void clear() {
            this.e.a();
        }
        
        public boolean contains(final Object o) {
            return this.e.f(o) >= 0;
        }
        
        public boolean containsAll(final Collection<?> collection) {
            final Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                if (!this.contains(iterator.next())) {
                    return false;
                }
            }
            return true;
        }
        
        public boolean isEmpty() {
            return this.e.d() == 0;
        }
        
        public Iterator<V> iterator() {
            return (Iterator<V>)this.e.new a(1);
        }
        
        public boolean remove(final Object o) {
            final int f = this.e.f(o);
            if (f >= 0) {
                this.e.h(f);
                return true;
            }
            return false;
        }
        
        public boolean removeAll(final Collection<?> collection) {
            int d = this.e.d();
            int i = 0;
            boolean b = false;
            while (i < d) {
                int n = d;
                int n2 = i;
                if (collection.contains(this.e.b(i, 1))) {
                    this.e.h(i);
                    n2 = i - 1;
                    n = d - 1;
                    b = true;
                }
                i = n2 + 1;
                d = n;
            }
            return b;
        }
        
        public boolean retainAll(final Collection<?> collection) {
            int d = this.e.d();
            int i = 0;
            boolean b = false;
            while (i < d) {
                int n = d;
                int n2 = i;
                if (!collection.contains(this.e.b(i, 1))) {
                    this.e.h(i);
                    n2 = i - 1;
                    n = d - 1;
                    b = true;
                }
                i = n2 + 1;
                d = n;
            }
            return b;
        }
        
        public int size() {
            return this.e.d();
        }
        
        public Object[] toArray() {
            return this.e.q(1);
        }
        
        public <T> T[] toArray(final T[] array) {
            return this.e.r(array, 1);
        }
    }
}
