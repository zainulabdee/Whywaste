package v0;

import g0.c;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import java.util.List;
import android.os.Parcelable$Creator;
import d0.l;
import g0.a;

public final class f extends a implements l
{
    public static final Parcelable$Creator<f> CREATOR;
    private final List<String> e;
    private final String f;
    
    static {
        CREATOR = (Parcelable$Creator)new g();
    }
    
    public f(final List<String> e, final String f) {
        this.e = e;
        this.f = f;
    }
    
    public final Status a() {
        if (this.f != null) {
            return Status.k;
        }
        return Status.o;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.n(parcel, 1, (List)this.e, false);
        c.m(parcel, 2, this.f, false);
        c.b(parcel, a);
    }
}
