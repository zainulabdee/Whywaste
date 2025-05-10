package x;

import android.os.Parcelable;
import g0.c;
import android.os.Parcel;
import f0.g;
import f0.i;
import android.app.PendingIntent;
import android.os.Parcelable$Creator;
import g0.a;

public class d extends a
{
    public static final Parcelable$Creator<d> CREATOR;
    private final PendingIntent e;
    
    static {
        CREATOR = (Parcelable$Creator)new h();
    }
    
    public d(final PendingIntent pendingIntent) {
        this.e = (PendingIntent)i.i((Object)pendingIntent);
    }
    
    public PendingIntent e() {
        return this.e;
    }
    
    public boolean equals(final Object o) {
        return o instanceof d && g.b((Object)this.e, (Object)((d)o).e);
    }
    
    public int hashCode() {
        return g.c(new Object[] { this.e });
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.l(parcel, 1, (Parcelable)this.e(), n, false);
        c.b(parcel, a);
    }
}
