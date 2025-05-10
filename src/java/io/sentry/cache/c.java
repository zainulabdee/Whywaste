package io.sentry.cache;

import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import io.sentry.c1;
import java.io.File;
import io.sentry.l4;
import io.sentry.q4;
import java.nio.charset.Charset;

final class c
{
    private static final Charset a;
    
    static {
        a = Charset.forName("UTF-8");
    }
    
    static void a(final q4 q4, final String s, final String s2) {
        final File b = b(q4, s);
        if (b == null) {
            q4.getLogger().a(l4.INFO, "Cache dir is not set, cannot delete from scope cache", new Object[0]);
            return;
        }
        final File file = new File(b, s2);
        if (file.exists()) {
            q4.getLogger().a(l4.DEBUG, "Deleting %s from scope cache", s2);
            if (!file.delete()) {
                q4.getLogger().a(l4.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
    }
    
    private static File b(final q4 q4, final String s) {
        final String cacheDirPath = q4.getCacheDirPath();
        if (cacheDirPath == null) {
            return null;
        }
        final File file = new File(cacheDirPath, s);
        file.mkdirs();
        return file;
    }
    
    static <T, R> T c(final q4 q4, String s, final String s2, final Class<T> clazz, final c1<R> c1) {
        final File b = b(q4, s);
        if (b == null) {
            q4.getLogger().a(l4.INFO, "Cache dir is not set, cannot read from scope cache", new Object[0]);
            return null;
        }
        final File file = new File(b, s2);
        if (file.exists()) {
            try {
                s = (String)new BufferedReader((Reader)new InputStreamReader((InputStream)new FileInputStream(file), c.a));
                Label_0109: {
                    if (c1 != null) {
                        break Label_0109;
                    }
                    try {
                        final T a = q4.getSerializer().a((Reader)s, clazz);
                        ((Reader)s).close();
                        return a;
                        final T d = q4.getSerializer().d((Reader)s, (Class<T>)clazz, c1);
                        ((Reader)s).close();
                        return (T)d;
                    }
                    finally {
                        try {
                            ((Reader)s).close();
                        }
                        finally {
                            final Throwable t;
                            ((Throwable)clazz).addSuppressed(t);
                        }
                    }
                }
            }
            finally {
                final Throwable t2;
                q4.getLogger().c(l4.ERROR, t2, "Error reading entity from scope cache: %s", s2);
                return null;
            }
        }
        q4.getLogger().a(l4.DEBUG, "No entry stored for %s", s2);
        return null;
    }
    
    static <T> void d(final q4 q4, final T t, String s, final String s2) {
        final File b = b(q4, s);
        if (b == null) {
            q4.getLogger().a(l4.INFO, "Cache dir is not set, cannot store in scope cache", new Object[0]);
            return;
        }
        final File file = new File(b, s2);
        if (file.exists()) {
            q4.getLogger().a(l4.DEBUG, "Overwriting %s in scope cache", s2);
            if (!file.delete()) {
                q4.getLogger().a(l4.ERROR, "Failed to delete: %s", file.getAbsolutePath());
            }
        }
        try {
            s = (String)new FileOutputStream(file);
            try {
                final BufferedWriter bufferedWriter = new BufferedWriter((Writer)new OutputStreamWriter((OutputStream)s, c.a));
                try {
                    q4.getSerializer().c(t, (Writer)bufferedWriter);
                    ((Writer)bufferedWriter).close();
                    ((OutputStream)s).close();
                }
                finally {
                    try {
                        ((Writer)bufferedWriter).close();
                    }
                    finally {
                        final Throwable t2;
                        ((Throwable)t).addSuppressed(t2);
                    }
                }
            }
            finally {
                try {
                    ((OutputStream)s).close();
                }
                finally {
                    final Throwable t3;
                    ((Throwable)t).addSuppressed(t3);
                }
            }
        }
        finally {
            final Throwable t4;
            q4.getLogger().c(l4.ERROR, t4, "Error persisting entity: %s", s2);
        }
    }
}
