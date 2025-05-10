package s2;

import java.util.concurrent.Executor;

public final class e1
{
    public static final c0 a(final Executor executor) {
        s0 s0;
        if (executor instanceof s0) {
            s0 = (s0)executor;
        }
        else {
            s0 = null;
        }
        Object e;
        if (s0 == null || (e = s0.e) == null) {
            e = new d1(executor);
        }
        return (c0)e;
    }
}
