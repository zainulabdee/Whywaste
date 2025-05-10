package io.sentry.clientreport;

import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.l4;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Map;
import io.sentry.m1;

public final class f implements m1
{
    private final String e;
    private final String f;
    private final Long g;
    private Map<String, Object> h;
    
    public f(final String e, final String f, final Long g) {
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public String a() {
        return this.f;
    }
    
    public Long b() {
        return this.g;
    }
    
    public String c() {
        return this.e;
    }
    
    public void d(final Map<String, Object> h) {
        this.h = h;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("reason").v(this.e);
        k1.y("category").v(this.f);
        k1.y("quantity").u((Number)this.g);
        final Map<String, Object> h = this.h;
        if (h != null) {
            for (final String s : h.keySet()) {
                k1.y(s).z(n0, this.h.get((Object)s));
            }
        }
        k1.h();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("DiscardedEvent{reason='");
        sb.append(this.e);
        sb.append('\'');
        sb.append(", category='");
        sb.append(this.f);
        sb.append('\'');
        sb.append(", quantity=");
        sb.append((Object)this.g);
        sb.append('}');
        return sb.toString();
    }
    
    public static final class a implements c1<f>
    {
        private Exception c(final String s, final n0 n0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Missing required field \"");
            sb.append(s);
            sb.append("\"");
            final String string = sb.toString();
            final IllegalStateException ex = new IllegalStateException(string);
            n0.d(l4.ERROR, string, (Throwable)ex);
            return (Exception)ex;
        }
        
        public f b(final i1 i1, final n0 n0) {
            i1.b();
            String u = null;
            String u2 = null;
            Map<String, Object> map;
            Object q = map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 50511102: {
                        if (!r.equals((Object)"category")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -934964668: {
                        if (!r.equals((Object)"reason")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1285004149: {
                        if (!r.equals((Object)"quantity")) {
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
                            o = new HashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                        continue;
                    }
                    case 2: {
                        u2 = i1.U();
                        continue;
                    }
                    case 1: {
                        u = i1.U();
                        continue;
                    }
                    case 0: {
                        q = i1.Q();
                        continue;
                    }
                }
            }
            i1.h();
            if (u == null) {
                throw this.c("reason", n0);
            }
            if (u2 == null) {
                throw this.c("category", n0);
            }
            if (q != null) {
                final f f = new f(u, u2, (Long)q);
                f.d(map);
                return f;
            }
            throw this.c("quantity", n0);
        }
    }
}
