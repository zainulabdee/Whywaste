package io.sentry;

import io.sentry.protocol.w;
import io.sentry.hints.b;
import java.util.Map$Entry;
import java.util.HashMap;
import java.util.Map;
import io.sentry.protocol.p;
import java.util.Iterator;
import java.util.Collection;
import java.util.List;
import io.sentry.protocol.d;
import io.sentry.protocol.DebugImage;
import java.util.ArrayList;
import io.sentry.util.j;
import io.sentry.hints.f;
import io.sentry.util.n;
import java.io.Closeable;

public final class o1 implements x, Closeable
{
    private final q4 e;
    private final t4 f;
    private final f4 g;
    private volatile d0 h;
    
    public o1(final q4 q4) {
        this.h = null;
        final q4 e = (q4)n.c((Object)q4, "The SentryOptions is required.");
        this.e = e;
        final s4 s4 = new s4(e);
        this.g = new f4(s4);
        this.f = new t4(s4, e);
    }
    
    private void a() {
        if (this.h == null) {
            synchronized (this) {
                if (this.h == null) {
                    this.h = d0.e();
                }
            }
        }
    }
    
    private boolean d(final a0 a0) {
        return j.g(a0, (Class)f.class);
    }
    
    private void f(final e3 e3) {
        if (this.e.isSendDefaultPii()) {
            if (e3.Q() == null) {
                final io.sentry.protocol.a0 a0 = new io.sentry.protocol.a0();
                a0.r("{{auto}}");
                e3.e0(a0);
            }
            else if (e3.Q().n() == null) {
                e3.Q().r("{{auto}}");
            }
        }
    }
    
    private void g(final e3 e3) {
        this.p(e3);
        this.l(e3);
        this.r(e3);
        this.j(e3);
        this.q(e3);
        this.s(e3);
        this.f(e3);
    }
    
    private void h(final e3 e3) {
        this.o(e3);
    }
    
    private void i(final e3 e3) {
        final ArrayList list = new ArrayList();
        if (this.e.getProguardUuid() != null) {
            final DebugImage debugImage = new DebugImage();
            debugImage.setType("proguard");
            debugImage.setUuid(this.e.getProguardUuid());
            ((List)list).add((Object)debugImage);
        }
        for (final String debugId : this.e.getBundleIds()) {
            final DebugImage debugImage2 = new DebugImage();
            debugImage2.setType("jvm");
            debugImage2.setDebugId(debugId);
            ((List)list).add((Object)debugImage2);
        }
        if (!((List)list).isEmpty()) {
            d d;
            if ((d = e3.D()) == null) {
                d = new d();
            }
            if (d.c() == null) {
                d.d((List<DebugImage>)list);
            }
            else {
                d.c().addAll((Collection)list);
            }
            e3.S(d);
        }
    }
    
    private void j(final e3 e3) {
        if (e3.E() == null) {
            e3.T(this.e.getDist());
        }
    }
    
    private void l(final e3 e3) {
        if (e3.F() == null) {
            e3.U(this.e.getEnvironment());
        }
    }
    
    private void m(final e4 e4) {
        final Throwable p = e4.P();
        if (p != null) {
            e4.w0((List<p>)this.g.c(p));
        }
    }
    
    private void n(final e4 e4) {
        final Map a = this.e.getModulesLoader().a();
        if (a == null) {
            return;
        }
        final Map<String, String> r0 = e4.r0();
        if (r0 == null) {
            e4.A0((Map<String, String>)a);
        }
        else {
            r0.putAll(a);
        }
    }
    
    private void o(final e3 e3) {
        if (e3.I() == null) {
            e3.X("java");
        }
    }
    
    private void p(final e3 e3) {
        if (e3.J() == null) {
            e3.Y(this.e.getRelease());
        }
    }
    
    private void q(final e3 e3) {
        if (e3.L() == null) {
            e3.a0(this.e.getSdkVersion());
        }
    }
    
    private void r(final e3 e3) {
        if (e3.M() == null) {
            e3.b0(this.e.getServerName());
        }
        if (this.e.isAttachServerName() && e3.M() == null) {
            this.a();
            if (this.h != null) {
                e3.b0(this.h.d());
            }
        }
    }
    
    private void s(final e3 e3) {
        if (e3.N() == null) {
            e3.d0((Map)new HashMap(this.e.getTags()));
        }
        else {
            for (final Map$Entry map$Entry : this.e.getTags().entrySet()) {
                if (!e3.N().containsKey(map$Entry.getKey())) {
                    e3.c0((String)map$Entry.getKey(), (String)map$Entry.getValue());
                }
            }
        }
    }
    
    private void t(final e4 e4, final a0 a0) {
        if (e4.s0() == null) {
            final List list = null;
            List list2 = null;
            final List<p> o0 = e4.o0();
            List list3 = list;
            if (o0 != null) {
                list3 = list;
                if (!o0.isEmpty()) {
                    final Iterator iterator = o0.iterator();
                    while (true) {
                        list3 = list2;
                        if (!iterator.hasNext()) {
                            break;
                        }
                        final p p2 = (p)iterator.next();
                        if (p2.g() == null || p2.h() == null) {
                            continue;
                        }
                        Object o2;
                        if ((o2 = list2) == null) {
                            o2 = new ArrayList();
                        }
                        ((List)o2).add((Object)p2.h());
                        list2 = (List)o2;
                    }
                }
            }
            if (!this.e.isAttachThreads() && !j.g(a0, (Class)b.class)) {
                if (this.e.isAttachStacktrace() && (o0 == null || o0.isEmpty()) && !this.d(a0)) {
                    e4.B0((List<w>)this.f.a());
                }
            }
            else {
                final Object f = j.f(a0);
                boolean c = false;
                if (f instanceof b) {
                    c = ((b)f).c();
                }
                e4.B0((List<w>)this.f.b(list3, c));
            }
        }
    }
    
    private boolean u(final e3 e3, final a0 a0) {
        if (j.s(a0)) {
            return true;
        }
        this.e.getLogger().a(l4.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", new Object[] { e3.G() });
        return false;
    }
    
    public io.sentry.protocol.x b(final io.sentry.protocol.x x, final a0 a0) {
        this.h(x);
        this.i(x);
        if (this.u(x, a0)) {
            this.g(x);
        }
        return x;
    }
    
    public e4 c(final e4 e4, final a0 a0) {
        this.h(e4);
        this.m(e4);
        this.i(e4);
        this.n(e4);
        if (this.u(e4, a0)) {
            this.g(e4);
            this.t(e4, a0);
        }
        return e4;
    }
    
    public void close() {
        if (this.h != null) {
            this.h.c();
        }
    }
}
