package c2;

import kotlin.jvm.internal.i;
import java.io.Serializable;

public final class j<A, B> implements Serializable
{
    private final A e;
    private final B f;
    
    public j(final A e, final B f) {
        this.e = e;
        this.f = f;
    }
    
    public final A a() {
        return this.e;
    }
    
    public final B b() {
        return this.f;
    }
    
    public final A c() {
        return this.e;
    }
    
    public final B d() {
        return this.f;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof j)) {
            return false;
        }
        final j j = (j)o;
        return i.a((Object)this.e, (Object)j.e) && i.a((Object)this.f, (Object)j.f);
    }
    
    @Override
    public int hashCode() {
        final A e = this.e;
        int hashCode = 0;
        int hashCode2;
        if (e == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = e.hashCode();
        }
        final B f = this.f;
        if (f != null) {
            hashCode = f.hashCode();
        }
        return hashCode2 * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append((Object)this.e);
        sb.append(", ");
        sb.append((Object)this.f);
        sb.append(')');
        return sb.toString();
    }
}
