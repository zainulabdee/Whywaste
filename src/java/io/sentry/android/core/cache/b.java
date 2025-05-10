package io.sentry.android.core.cache;

import java.io.OutputStream;
import io.sentry.util.j$a;
import io.sentry.util.j;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.android.core.j0;
import io.sentry.a0;
import io.sentry.l3;
import java.io.FileOutputStream;
import java.io.File;
import io.sentry.l4;
import io.sentry.android.core.AnrV2Integration;
import io.sentry.q4;
import io.sentry.util.n;
import io.sentry.android.core.internal.util.a;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.transport.o;
import io.sentry.cache.e;

public final class b extends e
{
    private final o l;
    
    public b(final SentryAndroidOptions sentryAndroidOptions) {
        this(sentryAndroidOptions, a.b());
    }
    
    b(final SentryAndroidOptions sentryAndroidOptions, final o l) {
        super((q4)sentryAndroidOptions, (String)n.c((Object)((q4)sentryAndroidOptions).getCacheDirPath(), "cacheDirPath must not be null"), ((q4)sentryAndroidOptions).getMaxCacheItems());
        this.l = l;
    }
    
    public static boolean K(final q4 q4) {
        final String outboxPath = q4.getOutboxPath();
        if (outboxPath == null) {
            q4.getLogger().a(l4.DEBUG, "Outbox path is null, the startup crash marker file does not exist", new Object[0]);
            return false;
        }
        final File file = new File(outboxPath, "startup_crash");
        try {
            final boolean exists = file.exists();
            if (exists && !file.delete()) {
                q4.getLogger().a(l4.ERROR, "Failed to delete the startup crash marker file. %s.", new Object[] { file.getAbsolutePath() });
            }
            return exists;
        }
        finally {
            final Throwable t;
            q4.getLogger().d(l4.ERROR, "Error reading/deleting the startup crash marker file on the disk", t);
            return false;
        }
    }
    
    public static Long M(q4 value) {
        final File file = new File((String)n.c((Object)((q4)value).getCacheDirPath(), "Cache dir path should be set for getting ANRs reported"), "last_anr_report");
        final Object o = null;
        try {
            if (file.exists() && file.canRead()) {
                final String b = io.sentry.util.e.b(file);
                if (b.equals((Object)"null")) {
                    value = o;
                }
                else {
                    value = Long.parseLong(b.trim());
                }
                return (Long)value;
            }
            ((q4)value).getLogger().a(l4.DEBUG, "Last ANR marker does not exist. %s.", new Object[] { file.getAbsolutePath() });
        }
        finally {
            final Throwable t;
            ((q4)value).getLogger().d(l4.ERROR, "Error reading last ANR marker", t);
        }
        return null;
    }
    
    private void N(final Long n) {
        final String cacheDirPath = this.e.getCacheDirPath();
        if (cacheDirPath == null) {
            this.e.getLogger().a(l4.DEBUG, "Cache dir path is null, the ANR marker will not be written", new Object[0]);
            return;
        }
        final File file = new File(cacheDirPath, "last_anr_report");
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ((OutputStream)fileOutputStream).write(String.valueOf((Object)n).getBytes(b.i));
                ((OutputStream)fileOutputStream).flush();
                ((OutputStream)fileOutputStream).close();
            }
            finally {
                try {
                    ((OutputStream)fileOutputStream).close();
                }
                finally {
                    final Throwable t;
                    ((Throwable)n).addSuppressed(t);
                }
            }
        }
        finally {
            final Throwable t2;
            this.e.getLogger().d(l4.ERROR, "Error writing the ANR marker to the disk", t2);
        }
    }
    
    private void O() {
        final String outboxPath = this.e.getOutboxPath();
        if (outboxPath == null) {
            this.e.getLogger().a(l4.DEBUG, "Outbox path is null, the startup crash marker file will not be written", new Object[0]);
            return;
        }
        final File file = new File(outboxPath, "startup_crash");
        try {
            file.createNewFile();
        }
        finally {
            final Throwable t;
            this.e.getLogger().d(l4.ERROR, "Error writing the startup crash marker file to the disk", t);
        }
    }
    
    public void g(final l3 l3, final a0 a0) {
        super.g(l3, a0);
        final SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions)this.e;
        final Long c = j0.e().c();
        if (j.g(a0, (Class)UncaughtExceptionHandlerIntegration.a.class) && c != null) {
            final long n = this.l.a() - c;
            if (n <= sentryAndroidOptions.getStartupCrashDurationThresholdMillis()) {
                ((q4)sentryAndroidOptions).getLogger().a(l4.DEBUG, "Startup Crash detected %d milliseconds after SDK init. Writing a startup crash marker file to disk.", new Object[] { n });
                this.O();
            }
        }
        j.n(a0, (Class)AnrV2Integration.b.class, (j$a)new io.sentry.android.core.cache.a(this, sentryAndroidOptions));
    }
}
