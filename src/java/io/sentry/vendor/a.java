package io.sentry.vendor;

import java.io.UnsupportedEncodingException;

public class a
{
    public static byte[] a(final byte[] array, final int n) {
        return b(array, 0, array.length, n);
    }
    
    public static byte[] b(final byte[] array, final int n, final int n2, int n3) {
        final a$b a$b = new a$b(n3, (byte[])null);
        final int n4 = n2 / 3 * 4;
        final boolean f = a$b.f;
        final int n5 = 2;
        if (f) {
            n3 = n4;
            if (n2 % 3 > 0) {
                n3 = n4 + 4;
            }
        }
        else {
            n3 = n2 % 3;
            if (n3 != 1) {
                if (n3 != 2) {
                    n3 = n4;
                }
                else {
                    n3 = n4 + 3;
                }
            }
            else {
                n3 = n4 + 2;
            }
        }
        int n6 = n3;
        if (a$b.g) {
            n6 = n3;
            if (n2 > 0) {
                final int n7 = (n2 - 1) / 57;
                int n8;
                if (a$b.h) {
                    n8 = n5;
                }
                else {
                    n8 = 1;
                }
                n6 = n3 + (n7 + 1) * n8;
            }
        }
        ((a)a$b).a = new byte[n6];
        a$b.a(array, n, n2, true);
        return ((a)a$b).a;
    }
    
    public static String c(final byte[] array, final int n) {
        try {
            return new String(a(array, n), "US-ASCII");
        }
        catch (final UnsupportedEncodingException ex) {
            throw new AssertionError((Object)ex);
        }
    }
    
    abstract static class a
    {
        public byte[] a;
        public int b;
    }
}
