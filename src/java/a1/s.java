package a1;

import android.os.Handler;
import android.os.HandlerThread;

class s implements o
{
    final String a;
    final int b;
    private HandlerThread c;
    private Handler d;
    
    s(final String a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    public void b() {
        final HandlerThread c = this.c;
        if (c != null) {
            c.quit();
            this.c = null;
            this.d = null;
        }
    }
    
    public void c(final k k) {
        this.d.post(k.b);
    }
    
    public void start() {
        ((Thread)(this.c = new HandlerThread(this.a, this.b))).start();
        this.d = new Handler(this.c.getLooper());
    }
}
