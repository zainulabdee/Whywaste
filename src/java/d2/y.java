package d2;

import kotlin.jvm.internal.d;
import java.util.Iterator;
import kotlin.jvm.internal.i;
import java.util.Collection;
import java.io.Serializable;
import java.util.Set;

public final class y implements Set, Serializable
{
    public static final y e;
    
    static {
        e = new y();
    }
    
    private y() {
    }
    
    public boolean addAll(final Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    public final /* bridge */ boolean contains(final Object o) {
        return o instanceof Void && this.h((Void)o);
    }
    
    public boolean containsAll(final Collection collection) {
        i.e((Object)collection, "elements");
        return collection.isEmpty();
    }
    
    @Override
    public boolean equals(final Object o) {
        return o instanceof Set && ((Set)o).isEmpty();
    }
    
    public boolean h(final Void void1) {
        i.e((Object)void1, "element");
        return false;
    }
    
    @Override
    public int hashCode() {
        return 0;
    }
    
    public int i() {
        return 0;
    }
    
    public boolean isEmpty() {
        return true;
    }
    
    public Iterator iterator() {
        return (Iterator)v.e;
    }
    
    public boolean remove(final Object o) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    public boolean removeAll(final Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    public boolean retainAll(final Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
    
    public final /* bridge */ int size() {
        return this.i();
    }
    
    public Object[] toArray() {
        return d.a((Collection)this);
    }
    
    public <T> T[] toArray(final T[] array) {
        i.e((Object)array, "array");
        return (T[])d.b((Collection)this, (Object[])array);
    }
    
    @Override
    public String toString() {
        return "[]";
    }
}
