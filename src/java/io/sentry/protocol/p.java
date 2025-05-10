package io.sentry.protocol;

import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Map;
import io.sentry.m1;

public final class p implements m1
{
    private String e;
    private String f;
    private String g;
    private Long h;
    private v i;
    private i j;
    private Map<String, Object> k;
    
    public i g() {
        return this.j;
    }
    
    public Long h() {
        return this.h;
    }
    
    public void i(final i j) {
        this.j = j;
    }
    
    public void j(final String g) {
        this.g = g;
    }
    
    public void k(final v i) {
        this.i = i;
    }
    
    public void l(final Long h) {
        this.h = h;
    }
    
    public void m(final String e) {
        this.e = e;
    }
    
    public void n(final Map<String, Object> k) {
        this.k = k;
    }
    
    public void o(final String f) {
        this.f = f;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("type").v(this.e);
        }
        if (this.f != null) {
            k1.y("value").v(this.f);
        }
        if (this.g != null) {
            k1.y("module").v(this.g);
        }
        if (this.h != null) {
            k1.y("thread_id").u((Number)this.h);
        }
        if (this.i != null) {
            k1.y("stacktrace").z(n0, this.i);
        }
        if (this.j != null) {
            k1.y("mechanism").z(n0, this.j);
        }
        final Map<String, Object> i = this.k;
        if (i != null) {
            for (final String s : i.keySet()) {
                k1.y(s).z(n0, this.k.get((Object)s));
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<p>
    {
        public p b(final i1 i1, final n0 n0) {
            final p p2 = new p();
            i1.b();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 2055832509: {
                        if (!r.equals((Object)"stacktrace")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 1225089881: {
                        if (!r.equals((Object)"mechanism")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 111972721: {
                        if (!r.equals((Object)"value")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 3575610: {
                        if (!r.equals((Object)"type")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -1068784020: {
                        if (!r.equals((Object)"module")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1562235024: {
                        if (!r.equals((Object)"thread_id")) {
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
                    case 5: {
                        p2.i = i1.T(n0, (io.sentry.c1<v>)new v.a());
                        continue;
                    }
                    case 4: {
                        p2.j = i1.T(n0, (io.sentry.c1<i>)new i.a());
                        continue;
                    }
                    case 3: {
                        p2.f = i1.U();
                        continue;
                    }
                    case 2: {
                        p2.e = i1.U();
                        continue;
                    }
                    case 1: {
                        p2.g = i1.U();
                        continue;
                    }
                    case 0: {
                        p2.h = i1.Q();
                        continue;
                    }
                }
            }
            i1.h();
            p2.n(map);
            return p2;
        }
    }
}
