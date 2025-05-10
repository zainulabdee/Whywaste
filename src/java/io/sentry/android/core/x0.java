package io.sentry.android.core;

import android.os.Looper;
import android.os.Handler;

final class x0
{
    private final Handler a;
    
    x0() {
        this(Looper.getMainLooper());
    }
    
    x0(final Looper looper) {
        this.a = new Handler(looper);
    }
    
    public Thread a() {
        return this.a.getLooper().getThread();
    }
    
    public void b(final Runnable runnable) {
        this.a.post(runnable);
    }
}
