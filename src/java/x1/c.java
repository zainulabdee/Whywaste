package x1;

import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import com.google.common.util.concurrent.f;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ThreadPoolExecutor;

public final class c
{
    private final ThreadPoolExecutor a;
    
    public c(final int n) {
        this.a = new ThreadPoolExecutor(n, n, 1L, TimeUnit.SECONDS, (BlockingQueue)new LinkedBlockingQueue());
    }
    
    public <T> com.google.common.util.concurrent.c<T> e(final Callable<T> callable) {
        final f d = f.D();
        this.a.execute((Runnable)new b(d, callable));
        return (com.google.common.util.concurrent.c<T>)d;
    }
    
    public <T> void f(final Callable<T> callable, final a<T> a) {
        final com.google.common.util.concurrent.c<Object> e = this.e((java.util.concurrent.Callable<Object>)callable);
        e.a((Runnable)new x1.a((a)a, e), d.a());
    }
    
    public interface a<T>
    {
        void a(final Future<T> p0);
    }
}
