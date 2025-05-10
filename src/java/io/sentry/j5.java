package io.sentry;

import java.util.Iterator;
import java.io.Serializable;
import java.util.Collection;

class j5<E> implements Collection<E>, Serializable
{
    private final Collection<E> e;
    final Object f;
    
    j5(final Collection<E> e) {
        if (e != null) {
            this.e = e;
            this.f = this;
            return;
        }
        throw new NullPointerException("Collection must not be null.");
    }
    
    public boolean add(final E e) {
        final Object f = this.f;
        synchronized (f) {
            return this.h().add((Object)e);
        }
    }
    
    public boolean addAll(final Collection<? extends E> collection) {
        final Object f = this.f;
        synchronized (f) {
            return this.h().addAll((Collection)collection);
        }
    }
    
    public void clear() {
        final Object f = this.f;
        synchronized (f) {
            this.h().clear();
        }
    }
    
    public boolean contains(final Object o) {
        final Object f = this.f;
        synchronized (f) {
            return this.h().contains(o);
        }
    }
    
    public boolean containsAll(final Collection<?> collection) {
        final Object f = this.f;
        synchronized (f) {
            return this.h().containsAll((Collection)collection);
        }
    }
    
    protected Collection<E> h() {
        return this.e;
    }
    
    public boolean isEmpty() {
        final Object f = this.f;
        synchronized (f) {
            return this.h().isEmpty();
        }
    }
    
    public Iterator<E> iterator() {
        return (Iterator<E>)this.h().iterator();
    }
    
    public boolean remove(final Object o) {
        final Object f = this.f;
        synchronized (f) {
            return this.h().remove(o);
        }
    }
    
    public boolean removeAll(final Collection<?> collection) {
        final Object f = this.f;
        synchronized (f) {
            return this.h().removeAll((Collection)collection);
        }
    }
    
    public boolean retainAll(final Collection<?> collection) {
        final Object f = this.f;
        synchronized (f) {
            return this.h().retainAll((Collection)collection);
        }
    }
    
    public int size() {
        final Object f = this.f;
        synchronized (f) {
            return this.h().size();
        }
    }
    
    @Override
    public String toString() {
        final Object f = this.f;
        synchronized (f) {
            return this.h().toString();
        }
    }
}
