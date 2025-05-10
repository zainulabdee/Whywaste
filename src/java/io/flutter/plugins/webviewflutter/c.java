package io.flutter.plugins.webviewflutter;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.os.Build$VERSION;
import java.util.Objects;
import android.webkit.CookieManager;

public class c implements n$c
{
    private final t1.c a;
    private final c4 b;
    private final c.c$b c;
    private final c.c$a d;
    
    public c(final t1.c c, final c4 c2) {
        this(c, c2, new c.c$b());
    }
    
    c(final t1.c c, final c4 c2, final c.c$b c$b) {
        this(c, c2, c$b, (c.c$a)new a());
    }
    
    c(final t1.c a, final c4 b, final c.c$b c, final c.c$a d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    private CookieManager f(final Long n) {
        final CookieManager cookieManager = (CookieManager)this.b.i((long)n);
        Objects.requireNonNull((Object)cookieManager);
        final CookieManager cookieManager2 = cookieManager;
        return cookieManager;
    }
    
    private boolean h(final CookieManager cookieManager) {
        final boolean hasCookies = cookieManager.hasCookies();
        if (hasCookies) {
            cookieManager.removeAllCookie();
        }
        return hasCookies;
    }
    
    public void a(final Long n, final Long n2, final Boolean b) {
        if (this.d.a(21)) {
            final CookieManager f = this.f(n);
            final WebView webView = (WebView)this.b.i((long)n2);
            Objects.requireNonNull((Object)webView);
            final WebView webView2 = webView;
            f.setAcceptThirdPartyCookies(webView, (boolean)b);
            return;
        }
        throw new UnsupportedOperationException("`setAcceptThirdPartyCookies` is unsupported on versions below `Build.VERSION_CODES.LOLLIPOP`.");
    }
    
    public void b(final Long n, final n$w<Boolean> n$w) {
        if (this.d.a(21)) {
            final CookieManager f = this.f(n);
            Objects.requireNonNull((Object)n$w);
            f.removeAllCookies((ValueCallback)new b((n$w)n$w));
        }
        else {
            n$w.a((Object)this.h(this.f(n)));
        }
    }
    
    public void c(final Long n, final String s, final String s2) {
        this.f(n).setCookie(s, s2);
    }
    
    public void d(final Long n) {
        this.b.b((Object)this.c.a(), (long)n);
    }
}
