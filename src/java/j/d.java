package j;

import kotlin.jvm.internal.i;
import kotlin.jvm.internal.e;

public final class d extends a
{
    public d() {
        this(null, 1, null);
    }
    
    public d(final a a) {
        i.e((Object)a, "initialExtras");
        this.a().putAll(a.a());
    }
    
    public final <T> void b(final a$b<T> a$b, final T t) {
        i.e((Object)a$b, "key");
        this.a().put((Object)a$b, (Object)t);
    }
}
