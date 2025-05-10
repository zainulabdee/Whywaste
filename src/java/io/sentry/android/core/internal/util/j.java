package io.sentry.android.core.internal.util;

import io.sentry.protocol.e$b;

public final class j
{
    public static e$b a(final int n) {
        if (n == 1) {
            return e$b.PORTRAIT;
        }
        if (n != 2) {
            return null;
        }
        return e$b.LANDSCAPE;
    }
}
