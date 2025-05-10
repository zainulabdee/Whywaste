package io.flutter.embedding.android;

import android.view.ViewGroup;
import java.util.List;
import androidx.window.layout.FoldingFeature$State;
import androidx.window.layout.FoldingFeature$OcclusionType;
import androidx.window.layout.FoldingFeature;
import androidx.window.layout.DisplayFeature;
import java.util.ArrayList;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.WindowInfoTracker;
import android.view.ViewStructure;
import android.view.MotionEvent;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.EditorInfo;
import android.content.res.Configuration;
import android.app.Activity;
import b2.i;
import android.view.DisplayCutout;
import android.graphics.Insets;
import androidx.core.view.a0;
import androidx.core.view.f0;
import android.view.WindowInsets$Type;
import androidx.core.view.c0;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.graphics.Rect;
import android.view.PointerIcon;
import android.view.autofill.AutofillValue;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.text.format.DateFormat;
import android.provider.Settings$System;
import java.util.function.Predicate;
import android.view.View;
import android.view.WindowInsets;
import android.os.Build$VERSION;
import android.view.WindowManager;
import android.view.textservice.SpellCheckerInfo;
import android.view.ViewConfiguration;
import java.util.Iterator;
import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import android.util.AttributeSet;
import android.content.Context;
import android.database.ContentObserver;
import io.flutter.view.g$k;
import android.view.textservice.TextServicesManager;
import io.flutter.view.g;
import io.flutter.plugin.editing.f;
import io.flutter.plugin.editing.m;
import java.util.Set;
import r1.c;
import androidx.window.layout.WindowLayoutInfo;
import androidx.core.util.a;
import v1.b;
import android.widget.FrameLayout;

public class r extends FrameLayout implements c, z$e
{
    private final a<WindowLayoutInfo> A;
    private k e;
    private l f;
    private j g;
    r1.c h;
    private r1.c i;
    private final Set<r1.b> j;
    private boolean k;
    private io.flutter.embedding.engine.a l;
    private final Set<r.r$f> m;
    private b n;
    private m o;
    private f p;
    private u1.b q;
    private z r;
    private io.flutter.embedding.android.a s;
    private g t;
    private TextServicesManager u;
    private g0 v;
    private final r1.a.g w;
    private final g$k x;
    private final ContentObserver y;
    private final r1.b z;
    
    private r(final Context context, final AttributeSet set, final k k) {
        super(context, set);
        this.j = (Set<r1.b>)new HashSet();
        this.m = (Set<r.r$f>)new HashSet();
        this.w = new r1.a.g();
        this.x = (g$k)new g$k() {
            final r a;
            
            public void a(final boolean b, final boolean b2) {
                this.a.C(b, b2);
            }
        };
        this.y = (ContentObserver)new r$b(this, new Handler(Looper.getMainLooper()));
        this.z = new r1.b() {
            final r a;
            
            @Override
            public void c() {
                this.a.k = false;
                final Iterator iterator = this.a.j.iterator();
                while (iterator.hasNext()) {
                    ((r1.b)iterator.next()).c();
                }
            }
            
            @Override
            public void f() {
                this.a.k = true;
                final Iterator iterator = this.a.j.iterator();
                while (iterator.hasNext()) {
                    ((r1.b)iterator.next()).f();
                }
            }
        };
        this.A = (a<WindowLayoutInfo>)new a<WindowLayoutInfo>() {
            final r a;
            
            public void a(final WindowLayoutInfo windowInfoListenerDisplayFeatures) {
                this.a.setWindowInfoListenerDisplayFeatures(windowInfoListenerDisplayFeatures);
            }
        };
        this.e = k;
        this.h = k;
        this.w();
    }
    
    private r(final Context context, final AttributeSet set, final l l) {
        super(context, set);
        this.j = (Set<r1.b>)new HashSet();
        this.m = (Set<r.r$f>)new HashSet();
        this.w = new r1.a.g();
        this.x = (g$k)new g$k() {
            final r a;
            
            public void a(final boolean b, final boolean b2) {
                this.a.C(b, b2);
            }
        };
        this.y = (ContentObserver)new r$b(this, new Handler(Looper.getMainLooper()));
        this.z = new r1.b() {
            final r a;
            
            @Override
            public void c() {
                this.a.k = false;
                final Iterator iterator = this.a.j.iterator();
                while (iterator.hasNext()) {
                    ((r1.b)iterator.next()).c();
                }
            }
            
            @Override
            public void f() {
                this.a.k = true;
                final Iterator iterator = this.a.j.iterator();
                while (iterator.hasNext()) {
                    ((r1.b)iterator.next()).f();
                }
            }
        };
        this.A = (a<WindowLayoutInfo>)new a<WindowLayoutInfo>() {
            final r a;
            
            public void a(final WindowLayoutInfo windowInfoListenerDisplayFeatures) {
                this.a.setWindowInfoListenerDisplayFeatures(windowInfoListenerDisplayFeatures);
            }
        };
        this.f = l;
        this.h = l;
        this.w();
    }
    
    public r(final Context context, final k k) {
        this(context, null, k);
    }
    
    public r(final Context context, final l l) {
        this(context, null, l);
    }
    
    private void C(final boolean b, final boolean b2) {
        final boolean k = this.l.q().k();
        final boolean b3 = false;
        if (!k) {
            boolean willNotDraw = b3;
            if (!b) {
                willNotDraw = b3;
                if (!b2) {
                    willNotDraw = true;
                }
            }
            ((View)this).setWillNotDraw(willNotDraw);
        }
        else {
            ((View)this).setWillNotDraw(false);
        }
    }
    
    private void F() {
        if (!this.x()) {
            f1.b.g("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.w.a = ((View)this).getResources().getDisplayMetrics().density;
        this.w.p = ViewConfiguration.get(((View)this).getContext()).getScaledTouchSlop();
        this.l.q().r(this.w);
    }
    
    private r.r$g p() {
        final Context context = ((View)this).getContext();
        final int orientation = context.getResources().getConfiguration().orientation;
        final int rotation = ((WindowManager)context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (orientation == 2) {
            if (rotation == 1) {
                return io.flutter.embedding.android.r.r$g.g;
            }
            if (rotation == 3) {
                r.r$g r$g;
                if (Build$VERSION.SDK_INT >= 23) {
                    r$g = io.flutter.embedding.android.r.r$g.f;
                }
                else {
                    r$g = io.flutter.embedding.android.r.r$g.g;
                }
                return r$g;
            }
            if (rotation == 0 || rotation == 2) {
                return io.flutter.embedding.android.r.r$g.h;
            }
        }
        return io.flutter.embedding.android.r.r$g.e;
    }
    
    private int u(final WindowInsets windowInsets) {
        if (windowInsets.getSystemWindowInsetBottom() < ((View)this).getRootView().getHeight() * 0.18) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }
    
    private void w() {
        f1.b.f("FlutterView", "Initializing FlutterView");
        if (this.e != null) {
            f1.b.f("FlutterView", "Internally using a FlutterSurfaceView.");
            ((ViewGroup)this).addView((View)this.e);
        }
        else if (this.f != null) {
            f1.b.f("FlutterView", "Internally using a FlutterTextureView.");
            ((ViewGroup)this).addView((View)this.f);
        }
        else {
            f1.b.f("FlutterView", "Internally using a FlutterImageView.");
            ((ViewGroup)this).addView((View)this.g);
        }
        ((View)this).setFocusable(true);
        ((View)this).setFocusableInTouchMode(true);
        if (Build$VERSION.SDK_INT >= 26) {
            this.setImportantForAutofill(1);
        }
    }
    
    private void z() {
        final j g = this.g;
        if (g != null) {
            g.f();
            ((ViewGroup)this).removeView((View)this.g);
            this.g = null;
        }
    }
    
    public void A(final r.r$f r$f) {
        this.m.remove((Object)r$f);
    }
    
    public void B(final r1.b b) {
        this.j.remove((Object)b);
    }
    
    public void D(final Runnable runnable) {
        if (this.g == null) {
            f1.b.f("FlutterView", "Tried to revert the image view, but no image view is used.");
            return;
        }
        final r1.c i = this.i;
        if (i == null) {
            f1.b.f("FlutterView", "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.h = i;
        this.i = null;
        final r1.a q = this.l.q();
        if (this.l != null && q != null) {
            this.h.c(q);
            q.f((r1.b)new r1.b(this, q, runnable) {
                final r1.a a;
                final Runnable b;
                final r c;
                
                @Override
                public void c() {
                }
                
                @Override
                public void f() {
                    this.a.p((r1.b)this);
                    this.b.run();
                    final r c = this.c;
                    if (!(c.h instanceof j) && c.g != null) {
                        this.c.g.a();
                        this.c.z();
                    }
                }
            });
            return;
        }
        this.g.a();
        this.z();
        runnable.run();
    }
    
    void E() {
        final int uiMode = ((View)this).getResources().getConfiguration().uiMode;
        final boolean b = false;
        s1.m.b b2;
        if ((uiMode & 0x30) == 0x20) {
            b2 = s1.m.b.g;
        }
        else {
            b2 = s1.m.b.f;
        }
        final TextServicesManager u = this.u;
        boolean b3 = false;
        Label_0107: {
            Label_0105: {
                if (u != null) {
                    if (Build$VERSION.SDK_INT >= 31) {
                        final boolean anyMatch = io.flutter.embedding.android.o.a(io.flutter.embedding.android.n.a(u)).anyMatch((Predicate)new q());
                        if (!io.flutter.embedding.android.p.a(this.u) || !anyMatch) {
                            break Label_0105;
                        }
                    }
                    b3 = true;
                    break Label_0107;
                }
            }
            b3 = false;
        }
        final s1.m.a c = this.l.s().a().e(((View)this).getResources().getConfiguration().fontScale).c(b3);
        boolean b4 = b;
        if (Settings$System.getInt(((View)this).getContext().getContentResolver(), "show_password", 1) == 1) {
            b4 = true;
        }
        c.b(b4).f(DateFormat.is24HourFormat(((View)this).getContext())).d(b2).a();
    }
    
    public void a(final KeyEvent keyEvent) {
        ((View)this).getRootView().dispatchKeyEvent(keyEvent);
    }
    
    public void autofill(final SparseArray<AutofillValue> sparseArray) {
        this.o.j(sparseArray);
    }
    
    public PointerIcon b(final int n) {
        return PointerIcon.getSystemIcon(((View)this).getContext(), n);
    }
    
    public boolean c(final KeyEvent keyEvent) {
        return this.o.r(keyEvent);
    }
    
    public boolean checkInputConnectionProxy(final View view) {
        final io.flutter.embedding.engine.a l = this.l;
        boolean b;
        if (l != null) {
            b = l.o().F(view);
        }
        else {
            b = super.checkInputConnectionProxy(view);
        }
        return b;
    }
    
    public boolean dispatchKeyEvent(final KeyEvent keyEvent) {
        final int action = keyEvent.getAction();
        final boolean b = true;
        if (action == 0 && keyEvent.getRepeatCount() == 0) {
            ((View)this).getKeyDispatcherState().startTracking(keyEvent, (Object)this);
        }
        else if (keyEvent.getAction() == 1) {
            ((View)this).getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        if (this.x()) {
            final boolean b2 = b;
            if (this.r.a(keyEvent)) {
                return b2;
            }
        }
        return super.dispatchKeyEvent(keyEvent) && b;
    }
    
    protected boolean fitSystemWindows(final Rect rect) {
        return super.fitSystemWindows(rect);
    }
    
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        final g t = this.t;
        if (t != null && t.D()) {
            return (AccessibilityNodeProvider)this.t;
        }
        return null;
    }
    
    public io.flutter.embedding.engine.a getAttachedFlutterEngine() {
        return this.l;
    }
    
    public t1.c getBinaryMessenger() {
        return this.l.i();
    }
    
    public j getCurrentImageSurface() {
        return this.g;
    }
    
    public boolean k() {
        final j g = this.g;
        return g != null && g.d();
    }
    
    public void l(final r.r$f r$f) {
        this.m.add((Object)r$f);
    }
    
    public void m(final r1.b b) {
        this.j.add((Object)b);
    }
    
    public void n(final j j) {
        final io.flutter.embedding.engine.a l = this.l;
        if (l != null) {
            j.c(l.q());
        }
    }
    
    public void o(final io.flutter.embedding.engine.a l) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Attaching to a FlutterEngine: ");
        sb.append((Object)l);
        f1.b.f("FlutterView", sb.toString());
        if (this.x()) {
            if (l == this.l) {
                f1.b.f("FlutterView", "Already attached to this engine. Doing nothing.");
                return;
            }
            f1.b.f("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
            this.t();
        }
        this.l = l;
        final r1.a q = l.q();
        this.k = q.j();
        this.h.c(q);
        q.f(this.z);
        if (Build$VERSION.SDK_INT >= 24) {
            this.n = new b((b.c)this, this.l.l());
        }
        this.o = new m((View)this, this.l.v(), this.l.o());
        try {
            final TextServicesManager u = (TextServicesManager)((View)this).getContext().getSystemService("textservices");
            this.u = u;
            this.p = new f(u, this.l.t());
        }
        catch (final Exception ex) {
            f1.b.b("FlutterView", "TextServicesManager not supported by device, spell check disabled.");
        }
        this.q = this.l.k();
        this.r = new z((z.z$e)this);
        this.s = new io.flutter.embedding.android.a(this.l.q(), false);
        (this.t = new g((View)this, l.g(), (AccessibilityManager)((View)this).getContext().getSystemService("accessibility"), ((View)this).getContext().getContentResolver(), (io.flutter.plugin.platform.p)this.l.o())).Y(this.x);
        this.C(this.t.D(), this.t.E());
        this.l.o().a(this.t);
        this.l.o().D(this.l.q());
        this.o.q().restartInput((View)this);
        this.E();
        ((View)this).getContext().getContentResolver().registerContentObserver(Settings$System.getUriFor("show_password"), false, this.y);
        this.F();
        l.o().E(this);
        final Iterator iterator = this.m.iterator();
        while (iterator.hasNext()) {
            ((r.r$f)iterator.next()).b(l);
        }
        if (this.k) {
            this.z.f();
        }
    }
    
    public final WindowInsets onApplyWindowInsets(final WindowInsets windowInsets) {
        final WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT == 29) {
            final Insets a = c0.a(windowInsets);
            final r1.a.g w = this.w;
            w.l = a.top;
            w.m = a.right;
            w.n = a.bottom;
            w.o = a.left;
        }
        final int windowSystemUiVisibility = ((View)this).getWindowSystemUiVisibility();
        boolean b = true;
        int n = 0;
        final boolean b2 = (windowSystemUiVisibility & 0x4) == 0x0;
        if ((((View)this).getWindowSystemUiVisibility() & 0x2) != 0x0) {
            b = false;
        }
        if (sdk_INT >= 30) {
            if (b) {
                n = (0x0 | WindowInsets$Type.navigationBars());
            }
            int n2 = n;
            if (b2) {
                n2 = (n | WindowInsets$Type.statusBars());
            }
            final Insets a2 = f0.a(windowInsets, n2);
            final r1.a.g w2 = this.w;
            w2.d = a2.top;
            w2.e = a2.right;
            w2.f = a2.bottom;
            w2.g = a2.left;
            final Insets a3 = f0.a(windowInsets, WindowInsets$Type.ime());
            final r1.a.g w3 = this.w;
            w3.h = a3.top;
            w3.i = a3.right;
            w3.j = a3.bottom;
            w3.k = a3.left;
            final Insets a4 = f0.a(windowInsets, WindowInsets$Type.systemGestures());
            final r1.a.g w4 = this.w;
            w4.l = a4.top;
            w4.m = a4.right;
            w4.n = a4.bottom;
            w4.o = a4.left;
            final DisplayCutout a5 = a0.a(windowInsets);
            if (a5 != null) {
                final Insets a6 = io.flutter.embedding.android.m.a(a5);
                final r1.a.g w5 = this.w;
                w5.d = Math.max(Math.max(w5.d, a6.top), a5.getSafeInsetTop());
                final r1.a.g w6 = this.w;
                w6.e = Math.max(Math.max(w6.e, a6.right), a5.getSafeInsetRight());
                final r1.a.g w7 = this.w;
                w7.f = Math.max(Math.max(w7.f, a6.bottom), a5.getSafeInsetBottom());
                final r1.a.g w8 = this.w;
                w8.g = Math.max(Math.max(w8.g, a6.left), a5.getSafeInsetLeft());
            }
        }
        else {
            r.r$g r$g = io.flutter.embedding.android.r.r$g.e;
            if (!b) {
                r$g = this.p();
            }
            final r1.a.g w9 = this.w;
            int systemWindowInsetTop;
            if (b2) {
                systemWindowInsetTop = windowInsets.getSystemWindowInsetTop();
            }
            else {
                systemWindowInsetTop = 0;
            }
            w9.d = systemWindowInsetTop;
            final r1.a.g w10 = this.w;
            int systemWindowInsetRight;
            if (r$g != io.flutter.embedding.android.r.r$g.g && r$g != io.flutter.embedding.android.r.r$g.h) {
                systemWindowInsetRight = windowInsets.getSystemWindowInsetRight();
            }
            else {
                systemWindowInsetRight = 0;
            }
            w10.e = systemWindowInsetRight;
            final r1.a.g w11 = this.w;
            int systemWindowInsetBottom;
            if (b && this.u(windowInsets) == 0) {
                systemWindowInsetBottom = windowInsets.getSystemWindowInsetBottom();
            }
            else {
                systemWindowInsetBottom = 0;
            }
            w11.f = systemWindowInsetBottom;
            final r1.a.g w12 = this.w;
            int systemWindowInsetLeft;
            if (r$g != io.flutter.embedding.android.r.r$g.f && r$g != io.flutter.embedding.android.r.r$g.h) {
                systemWindowInsetLeft = windowInsets.getSystemWindowInsetLeft();
            }
            else {
                systemWindowInsetLeft = 0;
            }
            w12.g = systemWindowInsetLeft;
            final r1.a.g w13 = this.w;
            w13.h = 0;
            w13.i = 0;
            w13.j = this.u(windowInsets);
            this.w.k = 0;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: ");
        sb.append(this.w.d);
        sb.append(", Left: ");
        sb.append(this.w.g);
        sb.append(", Right: ");
        sb.append(this.w.e);
        sb.append("\nKeyboard insets: Bottom: ");
        sb.append(this.w.j);
        sb.append(", Left: ");
        sb.append(this.w.k);
        sb.append(", Right: ");
        sb.append(this.w.i);
        sb.append("System Gesture Insets - Left: ");
        sb.append(this.w.o);
        sb.append(", Top: ");
        sb.append(this.w.l);
        sb.append(", Right: ");
        sb.append(this.w.m);
        sb.append(", Bottom: ");
        sb.append(this.w.j);
        f1.b.f("FlutterView", sb.toString());
        this.F();
        return onApplyWindowInsets;
    }
    
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.v = this.s();
        final Activity e = b2.i.e(((View)this).getContext());
        final g0 v = this.v;
        if (v != null && e != null) {
            v.a(e, androidx.core.content.a.d(((View)this).getContext()), (a)this.A);
        }
    }
    
    protected void onConfigurationChanged(final Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.l != null) {
            f1.b.f("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
            this.q.d(configuration);
            this.E();
        }
    }
    
    public InputConnection onCreateInputConnection(final EditorInfo editorInfo) {
        if (!this.x()) {
            return super.onCreateInputConnection(editorInfo);
        }
        return this.o.o((View)this, this.r, editorInfo);
    }
    
    protected void onDetachedFromWindow() {
        final g0 v = this.v;
        if (v != null) {
            v.b((a)this.A);
        }
        this.v = null;
        super.onDetachedFromWindow();
    }
    
    public boolean onGenericMotionEvent(final MotionEvent motionEvent) {
        final boolean x = this.x();
        boolean onGenericMotionEvent = true;
        if (!x || !this.s.e(motionEvent)) {
            onGenericMotionEvent = super.onGenericMotionEvent(motionEvent);
        }
        return onGenericMotionEvent;
    }
    
    public boolean onHoverEvent(final MotionEvent motionEvent) {
        if (!this.x()) {
            return super.onHoverEvent(motionEvent);
        }
        return this.t.J(motionEvent);
    }
    
    public void onProvideAutofillVirtualStructure(final ViewStructure viewStructure, final int n) {
        super.onProvideAutofillVirtualStructure(viewStructure, n);
        this.o.z(viewStructure, n);
    }
    
    protected void onSizeChanged(final int b, final int c, final int n, final int n2) {
        super.onSizeChanged(b, c, n, n2);
        final StringBuilder sb = new StringBuilder();
        sb.append("Size changed. Sending Flutter new viewport metrics. FlutterView was ");
        sb.append(n);
        sb.append(" x ");
        sb.append(n2);
        sb.append(", it is now ");
        sb.append(b);
        sb.append(" x ");
        sb.append(c);
        f1.b.f("FlutterView", sb.toString());
        final r1.a.g w = this.w;
        w.b = b;
        w.c = c;
        this.F();
    }
    
    public boolean onTouchEvent(final MotionEvent motionEvent) {
        if (!this.x()) {
            return super.onTouchEvent(motionEvent);
        }
        ((View)this).requestUnbufferedDispatch(motionEvent);
        return this.s.f(motionEvent);
    }
    
    public void q() {
        this.h.b();
        final j g = this.g;
        if (g == null) {
            ((ViewGroup)this).addView((View)(this.g = this.r()));
        }
        else {
            g.j(((View)this).getWidth(), ((View)this).getHeight());
        }
        this.i = this.h;
        final j g2 = this.g;
        this.h = g2;
        final io.flutter.embedding.engine.a l = this.l;
        if (l != null) {
            g2.c(l.q());
        }
    }
    
    public j r() {
        return new j(((View)this).getContext(), ((View)this).getWidth(), ((View)this).getHeight(), j$b.e);
    }
    
    protected g0 s() {
        try {
            return new g0(new WindowInfoTrackerCallbackAdapter(WindowInfoTracker.Companion.getOrCreate(((View)this).getContext())));
        }
        catch (final NoClassDefFoundError noClassDefFoundError) {
            return null;
        }
    }
    
    public void setVisibility(final int n) {
        super.setVisibility(n);
        final r1.c h = this.h;
        if (h instanceof k) {
            ((View)h).setVisibility(n);
        }
    }
    
    protected void setWindowInfoListenerDisplayFeatures(final WindowLayoutInfo windowLayoutInfo) {
        final List displayFeatures = windowLayoutInfo.getDisplayFeatures();
        final ArrayList q = new ArrayList();
        for (final DisplayFeature displayFeature : displayFeatures) {
            final StringBuilder sb = new StringBuilder();
            sb.append("WindowInfoTracker Display Feature reported with bounds = ");
            sb.append(displayFeature.getBounds().toString());
            sb.append(" and type = ");
            sb.append(displayFeature.getClass().getSimpleName());
            f1.b.f("FlutterView", sb.toString());
            if (displayFeature instanceof FoldingFeature) {
                final FoldingFeature foldingFeature = (FoldingFeature)displayFeature;
                r1.a.d d;
                if (foldingFeature.getOcclusionType() == FoldingFeature$OcclusionType.FULL) {
                    d = r1.a.d.h;
                }
                else {
                    d = r1.a.d.g;
                }
                r1.a.c c;
                if (foldingFeature.getState() == FoldingFeature$State.FLAT) {
                    c = r1.a.c.g;
                }
                else if (foldingFeature.getState() == FoldingFeature$State.HALF_OPENED) {
                    c = r1.a.c.h;
                }
                else {
                    c = r1.a.c.f;
                }
                ((List)q).add((Object)new r1.a.b(displayFeature.getBounds(), d, c));
            }
            else {
                ((List)q).add((Object)new r1.a.b(displayFeature.getBounds(), r1.a.d.f, r1.a.c.f));
            }
        }
        if (Build$VERSION.SDK_INT >= 28) {
            final WindowInsets rootWindowInsets = this.getRootWindowInsets();
            if (rootWindowInsets != null) {
                final DisplayCutout a = a0.a(rootWindowInsets);
                if (a != null) {
                    for (final Rect rect : a.getBoundingRects()) {
                        final StringBuilder sb2 = new StringBuilder();
                        sb2.append("DisplayCutout area reported with bounds = ");
                        sb2.append(rect.toString());
                        f1.b.f("FlutterView", sb2.toString());
                        ((List)q).add((Object)new r1.a.b(rect, r1.a.d.i));
                    }
                }
            }
        }
        this.w.q = (List<r1.a.b>)q;
        this.F();
    }
    
    public void t() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Detaching from a FlutterEngine: ");
        sb.append((Object)this.l);
        f1.b.f("FlutterView", sb.toString());
        if (!this.x()) {
            f1.b.f("FlutterView", "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        final Iterator iterator = this.m.iterator();
        while (iterator.hasNext()) {
            ((r.r$f)iterator.next()).a();
        }
        ((View)this).getContext().getContentResolver().unregisterContentObserver(this.y);
        this.l.o().K();
        this.l.o().d();
        this.t.Q();
        this.t = null;
        this.o.q().restartInput((View)this);
        this.o.p();
        this.r.c();
        final f p = this.p;
        if (p != null) {
            p.b();
        }
        final b n = this.n;
        if (n != null) {
            n.c();
        }
        final r1.a q = this.l.q();
        this.k = false;
        q.p(this.z);
        q.t();
        q.q(false);
        final r1.c i = this.i;
        if (i != null && this.h == this.g) {
            this.h = i;
        }
        this.h.a();
        this.z();
        this.i = null;
        this.l = null;
    }
    
    public boolean v() {
        return this.k;
    }
    
    public boolean x() {
        final io.flutter.embedding.engine.a l = this.l;
        return l != null && l.q() == this.h.getAttachedRenderer();
    }
}
