package io.sentry.android.core.internal.util;

import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import android.view.View$OnAttachStateChangeListener;
import io.sentry.android.core.l0;
import android.os.Looper;
import android.view.View;
import java.util.concurrent.atomic.AtomicReference;
import android.os.Handler;
import android.view.ViewTreeObserver$OnDrawListener;

public class l implements ViewTreeObserver$OnDrawListener
{
    private final Handler e;
    private final AtomicReference<View> f;
    private final Runnable g;
    
    private l(final View view, final Runnable g) {
        this.e = new Handler(Looper.getMainLooper());
        this.f = (AtomicReference<View>)new AtomicReference((Object)view);
        this.g = g;
    }
    
    private static boolean b(final View view, final l0 l0) {
        return view.getViewTreeObserver().isAlive() && c(view, l0);
    }
    
    private static boolean c(final View view, final l0 l0) {
        if (l0.d() >= 19) {
            return view.isAttachedToWindow();
        }
        return view.getWindowToken() != null;
    }
    
    public static void e(final View view, final Runnable runnable, final l0 l0) {
        final l i = new l(view, runnable);
        if (l0.d() < 26 && !b(view, l0)) {
            view.addOnAttachStateChangeListener((View$OnAttachStateChangeListener)new View$OnAttachStateChangeListener(i) {
                final l e;
                
                public void onViewAttachedToWindow(final View view) {
                    view.getViewTreeObserver().addOnDrawListener((ViewTreeObserver$OnDrawListener)this.e);
                    view.removeOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
                }
                
                public void onViewDetachedFromWindow(final View view) {
                    view.removeOnAttachStateChangeListener((View$OnAttachStateChangeListener)this);
                }
            });
        }
        else {
            view.getViewTreeObserver().addOnDrawListener((ViewTreeObserver$OnDrawListener)i);
        }
    }
    
    public void onDraw() {
        final View view = (View)this.f.getAndSet((Object)null);
        if (view == null) {
            return;
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver$OnGlobalLayoutListener)new k(this, view));
        this.e.postAtFrontOfQueue(this.g);
    }
}
