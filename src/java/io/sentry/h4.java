package io.sentry;

import java.time.Instant;

public final class h4 extends j3
{
    private final Instant e;
    
    public h4() {
        this(Instant.now());
    }
    
    public h4(final Instant e) {
        this.e = e;
    }
    
    public long i() {
        return j.m(this.e.getEpochSecond()) + this.e.getNano();
    }
}
