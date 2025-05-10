package io.sentry.internal.modules;

import java.io.InputStream;
import io.sentry.l4;
import java.util.TreeMap;
import java.util.Map;
import io.sentry.util.a;
import io.sentry.n0;

public final class f extends d
{
    private final ClassLoader d;
    
    public f(final n0 n0) {
        this(n0, f.class.getClassLoader());
    }
    
    f(final n0 n0, final ClassLoader classLoader) {
        super(n0);
        this.d = a.a(classLoader);
    }
    
    protected Map<String, String> b() {
        final TreeMap treeMap = new TreeMap();
        try {
            final InputStream resourceAsStream = this.d.getResourceAsStream("sentry-external-modules.txt");
            if (resourceAsStream == null) {
                super.a.a(l4.INFO, "%s file was not found.", new Object[] { "sentry-external-modules.txt" });
                return (Map<String, String>)treeMap;
            }
            return (Map<String, String>)this.c(resourceAsStream);
        }
        catch (final SecurityException ex) {
            super.a.d(l4.INFO, "Access to resources denied.", (Throwable)ex);
            return (Map<String, String>)treeMap;
        }
    }
}
