package io.flutter.plugins.webviewflutter;

import java.util.Arrays;
import android.webkit.PermissionRequest;
import t1.c;

public class j4
{
    private final c a;
    private final c4 b;
    private n$u c;
    
    public j4(final c a, final c4 b) {
        this.a = a;
        this.b = b;
        this.c = new n$u(a);
    }
    
    public void a(final PermissionRequest permissionRequest, final String[] array, final n$u$a<Void> n$u$a) {
        if (!this.b.f(permissionRequest)) {
            this.c.b(Long.valueOf(this.b.c(permissionRequest)), Arrays.asList((Object[])array), (n$u$a)n$u$a);
        }
    }
}
