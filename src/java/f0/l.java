package f0;

import g0.c;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcelable$Creator;
import g0.a;

public class l extends a
{
    public static final Parcelable$Creator<l> CREATOR;
    private final int e;
    private List<f> f;
    
    static {
        CREATOR = (Parcelable$Creator)new p();
    }
    
    public l(final int e, final List<f> f) {
        this.e = e;
        this.f = f;
    }
    
    public final int e() {
        return this.e;
    }
    
    public final List<f> f() {
        return this.f;
    }
    
    public final void g(final f f) {
        if (this.f == null) {
            this.f = (List<f>)new ArrayList();
        }
        this.f.add((Object)f);
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.p(parcel, 2, (List)this.f, false);
        c.b(parcel, a);
    }
}
