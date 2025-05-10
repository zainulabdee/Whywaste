package a1;

import android.os.Handler;
import android.os.HandlerThread;

class m
{
    private final String a;
    private final int b;
    private HandlerThread c;
    private Handler d;
    protected Runnable e;
    private k f;
    
    m(final String a, final int b) {
        this.a = a;
        this.b = b;
    }
    
    boolean b() {
        final k f = this.f;
        return f != null && f.b();
    }
    
    Integer d() {
        final k f = this.f;
        Integer a;
        if (f != null) {
            a = f.a();
        }
        else {
            a = null;
        }
        return a;
    }
    
    void e(final k k) {
        this.d.post((Runnable)new l(this, k));
    }
    
    void f() {
        synchronized (this) {
            final HandlerThread c = this.c;
            if (c != null) {
                c.quit();
                this.c = null;
                this.d = null;
            }
        }
    }
    
    void g(final Runnable e) {
        synchronized (this) {
            ((Thread)(this.c = new HandlerThread(this.a, this.b))).start();
            this.d = new Handler(this.c.getLooper());
            this.e = e;
        }
    }
    
    void h(final k f) {
        f.b.run();
        this.f = f;
        this.e.run();
    }
}
