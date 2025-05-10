package io.sentry;

import io.sentry.util.n;

public final class m implements n0
{
    private final q4 a;
    private final n0 b;
    
    public m(final q4 q4, final n0 b) {
        this.a = (q4)n.c((Object)q4, "SentryOptions is required.");
        this.b = b;
    }
    
    public void a(final l4 l4, final String s, final Object... array) {
        if (this.b != null && this.b(l4)) {
            this.b.a(l4, s, array);
        }
    }
    
    public boolean b(final l4 l4) {
        final l4 diagnosticLevel = this.a.getDiagnosticLevel();
        final boolean b = false;
        if (l4 == null) {
            return false;
        }
        boolean b2 = b;
        if (this.a.isDebug()) {
            b2 = b;
            if (l4.ordinal() >= diagnosticLevel.ordinal()) {
                b2 = true;
            }
        }
        return b2;
    }
    
    public void c(final l4 l4, final Throwable t, final String s, final Object... array) {
        if (this.b != null && this.b(l4)) {
            this.b.c(l4, t, s, array);
        }
    }
    
    public void d(final l4 l4, final String s, final Throwable t) {
        if (this.b != null && this.b(l4)) {
            this.b.d(l4, s, t);
        }
    }
}
