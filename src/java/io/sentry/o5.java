package io.sentry;

public final class o5
{
    private final Boolean a;
    private final Double b;
    private final Boolean c;
    private final Double d;
    
    public o5(final Boolean b) {
        this(b, null);
    }
    
    public o5(final Boolean b, final Double n) {
        this(b, n, Boolean.FALSE, null);
    }
    
    public o5(final Boolean a, final Double b, final Boolean b2, final Double d) {
        this.a = a;
        this.b = b;
        this.c = (a && b2);
        this.d = d;
    }
    
    public Boolean a() {
        return this.c;
    }
    
    public Double b() {
        return this.b;
    }
    
    public Boolean c() {
        return this.a;
    }
}
