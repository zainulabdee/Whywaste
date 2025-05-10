package io.sentry;

public final class r1
{
    final long a;
    final long b;
    final long c;
    
    public r1(final long n, final long n2) {
        this(n, n2, -1L);
    }
    
    public r1(final long a, final long b, final long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public long a() {
        return this.a;
    }
    
    public long b() {
        return this.b;
    }
    
    public long c() {
        return this.c;
    }
}
