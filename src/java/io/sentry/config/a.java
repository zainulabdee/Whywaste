package io.sentry.config;

import java.util.Hashtable;
import java.util.List;
import java.util.Iterator;
import io.sentry.util.r;
import java.util.Map$Entry;
import java.util.HashMap;
import java.util.Map;
import io.sentry.util.n;
import java.util.Properties;

abstract class a implements g
{
    private final String a;
    private final Properties b;
    
    protected a(final String s, final Properties properties) {
        this.a = (String)n.c((Object)s, "prefix is required");
        this.b = (Properties)n.c((Object)properties, "properties are required");
    }
    
    protected a(final Properties properties) {
        this("", properties);
    }
    
    public Map<String, String> a(String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(s);
        sb.append(".");
        final String string = sb.toString();
        final HashMap hashMap = new HashMap();
        for (final Map$Entry map$Entry : ((Hashtable)this.b).entrySet()) {
            if (map$Entry.getKey() instanceof String && map$Entry.getValue() instanceof String) {
                s = (String)map$Entry.getKey();
                if (!s.startsWith(string)) {
                    continue;
                }
                ((Map)hashMap).put((Object)s.substring(string.length()), (Object)r.e((String)map$Entry.getValue(), "\""));
            }
        }
        return (Map<String, String>)hashMap;
    }
    
    public String getProperty(final String s) {
        final Properties b = this.b;
        final StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(s);
        return r.e(b.getProperty(sb.toString()), "\"");
    }
}
