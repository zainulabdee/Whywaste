package f0;

import g0.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import g0.a;

@Deprecated
public final class k0 extends a
{
    public static final Parcelable$Creator<k0> CREATOR;
    final int e;
    
    static {
        CREATOR = (Parcelable$Creator)new l0();
    }
    
    k0(final int e) {
        this.e = e;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.b(parcel, a);
    }
}
