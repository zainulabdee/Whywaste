package k0;

import java.util.List;
import g0.c;
import android.os.Parcel;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import android.os.Parcelable$Creator;
import g0.a;

public final class f extends a
{
    public static final Parcelable$Creator<f> CREATOR;
    final int e;
    final String f;
    final ArrayList<g> g;
    
    static {
        CREATOR = (Parcelable$Creator)new j();
    }
    
    f(final int e, final String f, final ArrayList<g> g) {
        this.e = e;
        this.f = f;
        this.g = g;
    }
    
    f(String f, final Map<String, k0.a.a<?, ?>> map) {
        this.e = 1;
        this.f = f;
        ArrayList g;
        if (map == null) {
            g = null;
        }
        else {
            final ArrayList list = new ArrayList();
            final Iterator iterator = map.keySet().iterator();
            while (true) {
                g = list;
                if (!iterator.hasNext()) {
                    break;
                }
                f = (String)iterator.next();
                list.add((Object)new g(f, (k0.a.a<?, ?>)map.get((Object)f)));
            }
        }
        this.g = (ArrayList<g>)g;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        c.m(parcel, 2, this.f, false);
        c.p(parcel, 3, (List)this.g, false);
        c.b(parcel, a);
    }
}
