package io.sentry.protocol;

import io.sentry.l4;
import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Objects;
import io.sentry.util.n;
import java.util.Map;
import io.sentry.m1;

public final class r implements m1
{
    private String e;
    private String f;
    private Map<String, Object> g;
    
    public r(final String s, final String s2) {
        this.e = (String)n.c((Object)s, "name is required.");
        this.f = (String)n.c((Object)s2, "version is required.");
    }
    
    public String a() {
        return this.e;
    }
    
    public String b() {
        return this.f;
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
        if (o != null && r.class == o.getClass()) {
            final r r = (r)o;
            if (!Objects.equals((Object)this.e, (Object)r.e) || !Objects.equals((Object)this.f, (Object)r.f)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(new Object[] { this.e, this.f });
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("name").v(this.e);
        k1.y("version").v(this.f);
        final Map<String, Object> g = this.g;
        if (g != null) {
            for (final String s : g.keySet()) {
                k1.y(s).z(n0, this.g.get((Object)s));
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<r>
    {
        public r b(final i1 i1, final n0 n0) {
            i1.b();
            String v = null;
            String v2 = null;
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                if (!r.equals((Object)"name")) {
                    if (!r.equals((Object)"version")) {
                        Object o;
                        if ((o = map) == null) {
                            o = new HashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                    }
                    else {
                        v2 = i1.v();
                    }
                }
                else {
                    v = i1.v();
                }
            }
            i1.h();
            if (v == null) {
                final IllegalStateException ex = new IllegalStateException("Missing required field \"name\"");
                n0.d(l4.ERROR, "Missing required field \"name\"", (Throwable)ex);
                throw ex;
            }
            if (v2 != null) {
                final r r2 = new r(v, v2);
                r2.c(map);
                return r2;
            }
            final IllegalStateException ex2 = new IllegalStateException("Missing required field \"version\"");
            n0.d(l4.ERROR, "Missing required field \"version\"", (Throwable)ex2);
            throw ex2;
        }
    }
}
