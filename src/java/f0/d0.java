package f0;

import android.os.Parcelable;
import g0.c;
import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import android.accounts.Account;
import android.os.Parcelable$Creator;
import g0.a;

public final class d0 extends a
{
    public static final Parcelable$Creator<d0> CREATOR;
    final int e;
    private final Account f;
    private final int g;
    private final GoogleSignInAccount h;
    
    static {
        CREATOR = (Parcelable$Creator)new e0();
    }
    
    d0(final int e, final Account f, final int g, final GoogleSignInAccount h) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public d0(final Account account, final int n, final GoogleSignInAccount googleSignInAccount) {
        this(2, account, n, googleSignInAccount);
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.l(parcel, 2, (Parcelable)this.f, n, false);
        c.g(parcel, 3, this.g);
        c.l(parcel, 4, (Parcelable)this.h, n, false);
        c.b(parcel, a);
    }
}
