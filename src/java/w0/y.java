package w0;

import t0.a;
import android.os.Looper;
import android.os.Handler;
import java.util.concurrent.Executor;

final class y implements Executor
{
    private final Handler e;
    
    public y() {
        this.e = new a(Looper.getMainLooper());
    }
    
    public final void execute(final Runnable runnable) {
        this.e.post(runnable);
    }
}
