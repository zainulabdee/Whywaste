package io.sentry.protocol;

import java.util.concurrent.ConcurrentHashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Map;
import java.util.List;
import io.sentry.m1;

public final class v implements m1
{
    private List<u> e;
    private Map<String, String> f;
    private Boolean g;
    private Map<String, Object> h;
    
    public v() {
    }
    
    public v(final List<u> e) {
        this.e = e;
    }
    
    public List<u> d() {
        return this.e;
    }
    
    public void e(final Boolean g) {
        this.g = g;
    }
    
    public void f(final Map<String, Object> h) {
        this.h = h;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("frames").z(n0, this.e);
        }
        if (this.f != null) {
            k1.y("registers").z(n0, this.f);
        }
        if (this.g != null) {
            k1.y("snapshot").t(this.g);
        }
        final Map<String, Object> h = this.h;
        if (h != null) {
            for (final String s : h.keySet()) {
                final Object value = this.h.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<v>
    {
        public v b(final i1 i1, final n0 n0) {
            final v v = new v();
            i1.b();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 284874180: {
                        if (!r.equals((Object)"snapshot")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case 78226992: {
                        if (!r.equals((Object)"registers")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1266514778: {
                        if (!r.equals((Object)"frames")) {
                            break;
                        }
                        n2 = 0;
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        Object o = map;
                        if (map == null) {
                            o = new ConcurrentHashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                        continue;
                    }
                    case 2: {
                        v.g = i1.J();
                        continue;
                    }
                    case 1: {
                        v.f = (Map<String, String>)io.sentry.util.b.b((Map)i1.S());
                        continue;
                    }
                    case 0: {
                        v.e = (List<u>)i1.P(n0, (io.sentry.c1<Object>)new u.a());
                        continue;
                    }
                }
            }
            v.f(map);
            i1.h();
            return v;
        }
    }
}
