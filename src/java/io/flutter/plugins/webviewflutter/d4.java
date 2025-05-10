package io.flutter.plugins.webviewflutter;

public class d4 implements n$r
{
    private final c4 a;
    
    public d4(final c4 a) {
        this.a = a;
    }
    
    public void a(final Long n) {
        final Object i = this.a.i((long)n);
        if (i instanceof t6.a) {
            ((t6.a)i).destroy();
        }
        this.a.m((long)n);
    }
}
