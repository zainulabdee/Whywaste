package io.sentry.protocol;

import java.util.AbstractMap;
import io.sentry.i1;
import io.sentry.c1;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.util.n;
import java.util.Iterator;
import io.sentry.d5;
import java.util.Map$Entry;
import io.sentry.m1;
import java.util.concurrent.ConcurrentHashMap;

public final class c extends ConcurrentHashMap<String, Object> implements m1
{
    public c() {
    }
    
    public c(final c c) {
        for (final Map$Entry map$Entry : ((AbstractMap)c).entrySet()) {
            if (map$Entry != null) {
                final Object value = map$Entry.getValue();
                if ("app".equals(map$Entry.getKey()) && value instanceof io.sentry.protocol.a) {
                    this.f(new io.sentry.protocol.a((io.sentry.protocol.a)value));
                }
                else if ("browser".equals(map$Entry.getKey()) && value instanceof b) {
                    this.g(new b((b)value));
                }
                else if ("device".equals(map$Entry.getKey()) && value instanceof e) {
                    this.h(new e((e)value));
                }
                else if ("os".equals(map$Entry.getKey()) && value instanceof k) {
                    this.j(new k((k)value));
                }
                else if ("runtime".equals(map$Entry.getKey()) && value instanceof s) {
                    this.l(new s((s)value));
                }
                else if ("gpu".equals(map$Entry.getKey()) && value instanceof g) {
                    this.i(new g((g)value));
                }
                else if ("trace".equals(map$Entry.getKey()) && value instanceof d5) {
                    this.m(new d5((d5)value));
                }
                else if ("response".equals(map$Entry.getKey()) && value instanceof m) {
                    this.k(new m((m)value));
                }
                else {
                    ((AbstractMap)this).put((Object)map$Entry.getKey(), value);
                }
            }
        }
    }
    
    private <T> T n(final String s, final Class<T> clazz) {
        final Object value = ((AbstractMap)this).get((Object)s);
        T cast;
        if (clazz.isInstance(value)) {
            cast = clazz.cast(value);
        }
        else {
            cast = null;
        }
        return cast;
    }
    
    public io.sentry.protocol.a a() {
        return this.n("app", io.sentry.protocol.a.class);
    }
    
    public e b() {
        return this.n("device", e.class);
    }
    
    public k c() {
        return this.n("os", k.class);
    }
    
    public s d() {
        return this.n("runtime", s.class);
    }
    
    public d5 e() {
        return this.n("trace", d5.class);
    }
    
    public void f(final io.sentry.protocol.a a) {
        ((AbstractMap)this).put((Object)"app", (Object)a);
    }
    
    public void g(final b b) {
        ((AbstractMap)this).put((Object)"browser", (Object)b);
    }
    
    public void h(final e e) {
        ((AbstractMap)this).put((Object)"device", (Object)e);
    }
    
    public void i(final g g) {
        ((AbstractMap)this).put((Object)"gpu", (Object)g);
    }
    
    public void j(final k k) {
        ((AbstractMap)this).put((Object)"os", (Object)k);
    }
    
    public void k(final m m) {
        ((AbstractMap)this).put((Object)"response", (Object)m);
    }
    
    public void l(final s s) {
        ((AbstractMap)this).put((Object)"runtime", (Object)s);
    }
    
    public void m(final d5 d5) {
        n.c((Object)d5, "traceContext is required");
        ((AbstractMap)this).put((Object)"trace", (Object)d5);
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        final ArrayList list = Collections.list(this.keys());
        Collections.sort((List)list);
        for (final String s : list) {
            final Object value = ((AbstractMap)this).get((Object)s);
            if (value != null) {
                k1.y(s).z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<c>
    {
        public c b(final i1 i1, final n0 n0) {
            final c c = new c();
            i1.b();
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1550962648: {
                        if (!r.equals((Object)"runtime")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case 150940456: {
                        if (!r.equals((Object)"browser")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 110620997: {
                        if (!r.equals((Object)"trace")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 102572: {
                        if (!r.equals((Object)"gpu")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 96801: {
                        if (!r.equals((Object)"app")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 3556: {
                        if (!r.equals((Object)"os")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case -340323263: {
                        if (!r.equals((Object)"response")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -1335157162: {
                        if (!r.equals((Object)"device")) {
                            break;
                        }
                        n2 = 0;
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        final Object s = i1.S();
                        if (s != null) {
                            ((AbstractMap)c).put((Object)r, s);
                            continue;
                        }
                        continue;
                    }
                    case 7: {
                        c.l(new s.a().b(i1, n0));
                        continue;
                    }
                    case 6: {
                        c.g(new b.a().b(i1, n0));
                        continue;
                    }
                    case 5: {
                        c.m(new d5.a().b(i1, n0));
                        continue;
                    }
                    case 4: {
                        c.i(new g.a().b(i1, n0));
                        continue;
                    }
                    case 3: {
                        c.f(new io.sentry.protocol.a.a().b(i1, n0));
                        continue;
                    }
                    case 2: {
                        c.j(new k.a().b(i1, n0));
                        continue;
                    }
                    case 1: {
                        c.k(new m.a().b(i1, n0));
                        continue;
                    }
                    case 0: {
                        c.h(new e.a().b(i1, n0));
                        continue;
                    }
                }
            }
            i1.h();
            return c;
        }
    }
}
