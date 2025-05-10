package io.sentry.protocol;

import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Map;
import io.sentry.m1;

public final class i implements m1
{
    private final transient Thread e;
    private String f;
    private String g;
    private String h;
    private Boolean i;
    private Map<String, Object> j;
    private Map<String, Object> k;
    private Boolean l;
    private Map<String, Object> m;
    
    public i() {
        this(null);
    }
    
    public i(final Thread e) {
        this.e = e;
    }
    
    public Boolean h() {
        return this.i;
    }
    
    public void i(final Boolean i) {
        this.i = i;
    }
    
    public void j(final String f) {
        this.f = f;
    }
    
    public void k(final Map<String, Object> m) {
        this.m = m;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.f != null) {
            k1.y("type").v(this.f);
        }
        if (this.g != null) {
            k1.y("description").v(this.g);
        }
        if (this.h != null) {
            k1.y("help_link").v(this.h);
        }
        if (this.i != null) {
            k1.y("handled").t(this.i);
        }
        if (this.j != null) {
            k1.y("meta").z(n0, this.j);
        }
        if (this.k != null) {
            k1.y("data").z(n0, this.k);
        }
        if (this.l != null) {
            k1.y("synthetic").t(this.l);
        }
        final Map<String, Object> m = this.m;
        if (m != null) {
            for (final String s : m.keySet()) {
                k1.y(s).z(n0, this.m.get((Object)s));
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<i>
    {
        public i b(final i1 i1, final n0 n0) {
            final i j = new i();
            i1.b();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1297152568: {
                        if (!r.equals((Object)"help_link")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 989128517: {
                        if (!r.equals((Object)"synthetic")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 692803388: {
                        if (!r.equals((Object)"handled")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 3575610: {
                        if (!r.equals((Object)"type")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 3347973: {
                        if (!r.equals((Object)"meta")) {
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
                    case -1724546052: {
                        if (!r.equals((Object)"description")) {
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
                    case 6: {
                        j.h = i1.U();
                        continue;
                    }
                    case 5: {
                        j.l = i1.J();
                        continue;
                    }
                    case 4: {
                        j.i = i1.J();
                        continue;
                    }
                    case 3: {
                        j.f = i1.U();
                        continue;
                    }
                    case 2: {
                        j.j = (Map<String, Object>)io.sentry.util.b.b((Map)i1.S());
                        continue;
                    }
                    case 1: {
                        j.k = (Map<String, Object>)io.sentry.util.b.b((Map)i1.S());
                        continue;
                    }
                    case 0: {
                        j.g = i1.U();
                        continue;
                    }
                }
            }
            i1.h();
            j.k(map);
            return j;
        }
    }
}
