package f0;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import g0.a;

public class c extends a
{
    public static final Parcelable$Creator<c> CREATOR;
    private final k e;
    private final boolean f;
    private final boolean g;
    private final int[] h;
    private final int i;
    private final int[] j;
    
    static {
        CREATOR = (Parcelable$Creator)new m0();
    }
    
    public c(final k e, final boolean f, final boolean g, final int[] h, final int i, final int[] j) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    public int e() {
        return this.i;
    }
    
    public int[] f() {
        return this.h;
    }
    
    public int[] g() {
        return this.j;
    }
    
    public boolean h() {
        return this.f;
    }
    
    public boolean i() {
        return this.g;
    }
    
    public final k j() {
        return this.e;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = g0.c.a(parcel);
        g0.c.l(parcel, 1, (Parcelable)this.e, n, false);
        g0.c.c(parcel, 2, this.h());
        g0.c.c(parcel, 3, this.i());
        g0.c.h(parcel, 4, this.f(), false);
        g0.c.g(parcel, 5, this.e());
        g0.c.h(parcel, 6, this.g(), false);
        g0.c.b(parcel, a);
    }
}
