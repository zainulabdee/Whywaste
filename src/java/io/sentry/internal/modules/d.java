package io.sentry.internal.modules;

import java.io.IOException;
import io.sentry.l4;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;
import java.io.InputStream;
import java.util.Map;
import io.sentry.n0;
import java.nio.charset.Charset;

public abstract class d implements b
{
    private static final Charset c;
    protected final n0 a;
    private Map<String, String> b;
    
    static {
        c = Charset.forName("UTF-8");
    }
    
    public d(final n0 a) {
        this.b = null;
        this.a = a;
    }
    
    public Map<String, String> a() {
        final Map<String, String> b = this.b;
        if (b != null) {
            return b;
        }
        return this.b = this.b();
    }
    
    protected abstract Map<String, String> b();
    
    protected Map<String, String> c(final InputStream inputStream) {
        final TreeMap treeMap = new TreeMap();
        try {
            final BufferedReader bufferedReader = new BufferedReader((Reader)new InputStreamReader(inputStream, d.c));
            try {
                for (String s = bufferedReader.readLine(); s != null; s = bufferedReader.readLine()) {
                    final int lastIndex = s.lastIndexOf(58);
                    ((Map)treeMap).put((Object)s.substring(0, lastIndex), (Object)s.substring(lastIndex + 1));
                }
                this.a.a(l4.DEBUG, "Extracted %d modules from resources.", new Object[] { ((Map)treeMap).size() });
                bufferedReader.close();
            }
            finally {
                try {
                    bufferedReader.close();
                }
                finally {
                    final Throwable t;
                    ((Throwable)inputStream).addSuppressed(t);
                }
            }
        }
        catch (final RuntimeException ex) {
            this.a.c(l4.ERROR, (Throwable)ex, "%s file is malformed.", new Object[] { "sentry-external-modules.txt" });
        }
        catch (final IOException ex2) {
            this.a.d(l4.ERROR, "Error extracting modules.", (Throwable)ex2);
        }
        return (Map<String, String>)treeMap;
    }
}
