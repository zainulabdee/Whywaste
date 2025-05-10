package io.sentry;

import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Locale;
import io.sentry.config.g;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Set;
import java.util.List;
import java.util.Map;

public final class y
{
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Double j;
    private Double k;
    private q4.f l;
    private final Map<String, String> m;
    private q4.e n;
    private final List<String> o;
    private final List<String> p;
    private List<String> q;
    private final List<String> r;
    private String s;
    private Long t;
    private final Set<Class<? extends Throwable>> u;
    private Boolean v;
    private Boolean w;
    private Set<String> x;
    
    public y() {
        this.m = (Map<String, String>)new ConcurrentHashMap();
        this.o = (List<String>)new CopyOnWriteArrayList();
        this.p = (List<String>)new CopyOnWriteArrayList();
        this.q = null;
        this.r = (List<String>)new CopyOnWriteArrayList();
        this.u = (Set<Class<? extends Throwable>>)new CopyOnWriteArraySet();
        this.x = (Set<String>)new CopyOnWriteArraySet();
    }
    
    public static y g(g iterator, final n0 n0) {
        final y y = new y();
        y.G(iterator.getProperty("dsn"));
        y.K(iterator.getProperty("environment"));
        y.R(iterator.getProperty("release"));
        y.F(iterator.getProperty("dist"));
        y.T(iterator.getProperty("servername"));
        y.J(iterator.b("uncaught.handler.enabled"));
        y.N(iterator.b("uncaught.handler.print-stacktrace"));
        y.I(iterator.b("enable-tracing"));
        y.V(iterator.d("traces-sample-rate"));
        y.O(iterator.d("profiles-sample-rate"));
        y.E(iterator.b("debug"));
        y.H(iterator.b("enable-deduplication"));
        y.S(iterator.b("send-client-reports"));
        final String property = iterator.getProperty("max-request-body-size");
        if (property != null) {
            y.M(q4.f.valueOf(property.toUpperCase(Locale.ROOT)));
        }
        for (final Map$Entry map$Entry : iterator.a("tags").entrySet()) {
            y.U((String)map$Entry.getKey(), (String)map$Entry.getValue());
        }
        final String property2 = iterator.getProperty("proxy.host");
        final String property3 = iterator.getProperty("proxy.user");
        final String property4 = iterator.getProperty("proxy.pass");
        final String e = iterator.e("proxy.port", "80");
        if (property2 != null) {
            y.Q(new q4.e(property2, e, property3, property4));
        }
        final Iterator iterator3 = iterator.f("in-app-includes").iterator();
        while (iterator3.hasNext()) {
            y.e((String)iterator3.next());
        }
        final Iterator iterator4 = iterator.f("in-app-excludes").iterator();
        while (iterator4.hasNext()) {
            y.d((String)iterator4.next());
        }
        List f = null;
        if (iterator.getProperty("trace-propagation-targets") != null) {
            f = iterator.f("trace-propagation-targets");
        }
        List f2;
        if ((f2 = f) == null) {
            f2 = f;
            if (iterator.getProperty("tracing-origins") != null) {
                f2 = iterator.f("tracing-origins");
            }
        }
        if (f2 != null) {
            final Iterator iterator5 = f2.iterator();
            while (iterator5.hasNext()) {
                y.f((String)iterator5.next());
            }
        }
        final Iterator iterator6 = iterator.f("context-tags").iterator();
        while (iterator6.hasNext()) {
            y.b((String)iterator6.next());
        }
        y.P(iterator.getProperty("proguard-uuid"));
        final Iterator iterator7 = iterator.f("bundle-ids").iterator();
        while (iterator7.hasNext()) {
            y.a((String)iterator7.next());
        }
        y.L(iterator.c("idle-timeout"));
        iterator = (g)iterator.f("ignored-exceptions-for-type").iterator();
        while (((Iterator)iterator).hasNext()) {
            final String className = (String)((Iterator)iterator).next();
            try {
                final Class<?> forName = Class.forName(className);
                if (Throwable.class.isAssignableFrom(forName)) {
                    y.c((Class<? extends Throwable>)forName);
                }
                else {
                    n0.a(l4.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s does not extend Throwable", className, className);
                }
            }
            catch (final ClassNotFoundException ex) {
                n0.a(l4.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s class is not found", className, className);
            }
        }
        return y;
    }
    
    public String A() {
        return this.e;
    }
    
    public Map<String, String> B() {
        return this.m;
    }
    
    public List<String> C() {
        return this.q;
    }
    
    public Double D() {
        return this.j;
    }
    
    public void E(final Boolean g) {
        this.g = g;
    }
    
    public void F(final String d) {
        this.d = d;
    }
    
    public void G(final String a) {
        this.a = a;
    }
    
    public void H(final Boolean h) {
        this.h = h;
    }
    
    public void I(final Boolean i) {
        this.i = i;
    }
    
    public void J(final Boolean f) {
        this.f = f;
    }
    
    public void K(final String b) {
        this.b = b;
    }
    
    public void L(final Long t) {
        this.t = t;
    }
    
    public void M(final q4.f l) {
        this.l = l;
    }
    
    public void N(final Boolean v) {
        this.v = v;
    }
    
    public void O(final Double k) {
        this.k = k;
    }
    
    public void P(final String s) {
        this.s = s;
    }
    
    public void Q(final q4.e n) {
        this.n = n;
    }
    
    public void R(final String c) {
        this.c = c;
    }
    
    public void S(final Boolean w) {
        this.w = w;
    }
    
    public void T(final String e) {
        this.e = e;
    }
    
    public void U(final String s, final String s2) {
        this.m.put((Object)s, (Object)s2);
    }
    
    public void V(final Double j) {
        this.j = j;
    }
    
    public void a(final String s) {
        this.x.add((Object)s);
    }
    
    public void b(final String s) {
        this.r.add((Object)s);
    }
    
    public void c(final Class<? extends Throwable> clazz) {
        this.u.add((Object)clazz);
    }
    
    public void d(final String s) {
        this.o.add((Object)s);
    }
    
    public void e(final String s) {
        this.p.add((Object)s);
    }
    
    public void f(final String s) {
        if (this.q == null) {
            this.q = (List<String>)new CopyOnWriteArrayList();
        }
        if (!s.isEmpty()) {
            this.q.add((Object)s);
        }
    }
    
    public Set<String> h() {
        return this.x;
    }
    
    public List<String> i() {
        return this.r;
    }
    
    public Boolean j() {
        return this.g;
    }
    
    public String k() {
        return this.d;
    }
    
    public String l() {
        return this.a;
    }
    
    public Boolean m() {
        return this.h;
    }
    
    public Boolean n() {
        return this.i;
    }
    
    public Boolean o() {
        return this.f;
    }
    
    public String p() {
        return this.b;
    }
    
    public Long q() {
        return this.t;
    }
    
    public Set<Class<? extends Throwable>> r() {
        return this.u;
    }
    
    public List<String> s() {
        return this.o;
    }
    
    public List<String> t() {
        return this.p;
    }
    
    public Boolean u() {
        return this.v;
    }
    
    public Double v() {
        return this.k;
    }
    
    public String w() {
        return this.s;
    }
    
    public q4.e x() {
        return this.n;
    }
    
    public String y() {
        return this.c;
    }
    
    public Boolean z() {
        return this.w;
    }
}
