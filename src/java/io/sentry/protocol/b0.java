package io.sentry.protocol;

import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Map;
import java.util.List;
import io.sentry.m1;

public final class b0 implements m1
{
    private final String e;
    private final List<c0> f;
    private Map<String, Object> g;
    
    public b0(final String e, final List<c0> f) {
        this.e = e;
        this.f = f;
    }
    
    public void a(final Map<String, Object> g) {
        this.g = g;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("rendering_system").v(this.e);
        }
        if (this.f != null) {
            k1.y("windows").z(n0, this.f);
        }
        final Map<String, Object> g = this.g;
        if (g != null) {
            for (final String s : g.keySet()) {
                k1.y(s).z(n0, this.g.get((Object)s));
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<b0>
    {
        public b0 b(final i1 i1, final n0 n0) {
            i1.b();
            String u = null;
            List<c0> p2 = null;
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                if (!r.equals((Object)"rendering_system")) {
                    if (!r.equals((Object)"windows")) {
                        Object o;
                        if ((o = map) == null) {
                            o = new HashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                    }
                    else {
                        p2 = i1.P(n0, (io.sentry.c1<c0>)new c0.a());
                    }
                }
                else {
                    u = i1.U();
                }
            }
            i1.h();
            final b0 b0 = new b0(u, p2);
            b0.a(map);
            return b0;
        }
    }
}
