package io.sentry;

import io.sentry.cache.f;
import io.sentry.cache.e;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.Date;
import java.io.File;
import java.nio.charset.Charset;

final class j2 implements Runnable
{
    private static final Charset g;
    private final q4 e;
    private final m0 f;
    
    static {
        g = Charset.forName("UTF-8");
    }
    
    j2(final q4 e, final m0 f) {
        this.e = e;
        this.f = f;
    }
    
    private Date a(final File file) {
        try {
            final BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(file), j2.g));
            try {
                final String line = bufferedReader.readLine();
                this.e.getLogger().a(l4.DEBUG, "Crash marker file has %s timestamp.", line);
                final Date e = j.e(line);
                bufferedReader.close();
                return e;
            }
            finally {
                try {
                    bufferedReader.close();
                }
                finally {
                    final Throwable t;
                    ((Throwable)file).addSuppressed(t);
                }
            }
        }
        catch (final IllegalArgumentException ex) {
            this.e.getLogger().c(l4.ERROR, (Throwable)ex, "Error converting the crash timestamp.", new Object[0]);
        }
        catch (final IOException ex2) {
            this.e.getLogger().d(l4.ERROR, "Error reading the crash marker file.", (Throwable)ex2);
        }
        return null;
    }
    
    public void run() {
        final String cacheDirPath = this.e.getCacheDirPath();
        if (cacheDirPath == null) {
            this.e.getLogger().a(l4.INFO, "Cache dir is not set, not finalizing the previous session.", new Object[0]);
            return;
        }
        if (!this.e.isEnableAutoSessionTracking()) {
            this.e.getLogger().a(l4.DEBUG, "Session tracking is disabled, bailing from previous session finalizer.", new Object[0]);
            return;
        }
        final f envelopeDiskCache = this.e.getEnvelopeDiskCache();
        if (envelopeDiskCache instanceof e && !((e)envelopeDiskCache).F()) {
            this.e.getLogger().a(l4.WARNING, "Timed out waiting to flush previous session to its own file in session finalizer.", new Object[0]);
            return;
        }
        final File b = io.sentry.cache.e.B(cacheDirPath);
        final t0 serializer = this.e.getSerializer();
        if (b.exists()) {
            this.e.getLogger().a(l4.WARNING, "Current session is not ended, we'd need to end it.", new Object[0]);
            try {
                final BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(b), j2.g));
                try {
                    final a5 a5 = serializer.a((Reader)bufferedReader, a5.class);
                    if (a5 == null) {
                        this.e.getLogger().a(l4.ERROR, "Stream from path %s resulted in a null envelope.", b.getAbsolutePath());
                    }
                    else {
                        final File file = new File(this.e.getCacheDirPath(), ".sentry-native/last_crash");
                        final boolean exists = file.exists();
                        Date a6 = null;
                        if (exists) {
                            this.e.getLogger().a(l4.INFO, "Crash marker file exists, last Session is gonna be Crashed.", new Object[0]);
                            a6 = this.a(file);
                            if (!file.delete()) {
                                this.e.getLogger().a(l4.ERROR, "Failed to delete the crash marker file. %s.", file.getAbsolutePath());
                            }
                            a5.o(io.sentry.a5.b.Crashed, (String)null, true);
                        }
                        if (a5.f() == null) {
                            a5.d(a6);
                        }
                        this.f.o(l3.a(serializer, a5, this.e.getSdkVersion()));
                    }
                    ((Reader)bufferedReader).close();
                }
                finally {
                    try {
                        ((Reader)bufferedReader).close();
                    }
                    finally {
                        final Throwable t;
                        final Throwable t2;
                        t.addSuppressed(t2);
                    }
                }
            }
            finally {
                final Throwable t3;
                this.e.getLogger().d(l4.ERROR, "Error processing previous session.", t3);
            }
            if (!b.delete()) {
                this.e.getLogger().a(l4.WARNING, "Failed to delete the previous session file.", new Object[0]);
            }
        }
    }
}
