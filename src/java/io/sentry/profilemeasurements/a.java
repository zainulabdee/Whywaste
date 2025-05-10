package io.sentry.profilemeasurements;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.util.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import io.sentry.m1;

public final class a implements m1
{
    private Map<String, Object> e;
    private String f;
    private Collection<b> g;
    
    public a() {
        this("unknown", (Collection<b>)new ArrayList());
    }
    
    public a(final String f, final Collection<b> g) {
        this.f = f;
        this.g = g;
    }
    
    public void c(final Map<String, Object> e) {
        this.e = e;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && a.class == o.getClass()) {
            final a a = (a)o;
            if (!n.a((Object)this.e, (Object)a.e) || !this.f.equals((Object)a.f) || !new ArrayList((Collection)this.g).equals(new ArrayList((Collection)a.g))) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return n.b(new Object[] { this.e, this.f, this.g });
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("unit").z(n0, this.f);
        k1.y("values").z(n0, this.g);
        final Map<String, Object> e = this.e;
        if (e != null) {
            for (final String s : e.keySet()) {
                final Object value = this.e.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<io.sentry.profilemeasurements.a>
    {
        public io.sentry.profilemeasurements.a b(final i1 i1, final n0 n0) {
            i1.b();
            final io.sentry.profilemeasurements.a a = new io.sentry.profilemeasurements.a();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                if (!r.equals((Object)"values")) {
                    if (!r.equals((Object)"unit")) {
                        Object o;
                        if ((o = map) == null) {
                            o = new ConcurrentHashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                    }
                    else {
                        final String u = i1.U();
                        if (u == null) {
                            continue;
                        }
                        a.f = u;
                    }
                }
                else {
                    final java.util.List<Object> p2 = i1.P(n0, (io.sentry.c1<Object>)new b.a());
                    if (p2 == null) {
                        continue;
                    }
                    a.g = (Collection<b>)p2;
                }
            }
            a.c(map);
            i1.h();
            return a;
        }
    }
}
