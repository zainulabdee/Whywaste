package a2;

import android.os.BaseBundle;
import io.flutter.plugins.urllauncher.WebViewActivity;
import android.content.ActivityNotFoundException;
import android.net.Uri;
import android.content.ComponentName;
import java.util.Iterator;
import android.os.Bundle;
import java.util.Map;
import android.content.Intent;
import android.app.Activity;
import android.content.Context;

final class h implements a$b
{
    private final Context a;
    private final h.h$a b;
    private Activity c;
    
    h(final Context context) {
        this(context, (h.h$a)new g(context));
    }
    
    h(final Context a, final h.h$a b) {
        this.a = a;
        this.b = b;
    }
    
    private void f() {
        if (this.c != null) {
            return;
        }
        throw new a$a("NO_ACTIVITY", "Launching a URL requires a foreground activity.", (Object)null);
    }
    
    private static Bundle g(final Map<String, String> map) {
        final Bundle bundle = new Bundle();
        for (final String s : map.keySet()) {
            ((BaseBundle)bundle).putString(s, (String)map.get((Object)s));
        }
        return bundle;
    }
    
    public Boolean a(String a) {
        final Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(a));
        a = this.b.a(intent);
        if (a == null) {
            return Boolean.FALSE;
        }
        return "{com.android.fallback/com.android.fallback.Fallback}".equals((Object)a) ^ true;
    }
    
    public void b() {
        this.a.sendBroadcast(new Intent("close action"));
    }
    
    public Boolean c(final String s, final Map<String, String> map) {
        this.f();
        final Intent putExtra = new Intent("android.intent.action.VIEW").setData(Uri.parse(s)).putExtra("com.android.browser.headers", g(map));
        try {
            this.c.startActivity(putExtra);
            return Boolean.TRUE;
        }
        catch (final ActivityNotFoundException ex) {
            return Boolean.FALSE;
        }
    }
    
    public Boolean d(final String s, final a$d a$d) {
        this.f();
        final Intent a = WebViewActivity.a((Context)this.c, s, (boolean)a$d.c(), (boolean)a$d.b(), g((Map<String, String>)a$d.d()));
        try {
            this.c.startActivity(a);
            return Boolean.TRUE;
        }
        catch (final ActivityNotFoundException ex) {
            return Boolean.FALSE;
        }
    }
    
    void i(final Activity c) {
        this.c = c;
    }
}
