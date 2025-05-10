package io.sentry.util;

public final class l<T>
{
    private T a;
    private final a<T> b;
    
    public l(final a<T> b) {
        this.a = null;
        this.b = b;
    }
    
    public T a() {
        synchronized (this) {
            if (this.a == null) {
                this.a = this.b.a();
            }
            return this.a;
        }
    }
    
    public interface a<T>
    {
        T a();
    }
}
