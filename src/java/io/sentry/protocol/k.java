package io.sentry.protocol;

import java.util.concurrent.ConcurrentHashMap;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.util.n;
import io.sentry.util.b;
import java.util.Map;
import io.sentry.m1;

public final class k implements m1
{
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private Boolean j;
    private Map<String, Object> k;
    
    public k() {
    }
    
    k(final k k) {
        this.e = k.e;
        this.f = k.f;
        this.g = k.g;
        this.h = k.h;
        this.i = k.i;
        this.j = k.j;
        this.k = (Map<String, Object>)b.b((Map)k.k);
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && k.class == o.getClass()) {
            final k k = (k)o;
            if (!n.a((Object)this.e, (Object)k.e) || !n.a((Object)this.f, (Object)k.f) || !n.a((Object)this.g, (Object)k.g) || !n.a((Object)this.h, (Object)k.h) || !n.a((Object)this.i, (Object)k.i) || !n.a((Object)this.j, (Object)k.j)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public String g() {
        return this.e;
    }
    
    public void h(final String h) {
        this.h = h;
    }
    
    @Override
    public int hashCode() {
        return n.b(new Object[] { this.e, this.f, this.g, this.h, this.i, this.j });
    }
    
    public void i(final String i) {
        this.i = i;
    }
    
    public void j(final String e) {
        this.e = e;
    }
    
    public void k(final Boolean j) {
        this.j = j;
    }
    
    public void l(final Map<String, Object> k) {
        this.k = k;
    }
    
    public void m(final String f) {
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
        if (this.h != null) {
            k1.y("build").v(this.h);
        }
        if (this.i != null) {
            k1.y("kernel_version").v(this.i);
        }
        if (this.j != null) {
            k1.y("rooted").t(this.j);
        }
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
    
    public static final class a implements c1<k>
    {
        public k b(final i1 i1, final n0 n0) {
            i1.b();
            final k k = new k();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 2015527638: {
                        if (!r.equals((Object)"kernel_version")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 351608024: {
                        if (!r.equals((Object)"version")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 94094958: {
                        if (!r.equals((Object)"build")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 3373707: {
                        if (!r.equals((Object)"name")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -339173787: {
                        if (!r.equals((Object)"raw_description")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -925311743: {
                        if (!r.equals((Object)"rooted")) {
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
                    case 5: {
                        k.i = i1.U();
                        continue;
                    }
                    case 4: {
                        k.f = i1.U();
                        continue;
                    }
                    case 3: {
                        k.h = i1.U();
                        continue;
                    }
                    case 2: {
                        k.e = i1.U();
                        continue;
                    }
                    case 1: {
                        k.g = i1.U();
                        continue;
                    }
                    case 0: {
                        k.j = i1.J();
                        continue;
                    }
                }
            }
            k.l(map);
            i1.h();
            return k;
        }
    }
}
