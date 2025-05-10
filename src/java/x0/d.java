package x0;

public final class d
{
    public static <T> T a(final T t) {
        t.getClass();
        return t;
    }
    
    public static <T> T b(final T t, final Object o) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(o));
    }
}
