package io.sentry.config;

import java.io.IOException;
import io.sentry.l4;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.util.Properties;
import io.sentry.util.a;
import io.sentry.n0;

final class b
{
    private final String a;
    private final ClassLoader b;
    private final n0 c;
    
    public b(final n0 n0) {
        this("sentry.properties", b.class.getClassLoader(), n0);
    }
    
    public b(final String a, final ClassLoader classLoader, final n0 c) {
        this.a = a;
        this.b = io.sentry.util.a.a(classLoader);
        this.c = c;
    }
    
    public Properties a() {
        try {
            final InputStream resourceAsStream = this.b.getResourceAsStream(this.a);
            if (resourceAsStream != null) {
                try {
                    final BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
                    try {
                        final Properties properties = new Properties();
                        properties.load((InputStream)bufferedInputStream);
                        bufferedInputStream.close();
                        resourceAsStream.close();
                        return properties;
                    }
                    finally {
                        try {
                            bufferedInputStream.close();
                        }
                        finally {
                            final Throwable t;
                            final Throwable t2;
                            t.addSuppressed(t2);
                        }
                    }
                }
                finally {
                    try {
                        resourceAsStream.close();
                    }
                    finally {
                        final Throwable t3;
                        final Throwable t4;
                        t3.addSuppressed(t4);
                    }
                }
            }
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return null;
        }
        catch (final IOException ex) {
            this.c.c(l4.ERROR, (Throwable)ex, "Failed to load Sentry configuration from classpath resource: %s", this.a);
            return null;
        }
    }
}
