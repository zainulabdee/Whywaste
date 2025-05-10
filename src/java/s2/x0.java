package s2;

import kotlinx.coroutines.internal.g0;
import e2.g;
import kotlinx.coroutines.internal.h0;
import o2.d;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.q;
import androidx.concurrent.futures.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class x0 extends y0 implements n0
{
    private static final AtomicReferenceFieldUpdater j;
    private static final AtomicReferenceFieldUpdater k;
    private volatile Object _delayed;
    private volatile int _isCompleted;
    private volatile Object _queue;
    
    static {
        j = AtomicReferenceFieldUpdater.newUpdater((Class)x0.class, (Class)Object.class, "_queue");
        k = AtomicReferenceFieldUpdater.newUpdater((Class)x0.class, (Class)Object.class, "_delayed");
    }
    
    public x0() {
        this._queue = null;
        this._delayed = null;
        this._isCompleted = 0;
    }
    
    private final void M() {
        while (true) {
            final Object queue = this._queue;
            if (queue == null) {
                if (androidx.concurrent.futures.b.a(x0.j, (Object)this, (Object)null, (Object)a1.a())) {
                    return;
                }
                continue;
            }
            else {
                if (queue instanceof q) {
                    ((q)queue).d();
                    return;
                }
                if (queue == a1.a()) {
                    return;
                }
                final q q = new q(8, true);
                q.a((Object)queue);
                if (androidx.concurrent.futures.b.a(x0.j, (Object)this, queue, (Object)q)) {
                    return;
                }
                continue;
            }
        }
    }
    
    private final Runnable N() {
        while (true) {
            final Object queue = this._queue;
            if (queue == null) {
                return null;
            }
            if (queue instanceof q) {
                final q q = (q)queue;
                final Object j = q.j();
                if (j != kotlinx.coroutines.internal.q.h) {
                    return (Runnable)j;
                }
                androidx.concurrent.futures.b.a(x0.j, (Object)this, queue, (Object)q.i());
            }
            else {
                if (queue == a1.a()) {
                    return null;
                }
                if (androidx.concurrent.futures.b.a(x0.j, (Object)this, queue, (Object)null)) {
                    return (Runnable)queue;
                }
                continue;
            }
        }
    }
    
    private final boolean P(final Runnable runnable) {
        while (true) {
            final Object queue = this._queue;
            if (this.Q()) {
                return false;
            }
            if (queue == null) {
                if (androidx.concurrent.futures.b.a(x0.j, (Object)this, (Object)null, (Object)runnable)) {
                    return true;
                }
                continue;
            }
            else if (queue instanceof q) {
                final q q = (q)queue;
                final int a = q.a((Object)runnable);
                if (a == 0) {
                    return true;
                }
                if (a != 1) {
                    if (a != 2) {
                        continue;
                    }
                    return false;
                }
                else {
                    androidx.concurrent.futures.b.a(x0.j, (Object)this, queue, (Object)q.i());
                }
            }
            else {
                if (queue == a1.a()) {
                    return false;
                }
                final q q2 = new q(8, true);
                q2.a((Object)queue);
                q2.a((Object)runnable);
                if (androidx.concurrent.futures.b.a(x0.j, (Object)this, queue, (Object)q2)) {
                    return true;
                }
                continue;
            }
        }
    }
    
    private final boolean Q() {
        return this._isCompleted != 0;
    }
    
    private final void T() {
        c.a();
        final long nanoTime = System.nanoTime();
        while (true) {
            final b b = (b)this._delayed;
            if (b == null) {
                break;
            }
            final a a = (a)b.i();
            if (a == null) {
                break;
            }
            this.J(nanoTime, a);
        }
    }
    
    private final int W(final long n, final a a) {
        if (this.Q()) {
            return 1;
        }
        b b;
        if ((b = (b)this._delayed) == null) {
            androidx.concurrent.futures.b.a(x0.k, (Object)this, (Object)null, (Object)new b(n));
            final Object delayed = this._delayed;
            kotlin.jvm.internal.i.b(delayed);
            b = (b)delayed;
        }
        return a.i(n, b, this);
    }
    
    private final void X(final boolean isCompleted) {
        this._isCompleted = (isCompleted ? 1 : 0);
    }
    
    private final boolean Y(final a a) {
        final b b = (b)this._delayed;
        a a2;
        if (b != null) {
            a2 = (a)b.e();
        }
        else {
            a2 = null;
        }
        return a2 == a;
    }
    
    protected long C() {
        if (super.C() == 0L) {
            return 0L;
        }
        final Object queue = this._queue;
        if (queue != null) {
            if (queue instanceof q) {
                if (!((q)queue).g()) {
                    return 0L;
                }
            }
            else {
                if (queue == a1.a()) {
                    return Long.MAX_VALUE;
                }
                return 0L;
            }
        }
        final b b = (b)this._delayed;
        if (b != null) {
            final a a = (a)b.e();
            if (a != null) {
                final long e = a.e;
                c.a();
                return d.b(e - System.nanoTime(), 0L);
            }
        }
        return Long.MAX_VALUE;
    }
    
    public void O(final Runnable runnable) {
        if (this.P(runnable)) {
            this.K();
        }
        else {
            l0.l.O(runnable);
        }
    }
    
    protected boolean R() {
        final boolean g = this.G();
        boolean g2 = false;
        if (!g) {
            return false;
        }
        final b b = (b)this._delayed;
        if (b != null && !b.d()) {
            return false;
        }
        final Object queue = this._queue;
        if (queue != null) {
            if (queue instanceof q) {
                g2 = ((q)queue).g();
                return g2;
            }
            if (queue != a1.a()) {
                return g2;
            }
        }
        g2 = true;
        return g2;
    }
    
    public long S() {
        if (this.H()) {
            return 0L;
        }
        final b b = (b)this._delayed;
        if (b != null && !b.d()) {
            c.a();
            final long nanoTime = System.nanoTime();
            while (true) {
                synchronized (b) {
                    final h0 b2 = b.b();
                    final a a = null;
                    Object h = null;
                    if (b2 == null) {
                        monitorexit(b);
                        h = a;
                    }
                    else {
                        final a a2 = (a)b2;
                        if (a2.j(nanoTime) && this.P((Runnable)a2)) {
                            h = b.h(0);
                        }
                        monitorexit(b);
                    }
                    if (h != null) {
                        continue;
                    }
                }
                break;
            }
        }
        final Runnable n = this.N();
        if (n != null) {
            n.run();
            return 0L;
        }
        return this.C();
    }
    
    protected final void U() {
        this._queue = null;
        this._delayed = null;
    }
    
    public final void V(final long n, final a a) {
        final int w = this.W(n, a);
        if (w != 0) {
            if (w != 1) {
                if (w != 2) {
                    throw new IllegalStateException("unexpected result".toString());
                }
            }
            else {
                this.J(n, a);
            }
        }
        else if (this.Y(a)) {
            this.K();
        }
    }
    
    public final void p(final g g, final Runnable runnable) {
        this.O(runnable);
    }
    
    public void shutdown() {
        c2.a.b();
        this.X(true);
        this.M();
        while (this.S() <= 0L) {}
        this.T();
    }
    
    public abstract static class a implements Runnable, Comparable<a>, u0, h0
    {
        private volatile Object _heap;
        public long e;
        private int f;
        
        public final void d() {
            synchronized (this) {
                final Object heap = this._heap;
                if (heap == a1.b()) {
                    return;
                }
                b b;
                if (heap instanceof b) {
                    b = (b)heap;
                }
                else {
                    b = null;
                }
                if (b != null) {
                    b.g((h0)this);
                }
                this._heap = a1.b();
            }
        }
        
        public void e(final g0<?> heap) {
            if (this._heap != a1.b()) {
                this._heap = heap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        
        public g0<?> f() {
            final Object heap = this._heap;
            g0 g0;
            if (heap instanceof g0) {
                g0 = (g0)heap;
            }
            else {
                g0 = null;
            }
            return (g0<?>)g0;
        }
        
        public int getIndex() {
            return this.f;
        }
        
        public int h(final a a) {
            final long n = lcmp(this.e - a.e, 0L);
            int n2;
            if (n > 0) {
                n2 = 1;
            }
            else if (n < 0) {
                n2 = -1;
            }
            else {
                n2 = 0;
            }
            return n2;
        }
        
        public final int i(long b, final b b2, final x0 x0) {
            synchronized (this) {
                if (this._heap == a1.b()) {
                    return 2;
                }
                synchronized (b2) {
                    final a a = (a)b2.b();
                    if (x0.Q()) {
                        return 1;
                    }
                    if (a == null) {
                        b2.b = b;
                    }
                    else {
                        final long e = a.e;
                        if (e - b < 0L) {
                            b = e;
                        }
                        if (b - b2.b > 0L) {
                            b2.b = b;
                        }
                    }
                    final long e2 = this.e;
                    b = b2.b;
                    if (e2 - b < 0L) {
                        this.e = b;
                    }
                    b2.a((h0)this);
                    return 0;
                }
            }
        }
        
        public final boolean j(final long n) {
            return n - this.e >= 0L;
        }
        
        public void setIndex(final int f) {
            this.f = f;
        }
        
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Delayed[nanos=");
            sb.append(this.e);
            sb.append(']');
            return sb.toString();
        }
    }
    
    public static final class b extends g0<a>
    {
        public long b;
        
        public b(final long b) {
            this.b = b;
        }
    }
}
