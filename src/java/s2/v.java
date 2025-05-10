package s2;

import kotlin.jvm.internal.e;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class v
{
    private static final AtomicIntegerFieldUpdater b;
    private volatile int _handled;
    public final Throwable a;
    
    static {
        b = AtomicIntegerFieldUpdater.newUpdater((Class)v.class, "_handled");
    }
    
    public v(final Throwable a, final boolean handled) {
        this.a = a;
        this._handled = (handled ? 1 : 0);
    }
    
    public final boolean a() {
        return this._handled != 0;
    }
    
    public final boolean b() {
        return v.b.compareAndSet((Object)this, 0, 1);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(k0.a(this));
        sb.append('[');
        sb.append((Object)this.a);
        sb.append(']');
        return sb.toString();
    }
}
