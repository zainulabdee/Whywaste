package io.sentry.cache;

import io.sentry.e;
import io.sentry.p0;
import java.util.Map;
import java.util.Collection;
import io.sentry.l4;
import io.sentry.c1;
import io.sentry.protocol.a0;
import io.sentry.d5;
import io.sentry.q4;
import io.sentry.q0;

public final class w implements q0
{
    private final q4 a;
    
    public w(final q4 a) {
        this.a = a;
    }
    
    public static <T> T D(final q4 q4, final String s, final Class<T> clazz) {
        return E(q4, s, clazz, (io.sentry.c1<Object>)null);
    }
    
    public static <T, R> T E(final q4 q4, final String s, final Class<T> clazz, final c1<R> c1) {
        return (T)c.c(q4, ".scope-cache", s, (Class)clazz, (c1)c1);
    }
    
    private void F(final Runnable runnable) {
        try {
            this.a.getExecutorService().submit((Runnable)new t(this, runnable));
        }
        finally {
            final Throwable t;
            this.a.getLogger().d(l4.ERROR, "Serialization task could not be scheduled", t);
        }
    }
    
    private <T> void G(final T t, final String s) {
        c.d(this.a, (Object)t, ".scope-cache", s);
    }
    
    private void u(final String s) {
        c.a(this.a, ".scope-cache", s);
    }
    
    public void e(final Map<String, String> map) {
        this.F((Runnable)new p(this, (Map)map));
    }
    
    public void g(final d5 d5) {
        this.F((Runnable)new u(this, d5));
    }
    
    public void h(final a0 a0) {
        this.F((Runnable)new r(this, a0));
    }
    
    public void i(final Collection<e> collection) {
        this.F((Runnable)new s(this, (Collection)collection));
    }
    
    public void j(final Map<String, Object> map) {
        this.F((Runnable)new o(this, (Map)map));
    }
    
    public void k(final String s) {
        this.F((Runnable)new v(this, s));
    }
    
    public void l(final io.sentry.protocol.c c) {
        this.F((Runnable)new q(this, c));
    }
}
