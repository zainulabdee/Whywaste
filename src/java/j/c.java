package j;

import java.util.Collection;
import java.util.Arrays;
import androidx.lifecycle.b0$b;
import kotlin.jvm.internal.i;
import androidx.lifecycle.a0;
import l2.l;
import java.util.ArrayList;
import java.util.List;

public final class c
{
    private final List<f<?>> a;
    
    public c() {
        this.a = (List<f<?>>)new ArrayList();
    }
    
    public final <T extends a0> void a(final p2.c<T> c, final l<? super a, ? extends T> l) {
        i.e((Object)c, "clazz");
        i.e((Object)l, "initializer");
        this.a.add((Object)new f(k2.a.a((p2.c<a0>)c), l));
    }
    
    public final b0$b b() {
        final f[] array = (f[])((Collection)this.a).toArray((Object[])new f[0]);
        return (b0$b)new b((f[])Arrays.copyOf((Object[])array, array.length));
    }
}
