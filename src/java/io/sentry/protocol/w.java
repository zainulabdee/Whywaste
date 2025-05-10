package io.sentry.protocol;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.m4;
import java.util.Map;
import io.sentry.m1;

public final class w implements m1
{
    private Long e;
    private Integer f;
    private String g;
    private String h;
    private Boolean i;
    private Boolean j;
    private Boolean k;
    private Boolean l;
    private v m;
    private Map<String, m4> n;
    private Map<String, Object> o;
    
    public void A(final Map<String, Object> o) {
        this.o = o;
    }
    
    public Map<String, m4> k() {
        return this.n;
    }
    
    public Long l() {
        return this.e;
    }
    
    public String m() {
        return this.g;
    }
    
    public v n() {
        return this.m;
    }
    
    public Boolean o() {
        return this.j;
    }
    
    public Boolean p() {
        return this.l;
    }
    
    public void q(final Boolean i) {
        this.i = i;
    }
    
    public void r(final Boolean j) {
        this.j = j;
    }
    
    public void s(final Boolean k) {
        this.k = k;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("id").u((Number)this.e);
        }
        if (this.f != null) {
            k1.y("priority").u((Number)this.f);
        }
        if (this.g != null) {
            k1.y("name").v(this.g);
        }
        if (this.h != null) {
            k1.y("state").v(this.h);
        }
        if (this.i != null) {
            k1.y("crashed").t(this.i);
        }
        if (this.j != null) {
            k1.y("current").t(this.j);
        }
        if (this.k != null) {
            k1.y("daemon").t(this.k);
        }
        if (this.l != null) {
            k1.y("main").t(this.l);
        }
        if (this.m != null) {
            k1.y("stacktrace").z(n0, this.m);
        }
        if (this.n != null) {
            k1.y("held_locks").z(n0, this.n);
        }
        final Map<String, Object> o = this.o;
        if (o != null) {
            for (final String s : o.keySet()) {
                final Object value = this.o.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public void t(final Map<String, m4> n) {
        this.n = n;
    }
    
    public void u(final Long e) {
        this.e = e;
    }
    
    public void v(final Boolean l) {
        this.l = l;
    }
    
    public void w(final String g) {
        this.g = g;
    }
    
    public void x(final Integer f) {
        this.f = f;
    }
    
    public void y(final v m) {
        this.m = m;
    }
    
    public void z(final String h) {
        this.h = h;
    }
    
    public static final class a implements c1<w>
    {
        public w b(final i1 i1, final n0 n0) {
            final w w = new w();
            i1.b();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 2055832509: {
                        if (!r.equals((Object)"stacktrace")) {
                            break;
                        }
                        n2 = 9;
                        break;
                    }
                    case 1126940025: {
                        if (!r.equals((Object)"current")) {
                            break;
                        }
                        n2 = 8;
                        break;
                    }
                    case 1025385094: {
                        if (!r.equals((Object)"crashed")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case 109757585: {
                        if (!r.equals((Object)"state")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 3373707: {
                        if (!r.equals((Object)"name")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 3343801: {
                        if (!r.equals((Object)"main")) {
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
                    case -502917346: {
                        if (!r.equals((Object)"held_locks")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -1165461084: {
                        if (!r.equals((Object)"priority")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1339353468: {
                        if (!r.equals((Object)"daemon")) {
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
                    case 9: {
                        w.m = i1.T(n0, (io.sentry.c1<v>)new v.a());
                        continue;
                    }
                    case 8: {
                        w.j = i1.J();
                        continue;
                    }
                    case 7: {
                        w.i = i1.J();
                        continue;
                    }
                    case 6: {
                        w.h = i1.U();
                        continue;
                    }
                    case 5: {
                        w.g = i1.U();
                        continue;
                    }
                    case 4: {
                        w.l = i1.J();
                        continue;
                    }
                    case 3: {
                        w.e = i1.Q();
                        continue;
                    }
                    case 2: {
                        final java.util.Map<String, Object> r2 = i1.R(n0, (io.sentry.c1<Object>)new m4.a());
                        if (r2 != null) {
                            w.n = (Map<String, m4>)new HashMap((Map)r2);
                            continue;
                        }
                        continue;
                    }
                    case 1: {
                        w.f = i1.O();
                        continue;
                    }
                    case 0: {
                        w.k = i1.J();
                        continue;
                    }
                }
            }
            w.A(map);
            i1.h();
            return w;
        }
    }
}
