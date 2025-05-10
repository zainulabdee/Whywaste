package f0;

import g0.c;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import g0.a;

public class k extends a
{
    public static final Parcelable$Creator<k> CREATOR;
    private final int e;
    private final boolean f;
    private final boolean g;
    private final int h;
    private final int i;
    
    static {
        CREATOR = (Parcelable$Creator)new j0();
    }
    
    public k(final int e, final boolean f, final boolean g, final int h, final int i) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    public int e() {
        return this.h;
    }
    
    public int f() {
        return this.i;
    }
    
    public boolean g() {
        return this.f;
    }
    
    public boolean h() {
        return this.g;
    }
    
    public int i() {
        return this.e;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.i());
        c.c(parcel, 2, this.g());
        c.c(parcel, 3, this.h());
        c.g(parcel, 4, this.e());
        c.g(parcel, 5, this.f());
        c.b(parcel, a);
    }
}
