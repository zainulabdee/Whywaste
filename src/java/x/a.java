package x;

import android.os.Parcelable;
import g0.c;
import android.os.Parcel;
import f0.g;
import f0.i;
import android.app.PendingIntent;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.List;
import android.os.Parcelable$Creator;

public final class a extends g0.a
{
    public static final Parcelable$Creator<a> CREATOR;
    private final String e;
    private final String f;
    private final String g;
    private final List h;
    private final GoogleSignInAccount i;
    private final PendingIntent j;
    
    static {
        CREATOR = (Parcelable$Creator)new e();
    }
    
    public a(final String e, final String f, final String g, final List<String> list, final GoogleSignInAccount i, final PendingIntent j) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = (List)f0.i.i((Object)list);
        this.j = j;
        this.i = i;
    }
    
    public String e() {
        return this.f;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof a)) {
            return false;
        }
        final a a = (a)o;
        return f0.g.b((Object)this.e, (Object)a.e) && f0.g.b((Object)this.f, (Object)a.f) && f0.g.b((Object)this.g, (Object)a.g) && f0.g.b((Object)this.h, (Object)a.h) && f0.g.b((Object)this.j, (Object)a.j) && f0.g.b((Object)this.i, (Object)a.i);
    }
    
    public List<String> f() {
        return (List<String>)this.h;
    }
    
    public PendingIntent g() {
        return this.j;
    }
    
    public String h() {
        return this.e;
    }
    
    public int hashCode() {
        return f0.g.c(new Object[] { this.e, this.f, this.g, this.h, this.j, this.i });
    }
    
    public GoogleSignInAccount i() {
        return this.i;
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.m(parcel, 1, this.h(), false);
        c.m(parcel, 2, this.e(), false);
        c.m(parcel, 3, this.g, false);
        c.n(parcel, 4, (List)this.f(), false);
        c.l(parcel, 5, (Parcelable)this.i(), n, false);
        c.l(parcel, 6, (Parcelable)this.g(), n, false);
        c.b(parcel, a);
    }
}
