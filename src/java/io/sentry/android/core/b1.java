package io.sentry.android.core;

import io.sentry.e4;
import java.util.Map;
import io.sentry.d5;
import io.sentry.protocol.q;
import io.sentry.q1;
import io.sentry.a0;
import java.util.Iterator;
import io.sentry.protocol.t;
import java.util.List;
import io.sentry.util.n;
import io.sentry.x;

final class b1 implements x
{
    private boolean e;
    private final h f;
    private final SentryAndroidOptions g;
    
    b1(final SentryAndroidOptions sentryAndroidOptions, final h h) {
        this.e = false;
        this.g = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f = (h)n.c((Object)h, "ActivityFramesTracker is required");
    }
    
    private boolean a(final List<t> list) {
        for (final t t : list) {
            if (t.b().contentEquals((CharSequence)"app.start.cold") || t.b().contentEquals((CharSequence)"app.start.warm")) {
                return true;
            }
        }
        return false;
    }
    
    public io.sentry.protocol.x b(final io.sentry.protocol.x x, final a0 a0) {
        synchronized (this) {
            if (!this.g.isTracingEnabled()) {
                return x;
            }
            if (!this.e && this.a(x.o0())) {
                final Long b = j0.e().b();
                if (b != null) {
                    final io.sentry.protocol.h h = new io.sentry.protocol.h((Number)(float)b, q1.a.MILLISECOND.apiName());
                    String s;
                    if (j0.e().f()) {
                        s = "app_start_cold";
                    }
                    else {
                        s = "app_start_warm";
                    }
                    x.m0().put((Object)s, (Object)h);
                    this.e = true;
                }
            }
            final q g = x.G();
            final d5 e = x.C().e();
            if (g != null && e != null && e.b().contentEquals((CharSequence)"ui.load")) {
                final Map q = this.f.q(g);
                if (q != null) {
                    x.m0().putAll(q);
                }
            }
            return x;
        }
    }
    
    public e4 c(final e4 e4, final a0 a0) {
        return e4;
    }
}
