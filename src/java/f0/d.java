package f0;

public final class d
{
    private final String a;
    private final String b;
    
    public d(final String s) {
        this(s, null);
    }
    
    public d(final String a, final String b) {
        i.j(a, "log tag cannot be null");
        final int length = a.length();
        boolean b2 = false;
        if (length <= 23) {
            b2 = true;
        }
        i.c(b2, "tag \"%s\" is longer than the %d character maximum", a, 23);
        this.a = a;
        if (b != null && b.length() > 0) {
            this.b = b;
            return;
        }
        this.b = null;
    }
}
