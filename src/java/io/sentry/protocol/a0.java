package io.sentry.protocol;

import io.sentry.i1;
import io.sentry.c1;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.util.n;
import java.util.Iterator;
import io.sentry.l4;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map$Entry;
import io.sentry.q4;
import io.sentry.util.b;
import java.util.Map;
import io.sentry.m1;

public final class a0 implements m1
{
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private f k;
    private Map<String, String> l;
    private Map<String, Object> m;
    
    public a0() {
    }
    
    public a0(final a0 a0) {
        this.e = a0.e;
        this.g = a0.g;
        this.f = a0.f;
        this.i = a0.i;
        this.h = a0.h;
        this.j = a0.j;
        this.k = a0.k;
        this.l = (Map<String, String>)b.b((Map)a0.l);
        this.m = (Map<String, Object>)b.b((Map)a0.m);
    }
    
    public static a0 j(final Map<String, Object> map, final q4 q4) {
        final a0 a0 = new a0();
        final Iterator iterator = map.entrySet().iterator();
        Map m = null;
        while (iterator.hasNext()) {
            final Map$Entry map$Entry = (Map$Entry)iterator.next();
            final Object value = map$Entry.getValue();
            final String s = (String)map$Entry.getKey();
            s.hashCode();
            int n = -1;
            switch (s.hashCode()) {
                case 1973722931: {
                    if (!s.equals((Object)"segment")) {
                        break;
                    }
                    n = 8;
                    break;
                }
                case 1480014044: {
                    if (!s.equals((Object)"ip_address")) {
                        break;
                    }
                    n = 7;
                    break;
                }
                case 106069776: {
                    if (!s.equals((Object)"other")) {
                        break;
                    }
                    n = 6;
                    break;
                }
                case 96619420: {
                    if (!s.equals((Object)"email")) {
                        break;
                    }
                    n = 5;
                    break;
                }
                case 3373707: {
                    if (!s.equals((Object)"name")) {
                        break;
                    }
                    n = 4;
                    break;
                }
                case 3076010: {
                    if (!s.equals((Object)"data")) {
                        break;
                    }
                    n = 3;
                    break;
                }
                case 102225: {
                    if (!s.equals((Object)"geo")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case 3355: {
                    if (!s.equals((Object)"id")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -265713450: {
                    if (!s.equals((Object)"username")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                default: {
                    Object o = m;
                    if (m == null) {
                        o = new ConcurrentHashMap();
                    }
                    ((Map)o).put((Object)map$Entry.getKey(), map$Entry.getValue());
                    m = (Map)o;
                    continue;
                }
                case 8: {
                    String h;
                    if (value instanceof String) {
                        h = (String)value;
                    }
                    else {
                        h = null;
                    }
                    a0.h = h;
                    continue;
                }
                case 7: {
                    String i;
                    if (value instanceof String) {
                        i = (String)value;
                    }
                    else {
                        i = null;
                    }
                    a0.i = i;
                    continue;
                }
                case 6: {
                    Map map2;
                    if (value instanceof Map) {
                        map2 = (Map)value;
                    }
                    else {
                        map2 = null;
                    }
                    if (map2 == null) {
                        continue;
                    }
                    final Map<String, String> l = a0.l;
                    if (l == null || l.isEmpty()) {
                        final ConcurrentHashMap j = new ConcurrentHashMap();
                        for (final Map$Entry map$Entry2 : map2.entrySet()) {
                            if (map$Entry2.getKey() instanceof String && map$Entry2.getValue() != null) {
                                j.put((Object)map$Entry2.getKey(), (Object)map$Entry2.getValue().toString());
                            }
                            else {
                                q4.getLogger().a(l4.WARNING, "Invalid key or null value in other map.", new Object[0]);
                            }
                        }
                        a0.l = (Map<String, String>)j;
                        continue;
                    }
                    continue;
                }
                case 5: {
                    String e;
                    if (value instanceof String) {
                        e = (String)value;
                    }
                    else {
                        e = null;
                    }
                    a0.e = e;
                    continue;
                }
                case 4: {
                    String k;
                    if (value instanceof String) {
                        k = (String)value;
                    }
                    else {
                        k = null;
                    }
                    a0.j = k;
                    continue;
                }
                case 3: {
                    Map map3;
                    if (value instanceof Map) {
                        map3 = (Map)value;
                    }
                    else {
                        map3 = null;
                    }
                    if (map3 != null) {
                        final ConcurrentHashMap l2 = new ConcurrentHashMap();
                        for (final Map$Entry map$Entry3 : map3.entrySet()) {
                            if (map$Entry3.getKey() instanceof String && map$Entry3.getValue() != null) {
                                l2.put((Object)map$Entry3.getKey(), (Object)map$Entry3.getValue().toString());
                            }
                            else {
                                q4.getLogger().a(l4.WARNING, "Invalid key or null value in data map.", new Object[0]);
                            }
                        }
                        a0.l = (Map<String, String>)l2;
                        continue;
                    }
                    continue;
                }
                case 2: {
                    Map map4;
                    if (value instanceof Map) {
                        map4 = (Map)value;
                    }
                    else {
                        map4 = null;
                    }
                    if (map4 != null) {
                        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                        for (final Map$Entry map$Entry4 : map4.entrySet()) {
                            if (map$Entry4.getKey() instanceof String && map$Entry4.getValue() != null) {
                                concurrentHashMap.put((Object)map$Entry4.getKey(), map$Entry4.getValue());
                            }
                            else {
                                q4.getLogger().a(l4.WARNING, "Invalid key type in gep map.", new Object[0]);
                            }
                        }
                        a0.k = f.d((Map<String, Object>)concurrentHashMap);
                        continue;
                    }
                    continue;
                }
                case 1: {
                    String f;
                    if (value instanceof String) {
                        f = (String)value;
                    }
                    else {
                        f = null;
                    }
                    a0.f = f;
                    continue;
                }
                case 0: {
                    String g;
                    if (value instanceof String) {
                        g = (String)value;
                    }
                    else {
                        g = null;
                    }
                    a0.g = g;
                    continue;
                }
            }
        }
        a0.m = (Map<String, Object>)m;
        return a0;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && a0.class == o.getClass()) {
            final a0 a0 = (a0)o;
            if (!n.a((Object)this.e, (Object)a0.e) || !n.a((Object)this.f, (Object)a0.f) || !n.a((Object)this.g, (Object)a0.g) || !n.a((Object)this.h, (Object)a0.h) || !n.a((Object)this.i, (Object)a0.i)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return n.b(new Object[] { this.e, this.f, this.g, this.h, this.i });
    }
    
    public Map<String, String> k() {
        return this.l;
    }
    
    public String l() {
        return this.e;
    }
    
    public String m() {
        return this.f;
    }
    
    public String n() {
        return this.i;
    }
    
    public String o() {
        return this.h;
    }
    
    public String p() {
        return this.g;
    }
    
    public void q(final String f) {
        this.f = f;
    }
    
    public void r(final String i) {
        this.i = i;
    }
    
    public void s(final Map<String, Object> m) {
        this.m = m;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("email").v(this.e);
        }
        if (this.f != null) {
            k1.y("id").v(this.f);
        }
        if (this.g != null) {
            k1.y("username").v(this.g);
        }
        if (this.h != null) {
            k1.y("segment").v(this.h);
        }
        if (this.i != null) {
            k1.y("ip_address").v(this.i);
        }
        if (this.j != null) {
            k1.y("name").v(this.j);
        }
        if (this.k != null) {
            k1.y("geo");
            this.k.serialize(k1, n0);
        }
        if (this.l != null) {
            k1.y("data").z(n0, this.l);
        }
        final Map<String, Object> m = this.m;
        if (m != null) {
            for (final String s : m.keySet()) {
                final Object value = this.m.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<a0>
    {
        public a0 b(final i1 i1, final n0 n0) {
            i1.b();
            final a0 a0 = new a0();
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1973722931: {
                        if (!r.equals((Object)"segment")) {
                            break;
                        }
                        n2 = 8;
                        break;
                    }
                    case 1480014044: {
                        if (!r.equals((Object)"ip_address")) {
                            break;
                        }
                        n2 = 7;
                        break;
                    }
                    case 106069776: {
                        if (!r.equals((Object)"other")) {
                            break;
                        }
                        n2 = 6;
                        break;
                    }
                    case 96619420: {
                        if (!r.equals((Object)"email")) {
                            break;
                        }
                        n2 = 5;
                        break;
                    }
                    case 3373707: {
                        if (!r.equals((Object)"name")) {
                            break;
                        }
                        n2 = 4;
                        break;
                    }
                    case 3076010: {
                        if (!r.equals((Object)"data")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 102225: {
                        if (!r.equals((Object)"geo")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case 3355: {
                        if (!r.equals((Object)"id")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -265713450: {
                        if (!r.equals((Object)"username")) {
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
                    case 8: {
                        a0.h = i1.U();
                        continue;
                    }
                    case 7: {
                        a0.i = i1.U();
                        continue;
                    }
                    case 6: {
                        if (a0.l == null || a0.l.isEmpty()) {
                            a0.l = (Map<String, String>)b.b((Map)i1.S());
                            continue;
                        }
                        continue;
                    }
                    case 5: {
                        a0.e = i1.U();
                        continue;
                    }
                    case 4: {
                        a0.j = i1.U();
                        continue;
                    }
                    case 3: {
                        a0.l = (Map<String, String>)b.b((Map)i1.S());
                        continue;
                    }
                    case 2: {
                        a0.k = new f.a().b(i1, n0);
                        continue;
                    }
                    case 1: {
                        a0.f = i1.U();
                        continue;
                    }
                    case 0: {
                        a0.g = i1.U();
                        continue;
                    }
                }
            }
            a0.s(map);
            i1.h();
            return a0;
        }
    }
}
