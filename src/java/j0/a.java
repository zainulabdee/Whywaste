package j0;

import java.util.Iterator;
import java.util.List;
import g0.c;
import android.os.Parcel;
import java.util.ArrayList;
import android.util.SparseArray;
import java.util.HashMap;
import android.os.Parcelable$Creator;
import k0.a$b;

public final class a extends g0.a implements a$b<String, Integer>
{
    public static final Parcelable$Creator<a> CREATOR;
    final int e;
    private final HashMap<String, Integer> f;
    private final SparseArray<String> g;
    
    static {
        CREATOR = (Parcelable$Creator)new e();
    }
    
    public a() {
        this.e = 1;
        this.f = (HashMap<String, Integer>)new HashMap();
        this.g = (SparseArray<String>)new SparseArray();
    }
    
    a(int i, final ArrayList<d> list) {
        this.e = i;
        this.f = (HashMap<String, Integer>)new HashMap();
        this.g = (SparseArray<String>)new SparseArray();
        int size;
        d d;
        for (size = ((List)list).size(), i = 0; i < size; ++i) {
            d = (d)((List)list).get(i);
            this.e(d.f, d.g);
        }
    }
    
    public a e(final String s, final int n) {
        this.f.put((Object)s, (Object)n);
        this.g.put(n, (Object)s);
        return this;
    }
    
    public final void writeToParcel(final Parcel parcel, int a) {
        a = c.a(parcel);
        c.g(parcel, 1, this.e);
        final ArrayList list = new ArrayList();
        for (final String s : this.f.keySet()) {
            list.add((Object)new d(s, (int)this.f.get((Object)s)));
        }
        c.p(parcel, 2, (List)list, false);
        c.b(parcel, a);
    }
}
