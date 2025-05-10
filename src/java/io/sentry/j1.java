package io.sentry;

import io.sentry.vendor.gson.stream.c;
import java.util.Calendar;
import java.util.Currency;
import java.util.UUID;
import java.net.InetAddress;
import java.net.URI;
import java.util.concurrent.atomic.AtomicBoolean;
import io.sentry.util.k;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.Locale;
import java.util.Arrays;
import java.util.TimeZone;
import java.util.Map;
import java.util.Date;
import java.util.Iterator;
import java.util.Collection;

public final class j1
{
    public final l1 a;
    
    public j1(final int n) {
        this.a = new l1(n);
    }
    
    private void b(final k1 k1, final n0 n0, final Collection<?> collection) {
        ((c)k1).c();
        final Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.a(k1, n0, iterator.next());
        }
        ((c)k1).g();
    }
    
    private void c(final k1 k1, final n0 n0, final Date date) {
        try {
            ((c)k1).v(j.g(date));
        }
        catch (final Exception ex) {
            n0.d(l4.ERROR, "Error when serializing Date", (Throwable)ex);
            ((c)k1).l();
        }
    }
    
    private void d(final k1 k1, final n0 n0, final Map<?, ?> map) {
        ((c)k1).d();
        for (final Object next : map.keySet()) {
            if (next instanceof String) {
                k1.y((String)next);
                this.a(k1, n0, map.get(next));
            }
        }
        ((c)k1).h();
    }
    
    private void e(final k1 k1, final n0 n0, final TimeZone timeZone) {
        try {
            ((c)k1).v(timeZone.getID());
        }
        catch (final Exception ex) {
            n0.d(l4.ERROR, "Error when serializing TimeZone", (Throwable)ex);
            ((c)k1).l();
        }
    }
    
    public void a(final k1 k1, final n0 n0, final Object o) {
        if (o == null) {
            ((c)k1).l();
        }
        else if (o instanceof Character) {
            ((c)k1).v(Character.toString((char)o));
        }
        else if (o instanceof String) {
            ((c)k1).v((String)o);
        }
        else if (o instanceof Boolean) {
            ((c)k1).w((boolean)o);
        }
        else if (o instanceof Number) {
            ((c)k1).u((Number)o);
        }
        else if (o instanceof Date) {
            this.c(k1, n0, (Date)o);
        }
        else if (o instanceof TimeZone) {
            this.e(k1, n0, (TimeZone)o);
        }
        else if (o instanceof m1) {
            ((m1)o).serialize(k1, n0);
        }
        else if (o instanceof Collection) {
            this.b(k1, n0, (Collection<?>)o);
        }
        else if (o.getClass().isArray()) {
            this.b(k1, n0, (Collection<?>)Arrays.asList((Object[])o));
        }
        else if (o instanceof Map) {
            this.d(k1, n0, (Map<?, ?>)o);
        }
        else if (o instanceof Locale) {
            ((c)k1).v(o.toString());
        }
        else if (o instanceof AtomicIntegerArray) {
            this.b(k1, n0, (Collection<?>)k.a((AtomicIntegerArray)o));
        }
        else if (o instanceof AtomicBoolean) {
            ((c)k1).w(((AtomicBoolean)o).get());
        }
        else if (o instanceof URI) {
            ((c)k1).v(o.toString());
        }
        else if (o instanceof InetAddress) {
            ((c)k1).v(o.toString());
        }
        else if (o instanceof UUID) {
            ((c)k1).v(o.toString());
        }
        else if (o instanceof Currency) {
            ((c)k1).v(o.toString());
        }
        else if (o instanceof Calendar) {
            this.d(k1, n0, k.c((Calendar)o));
        }
        else if (o.getClass().isEnum()) {
            ((c)k1).v(o.toString());
        }
        else {
            try {
                this.a(k1, n0, this.a.d(o, n0));
            }
            catch (final Exception ex) {
                n0.d(l4.ERROR, "Failed serializing unknown object.", (Throwable)ex);
                ((c)k1).v("[OBJECT]");
            }
        }
    }
}
