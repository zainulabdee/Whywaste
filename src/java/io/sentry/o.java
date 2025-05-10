package io.sentry;

import io.sentry.util.j;
import java.io.FilenameFilter;
import java.io.File;

abstract class o
{
    private final n0 a;
    private final long b;
    
    o(final n0 a, final long b) {
        this.a = a;
        this.b = b;
    }
    
    protected abstract boolean c(final String p0);
    
    public void e(final File file) {
        try {
            final n0 a = this.a;
            final l4 debug = l4.DEBUG;
            a.a(debug, "Processing dir. %s", file.getAbsolutePath());
            if (!file.exists()) {
                this.a.a(l4.WARNING, "Directory '%s' doesn't exist. No cached events to send.", file.getAbsolutePath());
                return;
            }
            if (!file.isDirectory()) {
                this.a.a(l4.ERROR, "Cache dir %s is not a directory.", file.getAbsolutePath());
                return;
            }
            final File[] listFiles = file.listFiles();
            if (listFiles == null) {
                this.a.a(l4.ERROR, "Cache dir %s is null.", file.getAbsolutePath());
                return;
            }
            final File[] listFiles2 = file.listFiles((FilenameFilter)new n(this));
            final n0 a2 = this.a;
            int length;
            if (listFiles2 != null) {
                length = listFiles2.length;
            }
            else {
                length = 0;
            }
            a2.a(debug, "Processing %d items from cache dir %s", length, file.getAbsolutePath());
            for (final File file2 : listFiles) {
                if (!file2.isFile()) {
                    this.a.a(l4.DEBUG, "File %s is not a File.", file2.getAbsolutePath());
                }
                else {
                    this.a.a(l4.DEBUG, "Processing file: %s", file2.getAbsolutePath());
                    this.f(file2, j.e(new o.o$a(this.b, this.a)));
                }
            }
        }
        finally {
            final Throwable t;
            this.a.c(l4.ERROR, t, "Failed processing '%s'", file.getAbsolutePath());
        }
    }
    
    protected abstract void f(final File p0, final a0 p1);
}
