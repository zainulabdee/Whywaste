package io.sentry.util;

public final class d
{
    public static Throwable a(Throwable cause) {
        n.c(cause, "throwable cannot be null");
        while (cause.getCause() != null && cause.getCause() != cause) {
            cause = cause.getCause();
        }
        return cause;
    }
}
