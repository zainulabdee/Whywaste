package r0;

import android.os.Handler$Callback;
import android.os.Looper;
import android.os.Handler;

public class d extends Handler
{
    private final Looper a;
    
    public d(final Looper looper) {
        super(looper);
        this.a = Looper.getMainLooper();
    }
    
    public d(final Looper looper, final Handler$Callback handler$Callback) {
        super(looper, handler$Callback);
        this.a = Looper.getMainLooper();
    }
}
