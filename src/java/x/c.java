package x;

import android.os.Parcelable;
import android.os.Parcel;
import android.app.PendingIntent;
import android.os.Parcelable$Creator;
import g0.a;

public class c extends a
{
    public static final Parcelable$Creator<c> CREATOR;
    private final PendingIntent e;
    
    static {
        CREATOR = (Parcelable$Creator)new g();
    }
    
    public c(final PendingIntent e) {
        this.e = e;
    }
    
    public PendingIntent e() {
        return this.e;
    }
    
    public boolean equals(final Object o) {
        return o instanceof c && f0.g.b((Object)this.e, (Object)((c)o).e);
    }
    
    public int hashCode() {
        return f0.g.c(new Object[] { this.e });
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = g0.c.a(parcel);
        g0.c.l(parcel, 1, (Parcelable)this.e(), n, false);
        g0.c.b(parcel, a);
    }
}
