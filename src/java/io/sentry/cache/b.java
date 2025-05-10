package io.sentry.cache;

import java.util.List;
import java.util.Comparator;
import java.util.Arrays;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import io.sentry.l4;
import io.sentry.clientreport.e;
import io.sentry.k4;
import io.sentry.a5;
import java.util.Iterator;
import java.util.ArrayList;
import io.sentry.c4;
import io.sentry.l3;
import io.sentry.util.n;
import java.io.File;
import io.sentry.t0;
import io.sentry.q4;
import java.nio.charset.Charset;

abstract class b
{
    protected static final Charset i;
    protected final q4 e;
    protected final t0 f;
    protected final File g;
    private final int h;
    
    static {
        i = Charset.forName("UTF-8");
    }
    
    b(final q4 q4, final String s, final int h) {
        n.c(s, "Directory is required.");
        this.e = n.c(q4, "SentryOptions is required.");
        this.f = q4.getSerializer();
        this.g = new File(s);
        this.h = h;
    }
    
    private l3 i(final l3 l3, final c4 c4) {
        final ArrayList list = new ArrayList();
        final Iterator iterator = l3.c().iterator();
        while (iterator.hasNext()) {
            ((List)list).add((Object)iterator.next());
        }
        ((List)list).add((Object)c4);
        return new l3(l3.b(), (Iterable<c4>)list);
    }
    
    private a5 j(final l3 l3) {
        for (final c4 c4 : l3.c()) {
            if (!this.l(c4)) {
                continue;
            }
            return this.r(c4);
        }
        return null;
    }
    
    private boolean l(final c4 c4) {
        return c4 != null && c4.x().b().equals(k4.Session);
    }
    
    private boolean m(final l3 l3) {
        return l3.c().iterator().hasNext();
    }
    
    private boolean n(final a5 a5) {
        final boolean equals = a5.l().equals(io.sentry.a5.b.Ok);
        boolean b = false;
        if (!equals) {
            return false;
        }
        if (a5.j() != null) {
            b = true;
        }
        return b;
    }
    
    private void p(File u, final File[] array) {
        final l3 q = this.q(u);
        if (q != null) {
            if (this.m(q)) {
                this.e.getClientReportRecorder().d(io.sentry.clientreport.e.CACHE_OVERFLOW, q);
                final a5 j = this.j(q);
                if (j != null) {
                    if (this.n(j)) {
                        final Boolean g = j.g();
                        if (g != null) {
                            if (g) {
                                for (final File file : array) {
                                    final l3 q2 = this.q(file);
                                    if (q2 != null) {
                                        if (this.m(q2)) {
                                            final File file2 = null;
                                            final File file3 = null;
                                            final Iterator iterator = q2.c().iterator();
                                            while (true) {
                                                u = file2;
                                                if (!iterator.hasNext()) {
                                                    break;
                                                }
                                                final c4 c4 = (c4)iterator.next();
                                                if (!this.l(c4)) {
                                                    continue;
                                                }
                                                final a5 r = this.r(c4);
                                                if (r == null) {
                                                    continue;
                                                }
                                                if (!this.n(r)) {
                                                    continue;
                                                }
                                                final Boolean g2 = r.g();
                                                if (g2 != null && g2) {
                                                    this.e.getLogger().a(l4.ERROR, "Session %s has 2 times the init flag.", j.j());
                                                    return;
                                                }
                                                if (j.j() != null && j.j().equals((Object)r.j())) {
                                                    r.m();
                                                    u = file3;
                                                    try {
                                                        final Object o = u = (File)io.sentry.c4.u(this.f, r);
                                                        iterator.remove();
                                                        u = (File)o;
                                                    }
                                                    catch (final IOException ex) {
                                                        this.e.getLogger().c(l4.ERROR, (Throwable)ex, "Failed to create new envelope item for the session %s", j.j());
                                                    }
                                                    break;
                                                }
                                            }
                                            if (u != null) {
                                                final l3 k = this.i(q2, (c4)u);
                                                final long lastModified = file.lastModified();
                                                if (!file.delete()) {
                                                    this.e.getLogger().a(l4.WARNING, "File can't be deleted: %s", file.getAbsolutePath());
                                                }
                                                this.t(k, file, lastModified);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    private l3 q(final File file) {
        try {
            final BufferedInputStream bufferedInputStream = new BufferedInputStream((InputStream)new FileInputStream(file));
            try {
                final l3 b = this.f.b((InputStream)bufferedInputStream);
                ((InputStream)bufferedInputStream).close();
                return b;
            }
            finally {
                try {
                    ((InputStream)bufferedInputStream).close();
                }
                finally {
                    final Throwable t;
                    ((Throwable)file).addSuppressed(t);
                }
            }
        }
        catch (final IOException ex) {
            this.e.getLogger().d(l4.ERROR, "Failed to deserialize the envelope.", (Throwable)ex);
            return null;
        }
    }
    
    private a5 r(final c4 c4) {
        try {
            final BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)new ByteArrayInputStream(c4.w()), b.i));
            try {
                final a5 a5 = this.f.a((Reader)bufferedReader, a5.class);
                ((Reader)bufferedReader).close();
                return a5;
            }
            finally {
                try {
                    ((Reader)bufferedReader).close();
                }
                finally {
                    final Throwable t;
                    ((Throwable)c4).addSuppressed(t);
                }
            }
        }
        finally {
            final Throwable t2;
            this.e.getLogger().d(l4.ERROR, "Failed to deserialize the session.", t2);
            return null;
        }
    }
    
    private void t(final l3 l3, final File file, final long lastModified) {
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            try {
                this.f.e(l3, (OutputStream)fileOutputStream);
                file.setLastModified(lastModified);
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
            this.e.getLogger().d(l4.ERROR, "Failed to serialize the new envelope to the disk.", t2);
        }
    }
    
    private void u(final File[] array) {
        if (array.length > 1) {
            Arrays.sort((Object[])array, (Comparator)new a());
        }
    }
    
    protected boolean k() {
        if (this.g.isDirectory() && this.g.canWrite() && this.g.canRead()) {
            return true;
        }
        this.e.getLogger().a(l4.ERROR, "The directory for caching files is inaccessible.: %s", this.g.getAbsolutePath());
        return false;
    }
    
    protected void s(final File[] array) {
        final int length = array.length;
        if (length >= this.h) {
            this.e.getLogger().a(l4.WARNING, "Cache folder if full (respecting maxSize). Rotating files", new Object[0]);
            final int n = length - this.h + 1;
            this.u(array);
            final File[] array2 = (File[])Arrays.copyOfRange((Object[])array, n, length);
            for (final File file : array) {
                this.p(file, array2);
                if (!file.delete()) {
                    this.e.getLogger().a(l4.WARNING, "File can't be deleted: %s", file.getAbsolutePath());
                }
            }
        }
    }
}
