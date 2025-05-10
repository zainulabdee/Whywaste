package j;

import androidx.lifecycle.c0;
import androidx.lifecycle.a0;
import kotlin.jvm.internal.i;
import androidx.lifecycle.b0$b;

public final class b implements b0$b
{
    private final f<?>[] a;
    
    public b(final f<?>... a) {
        i.e((Object)a, "initializers");
        this.a = a;
    }
    
    public <T extends a0> T b(final Class<T> clazz, final a a) {
        i.e((Object)clazz, "modelClass");
        i.e((Object)a, "extras");
        final f<?>[] a2 = this.a;
        final int length = a2.length;
        int i = 0;
        a0 a3 = null;
        while (i < length) {
            final f<?> f = a2[i];
            if (kotlin.jvm.internal.i.a((Object)f.a(), (Object)clazz)) {
                final Object invoke = f.b().invoke(a);
                if (invoke instanceof a0) {
                    a3 = (T)invoke;
                }
                else {
                    a3 = null;
                }
            }
            ++i;
        }
        if (a3 != null) {
            return (T)a3;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("No initializer set for given class ");
        sb.append(clazz.getName());
        throw new IllegalArgumentException(sb.toString());
    }
}
