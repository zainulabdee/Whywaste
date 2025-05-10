package io.sentry.protocol;

import java.util.concurrent.ConcurrentHashMap;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.util.b;
import java.util.Map;
import io.sentry.m1;

public final class m implements m1
{
    private String e;
    private Map<String, String> f;
    private Integer g;
    private Long h;
    private Object i;
    private Map<String, Object> j;
    
    public m() {
    }
    
    public m(final m m) {
        this.e = m.e;
        this.f = (Map<String, String>)b.b((Map)m.f);
        this.j = (Map<String, Object>)b.b((Map)m.j);
        this.g = m.g;
        this.h = m.h;
        this.i = m.i;
    }
    
    public void f(final Map<String, Object> j) {
        this.j = j;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("cookies").v(this.e);
        }
        if (this.f != null) {
            k1.y("headers").z(n0, this.f);
        }
        if (this.g != null) {
            k1.y("status_code").z(n0, this.g);
        }
        if (this.h != null) {
            k1.y("body_size").z(n0, this.h);
        }
        if (this.i != null) {
            k1.y("data").z(n0, this.i);
        }
        final Map<String, Object> j = this.j;
        if (j != null) {
            for (final String s : j.keySet()) {
                final Object value = this.j.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<m>
    {
        public m b(final i1 i1, final n0 n0) {
            i1.b();
            final m m = new m();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1252988030: {
                        if (!r.equals((Object)"body_size")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 952189583: {
                        if (!r.equals((Object)"cookies")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 795307910: {
                        if (!r.equals((Object)"headers")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case 3076010: {
                        if (!r.equals((Object)"data")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -891699686: {
                        if (!r.equals((Object)"status_code")) {
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
                    case 4: {
                        m.h = i1.Q();
                        continue;
                    }
                    case 3: {
                        m.e = i1.U();
                        continue;
                    }
                    case 2: {
                        final Map map2 = (Map)i1.S();
                        if (map2 != null) {
                            m.f = (Map<String, String>)b.b(map2);
                            continue;
                        }
                        continue;
                    }
                    case 1: {
                        m.i = i1.S();
                        continue;
                    }
                    case 0: {
                        m.g = i1.O();
                        continue;
                    }
                }
            }
            m.f(map);
            i1.h();
            return m;
        }
    }
}
