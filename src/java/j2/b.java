package j2;

import c2.a;
import java.io.Closeable;

public final class b
{
    public static final void a(final Closeable closeable, final Throwable t) {
        if (closeable != null) {
            if (t == null) {
                closeable.close();
            }
            else {
                try {
                    closeable.close();
                }
                finally {
                    final Throwable t2;
                    a.a(t, t2);
                }
            }
        }
    }
}
