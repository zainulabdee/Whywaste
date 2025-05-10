package io.sentry;

import java.util.concurrent.Future;

public interface s0
{
    void a(final long p0);
    
    Future<?> b(final Runnable p0, final long p1);
    
    boolean isClosed();
    
    Future<?> submit(final Runnable p0);
}
