package io.sentry.transport;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Future;
import io.sentry.l4;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import io.sentry.n0;
import java.util.concurrent.ThreadPoolExecutor;

final class v extends ThreadPoolExecutor
{
    private final int e;
    private final n0 f;
    private final z g;
    
    public v(final int n, final int e, final ThreadFactory threadFactory, final RejectedExecutionHandler rejectedExecutionHandler, final n0 f) {
        super(n, n, 0L, TimeUnit.MILLISECONDS, (BlockingQueue)new LinkedBlockingQueue(), threadFactory, rejectedExecutionHandler);
        this.g = new z();
        this.e = e;
        this.f = f;
    }
    
    private boolean a() {
        return this.g.b() < this.e;
    }
    
    protected void afterExecute(final Runnable runnable, final Throwable t) {
        try {
            super.afterExecute(runnable, t);
        }
        finally {
            this.g.a();
        }
    }
    
    void b(final long n) {
        try {
            this.g.d(n, TimeUnit.MILLISECONDS);
        }
        catch (final InterruptedException ex) {
            this.f.d(l4.ERROR, "Failed to wait till idle", (Throwable)ex);
            Thread.currentThread().interrupt();
        }
    }
    
    public Future<?> submit(final Runnable runnable) {
        if (this.a()) {
            this.g.c();
            return (Future<?>)super.submit(runnable);
        }
        this.f.a(l4.WARNING, "Submit cancelled", new Object[0]);
        return (Future<?>)new a();
    }
    
    static final class a<T> implements Future<T>
    {
        public boolean cancel(final boolean b) {
            return true;
        }
        
        public T get() {
            throw new CancellationException();
        }
        
        public T get(final long n, final TimeUnit timeUnit) {
            throw new CancellationException();
        }
        
        public boolean isCancelled() {
            return true;
        }
        
        public boolean isDone() {
            return true;
        }
    }
}
