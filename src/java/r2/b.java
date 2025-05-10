package r2;

class b extends a
{
    public static final boolean d(final char c, final char c2, final boolean b) {
        final boolean b2 = true;
        if (c == c2) {
            return true;
        }
        if (!b) {
            return false;
        }
        final char upperCase = Character.toUpperCase(c);
        final char upperCase2 = Character.toUpperCase(c2);
        boolean b3 = b2;
        if (upperCase != upperCase2) {
            b3 = (Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2) && b2);
        }
        return b3;
    }
}
