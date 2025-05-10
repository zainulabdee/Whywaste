package q;

import android.content.Context;
import android.webkit.ValueCallback;
import java.util.List;
import android.net.Uri;
import android.webkit.SafeBrowsingResponse;

public class q
{
    public static void a(final SafeBrowsingResponse safeBrowsingResponse, final boolean b) {
        safeBrowsingResponse.backToSafety(b);
    }
    
    public static Uri b() {
        return p.a();
    }
    
    public static void c(final SafeBrowsingResponse safeBrowsingResponse, final boolean b) {
        safeBrowsingResponse.proceed(b);
    }
    
    public static void d(final List<String> list, final ValueCallback<Boolean> valueCallback) {
        n.a((List)list, (ValueCallback)valueCallback);
    }
    
    public static void e(final SafeBrowsingResponse safeBrowsingResponse, final boolean b) {
        safeBrowsingResponse.showInterstitial(b);
    }
    
    public static void f(final Context context, final ValueCallback<Boolean> valueCallback) {
        o.a(context, (ValueCallback)valueCallback);
    }
}
