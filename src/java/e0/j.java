package e0;

import java.util.concurrent.TimeUnit;
import d0.h$a;
import d0.h;
import com.google.android.gms.common.api.internal.BasePendingResult;
import d0.g;
import d0.l;

public final class j<R extends l> extends g<R>
{
    private final BasePendingResult<R> a;
    
    public j(final h<R> h) {
        this.a = (BasePendingResult<R>)h;
    }
    
    public final void b(final h$a h$a) {
        ((h)this.a).b(h$a);
    }
    
    public final R c(final long n, final TimeUnit timeUnit) {
        return (R)this.a.c(n, timeUnit);
    }
}
