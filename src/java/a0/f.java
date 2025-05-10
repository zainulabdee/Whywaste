package a0;

import k.b;
import java.util.Iterator;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import android.content.Context;
import java.util.Set;
import java.util.concurrent.Semaphore;
import e0.l;
import k.a;

public final class f extends a implements l
{
    private final Semaphore p;
    private final Set q;
    
    public f(final Context context, final Set q) {
        super(context);
        this.p = new Semaphore(0);
        this.q = q;
    }
    
    protected final void o() {
        this.p.drainPermits();
        ((b)this).h();
    }
}
