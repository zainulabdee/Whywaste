package io.sentry;

import java.util.concurrent.ConcurrentHashMap;
import io.sentry.vendor.gson.stream.b;
import java.util.Iterator;
import io.sentry.util.n;
import java.util.Map;

public final class m2 implements m1
{
    private String e;
    private String f;
    private String g;
    private Long h;
    private Long i;
    private Long j;
    private Long k;
    private Map<String, Object> l;
    
    public m2() {
        final a2 s = a2.s();
        final Long value = 0L;
        this((v0)s, value, value);
    }
    
    public m2(final v0 v0, final Long h, final Long j) {
        this.e = v0.f().toString();
        this.f = ((u0)v0).i().j().toString();
        this.g = v0.getName();
        this.h = h;
        this.j = j;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && m2.class == o.getClass()) {
            final m2 m2 = (m2)o;
            if (!this.e.equals((Object)m2.e) || !this.f.equals((Object)m2.f) || !this.g.equals((Object)m2.g) || !this.h.equals((Object)m2.h) || !this.j.equals((Object)m2.j) || !n.a((Object)this.k, (Object)m2.k) || !n.a((Object)this.i, (Object)m2.i) || !n.a((Object)this.l, (Object)m2.l)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public String h() {
        return this.e;
    }
    
    @Override
    public int hashCode() {
        return n.b(new Object[] { this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l });
    }
    
    public void i(final Long n, final Long n2, final Long n3, final Long n4) {
        if (this.i == null) {
            this.i = n - n2;
            this.h -= n2;
            this.k = n3 - n4;
            this.j -= n4;
        }
    }
    
    public void j(final Map<String, Object> l) {
        this.l = l;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("id").z(n0, this.e);
        k1.y("trace_id").z(n0, this.f);
        k1.y("name").z(n0, this.g);
        k1.y("relative_start_ns").z(n0, this.h);
        k1.y("relative_end_ns").z(n0, this.i);
        k1.y("relative_cpu_start_ms").z(n0, this.j);
        k1.y("relative_cpu_end_ms").z(n0, this.k);
        final Map<String, Object> l = this.l;
        if (l != null) {
            for (final String s : l.keySet()) {
                final Object value = this.l.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<m2>
    {
        public m2 b(final i1 i1, final n0 n0) {
            i1.b();
            final m2 m2 = new m2();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1902256621: {
                        if (!r.equals((Object)"relative_cpu_start_ms")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 1566648660: {
                        if (!r.equals((Object)"relative_cpu_end_ms")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 1270300245: {
                        if (!r.equals((Object)"trace_id")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 3373707: {
                        if (!r.equals((Object)"name")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 3355: {
                        if (!r.equals((Object)"id")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -84607876: {
                        if (!r.equals((Object)"relative_end_ns")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -112372011: {
                        if (!r.equals((Object)"relative_start_ns")) {
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
                    case 6: {
                        final Long q = i1.Q();
                        if (q != null) {
                            m2.j = q;
                            continue;
                        }
                        continue;
                    }
                    case 5: {
                        final Long q2 = i1.Q();
                        if (q2 != null) {
                            m2.k = q2;
                            continue;
                        }
                        continue;
                    }
                    case 4: {
                        final String u = i1.U();
                        if (u != null) {
                            m2.f = u;
                            continue;
                        }
                        continue;
                    }
                    case 3: {
                        final String u2 = i1.U();
                        if (u2 != null) {
                            m2.g = u2;
                            continue;
                        }
                        continue;
                    }
                    case 2: {
                        final String u3 = i1.U();
                        if (u3 != null) {
                            m2.e = u3;
                            continue;
                        }
                        continue;
                    }
                    case 1: {
                        final Long q3 = i1.Q();
                        if (q3 != null) {
                            m2.i = q3;
                            continue;
                        }
                        continue;
                    }
                    case 0: {
                        final Long q4 = i1.Q();
                        if (q4 != null) {
                            m2.h = q4;
                            continue;
                        }
                        continue;
                    }
                }
            }
            m2.j(map);
            i1.h();
            return m2;
        }
    }
}
