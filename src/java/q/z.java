package q;

import java.lang.reflect.Proxy;
import p.c;
import android.webkit.WebMessage;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import android.webkit.WebMessagePort;
import p.d;

public class z extends d
{
    private WebMessagePort a;
    private WebMessagePortBoundaryInterface b;
    
    public z(final WebMessagePort a) {
        this.a = a;
    }
    
    public static WebMessagePort[] b(final d[] array) {
        if (array == null) {
            return null;
        }
        final int length = array.length;
        final WebMessagePort[] array2 = new WebMessagePort[length];
        for (int i = 0; i < length; ++i) {
            array2[i] = array[i].a();
        }
        return array2;
    }
    
    public static c c(final WebMessage webMessage) {
        return g.d(webMessage);
    }
    
    private WebMessagePort d() {
        if (this.a == null) {
            this.a = c0.c().c(Proxy.getInvocationHandler((Object)this.b));
        }
        return this.a;
    }
    
    public static d[] e(final WebMessagePort[] array) {
        if (array == null) {
            return null;
        }
        final d[] array2 = new d[array.length];
        for (int i = 0; i < array.length; ++i) {
            array2[i] = new z(array[i]);
        }
        return array2;
    }
    
    public WebMessagePort a() {
        return this.d();
    }
}
