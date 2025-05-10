package g0;

import java.util.List;
import android.os.Parcelable;
import android.os.IBinder;
import android.os.Bundle;
import android.os.Parcel;

public class c
{
    public static int a(final Parcel parcel) {
        return q(parcel, 20293);
    }
    
    public static void b(final Parcel parcel, final int n) {
        r(parcel, n);
    }
    
    public static void c(final Parcel parcel, final int n, final boolean b) {
        s(parcel, n, 4);
        parcel.writeInt((int)(b ? 1 : 0));
    }
    
    public static void d(final Parcel parcel, int q, final Bundle bundle, final boolean b) {
        if (bundle == null) {
            if (b) {
                s(parcel, q, 0);
            }
            return;
        }
        q = q(parcel, q);
        parcel.writeBundle(bundle);
        r(parcel, q);
    }
    
    public static void e(final Parcel parcel, int q, final byte[] array, final boolean b) {
        if (array == null) {
            if (b) {
                s(parcel, q, 0);
            }
            return;
        }
        q = q(parcel, q);
        parcel.writeByteArray(array);
        r(parcel, q);
    }
    
    public static void f(final Parcel parcel, int q, final IBinder binder, final boolean b) {
        if (binder == null) {
            if (b) {
                s(parcel, q, 0);
            }
            return;
        }
        q = q(parcel, q);
        parcel.writeStrongBinder(binder);
        r(parcel, q);
    }
    
    public static void g(final Parcel parcel, final int n, final int n2) {
        s(parcel, n, 4);
        parcel.writeInt(n2);
    }
    
    public static void h(final Parcel parcel, int q, final int[] array, final boolean b) {
        if (array == null) {
            if (b) {
                s(parcel, q, 0);
            }
            return;
        }
        q = q(parcel, q);
        parcel.writeIntArray(array);
        r(parcel, q);
    }
    
    public static void i(final Parcel parcel, final int n, final long n2) {
        s(parcel, n, 8);
        parcel.writeLong(n2);
    }
    
    public static void j(final Parcel parcel, final int n, final Long n2, final boolean b) {
        if (n2 == null) {
            if (b) {
                s(parcel, n, 0);
            }
            return;
        }
        s(parcel, n, 8);
        parcel.writeLong((long)n2);
    }
    
    public static void k(final Parcel parcel, int q, final Parcel parcel2, final boolean b) {
        if (parcel2 == null) {
            if (b) {
                s(parcel, q, 0);
            }
            return;
        }
        q = q(parcel, q);
        parcel.appendFrom(parcel2, 0, parcel2.dataSize());
        r(parcel, q);
    }
    
    public static void l(final Parcel parcel, int q, final Parcelable parcelable, final int n, final boolean b) {
        if (parcelable == null) {
            if (b) {
                s(parcel, q, 0);
            }
            return;
        }
        q = q(parcel, q);
        parcelable.writeToParcel(parcel, n);
        r(parcel, q);
    }
    
    public static void m(final Parcel parcel, int q, final String s, final boolean b) {
        if (s == null) {
            if (b) {
                s(parcel, q, 0);
            }
            return;
        }
        q = q(parcel, q);
        parcel.writeString(s);
        r(parcel, q);
    }
    
    public static void n(final Parcel parcel, int q, final List<String> list, final boolean b) {
        if (list == null) {
            if (b) {
                s(parcel, q, 0);
            }
            return;
        }
        q = q(parcel, q);
        parcel.writeStringList((List)list);
        r(parcel, q);
    }
    
    public static <T extends Parcelable> void o(final Parcel parcel, int i, final T[] array, final int n, final boolean b) {
        if (array == null) {
            if (b) {
                s(parcel, i, 0);
            }
            return;
        }
        final int q = q(parcel, i);
        final int length = array.length;
        parcel.writeInt(length);
        Parcelable parcelable;
        for (i = 0; i < length; ++i) {
            parcelable = array[i];
            if (parcelable == null) {
                parcel.writeInt(0);
            }
            else {
                t(parcel, parcelable, n);
            }
        }
        r(parcel, q);
    }
    
    public static <T extends Parcelable> void p(final Parcel parcel, int i, final List<T> list, final boolean b) {
        if (list == null) {
            if (b) {
                s(parcel, i, 0);
            }
            return;
        }
        final int q = q(parcel, i);
        final int size = list.size();
        parcel.writeInt(size);
        Parcelable parcelable;
        for (i = 0; i < size; ++i) {
            parcelable = (Parcelable)list.get(i);
            if (parcelable == null) {
                parcel.writeInt(0);
            }
            else {
                t(parcel, parcelable, 0);
            }
        }
        r(parcel, q);
    }
    
    private static int q(final Parcel parcel, final int n) {
        parcel.writeInt(n | 0xFFFF0000);
        parcel.writeInt(0);
        return parcel.dataPosition();
    }
    
    private static void r(final Parcel parcel, final int n) {
        final int dataPosition = parcel.dataPosition();
        parcel.setDataPosition(n - 4);
        parcel.writeInt(dataPosition - n);
        parcel.setDataPosition(dataPosition);
    }
    
    private static void s(final Parcel parcel, final int n, final int n2) {
        parcel.writeInt(n | n2 << 16);
    }
    
    private static void t(final Parcel parcel, final Parcelable parcelable, int dataPosition) {
        final int dataPosition2 = parcel.dataPosition();
        parcel.writeInt(1);
        final int dataPosition3 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        parcel.setDataPosition(dataPosition2);
        parcel.writeInt(dataPosition - dataPosition3);
        parcel.setDataPosition(dataPosition);
    }
}
