package io.flutter.embedding.engine;

import t1.q;
import t1.n;
import t1.m;
import t1.p;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import android.os.Bundle;
import android.content.Intent;
import java.util.Iterator;
import androidx.lifecycle.f;
import k1.a$a;
import io.flutter.view.s;
import java.util.HashMap;
import i1.d;
import android.content.Context;
import android.content.ContentProvider;
import android.content.BroadcastReceiver;
import android.app.Service;
import android.app.Activity;
import k1.a$b;
import k1.a;
import java.util.Map;
import k1.b;

class c implements k1.b, l1.b
{
    private final Map<Class<? extends a>, a> a;
    private final io.flutter.embedding.engine.a b;
    private final a$b c;
    private final Map<Class<? extends a>, l1.a> d;
    private c<Activity> e;
    private c f;
    private boolean g;
    private final Map<Class<? extends a>, p1.a> h;
    private Service i;
    private final Map<Class<? extends a>, m1.a> j;
    private BroadcastReceiver k;
    private final Map<Class<? extends a>, n1.a> l;
    private ContentProvider m;
    
    c(final Context context, final io.flutter.embedding.engine.a b, final d d, final io.flutter.embedding.engine.d d2) {
        this.a = (Map<Class<? extends a>, a>)new HashMap();
        this.d = (Map<Class<? extends a>, l1.a>)new HashMap();
        this.g = false;
        this.h = (Map<Class<? extends a>, p1.a>)new HashMap();
        this.j = (Map<Class<? extends a>, m1.a>)new HashMap();
        this.l = (Map<Class<? extends a>, n1.a>)new HashMap();
        this.b = b;
        this.c = new a$b(context, b, (t1.c)b.i(), (s)b.q(), b.o().P(), (a$a)new b(d, null), d2);
    }
    
    private void j(final Activity activity, final f f) {
        this.f = new c(activity, f);
        this.b.o().h0(activity.getIntent() != null && activity.getIntent().getBooleanExtra("enable-software-rendering", false));
        this.b.o().B((Context)activity, (s)this.b.q(), this.b.i());
        for (final l1.a a : this.d.values()) {
            if (this.g) {
                a.onReattachedToActivityForConfigChanges((l1.c)this.f);
            }
            else {
                a.onAttachedToActivity((l1.c)this.f);
            }
        }
        this.g = false;
    }
    
    private void l() {
        this.b.o().J();
        this.e = null;
        this.f = null;
    }
    
    private void m() {
        if (this.r()) {
            this.i();
        }
        else if (this.u()) {
            this.p();
        }
        else if (this.s()) {
            this.n();
        }
        else if (this.t()) {
            this.o();
        }
    }
    
    private boolean r() {
        return this.e != null;
    }
    
    private boolean s() {
        return this.k != null;
    }
    
    private boolean t() {
        return this.m != null;
    }
    
    private boolean u() {
        return this.i != null;
    }
    
    public boolean a(final int n, final int n2, final Intent intent) {
        if (this.r()) {
            b2.f.a("FlutterEngineConnectionRegistry#onActivityResult");
            try {
                return this.f.i(n, n2, intent);
            }
            finally {
                b2.f.d();
            }
        }
        f1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
        return false;
    }
    
    public void b(final Intent intent) {
        if (this.r()) {
            b2.f.a("FlutterEngineConnectionRegistry#onNewIntent");
            try {
                this.f.j(intent);
                return;
            }
            finally {
                b2.f.d();
            }
        }
        f1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
    }
    
    public void c(final Bundle bundle) {
        if (this.r()) {
            b2.f.a("FlutterEngineConnectionRegistry#onRestoreInstanceState");
            try {
                this.f.l(bundle);
                return;
            }
            finally {
                b2.f.d();
            }
        }
        f1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
    }
    
    public void d(final Bundle bundle) {
        if (this.r()) {
            b2.f.a("FlutterEngineConnectionRegistry#onSaveInstanceState");
            try {
                this.f.m(bundle);
                return;
            }
            finally {
                b2.f.d();
            }
        }
        f1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
    }
    
    public void e() {
        if (this.r()) {
            b2.f.a("FlutterEngineConnectionRegistry#onUserLeaveHint");
            try {
                this.f.n();
                return;
            }
            finally {
                b2.f.d();
            }
        }
        f1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
    }
    
    public void f(final c<Activity> e, final f f) {
        b2.f.a("FlutterEngineConnectionRegistry#attachToActivity");
        try {
            final c<Activity> e2 = this.e;
            if (e2 != null) {
                e2.e();
            }
            this.m();
            this.e = e;
            this.j((Activity)e.f(), f);
        }
        finally {
            b2.f.d();
        }
    }
    
    public void g() {
        if (this.r()) {
            b2.f.a("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
            try {
                this.g = true;
                final Iterator iterator = this.d.values().iterator();
                while (iterator.hasNext()) {
                    ((l1.a)iterator.next()).onDetachedFromActivityForConfigChanges();
                }
                this.l();
                return;
            }
            finally {
                b2.f.d();
            }
        }
        f1.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
    }
    
    public void h(final a a) {
        final StringBuilder sb = new StringBuilder();
        sb.append("FlutterEngineConnectionRegistry#add ");
        sb.append(a.getClass().getSimpleName());
        b2.f.a(sb.toString());
        try {
            if (this.q(a.getClass())) {
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("Attempted to register plugin (");
                sb2.append((Object)a);
                sb2.append(") but it was already registered with this FlutterEngine (");
                sb2.append((Object)this.b);
                sb2.append(").");
                f1.b.g("FlutterEngineCxnRegstry", sb2.toString());
                return;
            }
            final StringBuilder sb3 = new StringBuilder();
            sb3.append("Adding plugin: ");
            sb3.append((Object)a);
            f1.b.f("FlutterEngineCxnRegstry", sb3.toString());
            this.a.put((Object)a.getClass(), (Object)a);
            a.onAttachedToEngine(this.c);
            if (a instanceof l1.a) {
                final l1.a a2 = (l1.a)a;
                this.d.put((Object)a.getClass(), (Object)a2);
                if (this.r()) {
                    a2.onAttachedToActivity((l1.c)this.f);
                }
            }
            if (a instanceof p1.a) {
                final p1.a a3 = (p1.a)a;
                this.h.put((Object)a.getClass(), (Object)a3);
                if (this.u()) {
                    a3.a(null);
                }
            }
            if (a instanceof m1.a) {
                final m1.a a4 = (m1.a)a;
                this.j.put((Object)a.getClass(), (Object)a4);
                if (this.s()) {
                    a4.b((m1.b)null);
                }
            }
            if (a instanceof n1.a) {
                final n1.a a5 = (n1.a)a;
                this.l.put((Object)a.getClass(), (Object)a5);
                if (this.t()) {
                    a5.b((n1.b)null);
                }
            }
        }
        finally {
            b2.f.d();
        }
    }
    
    public void i() {
        if (this.r()) {
            b2.f.a("FlutterEngineConnectionRegistry#detachFromActivity");
            try {
                final Iterator iterator = this.d.values().iterator();
                while (iterator.hasNext()) {
                    ((l1.a)iterator.next()).onDetachedFromActivity();
                }
                this.l();
                return;
            }
            finally {
                b2.f.d();
            }
        }
        f1.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
    }
    
    public void k() {
        f1.b.f("FlutterEngineCxnRegstry", "Destroying.");
        this.m();
        this.x();
    }
    
    public void n() {
        if (this.s()) {
            b2.f.a("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");
            try {
                final Iterator iterator = this.j.values().iterator();
                while (iterator.hasNext()) {
                    ((m1.a)iterator.next()).a();
                }
                return;
            }
            finally {
                b2.f.d();
            }
        }
        f1.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
    }
    
    public void o() {
        if (this.t()) {
            b2.f.a("FlutterEngineConnectionRegistry#detachFromContentProvider");
            try {
                final Iterator iterator = this.l.values().iterator();
                while (iterator.hasNext()) {
                    ((n1.a)iterator.next()).a();
                }
                return;
            }
            finally {
                b2.f.d();
            }
        }
        f1.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
    }
    
    public boolean onRequestPermissionsResult(final int n, final String[] array, final int[] array2) {
        if (this.r()) {
            b2.f.a("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
            try {
                return this.f.k(n, array, array2);
            }
            finally {
                b2.f.d();
            }
        }
        f1.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
        return false;
    }
    
    public void p() {
        if (this.u()) {
            b2.f.a("FlutterEngineConnectionRegistry#detachFromService");
            try {
                final Iterator iterator = this.h.values().iterator();
                while (iterator.hasNext()) {
                    ((p1.a)iterator.next()).b();
                }
                this.i = null;
                return;
            }
            finally {
                b2.f.d();
            }
        }
        f1.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
    }
    
    public boolean q(final Class<? extends a> clazz) {
        return this.a.containsKey((Object)clazz);
    }
    
    public void v(final Class<? extends a> clazz) {
        final a a = (a)this.a.get((Object)clazz);
        if (a == null) {
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("FlutterEngineConnectionRegistry#remove ");
        sb.append(clazz.getSimpleName());
        b2.f.a(sb.toString());
        try {
            if (a instanceof l1.a) {
                if (this.r()) {
                    ((l1.a)a).onDetachedFromActivity();
                }
                this.d.remove((Object)clazz);
            }
            if (a instanceof p1.a) {
                if (this.u()) {
                    ((p1.a)a).b();
                }
                this.h.remove((Object)clazz);
            }
            if (a instanceof m1.a) {
                if (this.s()) {
                    ((m1.a)a).a();
                }
                this.j.remove((Object)clazz);
            }
            if (a instanceof n1.a) {
                if (this.t()) {
                    ((n1.a)a).a();
                }
                this.l.remove((Object)clazz);
            }
            a.onDetachedFromEngine(this.c);
            this.a.remove((Object)clazz);
        }
        finally {
            b2.f.d();
        }
    }
    
    public void w(final Set<Class<? extends a>> set) {
        final Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            this.v((Class<? extends a>)iterator.next());
        }
    }
    
    public void x() {
        this.w((Set<Class<? extends a>>)new HashSet((Collection)this.a.keySet()));
        this.a.clear();
    }
    
    private static class b implements a$a
    {
        final d a;
        
        private b(final d a) {
            this.a = a;
        }
        
        public String a(final String s) {
            return this.a.h(s);
        }
    }
    
    private static class c implements l1.c
    {
        private final Activity a;
        private final HiddenLifecycleReference b;
        private final Set<p> c;
        private final Set<m> d;
        private final Set<n> e;
        private final Set<q> f;
        private final Set<l1.c$a> g;
        
        public c(final Activity a, final f f) {
            this.c = (Set<p>)new HashSet();
            this.d = (Set<m>)new HashSet();
            this.e = (Set<n>)new HashSet();
            this.f = (Set<q>)new HashSet();
            this.g = (Set<l1.c$a>)new HashSet();
            this.a = a;
            this.b = new HiddenLifecycleReference(f);
        }
        
        public Object a() {
            return this.b;
        }
        
        public void b(final m m) {
            this.d.add((Object)m);
        }
        
        public void c(final p p) {
            this.c.add((Object)p);
        }
        
        public Activity d() {
            return this.a;
        }
        
        public void e(final p p) {
            this.c.remove((Object)p);
        }
        
        public void f(final n n) {
            this.e.remove((Object)n);
        }
        
        public void g(final m m) {
            this.d.remove((Object)m);
        }
        
        public void h(final n n) {
            this.e.add((Object)n);
        }
        
        boolean i(final int n, final int n2, final Intent intent) {
            final Iterator iterator = new HashSet((Collection)this.d).iterator();
            boolean b = false;
        Label_0016:
            while (true) {
                b = false;
                while (iterator.hasNext()) {
                    if (!((m)iterator.next()).a(n, n2, intent) && !b) {
                        continue Label_0016;
                    }
                    b = true;
                }
                break;
            }
            return b;
        }
        
        void j(final Intent intent) {
            final Iterator iterator = this.e.iterator();
            while (iterator.hasNext()) {
                ((n)iterator.next()).b(intent);
            }
        }
        
        boolean k(final int n, final String[] array, final int[] array2) {
            final Iterator iterator = this.c.iterator();
            boolean b = false;
        Label_0011:
            while (true) {
                b = false;
                while (iterator.hasNext()) {
                    if (!((p)iterator.next()).onRequestPermissionsResult(n, array, array2) && !b) {
                        continue Label_0011;
                    }
                    b = true;
                }
                break;
            }
            return b;
        }
        
        void l(final Bundle bundle) {
            final Iterator iterator = this.g.iterator();
            while (iterator.hasNext()) {
                ((l1.c$a)iterator.next()).c(bundle);
            }
        }
        
        void m(final Bundle bundle) {
            final Iterator iterator = this.g.iterator();
            while (iterator.hasNext()) {
                ((l1.c$a)iterator.next()).d(bundle);
            }
        }
        
        void n() {
            final Iterator iterator = this.f.iterator();
            while (iterator.hasNext()) {
                ((q)iterator.next()).e();
            }
        }
    }
}
