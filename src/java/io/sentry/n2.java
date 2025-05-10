package io.sentry;

import io.sentry.protocol.q;

public final class n2
{
    private q a;
    private f5 b;
    private f5 c;
    private Boolean d;
    private d e;
    
    public n2() {
        this(new q(), new f5(), null, null, null);
    }
    
    public n2(final n2 n2) {
        this(n2.e(), n2.d(), n2.c(), a(n2.b()), n2.f());
    }
    
    public n2(final q a, final f5 b, final f5 c, final d e, final Boolean d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.e = e;
        this.d = d;
    }
    
    private static d a(final d d) {
        if (d != null) {
            return new d(d);
        }
        return null;
    }
    
    public d b() {
        return this.e;
    }
    
    public f5 c() {
        return this.c;
    }
    
    public f5 d() {
        return this.b;
    }
    
    public q e() {
        return this.a;
    }
    
    public Boolean f() {
        return this.d;
    }
    
    public void g(final d e) {
        this.e = e;
    }
    
    public m5 h() {
        final d e = this.e;
        if (e != null) {
            return e.B();
        }
        return null;
    }
}
