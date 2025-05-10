package io.flutter.plugin.platform;

import android.app.Dialog;
import android.view.ViewTreeObserver$OnDrawListener;
import android.view.View$OnAttachStateChangeListener;
import android.view.View;
import android.view.MotionEvent;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.view.Surface;
import android.view.View$OnFocusChangeListener;
import io.flutter.view.s$c;
import android.content.Context;

class w
{
    SingleViewPresentation a;
    private final Context b;
    private final a c;
    private final int d;
    private final s$c e;
    private final View$OnFocusChangeListener f;
    private final Surface g;
    private VirtualDisplay h;
    private int i;
    private int j;
    
    private w(final Context b, final a c, final VirtualDisplay h, final i i, final Surface g, final s$c e, final View$OnFocusChangeListener f, final int n, final Object o) {
        this.b = b;
        this.c = c;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.d = b.getResources().getDisplayMetrics().densityDpi;
        ((Dialog)(this.a = new SingleViewPresentation(b, this.h.getDisplay(), i, c, n, f))).show();
    }
    
    public static w a(final Context context, final a a, final i i, final s$c s$c, final int j, final int k, final int n, final Object o, final View$OnFocusChangeListener view$OnFocusChangeListener) {
        context.getResources().getDisplayMetrics();
        if (j == 0 || k == 0) {
            return null;
        }
        s$c.c().setDefaultBufferSize(j, k);
        final Surface surface = new Surface(s$c.c());
        final VirtualDisplay virtualDisplay = ((DisplayManager)context.getSystemService("display")).createVirtualDisplay("flutter-vd", j, k, context.getResources().getDisplayMetrics().densityDpi, surface, 0);
        if (virtualDisplay == null) {
            return null;
        }
        final w w = new w(context, a, virtualDisplay, i, surface, s$c, view$OnFocusChangeListener, n, o);
        w.i = j;
        w.j = k;
        return w;
    }
    
    public void b(final MotionEvent motionEvent) {
        final SingleViewPresentation a = this.a;
        if (a == null) {
            return;
        }
        ((Dialog)a).dispatchTouchEvent(motionEvent);
    }
    
    public int c() {
        return this.j;
    }
    
    public int d() {
        return this.i;
    }
    
    public View e() {
        final SingleViewPresentation a = this.a;
        if (a == null) {
            return null;
        }
        return a.getView().getView();
    }
    
    void f(final View view) {
        final SingleViewPresentation a = this.a;
        if (a != null) {
            if (a.getView() != null) {
                this.a.getView().f(view);
            }
        }
    }
    
    void g() {
        final SingleViewPresentation a = this.a;
        if (a != null) {
            if (a.getView() != null) {
                this.a.getView().h();
            }
        }
    }
    
    void h() {
        final SingleViewPresentation a = this.a;
        if (a != null) {
            if (a.getView() != null) {
                this.a.getView().e();
            }
        }
    }
    
    public void i(final int i, final int j, final Runnable runnable) {
        final boolean focused = this.e().isFocused();
        final SingleViewPresentation.e detachState = this.a.detachState();
        this.h.setSurface((Surface)null);
        this.h.release();
        this.i = i;
        this.j = j;
        this.e.c().setDefaultBufferSize(i, j);
        this.h = ((DisplayManager)this.b.getSystemService("display")).createVirtualDisplay("flutter-vd", i, j, this.d, this.g, 0);
        final View e = this.e();
        e.addOnAttachStateChangeListener((View$OnAttachStateChangeListener)new View$OnAttachStateChangeListener(this, e, runnable) {
            final View e;
            final Runnable f;
            final w g;
            
            public void onViewAttachedToWindow(final View view) {
                w.b.a(this.e, (Runnable)new Runnable(this) {
                    final w$a e;
                    
                    public void run() {
                        final View$OnAttachStateChangeListener e = (View$OnAttachStateChangeListener)this.e;
                        e.e.postDelayed(e.f, 128L);
                    }
                });
                this.e.removeOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
            }
            
            public void onViewDetachedFromWindow(final View view) {
            }
        });
        final SingleViewPresentation a = new SingleViewPresentation(this.b, this.h.getDisplay(), this.c, detachState, this.f, focused);
        ((Dialog)a).show();
        ((Dialog)this.a).cancel();
        this.a = a;
    }
    
    static class b implements ViewTreeObserver$OnDrawListener
    {
        final View e;
        Runnable f;
        
        b(final View e, final Runnable f) {
            this.e = e;
            this.f = f;
        }
        
        static void a(final View view, final Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener((ViewTreeObserver$OnDrawListener)new b(view, runnable));
        }
        
        public void onDraw() {
            final Runnable f = this.f;
            if (f == null) {
                return;
            }
            f.run();
            this.f = null;
            this.e.post((Runnable)new Runnable(this) {
                final b e;
                
                public void run() {
                    this.e.e.getViewTreeObserver().removeOnDrawListener((ViewTreeObserver$OnDrawListener)this.e);
                }
            });
        }
    }
}
