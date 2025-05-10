package a0;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.IInterface;
import o0.h;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import android.os.IBinder;
import o0.a;

public final class t extends a
{
    t(final IBinder binder) {
        super(binder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }
    
    public final void Z0(final s s, final GoogleSignInOptions googleSignInOptions) {
        final Parcel j = this.j();
        h.d(j, (IInterface)s);
        h.c(j, (Parcelable)googleSignInOptions);
        this.m(102, j);
    }
    
    public final void a1(final s s, final GoogleSignInOptions googleSignInOptions) {
        final Parcel j = this.j();
        h.d(j, (IInterface)s);
        h.c(j, (Parcelable)googleSignInOptions);
        this.m(101, j);
    }
    
    public final void n(final s s, final GoogleSignInOptions googleSignInOptions) {
        final Parcel j = this.j();
        h.d(j, (IInterface)s);
        h.c(j, (Parcelable)googleSignInOptions);
        this.m(103, j);
    }
}
