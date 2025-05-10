package y;

import android.os.Parcelable;
import android.os.Parcel;
import android.os.Bundle;
import android.app.PendingIntent;
import android.os.Parcelable$Creator;
import g0.a;

public class b extends a
{
    public static final Parcelable$Creator<b> CREATOR;
    public final int e;
    public final PendingIntent f;
    public final int g;
    public final byte[] h;
    final int i;
    final Bundle j;
    
    static {
        CREATOR = (Parcelable$Creator)new c();
    }
    
    b(final int i, final int e, final PendingIntent f, final int g, final Bundle j, final byte[] h) {
        this.i = i;
        this.e = e;
        this.g = g;
        this.j = j;
        this.h = h;
        this.f = f;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = g0.c.a(parcel);
        g0.c.g(parcel, 1, this.e);
        g0.c.l(parcel, 2, (Parcelable)this.f, n, false);
        g0.c.g(parcel, 3, this.g);
        g0.c.d(parcel, 4, this.j, false);
        g0.c.e(parcel, 5, this.h, false);
        g0.c.g(parcel, 1000, this.i);
        g0.c.b(parcel, a);
    }
}
