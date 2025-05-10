package io.sentry.android.core.internal.gestures;

import io.sentry.g5;
import io.sentry.u0;
import java.lang.ref.Reference;
import io.sentry.q4;
import java.util.Collections;
import io.sentry.s2;
import io.sentry.p5;
import io.sentry.protocol.z;
import io.sentry.r5;
import io.sentry.h5;
import io.sentry.util.v;
import android.view.Window;
import io.sentry.n0;
import io.sentry.l4;
import android.view.View;
import io.sentry.e;
import io.sentry.a0;
import android.view.MotionEvent;
import java.util.Map;
import io.sentry.r2;
import io.sentry.v0;
import io.sentry.internal.gestures.b;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.m0;
import android.app.Activity;
import java.lang.ref.WeakReference;
import android.view.GestureDetector$OnGestureListener;

public final class g implements GestureDetector$OnGestureListener
{
    private final WeakReference<Activity> a;
    private final m0 b;
    private final SentryAndroidOptions c;
    private io.sentry.internal.gestures.b d;
    private v0 e;
    private String f;
    private final b g;
    
    public g(final Activity activity, final m0 b, final SentryAndroidOptions c) {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new b();
        this.a = (WeakReference<Activity>)new WeakReference((Object)activity);
        this.b = b;
        this.c = c;
    }
    
    private void e(final io.sentry.internal.gestures.b b, final String s, final Map<String, Object> map, final MotionEvent motionEvent) {
        if (!((q4)this.c).isEnableUserInteractionBreadcrumbs()) {
            return;
        }
        final a0 a0 = new a0();
        a0.j("android:motionEvent", motionEvent);
        a0.j("android:view", b.e());
        this.b.k(io.sentry.e.s(s, b.c(), b.a(), b.d(), (Map)map), a0);
    }
    
    private View h(final String s) {
        final Activity activity = (Activity)((Reference)this.a).get();
        if (activity == null) {
            final n0 logger = ((q4)this.c).getLogger();
            final l4 debug = l4.DEBUG;
            final StringBuilder sb = new StringBuilder();
            sb.append("Activity is null in ");
            sb.append(s);
            sb.append(". No breadcrumb captured.");
            logger.a(debug, sb.toString(), new Object[0]);
            return null;
        }
        final Window window = activity.getWindow();
        if (window == null) {
            final n0 logger2 = ((q4)this.c).getLogger();
            final l4 debug2 = l4.DEBUG;
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("Window is null in ");
            sb2.append(s);
            sb2.append(". No breadcrumb captured.");
            logger2.a(debug2, sb2.toString(), new Object[0]);
            return null;
        }
        final View decorView = window.getDecorView();
        if (decorView == null) {
            final n0 logger3 = ((q4)this.c).getLogger();
            final l4 debug3 = l4.DEBUG;
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("DecorView is null in ");
            sb3.append(s);
            sb3.append(". No breadcrumb captured.");
            logger3.a(debug3, sb3.toString(), new Object[0]);
            return null;
        }
        return decorView;
    }
    
    private String i(final Activity activity) {
        return activity.getClass().getSimpleName();
    }
    
    private void o(final io.sentry.internal.gestures.b b, final String s) {
        final io.sentry.internal.gestures.b d = this.d;
        if (!((q4)this.c).isTracingEnabled() || !((q4)this.c).isEnableUserInteractionTracing()) {
            if (!b.equals(d) || !s.equals((Object)this.f)) {
                v.h(this.b);
                this.d = b;
                this.f = s;
            }
            return;
        }
        final Activity activity = (Activity)((Reference)this.a).get();
        if (activity == null) {
            ((q4)this.c).getLogger().a(l4.DEBUG, "Activity is null, no transaction captured.", new Object[0]);
            return;
        }
        final String b2 = b.b();
        if (this.e != null) {
            if (b.equals(d) && s.equals((Object)this.f) && !((u0)this.e).e()) {
                final n0 logger = ((q4)this.c).getLogger();
                final l4 debug = l4.DEBUG;
                final StringBuilder sb = new StringBuilder();
                sb.append("The view with id: ");
                sb.append(b2);
                sb.append(" already has an ongoing transaction assigned. Rescheduling finish");
                logger.a(debug, sb.toString(), new Object[0]);
                if (((q4)this.c).getIdleTimeout() != null) {
                    this.e.h();
                }
                return;
            }
            this.p(h5.OK);
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(this.i(activity));
        sb2.append(".");
        sb2.append(b2);
        final String string = sb2.toString();
        final StringBuilder sb3 = new StringBuilder();
        sb3.append("ui.action.");
        sb3.append(s);
        final String string2 = sb3.toString();
        final r5 r5 = new r5();
        r5.n(true);
        r5.k(((q4)this.c).getIdleTimeout());
        ((g5)r5).d(true);
        final v0 i = this.b.i(new p5(string, z.COMPONENT, string2), r5);
        this.b.l((s2)new d(this, i));
        this.e = i;
        this.d = b;
        this.f = s;
    }
    
    void f(final r2 r2, final v0 v0) {
        r2.J((r2.c)new f(this, r2, v0));
    }
    
    void g(final r2 r2) {
        r2.J((r2.c)new io.sentry.android.core.internal.gestures.e(this, r2));
    }
    
    public void n(final MotionEvent motionEvent) {
        final View h = this.h("onUp");
        final io.sentry.internal.gestures.b a = this.g.b;
        if (h != null) {
            if (a != null) {
                if (this.g.a == null) {
                    ((q4)this.c).getLogger().a(l4.DEBUG, "Unable to define scroll type. No breadcrumb captured.", new Object[0]);
                    return;
                }
                this.e(a, this.g.a, (Map<String, Object>)Collections.singletonMap((Object)"direction", (Object)this.g.i(motionEvent)), motionEvent);
                this.o(a, this.g.a);
                this.g.j();
            }
        }
    }
    
    public boolean onDown(final MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        this.g.j();
        this.g.c = motionEvent.getX();
        this.g.d = motionEvent.getY();
        return false;
    }
    
    public boolean onFling(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
        this.g.a = "swipe";
        return false;
    }
    
    public void onLongPress(final MotionEvent motionEvent) {
    }
    
    public boolean onScroll(final MotionEvent motionEvent, final MotionEvent motionEvent2, final float n, final float n2) {
        final View h = this.h("onScroll");
        if (h != null) {
            if (motionEvent != null) {
                if (this.g.a == null) {
                    final io.sentry.internal.gestures.b a = j.a(this.c, h, motionEvent.getX(), motionEvent.getY(), io.sentry.internal.gestures.b.a.SCROLLABLE);
                    if (a == null) {
                        ((q4)this.c).getLogger().a(l4.DEBUG, "Unable to find scroll target. No breadcrumb captured.", new Object[0]);
                        return false;
                    }
                    final n0 logger = ((q4)this.c).getLogger();
                    final l4 debug = l4.DEBUG;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Scroll target found: ");
                    sb.append(a.b());
                    logger.a(debug, sb.toString(), new Object[0]);
                    this.g.k(a);
                    this.g.a = "scroll";
                }
            }
        }
        return false;
    }
    
    public void onShowPress(final MotionEvent motionEvent) {
    }
    
    public boolean onSingleTapUp(final MotionEvent motionEvent) {
        final View h = this.h("onSingleTapUp");
        if (h != null) {
            if (motionEvent != null) {
                final io.sentry.internal.gestures.b a = j.a(this.c, h, motionEvent.getX(), motionEvent.getY(), io.sentry.internal.gestures.b.a.CLICKABLE);
                if (a == null) {
                    ((q4)this.c).getLogger().a(l4.DEBUG, "Unable to find click target. No breadcrumb captured.", new Object[0]);
                    return false;
                }
                this.e(a, "click", (Map<String, Object>)Collections.emptyMap(), motionEvent);
                this.o(a, "click");
            }
        }
        return false;
    }
    
    void p(final h5 h5) {
        final v0 e = this.e;
        if (e != null) {
            ((u0)e).j(h5);
        }
        this.b.l((s2)new c(this));
        this.e = null;
        if (this.d != null) {
            this.d = null;
        }
        this.f = null;
    }
    
    private static final class b
    {
        private String a;
        private io.sentry.internal.gestures.b b;
        private float c;
        private float d;
        
        private b() {
            this.a = null;
            this.c = 0.0f;
            this.d = 0.0f;
        }
        
        private String i(final MotionEvent motionEvent) {
            final float n = motionEvent.getX() - this.c;
            final float n2 = motionEvent.getY() - this.d;
            String s;
            if (Math.abs(n) > Math.abs(n2)) {
                if (n > 0.0f) {
                    s = "right";
                }
                else {
                    s = "left";
                }
            }
            else if (n2 > 0.0f) {
                s = "down";
            }
            else {
                s = "up";
            }
            return s;
        }
        
        private void j() {
            this.b = null;
            this.a = null;
            this.c = 0.0f;
            this.d = 0.0f;
        }
        
        private void k(final io.sentry.internal.gestures.b b) {
            this.b = b;
        }
    }
}
