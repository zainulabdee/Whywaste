package c0;

import g0.c;
import android.os.Parcel;
import f0.g$a;
import f0.g;
import android.os.Parcelable$Creator;
import g0.a;

public class d extends a
{
    public static final Parcelable$Creator<d> CREATOR;
    private final String e;
    @Deprecated
    private final int f;
    private final long g;
    
    static {
        CREATOR = (Parcelable$Creator)new s();
    }
    
    public d(final String e, final int f, final long g) {
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    public d(final String e, final long g) {
        this.e = e;
        this.g = g;
        this.f = -1;
    }
    
    public String e() {
        return this.e;
    }
    
    public final boolean equals(final Object o) {
        if (o instanceof d) {
            final d d = (d)o;
            if (((this.e() != null && this.e().equals((Object)d.e())) || (this.e() == null && d.e() == null)) && this.f() == d.f()) {
                return true;
            }
        }
        return false;
    }
    
    public long f() {
        long g;
        if ((g = this.g) == -1L) {
            g = this.f;
        }
        return g;
    }
    
    public final int hashCode() {
        return f0.g.c(new Object[] { this.e(), this.f() });
    }
    
    public final String toString() {
        final g$a d = f0.g.d((Object)this);
        d.a("name", (Object)this.e());
        d.a("version", (Object)this.f());
        return d.toString();
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.m(parcel, 1, this.e(), false);
        c.g(parcel, 2, this.f);
        c.i(parcel, 3, this.f());
        c.b(parcel, a);
    }
}
