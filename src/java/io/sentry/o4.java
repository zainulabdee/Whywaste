package io.sentry;

import java.util.Date;

public final class o4 extends j3
{
    private final Date e;
    private final long f;
    
    public o4() {
        this(j.c(), System.nanoTime());
    }
    
    public o4(final Date e, final long f) {
        this.e = e;
        this.f = f;
    }
    
    private long j(final o4 o4, final o4 o5) {
        return o4.i() + (o5.f - o4.f);
    }
    
    public int d(final j3 j3) {
        if (!(j3 instanceof o4)) {
            return super.d(j3);
        }
        final o4 o4 = (o4)j3;
        final long time = this.e.getTime();
        final long time2 = o4.e.getTime();
        if (time == time2) {
            return Long.valueOf(this.f).compareTo(Long.valueOf(o4.f));
        }
        return Long.valueOf(time).compareTo(Long.valueOf(time2));
    }
    
    public long e(final j3 j3) {
        if (j3 instanceof o4) {
            return this.f - ((o4)j3).f;
        }
        return super.e(j3);
    }
    
    public long h(final j3 j3) {
        if (j3 == null || !(j3 instanceof o4)) {
            return super.h(j3);
        }
        final o4 o4 = (o4)j3;
        if (this.d(j3) < 0) {
            return this.j(this, o4);
        }
        return this.j(o4, this);
    }
    
    public long i() {
        return j.a(this.e);
    }
}
