package io.sentry.util;

import io.sentry.l4;
import io.sentry.n0;

public final class m
{
    public static void a(final Class<?> clazz, final Object o, final n0 n0) {
        final l4 debug = l4.DEBUG;
        String canonicalName;
        if (o != null) {
            canonicalName = o.getClass().getCanonicalName();
        }
        else {
            canonicalName = "Hint";
        }
        n0.a(debug, "%s is not %s", canonicalName, clazz.getCanonicalName());
    }
}
