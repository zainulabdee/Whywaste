package io.sentry;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import io.sentry.vendor.a;
import java.io.File;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.ByteArrayOutputStream;
import io.sentry.util.k;
import io.sentry.util.n;
import java.util.concurrent.Callable;
import java.nio.charset.Charset;

public final class c4
{
    private static final Charset d;
    private final d4 a;
    private final Callable<byte[]> b;
    private byte[] c;
    
    static {
        d = Charset.forName("UTF-8");
    }
    
    c4(final d4 d4, final Callable<byte[]> callable) {
        this.a = n.c(d4, "SentryEnvelopeItemHeader is required.");
        this.b = n.c(callable, "DataFactory is required.");
        this.c = null;
    }
    
    c4(final d4 d4, final byte[] c) {
        this.a = n.c(d4, "SentryEnvelopeItemHeader is required.");
        this.c = c;
        this.b = null;
    }
    
    private static byte[] N(final String s, final long n) {
        Object o = null;
        try {
            o = new File(s);
            if (!((File)o).isFile()) {
                o = new io.sentry.exception.b(String.format("Reading the item %s failed, because the file located at the path is not a file.", new Object[] { s }));
                throw o;
            }
            if (((File)o).canRead()) {
                if (((File)o).length() <= n) {
                    o = new FileInputStream(s);
                    try {
                        final BufferedInputStream bufferedInputStream = new BufferedInputStream((InputStream)o);
                        try {
                            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                final byte[] array = new byte[1024];
                                while (true) {
                                    final int read = ((InputStream)bufferedInputStream).read(array);
                                    if (read == -1) {
                                        break;
                                    }
                                    byteArrayOutputStream.write(array, 0, read);
                                }
                                final byte[] byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                bufferedInputStream.close();
                                ((FileInputStream)o).close();
                                return byteArray;
                            }
                            finally {
                                try {
                                    byteArrayOutputStream.close();
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
                                bufferedInputStream.close();
                            }
                            finally {
                                final Throwable t3;
                                final Throwable t4;
                                t3.addSuppressed(t4);
                            }
                        }
                    }
                    finally {
                        try {
                            ((FileInputStream)o).close();
                        }
                        finally {
                            final Throwable t5;
                            t5.addSuppressed((Throwable)o);
                        }
                    }
                }
                throw new io.sentry.exception.b(String.format("Dropping item, because its size located at '%s' with %d bytes is bigger than the maximum allowed size of %d bytes.", new Object[] { s, ((File)o).length(), n }));
            }
            o = new io.sentry.exception.b(String.format("Reading the item %s failed, because can't read the file.", new Object[] { s }));
            throw o;
        }
        catch (final SecurityException o) {}
        catch (final IOException ex) {}
        throw new io.sentry.exception.b(String.format("Reading the item %s failed.\n%s", new Object[] { s, ((Throwable)o).getMessage() }));
    }
    
    private static void p(final long n, final long n2, final String s) {
        if (n <= n2) {
            return;
        }
        throw new io.sentry.exception.b(String.format("Dropping attachment with filename '%s', because the size of the passed bytes with %d bytes is bigger than the maximum allowed attachment size of %d bytes.", new Object[] { s, n, n2 }));
    }
    
    public static c4 q(final t0 t0, final n0 n0, final b b, final long n2) {
        final a a = new a((Callable<byte[]>)new b4(b, n2, t0, n0));
        return new c4(new d4(k4.Attachment, (Callable)new o3(a), b.f(), b.g(), b.d()), (Callable<byte[]>)new p3(a));
    }
    
    public static c4 r(final t0 t0, final io.sentry.clientreport.b b) {
        n.c(t0, "ISerializer is required.");
        n.c(b, "ClientReport is required.");
        final a a = new a((Callable<byte[]>)new v3(t0, b));
        return new c4(new d4(k4.resolve((Object)b), (Callable)new w3(a), "application/json", (String)null), (Callable<byte[]>)new x3(a));
    }
    
    public static c4 s(final t0 t0, final e3 e3) {
        n.c(t0, "ISerializer is required.");
        n.c(e3, "SentryEvent is required.");
        final a a = new a((Callable<byte[]>)new y3(t0, e3));
        return new c4(new d4(k4.resolve((Object)e3), (Callable)new z3(a), "application/json", (String)null), (Callable<byte[]>)new a4(a));
    }
    
    public static c4 t(final l2 l2, final long n, final t0 t0) {
        final File b = l2.B();
        final a a = new a((Callable<byte[]>)new q3(b, n, l2, t0));
        return new c4(new d4(k4.Profile, (Callable)new r3(a), "application-json", b.getName()), (Callable<byte[]>)new s3(a));
    }
    
    public static c4 u(final t0 t0, final a5 a5) {
        n.c(t0, "ISerializer is required.");
        n.c(a5, "Session is required.");
        final a a6 = new a((Callable<byte[]>)new n3(t0, a5));
        return new c4(new d4(k4.Session, (Callable)new t3(a6), "application/json", (String)null), (Callable<byte[]>)new u3(a6));
    }
    
    public io.sentry.clientreport.b v(final t0 t0) {
        final d4 a = this.a;
        if (a != null) {
            if (a.b() == k4.ClientReport) {
                final BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)new ByteArrayInputStream(this.w()), c4.d));
                try {
                    final io.sentry.clientreport.b b = t0.a((Reader)bufferedReader, io.sentry.clientreport.b.class);
                    ((Reader)bufferedReader).close();
                    return b;
                }
                finally {
                    try {
                        ((Reader)bufferedReader).close();
                    }
                    finally {
                        final Throwable t2;
                        ((Throwable)t0).addSuppressed(t2);
                    }
                }
            }
        }
        return null;
    }
    
    public byte[] w() {
        if (this.c == null) {
            final Callable<byte[]> b = this.b;
            if (b != null) {
                this.c = (byte[])b.call();
            }
        }
        return this.c;
    }
    
    public d4 x() {
        return this.a;
    }
    
    private static class a
    {
        private byte[] a;
        private final Callable<byte[]> b;
        
        public a(final Callable<byte[]> b) {
            this.b = b;
        }
        
        private static byte[] b(byte[] array) {
            if (array == null) {
                array = new byte[0];
            }
            return array;
        }
        
        public byte[] a() {
            if (this.a == null) {
                final Callable<byte[]> b = this.b;
                if (b != null) {
                    this.a = (byte[])b.call();
                }
            }
            return b(this.a);
        }
    }
}
