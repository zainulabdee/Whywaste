package r2;

import o2.c;

class a
{
    public static final int a(final int n) {
        if (new c(2, 36).m(n)) {
            return n;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("radix ");
        sb.append(n);
        sb.append(" was not in valid range ");
        sb.append((Object)new c(2, 36));
        throw new IllegalArgumentException(sb.toString());
    }
    
    public static final int b(final char c, final int n) {
        return Character.digit((int)c, n);
    }
    
    public static final boolean c(final char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}
