package io.sentry;

import io.sentry.util.r;
import java.util.concurrent.ConcurrentHashMap;
import io.sentry.vendor.gson.stream.b;
import java.util.Iterator;
import java.util.Locale;
import io.sentry.protocol.a0;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Date;

public final class a5 implements m1
{
    private final Date e;
    private Date f;
    private final AtomicInteger g;
    private final String h;
    private final UUID i;
    private Boolean j;
    private a5$b k;
    private Long l;
    private Double m;
    private final String n;
    private String o;
    private final String p;
    private final String q;
    private String r;
    private final Object s;
    private Map<String, Object> t;
    
    public a5(final a5$b k, final Date e, final Date f, final int n, final String h, final UUID i, final Boolean j, final Long l, final Double m, final String n2, final String o, final String p14, final String q, final String r) {
        this.s = new Object();
        this.k = k;
        this.e = e;
        this.f = f;
        this.g = new AtomicInteger(n);
        this.h = h;
        this.i = i;
        this.j = j;
        this.l = l;
        this.m = m;
        this.n = n2;
        this.o = o;
        this.p = p14;
        this.q = q;
        this.r = r;
    }
    
    public a5(final String s, final a0 a0, final String s2, final String s3) {
        final a5$b ok = a5$b.Ok;
        final Date c = io.sentry.j.c();
        final Date c2 = io.sentry.j.c();
        final UUID randomUUID = UUID.randomUUID();
        final Boolean true = Boolean.TRUE;
        String n;
        if (a0 != null) {
            n = a0.n();
        }
        else {
            n = null;
        }
        this(ok, c, c2, 0, s, randomUUID, true, null, null, n, null, s2, s3, null);
    }
    
    private double a(final Date date) {
        return Math.abs(date.getTime() - this.e.getTime()) / 1000.0;
    }
    
    private long i(final Date date) {
        long n2;
        final long n = n2 = date.getTime();
        if (n < 0L) {
            n2 = Math.abs(n);
        }
        return n2;
    }
    
    public a5 b() {
        return new a5(this.k, this.e, this.f, this.g.get(), this.h, this.i, this.j, this.l, this.m, this.n, this.o, this.p, this.q, this.r);
    }
    
    public void c() {
        this.d(io.sentry.j.c());
    }
    
    public void d(Date f) {
        final Object s = this.s;
        synchronized (s) {
            this.j = null;
            if (this.k == a5$b.Ok) {
                this.k = a5$b.Exited;
            }
            if (f != null) {
                this.f = f;
            }
            else {
                this.f = io.sentry.j.c();
            }
            f = this.f;
            if (f != null) {
                this.m = this.a(f);
                this.l = this.i(this.f);
            }
        }
    }
    
    public int e() {
        return this.g.get();
    }
    
    public String f() {
        return this.r;
    }
    
    public Boolean g() {
        return this.j;
    }
    
    public String h() {
        return this.q;
    }
    
    public UUID j() {
        return this.i;
    }
    
    public Date k() {
        final Date e = this.e;
        if (e == null) {
            return null;
        }
        return (Date)e.clone();
    }
    
    public a5$b l() {
        return this.k;
    }
    
    public void m() {
        this.j = Boolean.TRUE;
    }
    
    public void n(final Map<String, Object> t) {
        this.t = t;
    }
    
    public boolean o(final a5$b a5$b, final String s, final boolean b) {
        return this.p(a5$b, s, b, null);
    }
    
    public boolean p(final a5$b k, final String o, final boolean b, final String r) {
        final Object s;
        monitorenter(s = this.s);
        boolean b2 = false;
        final boolean b3 = true;
        Label_0037: {
            if (k == null) {
                break Label_0037;
            }
            try {
                this.k = k;
                b2 = true;
                break Label_0037;
            }
            finally {
                monitorexit(s);
                Date c;
                Block_4_Outer:Block_7_Outer:
                while (true) {
                    Label_0065: {
                        while (true) {
                            Label_0083: {
                                while (true) {
                                    while (true) {
                                        iftrue(Label_0065:)(!b);
                                        this.g.addAndGet(1);
                                        b2 = true;
                                        break Label_0065;
                                        this.r = r;
                                        b2 = b3;
                                        break Label_0083;
                                        this.o = o;
                                        b2 = true;
                                        continue Block_4_Outer;
                                    }
                                    this.j = null;
                                    c = io.sentry.j.c();
                                    iftrue(Label_0118:)((this.f = c) == null);
                                    this.l = this.i(c);
                                    Label_0118: {
                                        monitorexit(s);
                                    }
                                    return b2;
                                    iftrue(Label_0049:)(o == null);
                                    continue Block_7_Outer;
                                }
                            }
                            iftrue(Label_0118:)(!b2);
                            continue;
                        }
                    }
                    iftrue(Label_0083:)(r == null);
                    continue;
                }
            }
        }
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.d();
        if (this.i != null) {
            k1.y("sid").v(this.i.toString());
        }
        if (this.h != null) {
            k1.y("did").v(this.h);
        }
        if (this.j != null) {
            k1.y("init").t(this.j);
        }
        k1.y("started").z(n0, this.e);
        k1.y("status").z(n0, ((Enum)this.k).name().toLowerCase(Locale.ROOT));
        if (this.l != null) {
            k1.y("seq").u((Number)this.l);
        }
        k1.y("errors").s((long)this.g.intValue());
        if (this.m != null) {
            k1.y("duration").u((Number)this.m);
        }
        if (this.f != null) {
            k1.y("timestamp").z(n0, this.f);
        }
        if (this.r != null) {
            k1.y("abnormal_mechanism").z(n0, this.r);
        }
        k1.y("attrs");
        k1.d();
        k1.y("release").z(n0, this.q);
        if (this.p != null) {
            k1.y("environment").z(n0, this.p);
        }
        if (this.n != null) {
            k1.y("ip_address").z(n0, this.n);
        }
        if (this.o != null) {
            k1.y("user_agent").z(n0, this.o);
        }
        k1.h();
        final Map<String, Object> t = this.t;
        if (t != null) {
            for (final String s : t.keySet()) {
                final Object value = this.t.get((Object)s);
                k1.y(s);
                k1.z(n0, value);
            }
        }
        k1.h();
    }
    
    public static final class a implements c1<a5>
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
        
        public a5 b(final i1 i1, n0 n0) {
            i1.b();
            b b = null;
            Object value = null;
            Date date = null;
            Date date2 = null;
            b b2 = null;
            String s = null;
            b b3 = null;
            b b4 = null;
            Long q = null;
            b b5 = null;
            Object u = null;
            Object u2 = null;
            Object u3 = null;
            String u4 = null;
            String s2 = null;
        Label_1048_Outer:
            while (true) {
                Object o = i1.x();
                Label_1354: {
                    if (o != io.sentry.vendor.gson.stream.b.NAME) {
                        break Label_1354;
                    }
                    o = i1.r();
                    ((String)o).hashCode();
                    int n2 = 0;
                    Label_0389: {
                        switch (o) {
                            case "abnormal_mechanism": {
                                n2 = 10;
                                break Label_0389;
                            }
                            case "attrs": {
                                n2 = 9;
                                break Label_0389;
                            }
                            case "timestamp": {
                                n2 = 8;
                                break Label_0389;
                            }
                            case "init": {
                                n2 = 7;
                                break Label_0389;
                            }
                            case "sid": {
                                n2 = 6;
                                break Label_0389;
                            }
                            case "seq": {
                                n2 = 5;
                                break Label_0389;
                            }
                            case "did": {
                                n2 = 4;
                                break Label_0389;
                            }
                            case "status": {
                                n2 = 3;
                                break Label_0389;
                            }
                            case "errors": {
                                n2 = 2;
                                break Label_0389;
                            }
                            case "started": {
                                n2 = 1;
                                break Label_0389;
                            }
                            case "duration": {
                                n2 = 0;
                                break Label_0389;
                            }
                            default:
                                break;
                        }
                        n2 = -1;
                    }
                    Object o2;
                    Date k;
                    Date j;
                    String u5;
                    Object o3;
                    Object l;
                    String u6;
                    Object o4;
                    String r;
                    int n3 = 0;
                    String u7;
                    Object o5;
                    b b6;
                    String b7;
                    Double m;
                    Label_1096_Outer:Label_1327_Outer:Label_0926_Outer:
                    while (true) {
                        Label_1282: {
                            switch (n2) {
                                default: {
                                    o2 = b2;
                                    if (b2 == null) {
                                        o2 = new ConcurrentHashMap();
                                    }
                                    i1.W(n0, (Map<String, Object>)o2, (String)o);
                                    o = b;
                                    k = date;
                                    j = date2;
                                    u5 = s;
                                    o3 = b3;
                                    l = b4;
                                    u6 = s2;
                                    break Label_1048;
                                }
                                case 10: {
                                    u6 = i1.U();
                                    o = b;
                                    k = date;
                                    j = date2;
                                    o2 = b2;
                                    u5 = s;
                                    o3 = b3;
                                    l = b4;
                                    break Label_1048;
                                }
                                case 9: {
                                    i1.b();
                                    o4 = u2;
                                    u2 = u;
                                    u = o4;
                                    while (i1.x() == io.sentry.vendor.gson.stream.b.NAME) {
                                        r = i1.r();
                                        r.hashCode();
                                        Label_0702: {
                                            switch (r.hashCode()) {
                                                case 1917799825: {
                                                    if (!r.equals((Object)"user_agent")) {
                                                        break;
                                                    }
                                                    n3 = 3;
                                                    break Label_0702;
                                                }
                                                case 1480014044: {
                                                    if (!r.equals((Object)"ip_address")) {
                                                        break;
                                                    }
                                                    n3 = 2;
                                                    break Label_0702;
                                                }
                                                case 1090594823: {
                                                    if (!r.equals((Object)"release")) {
                                                        break;
                                                    }
                                                    n3 = 1;
                                                    break Label_0702;
                                                }
                                                case -85904877: {
                                                    if (!r.equals((Object)"environment")) {
                                                        break;
                                                    }
                                                    n3 = 0;
                                                    break Label_0702;
                                                }
                                            }
                                            n3 = -1;
                                        }
                                        switch (n3) {
                                            default: {
                                                i1.G();
                                                continue Label_1048_Outer;
                                            }
                                            case 3: {
                                                u = i1.U();
                                                continue Label_1048_Outer;
                                            }
                                            case 2: {
                                                u2 = i1.U();
                                                continue Label_1048_Outer;
                                            }
                                            case 1: {
                                                u4 = i1.U();
                                                continue Label_1048_Outer;
                                            }
                                            case 0: {
                                                u3 = i1.U();
                                                continue Label_1048_Outer;
                                            }
                                        }
                                    }
                                    i1.h();
                                    o = u3;
                                    o2 = b2;
                                    u3 = b3;
                                    b3 = b4;
                                    b2 = (b)o;
                                    break Label_1282;
                                }
                                case 8: {
                                    j = i1.K(n0);
                                    o = b;
                                    k = date;
                                    o2 = b2;
                                    u5 = s;
                                    o3 = b3;
                                    l = b4;
                                    u6 = s2;
                                    break Label_1048;
                                }
                                case 7: {
                                    l = i1.J();
                                    o = b;
                                    k = date;
                                    j = date2;
                                    o2 = b2;
                                    u5 = s;
                                    o3 = b3;
                                    u6 = s2;
                                    break Label_1048;
                                }
                                case 6: {
                                    break;
                                }
                                case 5: {
                                    break Label_1282;
                                }
                                case 4: {
                                    break Label_1282;
                                }
                                case 3: {
                                    break Label_1282;
                                }
                                case 2: {
                                    break Label_1282;
                                }
                                case 1: {
                                    break Label_1282;
                                }
                                case 0: {
                                    break Label_1282;
                                }
                            }
                            try {
                                o = (u7 = i1.U());
                                o3 = UUID.fromString(u7);
                                o = b;
                                k = date;
                                j = date2;
                                o2 = b2;
                                u5 = s;
                                l = b4;
                                u6 = s2;
                                break Label_1048;
                            }
                            catch (IllegalArgumentException o) {
                                o = null;
                            }
                            while (true) {
                                try {
                                    u7 = (String)o;
                                    o3 = UUID.fromString(u7);
                                    o = b;
                                    k = date;
                                    j = date2;
                                    o2 = b2;
                                    u5 = s;
                                    l = b4;
                                    u6 = s2;
                                    b2 = (b)u3;
                                    b4 = (b)u;
                                    s2 = u6;
                                    u = u2;
                                    u2 = b4;
                                    b3 = (b)l;
                                    u3 = o3;
                                    s = u5;
                                    date2 = j;
                                    date = k;
                                    b = (b)o;
                                    b4 = b5;
                                Block_27_Outer:
                                    while (true) {
                                        while (true) {
                                            Block_26: {
                                                while (true) {
                                                    o5 = u3;
                                                    b6 = b3;
                                                    b5 = b4;
                                                    u3 = u;
                                                    o = b2;
                                                    b2 = (b)o2;
                                                    b3 = (b)o5;
                                                    b4 = b6;
                                                    u = u2;
                                                    u2 = u3;
                                                    u3 = o;
                                                    continue Label_1048_Outer;
                                                    b7 = io.sentry.util.r.b(i1.U());
                                                    o = b;
                                                    k = date;
                                                    j = date2;
                                                    o2 = b2;
                                                    u5 = s;
                                                    o3 = b3;
                                                    l = b4;
                                                    u6 = s2;
                                                    iftrue(Label_1048:)(b7 == null);
                                                    Block_25: {
                                                        Block_24: {
                                                            break Block_24;
                                                            iftrue(Label_1449:)(value == null);
                                                            break Block_25;
                                                            k = i1.K(n0);
                                                            o = b;
                                                            j = date2;
                                                            o2 = b2;
                                                            u5 = s;
                                                            o3 = b3;
                                                            l = b4;
                                                            u6 = s2;
                                                            continue Label_1096_Outer;
                                                            Label_1449: {
                                                                throw this.c("status", n0);
                                                            }
                                                            Label_1425:
                                                            throw this.c("release", n0);
                                                        }
                                                        value = a5$b.valueOf(b7);
                                                        o = b;
                                                        k = date;
                                                        j = date2;
                                                        o2 = b2;
                                                        u5 = s;
                                                        o3 = b3;
                                                        l = b4;
                                                        u6 = s2;
                                                        continue Label_1096_Outer;
                                                    }
                                                    iftrue(Label_1441:)(date == null);
                                                    break Block_26;
                                                    m = i1.L();
                                                    b5 = (b)u3;
                                                    o = u2;
                                                    o2 = b2;
                                                    u3 = b3;
                                                    b3 = b4;
                                                    b4 = (b)m;
                                                    u2 = u;
                                                    u = o;
                                                    b2 = b5;
                                                    continue Label_1327_Outer;
                                                }
                                                iftrue(Label_1425:)(u4 == null);
                                                break Block_27_Outer;
                                            }
                                            iftrue(Label_1433:)(b == null);
                                            continue Label_0926_Outer;
                                        }
                                        u5 = i1.U();
                                        u6 = s2;
                                        l = b4;
                                        o3 = b3;
                                        o2 = b2;
                                        j = date2;
                                        k = date;
                                        o = b;
                                        continue Label_1096_Outer;
                                        o = i1.O();
                                        k = date;
                                        j = date2;
                                        o2 = b2;
                                        u5 = s;
                                        o3 = b3;
                                        l = b4;
                                        u6 = s2;
                                        continue Label_1096_Outer;
                                        n0.a(l4.ERROR, "%s sid is not valid.", new Object[] { o });
                                        o = b;
                                        k = date;
                                        j = date2;
                                        o2 = b2;
                                        u5 = s;
                                        o3 = b3;
                                        l = b4;
                                        u6 = s2;
                                        continue Label_1096_Outer;
                                        Label_1433: {
                                            throw this.c("errors", n0);
                                        }
                                        Label_1441:
                                        throw this.c("started", n0);
                                        q = i1.Q();
                                        o = u3;
                                        u3 = u2;
                                        o2 = b2;
                                        o5 = b3;
                                        b6 = b4;
                                        u2 = u;
                                        continue Block_27_Outer;
                                    }
                                    n0 = (n0)new a5((a5$b)value, date, date2, (int)b, s, (UUID)b3, (Boolean)b4, q, (Double)b5, (String)u, (String)u2, (String)u3, u4, s2);
                                    ((a5)n0).n((Map<String, Object>)b2);
                                    i1.h();
                                    return (a5)n0;
                                }
                                catch (final IllegalArgumentException ex) {
                                    continue;
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
