package v;

import android.os.Parcelable;
import java.util.List;
import android.os.Parcel;
import java.util.Map;
import java.util.HashSet;
import k0.a$a;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.auth.k;

public final class b extends k
{
    public static final Parcelable$Creator<b> CREATOR;
    private static final HashMap j;
    final Set e;
    final int f;
    private ArrayList g;
    private int h;
    private d i;
    
    static {
        CREATOR = (Parcelable$Creator)new c();
        final HashMap i = new HashMap();
        (j = i).put((Object)"authenticatorData", (Object)a$a.g("authenticatorData", 2, (Class)f.class));
        i.put((Object)"progress", (Object)a$a.f("progress", 4, (Class)d.class));
    }
    
    public b() {
        this.e = (Set)new HashSet(1);
        this.f = 1;
    }
    
    b(final Set e, final int f, final ArrayList g, final int h, final d i) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
    }
    
    protected final Object b(final a$a a$a) {
        final int k = a$a.k();
        if (k == 1) {
            return this.f;
        }
        if (k == 2) {
            return this.g;
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
        final int a = g0.c.a(parcel);
        final Set e = this.e;
        if (e.contains((Object)1)) {
            g0.c.g(parcel, 1, this.f);
        }
        if (e.contains((Object)2)) {
            g0.c.p(parcel, 2, (List)this.g, true);
        }
        if (e.contains((Object)3)) {
            g0.c.g(parcel, 3, this.h);
        }
        if (e.contains((Object)4)) {
            g0.c.l(parcel, 4, (Parcelable)this.i, n, true);
        }
        g0.c.b(parcel, a);
    }
}
