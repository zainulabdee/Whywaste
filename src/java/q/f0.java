package q;

import android.webkit.WebResourceError;
import android.webkit.WebMessagePort;
import android.webkit.SafeBrowsingResponse;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

public class f0
{
    private final WebkitToCompatConverterBoundaryInterface a;
    
    public f0(final WebkitToCompatConverterBoundaryInterface a) {
        this.a = a;
    }
    
    public SafeBrowsingResponse a(final InvocationHandler invocationHandler) {
        return (SafeBrowsingResponse)this.a.convertSafeBrowsingResponse(invocationHandler);
    }
    
    public InvocationHandler b(final SafeBrowsingResponse safeBrowsingResponse) {
        return this.a.convertSafeBrowsingResponse(safeBrowsingResponse);
    }
    
    public WebMessagePort c(final InvocationHandler invocationHandler) {
        return (WebMessagePort)this.a.convertWebMessagePort(invocationHandler);
    }
    
    public WebResourceError d(final InvocationHandler invocationHandler) {
        return (WebResourceError)this.a.convertWebResourceError(invocationHandler);
    }
    
    public InvocationHandler e(final WebResourceError webResourceError) {
        return this.a.convertWebResourceError(webResourceError);
    }
}
