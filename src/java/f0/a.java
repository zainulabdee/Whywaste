package f0;

import d0.k;
import d0.b;
import com.google.android.gms.common.api.Status;

public class a
{
    public static b a(final Status status) {
        if (status.h()) {
            return (b)new k(status);
        }
        return new b(status);
    }
}
