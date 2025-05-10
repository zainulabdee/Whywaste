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
import java.util.Date;
import io.sentry.m1;

public final class a implements m1
{
    private String e;
    private Date f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private Map<String, String> l;
    private Boolean m;
    private Map<String, Object> n;
    
    public a() {
    }
    
    a(final a a) {
        this.k = a.k;
        this.e = a.e;
        this.i = a.i;
        this.f = a.f;
        this.j = a.j;
        this.h = a.h;
        this.g = a.g;
        this.l = (Map<String, String>)b.b((Map)a.l);
        this.m = a.m;
        this.n = (Map<String, Object>)b.b((Map)a.n);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && a.class == o.getClass()) {
            final a a = (a)o;
            if (!io.sentry.util.n.a((Object)this.e, (Object)a.e) || !io.sentry.util.n.a((Object)this.f, (Object)a.f) || !io.sentry.util.n.a((Object)this.g, (Object)a.g) || !io.sentry.util.n.a((Object)this.h, (Object)a.h) || !io.sentry.util.n.a((Object)this.i, (Object)a.i) || !io.sentry.util.n.a((Object)this.j, (Object)a.j) || !io.sentry.util.n.a((Object)this.k, (Object)a.k)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return io.sentry.util.n.b(new Object[] { this.e, this.f, this.g, this.h, this.i, this.j, this.k });
    }
    
    public Boolean j() {
        return this.m;
    }
    
    public void k(final String k) {
        this.k = k;
    }
    
    public void l(final String e) {
        this.e = e;
    }
    
    public void m(final String i) {
        this.i = i;
    }
    
    public void n(final Date f) {
        this.f = f;
    }
    
    public void o(final String j) {
        this.j = j;
    }
    
    public void p(final Boolean m) {
        this.m = m;
    }
    
    public void q(final Map<String, String> l) {
        this.l = l;
    }
    
    public void r(final Map<String, Object> n) {
        this.n = n;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("app_identifier").v(this.e);
        }
        if (this.f != null) {
            k1.y("app_start_time").z(n0, this.f);
        }
        if (this.g != null) {
            k1.y("device_app_hash").v(this.g);
        }
        if (this.h != null) {
            k1.y("build_type").v(this.h);
        }
        if (this.i != null) {
            k1.y("app_name").v(this.i);
        }
        if (this.j != null) {
            k1.y("app_version").v(this.j);
        }
        if (this.k != null) {
            k1.y("app_build").v(this.k);
        }
        final Map<String, String> l = this.l;
        if (l != null && !l.isEmpty()) {
            k1.y("permissions").z(n0, this.l);
        }
        if (this.m != null) {
            k1.y("in_foreground").t(this.m);
        }
        final Map<String, Object> n2 = this.n;
        if (n2 != null) {
            for (final String s : n2.keySet()) {
                k1.y(s).z(n0, this.n.get((Object)s));
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<io.sentry.protocol.a>
    {
        public io.sentry.protocol.a b(final i1 i1, final n0 n0) {
            i1.b();
            final io.sentry.protocol.a a = new io.sentry.protocol.a();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1826866896: {
                        if (!r.equals((Object)"app_build")) {
                            break;
                        }
                        n2 = 8;
                        break;
                    }
                    case 1167648233: {
                        if (!r.equals((Object)"app_name")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case 1133704324: {
                        if (!r.equals((Object)"permissions")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 791585128: {
                        if (!r.equals((Object)"app_start_time")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 746297735: {
                        if (!r.equals((Object)"app_identifier")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case -470395285: {
                        if (!r.equals((Object)"build_type")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case -650544995: {
                        if (!r.equals((Object)"in_foreground")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -901870406: {
                        if (!r.equals((Object)"app_version")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1898053579: {
                        if (!r.equals((Object)"device_app_hash")) {
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
                        a.k = i1.U();
                        continue;
                    }
                    case 7: {
                        a.i = i1.U();
                        continue;
                    }
                    case 6: {
                        a.l = (Map<String, String>)b.b((Map)i1.S());
                        continue;
                    }
                    case 5: {
                        a.f = i1.K(n0);
                        continue;
                    }
                    case 4: {
                        a.e = i1.U();
                        continue;
                    }
                    case 3: {
                        a.h = i1.U();
                        continue;
                    }
                    case 2: {
                        a.m = i1.J();
                        continue;
                    }
                    case 1: {
                        a.j = i1.U();
                        continue;
                    }
                    case 0: {
                        a.g = i1.U();
                        continue;
                    }
                }
            }
            a.r(map);
            i1.h();
            return a;
        }
    }
}
