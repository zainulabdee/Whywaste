package k0;

import android.os.BaseBundle;
import android.os.Parcelable;
import java.util.ArrayList;
import m0.g;
import java.util.Set;
import android.os.Bundle;
import java.util.Iterator;
import g0.b$a;
import m0.f;
import java.util.HashMap;
import java.util.Map$Entry;
import android.util.SparseArray;
import java.util.Map;
import f0.i;
import android.os.Parcel;
import android.os.Parcelable$Creator;

public class c extends b
{
    public static final Parcelable$Creator<c> CREATOR;
    private final int e;
    private final Parcel f;
    private final int g;
    private final h h;
    private final String i;
    private int j;
    private int k;
    
    static {
        CREATOR = (Parcelable$Creator)new k();
    }
    
    c(final int e, final Parcel parcel, final h h) {
        this.e = e;
        this.f = (Parcel)f0.i.i((Object)parcel);
        this.g = 2;
        this.h = h;
        String e2;
        if (h == null) {
            e2 = null;
        }
        else {
            e2 = h.e();
        }
        this.i = e2;
        this.j = 2;
    }
    
    private final void i(final StringBuilder sb, final Map<String, a$a<?, ?>> map, final Parcel parcel) {
        final SparseArray sparseArray = new SparseArray();
        for (final Map$Entry map$Entry : map.entrySet()) {
            sparseArray.put(((a$a)map$Entry.getValue()).k(), (Object)map$Entry);
        }
        sb.append('{');
        final int f = g0.b.F(parcel);
        int n = 0;
        while (parcel.dataPosition() < f) {
            final int y = g0.b.y(parcel);
            final Map$Entry map$Entry2 = (Map$Entry)sparseArray.get(g0.b.u(y));
            if (map$Entry2 != null) {
                if (n != 0) {
                    sb.append(",");
                }
                final String s = (String)map$Entry2.getKey();
                final a$a a$a = (a$a)map$Entry2.getValue();
                sb.append("\"");
                sb.append(s);
                sb.append("\":");
                if (a$a.r()) {
                    final int h = a$a.h;
                    switch (h) {
                        default: {
                            final StringBuilder sb2 = new StringBuilder(36);
                            sb2.append("Unknown field out type = ");
                            sb2.append(h);
                            throw new IllegalArgumentException(sb2.toString());
                        }
                        case 11: {
                            throw new IllegalArgumentException("Method does not accept concrete type.");
                        }
                        case 10: {
                            final Bundle f2 = g0.b.f(parcel, y);
                            final HashMap hashMap = new HashMap();
                            for (final String s2 : ((BaseBundle)f2).keySet()) {
                                hashMap.put((Object)s2, (Object)f0.i.i((Object)((BaseBundle)f2).getString(s2)));
                            }
                            k(sb, (a$a<?, ?>)a$a, a.f(a$a, (Object)hashMap));
                            break;
                        }
                        case 8:
                        case 9: {
                            k(sb, (a$a<?, ?>)a$a, a.f(a$a, (Object)g0.b.g(parcel, y)));
                            break;
                        }
                        case 7: {
                            k(sb, (a$a<?, ?>)a$a, a.f(a$a, (Object)g0.b.o(parcel, y)));
                            break;
                        }
                        case 6: {
                            k(sb, (a$a<?, ?>)a$a, a.f(a$a, (Object)g0.b.v(parcel, y)));
                            break;
                        }
                        case 5: {
                            k(sb, (a$a<?, ?>)a$a, a.f(a$a, (Object)g0.b.a(parcel, y)));
                            break;
                        }
                        case 4: {
                            k(sb, (a$a<?, ?>)a$a, a.f(a$a, (Object)g0.b.w(parcel, y)));
                            break;
                        }
                        case 3: {
                            k(sb, (a$a<?, ?>)a$a, a.f(a$a, (Object)g0.b.x(parcel, y)));
                            break;
                        }
                        case 2: {
                            k(sb, (a$a<?, ?>)a$a, a.f(a$a, (Object)g0.b.B(parcel, y)));
                            break;
                        }
                        case 1: {
                            k(sb, (a$a<?, ?>)a$a, a.f(a$a, (Object)g0.b.c(parcel, y)));
                            break;
                        }
                        case 0: {
                            k(sb, (a$a<?, ?>)a$a, a.f(a$a, (Object)g0.b.A(parcel, y)));
                            break;
                        }
                    }
                }
                else if (a$a.i) {
                    sb.append("[");
                    switch (a$a.h) {
                        default: {
                            throw new IllegalStateException("Unknown field type out.");
                        }
                        case 11: {
                            final Parcel[] m = g0.b.m(parcel, y);
                            for (int length = m.length, i = 0; i < length; ++i) {
                                if (i > 0) {
                                    sb.append(",");
                                }
                                m[i].setDataPosition(0);
                                this.i(sb, (Map<String, a$a<?, ?>>)a$a.p(), m[i]);
                            }
                            break;
                        }
                        case 8:
                        case 9:
                        case 10: {
                            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                        }
                        case 7: {
                            m0.a.i(sb, g0.b.p(parcel, y));
                            break;
                        }
                        case 6: {
                            m0.a.h(sb, g0.b.e(parcel, y));
                            break;
                        }
                        case 5: {
                            m0.a.g(sb, (Object[])g0.b.b(parcel, y));
                            break;
                        }
                        case 4: {
                            m0.a.c(sb, g0.b.h(parcel, y));
                            break;
                        }
                        case 3: {
                            m0.a.d(sb, g0.b.i(parcel, y));
                            break;
                        }
                        case 2: {
                            m0.a.f(sb, g0.b.k(parcel, y));
                            break;
                        }
                        case 1: {
                            m0.a.g(sb, (Object[])g0.b.d(parcel, y));
                            break;
                        }
                        case 0: {
                            m0.a.e(sb, g0.b.j(parcel, y));
                            break;
                        }
                    }
                    sb.append("]");
                }
                else {
                    switch (a$a.h) {
                        default: {
                            throw new IllegalStateException("Unknown field type out");
                        }
                        case 11: {
                            final Parcel l = g0.b.l(parcel, y);
                            l.setDataPosition(0);
                            this.i(sb, (Map<String, a$a<?, ?>>)a$a.p(), l);
                            break;
                        }
                        case 10: {
                            final Bundle f3 = g0.b.f(parcel, y);
                            final Set keySet = ((BaseBundle)f3).keySet();
                            sb.append("{");
                            final Iterator iterator3 = keySet.iterator();
                            int n2 = 1;
                            while (iterator3.hasNext()) {
                                final String s3 = (String)iterator3.next();
                                if (n2 == 0) {
                                    sb.append(",");
                                }
                                sb.append("\"");
                                sb.append(s3);
                                sb.append("\":\"");
                                sb.append(m0.f.a(((BaseBundle)f3).getString(s3)));
                                sb.append("\"");
                                n2 = 0;
                            }
                            sb.append("}");
                            break;
                        }
                        case 9: {
                            final byte[] g = g0.b.g(parcel, y);
                            sb.append("\"");
                            sb.append(m0.b.b(g));
                            sb.append("\"");
                            break;
                        }
                        case 8: {
                            final byte[] g2 = g0.b.g(parcel, y);
                            sb.append("\"");
                            sb.append(m0.b.a(g2));
                            sb.append("\"");
                            break;
                        }
                        case 7: {
                            final String o = g0.b.o(parcel, y);
                            sb.append("\"");
                            sb.append(m0.f.a(o));
                            sb.append("\"");
                            break;
                        }
                        case 6: {
                            sb.append(g0.b.v(parcel, y));
                            break;
                        }
                        case 5: {
                            sb.append((Object)g0.b.a(parcel, y));
                            break;
                        }
                        case 4: {
                            sb.append(g0.b.w(parcel, y));
                            break;
                        }
                        case 3: {
                            sb.append(g0.b.x(parcel, y));
                            break;
                        }
                        case 2: {
                            sb.append(g0.b.B(parcel, y));
                            break;
                        }
                        case 1: {
                            sb.append((Object)g0.b.c(parcel, y));
                            break;
                        }
                        case 0: {
                            sb.append(g0.b.A(parcel, y));
                            break;
                        }
                    }
                }
                n = 1;
            }
        }
        if (parcel.dataPosition() == f) {
            sb.append('}');
            return;
        }
        final StringBuilder sb3 = new StringBuilder(37);
        sb3.append("Overread allowed size end=");
        sb3.append(f);
        throw new b$a(sb3.toString(), parcel);
    }
    
    private static final void j(StringBuilder sb, final int n, final Object o) {
        switch (n) {
            default: {
                sb = new StringBuilder(26);
                sb.append("Unknown type = ");
                sb.append(n);
                throw new IllegalArgumentException(sb.toString());
            }
            case 11: {
                throw new IllegalArgumentException("Method does not accept concrete type.");
            }
            case 10: {
                g.a(sb, (HashMap)i.i(o));
                return;
            }
            case 9: {
                sb.append("\"");
                sb.append(m0.b.b((byte[])o));
                sb.append("\"");
                return;
            }
            case 8: {
                sb.append("\"");
                sb.append(m0.b.a((byte[])o));
                sb.append("\"");
                return;
            }
            case 7: {
                sb.append("\"");
                sb.append(f.a(i.i(o).toString()));
                sb.append("\"");
                return;
            }
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6: {
                sb.append(o);
            }
        }
    }
    
    private static final void k(final StringBuilder sb, final a$a<?, ?> a$a, final Object o) {
        if (a$a.g) {
            final ArrayList list = (ArrayList)o;
            sb.append("[");
            for (int size = list.size(), i = 0; i < size; ++i) {
                if (i != 0) {
                    sb.append(",");
                }
                j(sb, a$a.f, list.get(i));
            }
            sb.append("]");
            return;
        }
        j(sb, a$a.f, o);
    }
    
    public final Map<String, a$a<?, ?>> a() {
        final h h = this.h;
        if (h == null) {
            return null;
        }
        return (Map<String, a$a<?, ?>>)h.f((String)f0.i.i((Object)this.i));
    }
    
    public final Object c(final String s) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
    
    public final boolean e(final String s) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
    
    public final Parcel h() {
        final int j = this.j;
        if (j != 0) {
            if (j == 1) {
                g0.c.b(this.f, this.k);
                this.j = 2;
            }
        }
        else {
            final int a = g0.c.a(this.f);
            this.k = a;
            g0.c.b(this.f, a);
            this.j = 2;
        }
        return this.f;
    }
    
    public final String toString() {
        f0.i.j((Object)this.h, (Object)"Cannot convert to JSON on client side.");
        final Parcel h = this.h();
        h.setDataPosition(0);
        final StringBuilder sb = new StringBuilder(100);
        this.i(sb, (Map<String, a$a<?, ?>>)f0.i.i((Object)this.h.f((String)f0.i.i((Object)this.i))), h);
        return sb.toString();
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int a = g0.c.a(parcel);
        g0.c.g(parcel, 1, this.e);
        g0.c.k(parcel, 2, this.h(), false);
        final int g = this.g;
        Object o;
        if (g != 0) {
            if (g != 1) {
                o = this.h;
            }
            else {
                o = this.h;
            }
        }
        else {
            o = null;
        }
        g0.c.l(parcel, 3, (Parcelable)o, n, false);
        g0.c.b(parcel, a);
    }
}
