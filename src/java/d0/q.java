package d0;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class q<R extends l> extends BasePendingResult<R>
{
    private final R p;
    
    public q(final f f, final R p2) {
        super(f);
        this.p = p2;
    }
    
    protected final R d(final Status status) {
        return this.p;
    }
}
