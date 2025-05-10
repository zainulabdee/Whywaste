package s2;

import c2.k$a;
import c2.q;
import kotlinx.coroutines.internal.f0;
import c2.l;
import c2.k;
import e2.g;
import e2.d;
import kotlinx.coroutines.internal.f;

public final class r0
{
    public static final <T> void a(final q0<? super T> q0, final int n) {
        final d b = q0.b();
        final boolean b2 = n == 4;
        if (!b2 && b instanceof f && b(n) == b(q0.g)) {
            final c0 h = ((f)b).h;
            final g context = b.getContext();
            if (h.v(context)) {
                h.p(context, (Runnable)q0);
            }
            else {
                e((q0)q0);
            }
        }
        else {
            d((s2.q0<? super Object>)q0, (e2.d<? super Object>)b, b2);
        }
    }
    
    public static final boolean b(final int n) {
        boolean b = true;
        if (n != 1) {
            b = (n == 2 && b);
        }
        return b;
    }
    
    public static final boolean c(final int n) {
        return n == 2;
    }
    
    public static final <T> void d(q0<? super T> f, d<? super T> context, final boolean b) {
        final Object h = ((q0)f).h();
        final Throwable d = ((q0)f).d(h);
        Object o;
        if (d != null) {
            final k$a e = k.e;
            o = l.a(d);
        }
        else {
            final k$a e2 = k.e;
            o = ((q0)f).f(h);
        }
        final Object a = k.a(o);
        if (b) {
            final f f2 = (f)context;
            final d i = f2.i;
            final Object k = f2.k;
            context = i.getContext();
            final Object c = f0.c(context, k);
            if (c != f0.a) {
                f = b0.f((d<?>)i, context, c);
            }
            else {
                f = null;
            }
            try {
                f2.i.resumeWith(a);
                final q a2 = q.a;
                return;
            }
            finally {
                if (f == null || ((e2)f).E0()) {
                    f0.a(context, c);
                }
            }
        }
        ((d)context).resumeWith(a);
    }
    
    private static final void e(final q0<?> q0) {
        final w0 a = c2.a.a();
        if (a.F()) {
            a.B((q0)q0);
            return;
        }
        a.D(true);
        final Throwable t2;
        try {
            d((s2.q0<? super Object>)q0, (e2.d<? super Object>)q0.b(), true);
            while (a.H()) {}
            return;
        }
        finally {
            final s2.q0<? super Object> q2 = (s2.q0<? super Object>)q0;
            final Throwable t = t2;
            final Throwable t3 = null;
            q2.g(t, t3);
        }
        try {
            final s2.q0<? super Object> q2 = (s2.q0<? super Object>)q0;
            final Throwable t = t2;
            final Throwable t3 = null;
            q2.g(t, t3);
        }
        finally {
            a.z(true);
        }
    }
}
