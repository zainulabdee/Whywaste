package io.sentry.protocol;

import java.util.concurrent.CopyOnWriteArraySet;
import io.sentry.l4;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import java.util.ArrayList;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.j4;
import io.sentry.util.n;
import java.util.Map;
import java.util.Set;
import io.sentry.m1;

public final class o implements m1
{
    private String e;
    private String f;
    private Set<r> g;
    private Set<String> h;
    private Map<String, Object> i;
    
    public o(final String s, final String s2) {
        this.e = (String)n.c((Object)s, "name is required.");
        this.f = (String)n.c((Object)s2, "version is required.");
    }
    
    public static o l(o o, final String s, final String s2) {
        n.c((Object)s, "name is required.");
        n.c((Object)s2, "version is required.");
        if (o == null) {
            o = new o(s, s2);
        }
        else {
            o.i(s);
            o.k(s2);
        }
        return o;
    }
    
    public void c(final String s) {
        j4.c().a(s);
    }
    
    public void d(final String s, final String s2) {
        j4.c().b(s, s2);
    }
    
    public Set<String> e() {
        Set set = this.h;
        if (set == null) {
            set = j4.c().d();
        }
        return (Set<String>)set;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && o.class == o.getClass()) {
            final o o2 = (o)o;
            if (!this.e.equals((Object)o2.e) || !this.f.equals((Object)o2.f)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public String f() {
        return this.e;
    }
    
    public Set<r> g() {
        Set set = this.g;
        if (set == null) {
            set = j4.c().e();
        }
        return (Set<r>)set;
    }
    
    public String h() {
        return this.f;
    }
    
    @Override
    public int hashCode() {
        return n.b(new Object[] { this.e, this.f });
    }
    
    public void i(final String s) {
        this.e = (String)n.c((Object)s, "name is required.");
    }
    
    public void j(final Map<String, Object> i) {
        this.i = i;
    }
    
    public void k(final String s) {
        this.f = (String)n.c((Object)s, "version is required.");
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("name").v(this.e);
        k1.y("version").v(this.f);
        final Set<r> g = this.g();
        final Set<String> e = this.e();
        if (!g.isEmpty()) {
            k1.y("packages").z(n0, g);
        }
        if (!e.isEmpty()) {
            k1.y("integrations").z(n0, e);
        }
        final Map<String, Object> i = this.i;
        if (i != null) {
            for (final String s : i.keySet()) {
                k1.y(s).z(n0, this.i.get((Object)s));
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<o>
    {
        public o b(final i1 i1, final n0 n0) {
            final ArrayList list = new ArrayList();
            final ArrayList list2 = new ArrayList();
            i1.b();
            String v = null;
            String v2 = null;
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1487029535: {
                        if (!r.equals((Object)"integrations")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 750867693: {
                        if (!r.equals((Object)"packages")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case 351608024: {
                        if (!r.equals((Object)"version")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case 3373707: {
                        if (!r.equals((Object)"name")) {
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
                    case 3: {
                        final List list3 = (List)i1.S();
                        if (list3 != null) {
                            ((List)list2).addAll((Collection)list3);
                            continue;
                        }
                        continue;
                    }
                    case 2: {
                        final java.util.List<Object> p2 = i1.P(n0, (io.sentry.c1<Object>)new r.a());
                        if (p2 != null) {
                            ((List)list).addAll((Collection)p2);
                            continue;
                        }
                        continue;
                    }
                    case 1: {
                        v2 = i1.v();
                        continue;
                    }
                    case 0: {
                        v = i1.v();
                        continue;
                    }
                }
            }
            i1.h();
            if (v == null) {
                final IllegalStateException ex = new IllegalStateException("Missing required field \"name\"");
                n0.d(l4.ERROR, "Missing required field \"name\"", (Throwable)ex);
                throw ex;
            }
            if (v2 != null) {
                final o o2 = new o(v, v2);
                o2.g = (Set<r>)new CopyOnWriteArraySet((Collection)list);
                o2.h = (Set<String>)new CopyOnWriteArraySet((Collection)list2);
                o2.j(map);
                return o2;
            }
            final IllegalStateException ex2 = new IllegalStateException("Missing required field \"version\"");
            n0.d(l4.ERROR, "Missing required field \"version\"", (Throwable)ex2);
            throw ex2;
        }
    }
}
