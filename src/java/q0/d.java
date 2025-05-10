package q0;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.os.Build$VERSION;

public final class d
{
    public static final int a;
    
    static {
        final int sdk_INT = Build$VERSION.SDK_INT;
        int a2 = 33554432;
        Label_0059: {
            if (sdk_INT < 31) {
                if (sdk_INT >= 30) {
                    final String codename = Build$VERSION.CODENAME;
                    if (codename.length() == 1 && codename.charAt(0) >= 'S' && codename.charAt(0) <= 'Z') {
                        break Label_0059;
                    }
                }
                a2 = 0;
            }
        }
        a = a2;
    }
    
    public static PendingIntent a(final Context context, final int n, final Intent intent, final int n2) {
        return PendingIntent.getActivity(context, n, intent, n2);
    }
}
