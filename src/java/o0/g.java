package o0;

import android.util.Base64;
import java.security.SecureRandom;

public final class g
{
    private static final SecureRandom a;
    
    static {
        a = new SecureRandom();
    }
    
    public static String a() {
        final byte[] array = new byte[16];
        g.a.nextBytes(array);
        return Base64.encodeToString(array, 11);
    }
}
