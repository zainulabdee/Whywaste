package io.sentry;

import java.util.ListIterator;
import io.sentry.protocol.x;
import io.sentry.protocol.a0;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Iterator;
import java.util.Collection;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import io.sentry.util.n;
import java.util.concurrent.CopyOnWriteArrayList;
import io.sentry.protocol.c;
import io.sentry.protocol.h;
import java.util.Map;
import io.sentry.protocol.z;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Timer;
import java.util.TimerTask;
import java.util.List;
import io.sentry.protocol.q;

public final class y4 implements v0
{
    private final q a;
    private final c5 b;
    private final List<c5> c;
    private final m0 d;
    private String e;
    private y4.y4$b f;
    private volatile TimerTask g;
    private volatile Timer h;
    private final Object i;
    private final AtomicBoolean j;
    private final d k;
    private z l;
    private final Map<String, h> m;
    private final y0 n;
    private final c o;
    private final s5 p;
    private final r5 q;
    
    y4(final p5 p4, final m0 d, final r5 q, final s5 p5) {
        this.a = new q();
        this.c = (List<c5>)new CopyOnWriteArrayList();
        this.f = y4.y4$b.c;
        this.h = null;
        this.i = new Object();
        this.j = new AtomicBoolean(false);
        this.o = new c();
        io.sentry.util.n.c((Object)p4, "context is required");
        io.sentry.util.n.c((Object)d, "hub is required");
        this.m = (Map<String, h>)new ConcurrentHashMap();
        this.b = new c5(p4, this, d, q.g(), (g5)q);
        this.e = p4.r();
        this.n = p4.q();
        this.d = d;
        this.p = p5;
        this.l = p4.t();
        this.q = q;
        if (p4.p() != null) {
            this.k = p4.p();
        }
        else {
            this.k = new d(d.r().getLogger());
        }
        if (p5 != null && Boolean.TRUE.equals((Object)this.J())) {
            p5.b((v0)this);
        }
        if (q.f() != null) {
            this.h = new Timer(true);
            this.h();
        }
    }
    
    private void B() {
        h5 h5 = this.a();
        if (h5 == null) {
            h5 = io.sentry.h5.OK;
        }
        this.j(h5);
        this.j.set(false);
    }
    
    private boolean I() {
        final ArrayList list = new ArrayList((Collection)this.c);
        if (!((List)list).isEmpty()) {
            final Iterator iterator = ((List)list).iterator();
            while (iterator.hasNext()) {
                if (!((c5)iterator.next()).e()) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private void R() {
        synchronized (this) {
            if (this.k.o()) {
                final AtomicReference atomicReference = new AtomicReference();
                this.d.l((s2)new w4(atomicReference));
                this.k.A((v0)this, (a0)atomicReference.get(), this.d.r(), this.G());
                this.k.a();
            }
        }
    }
    
    private void x() {
        final Object i = this.i;
        synchronized (i) {
            if (this.g != null) {
                this.g.cancel();
                this.j.set(false);
                this.g = null;
            }
        }
    }
    
    private u0 y(final f5 f5, final String s, final String s2, final j3 j3, final y0 obj, final g5 g5) {
        if (this.b.e()) {
            return (u0)z1.s();
        }
        if (!this.n.equals(obj)) {
            return (u0)z1.s();
        }
        io.sentry.util.n.c((Object)f5, "parentSpanId is required");
        io.sentry.util.n.c((Object)s, "operation is required");
        this.x();
        final c5 c5 = new c5(this.b.A(), f5, this, s, this.d, j3, g5, (e5)new v4(this));
        c5.d(s2);
        this.c.add((Object)c5);
        return (u0)c5;
    }
    
    private u0 z(final String s, final String s2, final j3 j3, final y0 obj, final g5 g5) {
        if (this.b.e()) {
            return (u0)z1.s();
        }
        if (!this.n.equals(obj)) {
            return (u0)z1.s();
        }
        if (this.c.size() < this.d.r().getMaxSpans()) {
            return this.b.E(s, s2, j3, obj, g5);
        }
        this.d.r().getLogger().a(l4.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", new Object[] { s, s2 });
        return (u0)z1.s();
    }
    
    public void A(final h5 h5, j3 j3, final boolean b) {
        final j3 l = this.b.l();
        if (j3 == null) {
            j3 = l;
        }
        j3 a = j3;
        if (j3 == null) {
            a = this.d.r().getDateProvider().a();
        }
        for (final c5 c5 : this.c) {
            if (c5.v().a()) {
                h5 k;
                if (h5 != null) {
                    k = h5;
                }
                else {
                    k = this.i().k;
                }
                c5.m(k, a);
            }
        }
        this.f = y4.y4$b.c(h5);
        if (!this.b.e() && (!this.q.j() || this.I())) {
            final s5 p3 = this.p;
            List a2;
            if (p3 != null) {
                a2 = p3.a((v0)this);
            }
            else {
                a2 = null;
            }
            final Boolean true = Boolean.TRUE;
            l2 a3;
            if (true.equals((Object)this.K()) && true.equals((Object)this.J())) {
                a3 = this.d.r().getTransactionProfiler().a((v0)this, a2);
            }
            else {
                a3 = null;
            }
            if (a2 != null) {
                a2.clear();
            }
            for (final c5 c6 : this.c) {
                if (!c6.e()) {
                    c6.D((e5)null);
                    c6.m(h5.DEADLINE_EXCEEDED, a);
                }
            }
            this.b.m(y4.y4$b.a(this.f), a);
            this.d.l((s2)new u4(this));
            final x x = new x(this);
            final q5 h6 = this.q.h();
            if (h6 != null) {
                h6.a((v0)this);
            }
            if (this.h != null) {
                final Object i = this.i;
                synchronized (i) {
                    if (this.h != null) {
                        this.h.cancel();
                        this.h = null;
                    }
                }
            }
            if (b && this.c.isEmpty() && this.q.f() != null) {
                this.d.r().getLogger().a(l4.DEBUG, "Dropping idle transaction %s because it has no child spans", new Object[] { this.e });
                return;
            }
            x.m0().putAll((Map)this.m);
            this.d.m(x, this.c(), (io.sentry.a0)null, a3);
        }
    }
    
    public List<c5> C() {
        return this.c;
    }
    
    public c D() {
        return this.o;
    }
    
    public Map<String, Object> E() {
        return (Map<String, Object>)this.b.s();
    }
    
    c5 F() {
        return this.b;
    }
    
    public o5 G() {
        return this.b.x();
    }
    
    public List<c5> H() {
        return this.c;
    }
    
    public Boolean J() {
        return this.b.B();
    }
    
    public Boolean K() {
        return this.b.C();
    }
    
    u0 P(final f5 f5, final String s, final String s2, final j3 j3, final y0 y0, final g5 g5) {
        return this.y(f5, s, s2, j3, y0, g5);
    }
    
    public u0 Q(final String s, final String s2, final j3 j3, final y0 y0, final g5 g5) {
        return this.z(s, s2, j3, y0, g5);
    }
    
    public h5 a() {
        return this.b.a();
    }
    
    public c5 b() {
        final ArrayList list = new ArrayList((Collection)this.c);
        if (!((List)list).isEmpty()) {
            for (int i = ((List)list).size() - 1; i >= 0; --i) {
                if (!((c5)((List)list).get(i)).e()) {
                    return (c5)((List)list).get(i);
                }
            }
        }
        return null;
    }
    
    public m5 c() {
        if (this.d.r().isTraceSampling()) {
            this.R();
            return this.k.B();
        }
        return null;
    }
    
    public void d(final String s) {
        if (this.b.e()) {
            return;
        }
        this.b.d(s);
    }
    
    public boolean e() {
        return this.b.e();
    }
    
    public q f() {
        return this.a;
    }
    
    public boolean g(final j3 j3) {
        return this.b.g(j3);
    }
    
    public String getDescription() {
        return this.b.getDescription();
    }
    
    public String getName() {
        return this.e;
    }
    
    public void h() {
        final Object i = this.i;
        synchronized (i) {
            this.x();
            if (this.h != null) {
                this.j.set(true);
                this.g = (TimerTask)new y4$a(this);
                try {
                    this.h.schedule(this.g, (long)this.q.f());
                }
                finally {
                    final Throwable t;
                    this.d.r().getLogger().d(l4.WARNING, "Failed to schedule finish timer", t);
                    this.B();
                }
            }
        }
    }
    
    public d5 i() {
        return this.b.i();
    }
    
    public void j(final h5 h5) {
        this.m(h5, null);
    }
    
    public void k(final h5 h5, final boolean b) {
        if (this.e()) {
            return;
        }
        final j3 a = this.d.r().getDateProvider().a();
        final List<c5> c = this.c;
        final ListIterator listIterator = c.listIterator(c.size());
        while (listIterator.hasPrevious()) {
            final c5 c2 = (c5)listIterator.previous();
            c2.D((e5)null);
            c2.m(h5, a);
        }
        this.A(h5, a, b);
    }
    
    public j3 l() {
        return this.b.l();
    }
    
    public void m(final h5 h5, final j3 j3) {
        this.A(h5, j3, true);
    }
    
    public u0 n(final String s, final String s2, final j3 j3, final y0 y0) {
        return this.Q(s, s2, j3, y0, new g5());
    }
    
    public void o() {
        this.j(this.a());
    }
    
    public void p(final String s, final Number n, final q1 q1) {
        if (this.b.e()) {
            return;
        }
        this.m.put((Object)s, (Object)new h(n, q1.apiName()));
    }
    
    public z q() {
        return this.l;
    }
    
    public j3 r() {
        return this.b.r();
    }
}
