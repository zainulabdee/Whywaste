package m0;

import f0.g;

public final class a
{
    public static boolean a(final int[] array, final int n) {
        if (array != null) {
            for (int i = 0; i < array.length; ++i) {
                if (array[i] == n) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public static <T> boolean b(final T[] array, final T t) {
        int length;
        if (array != null) {
            length = array.length;
        }
        else {
            length = 0;
        }
        int i = 0;
        while (i < length) {
            if (g.b((Object)array[i], (Object)t)) {
                if (i >= 0) {
                    return true;
                }
                break;
            }
            else {
                ++i;
            }
        }
        return false;
    }
    
    public static void c(final StringBuilder sb, final double[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(array[i]));
        }
    }
    
    public static void d(final StringBuilder sb, final float[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(array[i]));
        }
    }
    
    public static void e(final StringBuilder sb, final int[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(array[i]));
        }
    }
    
    public static void f(final StringBuilder sb, final long[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(array[i]));
        }
    }
    
    public static <T> void g(final StringBuilder sb, final T[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append((Object)array[i]);
        }
    }
    
    public static void h(final StringBuilder sb, final boolean[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(array[i]));
        }
    }
    
    public static void i(final StringBuilder sb, final String[] array) {
        for (int length = array.length, i = 0; i < length; ++i) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append("\"");
            sb.append(array[i]);
            sb.append("\"");
        }
    }
}
