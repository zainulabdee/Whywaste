package io.flutter.plugins.webviewflutter;

import java.util.List;
import android.webkit.WebChromeClient$FileChooserParams;
import android.webkit.WebChromeClient$CustomViewCallback;
import android.view.View;
import android.webkit.WebView;
import android.webkit.PermissionRequest;
import android.webkit.GeolocationPermissions$Callback;
import java.util.Objects;
import android.webkit.ConsoleMessage;
import android.webkit.ConsoleMessage$MessageLevel;
import android.webkit.WebChromeClient;
import t1.c;

public class t4 extends n$y
{
    private final c b;
    private final c4 c;
    private final l6 d;
    
    public t4(final c b, final c4 c) {
        super(b);
        this.b = b;
        this.c = c;
        this.d = new l6(b, c);
    }
    
    private long P(final WebChromeClient webChromeClient) {
        final Long h = this.c.h((Object)webChromeClient);
        if (h != null) {
            return h;
        }
        throw new IllegalStateException("Could not find identifier for WebChromeClient.");
    }
    
    private static n$b i0(final ConsoleMessage$MessageLevel consoleMessage$MessageLevel) {
        final int n = t4$a.a[((Enum)consoleMessage$MessageLevel).ordinal()];
        if (n == 1) {
            return n$b.i;
        }
        if (n == 2) {
            return n$b.h;
        }
        if (n == 3) {
            return n$b.j;
        }
        if (n == 4) {
            return n$b.g;
        }
        if (n != 5) {
            return n$b.k;
        }
        return n$b.f;
    }
    
    public void X(final WebChromeClient webChromeClient, final ConsoleMessage consoleMessage, final n$y$a<Void> n$y$a) {
        final Long h = this.c.h((Object)webChromeClient);
        Objects.requireNonNull((Object)h);
        super.x(h, new n$a$a().c(Long.valueOf((long)consoleMessage.lineNumber())).d(consoleMessage.message()).b(i0(consoleMessage.messageLevel())).e(consoleMessage.sourceId()).a(), (n$y$a)n$y$a);
    }
    
    public void Y(final WebChromeClient webChromeClient, final n$y$a<Void> n$y$a) {
        final Long h = this.c.h((Object)webChromeClient);
        Objects.requireNonNull((Object)h);
        super.y(h, (n$y$a)n$y$a);
    }
    
    public void Z(final WebChromeClient webChromeClient, final String s, final GeolocationPermissions$Callback geolocationPermissions$Callback, final n$y$a<Void> n$y$a) {
        new x3(this.b, this.c).a(geolocationPermissions$Callback, (n$l$a)new o4());
        final Long h = this.c.h((Object)webChromeClient);
        Objects.requireNonNull((Object)h);
        final Long h2 = this.c.h((Object)geolocationPermissions$Callback);
        Objects.requireNonNull((Object)h2);
        this.z(h, h2, s, (n$y$a)n$y$a);
    }
    
    public void a0(final WebChromeClient webChromeClient, final n$y$a<Void> n$y$a) {
        final Long h = this.c.h((Object)webChromeClient);
        Objects.requireNonNull((Object)h);
        super.A(h, (n$y$a)n$y$a);
    }
    
    public void b0(final WebChromeClient webChromeClient, final String s, final String s2, final n$y$a<Void> n$y$a) {
        final Long h = this.c.h((Object)webChromeClient);
        Objects.requireNonNull((Object)h);
        super.B(h, s, s2, (n$y$a)n$y$a);
    }
    
    public void c0(final WebChromeClient webChromeClient, final String s, final String s2, final n$y$a<Boolean> n$y$a) {
        final Long h = this.c.h((Object)webChromeClient);
        Objects.requireNonNull((Object)h);
        super.C(h, s, s2, (n$y$a)n$y$a);
    }
    
    public void d0(final WebChromeClient webChromeClient, final String s, final String s2, final String s3, final n$y$a<String> n$y$a) {
        final Long h = this.c.h((Object)webChromeClient);
        Objects.requireNonNull((Object)h);
        super.D(h, s, s2, s3, (n$y$a)n$y$a);
    }
    
    public void e0(final WebChromeClient webChromeClient, final PermissionRequest permissionRequest, final n$y$a<Void> n$y$a) {
        new j4(this.b, this.c).a(permissionRequest, permissionRequest.getResources(), (n$u$a)new s4());
        final Long h = this.c.h((Object)webChromeClient);
        Objects.requireNonNull((Object)h);
        final Long h2 = this.c.h((Object)permissionRequest);
        Objects.requireNonNull((Object)h2);
        super.E(h, h2, (n$y$a)n$y$a);
    }
    
    public void f0(final WebChromeClient webChromeClient, final WebView webView, final Long n, final n$y$a<Void> n$y$a) {
        this.d.a(webView, (n$i0$a)new p4());
        final Long h = this.c.h((Object)webView);
        Objects.requireNonNull((Object)h);
        super.F(Long.valueOf(this.P(webChromeClient)), h, n, (n$y$a)n$y$a);
    }
    
    public void g0(final WebChromeClient webChromeClient, final View view, final WebChromeClient$CustomViewCallback webChromeClient$CustomViewCallback, final n$y$a<Void> n$y$a) {
        new l4(this.b, this.c).a(view, (n$x$a)new m4());
        new d(this.b, this.c).a(webChromeClient$CustomViewCallback, (n$d$a)new n4());
        final Long h = this.c.h((Object)webChromeClient);
        Objects.requireNonNull((Object)h);
        final Long h2 = this.c.h((Object)view);
        Objects.requireNonNull((Object)h2);
        final Long h3 = this.c.h((Object)webChromeClient$CustomViewCallback);
        Objects.requireNonNull((Object)h3);
        this.G(h, h2, h3, (n$y$a)n$y$a);
    }
    
    public void h0(final WebChromeClient webChromeClient, final WebView webView, final WebChromeClient$FileChooserParams webChromeClient$FileChooserParams, final n$y$a<List<String>> n$y$a) {
        this.d.a(webView, (n$i0$a)new q4());
        new j(this.b, this.c).e(webChromeClient$FileChooserParams, (n$i$a<Void>)new r4());
        final Long h = this.c.h((Object)webChromeClient);
        Objects.requireNonNull((Object)h);
        final Long h2 = this.c.h((Object)webView);
        Objects.requireNonNull((Object)h2);
        final Long h3 = this.c.h((Object)webChromeClient$FileChooserParams);
        Objects.requireNonNull((Object)h3);
        this.H(h, h2, h3, (n$y$a)n$y$a);
    }
}
