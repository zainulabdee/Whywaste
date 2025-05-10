package io.sentry.android.core;

import io.sentry.util.n;

final class ApplicationNotResponding extends RuntimeException
{
    private final Thread e;
    
    ApplicationNotResponding(final String s, final Thread thread) {
        super(s);
        final Thread e = n.c(thread, "Thread must be provided.");
        this.e = e;
        ((Throwable)this).setStackTrace(e.getStackTrace());
    }
    
    public Thread a() {
        return this.e;
    }
}
