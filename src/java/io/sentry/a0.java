package io.sentry;

import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Collection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class a0
{
    private static final Map<String, Class<?>> f;
    private final Map<String, Object> a;
    private final List<b> b;
    private b c;
    private b d;
    private b e;
    
    static {
        final HashMap f2 = new HashMap();
        (f = (Map)f2).put((Object)"boolean", (Object)Boolean.class);
        ((Map)f2).put((Object)"char", (Object)Character.class);
        ((Map)f2).put((Object)"byte", (Object)Byte.class);
        ((Map)f2).put((Object)"short", (Object)Short.class);
        ((Map)f2).put((Object)"int", (Object)Integer.class);
        ((Map)f2).put((Object)"long", (Object)Long.class);
        ((Map)f2).put((Object)"float", (Object)Float.class);
        ((Map)f2).put((Object)"double", (Object)Double.class);
    }
    
    public a0() {
        this.a = (Map<String, Object>)new HashMap();
        this.b = (List<b>)new ArrayList();
        this.c = null;
        this.d = null;
        this.e = null;
    }
    
    private boolean i(final Object obj, final Class<?> clazz) {
        final Class clazz2 = (Class)a0.f.get((Object)clazz.getCanonicalName());
        return obj != null && clazz.isPrimitive() && clazz2 != null && clazz2.isInstance(obj);
    }
    
    public void a(final List<b> list) {
        if (list != null) {
            this.b.addAll((Collection)list);
        }
    }
    
    public void b() {
        synchronized (this) {
            final Iterator iterator = this.a.entrySet().iterator();
            while (iterator.hasNext()) {
                final Map$Entry map$Entry = (Map$Entry)iterator.next();
                if (map$Entry.getKey() == null || !((String)map$Entry.getKey()).startsWith("sentry:")) {
                    iterator.remove();
                }
            }
        }
    }
    
    public Object c(final String s) {
        synchronized (this) {
            return this.a.get((Object)s);
        }
    }
    
    public <T> T d(final String s, final Class<T> clazz) {
        synchronized (this) {
            final Object value = this.a.get((Object)s);
            if (clazz.isInstance(value)) {
                return (T)value;
            }
            if (this.i(value, clazz)) {
                return (T)value;
            }
            return null;
        }
    }
    
    public List<b> e() {
        return (List<b>)new ArrayList((Collection)this.b);
    }
    
    public b f() {
        return this.c;
    }
    
    public b g() {
        return this.e;
    }
    
    public b h() {
        return this.d;
    }
    
    public void j(final String s, final Object o) {
        synchronized (this) {
            this.a.put((Object)s, o);
        }
    }
    
    public void k(final b c) {
        this.c = c;
    }
    
    public void l(final b e) {
        this.e = e;
    }
    
    public void m(final b d) {
        this.d = d;
    }
}
