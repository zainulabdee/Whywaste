package n0;

import m0.h;
import android.content.Context;

public class b
{
    private static Context a;
    private static Boolean b;
    
    public static boolean a(final Context context) {
        synchronized (b.class) {
            final Context applicationContext = context.getApplicationContext();
            final Context a = n0.b.a;
            if (a != null) {
                final Boolean b = n0.b.b;
                if (b != null) {
                    if (a == applicationContext) {
                        return b;
                    }
                }
            }
            n0.b.b = null;
            if (h.g()) {
                n0.b.b = n0.a.a(applicationContext.getPackageManager());
            }
            else {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    n0.b.b = Boolean.TRUE;
                }
                catch (final ClassNotFoundException ex) {
                    n0.b.b = Boolean.FALSE;
                }
            }
            n0.b.a = applicationContext;
            return n0.b.b;
        }
    }
}
