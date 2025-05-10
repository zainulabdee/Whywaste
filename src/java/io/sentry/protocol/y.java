package io.sentry.protocol;

import java.util.concurrent.ConcurrentHashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Map;
import io.sentry.m1;

public final class y implements m1
{
    private final String e;
    private Map<String, Object> f;
    
    public y(final String e) {
        this.e = e;
    }
    
    public void a(final Map<String, Object> f) {
        this.f = f;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("source").z(n0, this.e);
        }
        final Map<String, Object> f = this.f;
        if (f != null) {
            for (final String s : f.keySet()) {
                final Object value = this.f.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<y>
    {
        public y b(final i1 i1, final n0 n0) {
            i1.b();
            String u = null;
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                if (!r.equals((Object)"source")) {
                    Object o;
                    if ((o = map) == null) {
                        o = new ConcurrentHashMap();
                    }
                    i1.W(n0, (Map<String, Object>)o, r);
                    map = (Map<String, Object>)o;
                }
                else {
                    u = i1.U();
                }
            }
            final y y = new y(u);
            y.a(map);
            i1.h();
            return y;
        }
    }
}
