package io.flutter.embedding.android;

import android.view.View;
import android.os.Bundle;
import android.content.Context;
import android.animation.Animator$AnimatorListener;
import android.widget.ImageView$ScaleType;
import android.graphics.drawable.Drawable;

@Deprecated
public final class b implements e0
{
    private final Drawable a;
    private final ImageView$ScaleType b;
    private final long c;
    private b.b$b d;
    
    public b(final Drawable drawable) {
        this(drawable, ImageView$ScaleType.FIT_XY, 500L);
    }
    
    public b(final Drawable a, final ImageView$ScaleType b, final long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void a(final Runnable runnable) {
        final b.b$b d = this.d;
        if (d == null) {
            runnable.run();
            return;
        }
        ((View)d).animate().alpha(0.0f).setDuration(this.c).setListener((Animator$AnimatorListener)new b$a(this, runnable));
    }
    
    public View c(final Context context, final Bundle bundle) {
        (this.d = new b.b$b(context)).a(this.a, this.b);
        return (View)this.d;
    }
}
