package m0;

import android.os.Looper;

public final class k
{
    public static boolean a() {
        return Looper.getMainLooper() == Looper.myLooper();
    }
}
