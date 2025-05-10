package u2;

import c2.q;
import l2.l;

public final class h
{
    public static final <E> f<E> a(int a, final e e, final l<? super E, q> l) {
        final int n = 1;
        final int n2 = 1;
        Object o;
        if (a != -2) {
            if (a != -1) {
                if (a != 0) {
                    if (a != Integer.MAX_VALUE) {
                        if (a == 1 && e == e.f) {
                            o = new m((l)l);
                        }
                        else {
                            o = new d(a, e, (l)l);
                        }
                    }
                    else {
                        o = new n((l)l);
                    }
                }
                else if (e == e.e) {
                    o = new r((l)l);
                }
                else {
                    o = new d(1, e, (l)l);
                }
            }
            else {
                if (e == e.e) {
                    a = n2;
                }
                else {
                    a = 0;
                }
                if (a == 0) {
                    throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
                }
                o = new m((l)l);
            }
        }
        else {
            a = n;
            if (e == e.e) {
                a = f.a.a();
            }
            o = new d(a, e, (l)l);
        }
        return (f<E>)o;
    }
}
