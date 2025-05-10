package io.sentry;

import java.lang.ref.Reference;
import io.sentry.util.j;
import io.sentry.hints.l;
import io.sentry.protocol.x;
import java.util.Iterator;
import java.io.Closeable;
import io.sentry.util.d;
import io.sentry.util.n;
import java.util.Collections;
import java.util.WeakHashMap;
import java.lang.ref.WeakReference;
import io.sentry.util.o;
import java.util.Map;
import io.sentry.protocol.q;

public final class g0 implements m0
{
    private volatile q a;
    private final q4 b;
    private volatile boolean c;
    private final i5 d;
    private final n5 e;
    private final Map<Throwable, o<WeakReference<u0>, String>> f;
    private final s5 g;
    
    public g0(final q4 q4) {
        this(q4, z(q4));
    }
    
    private g0(final q4 q4, final i5$a i5$a) {
        this(q4, new i5(q4.getLogger(), i5$a));
    }
    
    private g0(final q4 b, final i5 d) {
        this.f = (Map<Throwable, o<WeakReference<u0>, String>>)Collections.synchronizedMap((Map)new WeakHashMap());
        D(b);
        this.b = b;
        this.e = new n5(b);
        this.d = d;
        this.a = q.f;
        this.g = b.getTransactionPerformanceCollector();
        this.c = true;
    }
    
    private v0 A(final p5 p2, final r5 r5) {
        n.c((Object)p2, "transactionContext is required");
        Object o;
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            o = a2.s();
        }
        else if (!this.b.getInstrumenter().equals(p2.q())) {
            this.b.getLogger().a(l4.DEBUG, "Returning no-op for instrumenter %s as the SDK has been configured to use instrumenter %s", new Object[] { p2.q(), this.b.getInstrumenter() });
            o = a2.s();
        }
        else if (!this.b.isTracingEnabled()) {
            this.b.getLogger().a(l4.INFO, "Tracing is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            o = a2.s();
        }
        else {
            r5.e();
            final o5 a = this.e.a(new q2(p2, (h)null));
            ((d5)p2).l(a);
            o = new y4(p2, (m0)this, r5, this.g);
            if (a.c() && a.a()) {
                this.b.getTransactionProfiler().b((v0)o);
            }
        }
        if (r5.i()) {
            this.l((s2)new f0((v0)o));
        }
        return (v0)o;
    }
    
    private static void D(final q4 q4) {
        n.c((Object)q4, "SentryOptions is required.");
        if (q4.getDsn() != null && !q4.getDsn().isEmpty()) {
            return;
        }
        throw new IllegalArgumentException("Hub requires a DSN to be instantiated. Considering using the NoOpHub if no DSN is available.");
    }
    
    private void w(final e4 e4) {
        if (this.b.isTracingEnabled() && e4.O() != null) {
            final o o = (o)this.f.get((Object)io.sentry.util.d.a(e4.O()));
            if (o != null) {
                final WeakReference weakReference = (WeakReference)o.a();
                if (e4.C().e() == null && weakReference != null) {
                    final u0 u0 = (u0)((Reference)weakReference).get();
                    if (u0 != null) {
                        e4.C().m(u0.i());
                    }
                }
                final String s = (String)o.b();
                if (e4.t0() == null && s != null) {
                    e4.D0(s);
                }
            }
        }
    }
    
    private r2 x(final r2 r2, final s2 s2) {
        if (s2 != null) {
            try {
                final r2 r3 = new r2(r2);
                s2.run(r3);
                return r3;
            }
            finally {
                final Throwable t;
                this.b.getLogger().d(l4.ERROR, "Error in the 'ScopeCallback' callback.", t);
            }
        }
        return r2;
    }
    
    private q y(final e4 e4, final a0 a0, final s2 s2) {
        final q f = q.f;
        q c;
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
            c = f;
        }
        else if (e4 == null) {
            this.b.getLogger().a(l4.WARNING, "captureEvent called with null parameter.", new Object[0]);
            c = f;
        }
        else {
            c = f;
            try {
                this.w(e4);
                c = f;
                final i5$a a2 = this.d.a();
                c = f;
                final r2 x = this.x(a2.c(), s2);
                c = f;
                final q a3 = c = a2.a().c(e4, x, a0);
                this.a = a3;
                c = a3;
            }
            finally {
                final n0 logger = this.b.getLogger();
                final l4 error = l4.ERROR;
                final StringBuilder sb = new StringBuilder();
                sb.append("Error while capturing event with id: ");
                sb.append((Object)e4.G());
                final Throwable t;
                logger.d(error, sb.toString(), t);
            }
        }
        return c;
    }
    
    private static i5$a z(final q4 q4) {
        D(q4);
        return new i5$a(q4, (r0)new h3(q4), new r2(q4));
    }
    
    public void a(final String s) {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'removeTag' call is a no-op.", new Object[0]);
        }
        else if (s == null) {
            this.b.getLogger().a(l4.WARNING, "removeTag called with null parameter.", new Object[0]);
        }
        else {
            this.d.a().c().z(s);
        }
    }
    
    public void b(final String s, final String s2) {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'setTag' call is a no-op.", new Object[0]);
        }
        else if (s != null && s2 != null) {
            this.d.a().c().D(s, s2);
        }
        else {
            this.b.getLogger().a(l4.WARNING, "setTag called with null parameter.", new Object[0]);
        }
    }
    
    public void c(final String s) {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'removeExtra' call is a no-op.", new Object[0]);
        }
        else if (s == null) {
            this.b.getLogger().a(l4.WARNING, "removeExtra called with null parameter.", new Object[0]);
        }
        else {
            this.d.a().c().y(s);
        }
    }
    
    public m0 clone() {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Disabled Hub cloned.", new Object[0]);
        }
        return (m0)new g0(this.b, new i5(this.d));
    }
    
    public void close() {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
        }
        else {
            try {
                for (final Integration integration : this.b.getIntegrations()) {
                    if (integration instanceof Closeable) {
                        ((Closeable)integration).close();
                    }
                }
                this.l((s2)new e0());
                this.b.getTransactionProfiler().close();
                this.b.getTransactionPerformanceCollector().close();
                this.b.getExecutorService().a(this.b.getShutdownTimeoutMillis());
                this.d.a().a().close();
            }
            finally {
                final Throwable t;
                this.b.getLogger().d(l4.ERROR, "Error while closing the Hub.", t);
            }
            this.c = false;
        }
    }
    
    public void d(final String s, final String s2) {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'setExtra' call is a no-op.", new Object[0]);
        }
        else if (s != null && s2 != null) {
            this.d.a().c().B(s, s2);
        }
        else {
            this.b.getLogger().a(l4.WARNING, "setExtra called with null parameter.", new Object[0]);
        }
    }
    
    public void e(final long n) {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
        }
        else {
            try {
                this.d.a().a().e(n);
            }
            finally {
                final Throwable t;
                this.b.getLogger().d(l4.ERROR, "Error in the 'client.flush'.", t);
            }
        }
    }
    
    public q g(final l3 l3, final a0 a0) {
        n.c((Object)l3, "SentryEnvelope is required.");
        final q f = q.f;
        q q = null;
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
            q = f;
        }
        else {
            try {
                if (this.d.a().a().g(l3, a0) != null) {}
            }
            finally {
                final Throwable t;
                this.b.getLogger().d(l4.ERROR, "Error while capturing envelope.", t);
                q = f;
            }
        }
        return q;
    }
    
    public void h(final io.sentry.protocol.a0 a0) {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'setUser' call is a no-op.", new Object[0]);
        }
        else {
            this.d.a().c().F(a0);
        }
    }
    
    public v0 i(final p5 p2, final r5 r5) {
        return this.A(p2, r5);
    }
    
    public boolean isEnabled() {
        return this.c;
    }
    
    public void k(final e e, final a0 a0) {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        }
        else if (e == null) {
            this.b.getLogger().a(l4.WARNING, "addBreadcrumb called with null parameter.", new Object[0]);
        }
        else {
            this.d.a().c().a(e, a0);
        }
    }
    
    public void l(final s2 s2) {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
        }
        else {
            try {
                s2.run(this.d.a().c());
            }
            finally {
                final Throwable t;
                this.b.getLogger().d(l4.ERROR, "Error in the 'configureScope' callback.", t);
            }
        }
    }
    
    public q m(x b, final m5 m5, final a0 a0, final l2 l2) {
        n.c((Object)b, "transaction is required");
        final q f = q.f;
        q q;
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            q = f;
        }
        else if (!b.p0()) {
            this.b.getLogger().a(l4.WARNING, "Transaction: %s is not finished and this 'captureTransaction' call is a no-op.", new Object[] { b.G() });
            q = f;
        }
        else if (!Boolean.TRUE.equals((Object)b.q0())) {
            this.b.getLogger().a(l4.DEBUG, "Transaction %s was dropped due to sampling decision.", new Object[] { b.G() });
            this.b.getClientReportRecorder().a(io.sentry.clientreport.e.SAMPLE_RATE, i.Transaction);
            q = f;
        }
        else {
            try {
                final i5$a a2 = this.d.a();
                b = (x)a2.a().b(b, m5, a2.c(), a0, l2);
            }
            finally {
                final n0 logger = this.b.getLogger();
                final l4 error = l4.ERROR;
                final StringBuilder sb = new StringBuilder();
                sb.append("Error while capturing transaction with id: ");
                sb.append((Object)b.G());
                final Throwable t;
                logger.d(error, sb.toString(), t);
                q = f;
            }
        }
        return q;
    }
    
    public void n() {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
        }
        else {
            final i5$a a = this.d.a();
            final a5 g = a.c().g();
            if (g != null) {
                a.a().a(g, j.e((Object)new l()));
            }
        }
    }
    
    public void p() {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
        }
        else {
            final i5$a a = this.d.a();
            final r2$d g = a.c().G();
            if (g != null) {
                if (g.b() != null) {
                    a.a().a(g.b(), j.e((Object)new l()));
                }
                a.a().a(g.a(), j.e((Object)new io.sentry.hints.n()));
            }
            else {
                this.b.getLogger().a(l4.WARNING, "Session could not be started.", new Object[0]);
            }
        }
    }
    
    public void q(Throwable a, final u0 u0, final String s) {
        n.c((Object)a, "throwable is required");
        n.c((Object)u0, "span is required");
        n.c((Object)s, "transactionName is required");
        a = io.sentry.util.d.a(a);
        if (!this.f.containsKey((Object)a)) {
            this.f.put((Object)a, (Object)new o((Object)new WeakReference((Object)u0), (Object)s));
        }
    }
    
    public q4 r() {
        return this.d.a().b();
    }
    
    public q s(final e4 e4, final a0 a0) {
        return this.y(e4, a0, null);
    }
    
    public void t() {
        if (!this.isEnabled()) {
            this.b.getLogger().a(l4.WARNING, "Instance is disabled and this 'clearBreadcrumbs' call is a no-op.", new Object[0]);
        }
        else {
            this.d.a().c().d();
        }
    }
}
