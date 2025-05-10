package io.sentry.android.core.internal.gestures;

import io.sentry.q4;
import java.util.Collection;
import java.util.Queue;
import android.content.res.Resources;
import android.content.res.Resources$NotFoundException;
import java.util.Iterator;
import io.sentry.internal.gestures.a;
import android.view.ViewGroup;
import io.sentry.util.n;
import java.util.LinkedList;
import io.sentry.internal.gestures.b;
import android.view.View;
import io.sentry.android.core.SentryAndroidOptions;

public final class j
{
    static b a(final SentryAndroidOptions sentryAndroidOptions, final View view, final float n, final float n2, final b.a a) {
        final LinkedList list = new LinkedList();
        ((Queue)list).add((Object)view);
        b b = null;
    Label_0021:
        while (((Collection)list).size() > 0) {
            final View view2 = n.c(((Queue)list).poll(), "view is required");
            if (view2 instanceof ViewGroup) {
                final ViewGroup viewGroup = (ViewGroup)view2;
                for (int i = 0; i < viewGroup.getChildCount(); ++i) {
                    ((Queue)list).add((Object)viewGroup.getChildAt(i));
                }
            }
            final Iterator iterator = ((q4)sentryAndroidOptions).getGestureTargetLocators().iterator();
            b b2 = b;
            b a2;
            while (true) {
                b = b2;
                if (!iterator.hasNext()) {
                    continue Label_0021;
                }
                a2 = ((a)iterator.next()).a(view2, n, n2, a);
                if (a2 == null) {
                    continue;
                }
                if (a != io.sentry.internal.gestures.b.a.CLICKABLE) {
                    break;
                }
                b2 = a2;
            }
            return a2;
        }
        return b;
    }
    
    public static String b(final View view) {
        final int id = view.getId();
        if (id == -1 || c(id)) {
            throw new Resources$NotFoundException();
        }
        final Resources resources = view.getContext().getResources();
        if (resources != null) {
            return resources.getResourceEntryName(id);
        }
        return "";
    }
    
    private static boolean c(final int n) {
        return (0xFF000000 & n) == 0x0 && (n & 0xFFFFFF) != 0x0;
    }
}
