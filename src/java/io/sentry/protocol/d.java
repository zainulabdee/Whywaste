package io.sentry.protocol;

import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import io.sentry.i1;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import io.sentry.m1;

public final class d implements m1
{
    private n e;
    private List<DebugImage> f;
    private Map<String, Object> g;
    
    public List<DebugImage> c() {
        return this.f;
    }
    
    public void d(final List<DebugImage> list) {
        Object f;
        if (list != null) {
            f = new ArrayList((Collection)list);
        }
        else {
            f = null;
        }
        this.f = (List<DebugImage>)f;
    }
    
    public void e(final Map<String, Object> g) {
        this.g = g;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.e != null) {
            k1.y("sdk_info").z(n0, this.e);
        }
        if (this.f != null) {
            k1.y("images").z(n0, this.f);
        }
        final Map<String, Object> g = this.g;
        if (g != null) {
            for (final String s : g.keySet()) {
                k1.y(s).z(n0, this.g.get((Object)s));
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<d>
    {
        public d b(final i1 i1, final n0 n0) {
            final d d = new d();
            i1.b();
            Map<String, Object> map = null;
            while (i1.x() == b.NAME) {
                final String r = i1.r();
                r.hashCode();
                if (!r.equals((Object)"images")) {
                    if (!r.equals((Object)"sdk_info")) {
                        Object o;
                        if ((o = map) == null) {
                            o = new HashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                    }
                    else {
                        d.e = i1.T(n0, (io.sentry.c1<n>)new n.a());
                    }
                }
                else {
                    d.f = (List<DebugImage>)i1.P(n0, (io.sentry.c1<Object>)new DebugImage.a());
                }
            }
            i1.h();
            d.e(map);
            return d;
        }
    }
}
