package io.sentry.android.core;

import io.sentry.hints.a;
import io.sentry.n0;
import io.sentry.hints.b;
import io.sentry.hints.d;
import io.sentry.hints.e;
import io.sentry.util.n;
import io.sentry.q4;
import io.sentry.m0;
import io.sentry.l4;
import io.sentry.a1;
import io.sentry.z0;
import io.sentry.transport.m;
import java.util.concurrent.TimeUnit;
import io.sentry.transport.o;
import android.content.Context;
import java.io.Closeable;
import io.sentry.Integration;

public class AnrV2Integration implements Integration, Closeable
{
    static final long h;
    private final Context e;
    private final o f;
    private SentryAndroidOptions g;
    
    static {
        h = TimeUnit.DAYS.toMillis(91L);
    }
    
    public AnrV2Integration(final Context context) {
        this(context, m.b());
    }
    
    AnrV2Integration(final Context e, final o f) {
        this.e = e;
        this.f = f;
    }
    
    public /* synthetic */ void b() {
        z0.a((a1)this);
    }
    
    public void close() {
        final SentryAndroidOptions g = this.g;
        if (g != null) {
            ((q4)g).getLogger().a(l4.DEBUG, "AnrV2Integration removed.", new Object[0]);
        }
    }
    
    public void d(final m0 m0, final q4 q4) {
        SentryAndroidOptions sentryAndroidOptions;
        if (q4 instanceof SentryAndroidOptions) {
            sentryAndroidOptions = (SentryAndroidOptions)q4;
        }
        else {
            sentryAndroidOptions = null;
        }
        final SentryAndroidOptions g = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.g = g;
        ((q4)g).getLogger().a(l4.DEBUG, "AnrIntegration enabled: %s", new Object[] { this.g.isAnrEnabled() });
        if (((q4)this.g).getCacheDirPath() == null) {
            ((q4)this.g).getLogger().a(l4.INFO, "Cache dir is not set, unable to process ANRs", new Object[0]);
            return;
        }
        if (this.g.isAnrEnabled()) {
            try {
                q4.getExecutorService().submit((Runnable)new AnrV2Integration.AnrV2Integration$a(this.e, m0, this.g, this.f));
            }
            finally {
                final Throwable t;
                q4.getLogger().d(l4.DEBUG, "Failed to start AnrProcessor.", t);
            }
            q4.getLogger().a(l4.DEBUG, "AnrV2Integration installed.", new Object[0]);
            this.b();
        }
    }
    
    public static final class b extends e implements d, io.sentry.hints.b
    {
        private final long d;
        private final boolean e;
        private final boolean f;
        
        public b(final long n, final n0 n2, final long d, final boolean e, final boolean f) {
            super(n, n2);
            this.d = d;
            this.e = e;
            this.f = f;
        }
        
        public boolean a() {
            return this.e;
        }
        
        public Long b() {
            return this.d;
        }
        
        public String e() {
            String s;
            if (this.f) {
                s = "anr_background";
            }
            else {
                s = "anr_foreground";
            }
            return s;
        }
    }
}
