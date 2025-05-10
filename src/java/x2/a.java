package x2;

import l2.p;
import kotlinx.coroutines.internal.g;
import f2.b;
import c2.q;
import c2.k$a;
import c2.l;
import c2.k;
import e2.d;

public final class a
{
    private static final void a(final d<?> d, final Throwable t) {
        final k$a e = k.e;
        d.resumeWith(k.a(l.a(t)));
        throw t;
    }
    
    public static final void b(final d<? super q> d, final d<?> d2) {
        try {
            final d b = f2.b.b((d)d);
            final k$a e = k.e;
            g.c(b, k.a((Object)q.a), (l2.l)null, 2, (Object)null);
        }
        finally {
            final Throwable t;
            a(d2, t);
        }
    }
    
    public static final <R, T> void c(final p<? super R, ? super d<? super T>, ?> p4, final R r, final d<? super T> d, final l2.l<? super Throwable, q> l) {
        try {
            final d b = f2.b.b(f2.b.a((p)p4, (Object)r, (d)d));
            final k$a e = k.e;
            g.b(b, k.a((Object)q.a), (l2.l)l);
        }
        finally {
            final Throwable t;
            a(d, t);
        }
    }
}
