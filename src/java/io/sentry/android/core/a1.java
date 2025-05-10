package io.sentry.android.core;

import io.sentry.protocol.DebugImage;
import java.util.List;

final class a1 implements t0
{
    private static final a1 a;
    
    static {
        a = new a1();
    }
    
    private a1() {
    }
    
    public static a1 b() {
        return a1.a;
    }
    
    public List<DebugImage> a() {
        return null;
    }
}
