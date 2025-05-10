package v;

import g0.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class a extends g0.a
{
    public static final Parcelable$Creator<a> CREATOR;
    final int e;
    private boolean f;
    private long g;
    private final boolean h;
    
    static {
        CREATOR = (Parcelable$Creator)new j();
    }
    
    a(final int e, final boolean f, final long g, final boolean h) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public long e() {
        return this.g;
    }
    
    public boolean f() {
        return this.h;
    }
    
    public boolean g() {
        return this.f;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.c(parcel, 2, this.g());
        c.i(parcel, 3, this.e());
        c.c(parcel, 4, this.f());
        c.b(parcel, a);
    }
}
