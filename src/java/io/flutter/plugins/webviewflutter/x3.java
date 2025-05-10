package io.flutter.plugins.webviewflutter;

import android.webkit.GeolocationPermissions$Callback;
import t1.c;

public class x3
{
    private final c a;
    private final c4 b;
    private n$l c;
    
    public x3(final c a, final c4 b) {
        this.a = a;
        this.b = b;
        this.c = new n$l(a);
    }
    
    public void a(final GeolocationPermissions$Callback geolocationPermissions$Callback, final n$l$a<Void> n$l$a) {
        if (!this.b.f((Object)geolocationPermissions$Callback)) {
            this.c.b(Long.valueOf(this.b.c((Object)geolocationPermissions$Callback)), (n$l$a)n$l$a);
        }
    }
}
