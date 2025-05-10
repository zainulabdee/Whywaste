package io.sentry.util;

public final class o<A, B>
{
    private final A a;
    private final B b;
    
    public o(final A a, final B b) {
        this.a = a;
        this.b = b;
    }
    
    public A a() {
        return this.a;
    }
    
    public B b() {
        return this.b;
    }
}
