package q;

import java.util.concurrent.Executor;
import java.io.OutputStream;
import android.webkit.TracingConfig$Builder;
import p.b;
import android.os.Looper;
import android.webkit.WebView;
import android.webkit.TracingController;

public class u
{
    public static TracingController a() {
        return TracingController.getInstance();
    }
    
    public static ClassLoader b() {
        return s.a();
    }
    
    public static Looper c(final WebView webView) {
        return r.a(webView);
    }
    
    public static boolean d(final TracingController tracingController) {
        return tracingController.isTracing();
    }
    
    public static void e(final String s) {
        t.a(s);
    }
    
    public static void f(final TracingController tracingController, final b b) {
        new TracingConfig$Builder();
        throw null;
    }
    
    public static boolean g(final TracingController tracingController, final OutputStream outputStream, final Executor executor) {
        return tracingController.stop(outputStream, executor);
    }
}
