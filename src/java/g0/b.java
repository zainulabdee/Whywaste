package g0;

import android.os.IBinder;
import java.util.ArrayList;
import android.os.Parcelable;
import android.os.Parcelable$Creator;
import android.os.Bundle;
import java.math.BigInteger;
import java.math.BigDecimal;
import android.os.Parcel;

public class b
{
    public static int A(final Parcel parcel, final int n) {
        H(parcel, n, 4);
        return parcel.readInt();
    }
    
    public static long B(final Parcel parcel, final int n) {
        H(parcel, n, 8);
        return parcel.readLong();
    }
    
    public static Long C(final Parcel parcel, final int n) {
        final int d = D(parcel, n);
        if (d == 0) {
            return null;
        }
        G(parcel, n, d, 8);
        return parcel.readLong();
    }
    
    public static int D(final Parcel parcel, final int n) {
        if ((n & 0xFFFF0000) != 0xFFFF0000) {
            return (char)(n >> 16);
        }
        return parcel.readInt();
    }
    
    public static void E(final Parcel parcel, int d) {
        d = D(parcel, d);
        parcel.setDataPosition(parcel.dataPosition() + d);
    }
    
    public static int F(final Parcel parcel) {
        final int y = y(parcel);
        final int d = D(parcel, y);
        final int u = u(y);
        final int dataPosition = parcel.dataPosition();
        if (u != 20293) {
            throw new a("Expected object header. Got 0x".concat(String.valueOf((Object)Integer.toHexString(y))), parcel);
        }
        final int n = d + dataPosition;
        if (n >= dataPosition && n <= parcel.dataSize()) {
            return n;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Size read is invalid start=");
        sb.append(dataPosition);
        sb.append(" end=");
        sb.append(n);
        throw new a(sb.toString(), parcel);
    }
    
    private static void G(final Parcel parcel, final int n, final int n2, final int n3) {
        if (n2 == n3) {
            return;
        }
        final String hexString = Integer.toHexString(n2);
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected size ");
        sb.append(n3);
        sb.append(" got ");
        sb.append(n2);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new a(sb.toString(), parcel);
    }
    
    private static void H(final Parcel parcel, int d, final int n) {
        d = D(parcel, d);
        if (d == n) {
            return;
        }
        final String hexString = Integer.toHexString(d);
        final StringBuilder sb = new StringBuilder();
        sb.append("Expected size ");
        sb.append(n);
        sb.append(" got ");
        sb.append(d);
        sb.append(" (0x");
        sb.append(hexString);
        sb.append(")");
        throw new a(sb.toString(), parcel);
    }
    
    public static BigDecimal a(final Parcel parcel, int int1) {
        final int d = D(parcel, int1);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final byte[] byteArray = parcel.createByteArray();
        int1 = parcel.readInt();
        parcel.setDataPosition(dataPosition + d);
        return new BigDecimal(new BigInteger(byteArray), int1);
    }
    
    public static BigDecimal[] b(final Parcel parcel, int i) {
        final int d = D(parcel, i);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final int int1 = parcel.readInt();
        final BigDecimal[] array = new BigDecimal[int1];
        for (i = 0; i < int1; ++i) {
            array[i] = new BigDecimal(new BigInteger(parcel.createByteArray()), parcel.readInt());
        }
        parcel.setDataPosition(dataPosition + d);
        return array;
    }
    
    public static BigInteger c(final Parcel parcel, int d) {
        d = D(parcel, d);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final byte[] byteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + d);
        return new BigInteger(byteArray);
    }
    
    public static BigInteger[] d(final Parcel parcel, int i) {
        final int d = D(parcel, i);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final int int1 = parcel.readInt();
        final BigInteger[] array = new BigInteger[int1];
        for (i = 0; i < int1; ++i) {
            array[i] = new BigInteger(parcel.createByteArray());
        }
        parcel.setDataPosition(dataPosition + d);
        return array;
    }
    
    public static boolean[] e(final Parcel parcel, int d) {
        d = D(parcel, d);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final boolean[] booleanArray = parcel.createBooleanArray();
        parcel.setDataPosition(dataPosition + d);
        return booleanArray;
    }
    
    public static Bundle f(final Parcel parcel, int d) {
        d = D(parcel, d);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(dataPosition + d);
        return bundle;
    }
    
    public static byte[] g(final Parcel parcel, int d) {
        d = D(parcel, d);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final byte[] byteArray = parcel.createByteArray();
        parcel.setDataPosition(dataPosition + d);
        return byteArray;
    }
    
    public static double[] h(final Parcel parcel, int d) {
        d = D(parcel, d);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final double[] doubleArray = parcel.createDoubleArray();
        parcel.setDataPosition(dataPosition + d);
        return doubleArray;
    }
    
    public static float[] i(final Parcel parcel, int d) {
        d = D(parcel, d);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final float[] floatArray = parcel.createFloatArray();
        parcel.setDataPosition(dataPosition + d);
        return floatArray;
    }
    
    public static int[] j(final Parcel parcel, int d) {
        d = D(parcel, d);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final int[] intArray = parcel.createIntArray();
        parcel.setDataPosition(dataPosition + d);
        return intArray;
    }
    
    public static long[] k(final Parcel parcel, int d) {
        d = D(parcel, d);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final long[] longArray = parcel.createLongArray();
        parcel.setDataPosition(dataPosition + d);
        return longArray;
    }
    
    public static Parcel l(final Parcel parcel, int d) {
        d = D(parcel, d);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final Parcel obtain = Parcel.obtain();
        obtain.appendFrom(parcel, dataPosition, d);
        parcel.setDataPosition(dataPosition + d);
        return obtain;
    }
    
    public static Parcel[] m(final Parcel parcel, int i) {
        final int d = D(parcel, i);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final int int1 = parcel.readInt();
        final Parcel[] array = new Parcel[int1];
        int int2;
        int dataPosition2;
        Parcel obtain;
        for (i = 0; i < int1; ++i) {
            int2 = parcel.readInt();
            if (int2 != 0) {
                dataPosition2 = parcel.dataPosition();
                obtain = Parcel.obtain();
                obtain.appendFrom(parcel, dataPosition2, int2);
                array[i] = obtain;
                parcel.setDataPosition(dataPosition2 + int2);
            }
            else {
                array[i] = null;
            }
        }
        parcel.setDataPosition(dataPosition + d);
        return array;
    }
    
    public static <T extends Parcelable> T n(final Parcel parcel, int dataPosition, final Parcelable$Creator<T> parcelable$Creator) {
        final int d = D(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final Parcelable parcelable = (Parcelable)parcelable$Creator.createFromParcel(parcel);
        parcel.setDataPosition(dataPosition + d);
        return (T)parcelable;
    }
    
    public static String o(final Parcel parcel, int dataPosition) {
        final int d = D(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final String string = parcel.readString();
        parcel.setDataPosition(dataPosition + d);
        return string;
    }
    
    public static String[] p(final Parcel parcel, int d) {
        d = D(parcel, d);
        final int dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final String[] stringArray = parcel.createStringArray();
        parcel.setDataPosition(dataPosition + d);
        return stringArray;
    }
    
    public static ArrayList<String> q(final Parcel parcel, int dataPosition) {
        final int d = D(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final ArrayList stringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(dataPosition + d);
        return (ArrayList<String>)stringArrayList;
    }
    
    public static <T> T[] r(final Parcel parcel, int dataPosition, final Parcelable$Creator<T> parcelable$Creator) {
        final int d = D(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final Object[] typedArray = parcel.createTypedArray((Parcelable$Creator)parcelable$Creator);
        parcel.setDataPosition(dataPosition + d);
        return (T[])typedArray;
    }
    
    public static <T> ArrayList<T> s(final Parcel parcel, int dataPosition, final Parcelable$Creator<T> parcelable$Creator) {
        final int d = D(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final ArrayList typedArrayList = parcel.createTypedArrayList((Parcelable$Creator)parcelable$Creator);
        parcel.setDataPosition(dataPosition + d);
        return (ArrayList<T>)typedArrayList;
    }
    
    public static void t(final Parcel parcel, final int n) {
        if (parcel.dataPosition() == n) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Overread allowed size end=");
        sb.append(n);
        throw new a(sb.toString(), parcel);
    }
    
    public static int u(final int n) {
        return (char)n;
    }
    
    public static boolean v(final Parcel parcel, final int n) {
        H(parcel, n, 4);
        return parcel.readInt() != 0;
    }
    
    public static double w(final Parcel parcel, final int n) {
        H(parcel, n, 8);
        return parcel.readDouble();
    }
    
    public static float x(final Parcel parcel, final int n) {
        H(parcel, n, 4);
        return parcel.readFloat();
    }
    
    public static int y(final Parcel parcel) {
        return parcel.readInt();
    }
    
    public static IBinder z(final Parcel parcel, int dataPosition) {
        final int d = D(parcel, dataPosition);
        dataPosition = parcel.dataPosition();
        if (d == 0) {
            return null;
        }
        final IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(dataPosition + d);
        return strongBinder;
    }
    
    public static class a extends RuntimeException
    {
        public a(final String s, final Parcel parcel) {
            final int dataPosition = parcel.dataPosition();
            final int dataSize = parcel.dataSize();
            final StringBuilder sb = new StringBuilder();
            sb.append(s);
            sb.append(" Parcel: pos=");
            sb.append(dataPosition);
            sb.append(" size=");
            sb.append(dataSize);
            super(sb.toString());
        }
    }
}
