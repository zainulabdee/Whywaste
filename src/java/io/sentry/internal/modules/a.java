package io.sentry.internal.modules;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map;
import io.sentry.n0;
import java.util.List;

public final class a extends d
{
    private final List<b> d;
    
    public a(final List<b> d, final n0 n0) {
        super(n0);
        this.d = d;
    }
    
    protected Map<String, String> b() {
        final TreeMap treeMap = new TreeMap();
        final Iterator iterator = this.d.iterator();
        while (iterator.hasNext()) {
            final Map a = ((b)iterator.next()).a();
            if (a != null) {
                treeMap.putAll(a);
            }
        }
        return (Map<String, String>)treeMap;
    }
}
