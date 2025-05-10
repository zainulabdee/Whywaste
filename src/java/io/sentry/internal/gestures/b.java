package io.sentry.internal.gestures;

import java.lang.ref.Reference;
import io.sentry.util.n;
import java.lang.ref.WeakReference;

public final class b
{
    final WeakReference<Object> a;
    final String b;
    final String c;
    final String d;
    
    public b(final Object o, final String b, final String c, final String d) {
        this.a = (WeakReference<Object>)new WeakReference(o);
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public String a() {
        return this.b;
    }
    
    public String b() {
        final String c = this.c;
        if (c != null) {
            return c;
        }
        return n.c(this.d, "UiElement.tag can't be null");
    }
    
    public String c() {
        return this.c;
    }
    
    public String d() {
        return this.d;
    }
    
    public Object e() {
        return ((Reference)this.a).get();
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && b.class == o.getClass()) {
            final b b2 = (b)o;
            if (!n.a(this.b, b2.b) || !n.a(this.c, b2.c) || !n.a(this.d, b2.d)) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return n.b(this.a, this.c, this.d);
    }
    
    public enum a
    {
        private static final a[] $VALUES;
        
        CLICKABLE, 
        SCROLLABLE;
        
        private static /* synthetic */ a[] $values() {
            return new a[] { a.CLICKABLE, a.SCROLLABLE };
        }
        
        static {
            $VALUES = $values();
        }
    }
}
