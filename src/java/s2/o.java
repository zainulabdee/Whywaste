package s2;

import java.util.concurrent.CancellationException;
import e2.d;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class o extends v
{
    private static final AtomicIntegerFieldUpdater c;
    private volatile int _resumed;
    
    static {
        c = AtomicIntegerFieldUpdater.newUpdater((Class)o.class, "_resumed");
    }
    
    public o(final d<?> d, final Throwable t, final boolean b) {
        Object o = t;
        if (t == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Continuation ");
            sb.append((Object)d);
            sb.append(" was cancelled normally");
            o = new CancellationException(sb.toString());
        }
        super((Throwable)o, b);
        this._resumed = 0;
    }
    
    public final boolean c() {
        return o.c.compareAndSet((Object)this, 0, 1);
    }
}
