package io.sentry;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import java.io.Serializable;
import java.util.Queue;
import java.util.AbstractCollection;

final class f<E> extends AbstractCollection<E> implements Queue<E>, Serializable
{
    private transient E[] e;
    private transient int f;
    private transient int g;
    private transient boolean h;
    private final int i;
    
    f(final int n) {
        this.f = 0;
        this.g = 0;
        this.h = false;
        if (n > 0) {
            final Object[] e = new Object[n];
            this.e = (E[])e;
            this.i = ((E[])e).length;
            return;
        }
        throw new IllegalArgumentException("The size must be greater than 0");
    }
    
    private int q(int n) {
        if (--n < 0) {
            n = this.i - 1;
        }
        return n;
    }
    
    private int r(int n) {
        if (++n >= this.i) {
            n = 0;
        }
        return n;
    }
    
    public boolean add(final E e) {
        if (e != null) {
            if (this.s()) {
                this.remove();
            }
            final E[] e2 = this.e;
            final int g = this.g;
            final int g2 = g + 1;
            this.g = g2;
            e2[g] = e;
            if (g2 >= this.i) {
                this.g = 0;
            }
            if (this.g == this.f) {
                this.h = true;
            }
            return true;
        }
        throw new NullPointerException("Attempted to add null object to queue");
    }
    
    public void clear() {
        this.h = false;
        this.f = 0;
        this.g = 0;
        Arrays.fill((Object[])this.e, (Object)null);
    }
    
    public E element() {
        if (!this.isEmpty()) {
            return this.peek();
        }
        throw new NoSuchElementException("queue is empty");
    }
    
    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    public Iterator<E> iterator() {
        return (Iterator<E>)new Iterator<E>(this) {
            private int e = h.f;
            private int f = -1;
            private boolean g = h.h;
            final f h;
            
            public boolean hasNext() {
                return this.g || this.e != this.h.g;
            }
            
            public E next() {
                if (this.hasNext()) {
                    this.g = false;
                    final int e = this.e;
                    this.f = e;
                    this.e = this.h.r(e);
                    return this.h.e[this.f];
                }
                throw new NoSuchElementException();
            }
            
            public void remove() {
                final int f = this.f;
                if (f == -1) {
                    throw new IllegalStateException();
                }
                if (f == this.h.f) {
                    this.h.remove();
                    this.f = -1;
                    return;
                }
                int i;
                final int n = i = this.f + 1;
                if (this.h.f < this.f && (i = n) < this.h.g) {
                    System.arraycopy((Object)this.h.e, n, (Object)this.h.e, this.f, this.h.g - n);
                }
                else {
                    while (i != this.h.g) {
                        if (i >= this.h.i) {
                            this.h.e[i - 1] = this.h.e[0];
                            i = 0;
                        }
                        else {
                            this.h.e[this.h.q(i)] = this.h.e[i];
                            i = this.h.r(i);
                        }
                    }
                }
                this.f = -1;
                final f h = this.h;
                h.g = h.q(h.g);
                this.h.e[this.h.g] = null;
                this.h.h = false;
                this.e = this.h.q(this.e);
            }
        };
    }
    
    public boolean offer(final E e) {
        return this.add(e);
    }
    
    public E peek() {
        if (this.isEmpty()) {
            return null;
        }
        return this.e[this.f];
    }
    
    public E poll() {
        if (this.isEmpty()) {
            return null;
        }
        return this.remove();
    }
    
    public E remove() {
        if (!this.isEmpty()) {
            final E[] e = this.e;
            final int f = this.f;
            final E e2 = e[f];
            if (e2 != null) {
                final int f2 = f + 1;
                this.f = f2;
                e[f] = null;
                if (f2 >= this.i) {
                    this.f = 0;
                }
                this.h = false;
            }
            return e2;
        }
        throw new NoSuchElementException("queue is empty");
    }
    
    public boolean s() {
        return this.size() == this.i;
    }
    
    public int size() {
        final int g = this.g;
        final int f = this.f;
        int i;
        if (g < f) {
            i = this.i - f + g;
        }
        else if (g == f) {
            if (this.h) {
                i = this.i;
            }
            else {
                i = 0;
            }
        }
        else {
            i = g - f;
        }
        return i;
    }
}
