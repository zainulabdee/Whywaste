package io.sentry;

import java.util.HashMap;
import io.sentry.vendor.gson.stream.b;
import java.util.Iterator;
import java.util.Map;
import io.sentry.protocol.q;

public final class u5 implements m1
{
    private final q e;
    private String f;
    private String g;
    private String h;
    private Map<String, Object> i;
    
    public u5(final q e, final String f, final String g, final String h) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public void a(final Map<String, Object> i) {
        this.i = i;
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        k1.y("event_id");
        this.e.serialize(k1, n0);
        if (this.f != null) {
            k1.y("name").v(this.f);
        }
        if (this.g != null) {
            k1.y("email").v(this.g);
        }
        if (this.h != null) {
            k1.y("comments").v(this.h);
        }
        final Map<String, Object> i = this.i;
        if (i != null) {
            for (final String s : i.keySet()) {
                k1.y(s).z(n0, this.i.get((Object)s));
            }
        }
        k1.h();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("UserFeedback{eventId=");
        sb.append((Object)this.e);
        sb.append(", name='");
        sb.append(this.f);
        sb.append('\'');
        sb.append(", email='");
        sb.append(this.g);
        sb.append('\'');
        sb.append(", comments='");
        sb.append(this.h);
        sb.append('\'');
        sb.append('}');
        return sb.toString();
    }
    
    public static final class a implements c1<u5>
    {
        public u5 b(final i1 i1, final n0 n0) {
            i1.b();
            q b = null;
            String u = null;
            Object u2 = null;
            Object o;
            String u3 = (String)(o = u2);
            while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                final String r = i1.r();
                r.hashCode();
                int n2 = -1;
                switch (r.hashCode()) {
                    case 278118624: {
                        if (!r.equals((Object)"event_id")) {
                            break;
                        }
                        n2 = 3;
                        break;
                    }
                    case 96619420: {
                        if (!r.equals((Object)"email")) {
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
                    case -602415628: {
                        if (!r.equals((Object)"comments")) {
                            break;
                        }
                        n2 = 0;
                        break;
                    }
                }
                switch (n2) {
                    default: {
                        Object o2 = o;
                        if (o == null) {
                            o2 = new HashMap();
                        }
                        i1.W(n0, (Map<String, Object>)o2, r);
                        o = o2;
                        continue;
                    }
                    case 3: {
                        b = new q.a().b(i1, n0);
                        continue;
                    }
                    case 2: {
                        u2 = i1.U();
                        continue;
                    }
                    case 1: {
                        u = i1.U();
                        continue;
                    }
                    case 0: {
                        u3 = i1.U();
                        continue;
                    }
                }
            }
            i1.h();
            if (b != null) {
                final u5 u4 = new u5(b, u, (String)u2, u3);
                u4.a((Map<String, Object>)o);
                return u4;
            }
            final IllegalStateException ex = new IllegalStateException("Missing required field \"event_id\"");
            n0.d(l4.ERROR, "Missing required field \"event_id\"", (Throwable)ex);
            throw ex;
        }
    }
}
