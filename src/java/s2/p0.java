package s2;

import l2.l;
import kotlinx.coroutines.internal.g;
import f2.b;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.internal.z;

public final class p0<T> extends z<T>
{
    private static final AtomicIntegerFieldUpdater h;
    private volatile int _decision;
    
    static {
        h = AtomicIntegerFieldUpdater.newUpdater((Class)p0.class, "_decision");
    }
    
    private final boolean E0() {
        do {
            final int decision = this._decision;
            if (decision != 0) {
                if (decision == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!p0.h.compareAndSet((Object)this, 0, 2));
        return true;
    }
    
    protected void D(final Object o) {
        this.z0(o);
    }
    
    protected void z0(final Object o) {
        if (this.E0()) {
            return;
        }
        g.c(b.b(super.g), s2.z.a(o, super.g), (l)null, 2, (Object)null);
    }
}
