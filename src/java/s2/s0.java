package s2;

import e2.g;
import e2.h;
import java.util.concurrent.Executor;

final class s0 implements Executor
{
    public final c0 e;
    
    public void execute(final Runnable runnable) {
        this.e.p((g)h.e, runnable);
    }
    
    @Override
    public String toString() {
        return this.e.toString();
    }
}
