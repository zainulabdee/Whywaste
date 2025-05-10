package h0;

import android.os.Bundle;
import android.os.IInterface;
import android.os.IBinder;
import e0.i;
import e0.d;
import f0.b;
import android.os.Looper;
import android.content.Context;
import f0.o;
import com.google.android.gms.common.internal.c;

public final class f extends c<a>
{
    private final o I;
    
    public f(final Context context, final Looper looper, final b b, final o i, final d d, final i j) {
        super(context, looper, 270, b, d, j);
        this.I = i;
    }
    
    protected final String D() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }
    
    protected final String E() {
        return "com.google.android.gms.common.telemetry.service.START";
    }
    
    protected final boolean H() {
        return true;
    }
    
    public final int h() {
        return 203400000;
    }
    
    public final c0.d[] u() {
        return q0.c.b;
    }
    
    protected final Bundle z() {
        return this.I.c();
    }
}
