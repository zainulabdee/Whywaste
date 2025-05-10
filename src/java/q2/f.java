package q2;

import kotlin.jvm.internal.i;
import java.util.Iterator;

class f extends e
{
    public static <T> b<T> a(final Iterator<? extends T> iterator) {
        i.e((Object)iterator, "<this>");
        return b((q2.b<? extends T>)new b<T>(iterator) {
            final Iterator a;
            
            public Iterator<T> iterator() {
                return (Iterator<T>)this.a;
            }
        });
    }
    
    public static final <T> b<T> b(b<? extends T> a) {
        i.e((Object)a, "<this>");
        if (!(a instanceof a)) {
            a = new a((b)a);
        }
        return (b<T>)a;
    }
}
