package io.flutter.plugins.webviewflutter;

import java.util.Objects;
import android.webkit.WebView;
import t1.c;

public class l6
{
    private final c a;
    private final c4 b;
    private n.i0 c;
    
    public l6(final c a, final c4 b) {
        this.a = a;
        this.b = b;
        this.c = new n.i0(a);
    }
    
    public void a(final WebView webView, final n.i0.a<Void> a) {
        if (!this.b.f(webView)) {
            this.c.c(this.b.c(webView), a);
        }
    }
    
    public void b(final WebView webView, final Long n, final Long n2, final Long n3, final Long n4, final n.i0.a<Void> a) {
        final n.i0 c = this.c;
        final Long h = this.b.h(webView);
        Objects.requireNonNull((Object)h);
        c.g(h, n, n2, n3, n4, a);
    }
}
