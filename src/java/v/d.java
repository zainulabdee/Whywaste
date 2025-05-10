package v;

import g0.c;
import android.os.Parcel;
import java.util.Map;
import k0.a$a;
import java.util.List;
import f.a;
import android.os.Parcelable$Creator;
import com.google.android.gms.internal.auth.k;

public final class d extends k
{
    public static final Parcelable$Creator<d> CREATOR;
    private static final a k;
    final int e;
    private List f;
    private List g;
    private List h;
    private List i;
    private List j;
    
    static {
        CREATOR = (Parcelable$Creator)new e();
        final a i = new a();
        ((f.e)(k = i)).put((Object)"registered", (Object)a$a.j("registered", 2));
        ((f.e)i).put((Object)"in_progress", (Object)a$a.j("in_progress", 3));
        ((f.e)i).put((Object)"success", (Object)a$a.j("success", 4));
        ((f.e)i).put((Object)"failed", (Object)a$a.j("failed", 5));
        ((f.e)i).put((Object)"escrowed", (Object)a$a.j("escrowed", 6));
    }
    
    public d() {
        this.e = 1;
    }
    
    d(final int e, final List f, final List g, final List h, final List i, final List j) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
    }
    
    public final Map a() {
        return (Map)d.k;
    }
    
    protected final Object b(final a$a a$a) {
        switch (a$a.k()) {
            default: {
                final int k = a$a.k();
                final StringBuilder sb = new StringBuilder();
                sb.append("Unknown SafeParcelable id=");
                sb.append(k);
                throw new IllegalStateException(sb.toString());
            }
            case 6: {
                return this.j;
            }
            case 5: {
                return this.i;
            }
            case 4: {
                return this.h;
            }
            case 3: {
                return this.g;
            }
            case 2: {
                return this.f;
            }
            case 1: {
                return this.e;
            }
        }
    }
    
    protected final boolean d(final a$a a$a) {
        return true;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.n(parcel, 2, this.f, false);
        c.n(parcel, 3, this.g, false);
        c.n(parcel, 4, this.h, false);
        c.n(parcel, 5, this.i, false);
        c.n(parcel, 6, this.j, false);
        c.b(parcel, a);
    }
}
