package io.sentry;

import java.io.Writer;
import io.sentry.vendor.gson.stream.c;

public final class k1 extends c
{
    private final j1 p;
    
    public k1(final Writer writer, final int n) {
        super(writer);
        this.p = new j1(n);
    }
    
    public k1 y(final String s) {
        super.i(s);
        return this;
    }
    
    public k1 z(final n0 n0, final Object o) {
        this.p.a(this, n0, o);
        return this;
    }
}
