package io.sentry.android.core;

public final class k0
{
    private static k0 b;
    private Boolean a;
    
    static {
        k0.b = new k0();
    }
    
    private k0() {
        this.a = null;
    }
    
    public static k0 a() {
        return k0.b;
    }
    
    public Boolean b() {
        return this.a;
    }
    
    void c(final boolean b) {
        synchronized (this) {
            this.a = b;
        }
    }
}
