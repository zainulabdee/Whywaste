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

public final class l implements m1
{
    private String e;
    private String f;
    private String g;
    private Object h;
    private String i;
    private Map<String, String> j;
    private Map<String, String> k;
    private Long l;
    private Map<String, String> m;
    private String n;
    private String o;
    private Map<String, Object> p;
    
    public l() {
    }
    
    public l(final l l) {
        this.e = l.e;
        this.i = l.i;
        this.f = l.f;
        this.g = l.g;
        this.j = (Map<String, String>)b.b((Map)l.j);
        this.k = (Map<String, String>)b.b((Map)l.k);
        this.m = (Map<String, String>)b.b((Map)l.m);
        this.p = (Map<String, Object>)b.b((Map)l.p);
        this.h = l.h;
        this.n = l.n;
        this.l = l.l;
        this.o = l.o;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && l.class == o.getClass()) {
            final l l = (l)o;
            if (!io.sentry.util.n.a((Object)this.e, (Object)l.e) || !io.sentry.util.n.a((Object)this.f, (Object)l.f) || !io.sentry.util.n.a((Object)this.g, (Object)l.g) || !io.sentry.util.n.a((Object)this.i, (Object)l.i) || !io.sentry.util.n.a((Object)this.j, (Object)l.j) || !io.sentry.util.n.a((Object)this.k, (Object)l.k) || !io.sentry.util.n.a((Object)this.l, (Object)l.l) || !io.sentry.util.n.a((Object)this.n, (Object)l.n) || !io.sentry.util.n.a((Object)this.o, (Object)l.o)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return io.sentry.util.n.b(new Object[] { this.e, this.f, this.g, this.i, this.j, this.k, this.l, this.n, this.o });
    }
    
    public Map<String, String> l() {
        return this.j;
    }
    
    public void m(final Map<String, Object> p) {
        this.p = p;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("url").v(this.e);
        }
        if (this.f != null) {
            k1.y("method").v(this.f);
        }
        if (this.g != null) {
            k1.y("query_string").v(this.g);
        }
        if (this.h != null) {
            k1.y("data").z(n0, this.h);
        }
        if (this.i != null) {
            k1.y("cookies").v(this.i);
        }
        if (this.j != null) {
            k1.y("headers").z(n0, this.j);
        }
        if (this.k != null) {
            k1.y("env").z(n0, this.k);
        }
        if (this.m != null) {
            k1.y("other").z(n0, this.m);
        }
        if (this.n != null) {
            k1.y("fragment").z(n0, this.n);
        }
        if (this.l != null) {
            k1.y("body_size").z(n0, this.l);
        }
        if (this.o != null) {
            k1.y("api_target").z(n0, this.o);
        }
        final Map<String, Object> p2 = this.p;
        if (p2 != null) {
            for (final String s : p2.keySet()) {
                final Object value = this.p.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<l>
    {
        public l b(final i1 i1, final n0 n0) {
            i1.b();
            final l l = new l();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1980646230: {
                        if (!r.equals((Object)"api_target")) {
                            break;
                        }
                        n2 = 10;
                        break;
                    }
                    case 1595298664: {
                        if (!r.equals((Object)"query_string")) {
                            break;
                        }
                        n2 = 9;
                        break;
                    }
                    case 1252988030: {
                        if (!r.equals((Object)"body_size")) {
                            break;
                        }
                        n2 = 8;
                        break;
                    }
                    case 952189583: {
                        if (!r.equals((Object)"cookies")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case 795307910: {
                        if (!r.equals((Object)"headers")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 106069776: {
                        if (!r.equals((Object)"other")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 3076010: {
                        if (!r.equals((Object)"data")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 116079: {
                        if (!r.equals((Object)"url")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 100589: {
                        if (!r.equals((Object)"env")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -1077554975: {
                        if (!r.equals((Object)"method")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1650269616: {
                        if (!r.equals((Object)"fragment")) {
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
                    case 10: {
                        l.o = i1.U();
                        continue;
                    }
                    case 9: {
                        l.g = i1.U();
                        continue;
                    }
                    case 8: {
                        l.l = i1.Q();
                        continue;
                    }
                    case 7: {
                        l.i = i1.U();
                        continue;
                    }
                    case 6: {
                        final Map map2 = (Map)i1.S();
                        if (map2 != null) {
                            l.j = (Map<String, String>)b.b(map2);
                            continue;
                        }
                        continue;
                    }
                    case 5: {
                        final Map map3 = (Map)i1.S();
                        if (map3 != null) {
                            l.m = (Map<String, String>)b.b(map3);
                            continue;
                        }
                        continue;
                    }
                    case 4: {
                        l.h = i1.S();
                        continue;
                    }
                    case 3: {
                        l.e = i1.U();
                        continue;
                    }
                    case 2: {
                        final Map map4 = (Map)i1.S();
                        if (map4 != null) {
                            l.k = (Map<String, String>)b.b(map4);
                            continue;
                        }
                        continue;
                    }
                    case 1: {
                        l.f = i1.U();
                        continue;
                    }
                    case 0: {
                        l.n = i1.U();
                        continue;
                    }
                }
            }
            l.m(map);
            i1.h();
            return l;
        }
    }
}
