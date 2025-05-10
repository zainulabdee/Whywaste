package s2;

import kotlin.jvm.internal.i;
import c2.q;
import l2.l;

public final class w
{
    public final Object a;
    public final l<Throwable, q> b;
    
    public w(final Object a, final l<? super Throwable, q> b) {
        this.a = a;
        this.b = (l<Throwable, q>)b;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof w)) {
            return false;
        }
        final w w = (w)o;
        return i.a(this.a, w.a) && i.a((Object)this.b, (Object)w.b);
    }
    
    @Override
    public int hashCode() {
        final Object a = this.a;
        int hashCode;
        if (a == null) {
            hashCode = 0;
        }
        else {
            hashCode = a.hashCode();
        }
        return hashCode * 31 + this.b.hashCode();
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CompletedWithCancellation(result=");
        sb.append(this.a);
        sb.append(", onCancellation=");
        sb.append((Object)this.b);
        sb.append(')');
        return sb.toString();
    }
}
