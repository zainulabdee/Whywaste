package io.flutter.plugins.webviewflutter;

import java.util.Objects;
import android.webkit.HttpAuthHandler;
import t1.c;

public class a4 implements n$o
{
    private final c a;
    private final c4 b;
    
    public a4(final c a, final c4 b) {
        this.a = a;
        this.b = b;
    }
    
    private HttpAuthHandler d(final Long n) {
        final HttpAuthHandler httpAuthHandler = (HttpAuthHandler)this.b.i((long)n);
        Objects.requireNonNull((Object)httpAuthHandler);
        final HttpAuthHandler httpAuthHandler2 = httpAuthHandler;
        return httpAuthHandler;
    }
    
    public void a(final Long n) {
        this.d(n).cancel();
    }
    
    public Boolean b(final Long n) {
        return this.d(n).useHttpAuthUsernamePassword();
    }
    
    public void c(final Long n, final String s, final String s2) {
        this.d(n).proceed(s, s2);
    }
}
