package io.flutter.plugins.webviewflutter;

import java.util.Objects;
import android.webkit.WebChromeClient$CustomViewCallback;
import t1.c;

public class e implements n$e
{
    private final c a;
    private final c4 b;
    
    public e(final c a, final c4 b) {
        this.a = a;
        this.b = b;
    }
    
    private WebChromeClient$CustomViewCallback b(final Long n) {
        final WebChromeClient$CustomViewCallback webChromeClient$CustomViewCallback = (WebChromeClient$CustomViewCallback)this.b.i((long)n);
        Objects.requireNonNull((Object)webChromeClient$CustomViewCallback);
        return webChromeClient$CustomViewCallback;
    }
    
    public void a(final Long n) {
        this.b(n).onCustomViewHidden();
    }
}
