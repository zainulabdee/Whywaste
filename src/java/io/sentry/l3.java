package io.sentry;

import java.util.List;
import java.util.ArrayList;
import io.sentry.protocol.o;
import io.sentry.protocol.q;
import io.sentry.util.n;

public final class l3
{
    private final m3 a;
    private final Iterable<c4> b;
    
    public l3(final m3 m3, final Iterable<c4> iterable) {
        this.a = n.c(m3, "SentryEnvelopeHeader is required.");
        this.b = n.c(iterable, "SentryEnvelope items are required.");
    }
    
    public l3(final q q, final o o, final c4 c4) {
        n.c(c4, "SentryEnvelopeItem is required.");
        this.a = new m3(q, o);
        final ArrayList b = new ArrayList(1);
        ((List)b).add((Object)c4);
        this.b = (Iterable<c4>)b;
    }
    
    public static l3 a(final t0 t0, final a5 a5, final o o) {
        n.c(t0, "Serializer is required.");
        n.c(a5, "session is required.");
        return new l3(null, o, c4.u(t0, a5));
    }
    
    public m3 b() {
        return this.a;
    }
    
    public Iterable<c4> c() {
        return this.b;
    }
}
