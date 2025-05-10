package s2;

import kotlinx.coroutines.internal.f;
import e2.d;

public final class n
{
    public static final <T> l<T> a(final d<? super T> d) {
        if (!(d instanceof f)) {
            return (l<T>)new l((d)d, 1);
        }
        l j = ((f)d).j();
        if (j != null) {
            if (!j.G()) {
                j = null;
            }
            if (j != null) {
                return (l<T>)j;
            }
        }
        return (l<T>)new l((d)d, 2);
    }
}
