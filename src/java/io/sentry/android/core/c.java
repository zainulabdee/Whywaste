package io.sentry.android.core;

import android.os.Debug;
import android.os.SystemClock;
import java.util.Iterator;
import java.util.List;
import android.app.ActivityManager$ProcessErrorStateInfo;
import io.sentry.l4;
import android.app.ActivityManager;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import io.sentry.n0;
import io.sentry.transport.o;

final class c extends Thread
{
    private final boolean e;
    private final a f;
    private final x0 g;
    private final o h;
    private long i;
    private final long j;
    private final n0 k;
    private volatile long l;
    private final AtomicBoolean m;
    private final Context n;
    private final Runnable o;
    
    c(final long n, final boolean b, final a a, final n0 n2, final Context context) {
        this((o)new io.sentry.android.core.a(), n, 500L, b, a, n2, new x0(), context);
    }
    
    c(final o h, final long j, final long i, final boolean e, final a f, final n0 k, final x0 g, final Context n) {
        super("|ANR-WatchDog|");
        this.l = 0L;
        this.m = new AtomicBoolean(false);
        this.h = h;
        this.j = j;
        this.i = i;
        this.e = e;
        this.f = f;
        this.k = k;
        this.g = g;
        this.n = n;
        this.o = (Runnable)new b(this, h);
        if (j >= this.i * 2L) {
            return;
        }
        throw new IllegalArgumentException(String.format("ANRWatchDog: timeoutIntervalMillis has to be at least %d ms", new Object[] { this.i * 2L }));
    }
    
    private boolean c() {
        final ActivityManager activityManager = (ActivityManager)this.n.getSystemService("activity");
        if (activityManager != null) {
            List processesInErrorState = null;
            try {
                processesInErrorState = activityManager.getProcessesInErrorState();
            }
            finally {
                final Throwable t;
                this.k.d(l4.ERROR, "Error getting ActivityManager#getProcessesInErrorState.", t);
            }
            if (processesInErrorState != null) {
                final Iterator iterator = processesInErrorState.iterator();
                while (iterator.hasNext()) {
                    if (((ActivityManager$ProcessErrorStateInfo)iterator.next()).condition == 2) {
                        return true;
                    }
                }
            }
            return false;
        }
        return true;
    }
    
    public void run() {
        this.o.run();
        while (!this.isInterrupted()) {
            this.g.b(this.o);
            try {
                Thread.sleep(this.i);
                if (this.h.a() - this.l <= this.j) {
                    continue;
                }
                if (!this.e && (Debug.isDebuggerConnected() || Debug.waitingForDebugger())) {
                    this.k.a(l4.DEBUG, "An ANR was detected but ignored because the debugger is connected.", new Object[0]);
                    this.m.set(true);
                    continue;
                }
                if (this.c() && this.m.compareAndSet(false, true)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Application Not Responding for at least ");
                    sb.append(this.j);
                    sb.append(" ms.");
                    this.f.a(new ApplicationNotResponding(sb.toString(), this.g.a()));
                    continue;
                }
                continue;
            }
            catch (final InterruptedException ex) {
                try {
                    Thread.currentThread().interrupt();
                    this.k.a(l4.WARNING, "Interrupted: %s", ((Throwable)ex).getMessage());
                    return;
                }
                catch (final SecurityException ex2) {
                    this.k.a(l4.WARNING, "Failed to interrupt due to SecurityException: %s", ((Throwable)ex).getMessage());
                }
            }
            break;
        }
    }
    
    public interface a
    {
        void a(final ApplicationNotResponding p0);
    }
}
