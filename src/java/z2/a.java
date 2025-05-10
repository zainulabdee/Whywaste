package z2;

import android.os.Parcel;

public final class a
{
    private static int a(final Parcel parcel, final int n) {
        if ((n & 0xFFFF0000) != 0xFFFF0000) {
            return n >> 16 & 0xFFFF;
        }
        return parcel.readInt();
    }
    
    public static String b(final Parcel parcel, int a) {
        a = a(parcel, a);
        if (a == 0) {
            return null;
        }
        final int dataPosition = parcel.dataPosition();
        final String string = parcel.readString();
        parcel.setDataPosition(dataPosition + a);
        return string;
    }
}
