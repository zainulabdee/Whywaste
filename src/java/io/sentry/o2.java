package io.sentry;

import java.net.MalformedURLException;
import java.net.URI;
import io.sentry.util.n;
import java.util.Map;
import java.net.URL;

public final class o2
{
    private final URL a;
    private final Map<String, String> b;
    
    public o2(final String s, final Map<String, String> b) {
        n.c(s, "url is required");
        n.c(b, "headers is required");
        try {
            this.a = URI.create(s).toURL();
            this.b = b;
        }
        catch (final MalformedURLException ex) {
            throw new IllegalArgumentException("Failed to compose the Sentry's server URL.", (Throwable)ex);
        }
    }
    
    public Map<String, String> a() {
        return this.b;
    }
    
    public URL b() {
        return this.a;
    }
}
