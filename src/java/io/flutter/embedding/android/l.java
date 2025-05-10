package io.flutter.embedding.android;

import android.view.View;
import f1.b;
import android.util.AttributeSet;
import android.content.Context;
import android.view.TextureView$SurfaceTextureListener;
import android.view.Surface;
import r1.a;
import r1.c;
import android.view.TextureView;

public class l extends TextureView implements c
{
    private boolean e;
    private boolean f;
    private boolean g;
    private a h;
    private Surface i;
    private final TextureView$SurfaceTextureListener j;
    
    public l(final Context context) {
        this(context, null);
    }
    
    public l(final Context context, final AttributeSet set) {
        super(context, set);
        this.e = false;
        this.f = false;
        this.g = false;
        this.j = (TextureView$SurfaceTextureListener)new l$a(this);
        this.n();
    }
    
    private void k(final int n, final int n2) {
        if (this.h != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Notifying FlutterRenderer that Android surface size has changed to ");
            sb.append(n);
            sb.append(" x ");
            sb.append(n2);
            b.f("FlutterTextureView", sb.toString());
            this.h.u(n, n2);
            return;
        }
        throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
    }
    
    private void l() {
        if (this.h != null && this.getSurfaceTexture() != null) {
            final Surface i = this.i;
            if (i != null) {
                i.release();
                this.i = null;
            }
            final Surface j = new Surface(this.getSurfaceTexture());
            this.i = j;
            this.h.s(j, this.g);
            this.g = false;
            return;
        }
        throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
    }
    
    private void m() {
        final a h = this.h;
        if (h != null) {
            h.t();
            final Surface i = this.i;
            if (i != null) {
                i.release();
                this.i = null;
            }
            return;
        }
        throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
    }
    
    private void n() {
        this.setSurfaceTextureListener(this.j);
    }
    
    public void a() {
        if (this.h != null) {
            if (((View)this).getWindowToken() != null) {
                b.f("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
                this.m();
            }
            this.h = null;
            this.f = false;
        }
        else {
            b.g("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
        }
    }
    
    public void b() {
        if (this.h != null) {
            this.h = null;
            this.g = true;
            this.f = false;
        }
        else {
            b.g("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
        }
    }
    
    public void c(final a h) {
        b.f("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.h != null) {
            b.f("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.h.t();
        }
        this.h = h;
        this.f = true;
        if (this.e) {
            b.f("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            this.l();
        }
    }
    
    public a getAttachedRenderer() {
        return this.h;
    }
    
    public void setRenderSurface(final Surface i) {
        this.i = i;
    }
}
