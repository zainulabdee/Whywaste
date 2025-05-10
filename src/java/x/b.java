package x;

import android.os.Parcelable;
import g0.c;
import android.os.Parcel;
import f0.i;
import android.app.PendingIntent;
import android.os.Parcelable$Creator;
import g0.a;

public final class b extends a
{
    public static final Parcelable$Creator<b> CREATOR;
    private final PendingIntent e;
    
    static {
        CREATOR = (Parcelable$Creator)new f();
    }
    
    public b(final PendingIntent pendingIntent) {
        this.e = (PendingIntent)i.i((Object)pendingIntent);
    }
    
    public PendingIntent e() {
        return this.e;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.l(parcel, 1, (Parcelable)this.e(), n, false);
        c.b(parcel, a);
    }
}
