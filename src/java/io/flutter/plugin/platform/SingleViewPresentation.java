package io.flutter.plugin.platform;

import android.app.Dialog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import android.view.ViewGroup$LayoutParams;
import java.lang.reflect.InvocationHandler;
import android.app.AlertDialog;
import android.view.inputmethod.InputMethodManager;
import android.content.ContextWrapper;
import android.view.Gravity;
import android.view.WindowManager$LayoutParams;
import android.view.View$MeasureSpec;
import android.graphics.Rect;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.View;
import f1.b;
import android.content.MutableContextWrapper;
import android.view.WindowManager;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.content.Context;
import android.view.View$OnFocusChangeListener;
import android.widget.FrameLayout;
import android.app.Presentation;

class SingleViewPresentation extends Presentation
{
    private static final String TAG = "PlatformViewsController";
    private final io.flutter.plugin.platform.a accessibilityEventsDelegate;
    private FrameLayout container;
    private final View$OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private a rootView;
    private boolean startFocused;
    private final e state;
    private int viewId;
    
    public SingleViewPresentation(final Context outerContext, final Display display, final io.flutter.plugin.platform.a accessibilityEventsDelegate, final e state, final View$OnFocusChangeListener focusChangeListener, final boolean startFocused) {
        super((Context)new c(outerContext), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate;
        this.state = state;
        this.focusChangeListener = focusChangeListener;
        this.outerContext = outerContext;
        ((Dialog)this).getWindow().setFlags(8, 8);
        this.startFocused = startFocused;
    }
    
    public SingleViewPresentation(final Context outerContext, final Display display, final i i, final io.flutter.plugin.platform.a accessibilityEventsDelegate, final int viewId, final View$OnFocusChangeListener focusChangeListener) {
        super((Context)new c(outerContext), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = accessibilityEventsDelegate;
        this.viewId = viewId;
        this.focusChangeListener = focusChangeListener;
        this.outerContext = outerContext;
        (this.state = new e()).a = i;
        ((Dialog)this).getWindow().setFlags(8, 8);
        ((Dialog)this).getWindow().setType(2030);
    }
    
    public e detachState() {
        ((ViewGroup)this.container).removeAllViews();
        ((ViewGroup)this.rootView).removeAllViews();
        return this.state;
    }
    
    public i getView() {
        if (this.state.a == null) {
            return null;
        }
        return this.state.a;
    }
    
    protected void onCreate(final Bundle bundle) {
        super.onCreate(bundle);
        ((Dialog)this).getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        if (this.state.c == null) {
            this.state.c = new b(((Dialog)this).getContext());
        }
        if (this.state.b == null) {
            final WindowManager windowManager = (WindowManager)((Dialog)this).getContext().getSystemService("window");
            final e state = this.state;
            state.b = new f(windowManager, state.c);
        }
        this.container = new FrameLayout(((Dialog)this).getContext());
        final d baseContext = new d(((Dialog)this).getContext(), this.state.b, this.outerContext);
        final View view = this.state.a.getView();
        if (view.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper)view.getContext()).setBaseContext((Context)baseContext);
        }
        else {
            final StringBuilder sb = new StringBuilder();
            sb.append("Unexpected platform view context for view ID ");
            sb.append(this.viewId);
            sb.append("; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
            f1.b.g("PlatformViewsController", sb.toString());
        }
        ((ViewGroup)this.container).addView(view);
        ((ViewGroup)(this.rootView = new a(((Dialog)this).getContext(), this.accessibilityEventsDelegate, view))).addView((View)this.container);
        ((ViewGroup)this.rootView).addView((View)this.state.c);
        view.setOnFocusChangeListener(this.focusChangeListener);
        ((View)this.rootView).setFocusableInTouchMode(true);
        if (this.startFocused) {
            view.requestFocus();
        }
        else {
            ((View)this.rootView).requestFocus();
        }
        ((Dialog)this).setContentView((View)this.rootView);
    }
    
    private static class a extends FrameLayout
    {
        private final io.flutter.plugin.platform.a e;
        private final View f;
        
        public a(final Context context, final io.flutter.plugin.platform.a e, final View f) {
            super(context);
            this.e = e;
            this.f = f;
        }
        
        public boolean requestSendAccessibilityEvent(final View view, final AccessibilityEvent accessibilityEvent) {
            return this.e.b(this.f, view, accessibilityEvent);
        }
    }
    
    static class b extends ViewGroup
    {
        private final Rect e;
        private final Rect f;
        
        public b(final Context context) {
            super(context);
            this.e = new Rect();
            this.f = new Rect();
        }
        
        private static int a(final int n) {
            return View$MeasureSpec.makeMeasureSpec(View$MeasureSpec.getSize(n), Integer.MIN_VALUE);
        }
        
        protected void onLayout(final boolean b, final int n, final int n2, final int n3, final int n4) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                final View child = this.getChildAt(i);
                final WindowManager$LayoutParams windowManager$LayoutParams = (WindowManager$LayoutParams)child.getLayoutParams();
                this.e.set(n, n2, n3, n4);
                Gravity.apply(windowManager$LayoutParams.gravity, child.getMeasuredWidth(), child.getMeasuredHeight(), this.e, windowManager$LayoutParams.x, windowManager$LayoutParams.y, this.f);
                final Rect f = this.f;
                child.layout(f.left, f.top, f.right, f.bottom);
            }
        }
        
        protected void onMeasure(final int n, final int n2) {
            for (int i = 0; i < this.getChildCount(); ++i) {
                this.getChildAt(i).measure(a(n), a(n2));
            }
            super.onMeasure(n, n2);
        }
    }
    
    private static class c extends ContextWrapper
    {
        private final InputMethodManager a;
        
        c(final Context context) {
            this(context, null);
        }
        
        private c(final Context context, InputMethodManager a) {
            super(context);
            if (a == null) {
                a = (InputMethodManager)context.getSystemService("input_method");
            }
            this.a = a;
        }
        
        public Context createDisplayContext(final Display display) {
            return (Context)new c(super.createDisplayContext(display), this.a);
        }
        
        public Object getSystemService(final String s) {
            if ("input_method".equals((Object)s)) {
                return this.a;
            }
            return super.getSystemService(s);
        }
    }
    
    private static class d extends ContextWrapper
    {
        private final f a;
        private WindowManager b;
        private final Context c;
        
        d(final Context context, final f a, final Context c) {
            super(context);
            this.a = a;
            this.c = c;
        }
        
        private WindowManager a() {
            if (this.b == null) {
                this.b = this.a.b();
            }
            return this.b;
        }
        
        private boolean b() {
            final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int n = 0; n < stackTrace.length && n < 11; ++n) {
                if (stackTrace[n].getClassName().equals((Object)AlertDialog.class.getCanonicalName()) && stackTrace[n].getMethodName().equals((Object)"<init>")) {
                    return true;
                }
            }
            return false;
        }
        
        public Object getSystemService(final String s) {
            if (!"window".equals((Object)s)) {
                return super.getSystemService(s);
            }
            if (this.b()) {
                return this.c.getSystemService(s);
            }
            return this.a();
        }
    }
    
    static class e
    {
        private i a;
        private f b;
        private b c;
    }
    
    static class f implements InvocationHandler
    {
        private final WindowManager a;
        b b;
        
        f(final WindowManager a, final b b) {
            this.a = a;
            this.b = b;
        }
        
        private void a(final Object[] array) {
            final b b = this.b;
            if (b == null) {
                f1.b.g("PlatformViewsController", "Embedded view called addView while detached from presentation");
                return;
            }
            b.addView((View)array[0], (ViewGroup$LayoutParams)array[1]);
        }
        
        private void c(final Object[] array) {
            final b b = this.b;
            if (b == null) {
                f1.b.g("PlatformViewsController", "Embedded view called removeView while detached from presentation");
                return;
            }
            b.removeView((View)array[0]);
        }
        
        private void d(final Object[] array) {
            if (this.b == null) {
                f1.b.g("PlatformViewsController", "Embedded view called removeViewImmediate while detached from presentation");
                return;
            }
            final View view = (View)array[0];
            view.clearAnimation();
            this.b.removeView(view);
        }
        
        private void e(final Object[] array) {
            final b b = this.b;
            if (b == null) {
                f1.b.g("PlatformViewsController", "Embedded view called updateViewLayout while detached from presentation");
                return;
            }
            b.updateViewLayout((View)array[0], (ViewGroup$LayoutParams)array[1]);
        }
        
        public WindowManager b() {
            return (WindowManager)Proxy.newProxyInstance(WindowManager.class.getClassLoader(), new Class[] { WindowManager.class }, (InvocationHandler)this);
        }
        
        public Object invoke(Object invoke, final Method method, final Object[] array) {
            final String name = method.getName();
            name.hashCode();
            final int hashCode = name.hashCode();
            int n = -1;
            switch (hashCode) {
                case 1098630473: {
                    if (!name.equals((Object)"removeView")) {
                        break;
                    }
                    n = 3;
                    break;
                }
                case 931413976: {
                    if (!name.equals((Object)"updateViewLayout")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case 542766184: {
                    if (!name.equals((Object)"removeViewImmediate")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -1148522778: {
                    if (!name.equals((Object)"addView")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                default: {
                    try {
                        invoke = method.invoke((Object)this.a, array);
                        return invoke;
                    }
                    catch (final InvocationTargetException ex) {
                        throw ex.getCause();
                    }
                }
                case 3: {
                    this.c(array);
                    return null;
                }
                case 2: {
                    this.e(array);
                    return null;
                }
                case 1: {
                    this.d(array);
                    return null;
                }
                case 0: {
                    this.a(array);
                    return null;
                }
            }
        }
    }
}
