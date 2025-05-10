package k;

import java.util.concurrent.CountDownLatch;
import android.os.SystemClock;
import androidx.core.util.g;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.content.Context;
import android.os.Handler;
import java.util.concurrent.Executor;

public abstract class a<D> extends b<D>
{
    private final Executor j;
    volatile a k;
    volatile a l;
    long m;
    long n;
    Handler o;
    
    public a(final Context context) {
        this(context, c.l);
    }
    
    private a(final Context context, final Executor j) {
        super(context);
        this.n = -10000L;
        this.j = j;
    }
    
    public abstract D A();
    
    public void B(final D n) {
    }
    
    protected D C() {
        return this.A();
    }
    
    @Deprecated
    public void g(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.g(s, fileDescriptor, printWriter, array);
        if (this.k != null) {
            printWriter.print(s);
            printWriter.print("mTask=");
            printWriter.print((Object)this.k);
            printWriter.print(" waiting=");
            printWriter.println(this.k.p);
        }
        if (this.l != null) {
            printWriter.print(s);
            printWriter.print("mCancellingTask=");
            printWriter.print((Object)this.l);
            printWriter.print(" waiting=");
            printWriter.println(this.l.p);
        }
        if (this.m != 0L) {
            printWriter.print(s);
            printWriter.print("mUpdateThrottle=");
            g.c(this.m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            g.b(this.n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }
    
    protected boolean k() {
        if (this.k == null) {
            return false;
        }
        if (!super.e) {
            super.h = true;
        }
        if (this.l != null) {
            if (this.k.p) {
                this.k.p = false;
                this.o.removeCallbacks((Runnable)this.k);
            }
            this.k = null;
            return false;
        }
        if (this.k.p) {
            this.k.p = false;
            this.o.removeCallbacks((Runnable)this.k);
            this.k = null;
            return false;
        }
        final boolean a = this.k.a(false);
        if (a) {
            this.l = this.k;
            this.w();
        }
        this.k = null;
        return a;
    }
    
    protected void m() {
        super.m();
        this.b();
        this.k = new a();
        this.z();
    }
    
    public void w() {
    }
    
    void x(final a a, final D n) {
        this.B(n);
        if (this.l == a) {
            this.s();
            this.n = SystemClock.uptimeMillis();
            this.l = null;
            this.e();
            this.z();
        }
    }
    
    void y(final a a, final D n) {
        if (this.k != a) {
            this.x(a, n);
        }
        else if (this.i()) {
            this.B(n);
        }
        else {
            this.c();
            this.n = SystemClock.uptimeMillis();
            this.k = null;
            this.f((Object)n);
        }
    }
    
    void z() {
        if (this.l == null && this.k != null) {
            if (this.k.p) {
                this.k.p = false;
                this.o.removeCallbacks((Runnable)this.k);
            }
            if (this.m > 0L && SystemClock.uptimeMillis() < this.n + this.m) {
                this.k.p = true;
                this.o.postAtTime((Runnable)this.k, this.n + this.m);
                return;
            }
            this.k.c(this.j, (Object[])null);
        }
    }
    
    final class a extends c<Void, Void, D> implements Runnable
    {
        private final CountDownLatch o;
        boolean p;
        final k.a q;
        
        a(final k.a q) {
            this.q = q;
            this.o = new CountDownLatch(1);
        }
        
        protected void h(final D n) {
            try {
                this.q.x(this, n);
            }
            finally {
                this.o.countDown();
            }
        }
        
        protected void i(final D n) {
            try {
                this.q.y(this, n);
            }
            finally {
                this.o.countDown();
            }
        }
        
        protected D n(final Void... array) {
            return this.q.C();
        }
        
        public void run() {
            this.p = false;
            this.q.z();
        }
    }
}
