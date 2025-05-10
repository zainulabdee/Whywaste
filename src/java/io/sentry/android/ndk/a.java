package io.sentry.android.ndk;

import io.sentry.l4;
import java.util.Arrays;
import io.sentry.util.n;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.q4;
import io.sentry.protocol.DebugImage;
import java.util.List;
import io.sentry.android.core.t0;

final class a implements t0
{
    private static List<DebugImage> c;
    private static final Object d;
    private final q4 a;
    private final NativeModuleListLoader b;
    
    static {
        d = new Object();
    }
    
    a(final SentryAndroidOptions sentryAndroidOptions, final NativeModuleListLoader nativeModuleListLoader) {
        this.a = (q4)n.c((Object)sentryAndroidOptions, "The SentryAndroidOptions is required.");
        this.b = (NativeModuleListLoader)n.c((Object)nativeModuleListLoader, "The NativeModuleListLoader is required.");
    }
    
    public List<DebugImage> a() {
        final Object d = io.sentry.android.ndk.a.d;
        synchronized (d) {
            if (io.sentry.android.ndk.a.c == null) {
                try {
                    final DebugImage[] a = this.b.a();
                    if (a != null) {
                        io.sentry.android.ndk.a.c = (List<DebugImage>)Arrays.asList((Object[])a);
                        this.a.getLogger().a(l4.DEBUG, "Debug images loaded: %d", new Object[] { io.sentry.android.ndk.a.c.size() });
                    }
                }
                finally {
                    final Throwable t;
                    this.a.getLogger().c(l4.ERROR, t, "Failed to load debug images.", new Object[0]);
                }
            }
            return io.sentry.android.ndk.a.c;
        }
    }
}
