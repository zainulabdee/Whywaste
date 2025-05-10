package a;

import java.util.Iterator;
import kotlin.jvm.internal.i;
import java.util.concurrent.CopyOnWriteArraySet;
import android.content.Context;
import java.util.Set;

public final class a
{
    private final Set<b> a;
    private volatile Context b;
    
    public a() {
        this.a = (Set<b>)new CopyOnWriteArraySet();
    }
    
    public final void a(final b b) {
        i.e((Object)b, "listener");
        final Context b2 = this.b;
        if (b2 != null) {
            b.a(b2);
        }
        this.a.add((Object)b);
    }
    
    public final void b() {
        this.b = null;
    }
    
    public final void c(final Context b) {
        i.e((Object)b, "context");
        this.b = b;
        final Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            ((b)iterator.next()).a(b);
        }
    }
}
