package io.flutter.embedding.android;

import android.view.KeyEvent;
import s1.d;

public class t implements z$d
{
    private final d a;
    private final z$b b;
    
    public t(final d a) {
        this.b = new z$b();
        this.a = a;
    }
    
    public void a(final KeyEvent keyEvent, final z$d$a z$d$a) {
        final int action = keyEvent.getAction();
        boolean b = false;
        if (action != 0 && action != 1) {
            z$d$a.a(false);
            return;
        }
        final d.b b2 = new d.b(keyEvent, this.b.a(keyEvent.getUnicodeChar()));
        if (action != 0) {
            b = true;
        }
        this.a.e(b2, b, (d.a)new s(z$d$a));
    }
}
