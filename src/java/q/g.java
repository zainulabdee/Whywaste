package q;

import android.os.Handler;
import android.webkit.WebMessagePort$WebMessageCallback;
import android.net.Uri;
import android.webkit.WebView$VisualStateCallback;
import p.f;
import android.webkit.WebSettings;
import android.webkit.WebResourceError;
import android.webkit.WebView;
import android.webkit.WebMessage;
import p.c;
import android.webkit.WebMessagePort;

public class g
{
    public static void a(final WebMessagePort webMessagePort) {
        webMessagePort.close();
    }
    
    public static WebMessage b(final c c) {
        return new WebMessage(c.a(), z.b(c.b()));
    }
    
    public static WebMessagePort[] c(final WebView webView) {
        return q.c.a(webView);
    }
    
    public static c d(final WebMessage webMessage) {
        return new c(webMessage.getData(), z.e(webMessage.getPorts()));
    }
    
    public static CharSequence e(final WebResourceError webResourceError) {
        return webResourceError.getDescription();
    }
    
    public static int f(final WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }
    
    public static boolean g(final WebSettings webSettings) {
        return b.a(webSettings);
    }
    
    public static void h(final WebMessagePort webMessagePort, final WebMessage webMessage) {
        webMessagePort.postMessage(webMessage);
    }
    
    public static void i(final WebView webView, final long n, final f.a a) {
        d.a(webView, n, (WebView$VisualStateCallback)new g$c(a));
    }
    
    public static void j(final WebView webView, final WebMessage webMessage, final Uri uri) {
        e.a(webView, webMessage, uri);
    }
    
    public static void k(final WebSettings webSettings, final boolean b) {
        q.f.a(webSettings, b);
    }
    
    public static void l(final WebMessagePort webMessagePort, final p.d.a a) {
        webMessagePort.setWebMessageCallback((WebMessagePort$WebMessageCallback)new g$a(a));
    }
    
    public static void m(final WebMessagePort webMessagePort, final p.d.a a, final Handler handler) {
        webMessagePort.setWebMessageCallback((WebMessagePort$WebMessageCallback)new g$b(a), handler);
    }
}
