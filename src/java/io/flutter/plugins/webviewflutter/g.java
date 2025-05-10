package io.flutter.plugins.webviewflutter;

import android.webkit.DownloadListener;
import t1.c;

public class g extends n$f
{
    private final c4 b;
    
    public g(final c c, final c4 b) {
        super(c);
        this.b = b;
    }
    
    private long e(final DownloadListener downloadListener) {
        final Long h = this.b.h((Object)downloadListener);
        if (h != null) {
            return h;
        }
        throw new IllegalStateException("Could not find identifier for DownloadListener.");
    }
    
    public void f(final DownloadListener downloadListener, final String s, final String s2, final String s3, final String s4, final long n, final n$f$a<Void> n$f$a) {
        this.d(Long.valueOf(this.e(downloadListener)), s, s2, s3, s4, Long.valueOf(n), (n$f$a)n$f$a);
    }
}
