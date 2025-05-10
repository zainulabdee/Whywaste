package io.sentry.protocol;

import io.sentry.l4;
import java.util.concurrent.ConcurrentHashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Map;
import io.sentry.m1;

public final class h implements m1
{
    private final Number e;
    private final String f;
    private Map<String, Object> g;
    
    public h(final Number e, final String f) {
        this.e = e;
        this.f = f;
    }
    
    public Number a() {
        return this.e;
    }
    
    public void b(final Map<String, Object> g) {
        this.g = g;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("value").u(this.e);
        if (this.f != null) {
            k1.y("unit").v(this.f);
        }
        final Map<String, Object> g = this.g;
        if (g != null) {
            for (final String s : g.keySet()) {
                final Object value = this.g.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<h>
    {
        public h b(final i1 i1, final n0 n0) {
            i1.b();
            Number n2 = null;
            String u = null;
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                if (!r.equals((Object)"unit")) {
                    if (!r.equals((Object)"value")) {
                        Object o;
                        if ((o = map) == null) {
                            o = new ConcurrentHashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                    }
                    else {
                        n2 = (Number)i1.S();
                    }
                }
                else {
                    u = i1.U();
                }
            }
            i1.h();
            if (n2 != null) {
                final h h = new h(n2, u);
                h.b(map);
                return h;
            }
            final IllegalStateException ex = new IllegalStateException("Missing required field \"value\"");
            n0.d(l4.ERROR, "Missing required field \"value\"", (Throwable)ex);
            throw ex;
        }
    }
}
