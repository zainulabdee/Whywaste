package io.flutter.plugins.webviewflutter;

import android.webkit.HttpAuthHandler;
import java.util.Objects;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Build$VERSION;
import java.util.Map;
import java.util.HashMap;
import android.webkit.WebResourceRequest;
import p.e;
import android.webkit.WebResourceError;
import t1.c;

public class t5 extends n$f0
{
    private final c b;
    private final c4 c;
    private final l6 d;
    
    public t5(final c b, final c4 c) {
        super(b);
        this.b = b;
        this.c = c;
        this.d = new l6(b, c);
    }
    
    static n$b0 I(final WebResourceError webResourceError) {
        return new n$b0$a().c(Long.valueOf((long)webResourceError.getErrorCode())).b(webResourceError.getDescription().toString()).a();
    }
    
    static n$b0 J(final e e) {
        return new n$b0$a().c(Long.valueOf((long)e.b())).b(e.a().toString()).a();
    }
    
    static n$c0 K(final WebResourceRequest webResourceRequest) {
        final n$c0$a e = new n$c0$a().g(webResourceRequest.getUrl().toString()).c(Boolean.valueOf(webResourceRequest.isForMainFrame())).b(Boolean.valueOf(webResourceRequest.hasGesture())).e(webResourceRequest.getMethod());
        Object requestHeaders;
        if (webResourceRequest.getRequestHeaders() != null) {
            requestHeaders = webResourceRequest.getRequestHeaders();
        }
        else {
            requestHeaders = new HashMap();
        }
        final n$c0$a f = e.f((Map)requestHeaders);
        if (Build$VERSION.SDK_INT >= 24) {
            f.d(Boolean.valueOf(j5.a(webResourceRequest)));
        }
        return f.a();
    }
    
    private long M(final WebViewClient webViewClient) {
        final Long h = this.c.h((Object)webViewClient);
        if (h != null) {
            return h;
        }
        throw new IllegalStateException("Could not find identifier for WebViewClient.");
    }
    
    public void L(final WebViewClient webViewClient, final WebView webView, final String s, final boolean b, final n$f0$a<Void> n$f0$a) {
        this.d.a(webView, (n$i0$a)new l5());
        final Long h = this.c.h((Object)webView);
        Objects.requireNonNull((Object)h);
        this.i(Long.valueOf(this.M(webViewClient)), h, s, Boolean.valueOf(b), (n$f0$a)n$f0$a);
    }
    
    public void W(final WebViewClient webViewClient, final WebView webView, final String s, final n$f0$a<Void> n$f0$a) {
        this.d.a(webView, (n$i0$a)new r5());
        final Long h = this.c.h((Object)webView);
        Objects.requireNonNull((Object)h);
        this.s(Long.valueOf(this.M(webViewClient)), h, s, (n$f0$a)n$f0$a);
    }
    
    public void X(final WebViewClient webViewClient, final WebView webView, final String s, final n$f0$a<Void> n$f0$a) {
        this.d.a(webView, (n$i0$a)new n5());
        final Long h = this.c.h((Object)webView);
        Objects.requireNonNull((Object)h);
        this.t(Long.valueOf(this.M(webViewClient)), h, s, (n$f0$a)n$f0$a);
    }
    
    public void Y(final WebViewClient webViewClient, final WebView webView, final Long n, final String s, final String s2, final n$f0$a<Void> n$f0$a) {
        this.d.a(webView, (n$i0$a)new o5());
        final Long h = this.c.h((Object)webView);
        Objects.requireNonNull((Object)h);
        this.u(Long.valueOf(this.M(webViewClient)), h, n, s, s2, (n$f0$a)n$f0$a);
    }
    
    public void Z(final WebViewClient webViewClient, final WebView webView, final HttpAuthHandler httpAuthHandler, final String s, final String s2, final n$f0$a<Void> n$f0$a) {
        new z3(this.b, this.c).a(httpAuthHandler, (n$n$a)new m5());
        final Long h = this.c.h((Object)webViewClient);
        Objects.requireNonNull((Object)h);
        final Long h2 = this.c.h((Object)webView);
        Objects.requireNonNull((Object)h2);
        final Long h3 = this.c.h((Object)httpAuthHandler);
        Objects.requireNonNull((Object)h3);
        this.v(h, h2, h3, s, s2, (n$f0$a)n$f0$a);
    }
    
    public void a0(final WebViewClient webViewClient, final WebView webView, final WebResourceRequest webResourceRequest, final WebResourceError webResourceError, final n$f0$a<Void> n$f0$a) {
        this.d.a(webView, (n$i0$a)new q5());
        final Long h = this.c.h((Object)webView);
        Objects.requireNonNull((Object)h);
        this.w(Long.valueOf(this.M(webViewClient)), h, K(webResourceRequest), I(webResourceError), (n$f0$a)n$f0$a);
    }
    
    public void b0(final WebViewClient webViewClient, final WebView webView, final WebResourceRequest webResourceRequest, final e e, final n$f0$a<Void> n$f0$a) {
        this.d.a(webView, (n$i0$a)new s5());
        final Long h = this.c.h((Object)webView);
        Objects.requireNonNull((Object)h);
        this.w(Long.valueOf(this.M(webViewClient)), h, K(webResourceRequest), J(e), (n$f0$a)n$f0$a);
    }
    
    public void c0(final WebViewClient webViewClient, final WebView webView, final WebResourceRequest webResourceRequest, final n$f0$a<Void> n$f0$a) {
        this.d.a(webView, (n$i0$a)new k5());
        final Long h = this.c.h((Object)webView);
        Objects.requireNonNull((Object)h);
        this.x(Long.valueOf(this.M(webViewClient)), h, K(webResourceRequest), (n$f0$a)n$f0$a);
    }
    
    public void d0(final WebViewClient webViewClient, final WebView webView, final String s, final n$f0$a<Void> n$f0$a) {
        this.d.a(webView, (n$i0$a)new p5());
        final Long h = this.c.h((Object)webView);
        Objects.requireNonNull((Object)h);
        this.y(Long.valueOf(this.M(webViewClient)), h, s, (n$f0$a)n$f0$a);
    }
}
