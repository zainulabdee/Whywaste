package p0;

import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.os.Parcel;

public final class a
{
    private static final ClassLoader a;
    
    static {
        a = a.class.getClassLoader();
    }
    
    private a() {
    }
    
    public static <T extends Parcelable> T a(final Parcel parcel, final Parcelable$Creator<T> parcelable$Creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (T)parcelable$Creator.createFromParcel(parcel);
    }
    
    public static boolean b(final Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
