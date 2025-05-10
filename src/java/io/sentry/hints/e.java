package io.sentry.hints;

import io.sentry.l4;
import java.util.concurrent.TimeUnit;
import io.sentry.n0;
import java.util.concurrent.CountDownLatch;

public abstract class e implements g, h
{
    private final CountDownLatch a;
    private final long b;
    private final n0 c;
    
    public e(final long b, final n0 c) {
        this.b = b;
        this.a = new CountDownLatch(1);
        this.c = c;
    }
    
    public boolean d() {
        try {
            return this.a.await(this.b, TimeUnit.MILLISECONDS);
        }
        catch (final InterruptedException ex) {
            Thread.currentThread().interrupt();
            this.c.d(l4.ERROR, "Exception while awaiting for flush in BlockingFlushHint", (Throwable)ex);
            return false;
        }
    }
    
    public void f() {
        this.a.countDown();
    }
}
