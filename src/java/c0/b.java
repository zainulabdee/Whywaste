package c0;

import android.os.Parcelable;
import g0.c;
import android.os.Parcel;
import f0.g$a;
import f0.g;
import android.app.PendingIntent;
import android.os.Parcelable$Creator;
import g0.a;

public final class b extends a
{
    public static final Parcelable$Creator<b> CREATOR;
    public static final b i;
    final int e;
    private final int f;
    private final PendingIntent g;
    private final String h;
    
    static {
        i = new b(0);
        CREATOR = (Parcelable$Creator)new r();
    }
    
    public b(final int n) {
        this(n, null, null);
    }
    
    b(final int e, final int f, final PendingIntent g, final String h) {
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
    }
    
    public b(final int n, final PendingIntent pendingIntent) {
        this(n, pendingIntent, null);
    }
    
    public b(final int n, final PendingIntent pendingIntent, final String s) {
        this(1, n, pendingIntent, s);
    }
    
    static String j(final int n) {
        if (n == 99) {
            return "UNFINISHED";
        }
        if (n == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (n) {
            default: {
                switch (n) {
                    default: {
                        final StringBuilder sb = new StringBuilder();
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(n);
                        sb.append(")");
                        return sb.toString();
                    }
                    case 24: {
                        return "API_DISABLED_FOR_CONNECTION";
                    }
                    case 23: {
                        return "API_DISABLED";
                    }
                    case 22: {
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    }
                    case 21: {
                        return "API_VERSION_UPDATE_REQUIRED";
                    }
                    case 20: {
                        return "RESTRICTED_PROFILE";
                    }
                    case 19: {
                        return "SERVICE_MISSING_PERMISSION";
                    }
                    case 18: {
                        return "SERVICE_UPDATING";
                    }
                    case 17: {
                        return "SIGN_IN_FAILED";
                    }
                    case 16: {
                        return "API_UNAVAILABLE";
                    }
                    case 15: {
                        return "INTERRUPTED";
                    }
                    case 14: {
                        return "TIMEOUT";
                    }
                    case 13: {
                        return "CANCELED";
                    }
                }
                break;
            }
            case 11: {
                return "LICENSE_CHECK_FAILED";
            }
            case 10: {
                return "DEVELOPER_ERROR";
            }
            case 9: {
                return "SERVICE_INVALID";
            }
            case 8: {
                return "INTERNAL_ERROR";
            }
            case 7: {
                return "NETWORK_ERROR";
            }
            case 6: {
                return "RESOLUTION_REQUIRED";
            }
            case 5: {
                return "INVALID_ACCOUNT";
            }
            case 4: {
                return "SIGN_IN_REQUIRED";
            }
            case 3: {
                return "SERVICE_DISABLED";
            }
            case 2: {
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            }
            case 1: {
                return "SERVICE_MISSING";
            }
            case 0: {
                return "SUCCESS";
            }
            case -1: {
                return "UNKNOWN";
            }
        }
    }
    
    public int e() {
        return this.f;
    }
    
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof b)) {
            return false;
        }
        final b b = (b)o;
        return this.f == b.f && f0.g.b((Object)this.g, (Object)b.g) && f0.g.b((Object)this.h, (Object)b.h);
    }
    
    public String f() {
        return this.h;
    }
    
    public PendingIntent g() {
        return this.g;
    }
    
    public boolean h() {
        return this.f != 0 && this.g != null;
    }
    
    public int hashCode() {
        return f0.g.c(new Object[] { this.f, this.g, this.h });
    }
    
    public boolean i() {
        return this.f == 0;
    }
    
    public String toString() {
        final g$a d = f0.g.d((Object)this);
        d.a("statusCode", (Object)j(this.f));
        d.a("resolution", (Object)this.g);
        d.a("message", (Object)this.h);
        return d.toString();
    }
    
    public void writeToParcel(final Parcel parcel, final int n) {
        final int a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.g(parcel, 2, this.e());
        c.l(parcel, 3, (Parcelable)this.g(), n, false);
        c.m(parcel, 4, this.f(), false);
        c.b(parcel, a);
    }
}
