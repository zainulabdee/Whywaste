package io.flutter.plugins.webviewflutter;

import java.lang.ref.Reference;
import android.util.Log;
import android.os.Looper;
import android.os.Handler;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public class c4
{
    private final WeakHashMap<Object, Long> a;
    private final HashMap<Long, WeakReference<Object>> b;
    private final HashMap<Long, Object> c;
    private final ReferenceQueue<Object> d;
    private final HashMap<WeakReference<Object>, Long> e;
    private final Handler f;
    private final a g;
    private long h;
    private boolean i;
    
    private c4(final a g) {
        this.a = (WeakHashMap<Object, Long>)new WeakHashMap();
        this.b = (HashMap<Long, WeakReference<Object>>)new HashMap();
        this.c = (HashMap<Long, Object>)new HashMap();
        this.d = (ReferenceQueue<Object>)new ReferenceQueue();
        this.e = (HashMap<WeakReference<Object>, Long>)new HashMap();
        final Handler f = new Handler(Looper.getMainLooper());
        this.f = f;
        this.h = 65536L;
        this.i = false;
        this.g = g;
        f.postDelayed((Runnable)new b4(this), 3000L);
    }
    
    private void d(final Object o, final long n) {
        if (n < 0L) {
            throw new IllegalArgumentException(String.format("Identifier must be >= 0: %d", new Object[] { n }));
        }
        if (!this.b.containsKey((Object)n)) {
            final WeakReference weakReference = new WeakReference(o, (ReferenceQueue)this.d);
            this.a.put(o, (Object)n);
            this.b.put((Object)n, (Object)weakReference);
            this.e.put((Object)weakReference, (Object)n);
            this.c.put((Object)n, o);
            return;
        }
        throw new IllegalArgumentException(String.format("Identifier has already been added: %d", new Object[] { n }));
    }
    
    public static c4 g(final a a) {
        return new c4(a);
    }
    
    private void k() {
        if (this.j()) {
            Log.w("InstanceManager", "The manager was used after calls to the FinalizationListener have been stopped.");
        }
    }
    
    private void l() {
        if (this.j()) {
            return;
        }
        while (true) {
            final WeakReference weakReference = (WeakReference)this.d.poll();
            if (weakReference == null) {
                break;
            }
            final Long n = (Long)this.e.remove((Object)weakReference);
            if (n == null) {
                continue;
            }
            this.b.remove((Object)n);
            this.c.remove((Object)n);
            this.g.a(n);
        }
        this.f.postDelayed((Runnable)new b4(this), 3000L);
    }
    
    public void b(final Object o, final long n) {
        this.k();
        this.d(o, n);
    }
    
    public long c(final Object o) {
        this.k();
        if (!this.f(o)) {
            final long h = this.h;
            this.h = 1L + h;
            this.d(o, h);
            return h;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Instance of ");
        sb.append((Object)o.getClass());
        sb.append(" has already been added.");
        throw new IllegalArgumentException(sb.toString());
    }
    
    public void e() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
        this.e.clear();
    }
    
    public boolean f(final Object o) {
        this.k();
        return this.a.containsKey(o);
    }
    
    public Long h(final Object o) {
        this.k();
        final Long n = (Long)this.a.get(o);
        if (n != null) {
            this.c.put((Object)n, o);
        }
        return n;
    }
    
    public <T> T i(final long n) {
        this.k();
        final WeakReference weakReference = (WeakReference)this.b.get((Object)n);
        if (weakReference != null) {
            return (T)((Reference)weakReference).get();
        }
        return null;
    }
    
    public boolean j() {
        return this.i;
    }
    
    public <T> T m(final long n) {
        this.k();
        return (T)this.c.remove((Object)n);
    }
    
    public void n() {
        this.f.removeCallbacks((Runnable)new b4(this));
        this.i = true;
    }
    
    public interface a
    {
        void a(final long p0);
    }
}
