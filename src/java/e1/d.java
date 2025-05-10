package e1;

import android.content.Context;
import android.app.Activity;
import k1.a$b;
import t1.m;
import kotlin.jvm.internal.i;
import t1.k;
import k1.a;

public final class d implements a, l1.a
{
    public static final d.d$a d;
    private c a;
    private e b;
    private k c;
    
    static {
        d = new d.d$a((kotlin.jvm.internal.e)null);
    }
    
    public void onAttachedToActivity(final l1.c c) {
        i.e((Object)c, "binding");
        final e b = this.b;
        final c c2 = null;
        e e = b;
        if (b == null) {
            i.o("manager");
            e = null;
        }
        c.b((m)e);
        c a = this.a;
        if (a == null) {
            i.o("share");
            a = c2;
        }
        a.l(c.d());
    }
    
    public void onAttachedToEngine(final a$b a$b) {
        i.e((Object)a$b, "binding");
        this.c = new k(a$b.b(), "dev.fluttercommunity.plus/share");
        final Context a = a$b.a();
        i.d((Object)a, "binding.applicationContext");
        this.b = new e(a);
        final Context a2 = a$b.a();
        i.d((Object)a2, "binding.applicationContext");
        final e b = this.b;
        final k k = null;
        e e = b;
        if (b == null) {
            i.o("manager");
            e = null;
        }
        final c a3 = new c(a2, (Activity)null, e);
        this.a = a3;
        e b2;
        if ((b2 = this.b) == null) {
            i.o("manager");
            b2 = null;
        }
        final e1.a a4 = new e1.a(a3, b2);
        k c = this.c;
        if (c == null) {
            i.o("methodChannel");
            c = k;
        }
        c.e((k.c)a4);
    }
    
    public void onDetachedFromActivity() {
        c a;
        if ((a = this.a) == null) {
            i.o("share");
            a = null;
        }
        a.l((Activity)null);
    }
    
    public void onDetachedFromActivityForConfigChanges() {
        this.onDetachedFromActivity();
    }
    
    public void onDetachedFromEngine(final a$b a$b) {
        i.e((Object)a$b, "binding");
        k c;
        if ((c = this.c) == null) {
            i.o("methodChannel");
            c = null;
        }
        c.e(null);
    }
    
    public void onReattachedToActivityForConfigChanges(final l1.c c) {
        i.e((Object)c, "binding");
        this.onAttachedToActivity(c);
    }
}
