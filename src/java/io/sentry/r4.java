package io.sentry;

import io.sentry.protocol.s;

final class r4 implements x
{
    private final String e;
    private final String f;
    
    public r4() {
        this(System.getProperty("java.version"), System.getProperty("java.vendor"));
    }
    
    public r4(final String e, final String f) {
        this.e = e;
        this.f = f;
    }
    
    private <T extends e3> T a(final T t) {
        if (t.C().d() == null) {
            t.C().l(new s());
        }
        final s d = t.C().d();
        if (d != null && d.d() == null && d.e() == null) {
            d.f(this.f);
            d.h(this.e);
        }
        return t;
    }
    
    public io.sentry.protocol.x b(final io.sentry.protocol.x x, final a0 a0) {
        return this.a(x);
    }
    
    public e4 c(final e4 e4, final a0 a0) {
        return this.a(e4);
    }
}
