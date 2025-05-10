package io.flutter.plugins.webviewflutter;

import android.os.Handler;

public class i4 implements n$t
{
    private final c4 a;
    private final i4.i4$a b;
    private final h4 c;
    private Handler d;
    
    public i4(final c4 a, final i4.i4$a b, final h4 c, final Handler d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    public void a(final Long n, final String s) {
        this.a.b((Object)this.b.a(this.c, s, this.d), (long)n);
    }
    
    public void b(final Handler d) {
        this.d = d;
    }
}
