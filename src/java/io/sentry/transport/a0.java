package io.sentry.transport;

public abstract class a0
{
    private a0() {
    }
    
    public static a0 a() {
        return b(-1);
    }
    
    public static a0 b(final int n) {
        return (a0)new a0.a0$b(n);
    }
    
    public static a0 e() {
        return (a0)a0.a0$c.a;
    }
    
    public abstract int c();
    
    public abstract boolean d();
}
