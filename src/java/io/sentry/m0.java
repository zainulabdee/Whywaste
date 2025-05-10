package io.sentry;

import io.sentry.protocol.x;
import io.sentry.protocol.q;

public interface m0
{
    void a(final String p0);
    
    void b(final String p0, final String p1);
    
    void c(final String p0);
    
    m0 clone();
    
    void close();
    
    void d(final String p0, final String p1);
    
    void e(final long p0);
    
    void f(final e p0);
    
    q g(final l3 p0, final a0 p1);
    
    void h(final io.sentry.protocol.a0 p0);
    
    v0 i(final p5 p0, final r5 p1);
    
    boolean isEnabled();
    
    q j(final x p0, final m5 p1, final a0 p2);
    
    void k(final e p0, final a0 p1);
    
    void l(final s2 p0);
    
    q m(final x p0, final m5 p1, final a0 p2, final l2 p3);
    
    void n();
    
    q o(final l3 p0);
    
    void p();
    
    void q(final Throwable p0, final u0 p1, final String p2);
    
    q4 r();
    
    q s(final e4 p0, final a0 p1);
    
    void t();
}
