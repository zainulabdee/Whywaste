package io.sentry;

import java.util.Iterator;
import io.sentry.util.n;
import io.sentry.util.b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import io.sentry.protocol.q;

public class d5 implements m1
{
    private final q e;
    private final f5 f;
    private final f5 g;
    private transient o5 h;
    protected String i;
    protected String j;
    protected h5 k;
    protected Map<String, String> l;
    private Map<String, Object> m;
    
    public d5(final d5 d5) {
        this.l = (Map<String, String>)new ConcurrentHashMap();
        this.e = d5.e;
        this.f = d5.f;
        this.g = d5.g;
        this.h = d5.h;
        this.i = d5.i;
        this.j = d5.j;
        this.k = d5.k;
        final Map b = io.sentry.util.b.b((Map)d5.l);
        if (b != null) {
            this.l = (Map<String, String>)b;
        }
    }
    
    public d5(final q q, final f5 f5, final f5 g, final String s, final String j, final o5 h, final h5 k) {
        this.l = (Map<String, String>)new ConcurrentHashMap();
        this.e = (q)n.c((Object)q, "traceId is required");
        this.f = (f5)n.c((Object)f5, "spanId is required");
        this.i = (String)n.c((Object)s, "operation is required");
        this.g = g;
        this.h = h;
        this.j = j;
        this.k = k;
    }
    
    public d5(final q q, final f5 f5, final String s, final f5 f6, final o5 o5) {
        this(q, f5, f6, s, null, o5, null);
    }
    
    public d5(final String s) {
        this(new q(), new f5(), s, null, null);
    }
    
    public String a() {
        return this.j;
    }
    
    public String b() {
        return this.i;
    }
    
    public f5 c() {
        return this.g;
    }
    
    public Boolean d() {
        final o5 h = this.h;
        if (h == null) {
            return null;
        }
        return h.a();
    }
    
    public Boolean e() {
        final o5 h = this.h;
        if (h == null) {
            return null;
        }
        return h.c();
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof d5)) {
            return false;
        }
        final d5 d5 = (d5)o;
        if (!this.e.equals(d5.e) || !this.f.equals(d5.f) || !n.a((Object)this.g, (Object)d5.g) || !this.i.equals((Object)d5.i) || !n.a((Object)this.j, (Object)d5.j) || this.k != d5.k) {
            b = false;
        }
        return b;
    }
    
    public o5 f() {
        return this.h;
    }
    
    public f5 g() {
        return this.f;
    }
    
    public h5 h() {
        return this.k;
    }
    
    @Override
    public int hashCode() {
        return n.b(new Object[] { this.e, this.f, this.g, this.i, this.j, this.k });
    }
    
    public Map<String, String> i() {
        return this.l;
    }
    
    public q j() {
        return this.e;
    }
    
    public void k(final String j) {
        this.j = j;
    }
    
    public void l(final o5 h) {
        this.h = h;
    }
    
    public void m(final h5 k) {
        this.k = k;
    }
    
    public void n(final Map<String, Object> m) {
        this.m = m;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("trace_id");
        this.e.serialize(k1, n0);
        k1.y("span_id");
        this.f.serialize(k1, n0);
        if (this.g != null) {
            k1.y("parent_span_id");
            this.g.serialize(k1, n0);
        }
        k1.y("op").v(this.i);
        if (this.j != null) {
            k1.y("description").v(this.j);
        }
        if (this.k != null) {
            k1.y("status").z(n0, this.k);
        }
        if (!this.l.isEmpty()) {
            k1.y("tags").z(n0, this.l);
        }
        final Map<String, Object> m = this.m;
        if (m != null) {
            for (final String s : m.keySet()) {
                k1.y(s).z(n0, this.m.get((Object)s));
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<d5>
    {
        public d5 b(final i1 i1, final n0 n0) {
            i1.b();
            Map<String, Object> map = null;
            q b = null;
            String v;
            Object b2 = v = null;
            String v2;
            Object o = v2 = v;
            Object b3;
            Object o2 = b3 = v2;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1270300245: {
                        if (!r.equals((Object)"trace_id")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 3552281: {
                        if (!r.equals((Object)"tags")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 3553: {
                        if (!r.equals((Object)"op")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case -892481550: {
                        if (!r.equals((Object)"status")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case -1724546052: {
                        if (!r.equals((Object)"description")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -1757797477: {
                        if (!r.equals((Object)"parent_span_id")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -2011840976: {
                        if (!r.equals((Object)"span_id")) {
                            break;
                        }
                        n2 = 0;
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        Object o3 = map;
                        if (map == null) {
                            o3 = new ConcurrentHashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o3, r);
                        map = (Map<String, Object>)o3;
                        continue;
                    }
                    case 6: {
                        b = new q.a().b(i1, n0);
                        continue;
                    }
                    case 5: {
                        b3 = io.sentry.util.b.b((Map)i1.S());
                        continue;
                    }
                    case 4: {
                        v = i1.v();
                        continue;
                    }
                    case 3: {
                        o2 = i1.T(n0, (io.sentry.c1<h5>)new h5.a());
                        continue;
                    }
                    case 2: {
                        v2 = i1.v();
                        continue;
                    }
                    case 1: {
                        o = i1.T(n0, (io.sentry.c1<f5>)new f5.a());
                        continue;
                    }
                    case 0: {
                        b2 = new f5.a().b(i1, n0);
                        continue;
                    }
                }
            }
            if (b == null) {
                final IllegalStateException ex = new IllegalStateException("Missing required field \"trace_id\"");
                n0.d(l4.ERROR, "Missing required field \"trace_id\"", (Throwable)ex);
                throw ex;
            }
            if (b2 == null) {
                final IllegalStateException ex2 = new IllegalStateException("Missing required field \"span_id\"");
                n0.d(l4.ERROR, "Missing required field \"span_id\"", (Throwable)ex2);
                throw ex2;
            }
            if (v != null) {
                final d5 d5 = new d5(b, (f5)b2, v, (f5)o, null);
                d5.k(v2);
                d5.m((h5)o2);
                if (b3 != null) {
                    d5.l = (Map<String, String>)b3;
                }
                d5.n(map);
                i1.h();
                return d5;
            }
            final IllegalStateException ex3 = new IllegalStateException("Missing required field \"op\"");
            n0.d(l4.ERROR, "Missing required field \"op\"", (Throwable)ex3);
            throw ex3;
        }
    }
}
