package d0;

import android.os.Looper;
import com.google.android.gms.common.api.internal.b;
import java.util.Map;
import java.util.Collections;
import java.util.WeakHashMap;
import java.util.Set;

@Deprecated
public abstract class f
{
    private static final Set<f> a;
    
    static {
        a = Collections.newSetFromMap((Map)new WeakHashMap());
    }
    
    public static Set<f> c() {
        final Set<f> a = f.a;
        synchronized (a) {
            monitorexit(a);
            return a;
        }
    }
    
    public <A extends a.b, R extends l, T extends b<R, A>> T a(final T t) {
        throw new UnsupportedOperationException();
    }
    
    public <A extends a.b, T extends b<? extends l, A>> T b(final T t) {
        throw new UnsupportedOperationException();
    }
    
    public Looper d() {
        throw new UnsupportedOperationException();
    }
    
    public boolean e(final e0.l l) {
        throw new UnsupportedOperationException();
    }
    
    public void f() {
        throw new UnsupportedOperationException();
    }
}
