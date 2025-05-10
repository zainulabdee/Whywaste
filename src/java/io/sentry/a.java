package io.sentry;

import io.sentry.transport.d;
import io.sentry.transport.y;
import io.sentry.util.n;
import io.sentry.transport.p;

public final class a implements x0
{
    public p a(final q4 q4, final o2 o2) {
        n.c((Object)q4, "options is required");
        n.c((Object)o2, "requestDetails is required");
        return (p)new d(q4, new y(q4), q4.getTransportGate(), o2);
    }
}
