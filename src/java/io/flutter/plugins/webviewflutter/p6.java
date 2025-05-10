package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import io.flutter.plugin.platform.j;
import android.content.Context;
import io.flutter.plugin.platform.k;
import t1.c;
import k1.a$b;
import k1.a;

public class p6 implements a, l1.a
{
    private c4 a;
    private a$b b;
    private t6 c;
    private i4 d;
    
    private void g(final c c, final k k, final Context context, final io.flutter.plugins.webviewflutter.k i) {
        this.a = c4.g((c4$a)new m6(c));
        m0.c(c, (n$p)new n6(this));
        k.a("plugins.flutter.io/webview", (j)new m(this.a));
        this.c = new t6(this.a, c, new t6$b(), context);
        this.d = new i4(this.a, new i4$a(), new h4(c, this.a), new Handler(context.getMainLooper()));
        p0.c(c, (n$r)new d4(this.a));
        w3.B(c, (n$j0)this.c);
        s0.c(c, (n$t)this.d);
        t2.d(c, (n$h0)new c6(this.a, new c6$b(), new t5(c, this.a)));
        p1.h(c, (n$a0)new v4(this.a, new v4$b(), new t4(c, this.a)));
        y.c(c, (n$g)new h(this.a, new h$a(), new g(c, this.a)));
        f2.q(c, (n$d0)new h5(this.a, new h5$a()));
        c0.d(c, (n$j)new l(i));
        s.f(c, (n$c)new io.flutter.plugins.webviewflutter.c(c, this.a));
        i2.d(c, (n$e0)new i5(this.a, new i5$a()));
        w0.d(c, (n$v)new k4(c, this.a));
        f0.c(c, (n$m)new y3(c, this.a));
        v.c(c, (n$e)new e(c, this.a));
        k0.e(c, (n$o)new a4(c, this.a));
    }
    
    private void h(final Context context) {
        this.c.A(context);
        this.d.b(new Handler(context.getMainLooper()));
    }
    
    public void onAttachedToActivity(final l1.c c) {
        this.h((Context)c.d());
    }
    
    public void onAttachedToEngine(final a$b b) {
        this.b = b;
        this.g(b.b(), b.d(), b.a(), new io.flutter.plugins.webviewflutter.k.a(b.a().getAssets(), b.c()));
    }
    
    public void onDetachedFromActivity() {
        this.h(this.b.a());
    }
    
    public void onDetachedFromActivityForConfigChanges() {
        this.h(this.b.a());
    }
    
    public void onDetachedFromEngine(final a$b a$b) {
        final c4 a = this.a;
        if (a != null) {
            a.n();
            this.a = null;
        }
    }
    
    public void onReattachedToActivityForConfigChanges(final l1.c c) {
        this.h((Context)c.d());
    }
}
