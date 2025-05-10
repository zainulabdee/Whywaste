package io.flutter.plugins.webviewflutter;

import android.webkit.HttpAuthHandler;
import t1.c;

public class z3
{
    private final c a;
    private final c4 b;
    private final n.n c;
    
    public z3(final c a, final c4 b) {
        this.a = a;
        this.b = b;
        this.c = new n.n(a);
    }
    
    public void a(final HttpAuthHandler httpAuthHandler, final n.n.a<Void> a) {
        if (!this.b.f((Object)httpAuthHandler)) {
            this.c.b(this.b.c((Object)httpAuthHandler), a);
        }
    }
}
