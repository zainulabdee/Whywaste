package io.sentry.android.core.internal.util;

import android.os.SystemClock;
import io.sentry.transport.o;

public final class a implements o
{
    private static final o a;
    
    static {
        a = (o)new a();
    }
    
    private a() {
    }
    
    public static o b() {
        return io.sentry.android.core.internal.util.a.a;
    }
    
    public long a() {
        return SystemClock.uptimeMillis();
    }
}
