package io.sentry.cache;

import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import io.sentry.UncaughtExceptionHandlerIntegration$a;
import io.sentry.i3;
import io.sentry.hints.m;
import io.sentry.hints.k;
import io.sentry.util.n;
import java.util.concurrent.TimeUnit;
import io.sentry.transport.r;
import java.io.FilenameFilter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayInputStream;
import io.sentry.k4;
import io.sentry.c4;
import java.util.Date;
import io.sentry.n0;
import io.sentry.a5$b;
import io.sentry.a5;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import io.sentry.l4;
import io.sentry.util.j;
import io.sentry.a0;
import java.util.UUID;
import java.io.File;
import java.util.WeakHashMap;
import io.sentry.q4;
import io.sentry.l3;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class e extends b implements f
{
    private final CountDownLatch j;
    private final Map<l3, String> k;
    
    public e(final q4 q4, final String s, final int n) {
        super(q4, s, n);
        this.k = (Map<l3, String>)new WeakHashMap();
        this.j = new CountDownLatch(1);
    }
    
    private File A(final l3 l3) {
        synchronized (this) {
            String s;
            if (this.k.containsKey((Object)l3)) {
                s = (String)this.k.get((Object)l3);
            }
            else {
                String s2;
                if (l3.b().a() != null) {
                    s2 = l3.b().a().toString();
                }
                else {
                    s2 = UUID.randomUUID().toString();
                }
                final StringBuilder sb = new StringBuilder();
                sb.append(s2);
                sb.append(".envelope");
                final String string = sb.toString();
                this.k.put((Object)l3, (Object)string);
                s = string;
            }
            return new File(super.g.getAbsolutePath(), s);
        }
    }
    
    public static File B(final String s) {
        return new File(s, "previous_session.json");
    }
    
    private void D(final a0 a0) {
        final Object f = io.sentry.util.j.f(a0);
        if (f instanceof io.sentry.hints.b) {
            final File b = B(super.g.getAbsolutePath());
            if (b.exists()) {
                final n0 logger = super.e.getLogger();
                final l4 warning = l4.WARNING;
                logger.a(warning, "Previous session is not ended, we'd need to end it.", new Object[0]);
                try {
                    final BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(b), io.sentry.cache.b.i));
                    try {
                        final a5 a2 = (a5)super.f.a((Reader)bufferedReader, (Class)a5.class);
                        if (a2 != null) {
                            final io.sentry.hints.b b2 = (io.sentry.hints.b)f;
                            final Long b3 = b2.b();
                            Date date = null;
                            Label_0191: {
                                if (b3 != null) {
                                    final Date d = io.sentry.j.d((long)b3);
                                    final Date k = a2.k();
                                    if (k != null) {
                                        date = d;
                                        if (!d.before(k)) {
                                            break Label_0191;
                                        }
                                    }
                                    super.e.getLogger().a(warning, "Abnormal exit happened before previous session start, not ending the session.", new Object[0]);
                                    ((Reader)bufferedReader).close();
                                    return;
                                }
                                date = null;
                            }
                            a2.p(a5$b.Abnormal, null, true, b2.e());
                            a2.d(date);
                            this.I(b, a2);
                        }
                        ((Reader)bufferedReader).close();
                    }
                    finally {
                        try {
                            ((Reader)bufferedReader).close();
                        }
                        finally {
                            final Throwable t;
                            ((Throwable)a0).addSuppressed(t);
                        }
                    }
                }
                finally {
                    final Throwable t2;
                    super.e.getLogger().d(l4.ERROR, "Error processing previous session.", t2);
                    return;
                }
            }
            super.e.getLogger().a(l4.DEBUG, "No previous session file to end.", new Object[0]);
        }
    }
    
    private void E(final File file, l3 l3) {
        final Iterable c = l3.c();
        if (c.iterator().hasNext()) {
            final c4 c2 = (c4)c.iterator().next();
            if (k4.Session.equals(c2.x().b())) {
                try {
                    l3 = (l3)new BufferedReader((Reader)new InputStreamReader((InputStream)new ByteArrayInputStream(c2.w()), b.i));
                    try {
                        final a5 a5 = (a5)super.f.a((Reader)l3, (Class)a5.class);
                        if (a5 == null) {
                            super.e.getLogger().a(l4.ERROR, "Item of type %s returned null by the parser.", new Object[] { c2.x().b() });
                        }
                        else {
                            this.I(file, a5);
                        }
                        ((Reader)l3).close();
                    }
                    finally {
                        try {
                            ((Reader)l3).close();
                        }
                        finally {
                            final Throwable t;
                            ((Throwable)file).addSuppressed(t);
                        }
                    }
                }
                finally {
                    final Throwable t2;
                    super.e.getLogger().d(l4.ERROR, "Item failed to process.", t2);
                    return;
                }
            }
            super.e.getLogger().a(l4.INFO, "Current envelope has a different envelope type %s", new Object[] { c2.x().b() });
        }
        else {
            super.e.getLogger().a(l4.INFO, "Current envelope %s is empty", new Object[] { file.getAbsolutePath() });
        }
    }
    
    private void G() {
        final File file = new File(super.e.getCacheDirPath(), "last_crash");
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                ((OutputStream)fileOutputStream).write(io.sentry.j.g(io.sentry.j.c()).getBytes(b.i));
                ((OutputStream)fileOutputStream).flush();
                ((OutputStream)fileOutputStream).close();
            }
            finally {
                try {
                    ((OutputStream)fileOutputStream).close();
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
            super.e.getLogger().d(l4.ERROR, "Error writing the crash marker file to the disk", t3);
        }
    }
    
    private void H(final File file, final l3 l3) {
        if (file.exists()) {
            super.e.getLogger().a(l4.DEBUG, "Overwriting envelope to offline storage: %s", new Object[] { file.getAbsolutePath() });
            if (!file.delete()) {
                super.e.getLogger().a(l4.ERROR, "Failed to delete: %s", new Object[] { file.getAbsolutePath() });
            }
        }
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                super.f.e(l3, (OutputStream)fileOutputStream);
                ((OutputStream)fileOutputStream).close();
            }
            finally {
                try {
                    ((OutputStream)fileOutputStream).close();
                }
                finally {
                    final Throwable t;
                    ((Throwable)l3).addSuppressed(t);
                }
            }
        }
        finally {
            final Throwable t2;
            super.e.getLogger().c(l4.ERROR, t2, "Error writing Envelope %s to offline storage", new Object[] { file.getAbsolutePath() });
        }
    }
    
    private void I(File file, final a5 a5) {
        if (file.exists()) {
            super.e.getLogger().a(l4.DEBUG, "Overwriting session to offline storage: %s", new Object[] { a5.j() });
            if (!file.delete()) {
                super.e.getLogger().a(l4.ERROR, "Failed to delete: %s", new Object[] { file.getAbsolutePath() });
            }
        }
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                file = (File)new BufferedWriter((Writer)new OutputStreamWriter((OutputStream)fileOutputStream, b.i));
                try {
                    super.f.c((Object)a5, (Writer)file);
                    ((Writer)file).close();
                    ((OutputStream)fileOutputStream).close();
                }
                finally {
                    try {
                        ((Writer)file).close();
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
                    ((OutputStream)fileOutputStream).close();
                }
                finally {
                    final Throwable t3;
                    ((Throwable)file).addSuppressed(t3);
                }
            }
        }
        finally {
            final Throwable t4;
            super.e.getLogger().c(l4.ERROR, t4, "Error writing Session to offline storage: %s", new Object[] { a5.j() });
        }
    }
    
    private File[] w() {
        if (this.k()) {
            final File[] listFiles = super.g.listFiles((FilenameFilter)new d());
            if (listFiles != null) {
                return listFiles;
            }
        }
        return new File[0];
    }
    
    public static f x(final q4 q4) {
        final String cacheDirPath = q4.getCacheDirPath();
        final int maxCacheItems = q4.getMaxCacheItems();
        if (cacheDirPath == null) {
            q4.getLogger().a(l4.WARNING, "cacheDirPath is null, returning NoOpEnvelopeCache", new Object[0]);
            return (f)r.h();
        }
        return (f)new e(q4, cacheDirPath, maxCacheItems);
    }
    
    public static File z(final String s) {
        return new File(s, "session.json");
    }
    
    public boolean F() {
        try {
            return this.j.await(super.e.getFlushTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
        catch (final InterruptedException ex) {
            Thread.currentThread().interrupt();
            super.e.getLogger().a(l4.DEBUG, "Timed out waiting for previous session to flush.", new Object[0]);
            return false;
        }
    }
    
    public void a(final l3 l3) {
        n.c((Object)l3, "Envelope is required.");
        final File a = this.A(l3);
        if (a.exists()) {
            super.e.getLogger().a(l4.DEBUG, "Discarding envelope from cache: %s", new Object[] { a.getAbsolutePath() });
            if (!a.delete()) {
                super.e.getLogger().a(l4.ERROR, "Failed to delete envelope: %s", new Object[] { a.getAbsolutePath() });
            }
        }
        else {
            super.e.getLogger().a(l4.DEBUG, "Envelope was not cached: %s", new Object[] { a.getAbsolutePath() });
        }
    }
    
    public void g(final l3 l3, final a0 a0) {
        n.c((Object)l3, "Envelope is required.");
        this.s(this.w());
        final File z = z(super.g.getAbsolutePath());
        final File b = B(super.g.getAbsolutePath());
        if (io.sentry.util.j.g(a0, (Class)k.class) && !z.delete()) {
            super.e.getLogger().a(l4.WARNING, "Current envelope doesn't exist.", new Object[0]);
        }
        if (io.sentry.util.j.g(a0, (Class)io.sentry.hints.b.class)) {
            this.D(a0);
        }
        if (io.sentry.util.j.g(a0, (Class)m.class)) {
            if (z.exists()) {
                super.e.getLogger().a(l4.WARNING, "Current session is not ended, we'd need to end it.", new Object[0]);
                try {
                    final BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(z), io.sentry.cache.b.i));
                    try {
                        final a5 a2 = (a5)super.f.a((Reader)bufferedReader, (Class)a5.class);
                        if (a2 != null) {
                            this.I(b, a2);
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
                    super.e.getLogger().d(l4.ERROR, "Error processing session.", t3);
                }
            }
            this.E(z, l3);
            boolean exists;
            final boolean b2 = exists = new File(super.e.getCacheDirPath(), ".sentry-native/last_crash").exists();
            if (!b2) {
                final File file = new File(super.e.getCacheDirPath(), "last_crash");
                exists = b2;
                if (file.exists()) {
                    super.e.getLogger().a(l4.INFO, "Crash marker file exists, crashedLastRun will return true.", new Object[0]);
                    if (!file.delete()) {
                        super.e.getLogger().a(l4.ERROR, "Failed to delete the crash marker file. %s.", new Object[] { file.getAbsolutePath() });
                    }
                    exists = true;
                }
            }
            i3.a().b(exists);
            this.y();
        }
        final File a3 = this.A(l3);
        if (a3.exists()) {
            super.e.getLogger().a(l4.WARNING, "Not adding Envelope to offline storage because it already exists: %s", new Object[] { a3.getAbsolutePath() });
            return;
        }
        super.e.getLogger().a(l4.DEBUG, "Adding Envelope to offline storage: %s", new Object[] { a3.getAbsolutePath() });
        this.H(a3, l3);
        if (io.sentry.util.j.g(a0, (Class)UncaughtExceptionHandlerIntegration$a.class)) {
            this.G();
        }
    }
    
    public Iterator<l3> iterator() {
        final File[] w = this.w();
        final ArrayList list = new ArrayList(w.length);
        for (final File file : w) {
            try {
                final BufferedInputStream bufferedInputStream = new BufferedInputStream((InputStream)new FileInputStream(file));
                try {
                    ((List)list).add((Object)super.f.b((InputStream)bufferedInputStream));
                    ((InputStream)bufferedInputStream).close();
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
            catch (final IOException ex) {
                super.e.getLogger().d(l4.ERROR, String.format("Error while reading cached envelope from file %s", new Object[] { file.getAbsolutePath() }), (Throwable)ex);
            }
            catch (final FileNotFoundException ex2) {
                super.e.getLogger().a(l4.DEBUG, "Envelope file '%s' disappeared while converting all cached files to envelopes.", new Object[] { file.getAbsolutePath() });
            }
        }
        return (Iterator<l3>)((List)list).iterator();
    }
    
    public void y() {
        this.j.countDown();
    }
}
