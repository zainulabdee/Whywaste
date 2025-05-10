package io.sentry.android.core.internal.util;

import android.os.Process;
import io.sentry.util.n;
import android.content.Context;

public final class m
{
    public static boolean a(final Context context, final String s) {
        n.c(context, "The application context is required.");
        return context.checkPermission(s, Process.myPid(), Process.myUid()) == 0;
    }
}
