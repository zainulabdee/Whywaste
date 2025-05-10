package s;

import g0.c;
import android.os.Parcel;
import f0.i;
import java.util.List;
import android.os.Parcelable$Creator;
import g0.a;

public class b extends a
{
    public static final Parcelable$Creator<b> CREATOR;
    final int e;
    final List f;
    
    static {
        CREATOR = (Parcelable$Creator)new g();
    }
    
    b(final int e, final List list) {
        this.e = e;
        this.f = (List)i.i((Object)list);
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.p(parcel, 2, this.f, false);
        c.b(parcel, a);
    }
}
