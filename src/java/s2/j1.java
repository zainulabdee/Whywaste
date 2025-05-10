package s2;

import c2.q;
import l2.l;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

final class j1 extends n1
{
    private static final AtomicIntegerFieldUpdater j;
    private volatile int _invoked;
    private final l<Throwable, q> i;
    
    static {
        j = AtomicIntegerFieldUpdater.newUpdater((Class)j1.class, "_invoked");
    }
    
    public j1(final l<? super Throwable, q> i) {
        this.i = (l<Throwable, q>)i;
        this._invoked = 0;
    }
    
    @Override
    public void y(final Throwable t) {
        if (j1.j.compareAndSet((Object)this, 0, 1)) {
            this.i.invoke((Object)t);
        }
    }
}
