package u2;

import s2.k0;
import s2.m;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.o$b;

public final class j<E> extends s implements q<E>
{
    public final Throwable h;
    
    @Override
    public b0 A(final o$b o$b) {
        return m.a;
    }
    
    public j<E> C() {
        return this;
    }
    
    public j<E> D() {
        return this;
    }
    
    public final Throwable E() {
        Object h;
        if ((h = this.h) == null) {
            h = new k("Channel was closed");
        }
        return (Throwable)h;
    }
    
    public final Throwable F() {
        Object h;
        if ((h = this.h) == null) {
            h = new l("Channel was closed");
        }
        return (Throwable)h;
    }
    
    public void b(final E e) {
    }
    
    public b0 e(final E e, final o$b o$b) {
        return m.a;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Closed@");
        sb.append(k0.b((Object)this));
        sb.append('[');
        sb.append((Object)this.h);
        sb.append(']');
        return sb.toString();
    }
    
    @Override
    public void y() {
    }
}
