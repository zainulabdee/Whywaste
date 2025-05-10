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

public final class n implements m1
{
    private String e;
    private Integer f;
    private Integer g;
    private Integer h;
    private Map<String, Object> i;
    
    public void e(final Map<String, Object> i) {
        this.i = i;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("sdk_name").v(this.e);
        }
        if (this.f != null) {
            k1.y("version_major").u((Number)this.f);
        }
        if (this.g != null) {
            k1.y("version_minor").u((Number)this.g);
        }
        if (this.h != null) {
            k1.y("version_patchlevel").u((Number)this.h);
        }
        final Map<String, Object> i = this.i;
        if (i != null) {
            for (final String s : i.keySet()) {
                k1.y(s).z(n0, this.i.get((Object)s));
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<n>
    {
        public n b(final i1 i1, final n0 n0) {
            final n n2 = new n();
            i1.b();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n3 = -1;
                switch (r.hashCode()) {
                    case 1111483790: {
                        if (!r.equals((Object)"version_minor")) {
                            break;
                        }
                        n3 = 3;
                        break;
                    }
                    case 1111241618: {
                        if (!r.equals((Object)"version_major")) {
                            break;
                        }
                        n3 = 2;
                        break;
                    }
                    case 696101379: {
                        if (!r.equals((Object)"version_patchlevel")) {
                            break;
                        }
                        n3 = 1;
                        break;
                    }
                    case 270207856: {
                        if (!r.equals((Object)"sdk_name")) {
                            break;
                        }
                        n3 = 0;
                        break;
                    }
                }
                switch (n3) {
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
                        n2.g = i1.O();
                        continue;
                    }
                    case 2: {
                        n2.f = i1.O();
                        continue;
                    }
                    case 1: {
                        n2.h = i1.O();
                        continue;
                    }
                    case 0: {
                        n2.e = i1.U();
                        continue;
                    }
                }
            }
            i1.h();
            n2.e(map);
            return n2;
        }
    }
}
