package s0;

import android.os.BadParcelableException;
import java.util.ArrayList;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.os.Parcel;

public final class a
{
    private static final ClassLoader a;
    public static final int b = 0;
    
    static {
        a = a.class.getClassLoader();
    }
    
    private a() {
    }
    
    public static Parcelable a(final Parcel parcel, final Parcelable$Creator parcelable$Creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable)parcelable$Creator.createFromParcel(parcel);
    }
    
    public static ArrayList b(final Parcel parcel) {
        return parcel.readArrayList(s0.a.a);
    }
    
    public static void c(final Parcel parcel) {
        final int dataAvail = parcel.dataAvail();
        if (dataAvail <= 0) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Parcel data not fully consumed, unread size: ");
        sb.append(dataAvail);
        throw new BadParcelableException(sb.toString());
    }
}
