package io.flutter.plugins.webviewflutter;

import android.webkit.JavascriptInterface;
import android.os.Looper;
import android.os.Handler;

public class g4
{
    private final Handler a;
    final String b;
    private final h4 c;
    
    public g4(final h4 c, final String b, final Handler a) {
        this.c = c;
        this.b = b;
        this.a = a;
    }
    
    @JavascriptInterface
    public void postMessage(final String s) {
        final e4 e4 = new e4(this, s);
        if (this.a.getLooper() == Looper.myLooper()) {
            ((Runnable)e4).run();
        }
        else {
            this.a.post((Runnable)e4);
        }
    }
}
