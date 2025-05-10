package y2;

import android.os.Build;
import java.util.Collection;
import java.lang.reflect.Proxy;
import java.lang.reflect.InvocationHandler;

public class a
{
    public static <T> T a(final Class<T> clazz, final InvocationHandler invocationHandler) {
        if (invocationHandler == null) {
            return null;
        }
        return clazz.cast(Proxy.newProxyInstance(a.class.getClassLoader(), new Class[] { clazz }, invocationHandler));
    }
    
    public static boolean b(final Collection<String> collection, final String s) {
        if (!collection.contains((Object)s)) {
            if (c()) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s);
                sb.append(":dev");
                if (collection.contains((Object)sb.toString())) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    private static boolean c() {
        final String type = Build.TYPE;
        return "eng".equals((Object)type) || "userdebug".equals((Object)type);
    }
}
