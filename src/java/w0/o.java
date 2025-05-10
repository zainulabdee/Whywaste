package w0;

import java.util.concurrent.Executor;

final class o<TResult> implements v<TResult>
{
    private final Executor a;
    private final Object b;
    private b c;
    
    public o(final Executor a, final b c) {
        this.b = new Object();
        this.a = a;
        this.c = c;
    }
    
    public final void a(final g<TResult> g) {
        if (g.i()) {
            final Object b = this.b;
            synchronized (b) {
                if (this.c == null) {
                    return;
                }
                monitorexit(b);
                this.a.execute((Runnable)new n(this));
            }
        }
    }
}
