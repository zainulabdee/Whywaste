package w0;

import java.util.concurrent.Executor;

final class q<TResult> implements v<TResult>
{
    private final Executor a;
    private final Object b;
    private c<TResult> c;
    
    public q(final Executor a, final c<TResult> c) {
        this.b = new Object();
        this.a = a;
        this.c = c;
    }
    
    public final void a(final g<TResult> g) {
        final Object b = this.b;
        synchronized (b) {
            if (this.c == null) {
                return;
            }
            monitorexit(b);
            this.a.execute((Runnable)new p(this, (g)g));
        }
    }
}
