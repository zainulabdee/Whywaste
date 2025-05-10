package q;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import android.webkit.WebView;
import android.os.Build$VERSION;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import y2.a;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;

public class c0
{
    static d0 a() {
        try {
            return (d0)new e0((WebViewProviderFactoryBoundaryInterface)y2.a.a(WebViewProviderFactoryBoundaryInterface.class, b()));
        }
        catch (final NoSuchMethodException ex) {
            throw new RuntimeException((Throwable)ex);
        }
        catch (final ClassNotFoundException ex2) {
            return (d0)new w();
        }
        catch (final InvocationTargetException ex3) {
            throw new RuntimeException((Throwable)ex3);
        }
        catch (final IllegalAccessException ex4) {
            throw new RuntimeException((Throwable)ex4);
        }
    }
    
    private static InvocationHandler b() {
        return (InvocationHandler)Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, e()).getDeclaredMethod("createWebViewProviderFactory", (Class<?>[])new Class[0]).invoke((Object)null, new Object[0]);
    }
    
    public static f0 c() {
        return a.a;
    }
    
    public static d0 d() {
        return b.a;
    }
    
    public static ClassLoader e() {
        if (Build$VERSION.SDK_INT >= 28) {
            return u.b();
        }
        return f().getClass().getClassLoader();
    }
    
    private static Object f() {
        try {
            final Method declaredMethod = WebView.class.getDeclaredMethod("getFactory", (Class<?>[])new Class[0]);
            ((AccessibleObject)declaredMethod).setAccessible(true);
            return declaredMethod.invoke((Object)null, new Object[0]);
        }
        catch (final IllegalAccessException ex) {
            throw new RuntimeException((Throwable)ex);
        }
        catch (final InvocationTargetException ex2) {
            throw new RuntimeException((Throwable)ex2);
        }
        catch (final NoSuchMethodException ex3) {
            throw new RuntimeException((Throwable)ex3);
        }
    }
    
    private static class a
    {
        static final f0 a;
        
        static {
            a = new f0(c0.d().getWebkitToCompatConverter());
        }
    }
    
    private static class b
    {
        static final d0 a;
        
        static {
            a = c0.a();
        }
    }
}
