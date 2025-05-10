package io.sentry.android.core;

import android.os.FileObserver;
import io.sentry.k0;
import io.sentry.h2;
import io.sentry.util.n;
import io.sentry.m0;
import io.sentry.l4;
import io.sentry.q4;
import io.sentry.a1;
import io.sentry.z0;
import io.sentry.n0;
import java.io.Closeable;
import io.sentry.Integration;

public abstract class EnvelopeFileObserverIntegration implements Integration, Closeable
{
    private s0 e;
    private n0 f;
    
    public static EnvelopeFileObserverIntegration b() {
        return new OutboxEnvelopeFileObserverIntegration(null);
    }
    
    abstract String c(final q4 p0);
    
    public void close() {
        final s0 e = this.e;
        if (e != null) {
            ((FileObserver)e).stopWatching();
            final n0 f = this.f;
            if (f != null) {
                f.a(l4.DEBUG, "EnvelopeFileObserverIntegration removed.", new Object[0]);
            }
        }
    }
    
    public final void d(final m0 m0, final q4 q4) {
        n.c((Object)m0, "Hub is required");
        n.c((Object)q4, "SentryOptions is required");
        this.f = q4.getLogger();
        final String c = this.c(q4);
        if (c == null) {
            this.f.a(l4.WARNING, "Null given as a path to EnvelopeFileObserverIntegration. Nothing will be registered.", new Object[0]);
        }
        else {
            final n0 f = this.f;
            final l4 debug = l4.DEBUG;
            f.a(debug, "Registering EnvelopeFileObserverIntegration for path: %s", new Object[] { c });
            final s0 e = new s0(c, (k0)new h2(m0, q4.getEnvelopeReader(), q4.getSerializer(), this.f, q4.getFlushTimeoutMillis()), this.f, q4.getFlushTimeoutMillis());
            this.e = e;
            try {
                ((FileObserver)e).startWatching();
                this.f.a(debug, "EnvelopeFileObserverIntegration installed.", new Object[0]);
            }
            finally {
                final Throwable t;
                q4.getLogger().d(l4.ERROR, "Failed to initialize EnvelopeFileObserverIntegration.", t);
            }
        }
    }
    
    private static final class OutboxEnvelopeFileObserverIntegration extends EnvelopeFileObserverIntegration
    {
        protected String c(final q4 q4) {
            return q4.getOutboxPath();
        }
    }
}
