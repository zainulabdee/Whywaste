package io.sentry;

import io.sentry.protocol.x;
import io.sentry.protocol.q;

public final class t1 implements m0
{
    private static final t1 b;
    private final q4 a;
    
    static {
        b = new t1();
    }
    
    private t1() {
        this.a = q4.empty();
    }
    
    public static t1 u() {
        return t1.b;
    }
    
    public void a(final String s) {
    }
    
    public void b(final String s, final String s2) {
    }
    
    public void c(final String s) {
    }
    
    public m0 clone() {
        return (m0)t1.b;
    }
    
    public void close() {
    }
    
    public void d(final String s, final String s2) {
    }
    
    public void e(final long n) {
    }
    
    public q g(final l3 l3, final a0 a0) {
        return q.f;
    }
    
    public void h(final io.sentry.protocol.a0 a0) {
    }
    
    public v0 i(final p5 p2, final r5 r5) {
        return (v0)a2.s();
    }
    
    public boolean isEnabled() {
        return false;
    }
    
    public void k(final e e, final a0 a0) {
    }
    
    public void l(final s2 s2) {
    }
    
    public q m(final x x, final m5 m5, final a0 a0, final l2 l2) {
        return q.f;
    }
    
    public void n() {
    }
    
    public void p() {
    }
    
    public void q(final Throwable t, final u0 u0, final String s) {
    }
    
    public q4 r() {
        return this.a;
    }
    
    public q s(final e4 e4, final a0 a0) {
        return q.f;
    }
    
    public void t() {
    }
}
