package io.flutter.plugin.platform;

import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import android.view.MotionEvent;
import io.flutter.view.g;

class a
{
    private g a;
    
    public boolean a(final MotionEvent motionEvent, final boolean b) {
        final g a = this.a;
        return a != null && a.K(motionEvent, b);
    }
    
    public boolean b(final View view, final View view2, final AccessibilityEvent accessibilityEvent) {
        final g a = this.a;
        return a != null && a.x(view, view2, accessibilityEvent);
    }
    
    void c(final g a) {
        this.a = a;
    }
}
