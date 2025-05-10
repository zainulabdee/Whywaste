package io.flutter.view;

import android.view.Choreographer$FrameCallback;
import android.os.Handler;
import android.hardware.display.DisplayManager$DisplayListener;
import java.util.Objects;
import android.hardware.display.DisplayManager;
import io.flutter.embedding.engine.FlutterJNI$b;
import io.flutter.embedding.engine.FlutterJNI;

public class t
{
    private static t e;
    private static b f;
    private long a;
    private FlutterJNI b;
    private c c;
    private final FlutterJNI$b d;
    
    private t(final FlutterJNI b) {
        this.a = -1L;
        this.c = new c(0L);
        this.d = (FlutterJNI$b)new t$a(this);
        this.b = b;
    }
    
    public static t f(final DisplayManager displayManager, final FlutterJNI flutterJNI) {
        if (t.e == null) {
            t.e = new t(flutterJNI);
        }
        if (t.f == null) {
            final t e = t.e;
            Objects.requireNonNull((Object)e);
            (t.f = e.new b(displayManager)).a();
        }
        if (t.e.a == -1L) {
            final float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            t.e.a = (long)(1.0E9 / refreshRate);
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return t.e;
    }
    
    public void g() {
        this.b.setAsyncWaitForVsyncDelegate(this.d);
    }
    
    class b implements DisplayManager$DisplayListener
    {
        private DisplayManager a;
        final t b;
        
        b(final t b, final DisplayManager a) {
            this.b = b;
            this.a = a;
        }
        
        void a() {
            this.a.registerDisplayListener((DisplayManager$DisplayListener)this, (Handler)null);
        }
        
        public void onDisplayAdded(final int n) {
        }
        
        public void onDisplayChanged(final int n) {
            if (n == 0) {
                final float refreshRate = this.a.getDisplay(0).getRefreshRate();
                this.b.a = (long)(1.0E9 / refreshRate);
                this.b.b.setRefreshRateFPS(refreshRate);
            }
        }
        
        public void onDisplayRemoved(final int n) {
        }
    }
    
    private class c implements Choreographer$FrameCallback
    {
        private long a;
        final t b;
        
        c(final t b, final long a) {
            this.b = b;
            this.a = a;
        }
        
        public void doFrame(long n) {
            n = System.nanoTime() - n;
            if (n < 0L) {
                n = 0L;
            }
            this.b.b.onVsync(n, this.b.a, this.a);
            this.b.c = this;
        }
    }
}
