package io.sentry;

import java.util.TimerTask;
import java.util.concurrent.RejectedExecutionException;
import java.util.ArrayList;
import io.sentry.util.n;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public final class l implements s5
{
    private final Object a;
    private volatile Timer b;
    private final Map<String, List<i2>> c;
    private final List<i0> d;
    private final q4 e;
    private final AtomicBoolean f;
    
    public l(final q4 q4) {
        this.a = new Object();
        this.b = null;
        this.c = (Map<String, List<i2>>)new ConcurrentHashMap();
        this.f = new AtomicBoolean(false);
        this.e = (q4)n.c((Object)q4, "The options object is required.");
        this.d = (List<i0>)q4.getCollectors();
    }
    
    public List<i2> a(final v0 v0) {
        final Object o = this.c.remove((Object)v0.f().toString());
        this.e.getLogger().a(l4.DEBUG, "stop collecting performance info for transactions %s (%s)", new Object[] { v0.getName(), ((u0)v0).i().j().toString() });
        if (this.c.isEmpty() && this.f.getAndSet(false)) {
            final Object a = this.a;
            synchronized (a) {
                if (this.b != null) {
                    this.b.cancel();
                    this.b = null;
                }
            }
        }
        return (List<i2>)o;
    }
    
    public void b(final v0 v0) {
        if (this.d.isEmpty()) {
            this.e.getLogger().a(l4.INFO, "No collector found. Performance stats will not be captured during transactions.", new Object[0]);
            return;
        }
        if (!this.c.containsKey((Object)v0.f().toString())) {
            this.c.put((Object)v0.f().toString(), (Object)new ArrayList());
            try {
                this.e.getExecutorService().b((Runnable)new k(this, v0), 30000L);
            }
            catch (final RejectedExecutionException ex) {
                this.e.getLogger().d(l4.ERROR, "Failed to call the executor. Performance collector will not be automatically finished. Did you call Sentry.close()?", (Throwable)ex);
            }
        }
        if (!this.f.getAndSet(true)) {
            final Object a = this.a;
            synchronized (a) {
                if (this.b == null) {
                    this.b = new Timer(true);
                }
                this.b.schedule((TimerTask)new l$a(this), 0L);
                this.b.scheduleAtFixedRate((TimerTask)new l$b(this), 100L, 100L);
            }
        }
    }
    
    public void close() {
        this.c.clear();
        this.e.getLogger().a(l4.DEBUG, "stop collecting all performance info for transactions", new Object[0]);
        if (this.f.getAndSet(false)) {
            final Object a = this.a;
            synchronized (a) {
                if (this.b != null) {
                    this.b.cancel();
                    this.b = null;
                }
            }
        }
    }
}
