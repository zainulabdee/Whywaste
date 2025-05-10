package v0;

import android.os.Parcelable;
import g0.c;
import android.os.Parcel;
import com.google.android.gms.common.internal.g;
import c0.b;
import android.os.Parcelable$Creator;
import g0.a;

public final class j extends a
{
    public static final Parcelable$Creator<j> CREATOR;
    final int e;
    private final b f;
    private final g g;
    
    static {
        CREATOR = (Parcelable$Creator)new k();
    }
    
    j(final int e, final b f, final g g) {
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public final b e() {
        return this.f;
    }
    
    public final g f() {
        return this.g;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.l(parcel, 2, (Parcelable)this.f, n, false);
        c.l(parcel, 3, (Parcelable)this.g, n, false);
        c.b(parcel, a);
    }
}
