package io.sentry;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;
import java.util.Currency;
import java.util.UUID;
import java.net.InetAddress;
import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;
import io.sentry.util.k;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.Locale;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class l1
{
    private final Set<Object> a;
    private final int b;
    
    l1(final int b) {
        this.a = (Set<Object>)new HashSet();
        this.b = b;
    }
    
    private List<Object> a(final Collection<?> collection, final n0 n0) {
        final ArrayList list = new ArrayList();
        final Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            ((List)list).add(this.d(iterator.next(), n0));
        }
        return (List<Object>)list;
    }
    
    private List<Object> b(final Object[] array, final n0 n0) {
        final ArrayList list = new ArrayList();
        for (int length = array.length, i = 0; i < length; ++i) {
            ((List)list).add(this.d(array[i], n0));
        }
        return (List<Object>)list;
    }
    
    private Map<String, Object> c(final Map<?, ?> map, final n0 n0) {
        final HashMap hashMap = new HashMap();
        for (final Object next : map.keySet()) {
            final Object value = map.get(next);
            if (value != null) {
                ((Map)hashMap).put((Object)next.toString(), this.d(value, n0));
            }
            else {
                ((Map)hashMap).put((Object)next.toString(), (Object)null);
            }
        }
        return (Map<String, Object>)hashMap;
    }
    
    public Object d(final Object o, n0 n0) {
        final n0 n2 = null;
        if (o == null) {
            return null;
        }
        if (o instanceof Character) {
            return o.toString();
        }
        if (o instanceof Number) {
            return o;
        }
        if (o instanceof Boolean) {
            return o;
        }
        if (o instanceof String) {
            return o;
        }
        if (o instanceof Locale) {
            return o.toString();
        }
        if (o instanceof AtomicIntegerArray) {
            return k.a((AtomicIntegerArray)o);
        }
        if (o instanceof AtomicBoolean) {
            return ((AtomicBoolean)o).get();
        }
        if (o instanceof URI) {
            return o.toString();
        }
        if (o instanceof InetAddress) {
            return o.toString();
        }
        if (o instanceof UUID) {
            return o.toString();
        }
        if (o instanceof Currency) {
            return o.toString();
        }
        if (o instanceof Calendar) {
            return k.c((Calendar)o);
        }
        if (o.getClass().isEnum()) {
            return o.toString();
        }
        if (this.a.contains(o)) {
            n0.a(l4.INFO, "Cyclic reference detected. Calling toString() on object.", new Object[0]);
            return o.toString();
        }
        this.a.add(o);
        if (this.a.size() > this.b) {
            this.a.remove(o);
            n0.a(l4.INFO, "Max depth exceeded. Calling toString() on object.", new Object[0]);
            return o.toString();
        }
        try {
            try {
                if (o.getClass().isArray()) {
                    this.b((Object[])o, n0);
                }
                else if (o instanceof Collection) {
                    this.a((Collection<?>)o, n0);
                }
                else if (o instanceof Map) {
                    this.c((Map<?, ?>)o, n0);
                }
                else {
                    if (!this.e(o, n0).isEmpty()) {}
                    o.toString();
                }
            }
            finally {}
        }
        catch (final Exception ex) {
            n0.d(l4.INFO, "Not serializing object due to throwing sub-path.", (Throwable)ex);
            n0 = n2;
        }
        this.a.remove(o);
        return n0;
        this.a.remove(o);
    }
    
    public Map<String, Object> e(final Object o, final n0 n0) {
        final Field[] declaredFields = o.getClass().getDeclaredFields();
        final HashMap hashMap = new HashMap();
        for (final Field field : declaredFields) {
            if (!Modifier.isTransient(field.getModifiers())) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    final String name = field.getName();
                    try {
                        ((AccessibleObject)field).setAccessible(true);
                        ((Map)hashMap).put((Object)name, this.d(field.get(o), n0));
                        ((AccessibleObject)field).setAccessible(false);
                    }
                    catch (final Exception ex) {
                        final l4 info = l4.INFO;
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Cannot access field ");
                        sb.append(name);
                        sb.append(".");
                        n0.a(info, sb.toString(), new Object[0]);
                    }
                }
            }
        }
        return (Map<String, Object>)hashMap;
    }
}
