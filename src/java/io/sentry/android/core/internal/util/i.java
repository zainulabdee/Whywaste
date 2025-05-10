package io.sentry.android.core.internal.util;

import io.sentry.transport.o;

public class i
{
    private final long a;
    private final o b;
    private Long c;
    
    public i(final o b, final long a) {
        this.c = null;
        this.b = b;
        this.a = a;
    }
    
    public boolean a() {
        final long a = this.b.a();
        final Long c = this.c;
        if (c != null && c + this.a > a) {
            return true;
        }
        this.c = a;
        return false;
    }
}
