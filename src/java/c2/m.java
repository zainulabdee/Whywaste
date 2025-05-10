package c2;

import kotlin.jvm.internal.i;
import l2.a;
import java.io.Serializable;

final class m<T> implements e<T>, Serializable
{
    private a<? extends T> e;
    private volatile Object f;
    private final Object g;
    
    public m(final a<? extends T> e, final Object o) {
        i.e((Object)e, "initializer");
        this.e = e;
        this.f = o.a;
        Object g = o;
        if (o == null) {
            g = this;
        }
        this.g = g;
    }
    
    public boolean a() {
        return this.f != o.a;
    }
    
    public T getValue() {
        final Object f = this.f;
        final o a = o.a;
        if (f != a) {
            return (T)f;
        }
        final Object g = this.g;
        synchronized (g) {
            Object f2 = this.f;
            if (f2 == a) {
                final a<? extends T> e = this.e;
                i.b((Object)e);
                f2 = e.invoke();
                this.f = f2;
                this.e = null;
            }
            return (T)f2;
        }
    }
    
    @Override
    public String toString() {
        String value;
        if (this.a()) {
            value = String.valueOf(this.getValue());
        }
        else {
            value = "Lazy value not initialized yet.";
        }
        return value;
    }
}
