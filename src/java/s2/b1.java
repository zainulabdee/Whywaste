package s2;

import java.util.concurrent.CancellationException;

public final class b1
{
    public static final CancellationException a(final String s, final Throwable t) {
        final CancellationException ex = new CancellationException(s);
        ((Throwable)ex).initCause(t);
        return ex;
    }
}
