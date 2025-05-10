package d0;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

final class r<R extends l> extends BasePendingResult<R>
{
    public r(final f f) {
        super(f);
    }
    
    protected final R d(final Status status) {
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
