package q2;

import java.util.Iterator;
import kotlin.jvm.internal.i;
import java.util.concurrent.atomic.AtomicReference;

public final class a<T> implements b<T>
{
    private final AtomicReference<b<T>> a;
    
    public a(final b<? extends T> b) {
        i.e((Object)b, "sequence");
        this.a = (AtomicReference<b<T>>)new AtomicReference((Object)b);
    }
    
    public Iterator<T> iterator() {
        final b b = (b)this.a.getAndSet((Object)null);
        if (b != null) {
            return (Iterator<T>)b.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
