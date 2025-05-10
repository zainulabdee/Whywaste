package io.sentry;

public abstract class j3 implements Comparable<j3>
{
    public int d(final j3 j3) {
        return Long.valueOf(this.i()).compareTo(Long.valueOf(j3.i()));
    }
    
    public long e(final j3 j3) {
        return this.i() - j3.i();
    }
    
    public final boolean f(final j3 j3) {
        return this.e(j3) > 0L;
    }
    
    public final boolean g(final j3 j3) {
        return this.e(j3) < 0L;
    }
    
    public long h(final j3 j3) {
        if (j3 != null && this.d(j3) < 0) {
            return j3.i();
        }
        return this.i();
    }
    
    public abstract long i();
}
