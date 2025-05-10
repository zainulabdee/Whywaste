package d2;

import java.util.AbstractList;

public abstract class c<E> extends AbstractList<E>
{
    protected c() {
    }
    
    public abstract int h();
    
    public abstract E i(final int p0);
    
    public final /* bridge */ E remove(final int n) {
        return this.i(n);
    }
    
    public final /* bridge */ int size() {
        return this.h();
    }
}
