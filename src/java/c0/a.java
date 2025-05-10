package c0;

import android.content.ComponentName;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import f0.i;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.BlockingQueue;
import android.content.ServiceConnection;

public class a implements ServiceConnection
{
    boolean a;
    private final BlockingQueue b;
    
    public a() {
        this.a = false;
        this.b = (BlockingQueue)new LinkedBlockingQueue();
    }
    
    @ResultIgnorabilityUnspecified
    public IBinder a() {
        i.h("BlockingServiceConnection.getService() called on main thread");
        if (!this.a) {
            this.a = true;
            return (IBinder)this.b.take();
        }
        throw new IllegalStateException("Cannot call get on this connection more than once");
    }
    
    public final void onServiceConnected(final ComponentName componentName, final IBinder binder) {
        this.b.add((Object)binder);
    }
    
    public final void onServiceDisconnected(final ComponentName componentName) {
    }
}
