package io.sentry;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

final class z4<T>
{
    private final List<T> a;
    
    z4(final List<T> list) {
        Object o = list;
        if (list == null) {
            o = new ArrayList(0);
        }
        this.a = (List<T>)new ArrayList((Collection)o);
    }
    
    public List<T> a() {
        return this.a;
    }
}
