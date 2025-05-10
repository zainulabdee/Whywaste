package n2;

import kotlin.jvm.internal.i;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public final class a extends m2.a
{
    public Random c() {
        final ThreadLocalRandom current = ThreadLocalRandom.current();
        i.d((Object)current, "current()");
        return (Random)current;
    }
}
