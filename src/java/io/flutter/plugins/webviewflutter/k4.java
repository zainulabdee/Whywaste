package io.flutter.plugins.webviewflutter;

import java.util.List;
import java.util.Objects;
import android.webkit.PermissionRequest;
import t1.c;

public class k4 implements n$v
{
    private final c a;
    private final c4 b;
    
    public k4(final c a, final c4 b) {
        this.a = a;
        this.b = b;
    }
    
    private PermissionRequest c(final Long n) {
        final PermissionRequest permissionRequest = (PermissionRequest)this.b.i((long)n);
        Objects.requireNonNull((Object)permissionRequest);
        final PermissionRequest permissionRequest2 = permissionRequest;
        return permissionRequest;
    }
    
    public void a(final Long n, final List<String> list) {
        this.c(n).grant((String[])list.toArray((Object[])new String[0]));
    }
    
    public void b(final Long n) {
        this.c(n).deny();
    }
}
