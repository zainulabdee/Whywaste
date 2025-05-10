package t2;

import android.os.Build$VERSION;
import e2.g;
import java.lang.reflect.Modifier;
import java.lang.reflect.Method;
import e2.g$c;
import s2.d0;
import e2.a;

public final class b extends a implements d0
{
    private volatile Object _preHandler;
    
    public b() {
        super((g$c<?>)d0.c);
        this._preHandler = this;
    }
    
    private final Method p() {
        final Object preHandler = this._preHandler;
        if (preHandler != this) {
            return (Method)preHandler;
        }
        Object o = null;
        final boolean b = false;
        try {
            final Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", (Class<?>[])new Class[0]);
            int n = b ? 1 : 0;
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                final boolean static1 = Modifier.isStatic(declaredMethod.getModifiers());
                n = (b ? 1 : 0);
                if (static1) {
                    n = 1;
                }
            }
            if (n != 0) {
                o = declaredMethod;
            }
            return (Method)(this._preHandler = o);
        }
        finally {
            return (Method)(this._preHandler = o);
        }
    }
    
    @Override
    public void q(final g g, final Throwable t) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (26 <= sdk_INT && sdk_INT < 28) {
            final Method p2 = this.p();
            Thread$UncaughtExceptionHandler thread$UncaughtExceptionHandler = null;
            Object invoke;
            if (p2 != null) {
                invoke = p2.invoke((Object)null, new Object[0]);
            }
            else {
                invoke = null;
            }
            if (invoke instanceof Thread$UncaughtExceptionHandler) {
                thread$UncaughtExceptionHandler = (Thread$UncaughtExceptionHandler)invoke;
            }
            if (thread$UncaughtExceptionHandler != null) {
                thread$UncaughtExceptionHandler.uncaughtException(Thread.currentThread(), t);
            }
        }
    }
}
