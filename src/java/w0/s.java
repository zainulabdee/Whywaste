package w0;

import java.util.concurrent.Executor;

final class s<TResult> implements v<TResult>
{
    private final Executor a;
    private final Object b;
    private d c;
    
    public s(final Executor a, final d c) {
        this.b = new Object();
        this.a = a;
        this.c = c;
    }
    
    public final void a(final g<TResult> g) {
        if (!g.k() && !g.i()) {
            final Object b = this.b;
            synchronized (b) {
                if (this.c == null) {
                    return;
                }
                monitorexit(b);
                this.a.execute((Runnable)new r(this, (g)g));
            }
        }
    }
}
