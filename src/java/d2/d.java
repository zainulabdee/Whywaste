package d2;

import java.util.NoSuchElementException;
import java.util.List;
import java.util.Iterator;
import java.util.Collection;
import kotlin.jvm.internal.e;

public final class d<E> extends c<E>
{
    public static final d.d$a h;
    private static final Object[] i;
    private int e;
    private Object[] f;
    private int g;
    
    static {
        h = new d.d$a((e)null);
        i = new Object[0];
    }
    
    public d() {
        this.f = d.i;
    }
    
    private final void j(int n, final Collection<? extends E> collection) {
        Iterator iterator;
        for (iterator = collection.iterator(); n < this.f.length && iterator.hasNext(); ++n) {
            this.f[n] = iterator.next();
        }
        for (n = 0; n < this.e && iterator.hasNext(); ++n) {
            this.f[n] = iterator.next();
        }
        this.g = this.size() + collection.size();
    }
    
    private final void k(int e) {
        final Object[] f = new Object[e];
        final Object[] f2 = this.f;
        d2.h.c(f2, f, 0, this.e, f2.length);
        final Object[] f3 = this.f;
        final int length = f3.length;
        e = this.e;
        d2.h.c(f3, f, length - e, 0, e);
        this.e = 0;
        this.f = f;
    }
    
    private final int l(int h) {
        if (h == 0) {
            h = d2.i.h(this.f);
        }
        else {
            --h;
        }
        return h;
    }
    
    private final void m(final int n) {
        if (n < 0) {
            throw new IllegalStateException("Deque is too big.");
        }
        final Object[] f = this.f;
        if (n <= f.length) {
            return;
        }
        if (f == d.i) {
            this.f = new Object[o2.d.a(n, 10)];
            return;
        }
        this.k(d.h.a(f.length, n));
    }
    
    private final int n(int n) {
        if (n == d2.i.h(this.f)) {
            n = 0;
        }
        else {
            ++n;
        }
        return n;
    }
    
    private final int o(final int n) {
        int n2 = n;
        if (n < 0) {
            n2 = n + this.f.length;
        }
        return n2;
    }
    
    private final int p(final int n) {
        final Object[] f = this.f;
        int n2 = n;
        if (n >= f.length) {
            n2 = n - f.length;
        }
        return n2;
    }
    
    public void add(int e, final E e2) {
        b.e.b(e, this.size());
        if (e == this.size()) {
            this.addLast(e2);
            return;
        }
        if (e == 0) {
            this.addFirst(e2);
            return;
        }
        this.m(this.size() + 1);
        final int p2 = this.p(this.e + e);
        if (e < this.size() + 1 >> 1) {
            final int l = this.l(p2);
            e = this.l(this.e);
            final int e3 = this.e;
            if (l >= e3) {
                final Object[] f = this.f;
                f[e] = f[e3];
                d2.h.c(f, f, e3, e3 + 1, l + 1);
            }
            else {
                final Object[] f2 = this.f;
                d2.h.c(f2, f2, e3 - 1, e3, f2.length);
                final Object[] f3 = this.f;
                f3[f3.length - 1] = f3[0];
                d2.h.c(f3, f3, 0, 1, l + 1);
            }
            this.f[l] = e2;
            this.e = e;
        }
        else {
            e = this.p(this.e + this.size());
            if (p2 < e) {
                final Object[] f4 = this.f;
                d2.h.c(f4, f4, p2 + 1, p2, e);
            }
            else {
                final Object[] f5 = this.f;
                d2.h.c(f5, f5, 1, 0, e);
                final Object[] f6 = this.f;
                f6[0] = f6[f6.length - 1];
                d2.h.c(f6, f6, p2 + 1, p2, f6.length - 1);
            }
            this.f[p2] = e2;
        }
        this.g = this.size() + 1;
    }
    
    public boolean add(final E e) {
        this.addLast(e);
        return true;
    }
    
    public boolean addAll(int e, final Collection<? extends E> collection) {
        kotlin.jvm.internal.i.e((Object)collection, "elements");
        b.e.b(e, this.size());
        if (collection.isEmpty()) {
            return false;
        }
        if (e == this.size()) {
            return this.addAll(collection);
        }
        this.m(this.size() + collection.size());
        final int p2 = this.p(this.e + this.size());
        final int p3 = this.p(this.e + e);
        final int size = collection.size();
        if (e < this.size() + 1 >> 1) {
            final int e2 = this.e;
            e = e2 - size;
            if (p3 >= e2) {
                if (e >= 0) {
                    final Object[] f = this.f;
                    d2.h.c(f, f, e, e2, p3);
                }
                else {
                    final Object[] f2 = this.f;
                    e += f2.length;
                    final int n = f2.length - e;
                    if (n >= p3 - e2) {
                        d2.h.c(f2, f2, e, e2, p3);
                    }
                    else {
                        d2.h.c(f2, f2, e, e2, e2 + n);
                        final Object[] f3 = this.f;
                        d2.h.c(f3, f3, 0, this.e + n, p3);
                    }
                }
            }
            else {
                final Object[] f4 = this.f;
                d2.h.c(f4, f4, e, e2, f4.length);
                if (size >= p3) {
                    final Object[] f5 = this.f;
                    d2.h.c(f5, f5, f5.length - size, 0, p3);
                }
                else {
                    final Object[] f6 = this.f;
                    d2.h.c(f6, f6, f6.length - size, 0, size);
                    final Object[] f7 = this.f;
                    d2.h.c(f7, f7, 0, size, p3);
                }
            }
            this.e = e;
            this.j(this.o(p3 - size), collection);
        }
        else {
            e = p3 + size;
            if (p3 < p2) {
                final int n2 = size + p2;
                final Object[] f8 = this.f;
                if (n2 <= f8.length) {
                    d2.h.c(f8, f8, e, p3, p2);
                }
                else if (e >= f8.length) {
                    d2.h.c(f8, f8, e - f8.length, p3, p2);
                }
                else {
                    final int n3 = p2 - (n2 - f8.length);
                    d2.h.c(f8, f8, 0, n3, p2);
                    final Object[] f9 = this.f;
                    d2.h.c(f9, f9, e, p3, n3);
                }
            }
            else {
                final Object[] f10 = this.f;
                d2.h.c(f10, f10, size, 0, p2);
                final Object[] f11 = this.f;
                if (e >= f11.length) {
                    d2.h.c(f11, f11, e - f11.length, p3, f11.length);
                }
                else {
                    d2.h.c(f11, f11, 0, f11.length - size, f11.length);
                    final Object[] f12 = this.f;
                    d2.h.c(f12, f12, e, p3, f12.length - size);
                }
            }
            this.j(p3, collection);
        }
        return true;
    }
    
    public boolean addAll(final Collection<? extends E> collection) {
        kotlin.jvm.internal.i.e((Object)collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        this.m(this.size() + collection.size());
        this.j(this.p(this.e + this.size()), collection);
        return true;
    }
    
    public final void addFirst(final E e) {
        this.m(this.size() + 1);
        final int l = this.l(this.e);
        this.e = l;
        this.f[l] = e;
        this.g = this.size() + 1;
    }
    
    public final void addLast(final E e) {
        this.m(this.size() + 1);
        this.f[this.p(this.e + this.size())] = e;
        this.g = this.size() + 1;
    }
    
    public void clear() {
        final int p = this.p(this.e + this.size());
        final int e = this.e;
        if (e < p) {
            d2.e.e(this.f, (Object)null, e, p);
        }
        else if (((Collection)this).isEmpty() ^ true) {
            final Object[] f = this.f;
            d2.e.e(f, (Object)null, this.e, f.length);
            d2.e.e(this.f, (Object)null, 0, p);
        }
        this.e = 0;
        this.g = 0;
    }
    
    public boolean contains(final Object o) {
        return this.indexOf(o) != -1;
    }
    
    public E get(final int n) {
        b.e.a(n, this.size());
        return (E)this.f[this.p(this.e + n)];
    }
    
    public int h() {
        return this.g;
    }
    
    public E i(int n) {
        b.e.a(n, this.size());
        if (n == k.c((List)this)) {
            return this.removeLast();
        }
        if (n == 0) {
            return this.removeFirst();
        }
        final int p = this.p(this.e + n);
        final Object o = this.f[p];
        if (n < this.size() >> 1) {
            n = this.e;
            if (p >= n) {
                final Object[] f = this.f;
                d2.h.c(f, f, n + 1, n, p);
            }
            else {
                final Object[] f2 = this.f;
                d2.h.c(f2, f2, 1, 0, p);
                final Object[] f3 = this.f;
                f3[0] = f3[f3.length - 1];
                n = this.e;
                d2.h.c(f3, f3, n + 1, n, f3.length - 1);
            }
            final Object[] f4 = this.f;
            n = this.e;
            f4[n] = null;
            this.e = this.n(n);
        }
        else {
            n = this.p(this.e + k.c((List)this));
            if (p <= n) {
                final Object[] f5 = this.f;
                d2.h.c(f5, f5, p, p + 1, n + 1);
            }
            else {
                final Object[] f6 = this.f;
                d2.h.c(f6, f6, p, p + 1, f6.length);
                final Object[] f7 = this.f;
                f7[f7.length - 1] = f7[0];
                d2.h.c(f7, f7, 0, 1, n + 1);
            }
            this.f[n] = null;
        }
        this.g = this.size() - 1;
        return (E)o;
    }
    
    public int indexOf(final Object o) {
        final int p = this.p(this.e + this.size());
        int i = this.e;
        if (i < p) {
            while (i < p) {
                if (kotlin.jvm.internal.i.a(o, this.f[i])) {
                    final int n = this.e;
                    return i - n;
                }
                ++i;
            }
            return -1;
        }
        if (i >= p) {
            while (i < this.f.length) {
                if (kotlin.jvm.internal.i.a(o, this.f[i])) {
                    final int n = this.e;
                    return i - n;
                }
                ++i;
            }
            for (int j = 0; j < p; ++j) {
                if (kotlin.jvm.internal.i.a(o, this.f[j])) {
                    i = j + this.f.length;
                    final int n = this.e;
                    return i - n;
                }
            }
            return -1;
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    public int lastIndexOf(final Object o) {
        int n = this.p(this.e + this.size());
        final int e = this.e;
        int n2;
        if (e < n) {
            --n;
            if (e > n) {
                return -1;
            }
            while (!kotlin.jvm.internal.i.a(o, this.f[n])) {
                if (n == e) {
                    return -1;
                }
                --n;
            }
            n2 = this.e;
        }
        else {
            if (e <= n) {
                return -1;
            }
            --n;
            while (-1 < n) {
                if (kotlin.jvm.internal.i.a(o, this.f[n])) {
                    n += this.f.length;
                    n2 = this.e;
                    return n - n2;
                }
                --n;
            }
            n = d2.i.h(this.f);
            final int e2 = this.e;
            if (e2 > n) {
                return -1;
            }
            while (!kotlin.jvm.internal.i.a(o, this.f[n])) {
                if (n == e2) {
                    return -1;
                }
                --n;
            }
            n2 = this.e;
        }
        return n - n2;
    }
    
    public boolean remove(final Object o) {
        final int index = this.indexOf(o);
        if (index == -1) {
            return false;
        }
        this.remove(index);
        return true;
    }
    
    public boolean removeAll(final Collection<?> collection) {
        kotlin.jvm.internal.i.e((Object)collection, "elements");
        final boolean empty = this.isEmpty();
        final int n = 0;
        final boolean b = false;
        int n2 = 0;
        boolean b2 = b;
        if (!empty) {
            if (this.f.length == 0) {
                b2 = b;
            }
            else {
                final int p = this.p(this.e + this.size());
                int i = this.e;
                int n4;
                if (i < p) {
                    int n3 = i;
                    while (i < p) {
                        final Object o = this.f[i];
                        if (collection.contains(o) ^ true) {
                            this.f[n3] = o;
                            ++n3;
                        }
                        else {
                            n2 = 1;
                        }
                        ++i;
                    }
                    d2.e.e(this.f, (Object)null, n3, p);
                    n4 = n3;
                }
                else {
                    final int length = this.f.length;
                    int n5 = i;
                    n2 = 0;
                    while (i < length) {
                        final Object[] f = this.f;
                        final Object o2 = f[i];
                        f[i] = null;
                        if (collection.contains(o2) ^ true) {
                            this.f[n5] = o2;
                            ++n5;
                        }
                        else {
                            n2 = 1;
                        }
                        ++i;
                    }
                    n4 = this.p(n5);
                    for (int j = n; j < p; ++j) {
                        final Object[] f2 = this.f;
                        final Object o3 = f2[j];
                        f2[j] = null;
                        if (collection.contains(o3) ^ true) {
                            this.f[n4] = o3;
                            n4 = this.n(n4);
                        }
                        else {
                            n2 = 1;
                        }
                    }
                }
                b2 = (n2 != 0);
                if (n2 != 0) {
                    this.g = this.o(n4 - this.e);
                    b2 = (n2 != 0);
                }
            }
        }
        return b2;
    }
    
    public final E removeFirst() {
        if (!this.isEmpty()) {
            final Object[] f = this.f;
            final int e = this.e;
            final Object o = f[e];
            f[e] = null;
            this.e = this.n(e);
            this.g = this.size() - 1;
            return (E)o;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }
    
    public final E removeLast() {
        if (!this.isEmpty()) {
            final int p = this.p(this.e + k.c((List)this));
            final Object[] f = this.f;
            final Object o = f[p];
            f[p] = null;
            this.g = this.size() - 1;
            return (E)o;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }
    
    public boolean retainAll(final Collection<?> collection) {
        kotlin.jvm.internal.i.e((Object)collection, "elements");
        final boolean empty = this.isEmpty();
        final int n = 0;
        final boolean b = false;
        final int n2 = 0;
        int n3 = b ? 1 : 0;
        if (!empty) {
            if (this.f.length == 0) {
                n3 = (b ? 1 : 0);
            }
            else {
                final int p = this.p(this.e + this.size());
                int i = this.e;
                int n5;
                int n6;
                if (i < p) {
                    int n4 = i;
                    n5 = n2;
                    while (i < p) {
                        final Object o = this.f[i];
                        if (collection.contains(o)) {
                            this.f[n4] = o;
                            ++n4;
                        }
                        else {
                            n5 = 1;
                        }
                        ++i;
                    }
                    d2.e.e(this.f, (Object)null, n4, p);
                    n6 = n4;
                }
                else {
                    final int length = this.f.length;
                    int n7 = i;
                    n5 = 0;
                    while (i < length) {
                        final Object[] f = this.f;
                        final Object o2 = f[i];
                        f[i] = null;
                        if (collection.contains(o2)) {
                            this.f[n7] = o2;
                            ++n7;
                        }
                        else {
                            n5 = 1;
                        }
                        ++i;
                    }
                    n6 = this.p(n7);
                    for (int j = n; j < p; ++j) {
                        final Object[] f2 = this.f;
                        final Object o3 = f2[j];
                        f2[j] = null;
                        if (collection.contains(o3)) {
                            this.f[n6] = o3;
                            n6 = this.n(n6);
                        }
                        else {
                            n5 = 1;
                        }
                    }
                }
                n3 = n5;
                if (n5 != 0) {
                    this.g = this.o(n6 - this.e);
                    n3 = n5;
                }
            }
        }
        return n3 != 0;
    }
    
    public E set(int p2, final E e) {
        b.e.a(p2, this.size());
        p2 = this.p(this.e + p2);
        final Object[] f = this.f;
        final Object o = f[p2];
        f[p2] = e;
        return (E)o;
    }
    
    public Object[] toArray() {
        return this.toArray(new Object[this.size()]);
    }
    
    public <T> T[] toArray(T[] a) {
        kotlin.jvm.internal.i.e((Object)a, "array");
        if (a.length < this.size()) {
            a = (T[])d2.f.a((Object[])a, this.size());
        }
        final int p = this.p(this.e + this.size());
        final int e = this.e;
        if (e < p) {
            d2.e.d(this.f, (Object[])a, 0, e, p, 2, (Object)null);
        }
        else if (((Collection)this).isEmpty() ^ true) {
            final Object[] f = this.f;
            d2.h.c(f, (Object[])a, 0, this.e, f.length);
            final Object[] f2 = this.f;
            d2.h.c(f2, (Object[])a, f2.length - this.e, 0, p);
        }
        if (a.length > this.size()) {
            a[this.size()] = null;
        }
        return a;
    }
}
