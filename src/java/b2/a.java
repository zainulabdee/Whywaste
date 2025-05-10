package b2;

import c.e;
import android.os.Build$VERSION;
import android.os.Handler;
import android.os.Looper;

public final class a
{
    public static Handler a(final Looper looper) {
        if (Build$VERSION.SDK_INT >= 28) {
            return e.a(looper);
        }
        return new Handler(looper);
    }
}
