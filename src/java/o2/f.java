package o2;

class f extends e
{
    public static int a(final int n, final int n2) {
        int n3 = n;
        if (n < n2) {
            n3 = n2;
        }
        return n3;
    }
    
    public static long b(final long n, final long n2) {
        long n3 = n;
        if (n < n2) {
            n3 = n2;
        }
        return n3;
    }
    
    public static int c(final int n, final int n2) {
        int n3 = n;
        if (n > n2) {
            n3 = n2;
        }
        return n3;
    }
    
    public static long d(final long n, final long n2) {
        long n3 = n;
        if (n > n2) {
            n3 = n2;
        }
        return n3;
    }
    
    public static int e(final int n, final int n2, final int n3) {
        if (n2 > n3) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Cannot coerce value to an empty range: maximum ");
            sb.append(n3);
            sb.append(" is less than minimum ");
            sb.append(n2);
            sb.append('.');
            throw new IllegalArgumentException(sb.toString());
        }
        if (n < n2) {
            return n2;
        }
        if (n > n3) {
            return n3;
        }
        return n;
    }
    
    public static a f(final int n, final int n2) {
        return a.h.a(n, n2, -1);
    }
    
    public static c g(final int n, final int n2) {
        if (n2 <= Integer.MIN_VALUE) {
            return c.i.a();
        }
        return new c(n, n2 - 1);
    }
}
