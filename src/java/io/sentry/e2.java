package io.sentry;

public final class e2<T>
{
    private final Class<T> a;
    
    private e2(final Class<T> a) {
        this.a = a;
    }
    
    public static <T> e2<T> a(final Class<T> clazz) {
        return new e2<T>(clazz);
    }
    
    public T b() {
        return (T)this.a.getDeclaredConstructor((Class<?>[])new Class[0]).newInstance(new Object[0]);
    }
}
