package t2;

import android.os.Handler$Callback;
import android.os.Build$VERSION;
import android.os.Handler;
import c2.k$a;
import c2.l;
import android.os.Looper;
import c2.k;
import android.view.Choreographer;

public final class e
{
    public static final d a;
    private static volatile Choreographer choreographer;
    
    static {
        final d d = null;
        Object a2 = null;
        try {
            final k$a e = k.e;
            k.a((Object)new c(a(Looper.getMainLooper(), true), (String)null, 2, (kotlin.jvm.internal.e)null));
        }
        finally {
            final k$a e2 = k.e;
            final Throwable t;
            a2 = k.a(l.a(t));
        }
        if (k.c(a2)) {
            a2 = d;
        }
        a = (d)a2;
    }
    
    public static final Handler a(final Looper looper, final boolean b) {
        if (b) {
            if (Build$VERSION.SDK_INT >= 28) {
                final Object invoke = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke((Object)null, new Object[] { looper });
                if (invoke != null) {
                    return (Handler)invoke;
                }
                throw new NullPointerException("null cannot be cast to non-null type android.os.Handler");
            }
            else {
                try {
                    return (Handler)Handler.class.getDeclaredConstructor(Looper.class, Handler$Callback.class, Boolean.TYPE).newInstance(new Object[] { looper, null, Boolean.TRUE });
                }
                catch (final NoSuchMethodException ex) {
                    return new Handler(looper);
                }
            }
        }
        return new Handler(looper);
    }
}
