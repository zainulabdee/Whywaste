package r1;

import java.lang.ref.Reference;
import android.graphics.SurfaceTexture$OnFrameAvailableListener;
import io.flutter.view.s$a;
import android.graphics.Rect;
import java.nio.ByteBuffer;
import android.graphics.SurfaceTexture;
import io.flutter.view.s$c;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import java.util.Iterator;
import java.util.HashSet;
import io.flutter.view.s$b;
import java.lang.ref.WeakReference;
import java.util.Set;
import android.os.Handler;
import android.view.Surface;
import java.util.concurrent.atomic.AtomicLong;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.s;

public class a implements s
{
    private final FlutterJNI a;
    private final AtomicLong b;
    private Surface c;
    private boolean d;
    private Handler e;
    private final Set<WeakReference<s$b>> f;
    private final b g;
    
    public a(final FlutterJNI a) {
        this.b = new AtomicLong(0L);
        this.d = false;
        this.e = new Handler();
        this.f = (Set<WeakReference<s$b>>)new HashSet();
        final b g = (b)new b() {
            final a a;
            
            public void c() {
                this.a.d = false;
            }
            
            public void f() {
                this.a.d = true;
            }
        };
        this.g = (b)g;
        (this.a = a).addIsDisplayingFlutterUiListener((b)g);
    }
    
    private void h() {
        final Iterator iterator = this.f.iterator();
        while (iterator.hasNext()) {
            if (((Reference)iterator.next()).get() == null) {
                iterator.remove();
            }
        }
    }
    
    private void l(final long n) {
        this.a.markTextureFrameAvailable(n);
    }
    
    private void o(final long n, final SurfaceTextureWrapper surfaceTextureWrapper) {
        this.a.registerTexture(n, surfaceTextureWrapper);
    }
    
    public s$c a() {
        f1.b.f("FlutterRenderer", "Creating a SurfaceTexture.");
        return this.n(new SurfaceTexture(0));
    }
    
    public void f(final b b) {
        this.a.addIsDisplayingFlutterUiListener(b);
        if (this.d) {
            b.f();
        }
    }
    
    void g(final s$b s$b) {
        this.h();
        this.f.add((Object)new WeakReference((Object)s$b));
    }
    
    public void i(final ByteBuffer byteBuffer, final int n) {
        this.a.dispatchPointerDataPacket(byteBuffer, n);
    }
    
    public boolean j() {
        return this.d;
    }
    
    public boolean k() {
        return this.a.getIsSoftwareRenderingEnabled();
    }
    
    public void m(final int n) {
        final Iterator iterator = this.f.iterator();
        while (iterator.hasNext()) {
            final s$b s$b = (s$b)((Reference)iterator.next()).get();
            if (s$b != null) {
                s$b.onTrimMemory(n);
            }
            else {
                iterator.remove();
            }
        }
    }
    
    public s$c n(final SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        final f f = new f(this.b.getAndIncrement(), surfaceTexture);
        final StringBuilder sb = new StringBuilder();
        sb.append("New SurfaceTexture ID: ");
        sb.append(f.d());
        f1.b.f("FlutterRenderer", sb.toString());
        this.o(f.d(), f.h());
        this.g((s$b)f);
        return (s$c)f;
    }
    
    public void p(final b b) {
        this.a.removeIsDisplayingFlutterUiListener(b);
    }
    
    public void q(final boolean semanticsEnabled) {
        this.a.setSemanticsEnabled(semanticsEnabled);
    }
    
    public void r(final a.a$g a$g) {
        if (!a$g.a()) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Setting viewport metrics\nSize: ");
        sb.append(a$g.b);
        sb.append(" x ");
        sb.append(a$g.c);
        sb.append("\nPadding - L: ");
        sb.append(a$g.g);
        sb.append(", T: ");
        sb.append(a$g.d);
        sb.append(", R: ");
        sb.append(a$g.e);
        sb.append(", B: ");
        sb.append(a$g.f);
        sb.append("\nInsets - L: ");
        sb.append(a$g.k);
        sb.append(", T: ");
        sb.append(a$g.h);
        sb.append(", R: ");
        sb.append(a$g.i);
        sb.append(", B: ");
        sb.append(a$g.j);
        sb.append("\nSystem Gesture Insets - L: ");
        sb.append(a$g.o);
        sb.append(", T: ");
        sb.append(a$g.l);
        sb.append(", R: ");
        sb.append(a$g.m);
        sb.append(", B: ");
        sb.append(a$g.m);
        sb.append("\nDisplay Features: ");
        sb.append(a$g.q.size());
        f1.b.f("FlutterRenderer", sb.toString());
        final int[] array = new int[a$g.q.size() * 4];
        final int[] array2 = new int[a$g.q.size()];
        final int[] array3 = new int[a$g.q.size()];
        for (int i = 0; i < a$g.q.size(); ++i) {
            final a.a$b a$b = (a.a$b)a$g.q.get(i);
            final int n = i * 4;
            final Rect a = a$b.a;
            array[n] = a.left;
            array[n + 1] = a.top;
            array[n + 2] = a.right;
            array[n + 3] = a.bottom;
            array2[i] = a$b.b.e;
            array3[i] = a$b.c.e;
        }
        this.a.setViewportMetrics(a$g.a, a$g.b, a$g.c, a$g.d, a$g.e, a$g.f, a$g.g, a$g.h, a$g.i, a$g.j, a$g.k, a$g.l, a$g.m, a$g.n, a$g.o, a$g.p, array, array2, array3);
    }
    
    public void s(final Surface c, final boolean b) {
        if (this.c != null && !b) {
            this.t();
        }
        this.c = c;
        this.a.onSurfaceCreated(c);
    }
    
    public void t() {
        this.a.onSurfaceDestroyed();
        this.c = null;
        if (this.d) {
            this.g.c();
        }
        this.d = false;
    }
    
    public void u(final int n, final int n2) {
        this.a.onSurfaceChanged(n, n2);
    }
    
    public void v(final Surface c) {
        this.c = c;
        this.a.onSurfaceWindowChanged(c);
    }
    
    final class f implements s$c, s$b
    {
        private final long a;
        private final SurfaceTextureWrapper b;
        private boolean c;
        private s$b d;
        private s$a e;
        private final Runnable f;
        private SurfaceTexture$OnFrameAvailableListener g;
        final a h;
        
        f(final a h, final long a, final SurfaceTexture surfaceTexture) {
            this.h = h;
            final a$f$a f = new a$f$a(this);
            this.f = (Runnable)f;
            this.g = (SurfaceTexture$OnFrameAvailableListener)new a$f$b(this);
            this.a = a;
            this.b = new SurfaceTextureWrapper(surfaceTexture, (Runnable)f);
            this.c().setOnFrameAvailableListener(this.g, new Handler());
        }
        
        public void a(final s$b d) {
            this.d = d;
        }
        
        public void b(final s$a e) {
            this.e = e;
        }
        
        public SurfaceTexture c() {
            return this.b.surfaceTexture();
        }
        
        public long d() {
            return this.a;
        }
        
        @Override
        protected void finalize() {
            try {
                if (this.c) {
                    return;
                }
                this.h.e.post((Runnable)new a$e(this.a, this.h.a));
            }
            finally {
                super.finalize();
            }
        }
        
        public SurfaceTextureWrapper h() {
            return this.b;
        }
        
        public void onTrimMemory(final int n) {
            final s$b d = this.d;
            if (d != null) {
                d.onTrimMemory(n);
            }
        }
    }
}
