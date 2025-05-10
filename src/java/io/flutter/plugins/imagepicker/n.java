package io.flutter.plugins.imagepicker;

import android.os.Build$VERSION;
import android.content.pm.PackageManager$NameNotFoundException;
import java.util.Arrays;
import android.content.Context;

final class n
{
    private static boolean a(final Context context, final String s) {
        try {
            return Arrays.asList((Object[])context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions).contains((Object)s);
        }
        catch (final PackageManager$NameNotFoundException ex) {
            ((Throwable)ex).printStackTrace();
            return false;
        }
    }
    
    static boolean b(final Context context) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        boolean b = true;
        if (sdk_INT < 23 || !a(context, "android.permission.CAMERA")) {
            b = false;
        }
        return b;
    }
}
