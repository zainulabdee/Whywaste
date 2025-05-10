package e2;

import c2.q;
import c2.k;
import f2.b;
import kotlin.jvm.internal.i;
import l2.p;

public final class f
{
    public static final <R, T> void a(final p<? super R, ? super d<? super T>, ?> p3, final R r, final d<? super T> d) {
        i.e((Object)p3, "<this>");
        i.e((Object)d, "completion");
        final d b = f2.b.b(f2.b.a((p)p3, (Object)r, (d)d));
        final k.a e = k.e;
        b.resumeWith(k.a(q.a));
    }
}
