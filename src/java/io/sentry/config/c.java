package io.sentry.config;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;
import java.util.List;

final class c implements g
{
    private final List<g> a;
    
    public c(final List<g> a) {
        this.a = a;
    }
    
    public Map<String, String> a(final String s) {
        final ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            ((Map)concurrentHashMap).putAll(((g)iterator.next()).a(s));
        }
        return (Map<String, String>)concurrentHashMap;
    }
    
    public String getProperty(final String s) {
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            final String property = ((g)iterator.next()).getProperty(s);
            if (property != null) {
                return property;
            }
        }
        return null;
    }
}
