package io.sentry.internal.debugmeta;

import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;
import io.sentry.l4;
import java.util.Properties;
import io.sentry.n0;

public final class c implements a
{
    private final n0 a;
    private final ClassLoader b;
    
    public c(final n0 n0) {
        this(n0, c.class.getClassLoader());
    }
    
    c(final n0 a, final ClassLoader classLoader) {
        this.a = a;
        this.b = io.sentry.util.a.a(classLoader);
    }
    
    public Properties a() {
        final InputStream resourceAsStream = this.b.getResourceAsStream(io.sentry.util.c.a);
        if (resourceAsStream == null) {
            this.a.a(l4.INFO, "%s file was not found.", new Object[] { io.sentry.util.c.a });
        }
        else {
            try {
                final BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceAsStream);
                try {
                    final Properties properties = new Properties();
                    properties.load((InputStream)bufferedInputStream);
                    ((InputStream)bufferedInputStream).close();
                    return properties;
                }
                finally {
                    try {
                        ((InputStream)bufferedInputStream).close();
                    }
                    finally {
                        final Throwable t;
                        final Throwable t2;
                        t.addSuppressed(t2);
                    }
                }
            }
            catch (final RuntimeException ex) {
                this.a.c(l4.ERROR, (Throwable)ex, "%s file is malformed.", new Object[] { io.sentry.util.c.a });
            }
            catch (final IOException ex2) {
                this.a.c(l4.ERROR, (Throwable)ex2, "Failed to load %s", new Object[] { io.sentry.util.c.a });
            }
        }
        return null;
    }
}
