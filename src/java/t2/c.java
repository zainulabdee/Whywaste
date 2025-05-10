package t2;

import s2.v1;
import kotlin.jvm.internal.i;
import android.os.Looper;
import s2.t0;
import s2.p1;
import java.util.concurrent.CancellationException;
import e2.g;
import kotlin.jvm.internal.e;
import android.os.Handler;

public final class c extends d
{
    private volatile c _immediate;
    private final Handler g;
    private final String h;
    private final boolean i;
    private final c j;
    
    public c(final Handler handler, final String s) {
        this(handler, s, false);
    }
    
    private c(final Handler g, final String h, final boolean i) {
        c immediate = null;
        super(null);
        this.g = g;
        this.h = h;
        this.i = i;
        if (i) {
            immediate = this;
        }
        this._immediate = immediate;
        c immediate2;
        if ((immediate2 = this._immediate) == null) {
            immediate2 = new c(g, h, true);
            this._immediate = immediate2;
        }
        this.j = immediate2;
    }
    
    private final void B(final g g, final Runnable runnable) {
        final StringBuilder sb = new StringBuilder();
        sb.append("The task was rejected, the handler underlying the dispatcher '");
        sb.append((Object)this);
        sb.append("' was closed");
        p1.c(g, new CancellationException(sb.toString()));
        t0.b().p(g, runnable);
    }
    
    public c C() {
        return this.j;
    }
    
    public boolean equals(final Object o) {
        return o instanceof c && ((c)o).g == this.g;
    }
    
    public int hashCode() {
        return System.identityHashCode((Object)this.g);
    }
    
    public void p(final g g, final Runnable runnable) {
        if (!this.g.post(runnable)) {
            this.B(g, runnable);
        }
    }
    
    @Override
    public String toString() {
        String s;
        if ((s = this.A()) == null) {
            String s2;
            if ((s2 = this.h) == null) {
                s2 = this.g.toString();
            }
            s = s2;
            if (this.i) {
                final StringBuilder sb = new StringBuilder();
                sb.append(s2);
                sb.append(".immediate");
                s = sb.toString();
            }
        }
        return s;
    }
    
    public boolean v(final g g) {
        return !this.i || !kotlin.jvm.internal.i.a((Object)Looper.myLooper(), (Object)this.g.getLooper());
    }
}
