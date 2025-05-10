package w0;

import java.util.concurrent.Executor;

final class u<TResult> implements v<TResult>
{
    private final Executor a;
    private final Object b;
    private e<? super TResult> c;
    
    public u(final Executor a, final e<? super TResult> c) {
        this.b = new Object();
        this.a = a;
        this.c = c;
    }
    
    public final void a(final g<TResult> g) {
        if (g.k()) {
            final Object b = this.b;
            synchronized (b) {
                if (this.c == null) {
                    return;
                }
                monitorexit(b);
                this.a.execute((Runnable)new t(this, (g)g));
            }
        }
    }
}
