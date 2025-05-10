package io.sentry.protocol;

import java.util.Date;
import java.util.HashMap;
import io.sentry.i1;
import io.sentry.l4;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.math.RoundingMode;
import java.math.BigDecimal;
import io.sentry.j;
import java.util.concurrent.ConcurrentHashMap;
import io.sentry.util.b;
import io.sentry.util.n;
import io.sentry.c5;
import java.util.Map;
import io.sentry.h5;
import io.sentry.f5;
import io.sentry.m1;

public final class t implements m1
{
    private final Double e;
    private final Double f;
    private final q g;
    private final f5 h;
    private final f5 i;
    private final String j;
    private final String k;
    private final h5 l;
    private final Map<String, String> m;
    private final Map<String, Object> n;
    private Map<String, Object> o;
    
    public t(final c5 c5) {
        this(c5, c5.s());
    }
    
    public t(final c5 c5, final Map<String, Object> n) {
        io.sentry.util.n.c((Object)c5, "span is required");
        this.k = c5.getDescription();
        this.j = c5.u();
        this.h = c5.y();
        this.i = c5.w();
        this.g = c5.A();
        this.l = c5.a();
        Object b = io.sentry.util.b.b((Map)c5.z());
        if (b == null) {
            b = new ConcurrentHashMap();
        }
        this.m = (Map<String, String>)b;
        this.f = io.sentry.j.l(c5.r().h(c5.l()));
        this.e = io.sentry.j.l(c5.r().i());
        this.n = n;
    }
    
    public t(final Double e, final Double f, final q g, final f5 h, final f5 i, final String j, final String k, final h5 l, final Map<String, String> m, final Map<String, Object> n) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
    }
    
    private BigDecimal a(final Double n) {
        return BigDecimal.valueOf((double)n).setScale(6, RoundingMode.DOWN);
    }
    
    public String b() {
        return this.j;
    }
    
    public void c(final Map<String, Object> o) {
        this.o = o;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("start_timestamp").z(n0, this.a(this.e));
        if (this.f != null) {
            k1.y("timestamp").z(n0, this.a(this.f));
        }
        k1.y("trace_id").z(n0, this.g);
        k1.y("span_id").z(n0, this.h);
        if (this.i != null) {
            k1.y("parent_span_id").z(n0, this.i);
        }
        k1.y("op").v(this.j);
        if (this.k != null) {
            k1.y("description").v(this.k);
        }
        if (this.l != null) {
            k1.y("status").z(n0, this.l);
        }
        if (!this.m.isEmpty()) {
            k1.y("tags").z(n0, this.m);
        }
        if (this.n != null) {
            k1.y("data").z(n0, this.n);
        }
        final Map<String, Object> o = this.o;
        if (o != null) {
            for (final String s : o.keySet()) {
                final Object value = this.o.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<t>
    {
        private Exception c(String string, final n0 n0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Missing required field \"");
            sb.append(string);
            sb.append("\"");
            string = sb.toString();
            final IllegalStateException ex = new IllegalStateException(string);
            n0.d(l4.ERROR, string, (Throwable)ex);
            return (Exception)ex;
        }
        
        public t b(final i1 i1, final n0 n0) {
            i1.b();
            Map map = null;
            Double n2 = null;
            Double n3 = null;
            q b = null;
            f5 b2 = null;
            f5 f5 = null;
            String u = null;
            String u2 = null;
            h5 h5 = null;
            Map map2 = null;
            Map<String, Object> map3 = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n4 = -1;
                switch (r.hashCode()) {
                    case 1270300245: {
                        if (!r.equals((Object)"trace_id")) {
                            break;
                        }
                        n4 = 9;
                        break;
                    }
                    case 55126294: {
                        if (!r.equals((Object)"timestamp")) {
                            break;
                        }
                        n4 = 8;
                        break;
                    }
                    case 3552281: {
                        if (!r.equals((Object)"tags")) {
                            break;
                        }
                        n4 = 7;
                        break;
                    }
                    case 3076010: {
                        if (!r.equals((Object)"data")) {
                            break;
                        }
                        n4 = 6;
                        break;
                    }
                    case 3553: {
                        if (!r.equals((Object)"op")) {
                            break;
                        }
                        n4 = 5;
                        break;
                    }
                    case -892481550: {
                        if (!r.equals((Object)"status")) {
                            break;
                        }
                        n4 = 4;
                        break;
                    }
                    case -1526966919: {
                        if (!r.equals((Object)"start_timestamp")) {
                            break;
                        }
                        n4 = 3;
                        break;
                    }
                    case -1724546052: {
                        if (!r.equals((Object)"description")) {
                            break;
                        }
                        n4 = 2;
                        break;
                    }
                    case -1757797477: {
                        if (!r.equals((Object)"parent_span_id")) {
                            break;
                        }
                        n4 = 1;
                        break;
                    }
                    case -2011840976: {
                        if (!r.equals((Object)"span_id")) {
                            break;
                        }
                        n4 = 0;
                        break;
                    }
                }
                Map map8 = null;
                f5 f10 = null;
                f5 f11 = null;
                String s3 = null;
                Label_0754: {
                    Map map5 = null;
                    f5 f8 = null;
                    f5 f9 = null;
                    String s2 = null;
                    h5 h7 = null;
                    Map map7 = null;
                    Label_0484: {
                        Map map4 = null;
                        f5 f6 = null;
                        f5 f7 = null;
                        String s = null;
                        Label_0464: {
                            switch (n4) {
                                default: {
                                    Object o = map3;
                                    if (map3 == null) {
                                        o = new ConcurrentHashMap();
                                    }
                                    i1.W(n0, (Map<String, Object>)o, r);
                                    map3 = (Map<String, Object>)o;
                                    break;
                                }
                                case 9: {
                                    b = new q.a().b(i1, n0);
                                    break;
                                }
                                case 8: {
                                    try {
                                        n3 = i1.L();
                                    }
                                    catch (final NumberFormatException ex) {
                                        final Date k = i1.K(n0);
                                        if (k != null) {
                                            n3 = io.sentry.j.b(k);
                                        }
                                        else {
                                            n3 = null;
                                        }
                                    }
                                    break;
                                }
                                case 7: {
                                    map = (Map)i1.S();
                                    break;
                                }
                                case 6: {
                                    map4 = (Map)i1.S();
                                    map5 = map;
                                    f6 = b2;
                                    f7 = f5;
                                    s = u;
                                    break Label_0464;
                                }
                                case 5: {
                                    u = i1.U();
                                    break;
                                }
                                case 4: {
                                    final h5 h6 = i1.T(n0, (io.sentry.c1<h5>)new h5.a());
                                    final Map map6 = map2;
                                    map5 = map;
                                    f8 = b2;
                                    f9 = f5;
                                    s2 = u;
                                    h7 = h6;
                                    map7 = map6;
                                    break Label_0484;
                                }
                                case 3: {
                                    try {
                                        n2 = i1.L();
                                    }
                                    catch (final NumberFormatException ex2) {
                                        final Date j = i1.K(n0);
                                        if (j != null) {
                                            n2 = io.sentry.j.b(j);
                                        }
                                        else {
                                            n2 = null;
                                        }
                                    }
                                    break;
                                }
                                case 2: {
                                    u2 = i1.U();
                                    map8 = map;
                                    f10 = b2;
                                    f11 = f5;
                                    s3 = u;
                                    break Label_0754;
                                }
                                case 1: {
                                    f5 = i1.T(n0, (io.sentry.c1<f5>)new f5.a());
                                    break;
                                }
                                case 0: {
                                    b2 = new f5.a().b(i1, n0);
                                    break;
                                }
                            }
                            map4 = map2;
                            s = u;
                            f7 = f5;
                            f6 = b2;
                            map5 = map;
                        }
                        h7 = h5;
                        map7 = map4;
                        s2 = s;
                        f9 = f7;
                        f8 = f6;
                    }
                    map8 = map5;
                    f10 = f8;
                    f11 = f9;
                    s3 = s2;
                    h5 = h7;
                    map2 = map7;
                }
                map = map8;
                b2 = f10;
                f5 = f11;
                u = s3;
            }
            if (n2 == null) {
                throw this.c("start_timestamp", n0);
            }
            if (b == null) {
                throw this.c("trace_id", n0);
            }
            if (b2 == null) {
                throw this.c("span_id", n0);
            }
            if (u != null) {
                Object o2;
                if (map == null) {
                    o2 = new HashMap();
                }
                else {
                    o2 = map;
                }
                final t t = new t(n2, n3, b, b2, f5, u, u2, h5, (Map<String, String>)o2, (Map<String, Object>)map2);
                t.c(map3);
                i1.h();
                return t;
            }
            throw this.c("op", n0);
        }
    }
}
