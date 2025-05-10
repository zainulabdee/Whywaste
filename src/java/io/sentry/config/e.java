package io.sentry.config;

import java.io.IOException;
import io.sentry.l4;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.File;
import java.util.Properties;
import io.sentry.n0;

final class e
{
    private final String a;
    private final n0 b;
    
    public e(final String a, final n0 b) {
        this.a = a;
        this.b = b;
    }
    
    public Properties a() {
        try {
            final File file = new File(this.a);
            if (file.isFile() && file.canRead()) {
                final BufferedInputStream bufferedInputStream = new BufferedInputStream((InputStream)new FileInputStream(file));
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
            return null;
        }
        catch (final IOException ex) {
            this.b.c(l4.ERROR, (Throwable)ex, "Failed to load Sentry configuration from file: %s", this.a);
            return null;
        }
    }
}
