package io.sentry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

final class g4 implements s0
{
    private final ScheduledExecutorService a;
    
    g4() {
        this(Executors.newSingleThreadScheduledExecutor((ThreadFactory)new g4.g4$b((g4$a)null)));
    }
    
    g4(final ScheduledExecutorService a) {
        this.a = a;
    }
    
    public void a(final long n) {
        final ScheduledExecutorService a = this.a;
        synchronized (a) {
            if (!((ExecutorService)this.a).isShutdown()) {
                ((ExecutorService)this.a).shutdown();
                try {
                    if (!((ExecutorService)this.a).awaitTermination(n, TimeUnit.MILLISECONDS)) {
                        ((ExecutorService)this.a).shutdownNow();
                    }
                }
                catch (final InterruptedException ex) {
                    ((ExecutorService)this.a).shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
    
    public Future<?> b(final Runnable runnable, final long n) {
        return (Future<?>)this.a.schedule(runnable, n, TimeUnit.MILLISECONDS);
    }
    
    public boolean isClosed() {
        final ScheduledExecutorService a = this.a;
        synchronized (a) {
            return ((ExecutorService)this.a).isShutdown();
        }
    }
    
    public Future<?> submit(final Runnable runnable) {
        return (Future<?>)((ExecutorService)this.a).submit(runnable);
    }
}
