package a0;

import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.auth.api.signin.internal.zba;

final class k extends zba
{
    final l f;
    
    k(final l f) {
        this.f = f;
    }
    
    public final void g(final Status status) {
        ((BasePendingResult)this.f).g((d0.l)status);
    }
}
