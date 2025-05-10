package io.flutter.plugins.webviewflutter;

import t1.c;

public class h4 extends n$s
{
    private final c4 b;
    
    public h4(final c c, final c4 b) {
        super(c);
        this.b = b;
    }
    
    private long e(final g4 g4) {
        final Long h = this.b.h((Object)g4);
        if (h != null) {
            return h;
        }
        throw new IllegalStateException("Could not find identifier for JavaScriptChannel.");
    }
    
    public void f(final g4 g4, final String s, final n$s$a<Void> n$s$a) {
        super.d(Long.valueOf(this.e(g4)), s, (n$s$a)n$s$a);
    }
}
