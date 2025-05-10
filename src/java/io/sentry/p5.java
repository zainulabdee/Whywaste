package io.sentry;

import io.sentry.util.n;
import io.sentry.protocol.q;
import io.sentry.protocol.z;

public final class p5 extends d5
{
    private static final z s;
    private String n;
    private z o;
    private o5 p;
    private d q;
    private y0 r;
    
    static {
        s = z.CUSTOM;
    }
    
    public p5(final q q, final f5 f5, final f5 f6, final o5 p5, final d q2) {
        super(q, f5, "default", f6, (o5)null);
        this.r = y0.SENTRY;
        this.n = "<unlabeled transaction>";
        this.p = p5;
        this.o = p5.s;
        this.q = q2;
    }
    
    public p5(final String s, final z z, final String s2) {
        this(s, z, s2, null);
    }
    
    public p5(final String s, final z o, final String s2, final o5 o2) {
        super(s2);
        this.r = y0.SENTRY;
        this.n = (String)io.sentry.util.n.c((Object)s, "name is required");
        this.o = o;
        this.l(o2);
    }
    
    public static p5 o(final n2 n2) {
        final Boolean f = n2.f();
        o5 o5;
        if (f == null) {
            o5 = null;
        }
        else {
            o5 = new o5(f);
        }
        final d b = n2.b();
        if (b != null) {
            b.a();
            final Double g = b.g();
            final Boolean value = f != null && f;
            if (g != null) {
                o5 = new o5(value, g);
            }
            else {
                o5 = new o5(value);
            }
        }
        return new p5(n2.e(), n2.d(), n2.c(), o5, b);
    }
    
    public d p() {
        return this.q;
    }
    
    public y0 q() {
        return this.r;
    }
    
    public String r() {
        return this.n;
    }
    
    public o5 s() {
        return this.p;
    }
    
    public z t() {
        return this.o;
    }
}
