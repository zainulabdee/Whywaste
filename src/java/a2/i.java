package a2;

import android.app.Activity;
import k1.a$b;
import android.util.Log;
import l1.c;
import k1.a;

public final class i implements a, l1.a
{
    private h a;
    
    public void onAttachedToActivity(final c c) {
        final h a = this.a;
        if (a == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
            return;
        }
        a.i(c.d());
    }
    
    public void onAttachedToEngine(final a$b a$b) {
        this.a = new h(a$b.a());
        f.f(a$b.b(), (a2.a$b)this.a);
    }
    
    public void onDetachedFromActivity() {
        final h a = this.a;
        if (a == null) {
            Log.wtf("UrlLauncherPlugin", "urlLauncher was never set.");
            return;
        }
        a.i(null);
    }
    
    public void onDetachedFromActivityForConfigChanges() {
        this.onDetachedFromActivity();
    }
    
    public void onDetachedFromEngine(final a$b a$b) {
        if (this.a == null) {
            Log.wtf("UrlLauncherPlugin", "Already detached from the engine.");
            return;
        }
        f.f(a$b.b(), (a2.a$b)null);
        this.a = null;
    }
    
    public void onReattachedToActivityForConfigChanges(final c c) {
        this.onAttachedToActivity(c);
    }
}
