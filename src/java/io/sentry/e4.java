package io.sentry;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import io.sentry.util.b;
import io.sentry.protocol.q;
import io.sentry.protocol.p;
import io.sentry.protocol.w;
import io.sentry.protocol.j;
import java.util.Date;
import java.util.Map;
import java.util.List;

public final class e4 extends e3 implements m1
{
    private List<String> A;
    private Map<String, Object> B;
    private Map<String, String> C;
    private Date t;
    private j u;
    private String v;
    private z4<w> w;
    private z4<p> x;
    private l4 y;
    private String z;
    
    public e4() {
        this(new q(), io.sentry.j.c());
    }
    
    e4(final q q, final Date t) {
        super(q);
        this.t = t;
    }
    
    public e4(final Throwable n) {
        this();
        super.n = n;
    }
    
    public void A0(final Map<String, String> map) {
        this.C = (Map<String, String>)b.c((Map)map);
    }
    
    public void B0(final List<w> list) {
        this.w = (z4<w>)new z4((List)list);
    }
    
    public void C0(final Date t) {
        this.t = t;
    }
    
    public void D0(final String z) {
        this.z = z;
    }
    
    public void E0(final Map<String, Object> b) {
        this.B = b;
    }
    
    public List<p> o0() {
        final z4<p> x = this.x;
        List a;
        if (x == null) {
            a = null;
        }
        else {
            a = x.a();
        }
        return (List<p>)a;
    }
    
    public List<String> p0() {
        return this.A;
    }
    
    public l4 q0() {
        return this.y;
    }
    
    Map<String, String> r0() {
        return this.C;
    }
    
    public List<w> s0() {
        final z4<w> w = this.w;
        if (w != null) {
            return (List<w>)w.a();
        }
        return null;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("timestamp").z(n0, this.t);
        if (this.u != null) {
            k1.y("message").z(n0, this.u);
        }
        if (this.v != null) {
            k1.y("logger").v(this.v);
        }
        final z4<w> w = this.w;
        if (w != null && !w.a().isEmpty()) {
            k1.y("threads");
            k1.d();
            k1.y("values").z(n0, this.w.a());
            k1.h();
        }
        final z4<p> x = this.x;
        if (x != null && !x.a().isEmpty()) {
            k1.y("exception");
            k1.d();
            k1.y("values").z(n0, this.x.a());
            k1.h();
        }
        if (this.y != null) {
            k1.y("level").z(n0, this.y);
        }
        if (this.z != null) {
            k1.y("transaction").v(this.z);
        }
        if (this.A != null) {
            k1.y("fingerprint").z(n0, this.A);
        }
        if (this.C != null) {
            k1.y("modules").z(n0, this.C);
        }
        new e3$b().a((e3)this, k1, n0);
        final Map<String, Object> b = this.B;
        if (b != null) {
            for (final String s : b.keySet()) {
                final Object value = this.B.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public String t0() {
        return this.z;
    }
    
    public boolean u0() {
        final z4<p> x = this.x;
        if (x != null) {
            for (final p p : x.a()) {
                if (p.g() != null && p.g().h() != null && !p.g().h()) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean v0() {
        final z4<p> x = this.x;
        return x != null && !x.a().isEmpty();
    }
    
    public void w0(final List<p> list) {
        this.x = (z4<p>)new z4((List)list);
    }
    
    public void x0(final List<String> list) {
        Object a;
        if (list != null) {
            a = new ArrayList((Collection)list);
        }
        else {
            a = null;
        }
        this.A = (List<String>)a;
    }
    
    public void y0(final l4 y) {
        this.y = y;
    }
    
    public void z0(final j u) {
        this.u = u;
    }
    
    public static final class a implements c1<e4>
    {
        public e4 b(final i1 i1, final n0 n0) {
            i1.b();
            final e4 e4 = new e4();
            final e3$a e3$a = new e3$a();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 2141246174: {
                        if (!r.equals((Object)"transaction")) {
                            break;
                        }
                        n2 = 8;
                        break;
                    }
                    case 1481625679: {
                        if (!r.equals((Object)"exception")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case 1227433863: {
                        if (!r.equals((Object)"modules")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 954925063: {
                        if (!r.equals((Object)"message")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 102865796: {
                        if (!r.equals((Object)"level")) {
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
                    case -1097337456: {
                        if (!r.equals((Object)"logger")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -1337936983: {
                        if (!r.equals((Object)"threads")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1375934236: {
                        if (!r.equals((Object)"fingerprint")) {
                            break;
                        }
                        n2 = 0;
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        if (!e3$a.a((e3)e4, r, i1, n0)) {
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
                    case 8: {
                        e4.z = i1.U();
                        continue;
                    }
                    case 7: {
                        i1.b();
                        i1.r();
                        e4.x = (z4<p>)new z4((List)i1.P(n0, (io.sentry.c1<Object>)new p.a()));
                        i1.h();
                        continue;
                    }
                    case 6: {
                        e4.C = (Map<String, String>)b.b((Map)i1.S());
                        continue;
                    }
                    case 5: {
                        e4.u = i1.T(n0, (io.sentry.c1<j>)new j.a());
                        continue;
                    }
                    case 4: {
                        e4.y = i1.T(n0, (io.sentry.c1<l4>)new l4.a());
                        continue;
                    }
                    case 3: {
                        final Date k = i1.K(n0);
                        if (k != null) {
                            e4.t = k;
                            continue;
                        }
                        continue;
                    }
                    case 2: {
                        e4.v = i1.U();
                        continue;
                    }
                    case 1: {
                        i1.b();
                        i1.r();
                        e4.w = (z4<w>)new z4((List)i1.P(n0, (io.sentry.c1<Object>)new w.a()));
                        i1.h();
                        continue;
                    }
                    case 0: {
                        final List list = (List)i1.S();
                        if (list != null) {
                            e4.A = (List<String>)list;
                            continue;
                        }
                        continue;
                    }
                }
            }
            e4.E0(map);
            i1.h();
            return e4;
        }
    }
}
