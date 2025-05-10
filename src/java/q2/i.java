package q2;

import java.util.Iterator;
import l2.l;

public final class i<T, R> implements b<R>
{
    private final b<T> a;
    private final l<T, R> b;
    
    public i(final b<? extends T> a, final l<? super T, ? extends R> b) {
        kotlin.jvm.internal.i.e((Object)a, "sequence");
        kotlin.jvm.internal.i.e((Object)b, "transformer");
        this.a = (b<T>)a;
        this.b = (l<T, R>)b;
    }
    
    public Iterator<R> iterator() {
        return (Iterator<R>)new i$a(this);
    }
}
