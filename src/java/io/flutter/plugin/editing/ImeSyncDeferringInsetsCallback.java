package io.flutter.plugin.editing;

import android.view.View$OnApplyWindowInsetsListener;
import android.view.WindowInsetsAnimation$Callback;
import android.view.View;
import android.view.WindowInsets;

class ImeSyncDeferringInsetsCallback
{
    private boolean animating;
    private ImeSyncDeferringInsetsCallback.ImeSyncDeferringInsetsCallback$AnimationCallback animationCallback;
    private int deferredInsetTypes;
    private b insetsListener;
    private WindowInsets lastWindowInsets;
    private boolean needsSave;
    private int overlayInsetTypes;
    private View view;
    
    ImeSyncDeferringInsetsCallback(final View view, final int overlayInsetTypes, final int deferredInsetTypes) {
        this.animating = false;
        this.needsSave = false;
        this.overlayInsetTypes = overlayInsetTypes;
        this.deferredInsetTypes = deferredInsetTypes;
        this.view = view;
        this.animationCallback = new ImeSyncDeferringInsetsCallback.ImeSyncDeferringInsetsCallback$AnimationCallback(this);
        this.insetsListener = new b();
    }
    
    WindowInsetsAnimation$Callback getAnimationCallback() {
        return (WindowInsetsAnimation$Callback)this.animationCallback;
    }
    
    View$OnApplyWindowInsetsListener getInsetsListener() {
        return (View$OnApplyWindowInsetsListener)this.insetsListener;
    }
    
    void install() {
        io.flutter.plugin.editing.b.a(this.view, (WindowInsetsAnimation$Callback)this.animationCallback);
        this.view.setOnApplyWindowInsetsListener((View$OnApplyWindowInsetsListener)this.insetsListener);
    }
    
    void remove() {
        io.flutter.plugin.editing.b.a(this.view, (WindowInsetsAnimation$Callback)null);
        this.view.setOnApplyWindowInsetsListener((View$OnApplyWindowInsetsListener)null);
    }
    
    private class b implements View$OnApplyWindowInsetsListener
    {
        final ImeSyncDeferringInsetsCallback a;
        
        private b(final ImeSyncDeferringInsetsCallback a) {
            this.a = a;
        }
        
        public WindowInsets onApplyWindowInsets(final View view, final WindowInsets windowInsets) {
            this.a.view = view;
            if (this.a.needsSave) {
                this.a.lastWindowInsets = windowInsets;
                this.a.needsSave = false;
            }
            if (this.a.animating) {
                return WindowInsets.CONSUMED;
            }
            return view.onApplyWindowInsets(windowInsets);
        }
    }
}
