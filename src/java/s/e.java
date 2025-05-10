package s;

import android.content.Intent;
import com.google.android.gms.auth.UserRecoverableAuthException;

public class e extends UserRecoverableAuthException
{
    private final int f;
    
    e(final int f, final String s, final Intent intent) {
        super(s, intent);
        this.f = f;
    }
}
