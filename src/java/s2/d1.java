package s2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import e2.g;
import kotlinx.coroutines.internal.d;
import java.util.concurrent.Executor;

public final class d1 extends c1 implements n0
{
    private final Executor h;
    
    public d1(final Executor h) {
        this.h = h;
        d.a(this.A());
    }
    
    private final void z(final g g, final RejectedExecutionException ex) {
        p1.c(g, b1.a("The task was rejected", (Throwable)ex));
    }
    
    public Executor A() {
        return this.h;
    }
    
    public void close() {
        final Executor a = this.A();
        ExecutorService executorService;
        if (a instanceof ExecutorService) {
            executorService = (ExecutorService)a;
        }
        else {
            executorService = null;
        }
        if (executorService != null) {
            executorService.shutdown();
        }
    }
    
    public boolean equals(final Object o) {
        return o instanceof d1 && ((d1)o).A() == this.A();
    }
    
    public int hashCode() {
        return System.identityHashCode((Object)this.A());
    }
    
    public void p(final g g, final Runnable runnable) {
        try {
            final Executor a = this.A();
            c.a();
            a.execute(runnable);
        }
        catch (final RejectedExecutionException ex) {
            c.a();
            this.z(g, ex);
            t0.b().p(g, runnable);
        }
    }
    
    public String toString() {
        return this.A().toString();
    }
}
