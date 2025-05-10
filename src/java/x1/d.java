package x1;

import android.os.Looper;
import android.os.Handler;
import java.util.concurrent.Executor;

public final class d
{
    public static Executor a() {
        return (Executor)new a();
    }
    
    static final class a implements Executor
    {
        private static final Handler e;
        
        static {
            e = new Handler(Looper.getMainLooper());
        }
        
        public void execute(final Runnable runnable) {
            a.e.post(runnable);
        }
    }
}
