package io.sentry.transport;

import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;
import io.sentry.l3;
import java.net.URLConnection;
import java.net.SocketAddress;
import java.net.InetSocketAddress;
import java.net.Proxy$Type;
import io.sentry.n0;
import io.sentry.l4;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.HostnameVerifier;
import java.util.Iterator;
import javax.net.ssl.HttpsURLConnection;
import java.util.Map$Entry;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Authenticator;
import io.sentry.q4;
import io.sentry.o2;
import java.net.Proxy;
import java.nio.charset.Charset;

final class n
{
    private static final Charset e;
    private final Proxy a;
    private final o2 b;
    private final q4 c;
    private final y d;
    
    static {
        e = Charset.forName("UTF-8");
    }
    
    n(final q4 c, final o2 b, final l l, final y d) {
        this.b = b;
        this.c = c;
        this.d = d;
        final Proxy g = this.g(c.getProxy());
        this.a = g;
        if (g != null && c.getProxy() != null) {
            final String d2 = c.getProxy().d();
            final String b2 = c.getProxy().b();
            if (d2 != null && b2 != null) {
                l.b(new u(d2, b2));
            }
        }
    }
    
    public n(final q4 q4, final o2 o2, final y y) {
        this(q4, o2, l.a(), y);
    }
    
    private void a(final HttpURLConnection httpURLConnection) {
        try {
            ((URLConnection)httpURLConnection).getInputStream().close();
            goto Label_0017;
        }
        catch (final IOException ex) {
            goto Label_0017;
        }
        finally {
            httpURLConnection.disconnect();
        }
    }
    
    private HttpURLConnection b() {
        final HttpURLConnection e = this.e();
        for (final Map$Entry map$Entry : this.b.a().entrySet()) {
            ((URLConnection)e).setRequestProperty((String)map$Entry.getKey(), (String)map$Entry.getValue());
        }
        e.setRequestMethod("POST");
        ((URLConnection)e).setDoOutput(true);
        ((URLConnection)e).setRequestProperty("Content-Encoding", "gzip");
        ((URLConnection)e).setRequestProperty("Content-Type", "application/x-sentry-envelope");
        ((URLConnection)e).setRequestProperty("Accept", "application/json");
        ((URLConnection)e).setRequestProperty("Connection", "close");
        ((URLConnection)e).setConnectTimeout(this.c.getConnectionTimeoutMillis());
        ((URLConnection)e).setReadTimeout(this.c.getReadTimeoutMillis());
        final HostnameVerifier hostnameVerifier = this.c.getHostnameVerifier();
        final boolean b = e instanceof HttpsURLConnection;
        if (b && hostnameVerifier != null) {
            ((HttpsURLConnection)e).setHostnameVerifier(hostnameVerifier);
        }
        final SSLSocketFactory sslSocketFactory = this.c.getSslSocketFactory();
        if (b && sslSocketFactory != null) {
            ((HttpsURLConnection)e).setSSLSocketFactory(sslSocketFactory);
        }
        ((URLConnection)e).connect();
        return e;
    }
    
    private String c(HttpURLConnection errorStream) {
        try {
            errorStream = (HttpURLConnection)errorStream.getErrorStream();
            try {
                final BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader((InputStream)errorStream, n.e));
                try {
                    final StringBuilder sb = new StringBuilder();
                    int n = 1;
                    while (true) {
                        final String line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                        if (n == 0) {
                            sb.append("\n");
                        }
                        sb.append(line);
                        n = 0;
                    }
                    final String string = sb.toString();
                    bufferedReader.close();
                    if (errorStream != null) {
                        ((InputStream)errorStream).close();
                    }
                    return string;
                }
                finally {
                    try {
                        bufferedReader.close();
                    }
                    finally {
                        final Throwable t;
                        final Throwable t2;
                        t.addSuppressed(t2);
                    }
                }
            }
            finally {
                if (errorStream != null) {
                    try {
                        ((InputStream)errorStream).close();
                    }
                    finally {
                        final Throwable t3;
                        final Throwable t4;
                        t3.addSuppressed(t4);
                    }
                }
            }
        }
        catch (final IOException ex) {
            return "Failed to obtain error message while analyzing send failure.";
        }
    }
    
    private boolean d(final int n) {
        return n == 200;
    }
    
    private a0 f(final HttpURLConnection httpURLConnection) {
        try {
            try {
                final int responseCode = httpURLConnection.getResponseCode();
                this.i(httpURLConnection, responseCode);
                if (!this.d(responseCode)) {
                    final n0 logger = this.c.getLogger();
                    final l4 error = l4.ERROR;
                    logger.a(error, "Request failed, API returned %s", responseCode);
                    if (this.c.isDebug()) {
                        this.c.getLogger().a(error, this.c(httpURLConnection), new Object[0]);
                    }
                    final a0 b = a0.b(responseCode);
                    this.a(httpURLConnection);
                    return b;
                }
                this.c.getLogger().a(l4.DEBUG, "Envelope sent successfully.", new Object[0]);
                final a0 e = a0.e();
                this.a(httpURLConnection);
                return e;
            }
            finally {}
        }
        catch (final IOException ex) {
            this.c.getLogger().c(l4.ERROR, (Throwable)ex, "Error reading and logging the response stream", new Object[0]);
            this.a(httpURLConnection);
            return a0.a();
        }
        this.a(httpURLConnection);
    }
    
    private Proxy g(q4.e e) {
        if (e != null) {
            final String c = e.c();
            final String a = e.a();
            if (c != null && a != null) {
                try {
                    e = (q4.e)new Proxy(Proxy$Type.HTTP, (SocketAddress)new InetSocketAddress(a, Integer.parseInt(c)));
                    return (Proxy)e;
                }
                catch (final NumberFormatException ex) {
                    final n0 logger = this.c.getLogger();
                    final l4 error = l4.ERROR;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Failed to parse Sentry Proxy port: ");
                    sb.append(e.c());
                    sb.append(". Proxy is ignored");
                    logger.c(error, (Throwable)ex, sb.toString(), new Object[0]);
                }
            }
        }
        e = null;
        return (Proxy)e;
    }
    
    HttpURLConnection e() {
        URLConnection urlConnection;
        if (this.a == null) {
            urlConnection = this.b.b().openConnection();
        }
        else {
            urlConnection = this.b.b().openConnection(this.a);
        }
        return (HttpURLConnection)urlConnection;
    }
    
    public a0 h(final l3 l3) {
        final HttpURLConnection b = this.b();
        Label_0115: {
            final Throwable t4;
            try {
                final OutputStream outputStream = ((URLConnection)b).getOutputStream();
                try {
                    final GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
                    try {
                        this.c.getSerializer().e(l3, (OutputStream)gzipOutputStream);
                        ((OutputStream)gzipOutputStream).close();
                        if (outputStream != null) {
                            outputStream.close();
                            break Label_0115;
                        }
                        break Label_0115;
                    }
                    finally {
                        try {
                            ((OutputStream)gzipOutputStream).close();
                        }
                        finally {
                            final Throwable t;
                            ((Throwable)l3).addSuppressed(t);
                        }
                    }
                }
                finally {
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        }
                        finally {
                            final Throwable t2;
                            ((Throwable)l3).addSuppressed(t2);
                        }
                    }
                }
            }
            finally {
                final n n = this;
                final q4 q4 = n.c;
                final n0 n2 = q4.getLogger();
                final l4 l4 = io.sentry.l4.ERROR;
                final Throwable t3 = t4;
                final String s = "An exception occurred while submitting the envelope to the Sentry server.";
                final int n3 = 0;
                final Object[] array = new Object[n3];
                n2.c(l4, t3, s, array);
            }
            try {
                final n n = this;
                final q4 q4 = n.c;
                final n0 n2 = q4.getLogger();
                final l4 l4 = io.sentry.l4.ERROR;
                final Throwable t3 = t4;
                final String s = "An exception occurred while submitting the envelope to the Sentry server.";
                final int n3 = 0;
                final Object[] array = new Object[n3];
                n2.c(l4, t3, s, array);
                return this.f(b);
            }
            finally {
                this.f(b);
            }
        }
    }
    
    public void i(final HttpURLConnection httpURLConnection, final int n) {
        this.d.k(((URLConnection)httpURLConnection).getHeaderField("X-Sentry-Rate-Limits"), ((URLConnection)httpURLConnection).getHeaderField("Retry-After"), n);
    }
}
