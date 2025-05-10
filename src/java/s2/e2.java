package s2;

import e2.d;
import c2.q;
import kotlinx.coroutines.internal.f0;
import c2.n;
import e2.g;
import c2.j;
import kotlinx.coroutines.internal.z;

public final class e2<T> extends z<T>
{
    private ThreadLocal<j<g, Object>> h;
    
    public final boolean E0() {
        if (this.h.get() == null) {
            return false;
        }
        this.h.set((Object)null);
        return true;
    }
    
    public final void F0(final g g, final Object o) {
        this.h.set((Object)n.a((Object)g, o));
    }
    
    protected void z0(Object f) {
        final j j = (j)this.h.get();
        final Object o = null;
        if (j != null) {
            f0.a((g)j.a(), j.b());
            this.h.set((Object)null);
        }
        final Object a = s2.z.a(f, super.g);
        final d g = super.g;
        final g context = g.getContext();
        final Object c = f0.c(context, (Object)null);
        f = o;
        if (c != f0.a) {
            f = b0.f(g, context, c);
        }
        try {
            super.g.resumeWith(a);
            final q a2 = q.a;
        }
        finally {
            if (f == null || ((e2)f).E0()) {
                f0.a(context, c);
            }
        }
    }
}
