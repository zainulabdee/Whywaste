package io.sentry.protocol;

import java.util.AbstractMap;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.e3$a;
import io.sentry.i1;
import io.sentry.c1;
import io.sentry.e3$b;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.o5;
import java.math.RoundingMode;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map$Entry;
import io.sentry.d5;
import io.sentry.c5;
import io.sentry.j;
import io.sentry.util.n;
import java.util.HashMap;
import java.util.ArrayList;
import io.sentry.y4;
import java.util.List;
import java.util.Map;
import io.sentry.m1;
import io.sentry.e3;

public final class x extends e3 implements m1
{
    private Map<String, Object> A;
    private String t;
    private Double u;
    private Double v;
    private final List<t> w;
    private final String x;
    private final Map<String, h> y;
    private y z;
    
    public x(final y4 y4) {
        super(y4.f());
        this.w = (List<t>)new ArrayList();
        this.x = "transaction";
        this.y = (Map<String, h>)new HashMap();
        n.c((Object)y4, "sentryTracer is required");
        this.u = j.l(y4.r().i());
        this.v = j.l(y4.r().h(y4.l()));
        this.t = y4.getName();
        for (final c5 c5 : y4.C()) {
            if (Boolean.TRUE.equals((Object)c5.C())) {
                this.w.add((Object)new t(c5));
            }
        }
        final c c6 = this.C();
        ((AbstractMap)c6).putAll((Map)y4.D());
        final d5 i = y4.i();
        c6.m(new d5(i.j(), i.g(), i.c(), i.b(), i.a(), i.f(), i.h()));
        for (final Map$Entry map$Entry : i.i().entrySet()) {
            this.c0((String)map$Entry.getKey(), (String)map$Entry.getValue());
        }
        final Map e = y4.E();
        if (e != null) {
            for (final Map$Entry map$Entry2 : e.entrySet()) {
                this.V((String)map$Entry2.getKey(), map$Entry2.getValue());
            }
        }
        this.z = new y(y4.q().apiName());
    }
    
    public x(final String t, final Double u, final Double v, final List<t> list, final Map<String, h> map, final y z) {
        final ArrayList w = new ArrayList();
        this.w = (List<t>)w;
        this.x = "transaction";
        final HashMap y = new HashMap();
        this.y = (Map<String, h>)y;
        this.t = t;
        this.u = u;
        this.v = v;
        ((List)w).addAll((Collection)list);
        ((Map)y).putAll((Map)map);
        this.z = z;
    }
    
    private BigDecimal l0(final Double n) {
        return BigDecimal.valueOf((double)n).setScale(6, RoundingMode.DOWN);
    }
    
    public Map<String, h> m0() {
        return this.y;
    }
    
    public o5 n0() {
        final d5 e = this.C().e();
        if (e == null) {
            return null;
        }
        return e.f();
    }
    
    public List<t> o0() {
        return this.w;
    }
    
    public boolean p0() {
        return this.v != null;
    }
    
    public boolean q0() {
        final o5 n0 = this.n0();
        return n0 != null && n0.c();
    }
    
    public void r0(final Map<String, Object> a) {
        this.A = a;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.t != null) {
            k1.y("transaction").v(this.t);
        }
        k1.y("start_timestamp").z(n0, this.l0(this.u));
        if (this.v != null) {
            k1.y("timestamp").z(n0, this.l0(this.v));
        }
        if (!this.w.isEmpty()) {
            k1.y("spans").z(n0, this.w);
        }
        k1.y("type").v("transaction");
        if (!this.y.isEmpty()) {
            k1.y("measurements").z(n0, this.y);
        }
        k1.y("transaction_info").z(n0, this.z);
        new e3$b().a((e3)this, k1, n0);
        final Map<String, Object> a = this.A;
        if (a != null) {
            for (final String s : a.keySet()) {
                final Object value = this.A.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<x>
    {
        public x b(final i1 i1, final n0 n0) {
            i1.b();
            final x x = new x("", 0.0, null, (List<t>)new ArrayList(), (Map<String, h>)new HashMap(), new y(io.sentry.protocol.z.CUSTOM.apiName()));
            final e3$a e3$a = new e3$a();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 2141246174: {
                        if (!r.equals((Object)"transaction")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 508716399: {
                        if (!r.equals((Object)"transaction_info")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 109638249: {
                        if (!r.equals((Object)"spans")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 55126294: {
                        if (!r.equals((Object)"timestamp")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 3575610: {
                        if (!r.equals((Object)"type")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -362243017: {
                        if (!r.equals((Object)"measurements")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1526966919: {
                        if (!r.equals((Object)"start_timestamp")) {
                            break;
                        }
                        n2 = 0;
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        if (!e3$a.a((e3)x, r, i1, n0)) {
                            Object o;
                            if ((o = map) == null) {
                                o = new ConcurrentHashMap();
                            }
                            i1.W(n0, (Map<String, Object>)o, r);
                            map = (Map<String, Object>)o;
                            continue;
                        }
                        continue;
                    }
                    case 6: {
                        x.t = i1.U();
                        continue;
                    }
                    case 5: {
                        x.z = new y.a().b(i1, n0);
                        continue;
                    }
                    case 4: {
                        final java.util.List<Object> p2 = i1.P(n0, (io.sentry.c1<Object>)new t.a());
                        if (p2 != null) {
                            x.w.addAll((Collection)p2);
                            continue;
                        }
                        continue;
                    }
                    case 3: {
                        try {
                            final Double l = i1.L();
                            if (l == null) {
                                continue;
                            }
                            x.v = l;
                        }
                        catch (final NumberFormatException ex) {
                            final Date k = i1.K(n0);
                            if (k == null) {
                                continue;
                            }
                            x.v = j.b(k);
                        }
                        continue;
                    }
                    case 2: {
                        i1.v();
                        continue;
                    }
                    case 1: {
                        final java.util.Map<String, Object> r2 = i1.R(n0, (io.sentry.c1<Object>)new h.a());
                        if (r2 != null) {
                            x.y.putAll((Map)r2);
                            continue;
                        }
                        continue;
                    }
                    case 0: {
                        try {
                            final Double j = i1.L();
                            if (j == null) {
                                continue;
                            }
                            x.u = j;
                        }
                        catch (final NumberFormatException ex2) {
                            final Date m = i1.K(n0);
                            if (m == null) {
                                continue;
                            }
                            x.u = j.b(m);
                        }
                        continue;
                    }
                }
            }
            x.r0(map);
            i1.h();
            return x;
        }
    }
}
