package io.sentry.clientreport;

import io.sentry.util.n;

final class c
{
    private final String a;
    private final String b;
    
    c(final String a, final String b) {
        this.a = a;
        this.b = b;
    }
    
    public String a() {
        return this.b;
    }
    
    public String b() {
        return this.a;
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (!(o instanceof c)) {
            return false;
        }
        final c c = (c)o;
        if (!n.a(this.b(), c.b()) || !n.a(this.a(), c.a())) {
            b = false;
        }
        return b;
    }
    
    @Override
    public int hashCode() {
        return n.b(this.b(), this.a());
    }
}
