package v0;

import android.os.Parcelable;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import android.content.Intent;
import android.os.Parcelable$Creator;
import d0.l;
import g0.a;

public final class b extends a implements l
{
    public static final Parcelable$Creator<b> CREATOR;
    final int e;
    private int f;
    private Intent g;
    
    static {
        CREATOR = (Parcelable$Creator)new c();
    }
    
    public b() {
        this(2, 0, null);
    }
    
    b(final int e, final int f, final Intent g) {
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public final Status a() {
        if (this.f == 0) {
            return Status.k;
        }
        return Status.o;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = g0.c.a(parcel);
        g0.c.g(parcel, 1, this.e);
        g0.c.g(parcel, 2, this.f);
        g0.c.l(parcel, 3, (Parcelable)this.g, n, false);
        g0.c.b(parcel, a);
    }
}
