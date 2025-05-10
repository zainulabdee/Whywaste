package io.sentry.android.core;

import io.sentry.android.core.internal.util.f$a;
import io.sentry.android.core.internal.util.f;
import io.sentry.n0;
import android.content.Context;
import io.sentry.transport.q;

final class c0 implements q
{
    private final Context a;
    private final n0 b;
    
    c0(final Context a, final n0 b) {
        this.a = a;
        this.b = b;
    }
    
    public boolean a() {
        return this.b(f.b(this.a, this.b));
    }
    
    boolean b(final f$a f$a) {
        final int n = c0$a.a[((Enum)f$a).ordinal()];
        return n == 1 || n == 2 || n == 3;
    }
}
