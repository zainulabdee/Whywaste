package io.sentry;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import io.sentry.util.n;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.Map;

public final class q implements x
{
    private final Map<Throwable, Object> e;
    private final q4 f;
    
    public q(final q4 q4) {
        this.e = (Map<Throwable, Object>)Collections.synchronizedMap((Map)new WeakHashMap());
        this.f = (q4)n.c((Object)q4, "options are required");
    }
    
    private static List<Throwable> a(Throwable cause) {
        final ArrayList list = new ArrayList();
        while (cause.getCause() != null) {
            ((List)list).add((Object)cause.getCause());
            cause = cause.getCause();
        }
        return (List<Throwable>)list;
    }
    
    private static <T> boolean d(final Map<T, Object> map, final List<T> list) {
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (map.containsKey(iterator.next())) {
                return true;
            }
        }
        return false;
    }
    
    public e4 c(final e4 e4, final a0 a0) {
        if (this.f.isEnableDeduplication()) {
            final Throwable o = e4.O();
            if (o != null) {
                if (this.e.containsKey((Object)o) || d(this.e, a(o))) {
                    this.f.getLogger().a(l4.DEBUG, "Duplicate Exception detected. Event %s will be discarded.", new Object[] { e4.G() });
                    return null;
                }
                this.e.put((Object)o, (Object)null);
            }
        }
        else {
            this.f.getLogger().a(l4.DEBUG, "Event deduplication is disabled.", new Object[0]);
        }
        return e4;
    }
}
