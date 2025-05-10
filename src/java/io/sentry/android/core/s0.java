package io.sentry.android.core;

import io.sentry.a0;
import java.io.File;
import io.sentry.util.j;
import io.sentry.l4;
import io.sentry.util.n;
import io.sentry.n0;
import io.sentry.k0;
import android.os.FileObserver;

final class s0 extends FileObserver
{
    private final String a;
    private final k0 b;
    private final n0 c;
    private final long d;
    
    s0(final String a, final k0 k0, final n0 n0, final long d) {
        super(a);
        this.a = a;
        this.b = n.c(k0, "Envelope sender is required.");
        this.c = n.c(n0, "Logger is required.");
        this.d = d;
    }
    
    public void onEvent(final int n, final String s) {
        if (s != null) {
            if (n == 8) {
                this.c.a(l4.DEBUG, "onEvent fired for EnvelopeFileObserver with event type %d on path: %s for file %s.", n, this.a, s);
                final a0 e = j.e(new s0.s0$a(this.d, this.c));
                final k0 b = this.b;
                final StringBuilder sb = new StringBuilder();
                sb.append(this.a);
                sb.append(File.separator);
                sb.append(s);
                b.a(sb.toString(), e);
            }
        }
    }
}
