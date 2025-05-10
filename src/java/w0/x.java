package w0;

import java.util.concurrent.Executor;

final class x implements Executor
{
    public final void execute(final Runnable runnable) {
        runnable.run();
    }
}
