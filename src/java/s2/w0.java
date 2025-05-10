package s2;

import kotlinx.coroutines.internal.a;

public abstract class w0 extends c0
{
    private long g;
    private boolean h;
    private kotlinx.coroutines.internal.a<q0<?>> i;
    
    private final long A(final boolean b) {
        long n;
        if (b) {
            n = 4294967296L;
        }
        else {
            n = 1L;
        }
        return n;
    }
    
    public final void B(final q0<?> q0) {
        kotlinx.coroutines.internal.a i;
        if ((i = this.i) == null) {
            i = new kotlinx.coroutines.internal.a();
            this.i = (kotlinx.coroutines.internal.a<q0<?>>)i;
        }
        i.a((Object)q0);
    }
    
    protected long C() {
        final kotlinx.coroutines.internal.a<q0<?>> i = this.i;
        long n = Long.MAX_VALUE;
        if (i == null) {
            return Long.MAX_VALUE;
        }
        if (!i.c()) {
            n = 0L;
        }
        return n;
    }
    
    public final void D(final boolean b) {
        this.g += this.A(b);
        if (!b) {
            this.h = true;
        }
    }
    
    public final boolean F() {
        final long g = this.g;
        boolean b = true;
        if (g < this.A(true)) {
            b = false;
        }
        return b;
    }
    
    public final boolean G() {
        final kotlinx.coroutines.internal.a<q0<?>> i = this.i;
        return i == null || i.c();
    }
    
    public final boolean H() {
        final kotlinx.coroutines.internal.a<q0<?>> i = this.i;
        if (i == null) {
            return false;
        }
        final q0 q0 = (q0)i.d();
        if (q0 == null) {
            return false;
        }
        q0.run();
        return true;
    }
    
    public void shutdown() {
    }
    
    public final void z(final boolean b) {
        final long g = this.g - this.A(b);
        this.g = g;
        if (g > 0L) {
            return;
        }
        if (this.h) {
            this.shutdown();
        }
    }
}
