package io.flutter.plugins.webviewflutter;

import java.util.Objects;
import android.webkit.GeolocationPermissions$Callback;
import t1.c;

public class y3 implements n$m
{
    private final c a;
    private final c4 b;
    
    public y3(final c a, final c4 b) {
        this.a = a;
        this.b = b;
    }
    
    private GeolocationPermissions$Callback b(final Long n) {
        final GeolocationPermissions$Callback geolocationPermissions$Callback = (GeolocationPermissions$Callback)this.b.i((long)n);
        Objects.requireNonNull((Object)geolocationPermissions$Callback);
        return geolocationPermissions$Callback;
    }
    
    public void a(final Long n, final String s, final Boolean b, final Boolean b2) {
        this.b(n).invoke(s, (boolean)b, (boolean)b2);
    }
}
