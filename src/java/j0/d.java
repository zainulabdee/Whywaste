package j0;

import g0.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import g0.a;

public final class d extends a
{
    public static final Parcelable$Creator<d> CREATOR;
    final int e;
    final String f;
    final int g;
    
    static {
        CREATOR = (Parcelable$Creator)new f();
    }
    
    d(final int e, final String f, final int g) {
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    d(final String f, final int g) {
        this.e = 1;
        this.f = f;
        this.g = g;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.m(parcel, 2, this.f, false);
        c.g(parcel, 3, this.g);
        c.b(parcel, a);
    }
}
