package io.sentry.transport;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.TimeUnit;

public final class z
{
    private final a a;
    
    public z() {
        this(0);
    }
    
    public z(final int n) {
        if (n >= 0) {
            this.a = new a(n);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("negative initial count '");
        sb.append(n);
        sb.append("' is not allowed");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void a() {
        this.a.d();
    }
    
    public int b() {
        return this.a.e();
    }
    
    public void c() {
        this.a.f();
    }
    
    public boolean d(final long n, final TimeUnit timeUnit) {
        return this.a.tryAcquireSharedNanos(1, timeUnit.toNanos(n));
    }
    
    private static final class a extends AbstractQueuedSynchronizer
    {
        a(final int state) {
            this.setState(state);
        }
        
        private void d() {
            this.releaseShared(1);
        }
        
        private int e() {
            return this.getState();
        }
        
        private void f() {
            int state;
            do {
                state = this.getState();
            } while (!this.compareAndSetState(state, state + 1));
        }
        
        public int tryAcquireShared(int n) {
            if (this.getState() == 0) {
                n = 1;
            }
            else {
                n = -1;
            }
            return n;
        }
        
        public boolean tryReleaseShared(int state) {
            int n;
            boolean b;
            do {
                state = this.getState();
                b = false;
                if (state == 0) {
                    return false;
                }
                n = state - 1;
            } while (!this.compareAndSetState(state, n));
            if (n == 0) {
                b = true;
            }
            return b;
        }
    }
}
