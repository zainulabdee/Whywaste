package io.flutter.plugin.platform;

import io.flutter.embedding.android.b0$a;
import android.view.MotionEvent;
import io.flutter.view.g;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import android.view.MotionEvent$PointerProperties;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import android.view.MotionEvent$PointerCoords;
import android.view.ViewGroup;
import android.os.Build$VERSION;
import android.content.MutableContextWrapper;
import io.flutter.view.s$c;
import android.view.View$OnFocusChangeListener;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout$LayoutParams;
import android.view.SurfaceView;
import io.flutter.embedding.android.b0;
import java.util.HashSet;
import android.util.SparseArray;
import android.view.View;
import java.util.HashMap;
import s1.k;
import io.flutter.plugin.editing.m;
import io.flutter.view.s;
import io.flutter.embedding.android.r;
import android.content.Context;
import io.flutter.embedding.android.a;

public class v implements p
{
    private static Class[] w;
    private final l a;
    private a b;
    private Context c;
    private r d;
    private s e;
    private m f;
    private k g;
    private final io.flutter.plugin.platform.a h;
    final HashMap<Integer, w> i;
    final HashMap<Context, View> j;
    private final SparseArray<i> k;
    private final SparseArray<j1.a> l;
    private final SparseArray<b> m;
    private final SparseArray<o> n;
    private int o;
    private boolean p;
    private boolean q;
    private final HashSet<Integer> r;
    private final HashSet<Integer> s;
    private final b0 t;
    private boolean u;
    private final k.g v;
    
    static {
        v.w = new Class[] { SurfaceView.class };
    }
    
    public v() {
        this.o = 0;
        this.p = false;
        this.q = true;
        this.u = false;
        this.v = new k.g() {
            final v a;
            
            private void m(final i i, final d d) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Using hybrid composition for platform view: ");
                sb.append(d.a);
                f1.b.e("PlatformViewsController", sb.toString());
            }
            
            private long n(final i i, final d d) {
                this.q(23);
                final StringBuilder sb = new StringBuilder();
                sb.append("Hosting view in view hierarchy for platform view: ");
                sb.append(d.a);
                f1.b.e("PlatformViewsController", sb.toString());
                final int y = this.a.l0(d.c);
                final int y2 = this.a.l0(d.d);
                o o;
                long d2;
                if (this.a.u) {
                    o = new o(this.a.c);
                    d2 = -1L;
                }
                else {
                    final s$c a = this.a.e.a();
                    o = new o(this.a.c, a);
                    d2 = a.d();
                }
                o.m(this.a.b);
                o.i(y, y2);
                final FrameLayout$LayoutParams frameLayout$LayoutParams = new FrameLayout$LayoutParams(y, y2);
                final int y3 = this.a.l0(d.e);
                final int y4 = this.a.l0(d.f);
                frameLayout$LayoutParams.topMargin = y3;
                frameLayout$LayoutParams.leftMargin = y4;
                o.j(frameLayout$LayoutParams);
                final View view = i.getView();
                view.setLayoutParams((ViewGroup$LayoutParams)new FrameLayout$LayoutParams(y, y2));
                view.setImportantForAccessibility(4);
                ((ViewGroup)o).addView(view);
                o.k((View$OnFocusChangeListener)new io.flutter.plugin.platform.s(this, d));
                ((ViewGroup)this.a.d).addView((View)o);
                this.a.n.append(d.a, (Object)o);
                return d2;
            }
            
            private long o(final i i, final d d) {
                this.q(20);
                final StringBuilder sb = new StringBuilder();
                sb.append("Hosting view in a virtual display for platform view: ");
                sb.append(d.a);
                f1.b.e("PlatformViewsController", sb.toString());
                final s$c a = this.a.e.a();
                final w a2 = io.flutter.plugin.platform.w.a(this.a.c, this.a.h, i, a, this.a.l0(d.c), this.a.l0(d.d), d.a, (Object)null, (View$OnFocusChangeListener)new t(this, d));
                if (a2 != null) {
                    if (this.a.d != null) {
                        a2.f((View)this.a.d);
                    }
                    this.a.i.put((Object)d.a, (Object)a2);
                    final View view = i.getView();
                    this.a.j.put((Object)view.getContext(), (Object)view);
                    return a.d();
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Failed creating virtual display for a ");
                sb2.append(d.b);
                sb2.append(" with id: ");
                sb2.append(d.a);
                throw new IllegalStateException(sb2.toString());
            }
            
            private i p(final d d, final boolean b) {
                final j b2 = this.a.a.b(d.b);
                if (b2 == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Trying to create a platform view of unregistered type: ");
                    sb.append(d.b);
                    throw new IllegalStateException(sb.toString());
                }
                Object b3 = null;
                if (d.i != null) {
                    b3 = b2.b().b(d.i);
                }
                Object j;
                if (b) {
                    j = new MutableContextWrapper(this.a.c);
                }
                else {
                    j = this.a.c;
                }
                final i a = b2.a((Context)j, d.a, b3);
                final View view = a.getView();
                if (view != null) {
                    view.setLayoutDirection(d.g);
                    this.a.k.put(d.a, (Object)a);
                    return a;
                }
                throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
            }
            
            private void q(final int n) {
                final int sdk_INT = Build$VERSION.SDK_INT;
                if (sdk_INT >= n) {
                    return;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Trying to use platform views with API ");
                sb.append(sdk_INT);
                sb.append(", required API level is: ");
                sb.append(n);
                throw new IllegalStateException(sb.toString());
            }
            
            private void r(final d d) {
                if (n0(d.g)) {
                    return;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Trying to create a view with unknown direction value: ");
                sb.append(d.g);
                sb.append("(view id: ");
                sb.append(d.a);
                sb.append(")");
                throw new IllegalStateException(sb.toString());
            }
            
            @Override
            public void a(final boolean b) {
                this.a.q = b;
            }
            
            @Override
            public void b(int y, final double n, final double n2) {
                if (this.a.b(y)) {
                    return;
                }
                final o o = (o)this.a.n.get(y);
                if (o == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Setting offset for unknown platform view with id: ");
                    sb.append(y);
                    f1.b.b("PlatformViewsController", sb.toString());
                    return;
                }
                y = this.a.l0(n);
                final int y2 = this.a.l0(n2);
                final FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams)((View)o).getLayoutParams();
                frameLayout$LayoutParams.topMargin = y;
                frameLayout$LayoutParams.leftMargin = y2;
                o.j(frameLayout$LayoutParams);
            }
            
            @Override
            public void c(final int n, final int layoutDirection) {
                if (!n0(layoutDirection)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Trying to set unknown direction value: ");
                    sb.append(layoutDirection);
                    sb.append("(view id: ");
                    sb.append(n);
                    sb.append(")");
                    throw new IllegalStateException(sb.toString());
                }
                View view;
                if (this.a.b(n)) {
                    view = ((w)this.a.i.get((Object)n)).e();
                }
                else {
                    final i i = (i)this.a.k.get(n);
                    if (i == null) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("Setting direction to an unknown view with id: ");
                        sb2.append(n);
                        f1.b.b("PlatformViewsController", sb2.toString());
                        return;
                    }
                    view = i.getView();
                }
                if (view == null) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Setting direction to a null view with id: ");
                    sb3.append(n);
                    f1.b.b("PlatformViewsController", sb3.toString());
                    return;
                }
                view.setLayoutDirection(layoutDirection);
            }
            
            @Override
            public void d(final e e, final b b) {
                final int y = this.a.l0(e.b);
                final int y2 = this.a.l0(e.c);
                final int a = e.a;
                if (this.a.b(a)) {
                    final float z = this.a.O();
                    final w w = (w)this.a.i.get((Object)a);
                    this.a.U(w);
                    w.i(y, y2, (Runnable)new u(this, w, z, b));
                    return;
                }
                final i i = (i)this.a.k.get(a);
                final o o = (o)this.a.n.get(a);
                if (i != null && o != null) {
                    if (y > o.e() || y2 > o.d()) {
                        o.i(y, y2);
                    }
                    final ViewGroup$LayoutParams layoutParams = ((View)o).getLayoutParams();
                    layoutParams.width = y;
                    layoutParams.height = y2;
                    ((View)o).setLayoutParams(layoutParams);
                    final View view = i.getView();
                    if (view != null) {
                        final ViewGroup$LayoutParams layoutParams2 = view.getLayoutParams();
                        layoutParams2.width = y;
                        layoutParams2.height = y2;
                        view.setLayoutParams(layoutParams2);
                    }
                    b.a(new k.c(this.a.i0(o.e()), this.a.i0(o.d())));
                    return;
                }
                final StringBuilder sb = new StringBuilder();
                sb.append("Resizing unknown platform view with id: ");
                sb.append(a);
                f1.b.b("PlatformViewsController", sb.toString());
            }
            
            @Override
            public void e(final f f) {
                final int a = f.a;
                final float density = this.a.c.getResources().getDisplayMetrics().density;
                if (this.a.b(a)) {
                    ((w)this.a.i.get((Object)a)).b(this.a.k0(density, f, true));
                    return;
                }
                final i i = (i)this.a.k.get(a);
                if (i == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Sending touch to an unknown view with id: ");
                    sb.append(a);
                    f1.b.b("PlatformViewsController", sb.toString());
                    return;
                }
                final View view = i.getView();
                if (view == null) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Sending touch to a null view with id: ");
                    sb2.append(a);
                    f1.b.b("PlatformViewsController", sb2.toString());
                    return;
                }
                view.dispatchTouchEvent(this.a.k0(density, f, false));
            }
            
            @Override
            public void f(final int n) {
                View view;
                if (this.a.b(n)) {
                    view = ((w)this.a.i.get((Object)n)).e();
                }
                else {
                    final i i = (i)this.a.k.get(n);
                    if (i == null) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("Clearing focus on an unknown view with id: ");
                        sb.append(n);
                        f1.b.b("PlatformViewsController", sb.toString());
                        return;
                    }
                    view = i.getView();
                }
                if (view == null) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Clearing focus on a null view with id: ");
                    sb2.append(n);
                    f1.b.b("PlatformViewsController", sb2.toString());
                    return;
                }
                view.clearFocus();
            }
            
            @Override
            public void g(final d d) {
                this.q(19);
                this.r(d);
                this.m(this.p(d, false), d);
            }
            
            @Override
            public void h(final int n) {
                final i i = (i)this.a.k.get(n);
                if (i == null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Disposing unknown platform view with id: ");
                    sb.append(n);
                    f1.b.b("PlatformViewsController", sb.toString());
                    return;
                }
                this.a.k.remove(n);
                try {
                    i.d();
                }
                catch (final RuntimeException ex) {
                    f1.b.c("PlatformViewsController", "Disposing platform view threw an exception", (Throwable)ex);
                }
                if (this.a.b(n)) {
                    final View e = ((w)this.a.i.get((Object)n)).e();
                    if (e != null) {
                        this.a.j.remove((Object)e.getContext());
                    }
                    this.a.i.remove((Object)n);
                    return;
                }
                final o o = (o)this.a.n.get(n);
                if (o != null) {
                    ((ViewGroup)o).removeAllViews();
                    o.h();
                    o.o();
                    final ViewGroup viewGroup = (ViewGroup)((View)o).getParent();
                    if (viewGroup != null) {
                        viewGroup.removeView((View)o);
                    }
                    this.a.n.remove(n);
                    return;
                }
                final j1.a a = (j1.a)this.a.l.get(n);
                if (a != null) {
                    ((ViewGroup)a).removeAllViews();
                    a.b();
                    final ViewGroup viewGroup2 = (ViewGroup)((View)a).getParent();
                    if (viewGroup2 != null) {
                        viewGroup2.removeView((View)a);
                    }
                    this.a.l.remove(n);
                }
            }
            
            @Override
            public long i(final d d) {
                this.r(d);
                final int a = d.a;
                if (this.a.n.get(a) != null) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Trying to create an already created platform view, view id: ");
                    sb.append(a);
                    throw new IllegalStateException(sb.toString());
                }
                if (this.a.e == null) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Texture registry is null. This means that platform views controller was detached, view id: ");
                    sb2.append(a);
                    throw new IllegalStateException(sb2.toString());
                }
                if (this.a.d == null) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: ");
                    sb3.append(a);
                    throw new IllegalStateException(sb3.toString());
                }
                boolean b = true;
                final i p = this.p(d, true);
                final View view = p.getView();
                if (view.getParent() == null) {
                    if (Build$VERSION.SDK_INT < 23 || b2.i.f(view, io.flutter.plugin.platform.v.w)) {
                        b = false;
                    }
                    if (!b) {
                        if (d.h == s1.k.d.a.f) {
                            this.m(p, d);
                            return -2L;
                        }
                        if (!this.a.u) {
                            return this.o(p, d);
                        }
                    }
                    return this.n(p, d);
                }
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
        };
        this.a = new l();
        this.i = (HashMap<Integer, w>)new HashMap();
        this.h = new io.flutter.plugin.platform.a();
        this.j = (HashMap<Context, View>)new HashMap();
        this.m = (SparseArray<b>)new SparseArray();
        this.r = (HashSet<Integer>)new HashSet();
        this.s = (HashSet<Integer>)new HashSet();
        this.n = (SparseArray<o>)new SparseArray();
        this.k = (SparseArray<i>)new SparseArray();
        this.l = (SparseArray<j1.a>)new SparseArray();
        this.t = b0.a();
    }
    
    private void M() {
        while (this.k.size() > 0) {
            this.v.h(this.k.keyAt(0));
        }
    }
    
    private void N(boolean b) {
        for (int i = 0; i < this.m.size(); ++i) {
            final int key = this.m.keyAt(i);
            final b b2 = (b)this.m.valueAt(i);
            if (this.r.contains((Object)key)) {
                this.d.n((io.flutter.embedding.android.j)b2);
                b &= ((io.flutter.embedding.android.j)b2).d();
            }
            else {
                if (!this.p) {
                    ((io.flutter.embedding.android.j)b2).a();
                }
                ((View)b2).setVisibility(8);
                ((ViewGroup)this.d).removeView((View)b2);
            }
        }
        for (int j = 0; j < this.l.size(); ++j) {
            final int key2 = this.l.keyAt(j);
            final View view = (View)this.l.get(key2);
            if (this.s.contains((Object)key2) && (b || !this.q)) {
                view.setVisibility(0);
            }
            else {
                view.setVisibility(8);
            }
        }
    }
    
    private float O() {
        return this.c.getResources().getDisplayMetrics().density;
    }
    
    private void R() {
        if (this.q && !this.p) {
            this.d.q();
            this.p = true;
        }
    }
    
    private void U(final w w) {
        final m f = this.f;
        if (f == null) {
            return;
        }
        f.u();
        w.g();
    }
    
    private static MotionEvent$PointerCoords c0(final Object o, final float n) {
        final List list = (List)o;
        final MotionEvent$PointerCoords motionEvent$PointerCoords = new MotionEvent$PointerCoords();
        motionEvent$PointerCoords.orientation = (float)(double)list.get(0);
        motionEvent$PointerCoords.pressure = (float)(double)list.get(1);
        motionEvent$PointerCoords.size = (float)(double)list.get(2);
        motionEvent$PointerCoords.toolMajor = (float)(double)list.get(3) * n;
        motionEvent$PointerCoords.toolMinor = (float)(double)list.get(4) * n;
        motionEvent$PointerCoords.touchMajor = (float)(double)list.get(5) * n;
        motionEvent$PointerCoords.touchMinor = (float)(double)list.get(6) * n;
        motionEvent$PointerCoords.x = (float)(double)list.get(7) * n;
        motionEvent$PointerCoords.y = (float)(double)list.get(8) * n;
        return motionEvent$PointerCoords;
    }
    
    private static List<MotionEvent$PointerCoords> d0(final Object o, final float n) {
        final List list = (List)o;
        final ArrayList list2 = new ArrayList();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ((List)list2).add((Object)c0(iterator.next(), n));
        }
        return (List<MotionEvent$PointerCoords>)list2;
    }
    
    private static MotionEvent$PointerProperties e0(final Object o) {
        final List list = (List)o;
        final MotionEvent$PointerProperties motionEvent$PointerProperties = new MotionEvent$PointerProperties();
        motionEvent$PointerProperties.id = (int)list.get(0);
        motionEvent$PointerProperties.toolType = (int)list.get(1);
        return motionEvent$PointerProperties;
    }
    
    private static List<MotionEvent$PointerProperties> f0(final Object o) {
        final List list = (List)o;
        final ArrayList list2 = new ArrayList();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            ((List)list2).add((Object)e0(iterator.next()));
        }
        return (List<MotionEvent$PointerProperties>)list2;
    }
    
    private void g0() {
        if (this.d == null) {
            f1.b.b("PlatformViewsController", "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i = 0; i < this.m.size(); ++i) {
            ((ViewGroup)this.d).removeView((View)this.m.valueAt(i));
        }
        this.m.clear();
    }
    
    private int i0(final double n) {
        return this.j0(n, this.O());
    }
    
    private int j0(final double n, final float n2) {
        return (int)Math.round(n / n2);
    }
    
    private int l0(final double n) {
        return (int)Math.round(n * this.O());
    }
    
    private void m0(final w w) {
        final m f = this.f;
        if (f == null) {
            return;
        }
        f.G();
        w.h();
    }
    
    private static boolean n0(final int n) {
        boolean b = true;
        if (n != 0) {
            b = (n == 1 && b);
        }
        return b;
    }
    
    public void B(final Context c, final s e, final g1.a a) {
        if (this.c == null) {
            this.c = c;
            this.e = e;
            (this.g = new k(a)).e(this.v);
            return;
        }
        throw new AssertionError((Object)"A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
    }
    
    public void C(final m f) {
        this.f = f;
    }
    
    public void D(final r1.a a) {
        this.b = new a(a, true);
    }
    
    public void E(final r d) {
        this.d = d;
        final int n = 0;
        for (int i = 0; i < this.n.size(); ++i) {
            ((ViewGroup)this.d).addView((View)this.n.valueAt(i));
        }
        int n2 = 0;
        int j;
        while (true) {
            j = n;
            if (n2 >= this.l.size()) {
                break;
            }
            ((ViewGroup)this.d).addView((View)this.l.valueAt(n2));
            ++n2;
        }
        while (j < this.k.size()) {
            ((i)this.k.valueAt(j)).f((View)this.d);
            ++j;
        }
    }
    
    public boolean F(final View view) {
        if (view == null) {
            return false;
        }
        if (!this.j.containsKey((Object)view.getContext())) {
            return false;
        }
        final View view2 = (View)this.j.get((Object)view.getContext());
        return view2 == view || view2.checkInputConnectionProxy(view);
    }
    
    public FlutterOverlaySurface G() {
        return this.H(new b(((View)this.d).getContext(), ((View)this.d).getWidth(), ((View)this.d).getHeight(), this.h));
    }
    
    public FlutterOverlaySurface H(final b b) {
        final int n = this.o++;
        this.m.put(n, (Object)b);
        return new FlutterOverlaySurface(n, ((io.flutter.embedding.android.j)b).getSurface());
    }
    
    public void I() {
        for (int i = 0; i < this.m.size(); ++i) {
            final b b = (b)this.m.valueAt(i);
            ((io.flutter.embedding.android.j)b).a();
            ((io.flutter.embedding.android.j)b).f();
        }
    }
    
    public void J() {
        final k g = this.g;
        if (g != null) {
            g.e(null);
        }
        this.I();
        this.g = null;
        this.c = null;
        this.e = null;
    }
    
    public void K() {
        final int n = 0;
        for (int i = 0; i < this.n.size(); ++i) {
            ((ViewGroup)this.d).removeView((View)this.n.valueAt(i));
        }
        for (int j = 0; j < this.l.size(); ++j) {
            ((ViewGroup)this.d).removeView((View)this.l.valueAt(j));
        }
        this.I();
        this.g0();
        this.d = null;
        this.p = false;
        for (int k = n; k < this.k.size(); ++k) {
            ((i)this.k.valueAt(k)).g();
        }
    }
    
    public void L() {
        this.f = null;
    }
    
    public io.flutter.plugin.platform.k P() {
        return (io.flutter.plugin.platform.k)this.a;
    }
    
    void Q(final int n) {
        final i i = (i)this.k.get(n);
        if (i == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        }
        if (this.l.get(n) != null) {
            return;
        }
        final View view = i.getView();
        if (view == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        if (view.getParent() == null) {
            final Context c = this.c;
            final j1.a a = new j1.a(c, c.getResources().getDisplayMetrics().density, this.b);
            a.setOnDescendantFocusChangeListener((View$OnFocusChangeListener)new q(this, n));
            this.l.put(n, (Object)a);
            view.setImportantForAccessibility(4);
            ((ViewGroup)a).addView(view);
            ((ViewGroup)this.d).addView((View)a);
            return;
        }
        throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
    }
    
    public void V() {
    }
    
    public void W() {
        this.r.clear();
        this.s.clear();
    }
    
    public void X() {
        this.M();
    }
    
    public void Y(final int n, final int leftMargin, final int topMargin, final int n2, final int n3) {
        if (this.m.get(n) != null) {
            this.R();
            final b b = (b)this.m.get(n);
            if (((View)b).getParent() == null) {
                ((ViewGroup)this.d).addView((View)b);
            }
            final FrameLayout$LayoutParams layoutParams = new FrameLayout$LayoutParams(n2, n3);
            layoutParams.leftMargin = leftMargin;
            layoutParams.topMargin = topMargin;
            ((View)b).setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            ((View)b).setVisibility(0);
            ((View)b).bringToFront();
            this.r.add((Object)n);
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("The overlay surface (id:");
        sb.append(n);
        sb.append(") doesn't exist");
        throw new IllegalStateException(sb.toString());
    }
    
    public void Z(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final int n7, final FlutterMutatorsStack flutterMutatorsStack) {
        this.R();
        this.Q(n);
        final j1.a a = (j1.a)this.l.get(n);
        a.a(flutterMutatorsStack, n2, n3, n4, n5);
        ((View)a).setVisibility(0);
        ((View)a).bringToFront();
        final FrameLayout$LayoutParams layoutParams = new FrameLayout$LayoutParams(n6, n7);
        final View view = ((i)this.k.get(n)).getView();
        if (view != null) {
            view.setLayoutParams((ViewGroup$LayoutParams)layoutParams);
            view.bringToFront();
        }
        this.s.add((Object)n);
    }
    
    public void a(final g g) {
        this.h.c(g);
    }
    
    public void a0() {
        final boolean p = this.p;
        final boolean b = false;
        if (p && this.s.isEmpty()) {
            this.p = false;
            this.d.D((Runnable)new io.flutter.plugin.platform.r(this));
            return;
        }
        boolean b2 = b;
        if (this.p) {
            b2 = b;
            if (this.d.k()) {
                b2 = true;
            }
        }
        this.N(b2);
    }
    
    public boolean b(final int n) {
        return this.i.containsKey((Object)n);
    }
    
    public void b0() {
        this.M();
    }
    
    public View c(final int n) {
        if (this.b(n)) {
            return ((w)this.i.get((Object)n)).e();
        }
        final i i = (i)this.k.get(n);
        if (i == null) {
            return null;
        }
        return i.getView();
    }
    
    public void d() {
        this.h.c((g)null);
    }
    
    public void h0(final boolean u) {
        this.u = u;
    }
    
    public MotionEvent k0(final float n, final k.f f, final boolean b) {
        final MotionEvent b2 = this.t.b(b0$a.c(f.p));
        final MotionEvent$PointerProperties[] array = (MotionEvent$PointerProperties[])f0(f.f).toArray((Object[])new MotionEvent$PointerProperties[f.e]);
        final MotionEvent$PointerCoords[] array2 = (MotionEvent$PointerCoords[])d0(f.g, n).toArray((Object[])new MotionEvent$PointerCoords[f.e]);
        if (!b && b2 != null) {
            return MotionEvent.obtain(b2.getDownTime(), b2.getEventTime(), f.d, f.e, array, array2, b2.getMetaState(), b2.getButtonState(), b2.getXPrecision(), b2.getYPrecision(), b2.getDeviceId(), b2.getEdgeFlags(), b2.getSource(), b2.getFlags());
        }
        return MotionEvent.obtain(f.b.longValue(), f.c.longValue(), f.d, f.e, array, array2, f.h, f.i, f.j, f.k, f.l, f.m, f.n, f.o);
    }
}
