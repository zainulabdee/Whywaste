package g1;

import b2.f;
import java.util.List;
import t1.b;
import t1.t;
import java.nio.ByteBuffer;
import android.content.res.AssetManager;
import io.flutter.embedding.engine.FlutterJNI;
import t1.c;

public class a implements t1.c
{
    private final FlutterJNI a;
    private final AssetManager b;
    private final g1.c c;
    private final t1.c d;
    private boolean e;
    private String f;
    private a.a$d g;
    private final t1.c.a h;
    
    public a(final FlutterJNI a, final AssetManager b) {
        this.e = false;
        final t1.c.a h = new t1.c.a() {
            final a a;
            
            @Override
            public void a(final ByteBuffer byteBuffer, final b b) {
                this.a.f = t.b.c(byteBuffer);
                if (this.a.g != null) {
                    this.a.g.a(this.a.f);
                }
            }
        };
        this.h = h;
        this.a = a;
        this.b = b;
        final g1.c c = new g1.c(a);
        (this.c = c).g("flutter/isolate", h);
        this.d = new c(c);
        if (a.isAttached()) {
            this.e = true;
        }
    }
    
    @Deprecated
    @Override
    public t1.c.c a(final d d) {
        return this.d.a(d);
    }
    
    @Deprecated
    @Override
    public void b(final String s, final ByteBuffer byteBuffer, final b b) {
        this.d.b(s, byteBuffer, b);
    }
    
    @Deprecated
    @Override
    public void c(final String s, final t1.c.a a, final t1.c.c c) {
        this.d.c(s, a, c);
    }
    
    @Deprecated
    @Override
    public void e(final String s, final ByteBuffer byteBuffer) {
        this.d.e(s, byteBuffer);
    }
    
    @Deprecated
    @Override
    public void g(final String s, final t1.c.a a) {
        this.d.g(s, a);
    }
    
    public void j(final a.a$b a$b, final List<String> list) {
        if (this.e) {
            f1.b.g("DartExecutor", "Attempted to run a DartExecutor that is already running.");
            return;
        }
        b2.f.a("DartExecutor#executeDartEntrypoint");
        try {
            final StringBuilder sb = new StringBuilder();
            sb.append("Executing Dart entrypoint: ");
            sb.append((Object)a$b);
            f1.b.f("DartExecutor", sb.toString());
            this.a.runBundleAndSnapshotFromLibrary(a$b.a, a$b.c, a$b.b, this.b, (List)list);
            this.e = true;
        }
        finally {
            b2.f.d();
        }
    }
    
    public String k() {
        return this.f;
    }
    
    public boolean l() {
        return this.e;
    }
    
    public void m() {
        if (this.a.isAttached()) {
            this.a.notifyLowMemoryWarning();
        }
    }
    
    public void n() {
        f1.b.f("DartExecutor", "Attached to JNI. Registering the platform message handler for this Dart execution context.");
        this.a.setPlatformMessageHandler((g1.f)this.c);
    }
    
    public void o() {
        f1.b.f("DartExecutor", "Detached from JNI. De-registering the platform message handler for this Dart execution context.");
        this.a.setPlatformMessageHandler((g1.f)null);
    }
    
    private static class c implements t1.c
    {
        private final g1.c a;
        
        private c(final g1.c a) {
            this.a = a;
        }
        
        @Override
        public t1.c.c a(final d d) {
            return this.a.a(d);
        }
        
        @Override
        public void b(final String s, final ByteBuffer byteBuffer, final b b) {
            this.a.b(s, byteBuffer, b);
        }
        
        @Override
        public void c(final String s, final t1.c.a a, final t1.c.c c) {
            this.a.c(s, a, c);
        }
        
        @Override
        public void e(final String s, final ByteBuffer byteBuffer) {
            this.a.b(s, byteBuffer, null);
        }
        
        @Override
        public void g(final String s, final t1.c.a a) {
            this.a.g(s, a);
        }
    }
}
