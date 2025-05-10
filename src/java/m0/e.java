package m0;

import android.os.Build;
import c0.l;
import android.content.pm.PackageManager;
import android.content.Context;

public final class e
{
    private static Boolean a;
    private static Boolean b;
    private static Boolean c;
    private static Boolean d;
    
    public static boolean a(final Context context) {
        final PackageManager packageManager = context.getPackageManager();
        if (e.d == null) {
            final boolean g = h.g();
            boolean b = false;
            if (g) {
                b = b;
                if (packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                    b = true;
                }
            }
            e.d = b;
        }
        return e.d;
    }
    
    public static boolean b() {
        final int a = l.a;
        return "user".equals((Object)Build.TYPE);
    }
    
    public static boolean c(final Context context) {
        return g(context.getPackageManager());
    }
    
    public static boolean d(final Context context) {
        return (c(context) && !h.f()) || (e(context) && (!h.g() || h.i()));
    }
    
    public static boolean e(final Context context) {
        if (e.b == null) {
            final boolean e = h.e();
            boolean b = false;
            if (e) {
                b = b;
                if (context.getPackageManager().hasSystemFeature("cn.google")) {
                    b = true;
                }
            }
            m0.e.b = b;
        }
        return e.b;
    }
    
    public static boolean f(final Context context) {
        if (e.c == null) {
            final boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.type.iot");
            boolean b = true;
            if (!hasSystemFeature) {
                b = (context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") && b);
            }
            e.c = b;
        }
        return e.c;
    }
    
    public static boolean g(final PackageManager packageManager) {
        if (e.a == null) {
            final boolean d = h.d();
            boolean b = false;
            if (d) {
                b = b;
                if (packageManager.hasSystemFeature("android.hardware.type.watch")) {
                    b = true;
                }
            }
            e.a = b;
        }
        return e.a;
    }
}
