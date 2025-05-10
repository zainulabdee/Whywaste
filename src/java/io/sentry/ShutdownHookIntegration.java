package io.sentry;

import io.sentry.util.n;
import java.io.Closeable;

public final class ShutdownHookIntegration implements Integration, Closeable
{
    private final Runtime e;
    private Thread f;
    
    public ShutdownHookIntegration() {
        this(Runtime.getRuntime());
    }
    
    public ShutdownHookIntegration(final Runtime runtime) {
        this.e = (Runtime)n.c((Object)runtime, "Runtime is required");
    }
    
    public /* synthetic */ void c() {
        z0.a((a1)this);
    }
    
    public void close() {
        final Thread f = this.f;
        if (f != null) {
            try {
                this.e.removeShutdownHook(f);
            }
            catch (final IllegalStateException ex) {
                final String message = ((Throwable)ex).getMessage();
                if (message == null || !message.equals((Object)"Shutdown in progress")) {
                    throw ex;
                }
            }
        }
    }
    
    public void d(final m0 m0, final q4 q4) {
        n.c((Object)m0, "Hub is required");
        n.c((Object)q4, "SentryOptions is required");
        if (q4.isEnableShutdownHook()) {
            final Thread f = new Thread((Runnable)new b5(m0, q4));
            this.f = f;
            this.e.addShutdownHook(f);
            q4.getLogger().a(l4.DEBUG, "ShutdownHookIntegration installed.", new Object[0]);
            this.c();
        }
        else {
            q4.getLogger().a(l4.INFO, "enableShutdownHook is disabled.", new Object[0]);
        }
    }
}
