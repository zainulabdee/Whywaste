package io.sentry.android.core.internal.debugmeta;

import android.content.res.AssetManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import io.sentry.l4;
import java.io.InputStream;
import java.io.BufferedInputStream;
import io.sentry.util.c;
import java.util.Properties;
import io.sentry.n0;
import android.content.Context;

public final class a implements io.sentry.internal.debugmeta.a
{
    private final Context a;
    private final n0 b;
    
    public a(final Context a, final n0 b) {
        this.a = a;
        this.b = b;
    }
    
    public Properties a() {
        final AssetManager assets = this.a.getAssets();
        try {
            final BufferedInputStream bufferedInputStream = new BufferedInputStream(assets.open(c.a));
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
            this.b.c(l4.ERROR, (Throwable)ex, "%s file is malformed.", new Object[] { c.a });
        }
        catch (final IOException ex2) {
            this.b.d(l4.ERROR, "Error getting Proguard UUIDs.", (Throwable)ex2);
        }
        catch (final FileNotFoundException ex3) {
            this.b.c(l4.INFO, (Throwable)ex3, "%s file was not found.", new Object[] { c.a });
        }
        return null;
    }
}
