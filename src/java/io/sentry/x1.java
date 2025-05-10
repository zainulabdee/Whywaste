package io.sentry;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Future;

final class x1 implements s0
{
    private static final x1 a;
    
    static {
        a = new x1();
    }
    
    private x1() {
    }
    
    public static s0 e() {
        return (s0)x1.a;
    }
    
    public void a(final long n) {
    }
    
    public Future<?> b(final Runnable runnable, final long n) {
        return (Future<?>)new FutureTask((Callable)new w1());
    }
    
    public boolean isClosed() {
        return false;
    }
    
    public Future<?> submit(final Runnable runnable) {
        return (Future<?>)new FutureTask((Callable)new v1());
    }
}
