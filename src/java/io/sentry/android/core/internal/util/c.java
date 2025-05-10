package io.sentry.android.core.internal.util;

import io.sentry.l4;
import io.sentry.e;

public class c
{
    public static e a(final String s) {
        final e e = new e();
        e.q("session");
        e.n("state", (Object)s);
        e.m("app.lifecycle");
        e.o(l4.INFO);
        return e;
    }
}
