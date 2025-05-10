package x1;

import java.util.concurrent.Callable;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions$a;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.Iterator;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import android.content.Intent;
import w0.f;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.UserRecoverableAuthException;
import android.accounts.Account;
import w0.g;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import s.d;
import java.util.Objects;
import java.util.List;
import com.google.android.gms.auth.api.signin.b;
import t1.o;
import k1.a$b;
import android.content.Context;
import android.app.Activity;
import t1.m;
import t1.c;
import k1.a;

public class e implements a, l1.a
{
    private b a;
    private c b;
    private l1.c c;
    
    private void a(final l1.c c) {
        (this.c = c).b((m)this.a);
        this.a.L(c.d());
    }
    
    private void b() {
        this.a = null;
        final c b = this.b;
        if (b != null) {
            x.k(b, (n$b)null);
            this.b = null;
        }
    }
    
    private void c() {
        this.c.g((m)this.a);
        this.a.L(null);
        this.c = null;
    }
    
    public void d(final c b, final Context context, final x1.m m) {
        x.k(this.b = b, (n$b)(this.a = new b(context, m)));
    }
    
    public void onAttachedToActivity(final l1.c c) {
        this.a(c);
    }
    
    public void onAttachedToEngine(final a$b a$b) {
        this.d(a$b.b(), a$b.a(), new x1.m());
    }
    
    public void onDetachedFromActivity() {
        this.c();
    }
    
    public void onDetachedFromActivityForConfigChanges() {
        this.c();
    }
    
    public void onDetachedFromEngine(final a$b a$b) {
        this.b();
    }
    
    public void onReattachedToActivityForConfigChanges(final l1.c c) {
        this.a(c);
    }
    
    public static class b implements m, n$b
    {
        private final Context a;
        private o b;
        private Activity c;
        private final x1.c d;
        private final x1.m e;
        private com.google.android.gms.auth.api.signin.b f;
        private List<String> g;
        private b.e$b$a h;
        
        public b(final Context a, final x1.m e) {
            this.d = new x1.c(1);
            this.a = a;
            this.e = e;
        }
        
        private void A() {
            final n$e c = this.h.c;
            Objects.requireNonNull((Object)c);
            c.a((Object)null);
            this.h = null;
        }
        
        private void B(final n$g n$g) {
            final n$e b = this.h.b;
            Objects.requireNonNull((Object)b);
            b.a((Object)n$g);
            this.h = null;
        }
        
        private void J(final GoogleSignInAccount googleSignInAccount) {
            final n$g$a b = new n$g$a().c(googleSignInAccount.f()).d(googleSignInAccount.j()).e(googleSignInAccount.k()).g(googleSignInAccount.n()).b(googleSignInAccount.e());
            if (googleSignInAccount.l() != null) {
                b.f(googleSignInAccount.l().toString());
            }
            this.B(b.a());
        }
        
        private void K(final g<GoogleSignInAccount> g) {
            try {
                this.J((GoogleSignInAccount)g.h((Class)d0.b.class));
            }
            catch (final f f) {
                this.z("exception", f.toString());
            }
            catch (final d0.b b) {
                this.z(this.x(b.b()), b.toString());
            }
        }
        
        private void r(final String s, final n$e<String> n$e, final Object o) {
            this.v(s, n$e, o);
        }
        
        private void s(final String s, final n$e<Boolean> n$e) {
            this.t(s, null, null, n$e, null, null);
        }
        
        private void t(final String s, final n$e<n$g> n$e, final n$e<Void> n$e2, final n$e<Boolean> n$e3, final n$e<String> n$e4, final Object o) {
            if (this.h == null) {
                this.h = new b.e$b$a(s, (n$e)n$e, (n$e)n$e2, (n$e)n$e3, (n$e)n$e4, o);
                return;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Concurrent operations detected: ");
            sb.append(this.h.a);
            sb.append(", ");
            sb.append(s);
            throw new IllegalStateException(sb.toString());
        }
        
        private void u(final String s, final n$e<n$g> n$e) {
            this.t(s, n$e, null, null, null, null);
        }
        
        private void v(final String s, final n$e<String> n$e, final Object o) {
            this.t(s, null, null, null, n$e, o);
        }
        
        private void w(final String s, final n$e<Void> n$e) {
            this.t(s, null, n$e, null, null, null);
        }
        
        private String x(final int n) {
            if (n == 4) {
                return "sign_in_required";
            }
            if (n == 7) {
                return "network_error";
            }
            if (n != 12501) {
                return "sign_in_failed";
            }
            return "sign_in_canceled";
        }
        
        private void y(final Boolean b) {
            final n$e d = this.h.d;
            Objects.requireNonNull((Object)d);
            d.a((Object)b);
            this.h = null;
        }
        
        private void z(final String s, final String s2) {
            final b.e$b$a h = this.h;
            n$e n$e = h.b;
            if (n$e == null) {
                n$e = h.d;
                if (n$e == null) {
                    n$e = h.e;
                    if (n$e == null) {
                        n$e = h.c;
                    }
                }
            }
            Objects.requireNonNull((Object)n$e);
            n$e.b((Throwable)new n$a(s, s2, (Object)null));
            this.h = null;
        }
        
        public Activity C() {
            final o b = this.b;
            Activity activity;
            if (b != null) {
                activity = b.a();
            }
            else {
                activity = this.c;
            }
            return activity;
        }
        
        public void L(final Activity c) {
            this.c = c;
        }
        
        public boolean a(final int n, final int n2, final Intent intent) {
            final b.e$b$a h = this.h;
            boolean b = false;
            if (h == null) {
                return false;
            }
            switch (n) {
                default: {
                    return false;
                }
                case 53295: {
                    if (n2 == -1) {
                        b = true;
                    }
                    this.y(b);
                    return true;
                }
                case 53294: {
                    if (n2 == -1) {
                        final n$e e = h.e;
                        Objects.requireNonNull((Object)e);
                        final n$e n$e = e;
                        final Object f = this.h.f;
                        Objects.requireNonNull(f);
                        final String s = (String)f;
                        this.h = null;
                        this.g(s, Boolean.FALSE, (n$e<String>)n$e);
                    }
                    else {
                        this.z("failed_to_recover_auth", "Failed attempt to recover authentication");
                    }
                    return true;
                }
                case 53293: {
                    if (intent != null) {
                        this.K((g<GoogleSignInAccount>)com.google.android.gms.auth.api.signin.a.c(intent));
                    }
                    else {
                        this.z("sign_in_failed", "Signin failed");
                    }
                    return true;
                }
            }
        }
        
        public void b(final List<String> list, final n$e<Boolean> n$e) {
            this.s("requestScopes", n$e);
            final GoogleSignInAccount b = this.e.b(this.a);
            if (b == null) {
                this.z("sign_in_required", "No account to grant scopes.");
                return;
            }
            final ArrayList list2 = new ArrayList();
            final Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                final Scope scope = new Scope((String)iterator.next());
                if (!this.e.c(b, scope)) {
                    ((List)list2).add((Object)scope);
                }
            }
            if (((List)list2).isEmpty()) {
                this.y(Boolean.TRUE);
                return;
            }
            this.e.d(this.C(), 53295, b, (Scope[])((List)list2).toArray((Object[])new Scope[0]));
        }
        
        public void c(final n$e<n$g> n$e) {
            this.u("signInSilently", n$e);
            final g w = this.f.w();
            if (w.j()) {
                this.K((g<GoogleSignInAccount>)w);
            }
            else {
                w.c((w0.c)new l(this));
            }
        }
        
        public void d(final n$d n$d) {
            try {
                final int n = e$a.a[((Enum)n$d.g()).ordinal()];
                GoogleSignInOptions$a b;
                if (n != 1) {
                    if (n != 2) {
                        throw new IllegalStateException("Unknown signInOption");
                    }
                    b = new GoogleSignInOptions$a(GoogleSignInOptions.p).b();
                }
                else {
                    b = new GoogleSignInOptions$a(GoogleSignInOptions.q);
                }
                String s2;
                final String s = s2 = n$d.f();
                if (!x0.e.b(n$d.b())) {
                    s2 = s;
                    if (x0.e.b(s)) {
                        Log.w("google_sign_in", "clientId is not supported on Android and is interpreted as serverClientId. Use serverClientId instead to suppress this warning.");
                        s2 = n$d.b();
                    }
                }
                String string = s2;
                if (x0.e.b(s2)) {
                    final int identifier = this.a.getResources().getIdentifier("default_web_client_id", "string", this.a.getPackageName());
                    string = s2;
                    if (identifier != 0) {
                        string = this.a.getString(identifier);
                    }
                }
                if (!x0.e.b(string)) {
                    b.d(string);
                    b.g(string, (boolean)n$d.c());
                }
                final List e = n$d.e();
                this.g = (List<String>)e;
                final Iterator iterator = e.iterator();
                while (iterator.hasNext()) {
                    b.f(new Scope((String)iterator.next()), new Scope[0]);
                }
                if (!x0.e.b(n$d.d())) {
                    b.i(n$d.d());
                }
                this.f = this.e.a(this.a, b.a());
            }
            catch (final Exception ex) {
                throw new n$a("exception", ((Throwable)ex).getMessage(), (Object)null);
            }
        }
        
        public void e(final n$e<Void> n$e) {
            this.w("signOut", n$e);
            this.f.v().c((w0.c)new h(this));
        }
        
        public Boolean f() {
            return com.google.android.gms.auth.api.signin.a.b(this.a) != null;
        }
        
        public void g(final String s, final Boolean b, final n$e<String> n$e) {
            this.d.f((Callable)new x1.f(this, s), (c$a)new x1.g(this, n$e, b, s));
        }
        
        public void h(final n$e<n$g> n$e) {
            if (this.C() != null) {
                this.u("signIn", n$e);
                this.C().startActivityForResult(this.f.t(), 53293);
                return;
            }
            throw new IllegalStateException("signIn needs a foreground activity");
        }
        
        public void i(final String s, final n$e<Void> n$e) {
            this.d.f((Callable)new j(this, s), (c$a)new k(n$e));
        }
        
        public void j(final n$e<Void> n$e) {
            this.w("disconnect", n$e);
            this.f.u().c((w0.c)new i(this));
        }
    }
}
