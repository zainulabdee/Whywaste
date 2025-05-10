package io.flutter.plugins.webviewflutter;

import java.util.Arrays;
import android.webkit.WebChromeClient$FileChooserParams;
import t1.c;

public class j extends n$i
{
    private final c4 b;
    
    public j(final c c, final c4 b) {
        super(c);
        this.b = b;
    }
    
    private static n$h f(final int n) {
        if (n == 0) {
            return n$h.f;
        }
        if (n == 1) {
            return n$h.g;
        }
        if (n == 3) {
            return n$h.h;
        }
        throw new IllegalArgumentException(String.format("Unsupported FileChooserMode: %d", new Object[] { n }));
    }
    
    public void e(final WebChromeClient$FileChooserParams webChromeClient$FileChooserParams, final n$i$a<Void> n$i$a) {
        if (!this.b.f((Object)webChromeClient$FileChooserParams)) {
            this.b(Long.valueOf(this.b.c((Object)webChromeClient$FileChooserParams)), Boolean.valueOf(webChromeClient$FileChooserParams.isCaptureEnabled()), Arrays.asList((Object[])webChromeClient$FileChooserParams.getAcceptTypes()), f(webChromeClient$FileChooserParams.getMode()), webChromeClient$FileChooserParams.getFilenameHint(), (n$i$a)n$i$a);
        }
    }
}
