package e0;

import android.os.Handler;
import java.lang.ref.Reference;
import android.content.Intent;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import android.app.Activity;
import android.os.Looper;
import java.util.Map$Entry;
import java.util.Iterator;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.lang.ref.WeakReference;
import androidx.fragment.app.d;
import java.util.Collections;
import f.a;
import android.os.Bundle;
import java.util.Map;
import java.util.WeakHashMap;
import androidx.fragment.app.Fragment;

public final class i0 extends Fragment implements f
{
    private static final WeakHashMap f0;
    private final Map c0;
    private int d0;
    private Bundle e0;
    
    static {
        f0 = new WeakHashMap();
    }
    
    public i0() {
        this.c0 = Collections.synchronizedMap((Map)new a());
        this.d0 = 0;
    }
    
    public static i0 K1(final d d) {
        final WeakHashMap f0 = i0.f0;
        final WeakReference weakReference = (WeakReference)f0.get((Object)d);
        if (weakReference != null) {
            final i0 i0 = (i0)((Reference)weakReference).get();
            if (i0 != null) {
                return i0;
            }
        }
        try {
            final i0 i2 = (i0)d.x().c("SupportLifecycleFragmentImpl");
            i0 i3 = null;
            Label_0085: {
                if (i2 != null) {
                    i3 = i2;
                    if (!i2.b0()) {
                        break Label_0085;
                    }
                }
                i3 = new i0();
                d.x().a().b((Fragment)i3, "SupportLifecycleFragmentImpl").e();
            }
            f0.put((Object)d, (Object)new WeakReference((Object)i3));
            return i3;
        }
        catch (final ClassCastException ex) {
            throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", (Throwable)ex);
        }
    }
    
    public final void H0() {
        super.H0();
        this.d0 = 3;
        final Iterator iterator = this.c0.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).h();
        }
    }
    
    public final void I0(final Bundle bundle) {
        super.I0(bundle);
        if (bundle == null) {
            return;
        }
        for (final Map$Entry map$Entry : this.c0.entrySet()) {
            final Bundle bundle2 = new Bundle();
            ((LifecycleCallback)map$Entry.getValue()).i(bundle2);
            bundle.putBundle((String)map$Entry.getKey(), bundle2);
        }
    }
    
    public final void J0() {
        super.J0();
        this.d0 = 2;
        final Iterator iterator = this.c0.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).j();
        }
    }
    
    public final void K0() {
        super.K0();
        this.d0 = 4;
        final Iterator iterator = this.c0.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).k();
        }
    }
    
    public final void b(final String s, final LifecycleCallback lifecycleCallback) {
        if (!this.c0.containsKey((Object)s)) {
            this.c0.put((Object)s, (Object)lifecycleCallback);
            if (this.d0 > 0) {
                ((Handler)new r0.d(Looper.getMainLooper())).post((Runnable)new h0(this, lifecycleCallback, s));
            }
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("LifecycleCallback with tag ");
        sb.append(s);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public final <T extends LifecycleCallback> T c(final String s, final Class<T> clazz) {
        return clazz.cast(this.c0.get((Object)s));
    }
    
    public final void g(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.g(s, fileDescriptor, printWriter, array);
        final Iterator iterator = this.c0.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).a(s, fileDescriptor, printWriter, array);
        }
    }
    
    public final void h0(final int n, final int n2, final Intent intent) {
        super.h0(n, n2, intent);
        final Iterator iterator = this.c0.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).e(n, n2, intent);
        }
    }
    
    public final void m0(final Bundle e0) {
        super.m0(e0);
        this.d0 = 1;
        this.e0 = e0;
        for (final Map$Entry map$Entry : this.c0.entrySet()) {
            final LifecycleCallback lifecycleCallback = (LifecycleCallback)map$Entry.getValue();
            Bundle bundle;
            if (e0 != null) {
                bundle = e0.getBundle((String)map$Entry.getKey());
            }
            else {
                bundle = null;
            }
            lifecycleCallback.f(bundle);
        }
    }
    
    public final void r0() {
        super.r0();
        this.d0 = 5;
        final Iterator iterator = this.c0.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).g();
        }
    }
}
