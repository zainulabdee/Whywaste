package io.sentry.util;

public final class a
{
    public static ClassLoader a(final ClassLoader classLoader) {
        ClassLoader systemClassLoader = classLoader;
        if (classLoader == null) {
            systemClassLoader = ClassLoader.getSystemClassLoader();
        }
        return systemClassLoader;
    }
}
