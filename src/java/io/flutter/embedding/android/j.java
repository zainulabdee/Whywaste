package io.flutter.embedding.android;

import android.graphics.Paint;
import android.graphics.Canvas;
import android.view.Surface;
import java.nio.ByteBuffer;
import android.media.Image$Plane;
import android.hardware.HardwareBuffer;
import java.nio.Buffer;
import android.graphics.Bitmap$Config;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace$Named;
import f1.b;
import java.util.Locale;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.content.Context;
import r1.a;
import android.graphics.Bitmap;
import android.media.Image;
import android.media.ImageReader;
import r1.c;
import android.view.View;

public class j extends View implements c
{
    private ImageReader e;
    private Image f;
    private Bitmap g;
    private a h;
    private j.j$b i;
    private boolean j;
    
    public j(final Context context, final int n, final int n2, final j.j$b j$b) {
        this(context, g(n, n2), j$b);
    }
    
    j(final Context context, final ImageReader e, final j.j$b i) {
        super(context, (AttributeSet)null);
        this.j = false;
        this.e = e;
        this.i = i;
        this.h();
    }
    
    private void e() {
        final Image f = this.f;
        if (f != null) {
            f.close();
            this.f = null;
        }
    }
    
    private static ImageReader g(int n, int n2) {
        if (n <= 0) {
            i("ImageReader width must be greater than 0, but given width=%d, set width=1", n);
            n = 1;
        }
        if (n2 <= 0) {
            i("ImageReader height must be greater than 0, but given height=%d, set height=1", n2);
            n2 = 1;
        }
        if (Build$VERSION.SDK_INT >= 29) {
            return g.a(n, n2, 1, 3, 768L);
        }
        return ImageReader.newInstance(n, n2, 1, 3);
    }
    
    private void h() {
        this.setAlpha(0.0f);
    }
    
    private static void i(final String s, final Object... array) {
        b.g("FlutterImageView", String.format(Locale.US, s, array));
    }
    
    private void k() {
        if (Build$VERSION.SDK_INT >= 29) {
            final HardwareBuffer a = io.flutter.embedding.android.h.a(this.f);
            this.g = io.flutter.embedding.android.i.a(a, ColorSpace.get(ColorSpace$Named.SRGB));
            a.close();
        }
        else {
            final Image$Plane[] planes = this.f.getPlanes();
            if (planes.length != 1) {
                return;
            }
            final Image$Plane image$Plane = planes[0];
            final int n = image$Plane.getRowStride() / image$Plane.getPixelStride();
            final int height = this.f.getHeight();
            final Bitmap g = this.g;
            if (g == null || g.getWidth() != n || this.g.getHeight() != height) {
                this.g = Bitmap.createBitmap(n, height, Bitmap$Config.ARGB_8888);
            }
            final ByteBuffer buffer = image$Plane.getBuffer();
            buffer.rewind();
            this.g.copyPixelsFromBuffer((Buffer)buffer);
        }
    }
    
    public void a() {
        if (!this.j) {
            return;
        }
        this.setAlpha(0.0f);
        this.d();
        this.g = null;
        this.e();
        this.invalidate();
        this.j = false;
    }
    
    public void b() {
    }
    
    public void c(final a h) {
        if (j$a.a[((Enum)this.i).ordinal()] == 1) {
            h.v(this.e.getSurface());
        }
        this.setAlpha(1.0f);
        this.h = h;
        this.j = true;
    }
    
    public boolean d() {
        final boolean j = this.j;
        boolean b = false;
        if (!j) {
            return false;
        }
        final Image acquireLatestImage = this.e.acquireLatestImage();
        if (acquireLatestImage != null) {
            this.e();
            this.f = acquireLatestImage;
            this.invalidate();
        }
        if (acquireLatestImage != null) {
            b = true;
        }
        return b;
    }
    
    public void f() {
        this.e.close();
    }
    
    public a getAttachedRenderer() {
        return this.h;
    }
    
    public ImageReader getImageReader() {
        return this.e;
    }
    
    public Surface getSurface() {
        return this.e.getSurface();
    }
    
    public void j(final int n, final int n2) {
        if (this.h == null) {
            return;
        }
        if (n == this.e.getWidth() && n2 == this.e.getHeight()) {
            return;
        }
        this.e();
        this.f();
        this.e = g(n, n2);
    }
    
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        if (this.f != null) {
            this.k();
        }
        final Bitmap g = this.g;
        if (g != null) {
            canvas.drawBitmap(g, 0.0f, 0.0f, (Paint)null);
        }
    }
    
    protected void onSizeChanged(final int n, final int n2, final int n3, final int n4) {
        if (n == this.e.getWidth() && n2 == this.e.getHeight()) {
            return;
        }
        if (this.i == io.flutter.embedding.android.j.j$b.e && this.j) {
            this.j(n, n2);
            this.h.v(this.e.getSurface());
        }
    }
}
