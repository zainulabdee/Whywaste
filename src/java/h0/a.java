package h0;

import android.os.Parcel;
import android.os.Parcelable;
import q0.b;
import f0.l;
import android.os.IBinder;

public final class a extends q0.a
{
    a(final IBinder binder) {
        super(binder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }
    
    public final void Z0(final l l) {
        final Parcel j = this.j();
        b.b(j, (Parcelable)l);
        this.n(1, j);
    }
}
