package k;

import android.os.Message;
import android.os.Looper;
import android.os.Handler;
import android.util.Log;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Executor;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;

abstract class c<Params, Progress, Result>
{
    private static final ThreadFactory j;
    private static final BlockingQueue<Runnable> k;
    public static final Executor l;
    private static f m;
    private static volatile Executor n;
    private final h<Params, Result> e;
    private final FutureTask<Result> f;
    private volatile g g;
    final AtomicBoolean h;
    final AtomicBoolean i;
    
    static {
        c.n = (l = (Executor)new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, k = (BlockingQueue)new LinkedBlockingQueue(10), j = (ThreadFactory)new ThreadFactory() {
            private final AtomicInteger a = new AtomicInteger(1);
            
            public Thread newThread(final Runnable runnable) {
                final StringBuilder sb = new StringBuilder();
                sb.append("ModernAsyncTask #");
                sb.append(this.a.getAndIncrement());
                return new Thread(runnable, sb.toString());
            }
        }));
    }
    
    c() {
        this.g = c.g.e;
        this.h = new AtomicBoolean();
        this.i = new AtomicBoolean();
        final c$b e = new c$b(this);
        this.e = (h<Params, Result>)e;
        this.f = new FutureTask<Result>(this, e) {
            final c e;
            
            protected void done() {
                try {
                    this.e.m(this.get());
                }
                catch (final CancellationException ex) {
                    this.e.m(null);
                }
                catch (final ExecutionException ex2) {
                    throw new RuntimeException("An error occurred while executing doInBackground()", ((Throwable)ex2).getCause());
                }
                catch (final InterruptedException ex3) {
                    Log.w("AsyncTask", (Throwable)ex3);
                }
                finally {
                    final Throwable t;
                    throw new RuntimeException("An error occurred while executing doInBackground()", t);
                }
            }
        };
    }
    
    private static Handler e() {
        synchronized (c.class) {
            if (c.m == null) {
                c.m = new f();
            }
            return c.m;
        }
    }
    
    public final boolean a(final boolean b) {
        this.h.set(true);
        return this.f.cancel(b);
    }
    
    protected abstract Result b(final Params... p0);
    
    public final c<Params, Progress, Result> c(final Executor executor, final Params... a) {
        if (this.g == c.g.e) {
            this.g = c.g.f;
            this.j();
            this.e.a = a;
            executor.execute((Runnable)this.f);
            return this;
        }
        final int n = c$d.a[this.g.ordinal()];
        if (n == 1) {
            throw new IllegalStateException("Cannot execute task: the task is already running.");
        }
        if (n != 2) {
            throw new IllegalStateException("We should never reach this state");
        }
        throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
    }
    
    void d(final Result result) {
        if (this.f()) {
            this.h(result);
        }
        else {
            this.i(result);
        }
        this.g = c.g.g;
    }
    
    public final boolean f() {
        return this.h.get();
    }
    
    protected void g() {
    }
    
    protected void h(final Result result) {
        this.g();
    }
    
    protected void i(final Result result) {
    }
    
    protected void j() {
    }
    
    protected void k(final Progress... array) {
    }
    
    Result l(final Result result) {
        e().obtainMessage(1, (Object)new e(this, new Object[] { result })).sendToTarget();
        return result;
    }
    
    void m(final Result result) {
        if (!this.i.get()) {
            this.l(result);
        }
    }
    
    private static class e<Data>
    {
        final c a;
        final Data[] b;
        
        e(final c a, final Data... b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private static class f extends Handler
    {
        f() {
            super(Looper.getMainLooper());
        }
        
        public void handleMessage(final Message message) {
            final e e = (e)message.obj;
            final int what = message.what;
            if (what != 1) {
                if (what == 2) {
                    e.a.k(e.b);
                }
            }
            else {
                e.a.d(e.b[0]);
            }
        }
    }
    
    public enum g
    {
        e, 
        f, 
        g;
        
        private static final g[] h;
    }
    
    private abstract static class h<Params, Result> implements Callable<Result>
    {
        Params[] a;
        
        h() {
        }
    }
}
