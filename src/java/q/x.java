package q;

import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import android.webkit.SafeBrowsingResponse;
import p.a;

public class x extends a
{
    private SafeBrowsingResponse a;
    private SafeBrowsingResponseBoundaryInterface b;
    
    public x(final SafeBrowsingResponse a) {
        this.a = a;
    }
    
    public x(final InvocationHandler invocationHandler) {
        this.b = (SafeBrowsingResponseBoundaryInterface)y2.a.a((Class)SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }
    
    private SafeBrowsingResponseBoundaryInterface b() {
        if (this.b == null) {
            this.b = (SafeBrowsingResponseBoundaryInterface)y2.a.a((Class)SafeBrowsingResponseBoundaryInterface.class, c0.c().b(this.a));
        }
        return this.b;
    }
    
    private SafeBrowsingResponse c() {
        if (this.a == null) {
            this.a = c0.c().a(Proxy.getInvocationHandler((Object)this.b));
        }
        return this.a;
    }
    
    public void a(final boolean b) {
        final q.a.f z = b0.z;
        if (z.c()) {
            q.e(this.c(), b);
        }
        else {
            if (!z.d()) {
                throw b0.a();
            }
            this.b().showInterstitial(b);
        }
    }
}
