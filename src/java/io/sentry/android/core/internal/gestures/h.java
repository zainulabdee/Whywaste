package io.sentry.android.core.internal.gestures;

import android.view.ActionMode$Callback;
import android.view.WindowManager$LayoutParams;
import android.view.SearchEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.view.ActionMode;
import io.sentry.l4;
import android.view.accessibility.AccessibilityEvent;
import android.view.KeyEvent;
import io.sentry.h5;
import android.view.MotionEvent;
import android.view.GestureDetector$OnGestureListener;
import android.content.Context;
import io.sentry.q4;
import androidx.core.view.GestureDetectorCompat;
import android.view.Window$Callback;

public final class h extends m
{
    private final Window$Callback f;
    private final g g;
    private final GestureDetectorCompat h;
    private final q4 i;
    private final h$b j;
    
    public h(final Window$Callback window$Callback, final Context context, final g g, final q4 q4) {
        this(window$Callback, new GestureDetectorCompat(context, (GestureDetector$OnGestureListener)g), g, q4, (h$b)new h$b() {});
    }
    
    h(final Window$Callback f, final GestureDetectorCompat h, final g g, final q4 i, final h$b j) {
        super(f);
        this.f = f;
        this.g = g;
        this.i = i;
        this.h = h;
        this.j = j;
    }
    
    private void b(final MotionEvent motionEvent) {
        this.h.a(motionEvent);
        if (motionEvent.getActionMasked() == 1) {
            this.g.n(motionEvent);
        }
    }
    
    public Window$Callback a() {
        return this.f;
    }
    
    public void c() {
        this.g.p(h5.CANCELLED);
    }
    
    public boolean dispatchTouchEvent(final MotionEvent motionEvent) {
        if (motionEvent != null) {
            final MotionEvent a = this.j.a(motionEvent);
            while (true) {
                try {
                    this.b(a);
                    a.recycle();
                }
                finally {
                    try {
                        if (this.i != null) {
                            final Throwable t;
                            this.i.getLogger().d(l4.ERROR, "Error dispatching touch event", t);
                        }
                        continue;
                    }
                    finally {
                        a.recycle();
                    }
                }
                break;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
