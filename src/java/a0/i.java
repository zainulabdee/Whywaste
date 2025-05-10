package a0;

import com.google.android.gms.common.api.internal.BasePendingResult;
import d0.l;
import z.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zba;

final class i extends zba
{
    final j f;
    
    i(final j f) {
        this.f = f;
    }
    
    public final void U0(final GoogleSignInAccount googleSignInAccount, final Status status) {
        if (googleSignInAccount != null) {
            q.c(this.f.r).e(this.f.s, googleSignInAccount);
        }
        ((BasePendingResult)this.f).g((l)new b(googleSignInAccount, status));
    }
}
