package s2;

import kotlin.jvm.internal.e;
import c2.q;
import l2.l;

final class u
{
    public final Object a;
    public final i b;
    public final l<Throwable, q> c;
    public final Object d;
    public final Throwable e;
    
    public u(final Object a, final i b, final l<? super Throwable, q> c, final Object d, final Throwable e) {
        this.a = a;
        this.b = b;
        this.c = (l<Throwable, q>)c;
        this.d = d;
        this.e = e;
    }
    
    public final u a(final Object o, final i i, final l<? super Throwable, q> l, final Object o2, final Throwable t) {
        return new u(o, i, l, o2, t);
    }
    
    public final boolean c() {
        return this.e != null;
    }
    
    public final void d(final s2.l<?> l, final Throwable t) {
        final i b = this.b;
        if (b != null) {
            l.l(b, t);
        }
        final l<Throwable, q> c = this.c;
        if (c != null) {
            l.m((l)c, t);
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof u)) {
            return false;
        }
        final u u = (u)o;
        return kotlin.jvm.internal.i.a(this.a, u.a) && kotlin.jvm.internal.i.a((Object)this.b, (Object)u.b) && kotlin.jvm.internal.i.a((Object)this.c, (Object)u.c) && kotlin.jvm.internal.i.a(this.d, u.d) && kotlin.jvm.internal.i.a((Object)this.e, (Object)u.e);
    }
    
    @Override
    public int hashCode() {
        final Object a = this.a;
        int hashCode = 0;
        int hashCode2;
        if (a == null) {
            hashCode2 = 0;
        }
        else {
            hashCode2 = a.hashCode();
        }
        final i b = this.b;
        int hashCode3;
        if (b == null) {
            hashCode3 = 0;
        }
        else {
            hashCode3 = b.hashCode();
        }
        final l<Throwable, q> c = this.c;
        int hashCode4;
        if (c == null) {
            hashCode4 = 0;
        }
        else {
            hashCode4 = c.hashCode();
        }
        final Object d = this.d;
        int hashCode5;
        if (d == null) {
            hashCode5 = 0;
        }
        else {
            hashCode5 = d.hashCode();
        }
        final Throwable e = this.e;
        if (e != null) {
            hashCode = e.hashCode();
        }
        return (((hashCode2 * 31 + hashCode3) * 31 + hashCode4) * 31 + hashCode5) * 31 + hashCode;
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CompletedContinuation(result=");
        sb.append(this.a);
        sb.append(", cancelHandler=");
        sb.append((Object)this.b);
        sb.append(", onCancellation=");
        sb.append((Object)this.c);
        sb.append(", idempotentResume=");
        sb.append(this.d);
        sb.append(", cancelCause=");
        sb.append((Object)this.e);
        sb.append(')');
        return sb.toString();
    }
}
