package io.sentry.android.core;

import android.util.Log;
import io.sentry.l4;
import io.sentry.n0;

public final class t implements n0
{
    private final String a;
    
    public t() {
        this("Sentry");
    }
    
    public t(final String a) {
        this.a = a;
    }
    
    private int e(final l4 l4) {
        final int n = t$a.a[l4.ordinal()];
        if (n == 1) {
            return 4;
        }
        if (n == 2) {
            return 5;
        }
        if (n != 4) {
            return 3;
        }
        return 7;
    }
    
    public void a(final l4 l4, final String s, final Object... array) {
        Log.println(this.e(l4), this.a, String.format(s, array));
    }
    
    public boolean b(final l4 l4) {
        return true;
    }
    
    public void c(final l4 l4, final Throwable t, final String s, final Object... array) {
        this.d(l4, String.format(s, array), t);
    }
    
    public void d(final l4 l4, final String s, final Throwable t) {
        final int n = t$a.a[l4.ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3) {
                    if (n != 4) {
                        Log.d(this.a, s, t);
                    }
                    else {
                        Log.wtf(this.a, s, t);
                    }
                }
                else {
                    Log.e(this.a, s, t);
                }
            }
            else {
                Log.w(this.a, s, t);
            }
        }
        else {
            Log.i(this.a, s, t);
        }
    }
}
