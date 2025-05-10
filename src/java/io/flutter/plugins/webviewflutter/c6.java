package io.flutter.plugins.webviewflutter;

import android.os.Build$VERSION;
import java.util.Objects;
import android.webkit.WebViewClient;

public class c6 implements n$h0
{
    private final c4 a;
    private final c6.c6$b b;
    private final t5 c;
    
    public c6(final c4 a, final c6.c6$b b, final t5 c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public void a(final Long n) {
        this.a.b((Object)this.b.a(this.c), (long)n);
    }
    
    public void b(final Long n, final Boolean b) {
        final WebViewClient webViewClient = (WebViewClient)this.a.i((long)n);
        Objects.requireNonNull((Object)webViewClient);
        final WebViewClient webViewClient2 = webViewClient;
        if (webViewClient instanceof c6.c6$a) {
            ((c6.c6$a)webViewClient).s((boolean)b);
        }
        else {
            if (Build$VERSION.SDK_INT < 24 || !(webViewClient instanceof c6.c6$c)) {
                throw new IllegalStateException("This WebViewClient doesn't support setting the returnValueForShouldOverrideUrlLoading.");
            }
            ((c6.c6$c)webViewClient).q((boolean)b);
        }
    }
}
