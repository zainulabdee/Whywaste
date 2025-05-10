package io.sentry;

import java.util.Iterator;
import java.util.Map$Entry;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import io.sentry.protocol.u;
import java.util.List;
import io.sentry.protocol.v;
import io.sentry.protocol.w;
import io.sentry.util.n;

public final class t4
{
    private final s4 a;
    private final q4 b;
    
    public t4(final s4 s4, final q4 q4) {
        this.a = n.c(s4, "The SentryStackTraceFactory is required.");
        this.b = n.c(q4, "The SentryOptions is required");
    }
    
    private w d(final boolean b, final StackTraceElement[] array, final Thread thread) {
        final w w = new w();
        w.w(thread.getName());
        w.x(Integer.valueOf(thread.getPriority()));
        w.u(Long.valueOf(thread.getId()));
        w.s(Boolean.valueOf(thread.isDaemon()));
        w.z(((Enum)thread.getState()).name());
        w.q(Boolean.valueOf(b));
        final List<u> a = this.a.a(array);
        if (this.b.isAttachStacktrace() && a != null && !a.isEmpty()) {
            final v v = new v((List)a);
            v.e(Boolean.TRUE);
            w.y(v);
        }
        return w;
    }
    
    List<w> a() {
        final HashMap hashMap = new HashMap();
        final Thread currentThread = Thread.currentThread();
        ((Map)hashMap).put((Object)currentThread, (Object)currentThread.getStackTrace());
        return this.c((Map<Thread, StackTraceElement[]>)hashMap, null, false);
    }
    
    List<w> b(final List<Long> list, final boolean b) {
        return this.c((Map<Thread, StackTraceElement[]>)Thread.getAllStackTraces(), list, b);
    }
    
    List<w> c(final Map<Thread, StackTraceElement[]> map, final List<Long> list, final boolean b) {
        final Thread currentThread = Thread.currentThread();
        List<w> list3;
        if (!map.isEmpty()) {
            final ArrayList list2 = new ArrayList();
            if (!map.containsKey((Object)currentThread)) {
                map.put((Object)currentThread, (Object)currentThread.getStackTrace());
            }
            final Iterator iterator = map.entrySet().iterator();
            while (true) {
                list3 = (List<w>)list2;
                if (!iterator.hasNext()) {
                    break;
                }
                final Map$Entry map$Entry = (Map$Entry)iterator.next();
                final Thread thread = (Thread)map$Entry.getKey();
                ((List)list2).add((Object)this.d((thread == currentThread && !b) || (list != null && list.contains((Object)thread.getId())), (StackTraceElement[])map$Entry.getValue(), (Thread)map$Entry.getKey()));
            }
        }
        else {
            list3 = null;
        }
        return list3;
    }
}
