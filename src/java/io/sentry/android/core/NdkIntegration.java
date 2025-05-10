package io.sentry.android.core;

import io.sentry.util.n;
import io.sentry.m0;
import io.sentry.n0;
import io.sentry.l4;
import io.sentry.a1;
import io.sentry.z0;
import io.sentry.q4;
import java.io.Closeable;
import io.sentry.Integration;

public final class NdkIntegration implements Integration, Closeable
{
    private final Class<?> e;
    private SentryAndroidOptions f;
    
    public NdkIntegration(final Class<?> e) {
        this.e = e;
    }
    
    private void c(final q4 q4) {
        q4.setEnableNdk(false);
        q4.setEnableScopeSync(false);
    }
    
    public /* synthetic */ void b() {
        z0.a((a1)this);
    }
    
    public void close() {
        final SentryAndroidOptions f = this.f;
        if (f != null && ((q4)f).isEnableNdk()) {
            final Class<?> e = this.e;
            if (e != null) {
                Label_0109: {
                    try {
                        e.getMethod("close", (Class[])new Class[0]).invoke((Object)null, new Object[0]);
                        ((q4)this.f).getLogger().a(l4.DEBUG, "NdkIntegration removed.", new Object[0]);
                        break Label_0109;
                    }
                    catch (final NoSuchMethodException ex) {
                        final Throwable t = (Throwable)ex;
                        final NdkIntegration ndkIntegration = this;
                        final SentryAndroidOptions sentryAndroidOptions = ndkIntegration.f;
                        final n0 n0 = ((q4)sentryAndroidOptions).getLogger();
                        final l4 l4 = io.sentry.l4.ERROR;
                        final String s = "Failed to invoke the SentryNdk.close method.";
                        final Throwable t2 = t;
                        n0.d(l4, s, t2);
                    }
                    finally {
                        final Throwable t3;
                        ((q4)this.f).getLogger().d(l4.ERROR, "Failed to close SentryNdk.", t3);
                        break Label_0109;
                    }
                    try {
                        final NoSuchMethodException ex;
                        final Throwable t = (Throwable)ex;
                        final NdkIntegration ndkIntegration = this;
                        final SentryAndroidOptions sentryAndroidOptions = ndkIntegration.f;
                        final n0 n0 = ((q4)sentryAndroidOptions).getLogger();
                        final l4 l4 = io.sentry.l4.ERROR;
                        final String s = "Failed to invoke the SentryNdk.close method.";
                        final Throwable t2 = t;
                        n0.d(l4, s, t2);
                    }
                    finally {
                        this.c((q4)this.f);
                    }
                }
            }
        }
    }
    
    public final void d(final m0 m0, final q4 q4) {
        n.c((Object)m0, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions;
        if (q4 instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions)q4;
        }
        else {
            sentryAndroidOptions = null;
        }
        final SentryAndroidOptions f = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f = f;
        final boolean enableNdk = ((q4)f).isEnableNdk();
        final n0 logger = ((q4)this.f).getLogger();
        final l4 debug = l4.DEBUG;
        logger.a(debug, "NdkIntegration enabled: %s", new Object[] { enableNdk });
        if (enableNdk && this.e != null) {
            if (((q4)this.f).getCacheDirPath() == null) {
                ((q4)this.f).getLogger().a(l4.ERROR, "No cache dir path is defined in options.", new Object[0]);
                this.c((q4)this.f);
                return;
            }
            try {
                this.e.getMethod("init", SentryAndroidOptions.class).invoke((Object)null, new Object[] { this.f });
                ((q4)this.f).getLogger().a(debug, "NdkIntegration installed.", new Object[0]);
                this.b();
            }
            catch (final NoSuchMethodException ex) {
                this.c((q4)this.f);
                ((q4)this.f).getLogger().d(l4.ERROR, "Failed to invoke the SentryNdk.init method.", (Throwable)ex);
            }
            finally {
                this.c((q4)this.f);
                final Throwable t;
                ((q4)this.f).getLogger().d(l4.ERROR, "Failed to initialize SentryNdk.", t);
            }
        }
        else {
            this.c((q4)this.f);
        }
    }
}
