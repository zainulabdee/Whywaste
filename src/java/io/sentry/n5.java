package io.sentry;

import java.util.Random;
import io.sentry.util.n;
import java.security.SecureRandom;

final class n5
{
    private static final Double c;
    private final q4 a;
    private final SecureRandom b;
    
    static {
        c = 1.0;
    }
    
    public n5(final q4 q4) {
        this(n.c(q4, "options are required"), new SecureRandom());
    }
    
    n5(final q4 a, final SecureRandom b) {
        this.a = a;
        this.b = b;
    }
    
    private boolean b(final Double n) {
        return n >= ((Random)this.b).nextDouble();
    }
    
    o5 a(final q2 q2) {
        final o5 f = ((d5)q2.a()).f();
        if (f != null) {
            return f;
        }
        final Throwable t;
        Label_0062: {
            if (this.a.getProfilesSampler() != null) {
                try {
                    this.a.getProfilesSampler().a(q2);
                    break Label_0062;
                }
                finally {
                    this.a.getLogger().d(l4.ERROR, "Error in the 'ProfilesSamplerCallback' callback.", t);
                }
            }
            t = null;
        }
        Double profilesSampleRate = (Double)t;
        if (t == null) {
            profilesSampleRate = this.a.getProfilesSampleRate();
        }
        final Boolean value = profilesSampleRate != null && this.b(profilesSampleRate);
        if (this.a.getTracesSampler() != null) {
            Double n = null;
            try {
                this.a.getTracesSampler().a(q2);
            }
            finally {
                final Throwable t2;
                this.a.getLogger().d(l4.ERROR, "Error in the 'TracesSamplerCallback' callback.", t2);
                n = null;
            }
            if (n != null) {
                return new o5(this.b(n), n, value, profilesSampleRate);
            }
        }
        final o5 s = q2.a().s();
        if (s != null) {
            return s;
        }
        final Double tracesSampleRate = this.a.getTracesSampleRate();
        Double c;
        if (Boolean.TRUE.equals((Object)this.a.getEnableTracing())) {
            c = n5.c;
        }
        else {
            c = null;
        }
        Double n2 = tracesSampleRate;
        if (tracesSampleRate == null) {
            n2 = c;
        }
        if (n2 != null) {
            return new o5(this.b(n2), n2, value, profilesSampleRate);
        }
        final Boolean false = Boolean.FALSE;
        return new o5(false, null, false, null);
    }
}
