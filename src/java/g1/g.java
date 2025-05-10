package g1;

import b2.a;
import android.os.Looper;
import android.os.Handler;

public class g implements c$d
{
    private final Handler a;
    
    public g() {
        this.a = b2.a.a(Looper.getMainLooper());
    }
    
    public void a(final Runnable runnable) {
        this.a.post(runnable);
    }
}
