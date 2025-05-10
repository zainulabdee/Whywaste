package io.sentry.android.core.internal.util;

import io.sentry.protocol.w;
import android.os.Looper;
import io.sentry.util.thread.a;

public final class b implements io.sentry.util.thread.b
{
    private static final b a;
    
    static {
        a = new b();
    }
    
    private b() {
    }
    
    public static b d() {
        return b.a;
    }
    
    public boolean b(final long n) {
        return Looper.getMainLooper().getThread().getId() == n;
    }
}
