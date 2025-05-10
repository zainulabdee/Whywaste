package io.sentry;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.ExecutionException;
import io.sentry.util.n;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

final class d0
{
    private static final long g;
    private static final long h;
    private static d0 i;
    private final long a;
    private volatile String b;
    private volatile long c;
    private final AtomicBoolean d;
    private final Callable<InetAddress> e;
    private final ExecutorService f;
    
    static {
        g = TimeUnit.HOURS.toMillis(5L);
        h = TimeUnit.SECONDS.toMillis(1L);
    }
    
    private d0() {
        this(d0.g);
    }
    
    d0(final long n) {
        this(n, (Callable<InetAddress>)new b0());
    }
    
    d0(final long a, final Callable<InetAddress> callable) {
        this.d = new AtomicBoolean(false);
        this.f = Executors.newSingleThreadExecutor((ThreadFactory)new b());
        this.a = a;
        this.e = n.c(callable, "getLocalhost is required");
        this.i();
    }
    
    static d0 e() {
        if (d0.i == null) {
            d0.i = new d0();
        }
        return d0.i;
    }
    
    private void f() {
        this.c = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(1L);
    }
    
    private void i() {
        final c0 c0 = new c0(this);
        try {
            this.f.submit((Callable)c0).get(d0.h, TimeUnit.MILLISECONDS);
        }
        catch (final ExecutionException | TimeoutException | RuntimeException ex) {
            this.f();
        }
        catch (final InterruptedException ex2) {
            Thread.currentThread().interrupt();
            this.f();
        }
    }
    
    void c() {
        this.f.shutdown();
    }
    
    String d() {
        if (this.c < System.currentTimeMillis() && this.d.compareAndSet(false, true)) {
            this.i();
        }
        return this.b;
    }
    
    private static final class b implements ThreadFactory
    {
        private int a;
        
        public Thread newThread(final Runnable runnable) {
            final StringBuilder sb = new StringBuilder();
            sb.append("SentryHostnameCache-");
            sb.append(this.a++);
            final Thread thread = new Thread(runnable, sb.toString());
            thread.setDaemon(true);
            return thread;
        }
    }
}
