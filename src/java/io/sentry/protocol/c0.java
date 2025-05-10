package io.sentry.protocol;

import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Map;
import java.util.List;
import io.sentry.m1;

public final class c0 implements m1
{
    private String e;
    private String f;
    private String g;
    private String h;
    private Double i;
    private Double j;
    private Double k;
    private Double l;
    private String m;
    private Double n;
    private List<c0> o;
    private Map<String, Object> p;
    
    public void l(final Double n) {
        this.n = n;
    }
    
    public void m(final List<c0> o) {
        this.o = o;
    }
    
    public void n(final Double j) {
        this.j = j;
    }
    
    public void o(final String g) {
        this.g = g;
    }
    
    public void p(final String f) {
        this.f = f;
    }
    
    public void q(final Map<String, Object> p) {
        this.p = p;
    }
    
    public void r(final String m) {
        this.m = m;
    }
    
    public void s(final Double i) {
        this.i = i;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("rendering_system").v(this.e);
        }
        if (this.f != null) {
            k1.y("type").v(this.f);
        }
        if (this.g != null) {
            k1.y("identifier").v(this.g);
        }
        if (this.h != null) {
            k1.y("tag").v(this.h);
        }
        if (this.i != null) {
            k1.y("width").u((Number)this.i);
        }
        if (this.j != null) {
            k1.y("height").u((Number)this.j);
        }
        if (this.k != null) {
            k1.y("x").u((Number)this.k);
        }
        if (this.l != null) {
            k1.y("y").u((Number)this.l);
        }
        if (this.m != null) {
            k1.y("visibility").v(this.m);
        }
        if (this.n != null) {
            k1.y("alpha").u((Number)this.n);
        }
        final List<c0> o = this.o;
        if (o != null && !o.isEmpty()) {
            k1.y("children").z(n0, this.o);
        }
        final Map<String, Object> p2 = this.p;
        if (p2 != null) {
            for (final String s : p2.keySet()) {
                k1.y(s).z(n0, this.p.get((Object)s));
            }
        }
        k1.h();
    }
    
    public void t(final Double k) {
        this.k = k;
    }
    
    public void u(final Double l) {
        this.l = l;
    }
    
    public static final class a implements c1<c0>
    {
        public c0 b(final i1 i1, final n0 n0) {
            final c0 c0 = new c0();
            i1.b();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1941332754: {
                        if (!r.equals((Object)"visibility")) {
                            break;
                        }
                        n2 = 10;
                        break;
                    }
                    case 1659526655: {
                        if (!r.equals((Object)"children")) {
                            break;
                        }
                        n2 = 9;
                        break;
                    }
                    case 113126854: {
                        if (!r.equals((Object)"width")) {
                            break;
                        }
                        n2 = 8;
                        break;
                    }
                    case 92909918: {
                        if (!r.equals((Object)"alpha")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case 3575610: {
                        if (!r.equals((Object)"type")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 114586: {
                        if (!r.equals((Object)"tag")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 121: {
                        if (!r.equals((Object)"y")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 120: {
                        if (!r.equals((Object)"x")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case -1221029593: {
                        if (!r.equals((Object)"height")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -1618432855: {
                        if (!r.equals((Object)"identifier")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1784982718: {
                        if (!r.equals((Object)"rendering_system")) {
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
                    case 10: {
                        c0.m = i1.U();
                        continue;
                    }
                    case 9: {
                        c0.o = (List<c0>)i1.P(n0, (io.sentry.c1<Object>)this);
                        continue;
                    }
                    case 8: {
                        c0.i = i1.L();
                        continue;
                    }
                    case 7: {
                        c0.n = i1.L();
                        continue;
                    }
                    case 6: {
                        c0.f = i1.U();
                        continue;
                    }
                    case 5: {
                        c0.h = i1.U();
                        continue;
                    }
                    case 4: {
                        c0.l = i1.L();
                        continue;
                    }
                    case 3: {
                        c0.k = i1.L();
                        continue;
                    }
                    case 2: {
                        c0.j = i1.L();
                        continue;
                    }
                    case 1: {
                        c0.g = i1.U();
                        continue;
                    }
                    case 0: {
                        c0.e = i1.U();
                        continue;
                    }
                }
            }
            i1.h();
            c0.q(map);
            return c0;
        }
    }
}
