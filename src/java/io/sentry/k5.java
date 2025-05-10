package io.sentry;

import java.util.Collection;
import java.util.Queue;

final class k5<E> extends j5<E> implements Queue<E>
{
    private k5(final Queue<E> queue) {
        super((Collection)queue);
    }
    
    static <E> k5<E> j(final Queue<E> queue) {
        return new k5<E>(queue);
    }
    
    public E element() {
        final Object f = super.f;
        synchronized (f) {
            return (E)this.i().element();
        }
    }
    
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        final Object f = super.f;
        synchronized (f) {
            return this.i().equals(obj);
        }
    }
    
    public int hashCode() {
        final Object f = super.f;
        synchronized (f) {
            return this.i().hashCode();
        }
    }
    
    protected Queue<E> i() {
        return (Queue<E>)super.h();
    }
    
    public boolean offer(final E e) {
        final Object f = super.f;
        synchronized (f) {
            return this.i().offer((Object)e);
        }
    }
    
    public E peek() {
        final Object f = super.f;
        synchronized (f) {
            return (E)this.i().peek();
        }
    }
    
    public E poll() {
        final Object f = super.f;
        synchronized (f) {
            return (E)this.i().poll();
        }
    }
    
    public E remove() {
        final Object f = super.f;
        synchronized (f) {
            return (E)this.i().remove();
        }
    }
    
    public Object[] toArray() {
        final Object f = super.f;
        synchronized (f) {
            return ((Collection)this.i()).toArray();
        }
    }
    
    public <T> T[] toArray(final T[] array) {
        final Object f = super.f;
        synchronized (f) {
            return (T[])((Collection)this.i()).toArray((Object[])array);
        }
    }
}
