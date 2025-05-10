package io.sentry;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Iterator;
import io.sentry.util.n;
import io.sentry.util.b;
import java.util.Map;

public final class m4 implements m1
{
    private int e;
    private String f;
    private String g;
    private String h;
    private Long i;
    private Map<String, Object> j;
    
    public m4() {
    }
    
    public m4(final m4 m4) {
        this.e = m4.e;
        this.f = m4.f;
        this.g = m4.g;
        this.h = m4.h;
        this.i = m4.i;
        this.j = (Map<String, Object>)b.b((Map)m4.j);
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && m4.class == o.getClass() && n.a((Object)this.f, (Object)((m4)o).f));
    }
    
    public String f() {
        return this.f;
    }
    
    public int g() {
        return this.e;
    }
    
    public void h(final String f) {
        this.f = f;
    }
    
    @Override
    public int hashCode() {
        return n.b(new Object[] { this.f });
    }
    
    public void i(final String h) {
        this.h = h;
    }
    
    public void j(final String g) {
        this.g = g;
    }
    
    public void k(final Long i) {
        this.i = i;
    }
    
    public void l(final int e) {
        this.e = e;
    }
    
    public void m(final Map<String, Object> j) {
        this.j = j;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("type").s((long)this.e);
        if (this.f != null) {
            k1.y("address").v(this.f);
        }
        if (this.g != null) {
            k1.y("package_name").v(this.g);
        }
        if (this.h != null) {
            k1.y("class_name").v(this.h);
        }
        if (this.i != null) {
            k1.y("thread_id").u((Number)this.i);
        }
        final Map<String, Object> j = this.j;
        if (j != null) {
            for (final String s : j.keySet()) {
                final Object value = this.j.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<m4>
    {
        public m4 b(final i1 i1, final n0 n0) {
            final m4 m4 = new m4();
            i1.b();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 3575610: {
                        if (!r.equals((Object)"type")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case -290474766: {
                        if (!r.equals((Object)"class_name")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case -1147692044: {
                        if (!r.equals((Object)"address")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -1562235024: {
                        if (!r.equals((Object)"thread_id")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1877165340: {
                        if (!r.equals((Object)"package_name")) {
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
                    case 4: {
                        m4.e = i1.p();
                        continue;
                    }
                    case 3: {
                        m4.h = i1.U();
                        continue;
                    }
                    case 2: {
                        m4.f = i1.U();
                        continue;
                    }
                    case 1: {
                        m4.i = i1.Q();
                        continue;
                    }
                    case 0: {
                        m4.g = i1.U();
                        continue;
                    }
                }
            }
            m4.m(map);
            i1.h();
            return m4;
        }
    }
}
