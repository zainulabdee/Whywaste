package b2;

import android.view.ViewGroup;
import android.content.ContextWrapper;
import android.app.Activity;
import android.content.Context;
import android.view.View;

public final class i
{
    public static boolean c(final View view) {
        return i(view, (a)new g());
    }
    
    public static int d(final int n) {
        return View.generateViewId();
    }
    
    public static Activity e(final Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity)context;
        }
        if (context instanceof ContextWrapper) {
            return e(((ContextWrapper)context).getBaseContext());
        }
        return null;
    }
    
    public static boolean f(final View view, final Class<? extends View>[] array) {
        return i(view, (a)new h((Class[])array));
    }
    
    public static boolean i(final View view, final a a) {
        if (view == null) {
            return false;
        }
        if (a.a(view)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            final ViewGroup viewGroup = (ViewGroup)view;
            for (int i = 0; i < viewGroup.getChildCount(); ++i) {
                if (i(viewGroup.getChildAt(i), a)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public interface a
    {
        boolean a(final View p0);
    }
}
