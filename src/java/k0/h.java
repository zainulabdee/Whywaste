package k0;

import java.util.List;
import g0.c;
import android.os.Parcel;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import g0.a;

public final class h extends a
{
    public static final Parcelable$Creator<h> CREATOR;
    final int e;
    private final HashMap<String, Map<String, k0.a.a<?, ?>>> f;
    private final String g;
    
    static {
        CREATOR = (Parcelable$Creator)new i();
    }
    
    h(int i, final ArrayList<f> list, final String s) {
        this.e = i;
        final HashMap f = new HashMap();
        int size;
        f f2;
        String f3;
        HashMap hashMap;
        int size2;
        int j;
        g g;
        for (size = list.size(), i = 0; i < size; ++i) {
            f2 = (f)list.get(i);
            f3 = f2.f;
            hashMap = new HashMap();
            for (size2 = ((ArrayList)f0.i.i((Object)f2.g)).size(), j = 0; j < size2; ++j) {
                g = (g)f2.g.get(j);
                hashMap.put((Object)g.f, (Object)g.g);
            }
            f.put((Object)f3, (Object)hashMap);
        }
        this.f = (HashMap<String, Map<String, k0.a.a<?, ?>>>)f;
        this.g = (String)f0.i.i((Object)s);
        this.g();
    }
    
    public final String e() {
        return this.g;
    }
    
    public final Map<String, k0.a.a<?, ?>> f(final String s) {
        return (Map<String, k0.a.a<?, ?>>)this.f.get((Object)s);
    }
    
    public final void g() {
        final Iterator iterator = this.f.keySet().iterator();
        while (iterator.hasNext()) {
            final Map map = (Map)this.f.get((Object)iterator.next());
            final Iterator iterator2 = map.keySet().iterator();
            while (iterator2.hasNext()) {
                ((k0.a.a)map.get((Object)iterator2.next())).q(this);
            }
        }
    }
    
    public final String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final String s : this.f.keySet()) {
            sb.append(s);
            sb.append(":\n");
            final Map map = (Map)this.f.get((Object)s);
            for (final String s2 : map.keySet()) {
                sb.append("  ");
                sb.append(s2);
                sb.append(": ");
                sb.append(map.get((Object)s2));
            }
        }
        return sb.toString();
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        final ArrayList list = new ArrayList();
        for (final String s : this.f.keySet()) {
            list.add((Object)new f(s, (Map<String, k0.a.a<?, ?>>)this.f.get((Object)s)));
        }
        c.p(parcel, 2, (List)list, false);
        c.m(parcel, 3, this.g, false);
        c.b(parcel, a);
    }
}
