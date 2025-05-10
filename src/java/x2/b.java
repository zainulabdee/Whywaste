package x2;

import c2.k$a;
import e2.g;
import c2.l;
import c2.k;
import kotlin.jvm.internal.u;
import kotlinx.coroutines.internal.f0;
import kotlin.coroutines.jvm.internal.h;
import e2.d;
import l2.p;

public final class b
{
    public static final <R, T> void a(final p<? super R, ? super d<? super T>, ?> p2, final R r, d<? super T> c) {
        final d a = h.a((d)c);
        try {
            final g context = ((d)c).getContext();
            c = f0.c(context, (Object)null);
            try {
                final Object invoke = ((p)u.a((Object)p2, 2)).invoke((Object)r, (Object)a);
                f0.a(context, c);
                if (invoke != f2.b.c()) {
                    a.resumeWith(k.a(invoke));
                }
            }
            finally {
                f0.a(context, c);
            }
        }
        finally {
            final k$a e = k.e;
            final Throwable t;
            a.resumeWith(k.a(l.a(t)));
        }
    }
}
