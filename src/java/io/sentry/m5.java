package io.sentry;

import java.util.concurrent.ConcurrentHashMap;
import io.sentry.vendor.gson.stream.b;
import java.util.Iterator;
import java.util.Map;
import io.sentry.protocol.q;

public final class m5 implements m1
{
    private final q e;
    private final String f;
    private final String g;
    private final String h;
    private final String i;
    private final String j;
    private final String k;
    private final String l;
    private Map<String, Object> m;
    
    m5(final q q, final String s) {
        this(q, s, null, null, null, null, null, null);
    }
    
    m5(final q e, final String f, final String g, final String h, final String i, final String j, final String k, final String l) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
    }
    
    public String a() {
        return this.l;
    }
    
    public void b(final Map<String, Object> m) {
        this.m = m;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("trace_id").z(n0, this.e);
        k1.y("public_key").v(this.f);
        if (this.g != null) {
            k1.y("release").v(this.g);
        }
        if (this.h != null) {
            k1.y("environment").v(this.h);
        }
        if (this.i != null) {
            k1.y("user_id").v(this.i);
        }
        if (this.j != null) {
            k1.y("user_segment").v(this.j);
        }
        if (this.k != null) {
            k1.y("transaction").v(this.k);
        }
        if (this.l != null) {
            k1.y("sample_rate").v(this.l);
        }
        final Map<String, Object> m = this.m;
        if (m != null) {
            for (final String s : m.keySet()) {
                final Object value = this.m.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class b implements c1<m5>
    {
        private Exception c(final String s, final n0 n0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Missing required field \"");
            sb.append(s);
            sb.append("\"");
            final String string = sb.toString();
            final IllegalStateException ex = new IllegalStateException(string);
            n0.d(l4.ERROR, string, (Throwable)ex);
            return (Exception)ex;
        }
        
        public m5 b(final i1 i1, final n0 n0) {
            i1.b();
            m5$c m5$c = null;
            final String s = null;
            String u;
            Object b = u = null;
            final String s3;
            final String s2 = s3 = u;
            String u3;
            String u2 = u3 = s3;
            Object o;
            String u4 = (String)(o = u3);
            String u5 = s3;
            String v = s2;
            String u6 = s;
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
                    case 1904812937: {
                        if (!r.equals((Object)"public_key")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case 1270300245: {
                        if (!r.equals((Object)"trace_id")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 1090594823: {
                        if (!r.equals((Object)"release")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 153193045: {
                        if (!r.equals((Object)"sample_rate")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 3599307: {
                        if (!r.equals((Object)"user")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case -85904877: {
                        if (!r.equals((Object)"environment")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -147132913: {
                        if (!r.equals((Object)"user_id")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -795593025: {
                        if (!r.equals((Object)"user_segment")) {
                            break;
                        }
                        n2 = 0;
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        Object o2 = o;
                        if (o == null) {
                            o2 = new ConcurrentHashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o2, r);
                        o = o2;
                        continue;
                    }
                    case 8: {
                        u3 = i1.U();
                        continue;
                    }
                    case 7: {
                        v = i1.v();
                        continue;
                    }
                    case 6: {
                        b = new q.a().b(i1, n0);
                        continue;
                    }
                    case 5: {
                        u5 = i1.U();
                        continue;
                    }
                    case 4: {
                        u4 = i1.U();
                        continue;
                    }
                    case 3: {
                        m5$c = i1.T(n0, (io.sentry.c1<m5$c>)new a());
                        continue;
                    }
                    case 2: {
                        u2 = i1.U();
                        continue;
                    }
                    case 1: {
                        u6 = i1.U();
                        continue;
                    }
                    case 0: {
                        u = i1.U();
                        continue;
                    }
                }
            }
            if (b == null) {
                throw this.c("trace_id", n0);
            }
            if (v != null) {
                String s4 = u6;
                String s5 = null;
                Label_0574: {
                    if (m5$c != null) {
                        String a;
                        if ((a = u6) == null) {
                            a = m5$c.a();
                        }
                        s4 = a;
                        if (u == null) {
                            final String b2 = m5$c.b();
                            s4 = a;
                            s5 = b2;
                            break Label_0574;
                        }
                    }
                    s5 = u;
                }
                final m5 m5 = new m5((q)b, v, u5, u2, s4, s5, u3, u4);
                m5.b((Map<String, Object>)o);
                i1.h();
                return m5;
            }
            throw this.c("public_key", n0);
        }
    }
}
