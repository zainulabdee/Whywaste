package io.sentry.protocol;

import java.util.concurrent.ConcurrentHashMap;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.util.b;
import java.util.Map;
import io.sentry.m1;

public final class s implements m1
{
    private String e;
    private String f;
    private String g;
    private Map<String, Object> h;
    
    public s() {
    }
    
    s(final s s) {
        this.e = s.e;
        this.f = s.f;
        this.g = s.g;
        this.h = (Map<String, Object>)b.b((Map)s.h);
    }
    
    public String d() {
        return this.e;
    }
    
    public String e() {
        return this.f;
    }
    
    public void f(final String e) {
        this.e = e;
    }
    
    public void g(final Map<String, Object> h) {
        this.h = h;
    }
    
    public void h(final String f) {
        this.f = f;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("name").v(this.e);
        }
        if (this.f != null) {
            k1.y("version").v(this.f);
        }
        if (this.g != null) {
            k1.y("raw_description").v(this.g);
        }
        final Map<String, Object> h = this.h;
        if (h != null) {
            for (final String s : h.keySet()) {
                final Object value = this.h.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<s>
    {
        public s b(final i1 i1, final n0 n0) {
            i1.b();
            final s s = new s();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 351608024: {
                        if (!r.equals((Object)"version")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case 3373707: {
                        if (!r.equals((Object)"name")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -339173787: {
                        if (!r.equals((Object)"raw_description")) {
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
                    case 2: {
                        s.f = i1.U();
                        continue;
                    }
                    case 1: {
                        s.e = i1.U();
                        continue;
                    }
                    case 0: {
                        s.g = i1.U();
                        continue;
                    }
                }
            }
            s.g(map);
            i1.h();
            return s;
        }
    }
}
