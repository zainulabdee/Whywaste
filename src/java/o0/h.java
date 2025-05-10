package o0;

import android.os.IInterface;
import android.os.BadParcelableException;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.os.Parcel;

public final class h
{
    private static final ClassLoader a;
    
    static {
        a = h.class.getClassLoader();
    }
    
    private h() {
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
        parcelable.writeToParcel(parcel, 0);
    }
    
    public static void d(final Parcel parcel, final IInterface interface1) {
        parcel.writeStrongBinder(interface1.asBinder());
    }
}
