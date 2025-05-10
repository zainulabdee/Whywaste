package io.sentry;

import io.sentry.protocol.x;
import io.sentry.protocol.q;

public final class h0 implements m0
{
    private static final h0 a;
    
    static {
        a = new h0();
    }
    
    private h0() {
    }
    
    public static h0 u() {
        return h0.a;
    }
    
    public void a(final String s) {
        c3.v(s);
    }
    
    public void b(final String s, final String s2) {
        c3.x(s, s2);
    }
    
    public void c(final String s) {
        c3.u(s);
    }
    
    public m0 clone() {
        return c3.m().clone();
    }
    
    public void close() {
        c3.h();
    }
    
    public void d(final String s, final String s2) {
        c3.w(s, s2);
    }
    
    public void e(final long n) {
        c3.l(n);
    }
    
    public q g(final l3 l3, final a0 a0) {
        return c3.m().g(l3, a0);
    }
    
    public void h(final io.sentry.protocol.a0 a0) {
        c3.y(a0);
    }
    
    public v0 i(final p5 p2, final r5 r5) {
        return c3.A(p2, r5);
    }
    
    public boolean isEnabled() {
        return c3.q();
    }
    
    public void k(final e e, final a0 a0) {
        c3.d(e, a0);
    }
    
    public void l(final s2 s2) {
        c3.i(s2);
    }
    
    public q m(final x x, final m5 m5, final a0 a0, final l2 l2) {
        return c3.m().m(x, m5, a0, l2);
    }
    
    public void n() {
        c3.j();
    }
    
    public void p() {
        c3.z();
    }
    
    public void q(final Throwable t, final u0 u0, final String s) {
        c3.m().q(t, u0, s);
    }
    
    public q4 r() {
        return c3.m().r();
    }
    
    public q s(final e4 e4, final a0 a0) {
        return c3.f(e4, a0);
    }
    
    public void t() {
        c3.g();
    }
}
