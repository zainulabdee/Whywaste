package e0;

import f.e;
import d0.c;
import java.util.Set;
import java.util.Map;
import w0.h;
import f.a;

public final class c0
{
    private final a<b<?>, c0.b> a;
    private final a<b<?>, String> b;
    private final h<Map<b<?>, String>> c;
    private int d;
    private boolean e;
    
    public final Set<b<?>> a() {
        return (Set<b<?>>)this.a.keySet();
    }
    
    public final void b(final b<?> b, final c0.b b2, final String s) {
        ((e<b<?>, c0.b>)this.a).put(b, b2);
        ((e<b<?>, String>)this.b).put(b, s);
        --this.d;
        if (!b2.i()) {
            this.e = true;
        }
        if (this.d == 0) {
            if (this.e) {
                this.c.b((Exception)new c(this.a));
                return;
            }
            this.c.c((Object)this.b);
        }
    }
}
