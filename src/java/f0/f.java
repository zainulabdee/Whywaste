package f0;

import g0.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import g0.a;

public class f extends a
{
    public static final Parcelable$Creator<f> CREATOR;
    private final int e;
    private final int f;
    private final int g;
    private final long h;
    private final long i;
    private final String j;
    private final String k;
    private final int l;
    private final int m;
    
    static {
        CREATOR = (Parcelable$Creator)new y();
    }
    
    public f(final int e, final int f, final int g, final long h, final long i, final String j, final String k, final int l, final int m) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.g(parcel, 2, this.f);
        c.g(parcel, 3, this.g);
        c.i(parcel, 4, this.h);
        c.i(parcel, 5, this.i);
        c.m(parcel, 6, this.j, false);
        c.m(parcel, 7, this.k, false);
        c.g(parcel, 8, this.l);
        c.g(parcel, 9, this.m);
        c.b(parcel, a);
    }
}
