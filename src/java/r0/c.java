package r0;

import android.os.Build$VERSION;

public final class c
{
    public static final int a;
    
    static {
        int a2;
        if (Build$VERSION.SDK_INT >= 23) {
            a2 = 67108864;
        }
        else {
            a2 = 0;
        }
        a = a2;
    }
}
