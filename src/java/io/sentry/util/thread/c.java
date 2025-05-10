package io.sentry.util.thread;

public final class c implements b
{
    private static final long a;
    private static final c b;
    
    static {
        a = Thread.currentThread().getId();
        b = new c();
    }
    
    private c() {
    }
    
    public static c d() {
        return c.b;
    }
    
    public boolean b(final long n) {
        return c.a == n;
    }
}
