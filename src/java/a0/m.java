package a0;

import com.google.android.gms.common.api.internal.BasePendingResult;
import d0.l;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.auth.api.signin.internal.zba;

final class m extends zba
{
    final n f;
    
    m(final n f) {
        this.f = f;
    }
    
    public final void R0(final Status status) {
        ((BasePendingResult)this.f).g((l)status);
    }
}
