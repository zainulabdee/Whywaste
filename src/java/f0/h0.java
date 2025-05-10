package f0;

import android.os.BaseBundle;
import android.os.Bundle;
import n0.c;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import n0.d;
import android.content.Context;

public final class h0
{
    private static final Object a;
    private static boolean b;
    private static String c;
    private static int d;
    
    static {
        a = new Object();
    }
    
    public static int a(final Context context) {
        b(context);
        return h0.d;
    }
    
    private static void b(final Context context) {
        final Object a = h0.a;
        synchronized (a) {
            if (h0.b) {
                return;
            }
            h0.b = true;
            final String packageName = context.getPackageName();
            final c a2 = n0.d.a(context);
            try {
                final Bundle metaData = a2.a(packageName, 128).metaData;
                if (metaData == null) {
                    return;
                }
                h0.c = ((BaseBundle)metaData).getString("com.google.app.id");
                h0.d = ((BaseBundle)metaData).getInt("com.google.android.gms.version");
            }
            catch (final PackageManager$NameNotFoundException ex) {
                Log.wtf("MetadataValueReader", "This should never happen.", (Throwable)ex);
            }
        }
    }
}
