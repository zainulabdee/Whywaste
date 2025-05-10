package io.sentry.android.core;

import io.sentry.q4;
import io.sentry.m0;
import io.sentry.l4;
import android.net.ConnectivityManager$NetworkCallback;
import io.sentry.android.core.internal.util.f;
import io.sentry.a1;
import io.sentry.z0;
import io.sentry.util.n;
import io.sentry.n0;
import android.content.Context;
import java.io.Closeable;
import io.sentry.Integration;

public final class NetworkBreadcrumbsIntegration implements Integration, Closeable
{
    private final Context e;
    private final l0 f;
    private final n0 g;
    NetworkBreadcrumbsIntegration.NetworkBreadcrumbsIntegration$b h;
    
    public NetworkBreadcrumbsIntegration(final Context context, final l0 l0, final n0 n0) {
        this.e = (Context)n.c((Object)context, "Context is required");
        this.f = (l0)n.c((Object)l0, "BuildInfoProvider is required");
        this.g = (n0)n.c((Object)n0, "ILogger is required");
    }
    
    public /* synthetic */ void b() {
        z0.a((a1)this);
    }
    
    public void close() {
        final NetworkBreadcrumbsIntegration.NetworkBreadcrumbsIntegration$b h = this.h;
        if (h != null) {
            io.sentry.android.core.internal.util.f.g(this.e, this.g, this.f, (ConnectivityManager$NetworkCallback)h);
            this.g.a(l4.DEBUG, "NetworkBreadcrumbsIntegration remove.", new Object[0]);
        }
        this.h = null;
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
        final n0 g = this.g;
        final l4 debug = l4.DEBUG;
        g.a(debug, "NetworkBreadcrumbsIntegration enabled: %s", new Object[] { sentryAndroidOptions2.isEnableNetworkEventBreadcrumbs() });
        if (sentryAndroidOptions2.isEnableNetworkEventBreadcrumbs()) {
            if (this.f.d() < 21) {
                this.h = null;
                this.g.a(debug, "NetworkBreadcrumbsIntegration requires Android 5+", new Object[0]);
                return;
            }
            final NetworkBreadcrumbsIntegration.NetworkBreadcrumbsIntegration$b h = new NetworkBreadcrumbsIntegration.NetworkBreadcrumbsIntegration$b(m0, this.f);
            this.h = h;
            if (!io.sentry.android.core.internal.util.f.f(this.e, this.g, this.f, (ConnectivityManager$NetworkCallback)h)) {
                this.h = null;
                this.g.a(debug, "NetworkBreadcrumbsIntegration not installed.", new Object[0]);
                return;
            }
            this.g.a(debug, "NetworkBreadcrumbsIntegration installed.", new Object[0]);
            this.b();
        }
    }
}
