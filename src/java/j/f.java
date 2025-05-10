package j;

import kotlin.jvm.internal.i;
import l2.l;
import androidx.lifecycle.a0;

public final class f<T extends a0>
{
    private final Class<T> a;
    private final l<a, T> b;
    
    public f(final Class<T> a, final l<? super a, ? extends T> b) {
        i.e((Object)a, "clazz");
        i.e((Object)b, "initializer");
        this.a = a;
        this.b = (l<a, T>)b;
    }
    
    public final Class<T> a() {
        return this.a;
    }
    
    public final l<a, T> b() {
        return this.b;
    }
}
