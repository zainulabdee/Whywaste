package io.sentry.android.core;

import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.TimeUnit;
import io.sentry.q4;
import io.sentry.m0;
import io.sentry.a1;
import io.sentry.z0;
import io.sentry.l4;
import io.sentry.t2;
import io.sentry.util.n;
import io.sentry.util.l;
import io.sentry.x2;
import io.sentry.Integration;

final class SendCachedEnvelopeIntegration implements Integration
{
    private final x2 e;
    private final l<Boolean> f;
    
    public SendCachedEnvelopeIntegration(final x2 x2, final l<Boolean> f) {
        this.e = (x2)n.c((Object)x2, "SendFireAndForgetFactory is required");
        this.f = f;
    }
    
    public void d(final m0 m0, final q4 q4) {
        n.c((Object)m0, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions;
        if (q4 instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions)q4;
        }
        else {
            sentryAndroidOptions = null;
        }
        final SentryAndroidOptions sentryAndroidOptions2 = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        if (!this.e.b(q4.getCacheDirPath(), q4.getLogger())) {
            q4.getLogger().a(l4.ERROR, "No cache dir path is defined in options.", new Object[0]);
            return;
        }
        final t2 a = this.e.a(m0, (q4)sentryAndroidOptions2);
        if (a == null) {
            ((q4)sentryAndroidOptions2).getLogger().a(l4.ERROR, "SendFireAndForget factory is null.", new Object[0]);
            return;
        }
        try {
            final Future submit = ((q4)sentryAndroidOptions2).getExecutorService().submit((Runnable)new c1(a, sentryAndroidOptions2));
            if (this.f.a()) {
                ((q4)sentryAndroidOptions2).getLogger().a(l4.DEBUG, "Startup Crash marker exists, blocking flush.", new Object[0]);
                try {
                    submit.get(sentryAndroidOptions2.getStartupCrashFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
                }
                catch (final TimeoutException ex) {
                    ((q4)sentryAndroidOptions2).getLogger().a(l4.DEBUG, "Synchronous send timed out, continuing in the background.", new Object[0]);
                }
            }
            ((q4)sentryAndroidOptions2).getLogger().a(l4.DEBUG, "SendCachedEnvelopeIntegration installed.", new Object[0]);
        }
        catch (final RejectedExecutionException ex2) {
            ((q4)sentryAndroidOptions2).getLogger().d(l4.ERROR, "Failed to call the executor. Cached events will not be sent. Did you call Sentry.close()?", (Throwable)ex2);
        }
        finally {
            final Throwable t;
            ((q4)sentryAndroidOptions2).getLogger().d(l4.ERROR, "Failed to call the executor. Cached events will not be sent", t);
        }
    }
}
