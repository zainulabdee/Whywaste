package e0;

import java.lang.ref.Reference;
import java.util.Map$Entry;
import android.content.Intent;
import java.util.Iterator;
import java.io.PrintWriter;
import java.io.FileDescriptor;
import r0.d;
import android.os.Looper;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.lang.ref.WeakReference;
import android.app.Activity;
import java.util.Collections;
import f.a;
import android.os.Bundle;
import java.util.Map;
import java.util.WeakHashMap;
import android.app.Fragment;

public final class g0 extends Fragment implements f
{
    private static final WeakHashMap h;
    private final Map e;
    private int f;
    private Bundle g;
    
    static {
        h = new WeakHashMap();
    }
    
    public g0() {
        this.e = Collections.synchronizedMap((Map)new a());
        this.f = 0;
    }
    
    public static g0 f(final Activity activity) {
        final WeakHashMap h = g0.h;
        final WeakReference weakReference = (WeakReference)h.get((Object)activity);
        if (weakReference != null) {
            final g0 g0 = (g0)((Reference)weakReference).get();
            if (g0 != null) {
                return g0;
            }
        }
        try {
            final g0 g2 = (g0)activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
            g0 g3 = null;
            Label_0085: {
                if (g2 != null) {
                    g3 = g2;
                    if (!g2.isRemoving()) {
                        break Label_0085;
                    }
                }
                g3 = new g0();
                activity.getFragmentManager().beginTransaction().add((Fragment)g3, "LifecycleFragmentImpl").commitAllowingStateLoss();
            }
            h.put((Object)activity, (Object)new WeakReference((Object)g3));
            return g3;
        }
        catch (final ClassCastException ex) {
            throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", (Throwable)ex);
        }
    }
    
    public final void b(final String s, final LifecycleCallback lifecycleCallback) {
        if (!this.e.containsKey((Object)s)) {
            this.e.put((Object)s, (Object)lifecycleCallback);
            if (this.f > 0) {
                new d(Looper.getMainLooper()).post((Runnable)new f0(this, lifecycleCallback, s));
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
        return clazz.cast(this.e.get((Object)s));
    }
    
    public final Activity d() {
        return this.getActivity();
    }
    
    public final void dump(final String s, final FileDescriptor fileDescriptor, final PrintWriter printWriter, final String[] array) {
        super.dump(s, fileDescriptor, printWriter, array);
        final Iterator iterator = this.e.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).a(s, fileDescriptor, printWriter, array);
        }
    }
    
    public final void onActivityResult(final int n, final int n2, final Intent intent) {
        super.onActivityResult(n, n2, intent);
        final Iterator iterator = this.e.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).e(n, n2, intent);
        }
    }
    
    public final void onCreate(final Bundle g) {
        super.onCreate(g);
        this.f = 1;
        this.g = g;
        for (final Map$Entry map$Entry : this.e.entrySet()) {
            final LifecycleCallback lifecycleCallback = (LifecycleCallback)map$Entry.getValue();
            Bundle bundle;
            if (g != null) {
                bundle = g.getBundle((String)map$Entry.getKey());
            }
            else {
                bundle = null;
            }
            lifecycleCallback.f(bundle);
        }
    }
    
    public final void onDestroy() {
        super.onDestroy();
        this.f = 5;
        final Iterator iterator = this.e.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).g();
        }
    }
    
    public final void onResume() {
        super.onResume();
        this.f = 3;
        final Iterator iterator = this.e.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).h();
        }
    }
    
    public final void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (final Map$Entry map$Entry : this.e.entrySet()) {
            final Bundle bundle2 = new Bundle();
            ((LifecycleCallback)map$Entry.getValue()).i(bundle2);
            bundle.putBundle((String)map$Entry.getKey(), bundle2);
        }
    }
    
    public final void onStart() {
        super.onStart();
        this.f = 2;
        final Iterator iterator = this.e.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).j();
        }
    }
    
    public final void onStop() {
        super.onStop();
        this.f = 4;
        final Iterator iterator = this.e.values().iterator();
        while (iterator.hasNext()) {
            ((LifecycleCallback)iterator.next()).k();
        }
    }
}
