package io.flutter.plugins.webviewflutter;

import android.webkit.WebChromeClient$FileChooserParams;
import android.webkit.WebChromeClient$CustomViewCallback;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.WebView;
import android.webkit.GeolocationPermissions$Callback;
import android.webkit.WebChromeClient;
import android.webkit.ConsoleMessage;
import android.net.Uri;
import android.webkit.JsResult;
import java.util.List;
import android.webkit.ValueCallback;
import android.webkit.JsPromptResult;
import java.util.Objects;

public class v4 implements n$a0
{
    private final c4 a;
    private final v4.v4$b b;
    private final t4 c;
    
    public v4(final c4 a, final v4.v4$b b, final t4 c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void a(final Long n) {
        this.a.b((Object)this.b.a(this.c), (long)n);
    }
    
    public void b(final Long n, final Boolean b) {
        final c c = (c)this.a.i((long)n);
        Objects.requireNonNull((Object)c);
        final c c2 = c;
        c.z(b);
    }
    
    public void c(final Long n, final Boolean b) {
        final c c = (c)this.a.i((long)n);
        Objects.requireNonNull((Object)c);
        final c c2 = c;
        c.C(b);
    }
    
    public void d(final Long n, final Boolean b) {
        final c c = (c)this.a.i((long)n);
        Objects.requireNonNull((Object)c);
        final c c2 = c;
        c.y(b);
    }
    
    public void e(final Long n, final Boolean b) {
        final c c = (c)this.a.i((long)n);
        Objects.requireNonNull((Object)c);
        final c c2 = c;
        c.A(b);
    }
    
    public void f(final Long n, final Boolean b) {
        final c c = (c)this.a.i((long)n);
        Objects.requireNonNull((Object)c);
        final c c2 = c;
        c.B(b);
    }
    
    public static class c extends v4$a
    {
        private final t4 b;
        private boolean c;
        private boolean d;
        private boolean e;
        private boolean f;
        private boolean g;
        
        public c(final t4 b) {
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = false;
            this.g = false;
            this.b = b;
        }
        
        public void A(final boolean f) {
            this.f = f;
        }
        
        public void B(final boolean g) {
            this.g = g;
        }
        
        public void C(final boolean c) {
            this.c = c;
        }
        
        public boolean onConsoleMessage(final ConsoleMessage consoleMessage) {
            this.b.X((WebChromeClient)this, consoleMessage, (n$y$a<Void>)new x4());
            return this.d;
        }
        
        public void onGeolocationPermissionsHidePrompt() {
            this.b.Y((WebChromeClient)this, (n$y$a<Void>)new y4());
        }
        
        public void onGeolocationPermissionsShowPrompt(final String s, final GeolocationPermissions$Callback geolocationPermissions$Callback) {
            this.b.Z((WebChromeClient)this, s, geolocationPermissions$Callback, (n$y$a<Void>)new a5());
        }
        
        public void onHideCustomView() {
            this.b.a0((WebChromeClient)this, (n$y$a<Void>)new b5());
        }
        
        public boolean onJsAlert(final WebView webView, final String s, final String s2, final JsResult jsResult) {
            if (this.e) {
                this.b.b0((WebChromeClient)this, s, s2, (n$y$a<Void>)new f5(jsResult));
                return true;
            }
            return false;
        }
        
        public boolean onJsConfirm(final WebView webView, final String s, final String s2, final JsResult jsResult) {
            if (this.f) {
                this.b.c0((WebChromeClient)this, s, s2, (n$y$a<Boolean>)new e5(jsResult));
                return true;
            }
            return false;
        }
        
        public boolean onJsPrompt(final WebView webView, final String s, final String s2, final String s3, final JsPromptResult jsPromptResult) {
            if (this.g) {
                this.b.d0((WebChromeClient)this, s, s2, s3, (n$y$a<String>)new z4(jsPromptResult));
                return true;
            }
            return false;
        }
        
        public void onPermissionRequest(final PermissionRequest permissionRequest) {
            this.b.e0((WebChromeClient)this, permissionRequest, (n$y$a<Void>)new g5());
        }
        
        public void onProgressChanged(final WebView webView, final int n) {
            this.b.f0((WebChromeClient)this, webView, (long)n, (n$y$a<Void>)new c5());
        }
        
        public void onShowCustomView(final View view, final WebChromeClient$CustomViewCallback webChromeClient$CustomViewCallback) {
            this.b.g0((WebChromeClient)this, view, webChromeClient$CustomViewCallback, (n$y$a<Void>)new d5());
        }
        
        public boolean onShowFileChooser(final WebView webView, final ValueCallback<Uri[]> valueCallback, final WebChromeClient$FileChooserParams webChromeClient$FileChooserParams) {
            final boolean c = this.c;
            this.b.h0((WebChromeClient)this, webView, webChromeClient$FileChooserParams, (n$y$a<List<String>>)new w4(c, valueCallback));
            return c;
        }
        
        public void y(final boolean d) {
            this.d = d;
        }
        
        public void z(final boolean e) {
            this.e = e;
        }
    }
}
