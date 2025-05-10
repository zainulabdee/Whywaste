package s;

import g0.c;
import android.os.Parcel;
import f0.g;
import f0.i;
import android.os.Parcelable$Creator;

public class a extends g0.a
{
    public static final Parcelable$Creator<a> CREATOR;
    final int e;
    final long f;
    final String g;
    final int h;
    final int i;
    final String j;
    
    static {
        CREATOR = (Parcelable$Creator)new f();
    }
    
    a(final int e, final long f, final String s, final int h, final int i, final String j) {
        this.e = e;
        this.f = f;
        this.g = (String)f0.i.i((Object)s);
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    public boolean equals(final Object o) {
        if (!(o instanceof a)) {
            return false;
        }
        if (o == this) {
            return true;
        }
        final a a = (a)o;
        return this.e == a.e && this.f == a.f && f0.g.b((Object)this.g, (Object)a.g) && this.h == a.h && this.i == a.i && f0.g.b((Object)this.j, (Object)a.j);
    }
    
    public int hashCode() {
        return f0.g.c(new Object[] { this.e, this.f, this.g, this.h, this.i, this.j });
    }
    
    public String toString() {
        final int h = this.h;
        String s;
        if (h != 1) {
            if (h != 2) {
                if (h != 3) {
                    if (h != 4) {
                        s = "UNKNOWN";
                    }
                    else {
                        s = "RENAMED_TO";
                    }
                }
                else {
                    s = "RENAMED_FROM";
                }
            }
            else {
                s = "REMOVED";
            }
        }
        else {
            s = "ADDED";
        }
        final String g = this.g;
        final String j = this.j;
        final int i = this.i;
        final StringBuilder sb = new StringBuilder();
        sb.append("AccountChangeEvent {accountName = ");
        sb.append(g);
        sb.append(", changeType = ");
        sb.append(s);
        sb.append(", changeData = ");
        sb.append(j);
        sb.append(", eventIndex = ");
        sb.append(i);
        sb.append("}");
        return sb.toString();
    }
    
    public void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.i(parcel, 2, this.f);
        c.m(parcel, 3, this.g, false);
        c.g(parcel, 4, this.h);
        c.g(parcel, 5, this.i);
        c.m(parcel, 6, this.j, false);
        c.b(parcel, a);
    }
}
