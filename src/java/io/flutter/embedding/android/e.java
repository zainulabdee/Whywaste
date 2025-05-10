package io.flutter.embedding.android;

import io.flutter.embedding.engine.g;
import io.flutter.plugin.platform.f$d;
import java.util.Arrays;
import b2.i;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.content.Context;
import android.os.Bundle;
import android.net.Uri;
import android.content.Intent;
import java.util.List;
import g1.a$b;
import io.flutter.embedding.engine.d$b;
import r1.b;
import io.flutter.embedding.engine.d;
import android.view.ViewTreeObserver$OnPreDrawListener;
import io.flutter.plugin.platform.f;
import io.flutter.embedding.engine.a;
import android.app.Activity;

class e implements io.flutter.embedding.android.c<Activity>
{
    private c a;
    private a b;
    r c;
    private f d;
    ViewTreeObserver$OnPreDrawListener e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private Integer j;
    private d k;
    private final b l;
    
    e(final c c) {
        this(c, null);
    }
    
    e(final c a, final d k) {
        this.l = new b() {
            final e a;
            
            @Override
            public void c() {
                this.a.a.c();
                this.a.g = false;
            }
            
            @Override
            public void f() {
                this.a.a.f();
                this.a.g = true;
                this.a.h = true;
            }
        };
        this.a = a;
        this.h = false;
        this.k = k;
    }
    
    private d$b g(final d$b d$b) {
        final String v = this.a.v();
        String f = null;
        Label_0033: {
            if (v != null) {
                f = v;
                if (!v.isEmpty()) {
                    break Label_0033;
                }
            }
            f = f1.a.e().c().f();
        }
        final a$b a$b = new a$b(f, this.a.q());
        String s;
        if ((s = this.a.h()) == null && (s = this.o(this.a.d().getIntent())) == null) {
            s = "/";
        }
        return d$b.i(a$b).k(s).j((List)this.a.k());
    }
    
    private void h(final r r) {
        if (this.a.y() == c0.e) {
            if (this.e != null) {
                ((View)r).getViewTreeObserver().removeOnPreDrawListener(this.e);
            }
            this.e = (ViewTreeObserver$OnPreDrawListener)new e$b(this, r);
            ((View)r).getViewTreeObserver().addOnPreDrawListener(this.e);
            return;
        }
        throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
    }
    
    private void i() {
        if (this.a.o() != null) {
            return;
        }
        if (this.b.i().l()) {
            return;
        }
        String s;
        if ((s = this.a.h()) == null && (s = this.o(this.a.d().getIntent())) == null) {
            s = "/";
        }
        final String s2 = this.a.s();
        final StringBuilder sb = new StringBuilder();
        sb.append("Executing Dart entrypoint: ");
        sb.append(this.a.q());
        sb.append(", library uri: ");
        sb.append(s2);
        String string;
        if (sb.toString() == null) {
            string = "\"\"";
        }
        else {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append(s2);
            sb2.append(", and sending initial route: ");
            sb2.append(s);
            string = sb2.toString();
        }
        f1.b.f("FlutterActivityAndFragmentDelegate", string);
        this.b.m().c(s);
        final String v = this.a.v();
        String f = null;
        Label_0216: {
            if (v != null) {
                f = v;
                if (!v.isEmpty()) {
                    break Label_0216;
                }
            }
            f = f1.a.e().c().f();
        }
        a$b a$b;
        if (s2 == null) {
            a$b = new a$b(f, this.a.q());
        }
        else {
            a$b = new a$b(f, s2, this.a.q());
        }
        this.b.i().j(a$b, this.a.k());
    }
    
    private void j() {
        if (this.a != null) {
            return;
        }
        throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
    }
    
    private String o(final Intent intent) {
        if (this.a.w()) {
            final Uri data = intent.getData();
            if (data != null) {
                final String path = data.getPath();
                if (path != null && !path.isEmpty()) {
                    String string = path;
                    if (data.getQuery() != null) {
                        string = path;
                        if (!data.getQuery().isEmpty()) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append(path);
                            sb.append("?");
                            sb.append(data.getQuery());
                            string = sb.toString();
                        }
                    }
                    String string2 = string;
                    if (data.getFragment() != null) {
                        string2 = string;
                        if (!data.getFragment().isEmpty()) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(string);
                            sb2.append("#");
                            sb2.append(data.getFragment());
                            string2 = sb2.toString();
                        }
                    }
                    return string2;
                }
            }
        }
        return null;
    }
    
    void A() {
        f1.b.f("FlutterActivityAndFragmentDelegate", "onResume()");
        this.j();
        if (this.a.n()) {
            this.b.j().d();
        }
    }
    
    void B(final Bundle bundle) {
        f1.b.f("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        this.j();
        if (this.a.p()) {
            bundle.putByteArray("framework", this.b.r().h());
        }
        if (this.a.l()) {
            final Bundle bundle2 = new Bundle();
            this.b.h().d(bundle2);
            bundle.putBundle("plugins", bundle2);
        }
    }
    
    void C() {
        f1.b.f("FlutterActivityAndFragmentDelegate", "onStart()");
        this.j();
        this.i();
        final Integer j = this.j;
        if (j != null) {
            this.c.setVisibility(j);
        }
    }
    
    void D() {
        f1.b.f("FlutterActivityAndFragmentDelegate", "onStop()");
        this.j();
        if (this.a.n()) {
            this.b.j().c();
        }
        this.j = ((View)this.c).getVisibility();
        this.c.setVisibility(8);
    }
    
    void E(final int n) {
        this.j();
        final a b = this.b;
        if (b != null) {
            if (this.h && n >= 10) {
                b.i().m();
                this.b.u().a();
            }
            this.b.q().m(n);
        }
    }
    
    void F() {
        this.j();
        if (this.b != null) {
            f1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
            this.b.h().e();
        }
        else {
            f1.b.g("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
        }
    }
    
    void G() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
    }
    
    void H() {
        f1.b.f("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
        final String o = this.a.o();
        if (o != null) {
            final a a = io.flutter.embedding.engine.b.b().a(o);
            this.b = a;
            this.f = true;
            if (a != null) {
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '");
            sb.append(o);
            sb.append("'");
            throw new IllegalStateException(sb.toString());
        }
        else {
            final c a2 = this.a;
            if ((this.b = a2.A(a2.getContext())) != null) {
                this.f = true;
                return;
            }
            final String g = this.a.g();
            if (g == null) {
                f1.b.f("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
                d k;
                if ((k = this.k) == null) {
                    k = new d(this.a.getContext(), this.a.x().b());
                }
                this.b = k.a(this.g(new d$b(this.a.getContext()).h(false).l(this.a.p())));
                this.f = false;
                return;
            }
            final d a3 = io.flutter.embedding.engine.e.b().a(g);
            if (a3 != null) {
                this.b = a3.a(this.g(new d$b(this.a.getContext())));
                this.f = false;
                return;
            }
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("The requested cached FlutterEngineGroup did not exist in the FlutterEngineGroupCache: '");
            sb2.append(g);
            sb2.append("'");
            throw new IllegalStateException(sb2.toString());
        }
    }
    
    void I() {
        final f d = this.d;
        if (d != null) {
            d.A();
        }
    }
    
    public void e() {
        if (!this.a.m()) {
            this.a.e();
            return;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("The internal FlutterEngine created by ");
        sb.append((Object)this.a);
        sb.append(" has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
        throw new AssertionError((Object)sb.toString());
    }
    
    public Activity k() {
        final Activity d = this.a.d();
        if (d != null) {
            return d;
        }
        throw new AssertionError((Object)"FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }
    
    a l() {
        return this.b;
    }
    
    boolean m() {
        return this.i;
    }
    
    boolean n() {
        return this.f;
    }
    
    void p(final int n, final int n2, final Intent intent) {
        this.j();
        if (this.b != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Forwarding onActivityResult() to FlutterEngine:\nrequestCode: ");
            sb.append(n);
            sb.append("\nresultCode: ");
            sb.append(n2);
            sb.append("\ndata: ");
            sb.append((Object)intent);
            f1.b.f("FlutterActivityAndFragmentDelegate", sb.toString());
            this.b.h().a(n, n2, intent);
        }
        else {
            f1.b.g("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
        }
    }
    
    void q(final Context context) {
        this.j();
        if (this.b == null) {
            this.H();
        }
        if (this.a.l()) {
            f1.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.b.h().f((io.flutter.embedding.android.c)this, this.a.a());
        }
        final c a = this.a;
        this.d = a.t(a.d(), this.b);
        this.a.D(this.b);
        this.i = true;
    }
    
    void r() {
        this.j();
        if (this.b != null) {
            f1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
            this.b.m().a();
        }
        else {
            f1.b.g("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
        }
    }
    
    View s(final LayoutInflater layoutInflater, final ViewGroup viewGroup, final Bundle bundle, final int id, final boolean b) {
        f1.b.f("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
        this.j();
        final c0 y = this.a.y();
        final c0 e = c0.e;
        boolean opaque = true;
        final boolean b2 = true;
        if (y == e) {
            final k k = new k(this.a.getContext(), this.a.B() == f0.f && b2);
            this.a.u(k);
            this.c = new r(this.a.getContext(), k);
        }
        else {
            final l l = new l(this.a.getContext());
            if (this.a.B() != f0.e) {
                opaque = false;
            }
            l.setOpaque(opaque);
            this.a.C(l);
            this.c = new r(this.a.getContext(), l);
        }
        this.c.m(this.l);
        f1.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
        this.c.o(this.b);
        ((View)this.c).setId(id);
        final e0 z = this.a.z();
        if (z != null) {
            f1.b.g("FlutterActivityAndFragmentDelegate", "A splash screen was provided to Flutter, but this is deprecated. See flutter.dev/go/android-splash-migration for migration steps.");
            final FlutterSplashView flutterSplashView = new FlutterSplashView(this.a.getContext());
            ((View)flutterSplashView).setId(b2.i.d(486947586));
            flutterSplashView.g(this.c, z);
            return (View)flutterSplashView;
        }
        if (b) {
            this.h(this.c);
        }
        return (View)this.c;
    }
    
    void t() {
        f1.b.f("FlutterActivityAndFragmentDelegate", "onDestroyView()");
        this.j();
        if (this.e != null) {
            ((View)this.c).getViewTreeObserver().removeOnPreDrawListener(this.e);
            this.e = null;
        }
        this.c.t();
        this.c.B(this.l);
    }
    
    void u() {
        f1.b.f("FlutterActivityAndFragmentDelegate", "onDetach()");
        this.j();
        this.a.r(this.b);
        if (this.a.l()) {
            f1.b.f("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
            if (this.a.d().isChangingConfigurations()) {
                this.b.h().g();
            }
            else {
                this.b.h().i();
            }
        }
        final f d = this.d;
        if (d != null) {
            d.o();
            this.d = null;
        }
        if (this.a.n()) {
            this.b.j().a();
        }
        if (this.a.m()) {
            this.b.f();
            if (this.a.o() != null) {
                io.flutter.embedding.engine.b.b().d(this.a.o());
            }
            this.b = null;
        }
        this.i = false;
    }
    
    void v(final Intent intent) {
        this.j();
        if (this.b != null) {
            f1.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRouteInformation message.");
            this.b.h().b(intent);
            final String o = this.o(intent);
            if (o != null && !o.isEmpty()) {
                this.b.m().b(o);
            }
        }
        else {
            f1.b.g("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
        }
    }
    
    void w() {
        f1.b.f("FlutterActivityAndFragmentDelegate", "onPause()");
        this.j();
        if (this.a.n()) {
            this.b.j().b();
        }
    }
    
    void x() {
        f1.b.f("FlutterActivityAndFragmentDelegate", "onPostResume()");
        this.j();
        if (this.b != null) {
            this.I();
        }
        else {
            f1.b.g("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
        }
    }
    
    void y(final int n, final String[] array, final int[] array2) {
        this.j();
        if (this.b != null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: ");
            sb.append(n);
            sb.append("\npermissions: ");
            sb.append(Arrays.toString((Object[])array));
            sb.append("\ngrantResults: ");
            sb.append(Arrays.toString(array2));
            f1.b.f("FlutterActivityAndFragmentDelegate", sb.toString());
            this.b.h().onRequestPermissionsResult(n, array, array2);
        }
        else {
            f1.b.g("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
        }
    }
    
    void z(final Bundle bundle) {
        f1.b.f("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        this.j();
        final byte[] array = null;
        Bundle bundle2;
        byte[] byteArray;
        if (bundle != null) {
            bundle2 = bundle.getBundle("plugins");
            byteArray = bundle.getByteArray("framework");
        }
        else {
            bundle2 = null;
            byteArray = array;
        }
        if (this.a.p()) {
            this.b.r().j(byteArray);
        }
        if (this.a.l()) {
            this.b.h().c(bundle2);
        }
    }
    
    interface c extends f$d
    {
        a A(final Context p0);
        
        f0 B();
        
        void C(final l p0);
        
        void D(final a p0);
        
        androidx.lifecycle.f a();
        
        void c();
        
        Activity d();
        
        void e();
        
        void f();
        
        String g();
        
        Context getContext();
        
        String h();
        
        List<String> k();
        
        boolean l();
        
        boolean m();
        
        boolean n();
        
        String o();
        
        boolean p();
        
        String q();
        
        void r(final a p0);
        
        String s();
        
        f t(final Activity p0, final a p1);
        
        void u(final k p0);
        
        String v();
        
        boolean w();
        
        g x();
        
        c0 y();
        
        e0 z();
    }
}
