package io.sentry.android.core;

import io.sentry.r1;
import android.os.Debug;
import io.sentry.i2;
import io.sentry.i0;

public class u implements i0
{
    public void a(final i2 i2) {
        i2.b(new r1(System.currentTimeMillis(), Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory(), Debug.getNativeHeapSize() - Debug.getNativeHeapFreeSize()));
    }
    
    public void b() {
    }
}
