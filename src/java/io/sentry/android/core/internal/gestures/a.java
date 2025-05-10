package io.sentry.android.core.internal.gestures;

import io.sentry.internal.gestures.b$a;
import android.widget.ScrollView;
import android.widget.AbsListView;
import androidx.core.view.ScrollingView;
import android.content.res.Resources$NotFoundException;
import io.sentry.internal.gestures.b;
import android.view.View;

public final class a implements io.sentry.internal.gestures.a
{
    private final boolean a;
    private final int[] b;
    
    public a(final boolean a) {
        this.b = new int[2];
        this.a = a;
    }
    
    private b b(final View view) {
        try {
            final String b = j.b(view);
            String s;
            if ((s = view.getClass().getCanonicalName()) == null) {
                s = view.getClass().getSimpleName();
            }
            return new b((Object)view, s, b, (String)null);
        }
        catch (final Resources$NotFoundException ex) {
            return null;
        }
    }
    
    private static boolean c(final View view, final boolean b) {
        return b && ScrollingView.class.isAssignableFrom(view.getClass());
    }
    
    private static boolean d(final View view, final boolean b) {
        return (c(view, b) || AbsListView.class.isAssignableFrom(view.getClass()) || ScrollView.class.isAssignableFrom(view.getClass())) && view.getVisibility() == 0;
    }
    
    private static boolean e(final View view) {
        return view.isClickable() && view.getVisibility() == 0;
    }
    
    private boolean f(final View view, final float n, final float n2) {
        view.getLocationOnScreen(this.b);
        final int[] b = this.b;
        final boolean b2 = false;
        final int n3 = b[0];
        final int n4 = b[1];
        final int width = view.getWidth();
        final int height = view.getHeight();
        boolean b3 = b2;
        if (n >= n3) {
            b3 = b2;
            if (n <= n3 + width) {
                b3 = b2;
                if (n2 >= n4) {
                    b3 = b2;
                    if (n2 <= n4 + height) {
                        b3 = true;
                    }
                }
            }
        }
        return b3;
    }
    
    public b a(final Object o, final float n, final float n2, final b$a b$a) {
        if (!(o instanceof View)) {
            return null;
        }
        final View view = (View)o;
        if (this.f(view, n, n2)) {
            if (b$a == b$a.CLICKABLE && e(view)) {
                return this.b(view);
            }
            if (b$a == b$a.SCROLLABLE && d(view, this.a)) {
                return this.b(view);
            }
        }
        return null;
    }
}
