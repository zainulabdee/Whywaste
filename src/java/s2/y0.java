package s2;

import java.util.concurrent.locks.LockSupport;

public abstract class y0 extends w0
{
    protected abstract Thread I();
    
    protected void J(final long n, final x0.a a) {
        l0.l.V(n, a);
    }
    
    protected final void K() {
        final Thread i = this.I();
        if (Thread.currentThread() != i) {
            c.a();
            LockSupport.unpark(i);
        }
    }
}
