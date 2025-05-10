package a0;

import g0.c;
import android.os.Parcel;
import android.os.Bundle;
import android.os.Parcelable$Creator;

public class a extends g0.a
{
    public static final Parcelable$Creator<a> CREATOR;
    final int e;
    private int f;
    private Bundle g;
    
    static {
        CREATOR = (Parcelable$Creator)new d();
    }
    
    a(final int e, final int f, final Bundle g) {
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public int e() {
        return this.f;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.g(parcel, 2, this.e());
        c.d(parcel, 3, this.g, false);
        c.b(parcel, a);
    }
}
