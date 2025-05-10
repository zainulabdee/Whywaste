package d2;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import r2.d;
import l2.l;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.i;
import java.util.List;

class u extends t
{
    public static <T> T i(final List<? extends T> list) {
        i.e((Object)list, "<this>");
        if (!list.isEmpty()) {
            return (T)list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }
    
    public static <T> T j(final List<? extends T> list) {
        i.e((Object)list, "<this>");
        Object value;
        if (list.isEmpty()) {
            value = null;
        }
        else {
            value = list.get(0);
        }
        return (T)value;
    }
    
    public static final <T, A extends Appendable> A k(final Iterable<? extends T> iterable, final A a, final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final int n, final CharSequence charSequence4, final l<? super T, ? extends CharSequence> l) {
        i.e((Object)iterable, "<this>");
        i.e((Object)a, "buffer");
        i.e((Object)charSequence, "separator");
        i.e((Object)charSequence2, "prefix");
        i.e((Object)charSequence3, "postfix");
        i.e((Object)charSequence4, "truncated");
        a.append(charSequence2);
        final Iterator iterator = iterable.iterator();
        int n2 = 0;
        int n3;
        while (true) {
            n3 = n2;
            if (!iterator.hasNext()) {
                break;
            }
            final Object next = iterator.next();
            if (++n2 > 1) {
                a.append(charSequence);
            }
            if (n >= 0 && (n3 = n2) > n) {
                break;
            }
            d.a((Appendable)a, next, (l)l);
        }
        if (n >= 0 && n3 > n) {
            a.append(charSequence4);
        }
        a.append(charSequence3);
        return a;
    }
    
    public static final <T> String m(final Iterable<? extends T> iterable, final CharSequence charSequence, final CharSequence charSequence2, final CharSequence charSequence3, final int n, final CharSequence charSequence4, final l<? super T, ? extends CharSequence> l) {
        i.e((Object)iterable, "<this>");
        i.e((Object)charSequence, "separator");
        i.e((Object)charSequence2, "prefix");
        i.e((Object)charSequence3, "postfix");
        i.e((Object)charSequence4, "truncated");
        final String string = k((java.lang.Iterable<?>)iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, n, charSequence4, (l2.l<? super Object, ? extends CharSequence>)l).toString();
        i.d((Object)string, "joinTo(StringBuilder(), \u2026ed, transform).toString()");
        return string;
    }
    
    public static <T extends Comparable<? super T>> T o(final Iterable<? extends T> iterable) {
        i.e((Object)iterable, "<this>");
        final Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            return null;
        }
        Comparable comparable = (Comparable)iterator.next();
        while (iterator.hasNext()) {
            final Comparable comparable2 = (Comparable)iterator.next();
            if (comparable.compareTo((Object)comparable2) > 0) {
                comparable = comparable2;
            }
        }
        return (T)comparable;
    }
    
    public static <T> T p(final Iterable<? extends T> iterable) {
        i.e((Object)iterable, "<this>");
        if (iterable instanceof List) {
            return q((java.util.List<? extends T>)iterable);
        }
        final Iterator iterator = iterable.iterator();
        if (!iterator.hasNext()) {
            throw new NoSuchElementException("Collection is empty.");
        }
        final Object next = iterator.next();
        if (!iterator.hasNext()) {
            return (T)next;
        }
        throw new IllegalArgumentException("Collection has more than one element.");
    }
    
    public static final <T> T q(final List<? extends T> list) {
        i.e((Object)list, "<this>");
        final int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        }
        if (size == 1) {
            return (T)list.get(0);
        }
        throw new IllegalArgumentException("List has more than one element.");
    }
    
    public static final <T, C extends Collection<? super T>> C r(final Iterable<? extends T> iterable, final C c) {
        i.e((Object)iterable, "<this>");
        i.e((Object)c, "destination");
        final Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            c.add(iterator.next());
        }
        return c;
    }
    
    public static <T> List<T> s(final Iterable<? extends T> iterable) {
        i.e((Object)iterable, "<this>");
        if (iterable instanceof Collection) {
            final Collection collection = (Collection)iterable;
            final int size = collection.size();
            List list;
            if (size != 0) {
                if (size != 1) {
                    list = u((java.util.Collection<?>)collection);
                }
                else {
                    Object o;
                    if (iterable instanceof List) {
                        o = ((List)iterable).get(0);
                    }
                    else {
                        o = iterable.iterator().next();
                    }
                    list = k.a(o);
                }
            }
            else {
                list = k.b();
            }
            return (List<T>)list;
        }
        return (List<T>)k.e((List)t((java.lang.Iterable<?>)iterable));
    }
    
    public static final <T> List<T> t(final Iterable<? extends T> iterable) {
        i.e((Object)iterable, "<this>");
        if (iterable instanceof Collection) {
            return u((java.util.Collection<? extends T>)iterable);
        }
        return (List<T>)r((java.lang.Iterable<?>)iterable, (List)new ArrayList());
    }
    
    public static final <T> List<T> u(final Collection<? extends T> collection) {
        i.e((Object)collection, "<this>");
        return (List<T>)new ArrayList((Collection)collection);
    }
    
    public static <T> Set<T> v(final Iterable<? extends T> iterable) {
        i.e((Object)iterable, "<this>");
        if (iterable instanceof Collection) {
            final Collection collection = (Collection)iterable;
            final int size = collection.size();
            Set set;
            if (size != 0) {
                if (size != 1) {
                    set = r((java.lang.Iterable<?>)iterable, (Set)new LinkedHashSet(a0.a(collection.size())));
                }
                else {
                    Object o;
                    if (iterable instanceof List) {
                        o = ((List)iterable).get(0);
                    }
                    else {
                        o = iterable.iterator().next();
                    }
                    set = h0.a(o);
                }
            }
            else {
                set = g0.b();
            }
            return (Set<T>)set;
        }
        return (Set<T>)i0.c((Set)r((java.lang.Iterable<?>)iterable, (Set)new LinkedHashSet()));
    }
}
