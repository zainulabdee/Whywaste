package io.sentry.android.core;

import io.sentry.n0;
import io.sentry.android.core.internal.util.m;
import io.sentry.q4;
import io.sentry.m0;
import io.sentry.l4;
import android.telephony.PhoneStateListener;
import io.sentry.a1;
import io.sentry.z0;
import io.sentry.util.n;
import android.telephony.TelephonyManager;
import android.content.Context;
import java.io.Closeable;
import io.sentry.Integration;

public final class PhoneStateBreadcrumbsIntegration implements Integration, Closeable
{
    private final Context e;
    private SentryAndroidOptions f;
    PhoneStateBreadcrumbsIntegration.PhoneStateBreadcrumbsIntegration$a g;
    private TelephonyManager h;
    
    public PhoneStateBreadcrumbsIntegration(final Context context) {
        this.e = (Context)n.c((Object)context, "Context is required");
    }
    
    public /* synthetic */ void b() {
        z0.a((a1)this);
    }
    
    public void close() {
        final TelephonyManager h = this.h;
        if (h != null) {
            final PhoneStateBreadcrumbsIntegration.PhoneStateBreadcrumbsIntegration$a g = this.g;
            if (g != null) {
                h.listen((PhoneStateListener)g, 0);
                this.g = null;
                final SentryAndroidOptions f = this.f;
                if (f != null) {
                    ((q4)f).getLogger().a(l4.DEBUG, "PhoneStateBreadcrumbsIntegration removed.", new Object[0]);
                }
            }
        }
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
        final SentryAndroidOptions f = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f = f;
        final n0 logger = ((q4)f).getLogger();
        final l4 debug = l4.DEBUG;
        logger.a(debug, "enableSystemEventBreadcrumbs enabled: %s", new Object[] { this.f.isEnableSystemEventBreadcrumbs() });
        if (this.f.isEnableSystemEventBreadcrumbs() && m.a(this.e, "android.permission.READ_PHONE_STATE")) {
            if ((this.h = (TelephonyManager)this.e.getSystemService("phone")) != null) {
                try {
                    final PhoneStateBreadcrumbsIntegration.PhoneStateBreadcrumbsIntegration$a g = new PhoneStateBreadcrumbsIntegration.PhoneStateBreadcrumbsIntegration$a(m0);
                    this.g = g;
                    this.h.listen((PhoneStateListener)g, 32);
                    q4.getLogger().a(debug, "PhoneStateBreadcrumbsIntegration installed.", new Object[0]);
                    this.b();
                }
                finally {
                    final Throwable t;
                    ((q4)this.f).getLogger().c(l4.INFO, t, "TelephonyManager is not available or ready to use.", new Object[0]);
                }
            }
            else {
                ((q4)this.f).getLogger().a(l4.INFO, "TelephonyManager is not available", new Object[0]);
            }
        }
    }
}
