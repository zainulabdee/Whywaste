package e0;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

final class h0 implements Runnable
{
    final LifecycleCallback e;
    final String f;
    final i0 g;
    
    h0(final i0 g, final LifecycleCallback e, final String f) {
        this.g = g;
        this.e = e;
        this.f = f;
    }
    
    public final void run() {
        final i0 g = this.g;
        if (i0.I1(g) > 0) {
            final LifecycleCallback e = this.e;
            Bundle bundle;
            if (i0.J1(g) != null) {
                bundle = i0.J1(g).getBundle(this.f);
            }
            else {
                bundle = null;
            }
            e.f(bundle);
        }
        if (i0.I1(this.g) >= 2) {
            this.e.j();
        }
        if (i0.I1(this.g) >= 3) {
            this.e.h();
        }
        if (i0.I1(this.g) >= 4) {
            this.e.k();
        }
        if (i0.I1(this.g) >= 5) {
            this.e.g();
        }
    }
}
