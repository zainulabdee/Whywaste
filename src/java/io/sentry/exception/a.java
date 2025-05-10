package io.sentry.exception;

import io.sentry.util.n;
import io.sentry.protocol.i;

public final class a extends RuntimeException
{
    private final i e;
    private final Throwable f;
    private final Thread g;
    private final boolean h;
    
    public a(final i i, final Throwable t, final Thread thread) {
        this(i, t, thread, false);
    }
    
    public a(final i i, final Throwable t, final Thread thread, final boolean h) {
        this.e = n.c(i, "Mechanism is required.");
        this.f = n.c(t, "Throwable is required.");
        this.g = n.c(thread, "Thread is required.");
        this.h = h;
    }
    
    public i a() {
        return this.e;
    }
    
    public Thread b() {
        return this.g;
    }
    
    public Throwable c() {
        return this.f;
    }
    
    public boolean d() {
        return this.h;
    }
}
