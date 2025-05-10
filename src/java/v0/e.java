package v0;

import android.os.Parcel;
import android.os.IInterface;
import android.os.Parcelable;
import q0.b;
import android.os.IBinder;
import q0.a;

public final class e extends a
{
    e(final IBinder binder) {
        super(binder, "com.google.android.gms.signin.internal.ISignInService");
    }
    
    public final void Z0(final h h, final d d) {
        final Parcel j = this.j();
        b.b(j, (Parcelable)h);
        b.c(j, (IInterface)d);
        this.m(12, j);
    }
}
