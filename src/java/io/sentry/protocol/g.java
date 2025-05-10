package io.sentry.protocol;

import java.util.concurrent.ConcurrentHashMap;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.util.n;
import io.sentry.util.b;
import java.util.Map;
import io.sentry.m1;

public final class g implements m1
{
    private String e;
    private Integer f;
    private String g;
    private String h;
    private Integer i;
    private String j;
    private Boolean k;
    private String l;
    private String m;
    private Map<String, Object> n;
    
    public g() {
    }
    
    g(final g g) {
        this.e = g.e;
        this.f = g.f;
        this.g = g.g;
        this.h = g.h;
        this.i = g.i;
        this.j = g.j;
        this.k = g.k;
        this.l = g.l;
        this.m = g.m;
        this.n = (Map<String, Object>)b.b((Map)g.n);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && g.class == o.getClass()) {
            final g g = (g)o;
            if (!io.sentry.util.n.a((Object)this.e, (Object)g.e) || !io.sentry.util.n.a((Object)this.f, (Object)g.f) || !io.sentry.util.n.a((Object)this.g, (Object)g.g) || !io.sentry.util.n.a((Object)this.h, (Object)g.h) || !io.sentry.util.n.a((Object)this.i, (Object)g.i) || !io.sentry.util.n.a((Object)this.j, (Object)g.j) || !io.sentry.util.n.a((Object)this.k, (Object)g.k) || !io.sentry.util.n.a((Object)this.l, (Object)g.l) || !io.sentry.util.n.a((Object)this.m, (Object)g.m)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return io.sentry.util.n.b(new Object[] { this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m });
    }
    
    public void j(final Map<String, Object> n) {
        this.n = n;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("name").v(this.e);
        }
        if (this.f != null) {
            k1.y("id").u((Number)this.f);
        }
        if (this.g != null) {
            k1.y("vendor_id").v(this.g);
        }
        if (this.h != null) {
            k1.y("vendor_name").v(this.h);
        }
        if (this.i != null) {
            k1.y("memory_size").u((Number)this.i);
        }
        if (this.j != null) {
            k1.y("api_type").v(this.j);
        }
        if (this.k != null) {
            k1.y("multi_threaded_rendering").t(this.k);
        }
        if (this.l != null) {
            k1.y("version").v(this.l);
        }
        if (this.m != null) {
            k1.y("npot_support").v(this.m);
        }
        final Map<String, Object> n2 = this.n;
        if (n2 != null) {
            for (final String s : n2.keySet()) {
                final Object value = this.n.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<g>
    {
        public g b(final i1 i1, final n0 n0) {
            i1.b();
            final g g = new g();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1418777727: {
                        if (!r.equals((Object)"memory_size")) {
                            break;
                        }
                        n2 = 8;
                        break;
                    }
                    case 967446079: {
                        if (!r.equals((Object)"api_type")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case 351608024: {
                        if (!r.equals((Object)"version")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 59480866: {
                        if (!r.equals((Object)"vendor_name")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 3373707: {
                        if (!r.equals((Object)"name")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 3355: {
                        if (!r.equals((Object)"id")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case -1009234244: {
                        if (!r.equals((Object)"multi_threaded_rendering")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -1085970574: {
                        if (!r.equals((Object)"vendor_id")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1421884745: {
                        if (!r.equals((Object)"npot_support")) {
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
                    case 8: {
                        g.i = i1.O();
                        continue;
                    }
                    case 7: {
                        g.j = i1.U();
                        continue;
                    }
                    case 6: {
                        g.l = i1.U();
                        continue;
                    }
                    case 5: {
                        g.h = i1.U();
                        continue;
                    }
                    case 4: {
                        g.e = i1.U();
                        continue;
                    }
                    case 3: {
                        g.f = i1.O();
                        continue;
                    }
                    case 2: {
                        g.k = i1.J();
                        continue;
                    }
                    case 1: {
                        g.g = i1.U();
                        continue;
                    }
                    case 0: {
                        g.m = i1.U();
                        continue;
                    }
                }
            }
            g.j(map);
            i1.h();
            return g;
        }
    }
}
