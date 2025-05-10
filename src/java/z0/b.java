package z0;

import t1.k$d;
import t1.j;
import k1.a$b;
import android.util.Log;
import android.content.Intent;
import l1.c;
import t1.d$b;
import t1.d;
import t1.k;
import t1.n;
import t1.d$d;
import t1.k$c;
import k1.a;

public class b implements a, k$c, d$d, l1.a, n
{
    private k a;
    private d b;
    private d$b c;
    c d;
    private String e;
    private String f;
    
    private boolean d(final Intent intent) {
        if (intent == null) {
            return false;
        }
        Log.d("com.llfbandit.app_links", intent.toString());
        if ((intent.getFlags() & 0x100000) == 0x100000) {
            return false;
        }
        final String a = z0.a.a(intent);
        if (a == null) {
            return false;
        }
        if (this.e == null) {
            this.e = a;
        }
        this.f = a;
        final d$b c = this.c;
        if (c != null) {
            c.a((Object)a);
        }
        return true;
    }
    
    public void a(final Object o) {
        this.c = null;
    }
    
    public boolean b(final Intent intent) {
        return this.d(intent);
    }
    
    public void c(final Object o, final d$b c) {
        this.c = c;
    }
    
    public void onAttachedToActivity(final c d) {
        (this.d = d).h((n)this);
        this.d(d.d().getIntent());
    }
    
    public void onAttachedToEngine(final a$b a$b) {
        (this.a = new k(a$b.b(), "com.llfbandit.app_links/messages")).e((k$c)this);
        (this.b = new d(a$b.b(), "com.llfbandit.app_links/events")).d((d$d)this);
    }
    
    public void onDetachedFromActivity() {
        final c d = this.d;
        if (d != null) {
            d.f((n)this);
        }
        this.d = null;
    }
    
    public void onDetachedFromActivityForConfigChanges() {
        this.onDetachedFromActivity();
    }
    
    public void onDetachedFromEngine(final a$b a$b) {
        this.a.e((k$c)null);
        this.b.d((d$d)null);
        this.e = null;
        this.f = null;
    }
    
    public void onMethodCall(final j j, final k$d k$d) {
        if (j.a.equals((Object)"getLatestAppLink")) {
            k$d.a((Object)this.f);
        }
        else if (j.a.equals((Object)"getInitialAppLink")) {
            k$d.a((Object)this.e);
        }
        else {
            k$d.c();
        }
    }
    
    public void onReattachedToActivityForConfigChanges(final c d) {
        (this.d = d).h((n)this);
    }
}
