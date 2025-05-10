package m0;

import n0.d;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import c0.m;
import android.content.Context;

public final class i
{
    public static boolean a(final Context context, final int n) {
        if (!b(context, n, "com.google.android.gms")) {
            return false;
        }
        final PackageManager packageManager = context.getPackageManager();
        try {
            return m.a(context).b(packageManager.getPackageInfo("com.google.android.gms", 64));
        }
        catch (final PackageManager$NameNotFoundException ex) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }
    
    public static boolean b(final Context context, final int n, final String s) {
        return d.a(context).d(n, s);
    }
}
