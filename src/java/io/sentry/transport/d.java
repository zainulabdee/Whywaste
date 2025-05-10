package io.sentry.transport;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import io.sentry.clientreport.e;
import io.sentry.UncaughtExceptionHandlerIntegration$a;
import io.sentry.l3;
import java.util.concurrent.TimeUnit;
import io.sentry.util.j$a;
import io.sentry.a0;
import io.sentry.l4;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import io.sentry.hints.j;
import io.sentry.hints.o;
import java.util.concurrent.ThreadPoolExecutor;
import io.sentry.n0;
import io.sentry.o2;
import io.sentry.q4;
import io.sentry.cache.f;

public final class d implements p
{
    private final v e;
    private final f f;
    private final q4 g;
    private final y h;
    private final q i;
    private final n j;
    
    public d(final q4 q4, final y y, final q q5, final o2 o2) {
        this(h(q4.getMaxQueueSize(), q4.getEnvelopeDiskCache(), q4.getLogger()), q4, y, q5, new n(q4, o2, y));
    }
    
    public d(final v v, final q4 q4, final y y, final q q5, final n n) {
        this.e = (v)io.sentry.util.n.c((Object)v, "executor is required");
        this.f = (f)io.sentry.util.n.c((Object)q4.getEnvelopeDiskCache(), "envelopeCache is required");
        this.g = (q4)io.sentry.util.n.c((Object)q4, "options is required");
        this.h = (y)io.sentry.util.n.c((Object)y, "rateLimiter is required");
        this.i = (q)io.sentry.util.n.c((Object)q5, "transportGate is required");
        this.j = (n)io.sentry.util.n.c((Object)n, "httpConnection is required");
    }
    
    private static v h(final int n, final f f, final n0 n2) {
        return new v(1, n, (ThreadFactory)new d.d$b((d$a)null), (RejectedExecutionHandler)new a(f, n2), n2);
    }
    
    private static void m(final a0 a0, final boolean b) {
        io.sentry.util.j.n(a0, (Class)o.class, (j$a)new b());
        io.sentry.util.j.n(a0, (Class)j.class, (j$a)new c(b));
    }
    
    public void close() {
        ((ExecutorService)this.e).shutdown();
        this.g.getLogger().a(l4.DEBUG, "Shutting down", new Object[0]);
        try {
            if (!((ExecutorService)this.e).awaitTermination(1L, TimeUnit.MINUTES)) {
                this.g.getLogger().a(l4.WARNING, "Failed to shutdown the async connection async sender within 1 minute. Trying to force it now.", new Object[0]);
                ((ExecutorService)this.e).shutdownNow();
            }
        }
        catch (final InterruptedException ex) {
            this.g.getLogger().a(l4.DEBUG, "Thread interrupted while closing the connection.", new Object[0]);
            Thread.currentThread().interrupt();
        }
    }
    
    public void e(final long n) {
        this.e.b(n);
    }
    
    public void k(l3 b, final a0 a0) {
        Object o = this.f;
        final boolean g = io.sentry.util.j.g(a0, (Class)io.sentry.hints.f.class);
        boolean b2 = false;
        if (g) {
            o = r.h();
            this.g.getLogger().a(l4.DEBUG, "Captured Envelope is already cached", new Object[0]);
            b2 = true;
        }
        final l3 d = this.h.d(b, a0);
        if (d == null) {
            if (b2) {
                this.f.a(b);
            }
        }
        else {
            b = d;
            if (io.sentry.util.j.g(a0, (Class)UncaughtExceptionHandlerIntegration$a.class)) {
                b = this.g.getClientReportRecorder().b(d);
            }
            final Future submit = this.e.submit((Runnable)new d.d$c(this, b, a0, (f)o));
            if (submit != null && submit.isCancelled()) {
                this.g.getClientReportRecorder().d(io.sentry.clientreport.e.QUEUE_OVERFLOW, b);
            }
        }
    }
}
