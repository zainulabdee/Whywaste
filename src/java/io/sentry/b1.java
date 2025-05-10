package io.sentry;

public final class b1 implements i0
{
    private final Runtime a;
    
    public b1() {
        this.a = Runtime.getRuntime();
    }
    
    public void a(final i2 i2) {
        i2.b(new r1(System.currentTimeMillis(), this.a.totalMemory() - this.a.freeMemory()));
    }
    
    public void b() {
    }
}
