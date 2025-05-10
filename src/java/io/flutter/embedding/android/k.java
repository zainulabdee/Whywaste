package io.flutter.embedding.android;

import android.view.View;
import android.graphics.Region$Op;
import android.graphics.Region;
import android.util.AttributeSet;
import android.content.Context;
import r1.b;
import android.view.SurfaceHolder$Callback;
import r1.a;
import r1.c;
import android.view.SurfaceView;

public class k extends SurfaceView implements c
{
    private final boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private a i;
    private final SurfaceHolder$Callback j;
    private final b k;
    
    private k(final Context context, final AttributeSet set, final boolean e) {
        super(context, set);
        this.f = false;
        this.g = false;
        this.h = false;
        this.j = (SurfaceHolder$Callback)new k$a(this);
        this.k = new b() {
            final k a;
            
            @Override
            public void c() {
            }
            
            @Override
            public void f() {
                f1.b.f("FlutterSurfaceView", "onFlutterUiDisplayed()");
                ((View)this.a).setAlpha(1.0f);
                if (this.a.i != null) {
                    this.a.i.p((b)this);
                }
            }
        };
        this.e = e;
        this.m();
    }
    
    public k(final Context context, final boolean b) {
        this(context, null, b);
    }
    
    private void j(final int n, final int n2) {
        if (this.i != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Notifying FlutterRenderer that Android surface size has changed to ");
            sb.append(n);
            sb.append(" x ");
            sb.append(n2);
            f1.b.f("FlutterSurfaceView", sb.toString());
            this.i.u(n, n2);
            return;
        }
        throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
    }
    
    private void k() {
        if (this.i != null && this.getHolder() != null) {
            this.i.s(this.getHolder().getSurface(), this.g);
            return;
        }
        throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
    }
    
    private void l() {
        final a i = this.i;
        if (i != null) {
            i.t();
            return;
        }
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    }
    
    private void m() {
        if (this.e) {
            this.getHolder().setFormat(-2);
            this.setZOrderOnTop(true);
        }
        this.getHolder().addCallback(this.j);
        ((View)this).setAlpha(0.0f);
    }
    
    public void a() {
        if (this.i != null) {
            if (((View)this).getWindowToken() != null) {
                f1.b.f("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
                this.l();
            }
            ((View)this).setAlpha(0.0f);
            this.i.p(this.k);
            this.i = null;
            this.h = false;
        }
        else {
            f1.b.g("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
        }
    }
    
    public void b() {
        if (this.i != null) {
            this.i = null;
            this.g = true;
            this.h = false;
        }
        else {
            f1.b.g("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
        }
    }
    
    public void c(final a i) {
        f1.b.f("FlutterSurfaceView", "Attaching to FlutterRenderer.");
        if (this.i != null) {
            f1.b.f("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.i.t();
            this.i.p(this.k);
        }
        this.i = i;
        this.h = true;
        i.f(this.k);
        if (this.f) {
            f1.b.f("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            this.k();
        }
        this.g = false;
    }
    
    public boolean gatherTransparentRegion(final Region region) {
        if (((View)this).getAlpha() < 1.0f) {
            return false;
        }
        final int[] array = new int[2];
        ((View)this).getLocationInWindow(array);
        final int n = array[0];
        region.op(n, array[1], ((View)this).getRight() + n - ((View)this).getLeft(), array[1] + ((View)this).getBottom() - ((View)this).getTop(), Region$Op.DIFFERENCE);
        return true;
    }
    
    public a getAttachedRenderer() {
        return this.i;
    }
}
