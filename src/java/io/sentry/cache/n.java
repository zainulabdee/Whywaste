package io.sentry.cache;

import io.sentry.c1;
import io.sentry.l4;
import java.util.Map;
import io.sentry.protocol.o;
import io.sentry.q4;
import io.sentry.o0;

public final class n implements o0
{
    private final q4 a;
    
    public n(final q4 a) {
        this.a = a;
    }
    
    private void n(final String s) {
        c.a(this.a, ".options-cache", s);
    }
    
    public static <T> T v(final q4 q4, final String s, final Class<T> clazz) {
        return w(q4, s, clazz, (io.sentry.c1<Object>)null);
    }
    
    public static <T, R> T w(final q4 q4, final String s, final Class<T> clazz, final c1<R> c1) {
        return (T)c.c(q4, ".options-cache", s, (Class)clazz, (c1)c1);
    }
    
    private void x(final Runnable runnable) {
        try {
            this.a.getExecutorService().submit((Runnable)new m(this, runnable));
        }
        finally {
            final Throwable t;
            this.a.getLogger().d(l4.ERROR, "Serialization task could not be scheduled", t);
        }
    }
    
    private <T> void y(final T t, final String s) {
        c.d(this.a, (Object)t, ".options-cache", s);
    }
    
    public void e(final Map<String, String> map) {
        this.x((Runnable)new k(this, (Map)map));
    }
    
    public void f(final String s) {
        this.x((Runnable)new l(this, s));
    }
    
    public void g(final String s) {
        this.x((Runnable)new g(this, s));
    }
    
    public void h(final o o) {
        this.x((Runnable)new j(this, o));
    }
    
    public void i(final String s) {
        this.x((Runnable)new i(this, s));
    }
    
    public void j(final String s) {
        this.x((Runnable)new h(this, s));
    }
}
