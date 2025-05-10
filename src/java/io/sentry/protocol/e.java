package io.sentry.protocol;

import java.util.Locale;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Arrays;
import io.sentry.util.n;
import io.sentry.util.b;
import java.util.Map;
import java.util.TimeZone;
import java.util.Date;
import io.sentry.m1;

public final class e implements m1
{
    private Float A;
    private Integer B;
    private Date C;
    private TimeZone D;
    private String E;
    @Deprecated
    private String F;
    private String G;
    private String H;
    private Float I;
    private Integer J;
    private Double K;
    private String L;
    private Map<String, Object> M;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String[] k;
    private Float l;
    private Boolean m;
    private Boolean n;
    private b o;
    private Boolean p;
    private Long q;
    private Long r;
    private Long s;
    private Boolean t;
    private Long u;
    private Long v;
    private Long w;
    private Long x;
    private Integer y;
    private Integer z;
    
    public e() {
    }
    
    e(final e e) {
        this.e = e.e;
        this.f = e.f;
        this.g = e.g;
        this.h = e.h;
        this.i = e.i;
        this.j = e.j;
        this.m = e.m;
        this.n = e.n;
        this.o = e.o;
        this.p = e.p;
        this.q = e.q;
        this.r = e.r;
        this.s = e.s;
        this.t = e.t;
        this.u = e.u;
        this.v = e.v;
        this.w = e.w;
        this.x = e.x;
        this.y = e.y;
        this.z = e.z;
        this.A = e.A;
        this.B = e.B;
        this.C = e.C;
        this.E = e.E;
        this.F = e.F;
        this.H = e.H;
        this.I = e.I;
        this.l = e.l;
        final String[] k = e.k;
        final TimeZone timeZone = null;
        String[] i;
        if (k != null) {
            i = k.clone();
        }
        else {
            i = null;
        }
        this.k = i;
        this.G = e.G;
        final TimeZone d = e.D;
        TimeZone d2 = timeZone;
        if (d != null) {
            d2 = (TimeZone)d.clone();
        }
        this.D = d2;
        this.J = e.J;
        this.K = e.K;
        this.L = e.L;
        this.M = (Map<String, Object>)io.sentry.util.b.b((Map)e.M);
    }
    
    public String I() {
        return this.H;
    }
    
    public String J() {
        return this.E;
    }
    
    public String K() {
        return this.F;
    }
    
    public String L() {
        return this.G;
    }
    
    public void M(final String[] k) {
        this.k = k;
    }
    
    public void N(final Float l) {
        this.l = l;
    }
    
    public void O(final Float i) {
        this.I = i;
    }
    
    public void P(final Date c) {
        this.C = c;
    }
    
    public void Q(final String g) {
        this.g = g;
    }
    
    public void R(final Boolean m) {
        this.m = m;
    }
    
    public void S(final String h) {
        this.H = h;
    }
    
    public void T(final Long x) {
        this.x = x;
    }
    
    public void U(final Long w) {
        this.w = w;
    }
    
    public void V(final String h) {
        this.h = h;
    }
    
    public void W(final Long r) {
        this.r = r;
    }
    
    public void X(final Long v) {
        this.v = v;
    }
    
    public void Y(final String e) {
        this.E = e;
    }
    
    public void Z(final String f) {
        this.F = f;
    }
    
    public void a0(final String g) {
        this.G = g;
    }
    
    public void b0(final Boolean t) {
        this.t = t;
    }
    
    public void c0(final String f) {
        this.f = f;
    }
    
    public void d0(final Long q) {
        this.q = q;
    }
    
    public void e0(final String i) {
        this.i = i;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && e.class == o.getClass()) {
            final e e = (e)o;
            if (!io.sentry.util.n.a((Object)this.e, (Object)e.e) || !io.sentry.util.n.a((Object)this.f, (Object)e.f) || !io.sentry.util.n.a((Object)this.g, (Object)e.g) || !io.sentry.util.n.a((Object)this.h, (Object)e.h) || !io.sentry.util.n.a((Object)this.i, (Object)e.i) || !io.sentry.util.n.a((Object)this.j, (Object)e.j) || !Arrays.equals((Object[])this.k, (Object[])e.k) || !io.sentry.util.n.a((Object)this.l, (Object)e.l) || !io.sentry.util.n.a((Object)this.m, (Object)e.m) || !io.sentry.util.n.a((Object)this.n, (Object)e.n) || this.o != e.o || !io.sentry.util.n.a((Object)this.p, (Object)e.p) || !io.sentry.util.n.a((Object)this.q, (Object)e.q) || !io.sentry.util.n.a((Object)this.r, (Object)e.r) || !io.sentry.util.n.a((Object)this.s, (Object)e.s) || !io.sentry.util.n.a((Object)this.t, (Object)e.t) || !io.sentry.util.n.a((Object)this.u, (Object)e.u) || !io.sentry.util.n.a((Object)this.v, (Object)e.v) || !io.sentry.util.n.a((Object)this.w, (Object)e.w) || !io.sentry.util.n.a((Object)this.x, (Object)e.x) || !io.sentry.util.n.a((Object)this.y, (Object)e.y) || !io.sentry.util.n.a((Object)this.z, (Object)e.z) || !io.sentry.util.n.a((Object)this.A, (Object)e.A) || !io.sentry.util.n.a((Object)this.B, (Object)e.B) || !io.sentry.util.n.a((Object)this.C, (Object)e.C) || !io.sentry.util.n.a((Object)this.E, (Object)e.E) || !io.sentry.util.n.a((Object)this.F, (Object)e.F) || !io.sentry.util.n.a((Object)this.G, (Object)e.G) || !io.sentry.util.n.a((Object)this.H, (Object)e.H) || !io.sentry.util.n.a((Object)this.I, (Object)e.I) || !io.sentry.util.n.a((Object)this.J, (Object)e.J) || !io.sentry.util.n.a((Object)this.K, (Object)e.K) || !io.sentry.util.n.a((Object)this.L, (Object)e.L)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public void f0(final String j) {
        this.j = j;
    }
    
    public void g0(final String e) {
        this.e = e;
    }
    
    public void h0(final Boolean n) {
        this.n = n;
    }
    
    @Override
    public int hashCode() {
        return io.sentry.util.n.b(new Object[] { this.e, this.f, this.g, this.h, this.i, this.j, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L }) * 31 + Arrays.hashCode((Object[])this.k);
    }
    
    public void i0(final b o) {
        this.o = o;
    }
    
    public void j0(final Integer j) {
        this.J = j;
    }
    
    public void k0(final Double k) {
        this.K = k;
    }
    
    public void l0(final Float a) {
        this.A = a;
    }
    
    public void m0(final Integer b) {
        this.B = b;
    }
    
    public void n0(final Integer z) {
        this.z = z;
    }
    
    public void o0(final Integer y) {
        this.y = y;
    }
    
    public void p0(final Boolean p) {
        this.p = p;
    }
    
    public void q0(final Long u) {
        this.u = u;
    }
    
    public void r0(final TimeZone d) {
        this.D = d;
    }
    
    public void s0(final Map<String, Object> m) {
        this.M = m;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("name").v(this.e);
        }
        if (this.f != null) {
            k1.y("manufacturer").v(this.f);
        }
        if (this.g != null) {
            k1.y("brand").v(this.g);
        }
        if (this.h != null) {
            k1.y("family").v(this.h);
        }
        if (this.i != null) {
            k1.y("model").v(this.i);
        }
        if (this.j != null) {
            k1.y("model_id").v(this.j);
        }
        if (this.k != null) {
            k1.y("archs").z(n0, this.k);
        }
        if (this.l != null) {
            k1.y("battery_level").u((Number)this.l);
        }
        if (this.m != null) {
            k1.y("charging").t(this.m);
        }
        if (this.n != null) {
            k1.y("online").t(this.n);
        }
        if (this.o != null) {
            k1.y("orientation").z(n0, this.o);
        }
        if (this.p != null) {
            k1.y("simulator").t(this.p);
        }
        if (this.q != null) {
            k1.y("memory_size").u((Number)this.q);
        }
        if (this.r != null) {
            k1.y("free_memory").u((Number)this.r);
        }
        if (this.s != null) {
            k1.y("usable_memory").u((Number)this.s);
        }
        if (this.t != null) {
            k1.y("low_memory").t(this.t);
        }
        if (this.u != null) {
            k1.y("storage_size").u((Number)this.u);
        }
        if (this.v != null) {
            k1.y("free_storage").u((Number)this.v);
        }
        if (this.w != null) {
            k1.y("external_storage_size").u((Number)this.w);
        }
        if (this.x != null) {
            k1.y("external_free_storage").u((Number)this.x);
        }
        if (this.y != null) {
            k1.y("screen_width_pixels").u((Number)this.y);
        }
        if (this.z != null) {
            k1.y("screen_height_pixels").u((Number)this.z);
        }
        if (this.A != null) {
            k1.y("screen_density").u((Number)this.A);
        }
        if (this.B != null) {
            k1.y("screen_dpi").u((Number)this.B);
        }
        if (this.C != null) {
            k1.y("boot_time").z(n0, this.C);
        }
        if (this.D != null) {
            k1.y("timezone").z(n0, this.D);
        }
        if (this.E != null) {
            k1.y("id").v(this.E);
        }
        if (this.F != null) {
            k1.y("language").v(this.F);
        }
        if (this.H != null) {
            k1.y("connection_type").v(this.H);
        }
        if (this.I != null) {
            k1.y("battery_temperature").u((Number)this.I);
        }
        if (this.G != null) {
            k1.y("locale").v(this.G);
        }
        if (this.J != null) {
            k1.y("processor_count").u((Number)this.J);
        }
        if (this.K != null) {
            k1.y("processor_frequency").u((Number)this.K);
        }
        if (this.L != null) {
            k1.y("cpu_description").v(this.L);
        }
        final Map<String, Object> m = this.M;
        if (m != null) {
            for (final String s : m.keySet()) {
                k1.y(s).z(n0, this.M.get((Object)s));
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<e>
    {
        public e b(final i1 i1, final n0 n0) {
            i1.b();
            final e e = new e();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1556284978: {
                        if (!r.equals((Object)"screen_height_pixels")) {
                            break;
                        }
                        n2 = 33;
                        break;
                    }
                    case 1524159400: {
                        if (!r.equals((Object)"free_storage")) {
                            break;
                        }
                        n2 = 32;
                        break;
                    }
                    case 1450613660: {
                        if (!r.equals((Object)"external_free_storage")) {
                            break;
                        }
                        n2 = 31;
                        break;
                    }
                    case 1436115569: {
                        if (!r.equals((Object)"charging")) {
                            break;
                        }
                        n2 = 30;
                        break;
                    }
                    case 1418777727: {
                        if (!r.equals((Object)"memory_size")) {
                            break;
                        }
                        n2 = 29;
                        break;
                    }
                    case 1331465768: {
                        if (!r.equals((Object)"usable_memory")) {
                            break;
                        }
                        n2 = 28;
                        break;
                    }
                    case 897428293: {
                        if (!r.equals((Object)"storage_size")) {
                            break;
                        }
                        n2 = 27;
                        break;
                    }
                    case 823882553: {
                        if (!r.equals((Object)"external_storage_size")) {
                            break;
                        }
                        n2 = 26;
                        break;
                    }
                    case 817830969: {
                        if (!r.equals((Object)"screen_width_pixels")) {
                            break;
                        }
                        n2 = 25;
                        break;
                    }
                    case 731866107: {
                        if (!r.equals((Object)"connection_type")) {
                            break;
                        }
                        n2 = 24;
                        break;
                    }
                    case 244497903: {
                        if (!r.equals((Object)"processor_frequency")) {
                            break;
                        }
                        n2 = 23;
                        break;
                    }
                    case 115746789: {
                        if (!r.equals((Object)"cpu_description")) {
                            break;
                        }
                        n2 = 22;
                        break;
                    }
                    case 104069929: {
                        if (!r.equals((Object)"model")) {
                            break;
                        }
                        n2 = 21;
                        break;
                    }
                    case 93997959: {
                        if (!r.equals((Object)"brand")) {
                            break;
                        }
                        n2 = 20;
                        break;
                    }
                    case 93076189: {
                        if (!r.equals((Object)"archs")) {
                            break;
                        }
                        n2 = 19;
                        break;
                    }
                    case 59142220: {
                        if (!r.equals((Object)"low_memory")) {
                            break;
                        }
                        n2 = 18;
                        break;
                    }
                    case 3373707: {
                        if (!r.equals((Object)"name")) {
                            break;
                        }
                        n2 = 17;
                        break;
                    }
                    case 3355: {
                        if (!r.equals((Object)"id")) {
                            break;
                        }
                        n2 = 16;
                        break;
                    }
                    case -136523212: {
                        if (!r.equals((Object)"free_memory")) {
                            break;
                        }
                        n2 = 15;
                        break;
                    }
                    case -417046774: {
                        if (!r.equals((Object)"screen_dpi")) {
                            break;
                        }
                        n2 = 14;
                        break;
                    }
                    case -568274923: {
                        if (!r.equals((Object)"screen_density")) {
                            break;
                        }
                        n2 = 13;
                        break;
                    }
                    case -619038223: {
                        if (!r.equals((Object)"model_id")) {
                            break;
                        }
                        n2 = 12;
                        break;
                    }
                    case -877252910: {
                        if (!r.equals((Object)"battery_level")) {
                            break;
                        }
                        n2 = 11;
                        break;
                    }
                    case -1012222381: {
                        if (!r.equals((Object)"online")) {
                            break;
                        }
                        n2 = 10;
                        break;
                    }
                    case -1097462182: {
                        if (!r.equals((Object)"locale")) {
                            break;
                        }
                        n2 = 9;
                        break;
                    }
                    case -1281860764: {
                        if (!r.equals((Object)"family")) {
                            break;
                        }
                        n2 = 8;
                        break;
                    }
                    case -1410521534: {
                        if (!r.equals((Object)"battery_temperature")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case -1439500848: {
                        if (!r.equals((Object)"orientation")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case -1608004830: {
                        if (!r.equals((Object)"processor_count")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case -1613589672: {
                        if (!r.equals((Object)"language")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case -1969347631: {
                        if (!r.equals((Object)"manufacturer")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case -1981332476: {
                        if (!r.equals((Object)"simulator")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -2012489734: {
                        if (!r.equals((Object)"boot_time")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -2076227591: {
                        if (!r.equals((Object)"timezone")) {
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
                    case 33: {
                        e.z = i1.O();
                        continue;
                    }
                    case 32: {
                        e.v = i1.Q();
                        continue;
                    }
                    case 31: {
                        e.x = i1.Q();
                        continue;
                    }
                    case 30: {
                        e.m = i1.J();
                        continue;
                    }
                    case 29: {
                        e.q = i1.Q();
                        continue;
                    }
                    case 28: {
                        e.s = i1.Q();
                        continue;
                    }
                    case 27: {
                        e.u = i1.Q();
                        continue;
                    }
                    case 26: {
                        e.w = i1.Q();
                        continue;
                    }
                    case 25: {
                        e.y = i1.O();
                        continue;
                    }
                    case 24: {
                        e.H = i1.U();
                        continue;
                    }
                    case 23: {
                        e.K = i1.L();
                        continue;
                    }
                    case 22: {
                        e.L = i1.U();
                        continue;
                    }
                    case 21: {
                        e.i = i1.U();
                        continue;
                    }
                    case 20: {
                        e.g = i1.U();
                        continue;
                    }
                    case 19: {
                        final List list = (List)i1.S();
                        if (list != null) {
                            final String[] array = new String[list.size()];
                            list.toArray((Object[])array);
                            e.k = array;
                            continue;
                        }
                        continue;
                    }
                    case 18: {
                        e.t = i1.J();
                        continue;
                    }
                    case 17: {
                        e.e = i1.U();
                        continue;
                    }
                    case 16: {
                        e.E = i1.U();
                        continue;
                    }
                    case 15: {
                        e.r = i1.Q();
                        continue;
                    }
                    case 14: {
                        e.B = i1.O();
                        continue;
                    }
                    case 13: {
                        e.A = i1.N();
                        continue;
                    }
                    case 12: {
                        e.j = i1.U();
                        continue;
                    }
                    case 11: {
                        e.l = i1.N();
                        continue;
                    }
                    case 10: {
                        e.n = i1.J();
                        continue;
                    }
                    case 9: {
                        e.G = i1.U();
                        continue;
                    }
                    case 8: {
                        e.h = i1.U();
                        continue;
                    }
                    case 7: {
                        e.I = i1.N();
                        continue;
                    }
                    case 6: {
                        e.o = i1.T(n0, (io.sentry.c1<b>)new b.a());
                        continue;
                    }
                    case 5: {
                        e.J = i1.O();
                        continue;
                    }
                    case 4: {
                        e.F = i1.U();
                        continue;
                    }
                    case 3: {
                        e.f = i1.U();
                        continue;
                    }
                    case 2: {
                        e.p = i1.J();
                        continue;
                    }
                    case 1: {
                        if (i1.x() == io.sentry.vendor.gson.stream.b.STRING) {
                            e.C = i1.K(n0);
                            continue;
                        }
                        continue;
                    }
                    case 0: {
                        e.D = i1.V(n0);
                        continue;
                    }
                }
            }
            e.s0(map);
            i1.h();
            return e;
        }
    }
    
    public enum b implements m1
    {
        private static final b[] $VALUES;
        
        LANDSCAPE, 
        PORTRAIT;
        
        private static /* synthetic */ b[] $values() {
            return new b[] { b.PORTRAIT, b.LANDSCAPE };
        }
        
        static {
            $VALUES = $values();
        }
        
        public void serialize(final k1 k1, final n0 n0) {
            k1.v(this.toString().toLowerCase(Locale.ROOT));
        }
        
        public static final class a implements c1<b>
        {
            public b b(final i1 i1, final n0 n0) {
                return b.valueOf(i1.v().toUpperCase(Locale.ROOT));
            }
        }
    }
}
