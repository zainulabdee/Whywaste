package io.sentry;

import io.sentry.util.n;
import java.net.URI;

final class p
{
    private final String a;
    private final String b;
    private final String c;
    private final String d;
    private final URI e;
    
    p(String b) {
        try {
            n.c(b, "The DSN is required.");
            final URI normalize = new URI(b).normalize();
            b = normalize.getUserInfo();
            if (b == null || b.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            final String[] split = b.split(":", -1);
            b = split[0];
            this.d = b;
            if (b == null || b.isEmpty()) {
                throw new IllegalArgumentException("Invalid DSN: No public key provided.");
            }
            if (split.length > 1) {
                b = split[1];
            }
            else {
                b = null;
            }
            this.c = b;
            String s;
            b = (s = normalize.getPath());
            if (b.endsWith("/")) {
                s = b.substring(0, b.length() - 1);
            }
            final int n = s.lastIndexOf("/") + 1;
            final String s2 = b = s.substring(0, n);
            if (!s2.endsWith("/")) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s2);
                sb.append("/");
                b = sb.toString();
            }
            this.b = b;
            final String substring = s.substring(n);
            this.a = substring;
            if (!substring.isEmpty()) {
                final String scheme = normalize.getScheme();
                final String host = normalize.getHost();
                final int port = normalize.getPort();
                final StringBuilder sb2 = new StringBuilder();
                sb2.append(b);
                sb2.append("api/");
                sb2.append(substring);
                this.e = new URI(scheme, (String)null, host, port, sb2.toString(), (String)null, (String)null);
                return;
            }
            throw new IllegalArgumentException("Invalid DSN: A Project Id is required.");
        }
        finally {
            final Throwable t;
            throw new IllegalArgumentException(t);
        }
    }
    
    public String a() {
        return this.d;
    }
    
    public String b() {
        return this.c;
    }
    
    URI c() {
        return this.e;
    }
}
