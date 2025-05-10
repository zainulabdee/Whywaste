package r0;

import android.os.IBinder;
import android.os.IInterface;
import android.os.BadParcelableException;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.os.Parcel;

public final class b
{
    private static final ClassLoader a;
    public static final int b = 0;
    
    static {
        a = b.class.getClassLoader();
    }
    
    private b() {
    }
    
    public static Parcelable a(final Parcel parcel, final Parcelable$Creator parcelable$Creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable)parcelable$Creator.createFromParcel(parcel);
    }
    
    public static void b(final Parcel parcel) {
        final int dataAvail = parcel.dataAvail();
        if (dataAvail <= 0) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Parcel data not fully consumed, unread size: ");
        sb.append(dataAvail);
        throw new BadParcelableException(sb.toString());
    }
    
    public static void c(final Parcel parcel, final Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 1);
    }
    
    public static void d(final Parcel parcel, final IInterface interface1) {
        if (interface1 == null) {
            parcel.writeStrongBinder((IBinder)null);
            return;
        }
        parcel.writeStrongBinder(interface1.asBinder());
    }
    
    public static boolean e(final Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
