package q;

import java.lang.reflect.Proxy;
import y2.a;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;
import android.webkit.WebResourceError;
import p.e;

public class a0 extends e
{
    private WebResourceError a;
    private WebResourceErrorBoundaryInterface b;
    
    public a0(final WebResourceError a) {
        this.a = a;
    }
    
    public a0(final InvocationHandler invocationHandler) {
        this.b = (WebResourceErrorBoundaryInterface)y2.a.a((Class)WebResourceErrorBoundaryInterface.class, invocationHandler);
    }
    
    private WebResourceErrorBoundaryInterface c() {
        if (this.b == null) {
            this.b = (WebResourceErrorBoundaryInterface)y2.a.a((Class)WebResourceErrorBoundaryInterface.class, c0.c().e(this.a));
        }
        return this.b;
    }
    
    private WebResourceError d() {
        if (this.a == null) {
            this.a = c0.c().d(Proxy.getInvocationHandler((Object)this.b));
        }
        return this.a;
    }
    
    public CharSequence a() {
        final q.a.b v = b0.v;
        if (v.c()) {
            return g.e(this.d());
        }
        if (v.d()) {
            return this.c().getDescription();
        }
        throw b0.a();
    }
    
    public int b() {
        final q.a.b w = b0.w;
        if (w.c()) {
            return g.f(this.d());
        }
        if (w.d()) {
            return this.c().getErrorCode();
        }
        throw b0.a();
    }
}
