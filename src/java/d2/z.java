package d2;

import java.util.Iterator;

public abstract class z implements Iterator<Integer>
{
    public abstract int nextInt();
    
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
