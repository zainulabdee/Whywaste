package g2;

public final class c
{
    private static final int a(final int n, final int n2, final int n3) {
        return c(c(n, n3) - c(n2, n3), n3);
    }
    
    public static final int b(final int n, int n2, final int n3) {
        if (n3 > 0) {
            if (n < n2) {
                n2 -= a(n2, n, n3);
            }
        }
        else {
            if (n3 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (n > n2) {
                n2 += a(n, n2, -n3);
            }
        }
        return n2;
    }
    
    private static final int c(int n, final int n2) {
        n %= n2;
        if (n < 0) {
            n += n2;
        }
        return n;
    }
}
