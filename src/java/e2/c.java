package e2;

import l2.p;
import kotlin.jvm.internal.i;
import java.io.Serializable;

public final class c implements g, Serializable
{
    private final g e;
    private final g.b f;
    
    public c(final g e, final g.b f) {
        i.e((Object)e, "left");
        i.e((Object)f, "element");
        this.e = e;
        this.f = f;
    }
    
    private final boolean c(final g.b b) {
        return i.a(this.b(b.getKey()), (Object)b);
    }
    
    private final boolean d(c c) {
        while (this.c(c.f)) {
            final g e = c.e;
            if (!(e instanceof c)) {
                i.c((Object)e, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return this.c((g.b)e);
            }
            c = (c)e;
        }
        return false;
    }
    
    private final int e() {
        int n = 2;
        c c = this;
        while (true) {
            final g e = c.e;
            if (e instanceof c) {
                c = (c)e;
            }
            else {
                c = null;
            }
            if (c == null) {
                break;
            }
            ++n;
        }
        return n;
    }
    
    public <E extends g.b> E b(final g$c<E> g$c) {
        i.e((Object)g$c, "key");
        c c = this;
        while (true) {
            final g.b b = c.f.b(g$c);
            if (b != null) {
                return (E)b;
            }
            final g e = c.e;
            if (!(e instanceof c)) {
                return (E)e.b((g$c)g$c);
            }
            c = (c)e;
        }
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this != o) {
            if (o instanceof c) {
                final c c = (c)o;
                if (c.e() == this.e() && c.d(this)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    public g g(final g g) {
        return g$a.a((g)this, g);
    }
    
    @Override
    public int hashCode() {
        return this.e.hashCode() + this.f.hashCode();
    }
    
    public <R> R t(final R r, final p<? super R, ? super g.b, ? extends R> p2) {
        i.e((Object)p2, "operation");
        return (R)p2.invoke(this.e.t((Object)r, (p)p2), (Object)this.f);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append((String)this.t("", (l2.p<? super String, ? super g.b, ? extends String>)c$a.e));
        sb.append(']');
        return sb.toString();
    }
    
    public g y(final g$c<?> g$c) {
        i.e((Object)g$c, "key");
        if (this.f.b(g$c) != null) {
            return this.e;
        }
        final g y = this.e.y((g$c)g$c);
        Object f;
        if (y == this.e) {
            f = this;
        }
        else if (y == h.e) {
            f = this.f;
        }
        else {
            f = new c(y, this.f);
        }
        return (g)f;
    }
}
