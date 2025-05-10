package io.sentry.android.core;

import android.app.Activity;
import io.sentry.b;
import io.sentry.android.core.internal.util.p;
import io.sentry.util.j;
import io.sentry.l4;
import io.sentry.e4;
import io.sentry.w;
import io.sentry.a0;
import io.sentry.z0;
import io.sentry.android.core.internal.util.a;
import io.sentry.util.n;
import io.sentry.android.core.internal.util.i;
import io.sentry.a1;
import io.sentry.x;

public final class ScreenshotEventProcessor implements x, a1
{
    private final SentryAndroidOptions e;
    private final l0 f;
    private final i g;
    
    public ScreenshotEventProcessor(final SentryAndroidOptions sentryAndroidOptions, final l0 l0) {
        this.e = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f = (l0)n.c((Object)l0, "BuildInfoProvider is required");
        this.g = new i(a.b(), 2000L);
        if (sentryAndroidOptions.isAttachScreenshot()) {
            this.e();
        }
    }
    
    public e4 c(final e4 e4, final a0 a0) {
        if (!e4.v0()) {
            return e4;
        }
        if (!this.e.isAttachScreenshot()) {
            this.e.getLogger().a(l4.DEBUG, "attachScreenshot is disabled.", new Object[0]);
            return e4;
        }
        final Activity b = n0.c().b();
        if (b != null) {
            if (!j.h(a0)) {
                final boolean a2 = this.g.a();
                final SentryAndroidOptions.SentryAndroidOptions$a beforeScreenshotCaptureCallback = this.e.getBeforeScreenshotCaptureCallback();
                if (beforeScreenshotCaptureCallback != null) {
                    if (!beforeScreenshotCaptureCallback.a(e4, a0, a2)) {
                        return e4;
                    }
                }
                else if (a2) {
                    return e4;
                }
                final byte[] d = p.d(b, this.e.getMainThreadChecker(), this.e.getLogger(), this.f);
                if (d == null) {
                    return e4;
                }
                a0.k(io.sentry.b.a(d));
                a0.j("android:activity", (Object)b);
            }
        }
        return e4;
    }
    
    public /* synthetic */ void e() {
        z0.a((a1)this);
    }
}
