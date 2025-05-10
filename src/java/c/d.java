package c;

import java.util.concurrent.Executor;
import java.lang.reflect.InvocationTargetException;
import android.os.Handler$Callback;
import android.os.Build$VERSION;
import android.os.Looper;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.Executors;
import android.os.Handler;
import java.util.concurrent.ExecutorService;

public class d extends f
{
    private final Object a;
    private final ExecutorService b;
    private volatile Handler c;
    
    public d() {
        this.a = new Object();
        this.b = Executors.newFixedThreadPool(4, (ThreadFactory)new d$a(this));
    }
    
    private static Handler d(final Looper looper) {
        if (Build$VERSION.SDK_INT >= 28) {
            return d.d$b.a(looper);
        }
        try {
            return (Handler)Handler.class.getDeclaredConstructor(Looper.class, Handler$Callback.class, Boolean.TYPE).newInstance(new Object[] { looper, null, Boolean.TRUE });
        }
        catch (final InvocationTargetException ex) {
            return new Handler(looper);
        }
        catch (final IllegalAccessException | InstantiationException | NoSuchMethodException ex2) {
            return new Handler(looper);
        }
    }
    
    public void a(final Runnable runnable) {
        ((Executor)this.b).execute(runnable);
    }
    
    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
    
    public void c(final Runnable runnable) {
        if (this.c == null) {
            final Object a = this.a;
            synchronized (a) {
                if (this.c == null) {
                    this.c = d(Looper.getMainLooper());
                }
            }
        }
        this.c.post(runnable);
    }
}
