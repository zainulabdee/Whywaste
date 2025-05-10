package io.sentry;

import io.sentry.util.n;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map$Entry;
import io.sentry.util.b;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Date;

public final class e implements m1
{
    private final Date e;
    private String f;
    private String g;
    private Map<String, Object> h;
    private String i;
    private l4 j;
    private Map<String, Object> k;
    
    public e() {
        this(io.sentry.j.c());
    }
    
    e(final e e) {
        this.h = (Map<String, Object>)new ConcurrentHashMap();
        this.e = e.e;
        this.f = e.f;
        this.g = e.g;
        this.i = e.i;
        final Map b = io.sentry.util.b.b((Map)e.h);
        if (b != null) {
            this.h = (Map<String, Object>)b;
        }
        this.k = (Map<String, Object>)io.sentry.util.b.b((Map)e.k);
        this.j = e.j;
    }
    
    public e(final Date e) {
        this.h = (Map<String, Object>)new ConcurrentHashMap();
        this.e = e;
    }
    
    public static e f(Map<String, Object> i, final q4 q4) {
        Date c = j.c();
        final ConcurrentHashMap h = new ConcurrentHashMap();
        final Iterator iterator = ((Map)i).entrySet().iterator();
        String f = null;
        Object g = i = null;
        Map map;
        Object value = map = (Map)i;
        Object j = null;
    Label_0041:
        while (true) {
            while (true) {
                j = value;
                if (!iterator.hasNext()) {
                    break;
                }
                final Map$Entry map$Entry = (Map$Entry)iterator.next();
                final Object value2 = map$Entry.getValue();
                final String s = (String)map$Entry.getKey();
                s.hashCode();
                int n = -1;
                switch (s.hashCode()) {
                    case 954925063: {
                        if (!s.equals((Object)"message")) {
                            break;
                        }
                        n = 5;
                        break;
                    }
                    case 102865796: {
                        if (!s.equals((Object)"level")) {
                            break;
                        }
                        n = 4;
                        break;
                    }
                    case 55126294: {
                        if (!s.equals((Object)"timestamp")) {
                            break;
                        }
                        n = 3;
                        break;
                    }
                    case 50511102: {
                        if (!s.equals((Object)"category")) {
                            break;
                        }
                        n = 2;
                        break;
                    }
                    case 3575610: {
                        if (!s.equals((Object)"type")) {
                            break;
                        }
                        n = 1;
                        break;
                    }
                    case 3076010: {
                        if (!s.equals((Object)"data")) {
                            break;
                        }
                        n = 0;
                        break;
                    }
                }
                switch (n) {
                    default: {
                        Object o = map;
                        if (map == null) {
                            o = new ConcurrentHashMap();
                        }
                        ((Map)o).put((Object)map$Entry.getKey(), map$Entry.getValue());
                        value = j;
                        map = (Map)o;
                        continue;
                    }
                    case 5: {
                        if (value2 instanceof String) {
                            f = (String)value2;
                            value = j;
                            continue;
                        }
                        f = null;
                        value = j;
                        continue;
                    }
                    case 4: {
                        String s2;
                        if (value2 instanceof String) {
                            s2 = (String)value2;
                        }
                        else {
                            s2 = null;
                        }
                        value = j;
                        if (s2 != null) {
                            try {
                                value = l4.valueOf(s2.toUpperCase(Locale.ROOT));
                            }
                            catch (final Exception ex) {
                                value = j;
                            }
                            continue;
                        }
                        continue;
                    }
                    case 3: {
                        value = j;
                        if (!(value2 instanceof String)) {
                            continue;
                        }
                        final Date k = i1.I((String)value2, q4.getLogger());
                        value = j;
                        if (k != null) {
                            c = k;
                            value = j;
                            continue;
                        }
                        continue;
                    }
                    case 2: {
                        if (value2 instanceof String) {
                            i = value2;
                            value = j;
                            continue;
                        }
                        i = null;
                        value = j;
                        continue;
                    }
                    case 1: {
                        if (value2 instanceof String) {
                            g = value2;
                            value = j;
                            continue;
                        }
                        g = null;
                        value = j;
                        continue;
                    }
                    case 0: {
                        Map map2;
                        if (value2 instanceof Map) {
                            map2 = (Map)value2;
                        }
                        else {
                            map2 = null;
                        }
                        value = j;
                        if (map2 == null) {
                            continue;
                        }
                        final Iterator iterator2 = map2.entrySet().iterator();
                        while (true) {
                            value = j;
                            if (!iterator2.hasNext()) {
                                continue Label_0041;
                            }
                            final Map$Entry map$Entry2 = (Map$Entry)iterator2.next();
                            if (map$Entry2.getKey() instanceof String && map$Entry2.getValue() != null) {
                                ((Map)h).put((Object)map$Entry2.getKey(), map$Entry2.getValue());
                            }
                            else {
                                q4.getLogger().a(l4.WARNING, "Invalid key or null value in data map.", new Object[0]);
                            }
                        }
                        break;
                    }
                }
            }
            break;
        }
        final e e = new e(c);
        e.f = f;
        e.g = (String)g;
        e.h = (Map<String, Object>)h;
        e.i = (String)i;
        e.j = (l4)j;
        e.r((Map<String, Object>)map);
        return e;
    }
    
    public static e s(final String s, final String s2, final String s3, final String s4, final Map<String, Object> map) {
        final e e = new e();
        e.q("user");
        final StringBuilder sb = new StringBuilder();
        sb.append("ui.");
        sb.append(s);
        e.m(sb.toString());
        if (s2 != null) {
            e.n("view.id", s2);
        }
        if (s3 != null) {
            e.n("view.class", s3);
        }
        if (s4 != null) {
            e.n("view.tag", s4);
        }
        for (final Map$Entry map$Entry : map.entrySet()) {
            e.h().put((Object)map$Entry.getKey(), map$Entry.getValue());
        }
        e.o(l4.INFO);
        return e;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && e.class == o.getClass()) {
            final e e = (e)o;
            if (this.e.getTime() != e.e.getTime() || !n.a((Object)this.f, (Object)e.f) || !n.a((Object)this.g, (Object)e.g) || !n.a((Object)this.i, (Object)e.i) || this.j != e.j) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    public String g() {
        return this.i;
    }
    
    public Map<String, Object> h() {
        return this.h;
    }
    
    @Override
    public int hashCode() {
        return n.b(new Object[] { this.e, this.f, this.g, this.i, this.j });
    }
    
    public l4 i() {
        return this.j;
    }
    
    public String j() {
        return this.f;
    }
    
    public Date k() {
        return (Date)this.e.clone();
    }
    
    public String l() {
        return this.g;
    }
    
    public void m(final String i) {
        this.i = i;
    }
    
    public void n(final String s, final Object o) {
        this.h.put((Object)s, o);
    }
    
    public void o(final l4 j) {
        this.j = j;
    }
    
    public void p(final String f) {
        this.f = f;
    }
    
    public void q(final String g) {
        this.g = g;
    }
    
    public void r(final Map<String, Object> k) {
        this.k = k;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("timestamp").z(n0, this.e);
        if (this.f != null) {
            k1.y("message").v(this.f);
        }
        if (this.g != null) {
            k1.y("type").v(this.g);
        }
        k1.y("data").z(n0, this.h);
        if (this.i != null) {
            k1.y("category").v(this.i);
        }
        if (this.j != null) {
            k1.y("level").z(n0, this.j);
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
    
    public static final class a implements c1<e>
    {
        public e b(final i1 i1, final n0 n0) {
            i1.b();
            Date c = io.sentry.j.c();
            Object o = new ConcurrentHashMap();
            String u = null;
            String u2 = null;
            Object u3 = null;
            Object o2;
            Object b = o2 = u3;
            Object o3;
            while (true) {
                o3 = b;
                if (i1.x() != io.sentry.vendor.gson.stream.b.NAME) {
                    break;
                }
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 954925063: {
                        if (!r.equals((Object)"message")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 102865796: {
                        if (!r.equals((Object)"level")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 55126294: {
                        if (!r.equals((Object)"timestamp")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 50511102: {
                        if (!r.equals((Object)"category")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case 3575610: {
                        if (!r.equals((Object)"type")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case 3076010: {
                        if (!r.equals((Object)"data")) {
                            break;
                        }
                        n2 = 0;
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        Object o4 = o2;
                        if (o2 == null) {
                            o4 = new ConcurrentHashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o4, r);
                        b = o3;
                        o2 = o4;
                        continue;
                    }
                    case 5: {
                        u = i1.U();
                        b = o3;
                        continue;
                    }
                    case 4: {
                        try {
                            b = new l4.a().b(i1, n0);
                        }
                        catch (final Exception ex) {
                            n0.c(l4.ERROR, (Throwable)ex, "Error when deserializing SentryLevel", new Object[0]);
                            b = o3;
                        }
                        continue;
                    }
                    case 3: {
                        final Date k = i1.K(n0);
                        b = o3;
                        if (k != null) {
                            c = k;
                            b = o3;
                            continue;
                        }
                        continue;
                    }
                    case 2: {
                        u3 = i1.U();
                        b = o3;
                        continue;
                    }
                    case 1: {
                        u2 = i1.U();
                        b = o3;
                        continue;
                    }
                    case 0: {
                        final Map b2 = io.sentry.util.b.b((Map)i1.S());
                        b = o3;
                        if (b2 != null) {
                            o = b2;
                            b = o3;
                            continue;
                        }
                        continue;
                    }
                }
            }
            final e e = new e(c);
            e.f = u;
            e.g = u2;
            e.h = (Map<String, Object>)o;
            e.i = (String)u3;
            e.j = (l4)o3;
            e.r((Map<String, Object>)o2);
            i1.h();
            return e;
        }
    }
}
