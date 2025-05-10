package io.sentry.android.core;

import io.sentry.util.j;
import io.sentry.e4;
import io.sentry.util.n;
import io.sentry.a1;
import io.sentry.z0;
import io.sentry.n0;
import io.sentry.l4;
import io.sentry.exception.a;
import io.sentry.protocol.i;
import io.sentry.m0;
import io.sentry.q4;
import android.content.Context;
import java.io.Closeable;
import io.sentry.Integration;

public final class AnrIntegration implements Integration, Closeable
{
    private static c g;
    private static final Object h;
    private final Context e;
    private q4 f;
    
    static {
        h = new Object();
    }
    
    public AnrIntegration(final Context e) {
        this.e = e;
    }
    
    private Throwable f(final boolean b, final SentryAndroidOptions sentryAndroidOptions, final ApplicationNotResponding applicationNotResponding) {
        final StringBuilder sb = new StringBuilder();
        sb.append("ANR for at least ");
        sb.append(sentryAndroidOptions.getAnrTimeoutIntervalMillis());
        sb.append(" ms.");
        String s = sb.toString();
        if (b) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Background ");
            sb2.append(s);
            s = sb2.toString();
        }
        final ApplicationNotResponding applicationNotResponding2 = new ApplicationNotResponding(s, applicationNotResponding.a());
        final i i = new i();
        i.j("ANR");
        return (Throwable)new a(i, (Throwable)applicationNotResponding2, applicationNotResponding2.a(), true);
    }
    
    private void h(final m0 m0, final SentryAndroidOptions sentryAndroidOptions) {
        final n0 logger = ((q4)sentryAndroidOptions).getLogger();
        final l4 debug = l4.DEBUG;
        logger.a(debug, "AnrIntegration enabled: %s", new Object[] { sentryAndroidOptions.isAnrEnabled() });
        if (sentryAndroidOptions.isAnrEnabled()) {
            final Object h = AnrIntegration.h;
            synchronized (h) {
                if (AnrIntegration.g == null) {
                    ((q4)sentryAndroidOptions).getLogger().a(debug, "ANR timeout in milliseconds: %d", new Object[] { sentryAndroidOptions.getAnrTimeoutIntervalMillis() });
                    ((Thread)(AnrIntegration.g = new c(sentryAndroidOptions.getAnrTimeoutIntervalMillis(), sentryAndroidOptions.isAnrReportInDebug(), (c$a)new d0(this, m0, sentryAndroidOptions), ((q4)sentryAndroidOptions).getLogger(), this.e))).start();
                    ((q4)sentryAndroidOptions).getLogger().a(debug, "AnrIntegration installed.", new Object[0]);
                    this.c();
                }
            }
        }
    }
    
    public /* synthetic */ void c() {
        z0.a((a1)this);
    }
    
    public void close() {
        final Object h = AnrIntegration.h;
        synchronized (h) {
            final c g = AnrIntegration.g;
            if (g != null) {
                ((Thread)g).interrupt();
                AnrIntegration.g = null;
                final q4 f = this.f;
                if (f != null) {
                    f.getLogger().a(l4.DEBUG, "AnrIntegration removed.", new Object[0]);
                }
            }
        }
    }
    
    public final void d(final m0 m0, final q4 q4) {
        this.f = (q4)n.c((Object)q4, "SentryOptions is required");
        this.h(m0, (SentryAndroidOptions)q4);
    }
    
    void i(final m0 m0, final SentryAndroidOptions sentryAndroidOptions, final ApplicationNotResponding applicationNotResponding) {
        ((q4)sentryAndroidOptions).getLogger().a(l4.INFO, "ANR triggered with message: %s", new Object[] { ((Throwable)applicationNotResponding).getMessage() });
        final boolean equals = Boolean.TRUE.equals((Object)k0.a().b());
        final e4 e4 = new e4(this.f(equals, sentryAndroidOptions, applicationNotResponding));
        e4.y0(l4.ERROR);
        m0.s(e4, j.e((Object)new AnrIntegration.AnrIntegration$a(equals)));
    }
}
