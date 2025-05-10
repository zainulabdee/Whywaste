package e0;

import d0.b;
import w0.h;
import com.google.android.gms.common.api.Status;

public class o
{
    public static <ResultT> boolean a(final Status status, final ResultT resultT, final h<ResultT> h) {
        if (status.i()) {
            return h.e((Object)resultT);
        }
        return h.d((Exception)new b(status));
    }
}
