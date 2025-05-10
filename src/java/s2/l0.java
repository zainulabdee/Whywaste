package s2;

import java.util.concurrent.locks.LockSupport;
import o2.d;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public final class l0 extends x0 implements Runnable
{
    private static volatile Thread _thread;
    private static volatile int debugStatus;
    public static final l0 l;
    private static final long m;
    
    static {
        w0.E(l = new l0(), false, 1, null);
        final TimeUnit milliseconds = TimeUnit.MILLISECONDS;
        Long n;
        try {
            n = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        }
        catch (final SecurityException ex) {
            n = 1000L;
        }
        m = milliseconds.toNanos((long)n);
    }
    
    private l0() {
    }
    
    private final void Z() {
        synchronized (this) {
            if (!this.c0()) {
                return;
            }
            l0.debugStatus = 3;
            this.U();
            this.notifyAll();
        }
    }
    
    private final Thread a0() {
        synchronized (this) {
            Thread thread;
            if ((thread = l0._thread) == null) {
                thread = new Thread((Runnable)this, "kotlinx.coroutines.DefaultExecutor");
                (l0._thread = thread).setDaemon(true);
                thread.start();
            }
            return thread;
        }
    }
    
    private final boolean b0() {
        return l0.debugStatus == 4;
    }
    
    private final boolean c0() {
        final int debugStatus = l0.debugStatus;
        return debugStatus == 2 || debugStatus == 3;
    }
    
    private final boolean d0() {
        synchronized (this) {
            if (this.c0()) {
                return false;
            }
            l0.debugStatus = 1;
            this.notifyAll();
            return true;
        }
    }
    
    private final void e0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }
    
    protected Thread I() {
        Thread thread;
        if ((thread = l0._thread) == null) {
            thread = this.a0();
        }
        return thread;
    }
    
    protected void J(final long n, final a a) {
        this.e0();
    }
    
    @Override
    public void O(final Runnable runnable) {
        if (this.b0()) {
            this.e0();
        }
        super.O(runnable);
    }
    
    public void run() {
        c2.a.c((w0)this);
        c.a();
        try {
            if (!this.d0()) {
                return;
            }
            long n = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long n2 = this.S();
                long n3;
                if (n2 == Long.MAX_VALUE) {
                    c.a();
                    final long nanoTime = System.nanoTime();
                    n3 = n;
                    if (n == Long.MAX_VALUE) {
                        n3 = l0.m + nanoTime;
                    }
                    final long n4 = n3 - nanoTime;
                    if (n4 <= 0L) {
                        return;
                    }
                    n2 = d.d(n2, n4);
                }
                else {
                    n3 = Long.MAX_VALUE;
                }
                n = n3;
                if (n2 > 0L) {
                    if (this.c0()) {
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos((Object)this, n2);
                    n = n3;
                }
            }
        }
        finally {
            l0._thread = null;
            this.Z();
            c.a();
            if (!this.R()) {
                this.I();
            }
        }
    }
    
    @Override
    public void shutdown() {
        l0.debugStatus = 4;
        super.shutdown();
    }
}
