package io.sentry;

import io.sentry.util.n;

public final class y2 implements x2
{
    private final u2 a;
    
    public y2(final u2 u2) {
        this.a = (u2)n.c((Object)u2, "SendFireAndForgetDirPath is required");
    }
    
    public t2 a(final m0 m0, final q4 q4) {
        n.c((Object)m0, "Hub is required");
        n.c((Object)q4, "SentryOptions is required");
        final String a = this.a.a();
        if (a != null && this.b(a, q4.getLogger())) {
            return this.c(new v(m0, q4.getSerializer(), q4.getLogger(), q4.getFlushTimeoutMillis()), a, q4.getLogger());
        }
        q4.getLogger().a(l4.ERROR, "No cache dir path is defined in options.", new Object[0]);
        return null;
    }
    
    public /* synthetic */ boolean b(final String s, final n0 n0) {
        return w2.a((x2)this, s, n0);
    }
    
    public /* synthetic */ t2 c(final o o, final String s, final n0 n0) {
        return w2.b((x2)this, o, s, n0);
    }
}
