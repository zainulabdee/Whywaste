package w0;

import java.util.ArrayDeque;
import java.util.Queue;

final class w<TResult>
{
    private final Object a;
    private Queue<v<TResult>> b;
    private boolean c;
    
    w() {
        this.a = new Object();
    }
    
    public final void a(final v<TResult> v) {
        final Object a = this.a;
        synchronized (a) {
            if (this.b == null) {
                this.b = (Queue<v<TResult>>)new ArrayDeque();
            }
            this.b.add((Object)v);
        }
    }
    
    public final void b(final g<TResult> g) {
        final Object a = this.a;
        synchronized (a) {
            if (this.b != null) {
                if (!this.c) {
                    this.c = true;
                    monitorexit(a);
                    while (true) {
                        synchronized (this.a) {
                            final v v = (v)this.b.poll();
                            if (v == null) {
                                this.c = false;
                                return;
                            }
                            monitorexit(a);
                            v.a(g);
                            continue;
                        }
                        break;
                    }
                }
            }
        }
    }
}
