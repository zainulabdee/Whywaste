package io.sentry.config;

import java.util.List;
import java.util.Iterator;
import io.sentry.util.r;
import java.util.Map$Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.Locale;

final class d implements g
{
    private String g(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("SENTRY_");
        sb.append(s.replace((CharSequence)".", (CharSequence)"_").replace((CharSequence)"-", (CharSequence)"_").toUpperCase(Locale.ROOT));
        return sb.toString();
    }
    
    public Map<String, String> a(String string) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.g(string));
        sb.append("_");
        string = sb.toString();
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (final Map$Entry map$Entry : System.getenv().entrySet()) {
            final String s = (String)map$Entry.getKey();
            if (s.startsWith(string)) {
                final String e = r.e((String)map$Entry.getValue(), "\"");
                if (e == null) {
                    continue;
                }
                ((Map)concurrentHashMap).put((Object)s.substring(string.length()).toLowerCase(Locale.ROOT), (Object)e);
            }
        }
        return (Map<String, String>)concurrentHashMap;
    }
    
    public String getProperty(final String s) {
        return r.e(System.getenv(this.g(s)), "\"");
    }
}
