package k0;

import f0.i;
import java.util.Iterator;
import f0.g;
import android.os.Parcelable;

public abstract class b extends a implements Parcelable
{
    public Object c(final String s) {
        return null;
    }
    
    public final int describeContents() {
        return 0;
    }
    
    public boolean e(final String s) {
        return false;
    }
    
    public boolean equals(final Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!this.getClass().isInstance(obj)) {
            return false;
        }
        final a a = (a)obj;
        for (final a.a a2 : this.a().values()) {
            if (this.d(a2)) {
                if (!a.d(a2) || !g.b(this.b(a2), a.b(a2))) {
                    return false;
                }
                continue;
            }
            else {
                if (a.d(a2)) {
                    return false;
                }
                continue;
            }
        }
        return true;
    }
    
    public int hashCode() {
        final Iterator iterator = this.a().values().iterator();
        int n = 0;
        while (iterator.hasNext()) {
            final a.a a = (a.a)iterator.next();
            if (this.d(a)) {
                n = n * 31 + i.i(this.b(a)).hashCode();
            }
        }
        return n;
    }
}
