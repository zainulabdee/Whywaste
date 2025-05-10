package s2;

import l2.l;
import x2.a;
import e2.f;
import x2.b;
import c2.i;
import e2.d;
import l2.p;

public enum i0
{
    e, 
    f, 
    g, 
    h;
    
    private static final i0[] i;
    
    static {
        i = d();
    }
    
    private static final /* synthetic */ i0[] d() {
        return new i0[] { i0.e, i0.f, i0.g, i0.h };
    }
    
    public final <R, T> void e(final p<? super R, ? super d<? super T>, ?> p3, final R r, final d<? super T> d) {
        final int n = a.a[this.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        throw new i();
                    }
                }
                else {
                    b.a((l2.p<? super R, ? super e2.d<? super Object>, ?>)p3, r, (e2.d<? super Object>)d);
                }
            }
            else {
                e2.f.a((p)p3, (Object)r, (d)d);
            }
        }
        else {
            x2.a.d(p3, r, d, null, 4, null);
        }
    }
    
    public final boolean f() {
        return this == i0.f;
    }
}
