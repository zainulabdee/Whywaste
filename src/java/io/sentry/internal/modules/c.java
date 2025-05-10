package io.sentry.internal.modules;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.Enumeration;
import io.sentry.l4;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import io.sentry.util.a;
import io.sentry.n0;
import java.util.regex.Pattern;

public final class c extends d
{
    private final Pattern d;
    private final Pattern e;
    private final ClassLoader f;
    
    public c(final n0 n0) {
        this(c.class.getClassLoader(), n0);
    }
    
    c(final ClassLoader classLoader, final n0 n0) {
        super(n0);
        this.d = Pattern.compile(".*/(.+)!/META-INF/MANIFEST.MF");
        this.e = Pattern.compile("(.*?)-(\\d+\\.\\d+.*).jar");
        this.f = a.a(classLoader);
    }
    
    private c.c$a d(final String s) {
        if (s == null) {
            return null;
        }
        final Matcher matcher = this.e.matcher((CharSequence)s);
        if (matcher.matches() && matcher.groupCount() == 2) {
            return new c.c$a(matcher.group(1), matcher.group(2));
        }
        return null;
    }
    
    private List<c.c$a> e() {
        final ArrayList list = new ArrayList();
        try {
            final Enumeration resources = this.f.getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                final c.c$a d = this.d(this.f((URL)resources.nextElement()));
                if (d != null) {
                    ((List)list).add((Object)d);
                }
            }
        }
        finally {
            final Throwable t;
            super.a.d(l4.ERROR, "Unable to detect modules via manifest files.", t);
        }
        return (List<c.c$a>)list;
    }
    
    private String f(final URL url) {
        final Matcher matcher = this.d.matcher((CharSequence)url.toString());
        if (matcher.matches() && matcher.groupCount() == 1) {
            return matcher.group(1);
        }
        return null;
    }
    
    protected Map<String, String> b() {
        final HashMap hashMap = new HashMap();
        for (final c.c$a c$a : this.e()) {
            ((Map)hashMap).put((Object)c.c$a.a(c$a), (Object)c.c$a.b(c$a));
        }
        return (Map<String, String>)hashMap;
    }
}
