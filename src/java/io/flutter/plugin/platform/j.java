package io.flutter.plugin.platform;

import android.content.Context;
import t1.i;

public abstract class j
{
    private final i<Object> a;
    
    public j(final i<Object> a) {
        this.a = a;
    }
    
    public abstract io.flutter.plugin.platform.i a(final Context p0, final int p1, final Object p2);
    
    public final i<Object> b() {
        return this.a;
    }
}
