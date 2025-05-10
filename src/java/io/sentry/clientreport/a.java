package io.sentry.clientreport;

import java.util.Iterator;
import java.util.Map$Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import io.sentry.i;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Map;

final class a implements h
{
    private final Map<c, AtomicLong> a;
    
    public a() {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (final e e : e.values()) {
            final i[] values2 = i.values();
            for (int length2 = values2.length, j = 0; j < length2; ++j) {
                ((Map)concurrentHashMap).put((Object)new c(e.getReason(), values2[j].getCategory()), (Object)new AtomicLong(0L));
            }
        }
        this.a = (Map<c, AtomicLong>)Collections.unmodifiableMap((Map)concurrentHashMap);
    }
    
    public List<f> a() {
        final ArrayList list = new ArrayList();
        for (final Map$Entry map$Entry : this.a.entrySet()) {
            final Long value = ((AtomicLong)map$Entry.getValue()).getAndSet(0L);
            if (value > 0L) {
                ((List)list).add((Object)new f(((c)map$Entry.getKey()).b(), ((c)map$Entry.getKey()).a(), value));
            }
        }
        return (List<f>)list;
    }
    
    public void b(final c c, final Long n) {
        final AtomicLong atomicLong = (AtomicLong)this.a.get((Object)c);
        if (atomicLong != null) {
            atomicLong.addAndGet((long)n);
        }
    }
}
