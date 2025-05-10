package io.sentry.protocol;

import java.util.concurrent.ConcurrentHashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import io.sentry.m1;

public final class f implements m1
{
    private String e;
    private String f;
    private String g;
    private Map<String, Object> h;
    
    public static f d(final Map<String, Object> map) {
        final f f = new f();
        for (final Map$Entry map$Entry : map.entrySet()) {
            final Object value = map$Entry.getValue();
            final String s = (String)map$Entry.getKey();
            s.hashCode();
            int n = -1;
            switch (s.hashCode()) {
                case 1481071862: {
                    if (!s.equals((Object)"country_code")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case 3053931: {
                    if (!s.equals((Object)"city")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -934795532: {
                    if (!s.equals((Object)"region")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            final String s2 = null;
            final String s3 = null;
            String f2 = null;
            switch (n) {
                default: {
                    continue;
                }
                case 2: {
                    if (value instanceof String) {
                        f2 = (String)value;
                    }
                    f.f = f2;
                    continue;
                }
                case 1: {
                    String e = s2;
                    if (value instanceof String) {
                        e = (String)value;
                    }
                    f.e = e;
                    continue;
                }
                case 0: {
                    String g = s3;
                    if (value instanceof String) {
                        g = (String)value;
                    }
                    f.g = g;
                    continue;
                }
            }
        }
        return f;
    }
    
    public void e(final Map<String, Object> h) {
        this.h = h;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("city").v(this.e);
        }
        if (this.f != null) {
            k1.y("country_code").v(this.f);
        }
        if (this.g != null) {
            k1.y("region").v(this.g);
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
    
    public static final class a implements c1<f>
    {
        public f b(final i1 i1, final n0 n0) {
            i1.b();
            final f f = new f();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 1481071862: {
                        if (!r.equals((Object)"country_code")) {
                            break;
                        }
                        n2 = 2;
                        break;
                    }
                    case 3053931: {
                        if (!r.equals((Object)"city")) {
                            break;
                        }
                        n2 = 1;
                        break;
                    }
                    case -934795532: {
                        if (!r.equals((Object)"region")) {
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
                        f.f = i1.U();
                        continue;
                    }
                    case 1: {
                        f.e = i1.U();
                        continue;
                    }
                    case 0: {
                        f.g = i1.U();
                        continue;
                    }
                }
            }
            f.e(map);
            i1.h();
            return f;
        }
    }
}
