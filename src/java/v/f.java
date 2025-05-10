package v;

import android.os.Parcelable;
import g0.c;
import android.os.Parcel;
import java.util.Map;
import java.util.HashSet;
import k0.a$a;
import java.util.Set;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.auth.k;

public final class f extends k
{
    public static final Parcelable$Creator<f> CREATOR;
    private static final HashMap k;
    final Set e;
    final int f;
    private h g;
    private String h;
    private String i;
    private String j;
    
    static {
        CREATOR = (Parcelable$Creator)new g();
        final HashMap i = new HashMap();
        (k = i).put((Object)"authenticatorInfo", (Object)a$a.f("authenticatorInfo", 2, (Class)h.class));
        i.put((Object)"signature", (Object)a$a.i("signature", 3));
        i.put((Object)"package", (Object)a$a.i("package", 4));
    }
    
    public f() {
        this.e = (Set)new HashSet(3);
        this.f = 1;
    }
    
    f(final Set e, final int f, final h g, final String h, final String i, final String j) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    protected final Object b(final a$a a$a) {
        final int k = a$a.k();
        if (k == 1) {
            return this.f;
        }
        if (k == 2) {
            return this.g;
        }
        if (k == 3) {
            return this.h;
        }
        if (k == 4) {
            return this.i;
        }
        final int i = a$a.k();
        final StringBuilder sb = new StringBuilder();
        sb.append("Unknown SafeParcelable id=");
        sb.append(i);
        throw new IllegalStateException(sb.toString());
    }
    
    protected final boolean d(final a$a a$a) {
        return this.e.contains((Object)a$a.k());
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        final Set e = this.e;
        if (e.contains((Object)1)) {
            c.g(parcel, 1, this.f);
        }
        if (e.contains((Object)2)) {
            c.l(parcel, 2, (Parcelable)this.g, n, true);
        }
        if (e.contains((Object)3)) {
            c.m(parcel, 3, this.h, true);
        }
        if (e.contains((Object)4)) {
            c.m(parcel, 4, this.i, true);
        }
        if (e.contains((Object)5)) {
            c.m(parcel, 5, this.j, true);
        }
        c.b(parcel, a);
    }
}
