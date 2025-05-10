package io.flutter.plugin.platform;

import android.view.MotionEvent;
import io.flutter.embedding.android.j$b;
import android.content.Context;
import io.flutter.embedding.android.j;

public class b extends j
{
    private a k;
    
    public b(final Context context, final int n, final int n2, final a k) {
        super(context, n, n2, j$b.f);
        this.k = k;
    }
    
    public boolean onHoverEvent(final MotionEvent motionEvent) {
        final a k = this.k;
        return (k != null && k.a(motionEvent, true)) || super.onHoverEvent(motionEvent);
    }
}
