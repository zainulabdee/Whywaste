package io.sentry.android.core;

import android.system.Os;
import android.system.OsConstants;
import io.sentry.g;
import android.os.SystemClock;
import io.sentry.i2;
import java.io.IOException;
import io.sentry.l4;
import io.sentry.util.e;
import io.sentry.util.n;
import io.sentry.n0;
import java.io.File;
import io.sentry.i0;

public final class r implements i0
{
    private long a;
    private long b;
    private long c;
    private long d;
    private final long e;
    private double f;
    private final File g;
    private final n0 h;
    private final l0 i;
    private boolean j;
    
    public r(final n0 n0, final l0 l0) {
        this.a = 0L;
        this.b = 0L;
        this.c = 1L;
        this.d = 1L;
        this.e = 1000000000L;
        this.f = 1.0E9 / 1L;
        this.g = new File("/proc/self/stat");
        this.j = false;
        this.h = (n0)n.c((Object)n0, "Logger is required.");
        this.i = (l0)n.c((Object)l0, "BuildInfoProvider is required.");
    }
    
    private long c() {
        String b;
        try {
            b = io.sentry.util.e.b(this.g);
        }
        catch (final IOException ex) {
            this.j = false;
            this.h.d(l4.WARNING, "Unable to read /proc/self/stat file. Disabling cpu collection.", (Throwable)ex);
            b = null;
        }
        if (b != null) {
            final String[] split = b.trim().split("[\n\t\r ]");
            try {
                return (long)((Long.parseLong(split[13]) + Long.parseLong(split[14]) + Long.parseLong(split[15]) + Long.parseLong(split[16])) * this.f);
            }
            catch (final NumberFormatException ex2) {
                this.h.d(l4.ERROR, "Error parsing /proc/self/stat file.", (Throwable)ex2);
            }
        }
        return 0L;
    }
    
    public void a(final i2 i2) {
        if (this.i.d() >= 21) {
            if (this.j) {
                final long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                final long a = this.a;
                this.a = elapsedRealtimeNanos;
                final long c = this.c();
                final long b = this.b;
                this.b = c;
                i2.a(new g(System.currentTimeMillis(), (c - b) / (double)(elapsedRealtimeNanos - a) / this.d * 100.0));
            }
        }
    }
    
    public void b() {
        if (this.i.d() < 21) {
            this.j = false;
            return;
        }
        this.j = true;
        this.c = Os.sysconf(OsConstants._SC_CLK_TCK);
        this.d = Os.sysconf(OsConstants._SC_NPROCESSORS_CONF);
        this.f = 1.0E9 / this.c;
        this.b = this.c();
    }
}
