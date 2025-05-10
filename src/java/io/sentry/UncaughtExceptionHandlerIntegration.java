package io.sentry;

import io.sentry.hints.k;
import io.sentry.hints.e;
import io.sentry.protocol.q;
import io.sentry.util.j;
import io.sentry.exception.a;
import io.sentry.protocol.i;
import io.sentry.util.n;
import java.io.Closeable;

public final class UncaughtExceptionHandlerIntegration implements Integration, Thread$UncaughtExceptionHandler, Closeable
{
    private Thread$UncaughtExceptionHandler e;
    private m0 f;
    private q4 g;
    private boolean h;
    private final t5 i;
    
    public UncaughtExceptionHandlerIntegration() {
        this(t5$a.c());
    }
    
    UncaughtExceptionHandlerIntegration(final t5 t5) {
        this.h = false;
        this.i = (t5)n.c((Object)t5, "threadAdapter is required.");
    }
    
    static Throwable c(final Thread thread, final Throwable t) {
        final i i = new i();
        i.i(Boolean.FALSE);
        i.j("UncaughtExceptionHandler");
        return (Throwable)new io.sentry.exception.a(i, t, thread);
    }
    
    public /* synthetic */ void b() {
        z0.a((a1)this);
    }
    
    public void close() {
        if (this == this.i.b()) {
            this.i.a(this.e);
            final q4 g = this.g;
            if (g != null) {
                g.getLogger().a(l4.DEBUG, "UncaughtExceptionHandlerIntegration removed.", new Object[0]);
            }
        }
    }
    
    public final void d(final m0 m0, final q4 q4) {
        if (this.h) {
            q4.getLogger().a(l4.ERROR, "Attempt to register a UncaughtExceptionHandlerIntegration twice.", new Object[0]);
            return;
        }
        this.h = true;
        this.f = (m0)n.c((Object)m0, "Hub is required");
        final q4 g = (q4)n.c((Object)q4, "SentryOptions is required");
        this.g = g;
        final n0 logger = g.getLogger();
        final l4 debug = l4.DEBUG;
        logger.a(debug, "UncaughtExceptionHandlerIntegration enabled: %s", new Object[] { this.g.isEnableUncaughtExceptionHandler() });
        if (this.g.isEnableUncaughtExceptionHandler()) {
            final Thread$UncaughtExceptionHandler b = this.i.b();
            if (b != null) {
                final n0 logger2 = this.g.getLogger();
                final StringBuilder sb = new StringBuilder();
                sb.append("default UncaughtExceptionHandler class='");
                sb.append(b.getClass().getName());
                sb.append("'");
                logger2.a(debug, sb.toString(), new Object[0]);
                this.e = b;
            }
            this.i.a((Thread$UncaughtExceptionHandler)this);
            this.g.getLogger().a(debug, "UncaughtExceptionHandlerIntegration installed.", new Object[0]);
            this.b();
        }
    }
    
    public void uncaughtException(final Thread thread, final Throwable t) {
        final q4 g = this.g;
        if (g != null && this.f != null) {
            g.getLogger().a(l4.INFO, "Uncaught exception received.", new Object[0]);
            try {
                final a a = new a(this.g.getFlushTimeoutMillis(), this.g.getLogger());
                final e4 e4 = new e4(c(thread, t));
                e4.y0(l4.FATAL);
                if (!this.f.s(e4, j.e((Object)a)).equals((Object)q.f) && !a.d()) {
                    this.g.getLogger().a(l4.WARNING, "Timed out waiting to flush event to disk before crashing. Event: %s", new Object[] { ((e3)e4).G() });
                }
            }
            finally {
                final Throwable t2;
                this.g.getLogger().d(l4.ERROR, "Error sending uncaught exception to Sentry.", t2);
            }
            if (this.e != null) {
                this.g.getLogger().a(l4.INFO, "Invoking inner uncaught exception handler.", new Object[0]);
                this.e.uncaughtException(thread, t);
            }
            else if (this.g.isPrintUncaughtStackTrace()) {
                t.printStackTrace();
            }
        }
    }
    
    public static class a extends e implements k
    {
        public a(final long n, final n0 n2) {
            super(n, n2);
        }
    }
}
