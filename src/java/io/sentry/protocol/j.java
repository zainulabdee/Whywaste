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

public final class j implements m1
{
    private String e;
    private String f;
    private List<String> g;
    private Map<String, Object> h;
    
    public void d(final String e) {
        this.e = e;
    }
    
    public void e(final Map<String, Object> h) {
        this.h = h;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("formatted").v(this.e);
        }
        if (this.f != null) {
            k1.y("message").v(this.f);
        }
        final List<String> g = this.g;
        if (g != null && !g.isEmpty()) {
            k1.y("params").z(n0, this.g);
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
    
    public static final class a implements c1<j>
    {
        public j b(final i1 i1, final n0 n0) {
            i1.b();
            final j j = new j();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1811591356: {
                        if (!r.equals((Object)"formatted")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case 954925063: {
                        if (!r.equals((Object)"message")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -995427962: {
                        if (!r.equals((Object)"params")) {
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
                        j.e = i1.U();
                        continue;
                    }
                    case 1: {
                        j.f = i1.U();
                        continue;
                    }
                    case 0: {
                        final List list = (List)i1.S();
                        if (list != null) {
                            j.g = (List<String>)list;
                            continue;
                        }
                        continue;
                    }
                }
            }
            j.e(map);
            i1.h();
            return j;
        }
    }
}
