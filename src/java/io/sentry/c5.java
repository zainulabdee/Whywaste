package io.sentry;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import io.sentry.protocol.q;
import io.sentry.util.n;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c5 implements u0
{
    private j3 a;
    private j3 b;
    private final d5 c;
    private final y4 d;
    private Throwable e;
    private final m0 f;
    private final AtomicBoolean g;
    private final g5 h;
    private e5 i;
    private final Map<String, Object> j;
    
    public c5(final p5 p5, final y4 y4, final m0 m0, final j3 a, final g5 h) {
        this.g = new AtomicBoolean(false);
        this.j = (Map<String, Object>)new ConcurrentHashMap();
        this.c = (d5)n.c((Object)p5, "context is required");
        this.d = (y4)n.c((Object)y4, "sentryTracer is required");
        this.f = (m0)n.c((Object)m0, "hub is required");
        this.i = null;
        if (a != null) {
            this.a = a;
        }
        else {
            this.a = m0.r().getDateProvider().a();
        }
        this.h = h;
    }
    
    c5(final q q, final f5 f5, final y4 y4, final String s, final m0 m0, final j3 a, final g5 h, final e5 i) {
        this.g = new AtomicBoolean(false);
        this.j = (Map<String, Object>)new ConcurrentHashMap();
        this.c = new d5(q, new f5(), s, f5, y4.G());
        this.d = (y4)n.c((Object)y4, "transaction is required");
        this.f = (m0)n.c((Object)m0, "hub is required");
        this.h = h;
        this.i = i;
        if (a != null) {
            this.a = a;
        }
        else {
            this.a = m0.r().getDateProvider().a();
        }
    }
    
    private void F(final j3 a) {
        this.a = a;
    }
    
    private List<c5> t() {
        final ArrayList list = new ArrayList();
        for (final c5 c5 : this.d.H()) {
            if (c5.w() != null && c5.w().equals(this.y())) {
                ((List)list).add((Object)c5);
            }
        }
        return (List<c5>)list;
    }
    
    public q A() {
        return this.c.j();
    }
    
    public Boolean B() {
        return this.c.d();
    }
    
    public Boolean C() {
        return this.c.e();
    }
    
    void D(final e5 i) {
        this.i = i;
    }
    
    public u0 E(final String s, final String s2, final j3 j3, final y0 y0, final g5 g5) {
        if (this.g.get()) {
            return (u0)z1.s();
        }
        return this.d.P(this.c.g(), s, s2, j3, y0, g5);
    }
    
    public h5 a() {
        return this.c.h();
    }
    
    public void d(final String s) {
        if (this.g.get()) {
            return;
        }
        this.c.k(s);
    }
    
    public boolean e() {
        return this.g.get();
    }
    
    public boolean g(final j3 b) {
        if (this.b != null) {
            this.b = b;
            return true;
        }
        return false;
    }
    
    public String getDescription() {
        return this.c.a();
    }
    
    public d5 i() {
        return this.c;
    }
    
    public void j(final h5 h5) {
        this.m(h5, this.f.r().getDateProvider().a());
    }
    
    public j3 l() {
        return this.b;
    }
    
    public void m(final h5 h5, j3 j3) {
        if (!this.g.compareAndSet(false, true)) {
            return;
        }
        this.c.m(h5);
        j3 a;
        if ((a = j3) == null) {
            a = this.f.r().getDateProvider().a();
        }
        this.b = a;
        if (this.h.c() || this.h.b()) {
            List list;
            if (this.d.F().y().equals(this.y())) {
                list = this.d.C();
            }
            else {
                list = this.t();
            }
            final Iterator iterator = list.iterator();
            j3 j4 = null;
            j3 l = null;
            while (iterator.hasNext()) {
                final c5 c5 = (c5)iterator.next();
                Label_0164: {
                    if (j4 != null) {
                        j3 = j4;
                        if (!c5.r().g(j4)) {
                            break Label_0164;
                        }
                    }
                    j3 = c5.r();
                }
                if (l != null) {
                    j4 = j3;
                    if (c5.l() == null) {
                        continue;
                    }
                    j4 = j3;
                    if (!c5.l().f(l)) {
                        continue;
                    }
                }
                l = c5.l();
                j4 = j3;
            }
            if (this.h.c() && j4 != null && this.a.g(j4)) {
                this.F(j4);
            }
            if (this.h.b() && l != null) {
                j3 = this.b;
                if (j3 == null || j3.f(l)) {
                    this.g(l);
                }
            }
        }
        final Throwable e = this.e;
        if (e != null) {
            this.f.q(e, (u0)this, this.d.getName());
        }
        final e5 i = this.i;
        if (i != null) {
            i.a(this);
        }
    }
    
    public void o() {
        this.j(this.c.h());
    }
    
    public void p(final String s, final Number n, final q1 q1) {
        this.d.p(s, n, q1);
    }
    
    public j3 r() {
        return this.a;
    }
    
    public Map<String, Object> s() {
        return this.j;
    }
    
    public String u() {
        return this.c.b();
    }
    
    g5 v() {
        return this.h;
    }
    
    public f5 w() {
        return this.c.c();
    }
    
    public o5 x() {
        return this.c.f();
    }
    
    public f5 y() {
        return this.c.g();
    }
    
    public Map<String, String> z() {
        return this.c.i();
    }
}
