package io.flutter.embedding.engine;

import java.util.List;
import java.util.Iterator;
import android.content.res.AssetManager;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.HashSet;
import i1.d;
import android.content.Context;
import java.util.Set;
import io.flutter.plugin.platform.v;
import s1.p;
import s1.o;
import s1.n;
import s1.m;
import s1.i;
import s1.l;
import s1.h;
import s1.g;
import s1.f;
import s1.e;
import u1.b;

public class a
{
    private final FlutterJNI a;
    private final r1.a b;
    private final g1.a c;
    private final c d;
    private final u1.b e;
    private final s1.a f;
    private final s1.b g;
    private final e h;
    private final f i;
    private final g j;
    private final h k;
    private final l l;
    private final i m;
    private final m n;
    private final n o;
    private final o p;
    private final p q;
    private final v r;
    private final Set<b> s;
    private final b t;
    
    public a(final Context context, final d d, final FlutterJNI flutterJNI, final v v, final String[] array, final boolean b, final boolean b2) {
        this(context, d, flutterJNI, v, array, b, b2, null);
    }
    
    public a(final Context context, final d d, final FlutterJNI flutterJNI, final v v, final String[] array, final boolean b, final boolean b2, final io.flutter.embedding.engine.d d2) {
        this.s = (Set<b>)new HashSet();
        this.t = (b)new a$a(this);
        AssetManager assetManager;
        try {
            assetManager = context.createPackageContext(context.getPackageName(), 0).getAssets();
        }
        catch (final PackageManager$NameNotFoundException ex) {
            assetManager = context.getAssets();
        }
        final f1.a e = f1.a.e();
        FlutterJNI a = flutterJNI;
        if (flutterJNI == null) {
            a = e.d().a();
        }
        this.a = a;
        final g1.a c = new g1.a(a, assetManager);
        (this.c = c).n();
        final h1.a a2 = f1.a.e().a();
        this.f = new s1.a(c, a);
        final s1.b g = new s1.b(c);
        this.g = g;
        this.h = new e(c);
        final f i = new f(c);
        this.i = i;
        this.j = new g(c);
        this.k = new h(c);
        this.m = new i(c);
        this.l = new l(c, b2);
        this.n = new m(c);
        this.o = new n(c);
        this.p = new o(c);
        this.q = new p(c);
        if (a2 != null) {
            a2.b(g);
        }
        final u1.b b3 = new u1.b(context, i);
        this.e = b3;
        d c2;
        if ((c2 = d) == null) {
            c2 = e.c();
        }
        if (!a.isAttached()) {
            c2.l(context.getApplicationContext());
            c2.e(context, array);
        }
        a.addEngineLifecycleListener(this.t);
        a.setPlatformViewsController(v);
        a.setLocalizationPlugin(b3);
        a.setDeferredComponentManager(e.a());
        if (!a.isAttached()) {
            this.e();
        }
        this.b = new r1.a(a);
        (this.r = v).V();
        this.d = new c(context.getApplicationContext(), this, c2, d2);
        b3.d(context.getResources().getConfiguration());
        if (b && c2.d()) {
            q1.a.a(this);
        }
    }
    
    private void e() {
        f1.b.f("FlutterEngine", "Attaching to JNI.");
        this.a.attachToNative();
        if (this.w()) {
            return;
        }
        throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
    }
    
    private boolean w() {
        return this.a.isAttached();
    }
    
    public void d(final b b) {
        this.s.add((Object)b);
    }
    
    public void f() {
        f1.b.f("FlutterEngine", "Destroying.");
        final Iterator iterator = this.s.iterator();
        while (iterator.hasNext()) {
            ((b)iterator.next()).a();
        }
        this.d.k();
        this.r.X();
        this.c.o();
        this.a.removeEngineLifecycleListener(this.t);
        this.a.setDeferredComponentManager(null);
        this.a.detachFromNativeAndReleaseResources();
        if (f1.a.e().a() != null) {
            f1.a.e().a().destroy();
            this.g.c((h1.a)null);
        }
    }
    
    public s1.a g() {
        return this.f;
    }
    
    public l1.b h() {
        return (l1.b)this.d;
    }
    
    public g1.a i() {
        return this.c;
    }
    
    public e j() {
        return this.h;
    }
    
    public u1.b k() {
        return this.e;
    }
    
    public g l() {
        return this.j;
    }
    
    public h m() {
        return this.k;
    }
    
    public i n() {
        return this.m;
    }
    
    public v o() {
        return this.r;
    }
    
    public k1.b p() {
        return (k1.b)this.d;
    }
    
    public r1.a q() {
        return this.b;
    }
    
    public l r() {
        return this.l;
    }
    
    public m s() {
        return this.n;
    }
    
    public n t() {
        return this.o;
    }
    
    public o u() {
        return this.p;
    }
    
    public p v() {
        return this.q;
    }
    
    a x(final Context context, final g1.a.b b, final String s, final List<String> list, final v v, final boolean b2, final boolean b3) {
        if (this.w()) {
            return new a(context, null, this.a.spawn(b.c, b.b, s, list), v, null, b2, b3);
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }
    
    public interface b
    {
        void a();
        
        void b();
    }
}
