package d2;

import java.util.List;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import c2.j;
import kotlin.jvm.internal.i;
import java.util.Map;

class d0 extends c0
{
    public static <K, V> Map<K, V> d() {
        final x e = x.e;
        i.c((Object)e, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return (Map<K, V>)e;
    }
    
    public static <K, V> Map<K, V> e(final j<? extends K, ? extends V>... array) {
        i.e((Object)array, "pairs");
        Map map;
        if (array.length > 0) {
            map = l((c2.j<?, ?>[])array, (Map<K, V>)new LinkedHashMap(a0.a(array.length)));
        }
        else {
            map = a0.d();
        }
        return (Map<K, V>)map;
    }
    
    public static final <K, V> Map<K, V> f(Map<K, ? extends V> map) {
        i.e((Object)map, "<this>");
        final int size = map.size();
        if (size != 0) {
            if (size == 1) {
                map = c0.c(map);
            }
        }
        else {
            map = a0.d();
        }
        return (Map<K, V>)map;
    }
    
    public static final <K, V> void g(final Map<? super K, ? super V> map, final Iterable<? extends j<? extends K, ? extends V>> iterable) {
        i.e((Object)map, "<this>");
        i.e((Object)iterable, "pairs");
        for (final j j : iterable) {
            map.put(j.a(), j.b());
        }
    }
    
    public static final <K, V> void h(final Map<? super K, ? super V> map, final j<? extends K, ? extends V>[] array) {
        i.e((Object)map, "<this>");
        i.e((Object)array, "pairs");
        for (final j<? extends K, ? extends V> j : array) {
            map.put(j.a(), j.b());
        }
    }
    
    public static <K, V> Map<K, V> i(final Iterable<? extends j<? extends K, ? extends V>> iterable) {
        i.e((Object)iterable, "<this>");
        if (iterable instanceof Collection) {
            final Collection collection = (Collection)iterable;
            final int size = collection.size();
            Map map;
            if (size != 0) {
                if (size != 1) {
                    map = j((java.lang.Iterable<? extends c2.j<?, ?>>)iterable, (Map<K, V>)new LinkedHashMap(a0.a(collection.size())));
                }
                else {
                    Object o;
                    if (iterable instanceof List) {
                        o = ((List)iterable).get(0);
                    }
                    else {
                        o = iterable.iterator().next();
                    }
                    map = c0.b((j)o);
                }
            }
            else {
                map = a0.d();
            }
            return (Map<K, V>)map;
        }
        return f((java.util.Map<K, ? extends V>)j((java.lang.Iterable<? extends c2.j<?, ?>>)iterable, (Map<K, ? extends V>)new LinkedHashMap()));
    }
    
    public static final <K, V, M extends Map<? super K, ? super V>> M j(final Iterable<? extends j<? extends K, ? extends V>> iterable, final M m) {
        i.e((Object)iterable, "<this>");
        i.e((Object)m, "destination");
        g((java.util.Map<? super Object, ? super Object>)m, (java.lang.Iterable<? extends c2.j<?, ?>>)iterable);
        return m;
    }
    
    public static <K, V> Map<K, V> k(final Map<? extends K, ? extends V> map) {
        i.e((Object)map, "<this>");
        final int size = map.size();
        Map map2;
        if (size != 0) {
            if (size != 1) {
                map2 = m((java.util.Map<?, ?>)map);
            }
            else {
                map2 = c0.c((Map)map);
            }
        }
        else {
            map2 = a0.d();
        }
        return (Map<K, V>)map2;
    }
    
    public static final <K, V, M extends Map<? super K, ? super V>> M l(final j<? extends K, ? extends V>[] array, final M m) {
        i.e((Object)array, "<this>");
        i.e((Object)m, "destination");
        h((java.util.Map<? super Object, ? super Object>)m, (c2.j<?, ?>[])array);
        return m;
    }
    
    public static final <K, V> Map<K, V> m(final Map<? extends K, ? extends V> map) {
        i.e((Object)map, "<this>");
        return (Map<K, V>)new LinkedHashMap((Map)map);
    }
}
