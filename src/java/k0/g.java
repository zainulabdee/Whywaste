package k0;

import android.os.Parcelable;
import g0.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import g0.a;

public final class g extends a
{
    public static final Parcelable$Creator<g> CREATOR;
    final int e;
    final String f;
    final k0.a.a<?, ?> g;
    
    static {
        CREATOR = (Parcelable$Creator)new e();
    }
    
    g(final int e, final String f, final k0.a.a<?, ?> g) {
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    g(final String f, final k0.a.a<?, ?> g) {
        this.e = 1;
        this.f = f;
        this.g = g;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.m(parcel, 2, this.f, false);
        c.l(parcel, 3, (Parcelable)this.g, n, false);
        c.b(parcel, a);
    }
}
