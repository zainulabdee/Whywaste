package io.sentry.transport;

public final class m implements o
{
    private static final o a;
    
    static {
        a = (o)new m();
    }
    
    private m() {
    }
    
    public static o b() {
        return m.a;
    }
    
    public final long a() {
        return System.currentTimeMillis();
    }
}
