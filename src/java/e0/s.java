package e0;

import android.os.Looper;
import com.google.android.gms.common.api.internal.b;
import d0.l;
import d0.a$b;
import d0.e;
import d0.a$d;

public final class s<O extends a$d> extends p
{
    private final e<O> c;
    
    public s(final e<O> c) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.c = c;
    }
    
    public final <A extends a$b, R extends l, T extends b<R, A>> T a(final T t) {
        return (T)this.c.g((b)t);
    }
    
    public final <A extends a$b, T extends b<? extends l, A>> T b(final T t) {
        return (T)this.c.h((b)t);
    }
    
    public final Looper d() {
        return this.c.n();
    }
}
