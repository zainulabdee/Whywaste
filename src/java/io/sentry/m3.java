package io.sentry;

import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Date;
import io.sentry.protocol.o;
import io.sentry.protocol.q;

public final class m3 implements m1
{
    private final q e;
    private final o f;
    private final m5 g;
    private Date h;
    private Map<String, Object> i;
    
    public m3() {
        this(new q());
    }
    
    public m3(final q q) {
        this(q, null);
    }
    
    public m3(final q q, final o o) {
        this(q, o, null);
    }
    
    public m3(final q e, final o f, final m5 g) {
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public q a() {
        return this.e;
    }
    
    public o b() {
        return this.f;
    }
    
    public m5 c() {
        return this.g;
    }
    
    public void d(final Date h) {
        this.h = h;
    }
    
    public void e(final Map<String, Object> i) {
        this.i = i;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("event_id").z(n0, this.e);
        }
        if (this.f != null) {
            k1.y("sdk").z(n0, this.f);
        }
        if (this.g != null) {
            k1.y("trace").z(n0, this.g);
        }
        if (this.h != null) {
            k1.y("sent_at").z(n0, j.g(this.h));
        }
        final Map<String, Object> i = this.i;
        if (i != null) {
            for (final String s : i.keySet()) {
                final Object value = this.i.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<m3>
    {
        public m3 b(final i1 i1, final n0 n0) {
            i1.b();
            q q = null;
            o o = null;
            Object o2 = null;
            Object o3;
            Object k = o3 = o2;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1980389946: {
                        if (!r.equals((Object)"sent_at")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 278118624: {
                        if (!r.equals((Object)"event_id")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case 110620997: {
                        if (!r.equals((Object)"trace")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case 113722: {
                        if (!r.equals((Object)"sdk")) {
                            break;
                        }
                        n2 = 0;
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        Object o4 = o3;
                        if (o3 == null) {
                            o4 = new HashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o4, r);
                        o3 = o4;
                        continue;
                    }
                    case 3: {
                        k = i1.K(n0);
                        continue;
                    }
                    case 2: {
                        q = i1.T(n0, (io.sentry.c1<q>)new q.a());
                        continue;
                    }
                    case 1: {
                        o2 = i1.T(n0, (io.sentry.c1<m5>)new m5.b());
                        continue;
                    }
                    case 0: {
                        o = i1.T(n0, (io.sentry.c1<o>)new o.a());
                        continue;
                    }
                }
            }
            final m3 m3 = new m3(q, o, (m5)o2);
            m3.d((Date)k);
            m3.e((Map<String, Object>)o3);
            i1.h();
            return m3;
        }
    }
}
