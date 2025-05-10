package io.sentry.android.core;

import io.sentry.Integration;
import android.content.Context;

public final class e0
{
    public static Integration a(final Context context, final l0 l0) {
        if (l0.d() >= 30) {
            return (Integration)new AnrV2Integration(context);
        }
        return (Integration)new AnrIntegration(context);
    }
}
