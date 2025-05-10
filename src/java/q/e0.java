package q;

import y2.a;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

public class e0 implements d0
{
    final WebViewProviderFactoryBoundaryInterface a;
    
    public e0(final WebViewProviderFactoryBoundaryInterface a) {
        this.a = a;
    }
    
    public String[] a() {
        return this.a.getSupportedFeatures();
    }
    
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface)y2.a.a((Class)WebkitToCompatConverterBoundaryInterface.class, this.a.getWebkitToCompatConverter());
    }
}
