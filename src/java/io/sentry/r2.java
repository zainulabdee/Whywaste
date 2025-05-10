package io.sentry;

import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Collection;
import io.sentry.util.n;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import io.sentry.protocol.c;
import java.util.Map;
import java.util.Queue;
import java.util.List;
import io.sentry.protocol.l;
import io.sentry.protocol.a0;

public final class r2
{
    private l4 a;
    private v0 b;
    private String c;
    private a0 d;
    private l e;
    private List<String> f;
    private final Queue<e> g;
    private Map<String, String> h;
    private Map<String, Object> i;
    private List<x> j;
    private final q4 k;
    private volatile a5 l;
    private final Object m;
    private final Object n;
    private final Object o;
    private io.sentry.protocol.c p;
    private List<io.sentry.b> q;
    private n2 r;
    
    public r2(q4 k) {
        this.f = (List<String>)new ArrayList();
        this.h = (Map<String, String>)new ConcurrentHashMap();
        this.i = (Map<String, Object>)new ConcurrentHashMap();
        this.j = (List<x>)new CopyOnWriteArrayList();
        this.m = new Object();
        this.n = new Object();
        this.o = new Object();
        this.p = new io.sentry.protocol.c();
        this.q = (List<io.sentry.b>)new CopyOnWriteArrayList();
        k = io.sentry.util.n.c(k, "SentryOptions is required.");
        this.k = k;
        this.g = this.f(k.getMaxBreadcrumbs());
        this.r = new n2();
    }
    
    r2(final r2 r2) {
        this.f = (List<String>)new ArrayList();
        this.h = (Map<String, String>)new ConcurrentHashMap();
        this.i = (Map<String, Object>)new ConcurrentHashMap();
        this.j = (List<x>)new CopyOnWriteArrayList();
        this.m = new Object();
        this.n = new Object();
        this.o = new Object();
        this.p = new io.sentry.protocol.c();
        this.q = (List<io.sentry.b>)new CopyOnWriteArrayList();
        this.b = r2.b;
        this.c = r2.c;
        this.l = r2.l;
        this.k = r2.k;
        this.a = r2.a;
        final a0 d = r2.d;
        final l l = null;
        a0 d2;
        if (d != null) {
            d2 = new a0(d);
        }
        else {
            d2 = null;
        }
        this.d = d2;
        final l e = r2.e;
        l e2 = l;
        if (e != null) {
            e2 = new l(e);
        }
        this.e = e2;
        this.f = (List<String>)new ArrayList((Collection)r2.f);
        this.j = (List<x>)new CopyOnWriteArrayList((Collection)r2.j);
        final Queue<e> g = r2.g;
        int i = 0;
        final e[] array = (e[])((Collection)g).toArray((Object[])new e[0]);
        final Queue<e> f = this.f(r2.k.getMaxBreadcrumbs());
        while (i < array.length) {
            f.add((Object)new e(array[i]));
            ++i;
        }
        this.g = f;
        final Map<String, String> h = r2.h;
        final ConcurrentHashMap h2 = new ConcurrentHashMap();
        for (final Map$Entry map$Entry : h.entrySet()) {
            if (map$Entry != null) {
                ((Map)h2).put((Object)map$Entry.getKey(), (Object)map$Entry.getValue());
            }
        }
        this.h = (Map<String, String>)h2;
        final Map<String, Object> j = r2.i;
        final ConcurrentHashMap k = new ConcurrentHashMap();
        for (final Map$Entry map$Entry2 : j.entrySet()) {
            if (map$Entry2 != null) {
                ((Map)k).put((Object)map$Entry2.getKey(), map$Entry2.getValue());
            }
        }
        this.i = (Map<String, Object>)k;
        this.p = new io.sentry.protocol.c(r2.p);
        this.q = (List<io.sentry.b>)new CopyOnWriteArrayList((Collection)r2.q);
        this.r = new n2(r2.r);
    }
    
    private Queue<e> f(final int n) {
        return (Queue<e>)k5.j((Queue)new f(n));
    }
    
    private e h(final q4.a a, final e e, final io.sentry.a0 a2) {
        e e2 = null;
        try {
            a.a(e, a2);
        }
        finally {
            final Throwable t;
            this.k.getLogger().d(l4.ERROR, "The BeforeBreadcrumbCallback callback threw an exception. Exception details will be added to the breadcrumb.", t);
            e2 = e;
            if (t.getMessage() != null) {
                e.n("sentry:message", (Object)t.getMessage());
                e2 = e;
            }
        }
        return e2;
    }
    
    public void A(final String s, final Object o) {
        ((AbstractMap)this.p).put((Object)s, o);
        final Iterator iterator = this.k.getScopeObservers().iterator();
        while (iterator.hasNext()) {
            ((q0)iterator.next()).l(this.p);
        }
    }
    
    public void B(final String s, final String s2) {
        this.i.put((Object)s, (Object)s2);
        for (final q0 q0 : this.k.getScopeObservers()) {
            q0.d(s, s2);
            q0.j(this.i);
        }
    }
    
    public void C(final n2 r) {
        this.r = r;
    }
    
    public void D(final String s, final String s2) {
        this.h.put((Object)s, (Object)s2);
        for (final q0 q0 : this.k.getScopeObservers()) {
            q0.b(s, s2);
            q0.e(this.h);
        }
    }
    
    public void E(final v0 b) {
        final Object n = this.n;
        synchronized (n) {
            this.b = b;
            for (final q0 q0 : this.k.getScopeObservers()) {
                if (b != null) {
                    q0.k(b.getName());
                    q0.g(((u0)b).i());
                }
                else {
                    q0.k(null);
                    q0.g(null);
                }
            }
        }
    }
    
    public void F(final a0 d) {
        this.d = d;
        final Iterator iterator = this.k.getScopeObservers().iterator();
        while (iterator.hasNext()) {
            ((q0)iterator.next()).h(d);
        }
    }
    
    d G() {
        final Object m = this.m;
        synchronized (m) {
            if (this.l != null) {
                this.l.c();
            }
            final a5 l = this.l;
            final String release = this.k.getRelease();
            final d d = null;
            a5 b = null;
            d d2;
            if (release != null) {
                this.l = new a5(this.k.getDistinctId(), this.d, this.k.getEnvironment(), this.k.getRelease());
                if (l != null) {
                    b = l.b();
                }
                d2 = new d(this.l.b(), b);
            }
            else {
                this.k.getLogger().a(l4.WARNING, "Release is not set on SentryOptions. Session could not be started", new Object[0]);
                d2 = d;
            }
            return d2;
        }
    }
    
    public n2 H(final a a) {
        final Object o = this.o;
        synchronized (o) {
            a.a(this.r);
            return new n2(this.r);
        }
    }
    
    a5 I(final b b) {
        final Object m = this.m;
        synchronized (m) {
            b.a(this.l);
            a5 b2;
            if (this.l != null) {
                b2 = this.l.b();
            }
            else {
                b2 = null;
            }
            return b2;
        }
    }
    
    public void J(final c c) {
        final Object n = this.n;
        synchronized (n) {
            c.a(this.b);
        }
    }
    
    public void a(final e e, final io.sentry.a0 a0) {
        if (e == null) {
            return;
        }
        io.sentry.a0 a2;
        if ((a2 = a0) == null) {
            a2 = new io.sentry.a0();
        }
        final q4.a beforeBreadcrumb = this.k.getBeforeBreadcrumb();
        e h = e;
        if (beforeBreadcrumb != null) {
            h = this.h(beforeBreadcrumb, e, a2);
        }
        if (h != null) {
            this.g.add((Object)h);
            for (final q0 q0 : this.k.getScopeObservers()) {
                q0.f(h);
                q0.i((Collection<e>)this.g);
            }
        }
        else {
            this.k.getLogger().a(l4.INFO, "Breadcrumb was dropped by beforeBreadcrumb", new Object[0]);
        }
    }
    
    public void b() {
        this.a = null;
        this.d = null;
        this.e = null;
        this.f.clear();
        this.d();
        this.h.clear();
        this.i.clear();
        this.j.clear();
        this.e();
        this.c();
    }
    
    public void c() {
        this.q.clear();
    }
    
    public void d() {
        ((Collection)this.g).clear();
        final Iterator iterator = this.k.getScopeObservers().iterator();
        while (iterator.hasNext()) {
            ((q0)iterator.next()).i((Collection<e>)this.g);
        }
    }
    
    public void e() {
        final Object n = this.n;
        synchronized (n) {
            this.b = null;
            monitorexit(n);
            this.c = null;
            for (final q0 q0 : this.k.getScopeObservers()) {
                q0.k(null);
                q0.g(null);
            }
        }
    }
    
    a5 g() {
        final Object m = this.m;
        synchronized (m) {
            final a5 l = this.l;
            a5 b = null;
            if (l != null) {
                this.l.c();
                b = this.l.b();
                this.l = null;
            }
            return b;
        }
    }
    
    List<io.sentry.b> i() {
        return (List<io.sentry.b>)new CopyOnWriteArrayList((Collection)this.q);
    }
    
    Queue<e> j() {
        return this.g;
    }
    
    public io.sentry.protocol.c k() {
        return this.p;
    }
    
    List<x> l() {
        return this.j;
    }
    
    Map<String, Object> m() {
        return this.i;
    }
    
    List<String> n() {
        return this.f;
    }
    
    public l4 o() {
        return this.a;
    }
    
    public n2 p() {
        return this.r;
    }
    
    public l q() {
        return this.e;
    }
    
    public a5 r() {
        return this.l;
    }
    
    public u0 s() {
        final v0 b = this.b;
        if (b != null) {
            final c5 b2 = b.b();
            if (b2 != null) {
                return (u0)b2;
            }
        }
        return (u0)b;
    }
    
    public Map<String, String> t() {
        return io.sentry.util.b.b(this.h);
    }
    
    public v0 u() {
        return this.b;
    }
    
    public String v() {
        final v0 b = this.b;
        String s;
        if (b != null) {
            s = b.getName();
        }
        else {
            s = this.c;
        }
        return s;
    }
    
    public a0 w() {
        return this.d;
    }
    
    public void x(final String s) {
        ((AbstractMap)this.p).remove((Object)s);
    }
    
    public void y(final String s) {
        this.i.remove((Object)s);
        for (final q0 q0 : this.k.getScopeObservers()) {
            q0.c(s);
            q0.j(this.i);
        }
    }
    
    public void z(final String s) {
        this.h.remove((Object)s);
        for (final q0 q0 : this.k.getScopeObservers()) {
            q0.a(s);
            q0.e(this.h);
        }
    }
    
    public interface a
    {
        void a(final n2 p0);
    }
    
    interface b
    {
        void a(final a5 p0);
    }
    
    public interface c
    {
        void a(final v0 p0);
    }
    
    static final class d
    {
        private final a5 a;
        private final a5 b;
        
        public d(final a5 b, final a5 a) {
            this.b = b;
            this.a = a;
        }
        
        public a5 a() {
            return this.b;
        }
        
        public a5 b() {
            return this.a;
        }
    }
}
