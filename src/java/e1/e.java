package e1;

import dev.fluttercommunity.plus.share.SharePlusPendingIntent;
import android.content.Intent;
import kotlin.jvm.internal.i;
import java.util.concurrent.atomic.AtomicBoolean;
import t1.k;
import android.content.Context;
import t1.m;

public final class e implements m
{
    public static final e.e$a d;
    private final Context a;
    private k.d b;
    private AtomicBoolean c;
    
    static {
        d = new e.e$a((kotlin.jvm.internal.e)null);
    }
    
    public e(final Context a) {
        i.e((Object)a, "context");
        this.a = a;
        this.c = new AtomicBoolean(true);
    }
    
    private final void b(final String s) {
        if (this.c.compareAndSet(false, true)) {
            final k.d b = this.b;
            if (b != null) {
                i.b((Object)b);
                b.a(s);
                this.b = null;
            }
        }
    }
    
    @Override
    public boolean a(final int n, final int n2, final Intent intent) {
        boolean b;
        if (n == 22643) {
            this.b(SharePlusPendingIntent.a.a());
            b = true;
        }
        else {
            b = false;
        }
        return b;
    }
    
    public final boolean c(final k.d b) {
        i.e((Object)b, "callback");
        final AtomicBoolean c = this.c;
        boolean b2 = true;
        if (c.compareAndSet(true, false)) {
            SharePlusPendingIntent.a.b("");
            this.c.set(false);
            this.b = b;
        }
        else {
            b.b("Share callback error", "prior share-sheet did not call back, did you await it? Maybe use non-result variant", null);
            b2 = false;
        }
        return b2;
    }
    
    public final void d() {
        this.b("dev.fluttercommunity.plus/share/unavailable");
    }
}
