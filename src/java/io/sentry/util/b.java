package io.sentry.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public final class b
{
    public static <T> List<T> a(final List<T> list) {
        if (list != null) {
            return (List<T>)new ArrayList((Collection)list);
        }
        return null;
    }
    
    public static <K, V> Map<K, V> b(final Map<K, V> map) {
        if (map != null) {
            final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            for (final Map$Entry map$Entry : map.entrySet()) {
                if (map$Entry.getKey() != null && map$Entry.getValue() != null) {
                    ((Map)concurrentHashMap).put(map$Entry.getKey(), map$Entry.getValue());
                }
            }
            return (Map<K, V>)concurrentHashMap;
        }
        return null;
    }
    
    public static <K, V> Map<K, V> c(final Map<K, V> map) {
        if (map != null) {
            return (Map<K, V>)new HashMap((Map)map);
        }
        return null;
    }
    
    public static int d(final Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection)iterable).size();
        }
        int n = 0;
        final Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            ++n;
        }
        return n;
    }
}
