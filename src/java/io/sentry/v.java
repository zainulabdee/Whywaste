package io.sentry;

import java.io.FileNotFoundException;
import java.io.IOException;
import io.sentry.util.j$a;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import io.sentry.hints.h;
import io.sentry.hints.j;
import java.io.File;
import io.sentry.util.n;

public final class v extends o implements k0
{
    private final m0 c;
    private final t0 d;
    private final n0 e;
    
    public v(final m0 m0, final t0 t0, final n0 n0, final long n2) {
        super(n0, n2);
        this.c = (m0)n.c((Object)m0, "Hub is required.");
        this.d = (t0)n.c((Object)t0, "Serializer is required.");
        this.e = (n0)n.c((Object)n0, "Logger is required.");
    }
    
    private void m(final File file, final String s) {
        try {
            if (!file.delete()) {
                this.e.a(l4.ERROR, "Failed to delete '%s' %s", new Object[] { file.getAbsolutePath(), s });
            }
        }
        finally {
            final Throwable t;
            this.e.c(l4.ERROR, t, "Failed to delete '%s' %s", new Object[] { file.getAbsolutePath(), s });
        }
    }
    
    public void a(final String s, final a0 a0) {
        n.c((Object)s, "Path is required.");
        this.f(new File(s), a0);
    }
    
    protected boolean c(final String s) {
        return s.endsWith(".envelope");
    }
    
    protected void f(File file, final a0 a0) {
        if (!file.isFile()) {
            this.e.a(l4.DEBUG, "'%s' is not a file.", new Object[] { file.getAbsolutePath() });
            return;
        }
        if (!this.c(file.getName())) {
            this.e.a(l4.DEBUG, "File '%s' doesn't match extension expected.", new Object[] { file.getAbsolutePath() });
            return;
        }
        if (!file.getParentFile().canWrite()) {
            this.e.a(l4.WARNING, "File '%s' cannot be deleted so it will not be processed.", new Object[] { file.getAbsolutePath() });
            return;
        }
        Label_0437: {
            Object o2;
            try {
                Object e = new BufferedInputStream((InputStream)new FileInputStream(file));
                try {
                    final l3 b = this.d.b((InputStream)e);
                    if (b == null) {
                        this.e.a(l4.ERROR, "Failed to deserialize cached envelope %s", new Object[] { file.getAbsolutePath() });
                    }
                    else {
                        this.c.g(b, a0);
                    }
                    io.sentry.util.j.p(a0, (Class)h.class, this.e, (j$a)new s(this));
                    ((InputStream)e).close();
                    e = this.e;
                    final t t = new t(this, file);
                    file = (File)e;
                    e = t;
                }
                finally {
                    try {
                        ((InputStream)e).close();
                    }
                    finally {
                        final Throwable t2;
                        final Throwable t3;
                        t2.addSuppressed(t3);
                    }
                }
            }
            catch (final IOException ex) {
                final Throwable t4 = (Throwable)ex;
                final v v = this;
                final n0 n0 = v.e;
                final l4 l4 = io.sentry.l4.ERROR;
                final Throwable t5 = t4;
                final String s = "I/O on file '%s' failed.";
                final int n2 = 1;
                final Object[] array = new Object[n2];
                final int n3 = 0;
                final File file2 = file;
                final String s2 = file2.getAbsolutePath();
                array[n3] = s2;
                n0.c(l4, t5, s, array);
                final v v2 = this;
                final Object o = v2.e;
                final v v3 = this;
                final File file3 = file;
                final t t6 = new t(v3, file3);
                file = (File)o;
                break Label_0437;
            }
            catch (final FileNotFoundException ex2) {
                this.e.c(l4.ERROR, (Throwable)ex2, "File '%s' cannot be found.", new Object[] { file.getAbsolutePath() });
                final Object e2 = this.e;
                o2 = new t(this, file);
                file = (File)e2;
            }
            finally {
                final Throwable t7;
                this.e.c(l4.ERROR, t7, "Failed to capture cached envelope %s", new Object[] { file.getAbsolutePath() });
                io.sentry.util.j.p(a0, (Class)j.class, this.e, (j$a)new u(this, t7, file));
                final Object e3 = this.e;
                final t t8 = new t(this, file);
                file = (File)e3;
                o2 = t8;
                break Label_0437;
            }
            try {
                final IOException ex;
                final Throwable t4 = (Throwable)ex;
                final v v = this;
                final n0 n0 = v.e;
                final l4 l4 = io.sentry.l4.ERROR;
                final Throwable t5 = t4;
                final String s = "I/O on file '%s' failed.";
                final int n2 = 1;
                final Object[] array = new Object[n2];
                final int n3 = 0;
                final File file2 = file;
                final String s2 = file2.getAbsolutePath();
                array[n3] = s2;
                n0.c(l4, t5, s, array);
                final v v2 = this;
                final Object o = v2.e;
                final v v3 = this;
                final File file3 = file;
                final t t6 = new t(v3, file3);
                file = (File)o;
                io.sentry.util.j.p(a0, (Class)j.class, (n0)file, (j$a)o2);
            }
            finally {
                io.sentry.util.j.p(a0, (Class)j.class, this.e, (j$a)new t(this, file));
            }
        }
    }
}
