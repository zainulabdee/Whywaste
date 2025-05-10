package d2;

import java.util.NoSuchElementException;
import java.util.ListIterator;

public final class v implements ListIterator
{
    public static final v e;
    
    static {
        e = new v();
    }
    
    private v() {
    }
    
    public Void b() {
        throw new NoSuchElementException();
    }
    
    public Void c() {
        throw new NoSuchElementException();
    }
    
    public boolean hasNext() {
        return false;
    }
    
    public boolean hasPrevious() {
        return false;
    }
    
    public int nextIndex() {
        return 0;
    }
    
    public int previousIndex() {
        return -1;
    }
    
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
