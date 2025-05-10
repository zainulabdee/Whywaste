package io.sentry.clientreport;

import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import io.sentry.i1;
import io.sentry.l4;
import io.sentry.c1;
import java.util.Iterator;
import io.sentry.j;
import io.sentry.n0;
import io.sentry.k1;
import java.util.Map;
import java.util.List;
import java.util.Date;
import io.sentry.m1;

public final class b implements m1
{
    private final Date e;
    private final List<f> f;
    private Map<String, Object> g;
    
    public b(final Date e, final List<f> f) {
        this.e = e;
        this.f = f;
    }
    
    public List<f> a() {
        return this.f;
    }
    
    public void b(final Map<String, Object> g) {
        this.g = g;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("timestamp").v(j.g(this.e));
        k1.y("discarded_events").z(n0, this.f);
        final Map<String, Object> g = this.g;
        if (g != null) {
            for (final String s : g.keySet()) {
                k1.y(s).z(n0, this.g.get((Object)s));
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<b>
    {
        private Exception c(String string, final n0 n0) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Missing required field \"");
            sb.append(string);
            sb.append("\"");
            string = sb.toString();
            final IllegalStateException ex = new IllegalStateException(string);
            n0.d(l4.ERROR, string, (Throwable)ex);
            return (Exception)ex;
        }
        
        public b b(final i1 i1, final n0 n0) {
            final ArrayList list = new ArrayList();
            i1.b();
            Date k = null;
            Map<String, Object> map = null;
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                if (!r.equals((Object)"discarded_events")) {
                    if (!r.equals((Object)"timestamp")) {
                        Object o;
                        if ((o = map) == null) {
                            o = new HashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o, r);
                        map = (Map<String, Object>)o;
                    }
                    else {
                        k = i1.K(n0);
                    }
                }
                else {
                    ((List)list).addAll((Collection)i1.P(n0, (io.sentry.c1<Object>)new f.a()));
                }
            }
            i1.h();
            if (k == null) {
                throw this.c("timestamp", n0);
            }
            if (!((List)list).isEmpty()) {
                final b b = new b(k, (List<f>)list);
                b.b(map);
                return b;
            }
            throw this.c("discarded_events", n0);
        }
    }
}
