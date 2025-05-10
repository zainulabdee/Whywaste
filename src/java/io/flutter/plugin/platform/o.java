package io.flutter.plugin.platform;

import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.graphics.Matrix;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import b2.i;
import android.view.View;
import android.view.View$OnFocusChangeListener;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.view.ViewParent;
import android.graphics.Rect;
import android.graphics.PorterDuff$Mode;
import f1.b;
import android.graphics.Canvas;
import android.os.Build$VERSION;
import io.flutter.view.s$c;
import android.content.Context;
import io.flutter.view.s$b;
import io.flutter.view.s$a;
import java.util.concurrent.atomic.AtomicLong;
import android.view.ViewTreeObserver$OnGlobalFocusChangeListener;
import io.flutter.embedding.android.a;
import android.view.Surface;
import android.graphics.SurfaceTexture;
import android.widget.FrameLayout;

class o extends FrameLayout
{
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private SurfaceTexture k;
    private Surface l;
    private a m;
    ViewTreeObserver$OnGlobalFocusChangeListener n;
    private final AtomicLong o;
    private final s$a p;
    private boolean q;
    private final s$b r;
    
    public o(final Context context) {
        super(context);
        this.o = new AtomicLong(0L);
        this.p = (s$a)new o$a(this);
        this.q = false;
        this.r = (s$b)new o$b(this);
        ((View)this).setWillNotDraw(false);
    }
    
    public o(final Context context, final s$c s$c) {
        this(context);
        s$c.b(this.p);
        s$c.a(this.r);
        this.l(s$c.c());
    }
    
    private void f() {
        if (Build$VERSION.SDK_INT == 29) {
            this.o.incrementAndGet();
        }
    }
    
    private void g() {
        if (this.q) {
            final Surface l = this.l;
            if (l != null) {
                l.release();
            }
            this.l = this.c(this.k);
            this.q = false;
        }
    }
    
    private boolean n() {
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean b = true;
        if (sdk_INT == 29) {
            b = (this.o.get() <= 0L && b);
        }
        return b;
    }
    
    protected Surface c(final SurfaceTexture surfaceTexture) {
        return new Surface(surfaceTexture);
    }
    
    public int d() {
        return this.j;
    }
    
    public void draw(final Canvas canvas) {
        Object o = this.l;
        if (o == null) {
            super.draw(canvas);
            b.b("PlatformViewWrapper", "Platform view cannot be composed without a surface.");
            return;
        }
        if (!((Surface)o).isValid()) {
            b.b("PlatformViewWrapper", "Invalid surface. The platform view cannot be displayed.");
            return;
        }
        final SurfaceTexture k = this.k;
        if (k != null) {
            if (!io.flutter.plugin.platform.m.a(k)) {
                if (!this.n()) {
                    ((View)this).invalidate();
                    return;
                }
                this.g();
                o = io.flutter.plugin.platform.n.a(this.l);
                try {
                    ((Canvas)o).drawColor(0, PorterDuff$Mode.CLEAR);
                    super.draw((Canvas)o);
                    this.f();
                    return;
                }
                finally {
                    this.l.unlockCanvasAndPost((Canvas)o);
                }
            }
        }
        b.b("PlatformViewWrapper", "Invalid texture. The platform view cannot be displayed.");
    }
    
    public int e() {
        return this.i;
    }
    
    public void h() {
        this.k = null;
        final Surface l = this.l;
        if (l != null) {
            l.release();
            this.l = null;
        }
    }
    
    public void i(final int i, final int j) {
        this.i = i;
        this.j = j;
        final SurfaceTexture k = this.k;
        if (k != null) {
            k.setDefaultBufferSize(i, j);
        }
    }
    
    public ViewParent invalidateChildInParent(final int[] array, final Rect rect) {
        ((View)this).invalidate();
        return super.invalidateChildInParent(array, rect);
    }
    
    public void j(final FrameLayout$LayoutParams layoutParams) {
        super.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        this.g = layoutParams.leftMargin;
        this.h = layoutParams.topMargin;
    }
    
    public void k(final View$OnFocusChangeListener view$OnFocusChangeListener) {
        this.o();
        final ViewTreeObserver viewTreeObserver = ((View)this).getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.n == null) {
            viewTreeObserver.addOnGlobalFocusChangeListener(this.n = (ViewTreeObserver$OnGlobalFocusChangeListener)new ViewTreeObserver$OnGlobalFocusChangeListener(this, view$OnFocusChangeListener) {
                final View$OnFocusChangeListener e;
                final o f;
                
                public void onGlobalFocusChanged(final View view, final View view2) {
                    final View$OnFocusChangeListener e = this.e;
                    final o f = this.f;
                    e.onFocusChange((View)f, b2.i.c((View)f));
                }
            });
        }
    }
    
    public void l(final SurfaceTexture k) {
        if (Build$VERSION.SDK_INT < 23) {
            b.b("PlatformViewWrapper", "Platform views cannot be displayed below API level 23. You can prevent this issue by setting `minSdkVersion: 23` in build.gradle.");
            return;
        }
        this.k = k;
        final int i = this.i;
        if (i > 0) {
            final int j = this.j;
            if (j > 0) {
                k.setDefaultBufferSize(i, j);
            }
        }
        final Surface l = this.l;
        if (l != null) {
            l.release();
        }
        final Surface c = this.c(k);
        this.l = c;
        final Canvas a = io.flutter.plugin.platform.n.a(c);
        try {
            a.drawColor(0, PorterDuff$Mode.CLEAR);
            this.f();
        }
        finally {
            this.l.unlockCanvasAndPost(a);
        }
    }
    
    public void m(final a m) {
        this.m = m;
    }
    
    public void o() {
        final ViewTreeObserver viewTreeObserver = ((View)this).getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            final ViewTreeObserver$OnGlobalFocusChangeListener n = this.n;
            if (n != null) {
                this.n = null;
                viewTreeObserver.removeOnGlobalFocusChangeListener(n);
            }
        }
    }
    
    public void onDescendantInvalidated(final View view, final View view2) {
        super.onDescendantInvalidated(view, view2);
        ((View)this).invalidate();
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        return true;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.m == null) {
            return super.onTouchEvent(motionEvent);
        }
        final Matrix matrix = new Matrix();
        final int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                matrix.postTranslate((float)this.g, (float)this.h);
            }
            else {
                matrix.postTranslate((float)this.e, (float)this.f);
                this.e = this.g;
                this.f = this.h;
            }
        }
        else {
            final int g = this.g;
            this.e = g;
            final int h = this.h;
            this.f = h;
            matrix.postTranslate((float)g, (float)h);
        }
        return this.m.g(motionEvent, matrix);
    }
    
    public boolean requestSendAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        final View child = ((ViewGroup)this).getChildAt(0);
        return (child == null || child.getImportantForAccessibility() != 4) && super.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}
