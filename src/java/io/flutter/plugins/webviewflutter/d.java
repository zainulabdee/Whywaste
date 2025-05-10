package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient$CustomViewCallback;
import t1.c;

public class d
{
    private final c a;
    private final c4 b;
    private n.d c;
    
    public d(final c a, final c4 b) {
        this.a = a;
        this.b = b;
        this.c = new n.d(a);
    }
    
    public void a(final WebChromeClient$CustomViewCallback webChromeClient$CustomViewCallback, final n.d.a<Void> a) {
        if (!this.b.f(webChromeClient$CustomViewCallback)) {
            this.c.b(this.b.c(webChromeClient$CustomViewCallback), a);
        }
    }
}
