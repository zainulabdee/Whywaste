package j0;

import android.os.Parcelable;
import android.os.Parcel;
import k0.a$b;
import android.os.Parcelable$Creator;
import g0.a;

public final class b extends a
{
    public static final Parcelable$Creator<b> CREATOR;
    final int e;
    private final j0.a f;
    
    static {
        CREATOR = (Parcelable$Creator)new c();
    }
    
    b(final int e, final j0.a f) {
        this.e = e;
        this.f = f;
    }
    
    private b(final j0.a f) {
        this.e = 1;
        this.f = f;
    }
    
    public static b e(final a$b<?, ?> a$b) {
        if (a$b instanceof j0.a) {
            return new b((j0.a)a$b);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }
    
    public final a$b<?, ?> f() {
        final j0.a f = this.f;
        if (f != null) {
            return (a$b<?, ?>)f;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = g0.c.a(parcel);
        g0.c.g(parcel, 1, this.e);
        g0.c.l(parcel, 2, (Parcelable)this.f, n, false);
        g0.c.b(parcel, a);
    }
}
