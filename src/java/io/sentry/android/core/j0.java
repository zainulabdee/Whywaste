package io.sentry.android.core;

import android.os.SystemClock;
import io.sentry.n4;
import io.sentry.j;
import io.sentry.j3;

public final class j0
{
    private static j0 e;
    private Long a;
    private Long b;
    private Boolean c;
    private j3 d;
    
    static {
        j0.e = new j0();
    }
    
    private j0() {
        this.c = null;
    }
    
    public static j0 e() {
        return j0.e;
    }
    
    public j3 a() {
        final j3 d = this.d();
        if (d != null) {
            final Long b = this.b();
            if (b != null) {
                return (j3)new n4(d.i() + j.h(b));
            }
        }
        return null;
    }
    
    public Long b() {
        synchronized (this) {
            if (this.a != null) {
                final Long b = this.b;
                if (b != null) {
                    if (this.c != null) {
                        final long n = b - this.a;
                        if (n >= 60000L) {
                            return null;
                        }
                        monitorexit(this);
                        return n;
                    }
                }
            }
            return null;
        }
    }
    
    public Long c() {
        return this.a;
    }
    
    public j3 d() {
        return this.d;
    }
    
    public Boolean f() {
        return this.c;
    }
    
    void g() {
        synchronized (this) {
            this.h(SystemClock.uptimeMillis());
        }
    }
    
    void h(final long n) {
        this.b = n;
    }
    
    void i(final long n, final j3 d) {
        synchronized (this) {
            if (this.d != null && this.a != null) {
                return;
            }
            this.d = d;
            this.a = n;
        }
    }
    
    void j(final boolean b) {
        synchronized (this) {
            if (this.c != null) {
                return;
            }
            this.c = b;
        }
    }
}
