package f2;

import e2.g;
import kotlin.coroutines.jvm.internal.a;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.i;
import c2.q;
import e2.d;
import l2.p;

class c
{
    public static <R, T> d<q> a(final p<? super R, ? super d<? super T>, ?> p3, final R r, final d<? super T> d) {
        i.e((Object)p3, "<this>");
        i.e((Object)d, "completion");
        final d a = h.a((d)d);
        Object create;
        if (p3 instanceof a) {
            create = ((a)p3).create((Object)r, a);
        }
        else {
            final g context = a.getContext();
            if (context == e2.h.e) {
                create = new c$a(a, (p)p3, (Object)r);
            }
            else {
                create = new c$b(a, context, (p)p3, (Object)r);
            }
        }
        return (d<q>)create;
    }
    
    public static <T> d<T> b(final d<? super T> d) {
        i.e((Object)d, "<this>");
        kotlin.coroutines.jvm.internal.d d2;
        if (d instanceof kotlin.coroutines.jvm.internal.d) {
            d2 = (kotlin.coroutines.jvm.internal.d)d;
        }
        else {
            d2 = null;
        }
        d<T> intercepted = (d<T>)d;
        if (d2 != null) {
            intercepted = d2.intercepted();
            if (intercepted == null) {
                intercepted = (d<T>)d;
            }
        }
        return intercepted;
    }
}
