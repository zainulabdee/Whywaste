package g2;

import d2.e;
import m2.b;
import m2.c;
import java.lang.reflect.Method;
import kotlin.jvm.internal.i;

public class a
{
    public void a(final Throwable t, final Throwable t2) {
        i.e((Object)t, "cause");
        i.e((Object)t2, "exception");
        final Method b = a.b;
        if (b != null) {
            b.invoke((Object)t, new Object[] { t2 });
        }
    }
    
    public c b() {
        return (c)new b();
    }
    
    private static final class a
    {
        public static final a a;
        public static final Method b;
        public static final Method c;
        
        static {
            a = new a();
            final Method[] methods = Throwable.class.getMethods();
            i.d((Object)methods, "throwableMethods");
            final int length = methods.length;
            final int n = 0;
            int n2 = 0;
            Method method;
            Method b2;
            while (true) {
                method = null;
                if (n2 >= length) {
                    b2 = null;
                    break;
                }
                b2 = methods[n2];
                boolean b3 = false;
                Label_0093: {
                    if (i.a((Object)b2.getName(), (Object)"addSuppressed")) {
                        final Class[] parameterTypes = b2.getParameterTypes();
                        i.d((Object)parameterTypes, "it.parameterTypes");
                        if (i.a(e.j((Object[])parameterTypes), (Object)Throwable.class)) {
                            b3 = true;
                            break Label_0093;
                        }
                    }
                    b3 = false;
                }
                if (b3) {
                    break;
                }
                ++n2;
            }
            b = b2;
            final int length2 = methods.length;
            int n3 = n;
            Method c2;
            while (true) {
                c2 = method;
                if (n3 >= length2) {
                    break;
                }
                c2 = methods[n3];
                if (i.a((Object)c2.getName(), (Object)"getSuppressed")) {
                    break;
                }
                ++n3;
            }
            c = c2;
        }
    }
}
