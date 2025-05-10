package io.sentry.protocol;

import java.util.concurrent.ConcurrentHashMap;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.util.n;
import java.util.Map;
import io.sentry.m1;

public final class b implements m1
{
    private String e;
    private String f;
    private Map<String, Object> g;
    
    public b() {
    }
    
    b(final b b) {
        this.e = b.e;
        this.f = b.f;
        this.g = (Map<String, Object>)io.sentry.util.b.b((Map)b.g);
    }
    
    public void c(final Map<String, Object> g) {
        this.g = g;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && b.class == o.getClass()) {
            final b b2 = (b)o;
            if (!n.a((Object)this.e, (Object)b2.e) || !n.a((Object)this.f, (Object)b2.f)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return n.b(new Object[] { this.e, this.f });
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("name").v(this.e);
        }
        if (this.f != null) {
            k1.y("version").v(this.f);
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
    
    public static final class a implements c1<b>
    {
        public b b(final i1 i1, final n0 n0) {
            i1.b();
            final b b = new b();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                if (!r.equals((Object)"name")) {
                    if (!r.equals((Object)"version")) {
                        Object o;
                        if ((o = map) == null) {
                            o = new ConcurrentHashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                    }
                    else {
                        b.f = i1.U();
                    }
                }
                else {
                    b.e = i1.U();
                }
            }
            b.c(map);
            i1.h();
            return b;
        }
    }
}
