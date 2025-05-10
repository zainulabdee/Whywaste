package v;

import android.os.Parcelable;
import g0.c;
import android.os.Parcel;
import java.util.Map;
import f.b;
import k0.a$a;
import android.app.PendingIntent;
import java.util.Set;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.auth.k;

public final class h extends k
{
    public static final Parcelable$Creator<h> CREATOR;
    private static final HashMap l;
    final Set e;
    final int f;
    private String g;
    private int h;
    private byte[] i;
    private PendingIntent j;
    private a k;
    
    static {
        CREATOR = (Parcelable$Creator)new i();
        final HashMap i = new HashMap();
        (l = i).put((Object)"accountType", (Object)a$a.i("accountType", 2));
        i.put((Object)"status", (Object)a$a.h("status", 3));
        i.put((Object)"transferBytes", (Object)a$a.e("transferBytes", 4));
    }
    
    public h() {
        this.e = (Set)new b(3);
        this.f = 1;
    }
    
    h(final Set e, final int f, final String g, final int h, final byte[] i, final PendingIntent j, final a k) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
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
            c.m(parcel, 2, this.g, true);
        }
        if (e.contains((Object)3)) {
            c.g(parcel, 3, this.h);
        }
        if (e.contains((Object)4)) {
            c.e(parcel, 4, this.i, true);
        }
        if (e.contains((Object)5)) {
            c.l(parcel, 5, (Parcelable)this.j, n, true);
        }
        if (e.contains((Object)6)) {
            c.l(parcel, 6, (Parcelable)this.k, n, true);
        }
        c.b(parcel, a);
    }
}
