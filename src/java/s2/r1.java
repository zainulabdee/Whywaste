package s2;

import kotlin.jvm.internal.i;

public abstract class r1 extends x implements u0, g1
{
    public s1 h;
    
    public final void A(final s1 h) {
        this.h = h;
    }
    
    public boolean a() {
        return true;
    }
    
    public void d() {
        this.z().n0(this);
    }
    
    public w1 h() {
        return null;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(k0.a((Object)this));
        sb.append('@');
        sb.append(k0.b((Object)this));
        sb.append("[job@");
        sb.append(k0.b((Object)this.z()));
        sb.append(']');
        return sb.toString();
    }
    
    public final s1 z() {
        final s1 h = this.h;
        if (h != null) {
            return h;
        }
        i.o("job");
        return null;
    }
}
