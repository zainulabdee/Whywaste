package j1;

import android.view.ViewGroup;
import b2.i;
import android.view.View$OnFocusChangeListener;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.MotionEvent;
import java.util.Iterator;
import android.graphics.Path;
import android.graphics.Canvas;
import android.view.ViewTreeObserver;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.content.Context;
import android.view.ViewTreeObserver$OnGlobalFocusChangeListener;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import android.widget.FrameLayout;

public class a extends FrameLayout
{
    private FlutterMutatorsStack e;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private final io.flutter.embedding.android.a k;
    ViewTreeObserver$OnGlobalFocusChangeListener l;
    
    public a(final Context context, final float f, final io.flutter.embedding.android.a k) {
        super(context, (AttributeSet)null);
        this.f = f;
        this.k = k;
    }
    
    private Matrix getPlatformViewMatrix() {
        final Matrix matrix = new Matrix(this.e.getFinalMatrix());
        final float f = this.f;
        matrix.preScale(1.0f / f, 1.0f / f);
        matrix.postTranslate((float)(-this.g), (float)(-this.h));
        return matrix;
    }
    
    public void a(final FlutterMutatorsStack e, final int n, final int n2, final int n3, final int n4) {
        this.e = e;
        this.g = n;
        this.h = n2;
        final FrameLayout$LayoutParams layoutParams = new FrameLayout$LayoutParams(n3, n4);
        layoutParams.leftMargin = n;
        layoutParams.topMargin = n2;
        ((View)this).setLayoutParams((ViewGroup$LayoutParams)layoutParams);
        ((View)this).setWillNotDraw(false);
    }
    
    public void b() {
        final ViewTreeObserver viewTreeObserver = ((View)this).getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            final ViewTreeObserver$OnGlobalFocusChangeListener l = this.l;
            if (l != null) {
                this.l = null;
                viewTreeObserver.removeOnGlobalFocusChangeListener(l);
            }
        }
    }
    
    public void dispatchDraw(final Canvas canvas) {
        canvas.save();
        canvas.concat(this.getPlatformViewMatrix());
        super.dispatchDraw(canvas);
        canvas.restore();
    }
    
    public void draw(final Canvas canvas) {
        canvas.save();
        final Iterator iterator = this.e.getFinalClippingPaths().iterator();
        while (iterator.hasNext()) {
            final Path path = new Path((Path)iterator.next());
            path.offset((float)(-this.g), (float)(-this.h));
            canvas.clipPath(path);
        }
        super.draw(canvas);
        canvas.restore();
    }
    
    public boolean onInterceptTouchEvent(final MotionEvent motionEvent) {
        return true;
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (this.k == null) {
            return super.onTouchEvent(motionEvent);
        }
        final Matrix matrix = new Matrix();
        final int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 2) {
                matrix.postTranslate((float)this.g, (float)this.h);
            }
            else {
                matrix.postTranslate((float)this.i, (float)this.j);
                this.i = this.g;
                this.j = this.h;
            }
        }
        else {
            final int g = this.g;
            this.i = g;
            final int h = this.h;
            this.j = h;
            matrix.postTranslate((float)g, (float)h);
        }
        return this.k.g(motionEvent, matrix);
    }
    
    public boolean requestSendAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
        final View child = ((ViewGroup)this).getChildAt(0);
        return (child == null || child.getImportantForAccessibility() != 4) && super.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
    
    public void setOnDescendantFocusChangeListener(final View$OnFocusChangeListener view$OnFocusChangeListener) {
        this.b();
        final ViewTreeObserver viewTreeObserver = ((View)this).getViewTreeObserver();
        if (viewTreeObserver.isAlive() && this.l == null) {
            viewTreeObserver.addOnGlobalFocusChangeListener(this.l = (ViewTreeObserver$OnGlobalFocusChangeListener)new ViewTreeObserver$OnGlobalFocusChangeListener(this, view$OnFocusChangeListener, this) {
                final View$OnFocusChangeListener e;
                final View f;
                final a g;
                
                public void onGlobalFocusChanged(final View view, View f) {
                    final View$OnFocusChangeListener e = this.e;
                    f = this.f;
                    e.onFocusChange(f, b2.i.c(f));
                }
            });
        }
    }
}
