package d2;

import java.util.Map$Entry;
import java.util.Collections;
import kotlin.jvm.internal.i;
import java.util.Map;
import c2.j;

class c0 extends b0
{
    public static int a(int n) {
        if (n >= 0) {
            if (n < 3) {
                ++n;
            }
            else if (n < 1073741824) {
                n = (int)(n / 0.75f + 1.0f);
            }
            else {
                n = Integer.MAX_VALUE;
            }
        }
        return n;
    }
    
    public static final <K, V> Map<K, V> b(final j<? extends K, ? extends V> j) {
        i.e((Object)j, "pair");
        final Map singletonMap = Collections.singletonMap(j.c(), j.d());
        i.d((Object)singletonMap, "singletonMap(pair.first, pair.second)");
        return (Map<K, V>)singletonMap;
    }
    
    public static final <K, V> Map<K, V> c(final Map<? extends K, ? extends V> map) {
        i.e((Object)map, "<this>");
        final Map$Entry map$Entry = (Map$Entry)map.entrySet().iterator().next();
        final Map singletonMap = Collections.singletonMap(map$Entry.getKey(), map$Entry.getValue());
        i.d((Object)singletonMap, "with(entries.iterator().\u2026ingletonMap(key, value) }");
        return (Map<K, V>)singletonMap;
    }
}
