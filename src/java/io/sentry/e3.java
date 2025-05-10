package io.sentry;

import java.util.AbstractMap;
import io.sentry.protocol.d$a;
import io.sentry.protocol.c$a;
import io.sentry.protocol.o$a;
import io.sentry.protocol.a0$a;
import io.sentry.protocol.q$a;
import io.sentry.protocol.l$a;
import java.util.HashMap;
import io.sentry.util.b;
import io.sentry.exception.a;
import io.sentry.protocol.d;
import java.util.List;
import io.sentry.protocol.a0;
import java.util.Map;
import io.sentry.protocol.l;
import io.sentry.protocol.o;
import io.sentry.protocol.c;
import io.sentry.protocol.q;

public abstract class e3
{
    private q e;
    private final c f;
    private o g;
    private l h;
    private Map<String, String> i;
    private String j;
    private String k;
    private String l;
    private a0 m;
    protected transient Throwable n;
    private String o;
    private String p;
    private List<e> q;
    private d r;
    private Map<String, Object> s;
    
    protected e3() {
        this(new q());
    }
    
    protected e3(final q e) {
        this.f = new c();
        this.e = e;
    }
    
    public List<e> B() {
        return this.q;
    }
    
    public c C() {
        return this.f;
    }
    
    public d D() {
        return this.r;
    }
    
    public String E() {
        return this.p;
    }
    
    public String F() {
        return this.k;
    }
    
    public q G() {
        return this.e;
    }
    
    public Map<String, Object> H() {
        return this.s;
    }
    
    public String I() {
        return this.l;
    }
    
    public String J() {
        return this.j;
    }
    
    public l K() {
        return this.h;
    }
    
    public o L() {
        return this.g;
    }
    
    public String M() {
        return this.o;
    }
    
    public Map<String, String> N() {
        return this.i;
    }
    
    public Throwable O() {
        Throwable t2;
        final Throwable t = t2 = this.n;
        if (t instanceof io.sentry.exception.a) {
            t2 = ((io.sentry.exception.a)t).c();
        }
        return t2;
    }
    
    public Throwable P() {
        return this.n;
    }
    
    public a0 Q() {
        return this.m;
    }
    
    public void R(final List<e> list) {
        this.q = io.sentry.util.b.a(list);
    }
    
    public void S(final d r) {
        this.r = r;
    }
    
    public void T(final String p) {
        this.p = p;
    }
    
    public void U(final String k) {
        this.k = k;
    }
    
    public void V(final String s, final Object o) {
        if (this.s == null) {
            this.s = (Map<String, Object>)new HashMap();
        }
        this.s.put((Object)s, o);
    }
    
    public void W(final Map<String, Object> map) {
        this.s = io.sentry.util.b.c(map);
    }
    
    public void X(final String l) {
        this.l = l;
    }
    
    public void Y(final String j) {
        this.j = j;
    }
    
    public void Z(final l h) {
        this.h = h;
    }
    
    public void a0(final o g) {
        this.g = g;
    }
    
    public void b0(final String o) {
        this.o = o;
    }
    
    public void c0(final String s, final String s2) {
        if (this.i == null) {
            this.i = (Map<String, String>)new HashMap();
        }
        this.i.put((Object)s, (Object)s2);
    }
    
    public void d0(final Map<String, String> map) {
        this.i = io.sentry.util.b.c(map);
    }
    
    public void e0(final a0 m) {
        this.m = m;
    }
    
    public static final class a
    {
        public boolean a(final e3 e3, final String s, final i1 i1, final n0 n0) {
            s.hashCode();
            final int hashCode = s.hashCode();
            int n2 = -1;
            switch (hashCode) {
                case 1874684019: {
                    if (!s.equals((Object)"platform")) {
                        break;
                    }
                    n2 = 13;
                    break;
                }
                case 1095692943: {
                    if (!s.equals((Object)"request")) {
                        break;
                    }
                    n2 = 12;
                    break;
                }
                case 1090594823: {
                    if (!s.equals((Object)"release")) {
                        break;
                    }
                    n2 = 11;
                    break;
                }
                case 278118624: {
                    if (!s.equals((Object)"event_id")) {
                        break;
                    }
                    n2 = 10;
                    break;
                }
                case 96965648: {
                    if (!s.equals((Object)"extra")) {
                        break;
                    }
                    n2 = 9;
                    break;
                }
                case 3599307: {
                    if (!s.equals((Object)"user")) {
                        break;
                    }
                    n2 = 8;
                    break;
                }
                case 3552281: {
                    if (!s.equals((Object)"tags")) {
                        break;
                    }
                    n2 = 7;
                    break;
                }
                case 3083686: {
                    if (!s.equals((Object)"dist")) {
                        break;
                    }
                    n2 = 6;
                    break;
                }
                case 113722: {
                    if (!s.equals((Object)"sdk")) {
                        break;
                    }
                    n2 = 5;
                    break;
                }
                case -51457840: {
                    if (!s.equals((Object)"breadcrumbs")) {
                        break;
                    }
                    n2 = 4;
                    break;
                }
                case -85904877: {
                    if (!s.equals((Object)"environment")) {
                        break;
                    }
                    n2 = 3;
                    break;
                }
                case -567312220: {
                    if (!s.equals((Object)"contexts")) {
                        break;
                    }
                    n2 = 2;
                    break;
                }
                case -758770169: {
                    if (!s.equals((Object)"server_name")) {
                        break;
                    }
                    n2 = 1;
                    break;
                }
                case -1840434063: {
                    if (!s.equals((Object)"debug_meta")) {
                        break;
                    }
                    n2 = 0;
                    break;
                }
            }
            switch (n2) {
                default: {
                    return false;
                }
                case 13: {
                    e3.l = i1.U();
                    return true;
                }
                case 12: {
                    e3.h = (l)i1.T(n0, (c1)new l$a());
                    return true;
                }
                case 11: {
                    e3.j = i1.U();
                    return true;
                }
                case 10: {
                    e3.e = (q)i1.T(n0, (c1)new q$a());
                    return true;
                }
                case 9: {
                    e3.s = (Map<String, Object>)io.sentry.util.b.b((java.util.Map<Object, Object>)i1.S());
                    return true;
                }
                case 8: {
                    e3.m = (a0)i1.T(n0, (c1)new a0$a());
                    return true;
                }
                case 7: {
                    e3.i = (Map<String, String>)io.sentry.util.b.b((java.util.Map<Object, Object>)i1.S());
                    return true;
                }
                case 6: {
                    e3.p = i1.U();
                    return true;
                }
                case 5: {
                    e3.g = (o)i1.T(n0, (c1)new o$a());
                    return true;
                }
                case 4: {
                    e3.q = (List<e>)i1.P(n0, (c1)new e$a());
                    return true;
                }
                case 3: {
                    e3.k = i1.U();
                    return true;
                }
                case 2: {
                    ((AbstractMap)e3.f).putAll((Map)new c$a().b(i1, n0));
                    return true;
                }
                case 1: {
                    e3.o = i1.U();
                    return true;
                }
                case 0: {
                    e3.r = (d)i1.T(n0, (c1)new d$a());
                    return true;
                }
            }
        }
    }
    
    public static final class b
    {
        public void a(final e3 e3, final k1 k1, final n0 n0) {
            if (e3.e != null) {
                k1.y("event_id").z(n0, (Object)e3.e);
            }
            k1.y("contexts").z(n0, (Object)e3.f);
            if (e3.g != null) {
                k1.y("sdk").z(n0, (Object)e3.g);
            }
            if (e3.h != null) {
                k1.y("request").z(n0, (Object)e3.h);
            }
            if (e3.i != null && !e3.i.isEmpty()) {
                k1.y("tags").z(n0, (Object)e3.i);
            }
            if (e3.j != null) {
                ((io.sentry.vendor.gson.stream.c)k1.y("release")).v(e3.j);
            }
            if (e3.k != null) {
                ((io.sentry.vendor.gson.stream.c)k1.y("environment")).v(e3.k);
            }
            if (e3.l != null) {
                ((io.sentry.vendor.gson.stream.c)k1.y("platform")).v(e3.l);
            }
            if (e3.m != null) {
                k1.y("user").z(n0, (Object)e3.m);
            }
            if (e3.o != null) {
                ((io.sentry.vendor.gson.stream.c)k1.y("server_name")).v(e3.o);
            }
            if (e3.p != null) {
                ((io.sentry.vendor.gson.stream.c)k1.y("dist")).v(e3.p);
            }
            if (e3.q != null && !e3.q.isEmpty()) {
                k1.y("breadcrumbs").z(n0, (Object)e3.q);
            }
            if (e3.r != null) {
                k1.y("debug_meta").z(n0, (Object)e3.r);
            }
            if (e3.s != null && !e3.s.isEmpty()) {
                k1.y("extra").z(n0, (Object)e3.s);
            }
        }
    }
}
