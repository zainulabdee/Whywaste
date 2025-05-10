package io.sentry.android.core;

import io.sentry.e4;
import io.sentry.w;
import io.sentry.a0;
import io.sentry.z0;
import io.sentry.android.core.internal.gestures.j;
import android.view.Window;
import java.util.concurrent.TimeUnit;
import io.sentry.protocol.b0;
import io.sentry.util.thread.b;
import android.app.Activity;
import io.sentry.l4;
import java.util.Iterator;
import java.util.ArrayList;
import android.view.ViewGroup;
import io.sentry.protocol.c0;
import io.sentry.n0;
import java.util.concurrent.CountDownLatch;
import java.util.List;
import android.view.View;
import java.util.concurrent.atomic.AtomicReference;
import io.sentry.android.core.internal.util.a;
import io.sentry.util.n;
import io.sentry.android.core.internal.util.i;
import io.sentry.a1;
import io.sentry.x;

public final class ViewHierarchyEventProcessor implements x, a1
{
    private final SentryAndroidOptions e;
    private final i f;
    
    public ViewHierarchyEventProcessor(final SentryAndroidOptions sentryAndroidOptions) {
        this.e = (SentryAndroidOptions)n.c((Object)sentryAndroidOptions, "SentryAndroidOptions is required");
        this.f = new i(a.b(), 2000L);
        if (sentryAndroidOptions.isAttachViewHierarchy()) {
            this.g();
        }
    }
    
    private static void f(final View view, final c0 c0, final List<io.sentry.internal.viewhierarchy.a> list) {
        if (!(view instanceof ViewGroup)) {
            return;
        }
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            if (((io.sentry.internal.viewhierarchy.a)iterator.next()).a(c0, (Object)view)) {
                return;
            }
        }
        final ViewGroup viewGroup = (ViewGroup)view;
        final int childCount = viewGroup.getChildCount();
        if (childCount == 0) {
            return;
        }
        final ArrayList list2 = new ArrayList(childCount);
        for (int i = 0; i < childCount; ++i) {
            final View child = viewGroup.getChildAt(i);
            if (child != null) {
                final c0 k = k(child);
                ((List)list2).add((Object)k);
                f(child, k, list);
            }
        }
        c0.m((List<c0>)list2);
    }
    
    public static b0 i(final Activity activity, final List<io.sentry.internal.viewhierarchy.a> list, final b b, final n0 n0) {
        if (activity == null) {
            n0.a(l4.INFO, "Missing activity for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        final Window window = activity.getWindow();
        if (window == null) {
            n0.a(l4.INFO, "Missing window for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        final View peekDecorView = window.peekDecorView();
        if (peekDecorView == null) {
            n0.a(l4.INFO, "Missing decor view for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        try {
            if (b.c()) {
                return j(peekDecorView, list);
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final AtomicReference atomicReference = new AtomicReference((Object)null);
            activity.runOnUiThread((Runnable)new g1(atomicReference, peekDecorView, (List)list, countDownLatch, n0));
            if (countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                return (b0)atomicReference.get();
            }
        }
        finally {
            final Throwable t;
            n0.d(l4.ERROR, "Failed to process view hierarchy.", t);
        }
        return null;
    }
    
    public static b0 j(final View view, final List<io.sentry.internal.viewhierarchy.a> list) {
        final ArrayList list2 = new ArrayList(1);
        final b0 b0 = new b0("android_view_system", (List<c0>)list2);
        final c0 k = k(view);
        ((List)list2).add((Object)k);
        f(view, k, list);
        return b0;
    }
    
    private static c0 k(final View view) {
        final c0 c0 = new c0();
        String s;
        if ((s = view.getClass().getCanonicalName()) == null) {
            s = view.getClass().getSimpleName();
        }
        c0.p(s);
        while (true) {
            try {
                c0.o(j.b(view));
                c0.t((double)view.getX());
                c0.u((double)view.getY());
                c0.s((double)view.getWidth());
                c0.n((double)view.getHeight());
                c0.l((double)view.getAlpha());
                final int visibility = view.getVisibility();
                if (visibility != 0) {
                    if (visibility != 4) {
                        if (visibility == 8) {
                            c0.r("gone");
                        }
                    }
                    else {
                        c0.r("invisible");
                    }
                }
                else {
                    c0.r("visible");
                }
                return c0;
            }
            finally {
                continue;
            }
            break;
        }
    }
    
    public e4 c(final e4 e4, final a0 a0) {
        if (!e4.v0()) {
            return e4;
        }
        if (!this.e.isAttachViewHierarchy()) {
            this.e.getLogger().a(l4.DEBUG, "attachViewHierarchy is disabled.", new Object[0]);
            return e4;
        }
        if (io.sentry.util.j.h(a0)) {
            return e4;
        }
        final boolean a2 = this.f.a();
        final SentryAndroidOptions.SentryAndroidOptions$a beforeViewHierarchyCaptureCallback = this.e.getBeforeViewHierarchyCaptureCallback();
        if (beforeViewHierarchyCaptureCallback != null) {
            if (!beforeViewHierarchyCaptureCallback.a(e4, a0, a2)) {
                return e4;
            }
        }
        else if (a2) {
            return e4;
        }
        final b0 i = i(io.sentry.android.core.n0.c().b(), (List<io.sentry.internal.viewhierarchy.a>)this.e.getViewHierarchyExporters(), this.e.getMainThreadChecker(), this.e.getLogger());
        if (i != null) {
            a0.m(io.sentry.b.c(i));
        }
        return e4;
    }
    
    public /* synthetic */ void g() {
        z0.a((a1)this);
    }
}
