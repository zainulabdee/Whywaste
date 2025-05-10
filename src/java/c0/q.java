package c0;

import android.util.Log;
import android.os.Message;
import android.os.Looper;
import android.content.Context;
import q0.e;

final class q extends e
{
    private final Context a;
    final g b;
    
    public q(final g b, final Context context) {
        this.b = b;
        Looper looper;
        if (Looper.myLooper() == null) {
            looper = Looper.getMainLooper();
        }
        else {
            looper = Looper.myLooper();
        }
        super(looper);
        this.a = context.getApplicationContext();
    }
    
    public final void handleMessage(final Message message) {
        final int what = message.what;
        if (what != 1) {
            final StringBuilder sb = new StringBuilder(50);
            sb.append("Don't know how to handle this message: ");
            sb.append(what);
            Log.w("GoogleApiAvailability", sb.toString());
            return;
        }
        final int f = this.b.f(this.a);
        if (this.b.i(f)) {
            this.b.n(this.a, f);
        }
    }
}
