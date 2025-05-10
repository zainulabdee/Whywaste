package io.flutter.plugins.webviewflutter;

import android.webkit.WebView;
import java.util.Objects;
import android.webkit.WebSettings;

public class h5 implements n$d0
{
    private final c4 a;
    private final h5.h5$a b;
    
    public h5(final c4 a, final h5.h5$a b) {
        this.a = a;
        this.b = b;
    }
    
    public String a(final Long n) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        return webSettings.getUserAgentString();
    }
    
    public void b(final Long n, final Boolean b) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setJavaScriptEnabled((boolean)b);
    }
    
    public void c(final Long n, final Boolean b) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setDomStorageEnabled((boolean)b);
    }
    
    public void d(final Long n, final Boolean b) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setDisplayZoomControls((boolean)b);
    }
    
    public void e(final Long n, final Long n2) {
        final WebView webView = (WebView)this.a.i((long)n2);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        this.a.b((Object)this.b.a(webView), (long)n);
    }
    
    public void f(final Long n, final Boolean b) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setMediaPlaybackRequiresUserGesture((boolean)b);
    }
    
    public void g(final Long n, final Boolean b) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setSupportMultipleWindows((boolean)b);
    }
    
    public void h(final Long n, final Boolean b) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setAllowFileAccess((boolean)b);
    }
    
    public void i(final Long n, final Boolean b) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setSupportZoom((boolean)b);
    }
    
    public void j(final Long n, final Long n2) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setTextZoom(n2.intValue());
    }
    
    public void k(final Long n, final String userAgentString) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setUserAgentString(userAgentString);
    }
    
    public void l(final Long n, final Boolean b) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setLoadWithOverviewMode((boolean)b);
    }
    
    public void m(final Long n, final Boolean b) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setUseWideViewPort((boolean)b);
    }
    
    public void n(final Long n, final Boolean b) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setJavaScriptCanOpenWindowsAutomatically((boolean)b);
    }
    
    public void o(final Long n, final Boolean b) {
        final WebSettings webSettings = (WebSettings)this.a.i((long)n);
        Objects.requireNonNull((Object)webSettings);
        final WebSettings webSettings2 = webSettings;
        webSettings.setBuiltInZoomControls((boolean)b);
    }
}
