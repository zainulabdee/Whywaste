package a0;

import java.util.Set;
import java.util.Iterator;
import android.accounts.Account;
import d0.h;
import java.util.Collection;
import java.util.HashSet;
import f0.i;
import d0.g;
import d0.f;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import z.b;
import android.os.Parcelable;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import android.content.Intent;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import android.content.Context;
import i0.a;

public final class p
{
    private static final a a;
    
    static {
        a = new a("GoogleSignInCommon", new String[0]);
    }
    
    public static Intent a(final Context context, final GoogleSignInOptions googleSignInOptions) {
        p.a.a("getFallbackSignInIntent()", new Object[0]);
        final Intent c = c(context, googleSignInOptions);
        c.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return c;
    }
    
    public static Intent b(final Context context, final GoogleSignInOptions googleSignInOptions) {
        p.a.a("getNoImplementationSignInIntent()", new Object[0]);
        final Intent c = c(context, googleSignInOptions);
        c.setAction("com.google.android.gms.auth.NO_IMPL");
        return c;
    }
    
    public static Intent c(final Context context, final GoogleSignInOptions googleSignInOptions) {
        p.a.a("getSignInIntent()", new Object[0]);
        final SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        final Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, (Class)SignInHubActivity.class);
        final Bundle bundle = new Bundle();
        bundle.putParcelable("config", (Parcelable)signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }
    
    public static b d(final Intent intent) {
        if (intent == null) {
            return new b((GoogleSignInAccount)null, Status.m);
        }
        final Status status = (Status)intent.getParcelableExtra("googleSignInStatus");
        final GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount)intent.getParcelableExtra("googleSignInAccount");
        if (googleSignInAccount == null) {
            Status m;
            if ((m = status) == null) {
                m = Status.m;
            }
            return new b((GoogleSignInAccount)null, m);
        }
        return new b(googleSignInAccount, Status.k);
    }
    
    public static g e(final f f, final Context context, final GoogleSignInOptions googleSignInOptions, final boolean b) {
        final a a = p.a;
        a.a("silentSignIn()", new Object[0]);
        a.a("getEligibleSavedSignInResult()", new Object[0]);
        i.i(googleSignInOptions);
        final GoogleSignInOptions b2 = q.c(context).b();
        b b5 = null;
        Label_0207: {
            Label_0046: {
                if (b2 != null) {
                    final Account b3 = b2.b();
                    final Account b4 = googleSignInOptions.b();
                    if (b3 == null) {
                        if (b4 != null) {
                            break Label_0046;
                        }
                    }
                    else if (!b3.equals((Object)b4)) {
                        break Label_0046;
                    }
                    if (!googleSignInOptions.k()) {
                        if (googleSignInOptions.j()) {
                            if (!b2.j()) {
                                break Label_0046;
                            }
                            if (!f0.g.b(googleSignInOptions.h(), b2.h())) {
                                break Label_0046;
                            }
                        }
                        if (((Set)new HashSet((Collection)b2.g())).containsAll((Collection)new HashSet((Collection)googleSignInOptions.g()))) {
                            final GoogleSignInAccount a2 = q.c(context).a();
                            if (a2 != null && !a2.o()) {
                                b5 = new b(a2, Status.k);
                                break Label_0207;
                            }
                        }
                    }
                }
            }
            b5 = null;
        }
        if (b5 != null) {
            a.a("Eligible saved sign in result found", new Object[0]);
            return d0.i.b(b5, f);
        }
        if (b) {
            return d0.i.b(new b((GoogleSignInAccount)null, new Status(4)), f);
        }
        a.a("trySilentSignIn()", new Object[0]);
        return (g)new e0.j((h)f.a((h)new j(f, context, googleSignInOptions)));
    }
    
    public static h f(final f f, final Context context, final boolean b) {
        p.a.a("Revoking access", new Object[0]);
        final String e = c.b(context).e();
        h(context);
        if (b) {
            return a0.e.a(e);
        }
        return f.b((h)new n(f));
    }
    
    public static h g(final f f, final Context context, final boolean b) {
        p.a.a("Signing out", new Object[0]);
        h(context);
        if (b) {
            return d0.i.c(Status.k, f);
        }
        return f.b((h)new l(f));
    }
    
    private static void h(final Context context) {
        q.c(context).d();
        final Iterator iterator = f.c().iterator();
        while (iterator.hasNext()) {
            ((f)iterator.next()).f();
        }
        com.google.android.gms.common.api.internal.c.a();
    }
}
