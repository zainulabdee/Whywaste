package io.sentry;

import java.text.Format;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import io.sentry.util.q;
import io.sentry.protocol.z;
import io.sentry.protocol.a0;
import java.util.HashMap;
import java.util.Map;

public final class d
{
    static final Integer e;
    static final Integer f;
    final Map<String, String> a;
    final String b;
    private boolean c;
    final n0 d;
    
    static {
        e = 8192;
        f = 64;
    }
    
    public d(final d d) {
        this(d.a, d.b, d.c, d.d);
    }
    
    public d(final n0 n0) {
        this((Map<String, String>)new HashMap(), null, true, n0);
    }
    
    public d(final Map<String, String> a, final String b, final boolean c, final n0 d) {
        this.a = a;
        this.d = d;
        this.c = c;
        this.b = b;
    }
    
    private static String h(final a0 a0) {
        if (a0.o() != null) {
            return a0.o();
        }
        final Map k = a0.k();
        if (k != null) {
            return (String)k.get((Object)"segment");
        }
        return null;
    }
    
    private static boolean n(final z obj) {
        return obj != null && !z.URL.equals(obj);
    }
    
    private static Double p(final o5 o5) {
        if (o5 == null) {
            return null;
        }
        return o5.b();
    }
    
    private static String q(final Double n) {
        if (!q.e(n, false)) {
            return null;
        }
        return ((Format)new DecimalFormat("#.################", DecimalFormatSymbols.getInstance(Locale.ROOT))).format((Object)n);
    }
    
    public void A(final v0 v0, final a0 a0, final q4 q4, final o5 o5) {
        this.w(((u0)v0).i().j().toString());
        this.t(new p(q4.getDsn()).a());
        this.u(q4.getRelease());
        this.s(q4.getEnvironment());
        final String s = null;
        String h;
        if (a0 != null) {
            h = h(a0);
        }
        else {
            h = null;
        }
        this.y(h);
        String name = s;
        if (n(v0.q())) {
            name = v0.getName();
        }
        this.x(name);
        this.v(q(p(o5)));
    }
    
    public m5 B() {
        final String i = this.i();
        final String d = this.d();
        if (i != null && d != null) {
            final m5 m5 = new m5(new io.sentry.protocol.q(i), d, this.e(), this.c(), this.l(), this.m(), this.j(), this.f());
            m5.b((Map)this.k());
            return m5;
        }
        return null;
    }
    
    public void a() {
        this.c = false;
    }
    
    public String b(final String s) {
        if (s == null) {
            return null;
        }
        return (String)this.a.get((Object)s);
    }
    
    public String c() {
        return this.b("sentry-environment");
    }
    
    public String d() {
        return this.b("sentry-public_key");
    }
    
    public String e() {
        return this.b("sentry-release");
    }
    
    public String f() {
        return this.b("sentry-sample_rate");
    }
    
    public Double g() {
        final String f = this.f();
        Label_0030: {
            if (f == null) {
                break Label_0030;
            }
            try {
                final double double1 = Double.parseDouble(f);
                if (q.e(double1, false)) {
                    return double1;
                }
                return null;
            }
            catch (final NumberFormatException ex) {
                return null;
            }
        }
    }
    
    public String i() {
        return this.b("sentry-trace_id");
    }
    
    public String j() {
        return this.b("sentry-transaction");
    }
    
    public Map<String, Object> k() {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (final Map$Entry map$Entry : this.a.entrySet()) {
            final String s = (String)map$Entry.getKey();
            final String s2 = (String)map$Entry.getValue();
            if (!io.sentry.d.a.a.contains((Object)s) && s2 != null) {
                ((Map)concurrentHashMap).put((Object)s.replaceFirst("sentry-", ""), (Object)s2);
            }
        }
        return (Map<String, Object>)concurrentHashMap;
    }
    
    public String l() {
        return this.b("sentry-user_id");
    }
    
    public String m() {
        return this.b("sentry-user_segment");
    }
    
    public boolean o() {
        return this.c;
    }
    
    public void r(final String s, final String s2) {
        if (this.c) {
            this.a.put((Object)s, (Object)s2);
        }
    }
    
    public void s(final String s) {
        this.r("sentry-environment", s);
    }
    
    public void t(final String s) {
        this.r("sentry-public_key", s);
    }
    
    public void u(final String s) {
        this.r("sentry-release", s);
    }
    
    public void v(final String s) {
        this.r("sentry-sample_rate", s);
    }
    
    public void w(final String s) {
        this.r("sentry-trace_id", s);
    }
    
    public void x(final String s) {
        this.r("sentry-transaction", s);
    }
    
    public void y(final String s) {
        this.r("sentry-user_segment", s);
    }
    
    public void z(final r2 r2, final q4 q4) {
        final n2 p2 = r2.p();
        final a0 w = r2.w();
        this.w(p2.e().toString());
        this.t(new p(q4.getDsn()).a());
        this.u(q4.getRelease());
        this.s(q4.getEnvironment());
        String h;
        if (w != null) {
            h = h(w);
        }
        else {
            h = null;
        }
        this.y(h);
        this.x(null);
        this.v(null);
    }
    
    public static final class a
    {
        public static final List<String> a;
        
        static {
            a = Arrays.asList((Object[])new String[] { "sentry-trace_id", "sentry-public_key", "sentry-release", "sentry-user_id", "sentry-environment", "sentry-user_segment", "sentry-transaction", "sentry-sample_rate" });
        }
    }
}
