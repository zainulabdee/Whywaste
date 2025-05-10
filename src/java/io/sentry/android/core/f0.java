package io.sentry.android.core;

import java.util.AbstractMap;
import io.sentry.util.j;
import io.sentry.protocol.x;
import io.sentry.protocol.v;
import io.sentry.protocol.i;
import io.sentry.protocol.DebugImage;
import io.sentry.protocol.d;
import java.util.ArrayList;
import io.sentry.c1;
import io.sentry.e$a;
import android.content.pm.PackageInfo;
import io.sentry.protocol.a;
import java.util.Locale;
import io.sentry.hints.b;
import android.os.Build$VERSION;
import io.sentry.protocol.k;
import android.util.DisplayMetrics;
import android.app.ActivityManager$MemoryInfo;
import java.util.Collection;
import java.util.Collections;
import io.sentry.android.core.internal.util.h;
import android.os.Build;
import io.sentry.protocol.e;
import java.util.List;
import io.sentry.protocol.a0;
import io.sentry.d5;
import io.sentry.e4;
import io.sentry.l4;
import io.sentry.protocol.o;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.HashMap;
import java.util.Map;
import io.sentry.cache.w;
import io.sentry.protocol.l;
import io.sentry.cache.n;
import io.sentry.e3;
import io.sentry.q4;
import io.sentry.s4;
import io.sentry.f4;
import android.content.Context;
import io.sentry.c;

public final class f0 implements c
{
    private final Context e;
    private final SentryAndroidOptions f;
    private final l0 g;
    private final f4 h;
    
    public f0(final Context e, final SentryAndroidOptions f, final l0 g) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = new f4(new s4((q4)f));
    }
    
    private void A(final e3 e3) {
        if (e3.J() == null) {
            e3.Y((String)n.v((q4)this.f, "release.json", (Class)String.class));
        }
    }
    
    private void B(final e3 e3) {
        if (e3.K() == null) {
            e3.Z((l)w.D((q4)this.f, "request.json", (Class)l.class));
        }
    }
    
    private void C(final e3 e3) {
        final Map map = (Map)w.D((q4)this.f, "tags.json", (Class)Map.class);
        if (map == null) {
            return;
        }
        if (e3.N() == null) {
            e3.d0((Map)new HashMap(map));
        }
        else {
            for (final Map$Entry map$Entry : map.entrySet()) {
                if (!e3.N().containsKey(map$Entry.getKey())) {
                    e3.c0((String)map$Entry.getKey(), (String)map$Entry.getValue());
                }
            }
        }
    }
    
    private void D(final e3 e3) {
        if (e3.L() == null) {
            e3.a0((o)n.v((q4)this.f, "sdk-version.json", (Class)o.class));
        }
    }
    
    private void E(final e3 e3) {
        try {
            final Map k = m0.k(this.e, ((q4)this.f).getLogger(), this.g);
            if (k != null) {
                for (final Map$Entry map$Entry : k.entrySet()) {
                    e3.c0((String)map$Entry.getKey(), (String)map$Entry.getValue());
                }
            }
        }
        finally {
            final Throwable t;
            ((q4)this.f).getLogger().d(l4.ERROR, "Error getting side loaded info.", t);
        }
    }
    
    private void F(final e4 e4) {
        this.m((e3)e4);
        this.E((e3)e4);
    }
    
    private void G(final e4 e4) {
        final d5 d5 = (d5)w.D((q4)this.f, "trace.json", (Class)d5.class);
        if (((e3)e4).C().e() == null && d5 != null && d5.g() != null && d5.j() != null) {
            ((e3)e4).C().m(d5);
        }
    }
    
    private void H(final e4 e4) {
        final String s = (String)w.D((q4)this.f, "transaction.json", (Class)String.class);
        if (e4.t0() == null) {
            e4.D0(s);
        }
    }
    
    private void I(final e3 e3) {
        if (e3.Q() == null) {
            e3.e0((a0)w.D((q4)this.f, "user.json", (Class)a0.class));
        }
    }
    
    private void a(final e4 e4, final Object o) {
        this.A((e3)e4);
        this.t((e3)e4);
        this.s((e3)e4);
        this.q((e3)e4);
        this.D((e3)e4);
        this.n((e3)e4, o);
        this.y((e3)e4);
    }
    
    private void d(final e4 e4) {
        this.B((e3)e4);
        this.I((e3)e4);
        this.C((e3)e4);
        this.o((e3)e4);
        this.v((e3)e4);
        this.p((e3)e4);
        this.H(e4);
        this.w(e4);
        this.x(e4);
        this.G(e4);
    }
    
    private io.sentry.protocol.w e(final List<io.sentry.protocol.w> list) {
        if (list != null) {
            for (final io.sentry.protocol.w w : list) {
                final String m = w.m();
                if (m != null && m.equals((Object)"main")) {
                    return w;
                }
            }
        }
        return null;
    }
    
    private a0 f() {
        final a0 a0 = new a0();
        a0.q(this.h());
        return a0;
    }
    
    private e g() {
        final e e = new e();
        if (((q4)this.f).isSendDefaultPii()) {
            e.g0(m0.d(this.e, this.g));
        }
        e.c0(Build.MANUFACTURER);
        e.Q(Build.BRAND);
        e.V(m0.f(((q4)this.f).getLogger()));
        e.e0(Build.MODEL);
        e.f0(Build.ID);
        e.M(m0.c(this.g));
        final ActivityManager$MemoryInfo h = m0.h(this.e, ((q4)this.f).getLogger());
        if (h != null) {
            e.d0(this.i(h));
        }
        e.p0(this.g.f());
        final DisplayMetrics e2 = m0.e(this.e, ((q4)this.f).getLogger());
        if (e2 != null) {
            e.o0(Integer.valueOf(e2.widthPixels));
            e.n0(Integer.valueOf(e2.heightPixels));
            e.l0(Float.valueOf(e2.density));
            e.m0(Integer.valueOf(e2.densityDpi));
        }
        if (e.J() == null) {
            e.Y(this.h());
        }
        final List c = io.sentry.android.core.internal.util.h.a().c();
        if (!c.isEmpty()) {
            e.k0(Double.valueOf((double)Collections.max((Collection)c)));
            e.j0(Integer.valueOf(c.size()));
        }
        return e;
    }
    
    private String h() {
        try {
            return u0.a(this.e);
        }
        finally {
            final Throwable t;
            ((q4)this.f).getLogger().d(l4.ERROR, "Error getting installationId.", t);
            return null;
        }
    }
    
    private Long i(final ActivityManager$MemoryInfo activityManager$MemoryInfo) {
        if (this.g.d() >= 16) {
            return activityManager$MemoryInfo.totalMem;
        }
        return Runtime.getRuntime().totalMemory();
    }
    
    private k j() {
        final k k = new k();
        k.j("Android");
        k.m(Build$VERSION.RELEASE);
        k.h(Build.DISPLAY);
        try {
            k.i(m0.g(((q4)this.f).getLogger()));
        }
        finally {
            final Throwable t;
            ((q4)this.f).getLogger().d(l4.ERROR, "Error getting OperatingSystem.", t);
        }
        return k;
    }
    
    private boolean k(final Object o) {
        return o instanceof b && "anr_background".equals((Object)((b)o).e());
    }
    
    private void l(final e3 e3) {
        final k c = e3.C().c();
        e3.C().j(this.j());
        if (c != null) {
            final String g = c.g();
            String string;
            if (g != null && !g.isEmpty()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("os_");
                sb.append(g.trim().toLowerCase(Locale.ROOT));
                string = sb.toString();
            }
            else {
                string = "os_1";
            }
            ((AbstractMap)e3.C()).put((Object)string, (Object)c);
        }
    }
    
    private void m(final e3 e3) {
        if (((q4)this.f).isSendDefaultPii()) {
            if (e3.Q() == null) {
                final a0 a0 = new a0();
                a0.r("{{auto}}");
                e3.e0(a0);
            }
            else if (e3.Q().n() == null) {
                e3.Q().r("{{auto}}");
            }
        }
        final a0 q = e3.Q();
        if (q == null) {
            e3.e0(this.f());
        }
        else if (q.m() == null) {
            q.q(this.h());
        }
    }
    
    private void n(final e3 e3, Object j) {
        a a;
        if ((a = e3.C().a()) == null) {
            a = new a();
        }
        a.m(m0.b(this.e, ((q4)this.f).getLogger()));
        a.p(Boolean.valueOf(this.k(j) ^ true));
        final PackageInfo i = m0.j(this.e, ((q4)this.f).getLogger(), this.g);
        if (i != null) {
            a.l(i.packageName);
        }
        if (e3.J() != null) {
            j = e3.J();
        }
        else {
            j = n.v((q4)this.f, "release.json", (Class)String.class);
        }
        if (j != null) {
            try {
                final String substring = ((String)j).substring(((String)j).indexOf(64) + 1, ((String)j).indexOf(43));
                final String substring2 = ((String)j).substring(((String)j).indexOf(43) + 1);
                a.o(substring);
                a.k(substring2);
            }
            finally {
                ((q4)this.f).getLogger().a(l4.WARNING, "Failed to parse release from scope cache: %s", new Object[] { j });
            }
        }
        e3.C().f(a);
    }
    
    private void o(final e3 e3) {
        final List list = (List)w.E((q4)this.f, "breadcrumbs.json", (Class)List.class, (c1)new e$a());
        if (list == null) {
            return;
        }
        if (e3.B() == null) {
            e3.R((List)new ArrayList((Collection)list));
        }
        else {
            e3.B().addAll((Collection)list);
        }
    }
    
    private void p(final e3 e3) {
        final io.sentry.protocol.c c = (io.sentry.protocol.c)w.D((q4)this.f, "contexts.json", (Class)io.sentry.protocol.c.class);
        if (c == null) {
            return;
        }
        final io.sentry.protocol.c c2 = e3.C();
        for (final Map$Entry map$Entry : ((AbstractMap)new io.sentry.protocol.c(c)).entrySet()) {
            final Object value = map$Entry.getValue();
            if ("trace".equals(map$Entry.getKey()) && value instanceof d5) {
                continue;
            }
            if (((AbstractMap)c2).containsKey(map$Entry.getKey())) {
                continue;
            }
            ((AbstractMap)c2).put((Object)map$Entry.getKey(), value);
        }
    }
    
    private void q(final e3 e3) {
        d d;
        if ((d = e3.D()) == null) {
            d = new d();
        }
        if (d.c() == null) {
            d.d((List)new ArrayList());
        }
        final List c = d.c();
        if (c != null) {
            final String uuid = (String)n.v((q4)this.f, "proguard-uuid.json", (Class)String.class);
            if (uuid != null) {
                final DebugImage debugImage = new DebugImage();
                debugImage.setType("proguard");
                debugImage.setUuid(uuid);
                c.add((Object)debugImage);
            }
            e3.S(d);
        }
    }
    
    private void r(final e3 e3) {
        if (e3.C().b() == null) {
            e3.C().h(this.g());
        }
    }
    
    private void s(final e3 e3) {
        if (e3.E() == null) {
            e3.T((String)n.v((q4)this.f, "dist.json", (Class)String.class));
        }
        if (e3.E() == null) {
            final String s = (String)n.v((q4)this.f, "release.json", (Class)String.class);
            if (s != null) {
                try {
                    e3.T(s.substring(s.indexOf(43) + 1));
                }
                finally {
                    ((q4)this.f).getLogger().a(l4.WARNING, "Failed to parse release from scope cache: %s", new Object[] { s });
                }
            }
        }
    }
    
    private void t(final e3 e3) {
        if (e3.F() == null) {
            String environment = (String)n.v((q4)this.f, "environment.json", (Class)String.class);
            if (environment == null) {
                environment = ((q4)this.f).getEnvironment();
            }
            e3.U(environment);
        }
    }
    
    private void u(final e4 e4, Object e5) {
        final i i = new i();
        if (!((io.sentry.hints.d)e5).a()) {
            i.j("HistoricalAppExitInfo");
        }
        else {
            i.j("AppExitInfo");
        }
        final boolean k = this.k(e5);
        String string = "ANR";
        if (k) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Background ");
            sb.append("ANR");
            string = sb.toString();
        }
        final ApplicationNotResponding applicationNotResponding = new ApplicationNotResponding(string, Thread.currentThread());
        if ((e5 = this.e((List<io.sentry.protocol.w>)e4.s0())) == null) {
            e5 = new io.sentry.protocol.w();
            ((io.sentry.protocol.w)e5).y(new v());
        }
        e4.w0(this.h.e((io.sentry.protocol.w)e5, i, (Throwable)applicationNotResponding));
    }
    
    private void v(final e3 e3) {
        final Map map = (Map)w.D((q4)this.f, "extras.json", (Class)Map.class);
        if (map == null) {
            return;
        }
        if (e3.H() == null) {
            e3.W((Map)new HashMap(map));
        }
        else {
            for (final Map$Entry map$Entry : map.entrySet()) {
                if (!e3.H().containsKey(map$Entry.getKey())) {
                    e3.H().put((Object)map$Entry.getKey(), map$Entry.getValue());
                }
            }
        }
    }
    
    private void w(final e4 e4) {
        final List list = (List)w.D((q4)this.f, "fingerprint.json", (Class)List.class);
        if (e4.p0() == null) {
            e4.x0(list);
        }
    }
    
    private void x(final e4 e4) {
        final l4 l4 = (l4)w.D((q4)this.f, "level.json", (Class)l4.class);
        if (e4.q0() == null) {
            e4.y0(l4);
        }
    }
    
    private void y(final e3 e3) {
        final Map map = (Map)n.v((q4)this.f, "tags.json", (Class)Map.class);
        if (map == null) {
            return;
        }
        if (e3.N() == null) {
            e3.d0((Map)new HashMap(map));
        }
        else {
            for (final Map$Entry map$Entry : map.entrySet()) {
                if (!e3.N().containsKey(map$Entry.getKey())) {
                    e3.c0((String)map$Entry.getKey(), (String)map$Entry.getValue());
                }
            }
        }
    }
    
    private void z(final e3 e3) {
        if (e3.I() == null) {
            e3.X("java");
        }
    }
    
    public e4 c(final e4 e4, final io.sentry.a0 a0) {
        final Object f = j.f(a0);
        if (!(f instanceof io.sentry.hints.d)) {
            ((q4)this.f).getLogger().a(l4.WARNING, "The event is not Backfillable, but has been passed to BackfillingEventProcessor, skipping.", new Object[0]);
            return e4;
        }
        this.u(e4, f);
        this.z((e3)e4);
        this.l((e3)e4);
        this.r((e3)e4);
        if (!((io.sentry.hints.d)f).a()) {
            ((q4)this.f).getLogger().a(l4.DEBUG, "The event is Backfillable, but should not be enriched, skipping.", new Object[0]);
            return e4;
        }
        this.d(e4);
        this.a(e4, f);
        this.F(e4);
        return e4;
    }
}
