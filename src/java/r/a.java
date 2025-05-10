package r;

import android.content.Context;
import androidx.browser.customtabs.b;
import android.net.Uri;
import androidx.browser.customtabs.b$b;
import android.app.Activity;
import t1.j;
import k1.a$b;
import kotlin.jvm.internal.i;
import android.content.Intent;
import kotlin.jvm.internal.e;
import l1.c;
import t1.k;
import c2.q;
import t1.k$d;
import t1.m;
import t1.k$c;

public final class a implements k1.a, k$c, l1.a, m
{
    public static final a.a$a d;
    private static k$d e;
    private static l2.a<q> f;
    private final int a;
    private k b;
    private c c;
    
    static {
        d = new a.a$a((e)null);
    }
    
    public a() {
        this.a = 1001;
    }
    
    public boolean a(final int n, final int n2, final Intent intent) {
        if (n == this.a) {
            final k$d e = r.a.e;
            if (e != null) {
                e.b("authorization-error/canceled", "The user closed the Custom Tab", (Object)null);
                r.a.e = null;
                r.a.f = null;
            }
        }
        return false;
    }
    
    public void onAttachedToActivity(final c c) {
        i.e((Object)c, "binding");
        (this.c = c).b((m)this);
    }
    
    public void onAttachedToEngine(final k1.a$b a$b) {
        i.e((Object)a$b, "flutterPluginBinding");
        (this.b = new k(a$b.b(), "com.aboutyou.dart_packages.sign_in_with_apple")).e((k$c)this);
    }
    
    public void onDetachedFromActivity() {
        final c c = this.c;
        if (c != null) {
            c.g((m)this);
        }
        this.c = null;
    }
    
    public void onDetachedFromActivityForConfigChanges() {
        this.onDetachedFromActivity();
    }
    
    public void onDetachedFromEngine(final k1.a$b a$b) {
        i.e((Object)a$b, "binding");
        final k b = this.b;
        if (b != null) {
            b.e((k$c)null);
        }
        this.b = null;
    }
    
    public void onMethodCall(final j j, final k$d e) {
        i.e((Object)j, "call");
        i.e((Object)e, "result");
        final String a = j.a;
        if (i.a((Object)a, (Object)"isAvailable")) {
            e.a((Object)Boolean.TRUE);
        }
        else if (i.a((Object)a, (Object)"performAuthorizationRequest")) {
            final c c = this.c;
            Activity d;
            if (c != null) {
                d = c.d();
            }
            else {
                d = null;
            }
            if (d == null) {
                e.b("MISSING_ACTIVITY", "Plugin is not attached to an activity", j.b);
                return;
            }
            final String s = (String)j.a("url");
            if (s == null) {
                e.b("MISSING_ARG", "Missing 'url' argument", j.b);
                return;
            }
            final k$d e2 = r.a.e;
            if (e2 != null) {
                e2.b("NEW_REQUEST", "A new request came in while this was still pending. The previous request (this one) was then cancelled.", (Object)null);
            }
            final l2.a<q> f = r.a.f;
            if (f != null) {
                i.b((Object)f);
                f.invoke();
            }
            r.a.e = e;
            r.a.f = (l2.a<q>)new l2.a<q>(d) {
                final Activity e;
                
                public final void a() {
                    final Intent launchIntentForPackage = ((Context)this.e).getPackageManager().getLaunchIntentForPackage(((Context)this.e).getPackageName());
                    if (launchIntentForPackage != null) {
                        launchIntentForPackage.setPackage((String)null);
                    }
                    if (launchIntentForPackage != null) {
                        launchIntentForPackage.setFlags(67108864);
                    }
                    this.e.startActivity(launchIntentForPackage);
                }
            };
            final b a2 = new b$b().a();
            i.d((Object)a2, "builder.build()");
            a2.a.setData(Uri.parse(s));
            d.startActivityForResult(a2.a, this.a, a2.b);
        }
        else {
            e.c();
        }
    }
    
    public void onReattachedToActivityForConfigChanges(final c c) {
        i.e((Object)c, "binding");
        this.onAttachedToActivity(c);
    }
}
