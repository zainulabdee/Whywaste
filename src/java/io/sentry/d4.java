package io.sentry;

import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import java.util.Iterator;
import io.sentry.util.n;
import java.util.Map;
import java.util.concurrent.Callable;

public final class d4 implements m1
{
    private final String e;
    private final String f;
    private final k4 g;
    private final int h;
    private final Callable<Integer> i;
    private final String j;
    private Map<String, Object> k;
    
    public d4(final k4 k4, final int h, final String e, final String f, final String j) {
        this.g = (k4)n.c((Object)k4, "type is required");
        this.e = e;
        this.h = h;
        this.f = f;
        this.i = null;
        this.j = j;
    }
    
    d4(final k4 k4, final Callable<Integer> callable, final String s, final String s2) {
        this(k4, callable, s, s2, null);
    }
    
    d4(final k4 k4, final Callable<Integer> i, final String e, final String f, final String j) {
        this.g = (k4)n.c((Object)k4, "type is required");
        this.e = e;
        this.h = -1;
        this.f = f;
        this.i = i;
        this.j = j;
    }
    
    public int a() {
        final Callable<Integer> i = this.i;
        if (i != null) {
            try {
                return (int)i.call();
            }
            finally {
                return -1;
            }
        }
        return this.h;
    }
    
    public k4 b() {
        return this.g;
    }
    
    public void c(final Map<String, Object> k) {
        this.k = k;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("content_type").v(this.e);
        }
        if (this.f != null) {
            k1.y("filename").v(this.f);
        }
        k1.y("type").z(n0, this.g);
        if (this.j != null) {
            k1.y("attachment_type").v(this.j);
        }
        k1.y("length").s((long)this.a());
        final Map<String, Object> i = this.k;
        if (i != null) {
            for (final String s : i.keySet()) {
                final Object value = this.k.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<d4>
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
        
        public d4 b(final i1 i1, final n0 n0) {
            i1.b();
            Map<String, Object> map = null;
            k4 k4 = null;
            String u = null;
            String u3;
            String u2 = u3 = u;
            int p2 = 0;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 831846208: {
                        if (!r.equals((Object)"content_type")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 3575610: {
                        if (!r.equals((Object)"type")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case -672977706: {
                        if (!r.equals((Object)"attachment_type")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -734768633: {
                        if (!r.equals((Object)"filename")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1106363674: {
                        if (!r.equals((Object)"length")) {
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
                            o = new HashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                        continue;
                    }
                    case 4: {
                        u = i1.U();
                        continue;
                    }
                    case 3: {
                        k4 = i1.T(n0, (io.sentry.c1<k4>)new k4.a());
                        continue;
                    }
                    case 2: {
                        u3 = i1.U();
                        continue;
                    }
                    case 1: {
                        u2 = i1.U();
                        continue;
                    }
                    case 0: {
                        p2 = i1.p();
                        continue;
                    }
                }
            }
            if (k4 != null) {
                final d4 d4 = new d4(k4, p2, u, u2, u3);
                d4.c(map);
                i1.h();
                return d4;
            }
            throw this.c("type", n0);
        }
    }
}
