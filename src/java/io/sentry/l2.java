package io.sentry;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import io.sentry.vendor.gson.stream.b;
import java.util.Iterator;
import java.util.UUID;
import java.util.Locale;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.io.File;
import io.sentry.profilemeasurements.a;
import java.util.Map;

public final class l2 implements m1
{
    private String A;
    private String B;
    private String C;
    private final Map<String, a> D;
    private String E;
    private Map<String, Object> F;
    private final File e;
    private final Callable<List<Integer>> f;
    private int g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private boolean n;
    private String o;
    private List<Integer> p;
    private String q;
    private String r;
    private String s;
    private List<m2> t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    
    private l2() {
        this(new File("dummy"), (v0)a2.s());
    }
    
    public l2(final File file, final v0 v0) {
        this(file, (List<m2>)new ArrayList(), v0, "0", 0, "", (Callable<List<Integer>>)new k2(), null, null, null, null, null, null, null, null, "normal", (Map<String, a>)new HashMap());
    }
    
    public l2(final File e, final List<m2> t, final v0 v0, final String v2, final int g, String o, final Callable<List<Integer>> f, String i, final String s, String m, final Boolean b, String q, String s2, final String s3, final String s4, final String c, final Map<String, a> d) {
        this.p = (List<Integer>)new ArrayList();
        this.E = null;
        this.e = e;
        this.o = o;
        this.f = f;
        this.g = g;
        this.h = Locale.getDefault().toString();
        o = "";
        if (i == null) {
            i = "";
        }
        this.i = i;
        String j;
        if (s != null) {
            j = s;
        }
        else {
            j = "";
        }
        this.j = j;
        if (m == null) {
            m = "";
        }
        this.m = m;
        this.n = (b != null && b);
        if (q == null) {
            q = "0";
        }
        this.q = q;
        this.k = "";
        this.l = "android";
        this.r = "android";
        if (s2 == null) {
            s2 = "";
        }
        this.s = s2;
        this.t = t;
        this.u = v0.getName();
        this.v = v2;
        this.w = "";
        String x = o;
        if (s3 != null) {
            x = s3;
        }
        this.x = x;
        this.y = v0.f().toString();
        this.z = ((u0)v0).i().j().toString();
        this.A = UUID.randomUUID().toString();
        String b2;
        if (s4 != null) {
            b2 = s4;
        }
        else {
            b2 = "production";
        }
        this.B = b2;
        this.C = c;
        if (!this.D()) {
            this.C = "normal";
        }
        this.D = d;
    }
    
    private boolean D() {
        return this.C.equals((Object)"normal") || this.C.equals((Object)"timeout") || this.C.equals((Object)"backgrounded");
    }
    
    public String A() {
        return this.A;
    }
    
    public File B() {
        return this.e;
    }
    
    public String C() {
        return this.y;
    }
    
    public void F() {
        try {
            this.p = (List<Integer>)this.f.call();
        }
        finally {}
    }
    
    public void G(final String e) {
        this.E = e;
    }
    
    public void H(final Map<String, Object> f) {
        this.F = f;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("android_api_level").z(n0, this.g);
        k1.y("device_locale").z(n0, this.h);
        k1.y("device_manufacturer").v(this.i);
        k1.y("device_model").v(this.j);
        k1.y("device_os_build_number").v(this.k);
        k1.y("device_os_name").v(this.l);
        k1.y("device_os_version").v(this.m);
        k1.y("device_is_emulator").w(this.n);
        k1.y("architecture").z(n0, this.o);
        k1.y("device_cpu_frequencies").z(n0, this.p);
        k1.y("device_physical_memory_bytes").v(this.q);
        k1.y("platform").v(this.r);
        k1.y("build_id").v(this.s);
        k1.y("transaction_name").v(this.u);
        k1.y("duration_ns").v(this.v);
        k1.y("version_name").v(this.x);
        k1.y("version_code").v(this.w);
        if (!this.t.isEmpty()) {
            k1.y("transactions").z(n0, this.t);
        }
        k1.y("transaction_id").v(this.y);
        k1.y("trace_id").v(this.z);
        k1.y("profile_id").v(this.A);
        k1.y("environment").v(this.B);
        k1.y("truncation_reason").v(this.C);
        if (this.E != null) {
            k1.y("sampled_profile").v(this.E);
        }
        k1.y("measurements").z(n0, this.D);
        final Map<String, Object> f = this.F;
        if (f != null) {
            for (final String s : f.keySet()) {
                final Object value = this.F.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class b implements c1<l2>
    {
        public l2 b(final i1 i1, final n0 n0) {
            i1.b();
            Map<String, Object> map = null;
            final l2 l2 = new l2(null);
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1954122069: {
                        if (!r.equals((Object)"transactions")) {
                            break;
                        }
                        n2 = 24;
                        break;
                    }
                    case 1953158756: {
                        if (!r.equals((Object)"sampled_profile")) {
                            break;
                        }
                        n2 = 23;
                        break;
                    }
                    case 1874684019: {
                        if (!r.equals((Object)"platform")) {
                            break;
                        }
                        n2 = 22;
                        break;
                    }
                    case 1270300245: {
                        if (!r.equals((Object)"trace_id")) {
                            break;
                        }
                        n2 = 21;
                        break;
                    }
                    case 1163928186: {
                        if (!r.equals((Object)"truncation_reason")) {
                            break;
                        }
                        n2 = 20;
                        break;
                    }
                    case 1052553990: {
                        if (!r.equals((Object)"device_os_version")) {
                            break;
                        }
                        n2 = 19;
                        break;
                    }
                    case 1010584092: {
                        if (!r.equals((Object)"transaction_id")) {
                            break;
                        }
                        n2 = 18;
                        break;
                    }
                    case 839674195: {
                        if (!r.equals((Object)"architecture")) {
                            break;
                        }
                        n2 = 17;
                        break;
                    }
                    case 796476189: {
                        if (!r.equals((Object)"device_os_name")) {
                            break;
                        }
                        n2 = 16;
                        break;
                    }
                    case 508853068: {
                        if (!r.equals((Object)"transaction_name")) {
                            break;
                        }
                        n2 = 15;
                        break;
                    }
                    case -85904877: {
                        if (!r.equals((Object)"environment")) {
                            break;
                        }
                        n2 = 14;
                        break;
                    }
                    case -102670958: {
                        if (!r.equals((Object)"version_name")) {
                            break;
                        }
                        n2 = 13;
                        break;
                    }
                    case -102985484: {
                        if (!r.equals((Object)"version_code")) {
                            break;
                        }
                        n2 = 12;
                        break;
                    }
                    case -212264198: {
                        if (!r.equals((Object)"device_cpu_frequencies")) {
                            break;
                        }
                        n2 = 11;
                        break;
                    }
                    case -332426004: {
                        if (!r.equals((Object)"device_physical_memory_bytes")) {
                            break;
                        }
                        n2 = 10;
                        break;
                    }
                    case -362243017: {
                        if (!r.equals((Object)"measurements")) {
                            break;
                        }
                        n2 = 9;
                        break;
                    }
                    case -478065584: {
                        if (!r.equals((Object)"duration_ns")) {
                            break;
                        }
                        n2 = 8;
                        break;
                    }
                    case -512511455: {
                        if (!r.equals((Object)"device_is_emulator")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case -591076352: {
                        if (!r.equals((Object)"device_model")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case -716656436: {
                        if (!r.equals((Object)"device_os_build_number")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case -1102636175: {
                        if (!r.equals((Object)"profile_id")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case -1172160413: {
                        if (!r.equals((Object)"device_locale")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case -1430655860: {
                        if (!r.equals((Object)"build_id")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -1981468849: {
                        if (!r.equals((Object)"android_api_level")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -2133529830: {
                        if (!r.equals((Object)"device_manufacturer")) {
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
                    case 24: {
                        final java.util.List<Object> p2 = i1.P(n0, (io.sentry.c1<Object>)new m2.a());
                        if (p2 != null) {
                            l2.t.addAll((Collection)p2);
                            continue;
                        }
                        continue;
                    }
                    case 23: {
                        final String u = i1.U();
                        if (u != null) {
                            l2.E = u;
                            continue;
                        }
                        continue;
                    }
                    case 22: {
                        final String u2 = i1.U();
                        if (u2 != null) {
                            l2.r = u2;
                            continue;
                        }
                        continue;
                    }
                    case 21: {
                        final String u3 = i1.U();
                        if (u3 != null) {
                            l2.z = u3;
                            continue;
                        }
                        continue;
                    }
                    case 20: {
                        final String u4 = i1.U();
                        if (u4 != null) {
                            l2.C = u4;
                            continue;
                        }
                        continue;
                    }
                    case 19: {
                        final String u5 = i1.U();
                        if (u5 != null) {
                            l2.m = u5;
                            continue;
                        }
                        continue;
                    }
                    case 18: {
                        final String u6 = i1.U();
                        if (u6 != null) {
                            l2.y = u6;
                            continue;
                        }
                        continue;
                    }
                    case 17: {
                        final String u7 = i1.U();
                        if (u7 != null) {
                            l2.o = u7;
                            continue;
                        }
                        continue;
                    }
                    case 16: {
                        final String u8 = i1.U();
                        if (u8 != null) {
                            l2.l = u8;
                            continue;
                        }
                        continue;
                    }
                    case 15: {
                        final String u9 = i1.U();
                        if (u9 != null) {
                            l2.u = u9;
                            continue;
                        }
                        continue;
                    }
                    case 14: {
                        final String u10 = i1.U();
                        if (u10 != null) {
                            l2.B = u10;
                            continue;
                        }
                        continue;
                    }
                    case 13: {
                        final String u11 = i1.U();
                        if (u11 != null) {
                            l2.x = u11;
                            continue;
                        }
                        continue;
                    }
                    case 12: {
                        final String u12 = i1.U();
                        if (u12 != null) {
                            l2.w = u12;
                            continue;
                        }
                        continue;
                    }
                    case 11: {
                        final List list = (List)i1.S();
                        if (list != null) {
                            l2.p = (List<Integer>)list;
                            continue;
                        }
                        continue;
                    }
                    case 10: {
                        final String u13 = i1.U();
                        if (u13 != null) {
                            l2.q = u13;
                            continue;
                        }
                        continue;
                    }
                    case 9: {
                        final java.util.Map<String, Object> r2 = i1.R(n0, (io.sentry.c1<Object>)new a.a());
                        if (r2 != null) {
                            l2.D.putAll((Map)r2);
                            continue;
                        }
                        continue;
                    }
                    case 8: {
                        final String u14 = i1.U();
                        if (u14 != null) {
                            l2.v = u14;
                            continue;
                        }
                        continue;
                    }
                    case 7: {
                        final Boolean j = i1.J();
                        if (j != null) {
                            l2.n = j;
                            continue;
                        }
                        continue;
                    }
                    case 6: {
                        final String u15 = i1.U();
                        if (u15 != null) {
                            l2.j = u15;
                            continue;
                        }
                        continue;
                    }
                    case 5: {
                        final String u16 = i1.U();
                        if (u16 != null) {
                            l2.k = u16;
                            continue;
                        }
                        continue;
                    }
                    case 4: {
                        final String u17 = i1.U();
                        if (u17 != null) {
                            l2.A = u17;
                            continue;
                        }
                        continue;
                    }
                    case 3: {
                        final String u18 = i1.U();
                        if (u18 != null) {
                            l2.h = u18;
                            continue;
                        }
                        continue;
                    }
                    case 2: {
                        final String u19 = i1.U();
                        if (u19 != null) {
                            l2.s = u19;
                            continue;
                        }
                        continue;
                    }
                    case 1: {
                        final Integer o2 = i1.O();
                        if (o2 != null) {
                            l2.g = o2;
                            continue;
                        }
                        continue;
                    }
                    case 0: {
                        final String u20 = i1.U();
                        if (u20 != null) {
                            l2.i = u20;
                            continue;
                        }
                        continue;
                    }
                }
            }
            l2.H(map);
            i1.h();
            return l2;
        }
    }
}
