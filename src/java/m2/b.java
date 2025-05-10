package m2;

import kotlin.jvm.internal.i;
import java.util.Random;

public final class b extends a
{
    private final b$a g;
    
    public b() {
        this.g = new b$a();
    }
    
    public Random c() {
        final Object value = ((ThreadLocal)this.g).get();
        i.d(value, "implStorage.get()");
        return (Random)value;
    }
}
