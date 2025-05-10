package p;

import java.lang.reflect.InvocationTargetException;
import q.m;
import android.os.Build$VERSION;
import android.content.pm.PackageInfo;
import android.net.Uri;

public class f
{
    private static final Uri a;
    private static final Uri b;
    
    static {
        a = Uri.parse("*");
        b = Uri.parse("");
    }
    
    public static PackageInfo a() {
        if (Build$VERSION.SDK_INT >= 26) {
            return m.a();
        }
        try {
            return b();
        }
        catch (final ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
            return null;
        }
    }
    
    private static PackageInfo b() {
        return (PackageInfo)Class.forName("android.webkit.WebViewFactory").getMethod("getLoadedPackageInfo", (Class<?>[])new Class[0]).invoke((Object)null, new Object[0]);
    }
    
    public interface a
    {
        void onComplete(final long p0);
    }
}
