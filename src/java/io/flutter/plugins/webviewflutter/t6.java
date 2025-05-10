package io.flutter.plugins.webviewflutter;

import android.widget.FrameLayout;
import android.view.View;
import io.flutter.plugin.platform.h;
import android.view.ViewParent;
import io.flutter.embedding.android.r;
import android.os.Build$VERSION;
import io.flutter.plugin.platform.i;
import android.webkit.WebViewClient;
import android.webkit.ValueCallback;
import java.util.Map;
import android.webkit.WebChromeClient;
import android.webkit.DownloadListener;
import java.util.Objects;
import android.webkit.WebView;
import android.hardware.display.DisplayManager;
import android.content.Context;
import t1.c;

public class t6 implements n$j0
{
    private final c4 a;
    private final t6.t6$b b;
    private final c c;
    private Context d;
    
    public t6(final c4 a, final c c, final t6.t6$b b, final Context d) {
        this.a = a;
        this.c = c;
        this.b = b;
        this.d = d;
    }
    
    public void A(final Context d) {
        this.d = d;
    }
    
    public void a(final Long n) {
        final f f = new f();
        final DisplayManager displayManager = (DisplayManager)this.d.getSystemService("display");
        f.b(displayManager);
        final a a = this.b.a(this.d, this.c, this.a);
        f.a(displayManager);
        this.a.b((Object)a, (long)n);
    }
    
    public Long b(final Long n) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        return (long)((View)webView).getScrollX();
    }
    
    public String c(final Long n) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        return webView.getTitle();
    }
    
    public void d(final Long n, final String s, final String s2, final String s3) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        webView.loadData(s, s2, s3);
    }
    
    public void e(final Long n) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        webView.reload();
    }
    
    public void f(final Long n, final Long n2) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        final g4 g4 = (g4)this.a.i((long)n2);
        Objects.requireNonNull((Object)g4);
        webView.addJavascriptInterface((Object)g4, g4.b);
    }
    
    public Boolean g(final Long n) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        return webView.canGoForward();
    }
    
    public void h(final Long n, final String s, final String s2, final String s3, final String s4, final String s5) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        webView.loadDataWithBaseURL(s, s2, s3, s4, s5);
    }
    
    public void i(final Long n) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        webView.goBack();
    }
    
    public void j(final Long n, final Long n2) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        webView.setBackgroundColor(n2.intValue());
    }
    
    public void k(final Long n, final Long n2) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        final c4 a = this.a;
        Objects.requireNonNull((Object)n2);
        webView.setDownloadListener((DownloadListener)a.i((long)n2));
    }
    
    public void l(final Boolean b) {
        this.b.b((boolean)b);
    }
    
    public void m(final Long n, final Long n2) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        final c4 a = this.a;
        Objects.requireNonNull((Object)n2);
        webView.setWebChromeClient((WebChromeClient)a.i((long)n2));
    }
    
    public void n(final Long n) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        webView.goForward();
    }
    
    public void o(final Long n, final String s, final Map<String, String> map) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        webView.loadUrl(s, (Map)map);
    }
    
    public Boolean p(final Long n) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        return webView.canGoBack();
    }
    
    public void q(final Long n, final Boolean b) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        webView.clearCache((boolean)b);
    }
    
    public String r(final Long n) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        return webView.getUrl();
    }
    
    public void s(final Long n, final String s, final byte[] array) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        webView.postUrl(s, array);
    }
    
    public void t(final Long n, final String s, final n$w<String> n$w) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        Objects.requireNonNull((Object)n$w);
        webView.evaluateJavascript(s, (ValueCallback)new q6((n$w)n$w));
    }
    
    public void u(final Long n, final Long n2, final Long n3) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        ((View)webView).scrollTo(n2.intValue(), n3.intValue());
    }
    
    public void v(final Long n, final Long n2) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        final g4 g4 = (g4)this.a.i((long)n2);
        Objects.requireNonNull((Object)g4);
        webView.removeJavascriptInterface(g4.b);
    }
    
    public Long w(final Long n) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        return (long)((View)webView).getScrollY();
    }
    
    public n$l0 x(final Long n) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        return new n$l0$a().b(Long.valueOf((long)((View)webView).getScrollX())).c(Long.valueOf((long)((View)webView).getScrollY())).a();
    }
    
    public void y(final Long n, final Long n2, final Long n3) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        ((View)webView).scrollBy(n2.intValue(), n3.intValue());
    }
    
    public void z(final Long n, final Long n2) {
        final WebView webView = (WebView)this.a.i((long)n);
        Objects.requireNonNull((Object)webView);
        final WebView webView2 = webView;
        webView.setWebViewClient((WebViewClient)this.a.i((long)n2));
    }
    
    public static class a extends WebView implements i
    {
        private l6 e;
        private WebViewClient f;
        private v4$a g;
        private final a.t6$a$a h;
        
        public a(final Context context, final c c, final c4 c2) {
            this(context, c, c2, (a.t6$a$a)new s6());
        }
        
        a(final Context context, final c c, final c4 c2, final a.t6$a$a h) {
            super(context);
            this.f = new WebViewClient();
            this.g = new v4$a();
            this.e = new l6(c, c2);
            this.h = h;
            this.setWebViewClient(this.f);
            this.setWebChromeClient((WebChromeClient)this.g);
        }
        
        private r j() {
            a parent = this;
            while (((ViewParent)parent).getParent() != null) {
                final ViewParent viewParent = (ViewParent)(parent = (a)((ViewParent)parent).getParent());
                if (viewParent instanceof r) {
                    return (r)viewParent;
                }
            }
            return null;
        }
        
        public void d() {
        }
        
        public View getView() {
            return (View)this;
        }
        
        public WebChromeClient getWebChromeClient() {
            return (WebChromeClient)this.g;
        }
        
        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.h.a(26)) {
                final r j = this.j();
                if (j != null) {
                    ((FrameLayout)j).setImportantForAutofill(1);
                }
            }
        }
        
        protected void onScrollChanged(final int n, final int n2, final int n3, final int n4) {
            super.onScrollChanged(n, n2, n3, n4);
            this.e.b((WebView)this, Long.valueOf((long)n), Long.valueOf((long)n2), Long.valueOf((long)n3), Long.valueOf((long)n4), (n$i0$a)new r6());
        }
        
        void setApi(final l6 e) {
            this.e = e;
        }
        
        public void setWebChromeClient(final WebChromeClient webChromeClient) {
            super.setWebChromeClient(webChromeClient);
            if (webChromeClient instanceof v4$a) {
                (this.g = (v4$a)webChromeClient).b(this.f);
                return;
            }
            throw new AssertionError((Object)"Client must be a SecureWebChromeClient.");
        }
        
        public void setWebViewClient(final WebViewClient webViewClient) {
            super.setWebViewClient(webViewClient);
            this.f = webViewClient;
            this.g.b(webViewClient);
        }
    }
}
