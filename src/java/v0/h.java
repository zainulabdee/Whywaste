package v0;

import android.os.Parcelable;
import g0.c;
import android.os.Parcel;
import f0.d0;
import android.os.Parcelable$Creator;
import g0.a;

public final class h extends a
{
    public static final Parcelable$Creator<h> CREATOR;
    final int e;
    final d0 f;
    
    static {
        CREATOR = (Parcelable$Creator)new i();
    }
    
    h(final int e, final d0 f) {
        this.e = e;
        this.f = f;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.l(parcel, 2, (Parcelable)this.f, n, false);
        c.b(parcel, a);
    }
}
