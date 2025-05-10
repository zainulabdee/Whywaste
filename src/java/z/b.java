package z;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import d0.l;

public class b implements l
{
    private final Status e;
    private final GoogleSignInAccount f;
    
    public b(final GoogleSignInAccount f, final Status e) {
        this.f = f;
        this.e = e;
    }
    
    public Status a() {
        return this.e;
    }
    
    public GoogleSignInAccount b() {
        return this.f;
    }
}
