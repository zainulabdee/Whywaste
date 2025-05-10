package s2;

import c2.k$a;
import java.util.Iterator;
import c2.l;
import c2.q;
import c2.a;
import c2.k;
import e2.g;
import q2.c;
import java.util.ServiceLoader;
import java.util.List;

public final class e0
{
    private static final List<d0> a;
    
    static {
        a = c.e(c.a(ServiceLoader.load((Class)d0.class, d0.class.getClassLoader()).iterator()));
    }
    
    public static final void a(final g g, final Throwable t) {
        for (final d0 d0 : e0.a) {
            try {
                d0.q(g, t);
            }
            finally {
                final Thread currentThread = Thread.currentThread();
                final Throwable t2;
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, f0.b(t, t2));
            }
        }
        final Thread currentThread2 = Thread.currentThread();
        try {
            final k$a e = k.e;
            c2.a.a(t, (Throwable)new o0(g));
            k.a((Object)q.a);
        }
        finally {
            final k$a e2 = k.e;
            final Throwable t3;
            k.a(l.a(t3));
        }
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, t);
    }
}
