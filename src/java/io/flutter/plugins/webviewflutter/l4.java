package io.flutter.plugins.webviewflutter;

import android.view.View;
import t1.c;

public class l4
{
    private final c a;
    private final c4 b;
    private n$x c;
    
    public l4(final c a, final c4 b) {
        this.a = a;
        this.b = b;
        this.c = new n$x(a);
    }
    
    public void a(final View view, final n$x$a<Void> n$x$a) {
        if (!this.b.f(view)) {
            this.c.b(Long.valueOf(this.b.c(view)), (n$x$a)n$x$a);
        }
    }
}
