package p2;

import l2.a;

public interface i<V> extends h<V>, l2.a<V>
{
    V get();
    
    Object getDelegate();
    
    a<V> getGetter();
    
    public interface a<V> extends h.a<V>, l2.a<V>
    {
    }
}
