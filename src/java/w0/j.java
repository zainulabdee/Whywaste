package w0;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;
import f0.i;

public final class j
{
    public static <TResult> TResult a(final g<TResult> g) {
        i.g();
        i.j((Object)g, (Object)"Task must not be null");
        if (g.j()) {
            return (TResult)d((g<Object>)g);
        }
        final l l = new l((k)null);
        e((g<TResult>)g, (w0.m<? super TResult>)l);
        l.d();
        return (TResult)d((g<T>)g);
    }
    
    public static <TResult> g<TResult> b(final Exception ex) {
        final z z = new z();
        z.l(ex);
        return (g<TResult>)z;
    }
    
    public static <TResult> g<TResult> c(final TResult tResult) {
        final z z = new z();
        z.m((Object)tResult);
        return (g<TResult>)z;
    }
    
    private static <TResult> TResult d(final g<TResult> g) {
        if (g.k()) {
            return g.g();
        }
        if (g.i()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException((Throwable)g.f());
    }
    
    private static <T> void e(final g<T> g, final m<? super T> m) {
        final Executor b = w0.i.b;
        g.e(b, (e<? super T>)m);
        g.d(b, (d)m);
        g.a(b, (b)m);
    }
}
