package io.flutter.embedding.android;

import android.os.BaseBundle;
import io.flutter.embedding.engine.g;
import io.flutter.plugin.platform.f$d;
import androidx.lifecycle.f$a;
import android.content.Intent;
import java.util.List;
import android.content.Context;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.res.Resources$NotFoundException;
import f1.b;
import androidx.core.content.res.a;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.os.Build$VERSION;
import b2.i;
import android.window.OnBackInvokedCallback;
import androidx.lifecycle.l;
import androidx.lifecycle.k;
import android.app.Activity;

public class d extends Activity implements e$c, k
{
    public static final int h;
    protected e e;
    private l f;
    private final OnBackInvokedCallback g;
    
    static {
        h = i.d(61938);
    }
    
    public d() {
        Object g;
        if (Build$VERSION.SDK_INT >= 33) {
            g = new d$a(this);
        }
        else {
            g = null;
        }
        this.g = (OnBackInvokedCallback)g;
        this.f = new l((k)this);
    }
    
    private void E() {
        final Window window = this.getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(1073741824);
        window.getDecorView().setSystemUiVisibility(1280);
    }
    
    private void F() {
        if (this.H() == io.flutter.embedding.android.f.f) {
            this.getWindow().setBackgroundDrawable((Drawable)new ColorDrawable(0));
        }
    }
    
    private View G() {
        return this.e.s((LayoutInflater)null, (ViewGroup)null, (Bundle)null, d.h, this.y() == c0.e);
    }
    
    private Drawable K() {
        final Drawable drawable = null;
        try {
            final Bundle j = this.J();
            int int1;
            if (j != null) {
                int1 = ((BaseBundle)j).getInt("io.flutter.embedding.android.SplashScreenDrawable");
            }
            else {
                int1 = 0;
            }
            Drawable a = drawable;
            if (int1 != 0) {
                a = androidx.core.content.res.a.a(((Context)this).getResources(), int1, ((Context)this).getTheme());
            }
            return a;
        }
        catch (final Resources$NotFoundException ex) {
            b.b("FlutterActivity", "Splash screen not found. Ensure the drawable exists and that it's valid.");
            throw ex;
        }
        catch (final PackageManager$NameNotFoundException ex2) {
            return drawable;
        }
    }
    
    private boolean L() {
        return (((Context)this).getApplicationInfo().flags & 0x2) != 0x0;
    }
    
    private boolean O(final String s) {
        final e e = this.e;
        if (e == null) {
            final StringBuilder sb = new StringBuilder();
            sb.append("FlutterActivity ");
            sb.append(this.hashCode());
            sb.append(" ");
            sb.append(s);
            sb.append(" called after release.");
            b.g("FlutterActivity", sb.toString());
            return false;
        }
        if (!e.m()) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("FlutterActivity ");
            sb2.append(this.hashCode());
            sb2.append(" ");
            sb2.append(s);
            sb2.append(" called after detach.");
            b.g("FlutterActivity", sb2.toString());
            return false;
        }
        return true;
    }
    
    private void P() {
        try {
            final Bundle j = this.J();
            if (j != null) {
                final int int1 = ((BaseBundle)j).getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (int1 != -1) {
                    ((Context)this).setTheme(int1);
                }
            }
            else {
                b.f("FlutterActivity", "Using the launch theme as normal theme.");
            }
        }
        catch (final PackageManager$NameNotFoundException ex) {
            b.b("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }
    
    public io.flutter.embedding.engine.a A(final Context context) {
        return null;
    }
    
    public f0 B() {
        f0 f0;
        if (this.H() == io.flutter.embedding.android.f.e) {
            f0 = io.flutter.embedding.android.f0.e;
        }
        else {
            f0 = io.flutter.embedding.android.f0.f;
        }
        return f0;
    }
    
    public void C(final io.flutter.embedding.android.l l) {
    }
    
    public void D(final io.flutter.embedding.engine.a a) {
        if (this.e.n()) {
            return;
        }
        q1.a.a(a);
    }
    
    protected f H() {
        if (this.getIntent().hasExtra("background_mode")) {
            return io.flutter.embedding.android.f.valueOf(this.getIntent().getStringExtra("background_mode"));
        }
        return io.flutter.embedding.android.f.e;
    }
    
    protected io.flutter.embedding.engine.a I() {
        return this.e.l();
    }
    
    protected Bundle J() {
        return ((Context)this).getPackageManager().getActivityInfo(this.getComponentName(), 128).metaData;
    }
    
    public void M() {
        if (Build$VERSION.SDK_INT >= 33) {
            this.getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.g);
        }
    }
    
    public void N() {
        this.Q();
        final e e = this.e;
        if (e != null) {
            e.G();
            this.e = null;
        }
    }
    
    public void Q() {
        if (Build$VERSION.SDK_INT >= 33) {
            this.getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.g);
        }
    }
    
    public androidx.lifecycle.f a() {
        return (androidx.lifecycle.f)this.f;
    }
    
    public boolean b() {
        return false;
    }
    
    public void c() {
    }
    
    public Activity d() {
        return this;
    }
    
    public void e() {
        final StringBuilder sb = new StringBuilder();
        sb.append("FlutterActivity ");
        sb.append((Object)this);
        sb.append(" connection to the engine ");
        sb.append((Object)this.I());
        sb.append(" evicted by another attaching activity");
        b.g("FlutterActivity", sb.toString());
        final e e = this.e;
        if (e != null) {
            e.t();
            this.e.u();
        }
    }
    
    public void f() {
        if (Build$VERSION.SDK_INT >= 29) {
            this.reportFullyDrawn();
        }
    }
    
    public String g() {
        return this.getIntent().getStringExtra("cached_engine_group_id");
    }
    
    public Context getContext() {
        return (Context)this;
    }
    
    public String h() {
        if (this.getIntent().hasExtra("route")) {
            return this.getIntent().getStringExtra("route");
        }
        final String s = null;
        try {
            final Bundle j = this.J();
            String string = s;
            if (j != null) {
                string = ((BaseBundle)j).getString("io.flutter.InitialRoute");
            }
            return string;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            return s;
        }
    }
    
    public List<String> k() {
        return (List<String>)this.getIntent().getSerializableExtra("dart_entrypoint_args");
    }
    
    public boolean l() {
        return true;
    }
    
    public boolean m() {
        boolean b = this.getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        if (this.o() == null) {
            if (this.e.n()) {
                b = b;
            }
            else {
                b = this.getIntent().getBooleanExtra("destroy_engine_with_activity", true);
            }
        }
        return b;
    }
    
    public boolean n() {
        return true;
    }
    
    public String o() {
        return this.getIntent().getStringExtra("cached_engine_id");
    }
    
    protected void onActivityResult(final int n, final int n2, final Intent intent) {
        if (this.O("onActivityResult")) {
            this.e.p(n, n2, intent);
        }
    }
    
    public void onBackPressed() {
        if (this.O("onBackPressed")) {
            this.e.r();
        }
    }
    
    protected void onCreate(final Bundle bundle) {
        this.P();
        super.onCreate(bundle);
        (this.e = new e((e$c)this)).q((Context)this);
        this.e.z(bundle);
        this.f.h(f$a.ON_CREATE);
        this.M();
        this.F();
        this.setContentView(this.G());
        this.E();
    }
    
    protected void onDestroy() {
        super.onDestroy();
        if (this.O("onDestroy")) {
            this.e.t();
            this.e.u();
        }
        this.N();
        this.f.h(f$a.ON_DESTROY);
    }
    
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        if (this.O("onNewIntent")) {
            this.e.v(intent);
        }
    }
    
    protected void onPause() {
        super.onPause();
        if (this.O("onPause")) {
            this.e.w();
        }
        this.f.h(f$a.ON_PAUSE);
    }
    
    public void onPostResume() {
        super.onPostResume();
        if (this.O("onPostResume")) {
            this.e.x();
        }
    }
    
    public void onRequestPermissionsResult(final int n, final String[] array, final int[] array2) {
        if (this.O("onRequestPermissionsResult")) {
            this.e.y(n, array, array2);
        }
    }
    
    protected void onResume() {
        super.onResume();
        this.f.h(f$a.ON_RESUME);
        if (this.O("onResume")) {
            this.e.A();
        }
    }
    
    protected void onSaveInstanceState(final Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.O("onSaveInstanceState")) {
            this.e.B(bundle);
        }
    }
    
    protected void onStart() {
        super.onStart();
        this.f.h(f$a.ON_START);
        if (this.O("onStart")) {
            this.e.C();
        }
    }
    
    protected void onStop() {
        super.onStop();
        if (this.O("onStop")) {
            this.e.D();
        }
        this.f.h(f$a.ON_STOP);
    }
    
    public void onTrimMemory(final int n) {
        super.onTrimMemory(n);
        if (this.O("onTrimMemory")) {
            this.e.E(n);
        }
    }
    
    public void onUserLeaveHint() {
        if (this.O("onUserLeaveHint")) {
            this.e.F();
        }
    }
    
    public boolean p() {
        if (this.getIntent().hasExtra("enable_state_restoration")) {
            return this.getIntent().getBooleanExtra("enable_state_restoration", false);
        }
        return this.o() == null;
    }
    
    public String q() {
        String s = "main";
        if (this.getIntent().hasExtra("dart_entrypoint")) {
            return this.getIntent().getStringExtra("dart_entrypoint");
        }
        try {
            final Bundle j = this.J();
            String string;
            if (j != null) {
                string = ((BaseBundle)j).getString("io.flutter.Entrypoint");
            }
            else {
                string = null;
            }
            if (string != null) {
                s = string;
            }
            return s;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            return s;
        }
    }
    
    public void r(final io.flutter.embedding.engine.a a) {
    }
    
    public String s() {
        final String s = null;
        try {
            final Bundle j = this.J();
            String string = s;
            if (j != null) {
                string = ((BaseBundle)j).getString("io.flutter.EntrypointUri");
            }
            return string;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            return s;
        }
    }
    
    public io.flutter.plugin.platform.f t(final Activity activity, final io.flutter.embedding.engine.a a) {
        return new io.flutter.plugin.platform.f(this.d(), a.n(), (f$d)this);
    }
    
    public void u(final io.flutter.embedding.android.k k) {
    }
    
    public String v() {
        if (this.L() && "android.intent.action.RUN".equals((Object)this.getIntent().getAction())) {
            final String dataString = this.getIntent().getDataString();
            if (dataString != null) {
                return dataString;
            }
        }
        return null;
    }
    
    public boolean w() {
        final boolean b = false;
        try {
            final Bundle j = this.J();
            boolean boolean1 = b;
            if (j != null) {
                boolean1 = j.getBoolean("flutter_deeplinking_enabled");
            }
            return boolean1;
        }
        catch (final PackageManager$NameNotFoundException ex) {
            return b;
        }
    }
    
    public g x() {
        return io.flutter.embedding.engine.g.a(this.getIntent());
    }
    
    public c0 y() {
        c0 c0;
        if (this.H() == io.flutter.embedding.android.f.e) {
            c0 = io.flutter.embedding.android.c0.e;
        }
        else {
            c0 = io.flutter.embedding.android.c0.f;
        }
        return c0;
    }
    
    public e0 z() {
        final Drawable k = this.K();
        if (k != null) {
            return (e0)new io.flutter.embedding.android.b(k);
        }
        return null;
    }
}
