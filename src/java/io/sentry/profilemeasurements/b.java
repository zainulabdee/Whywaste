package io.sentry.profilemeasurements;

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
    private Map<String, Object> e;
    private String f;
    private double g;
    
    public b() {
        this(0L, (Number)0);
    }
    
    public b(final Long n, final Number n2) {
        this.f = n.toString();
        this.g = n2.doubleValue();
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
        if (o != null && b.class == o.getClass()) {
            final b b2 = (b)o;
            if (!n.a((Object)this.e, (Object)b2.e) || !this.f.equals((Object)b2.f) || this.g != b2.g) {
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
        k1.y("value").z(n0, this.g);
        k1.y("elapsed_since_start_ns").z(n0, this.f);
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
    
    public static final class a implements c1<b>
    {
        public b b(final i1 i1, final n0 n0) {
            i1.b();
            final b b = new b();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                if (!r.equals((Object)"elapsed_since_start_ns")) {
                    if (!r.equals((Object)"value")) {
                        Object o;
                        if ((o = map) == null) {
                            o = new ConcurrentHashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                    }
                    else {
                        final Double l = i1.L();
                        if (l == null) {
                            continue;
                        }
                        b.g = l;
                    }
                }
                else {
                    final String u = i1.U();
                    if (u == null) {
                        continue;
                    }
                    b.f = u;
                }
            }
            b.c(map);
            i1.h();
            return b;
        }
    }
}
