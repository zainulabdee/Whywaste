package io.sentry;

public final class i3
{
    private static final i3 d;
    private boolean a;
    private Boolean b;
    private final Object c;
    
    static {
        d = new i3();
    }
    
    private i3() {
        this.c = new Object();
    }
    
    public static i3 a() {
        return i3.d;
    }
    
    public void b(final boolean b) {
        final Object c = this.c;
        synchronized (c) {
            if (!this.a) {
                this.b = b;
                this.a = true;
            }
        }
    }
}
