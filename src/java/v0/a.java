package v0;

import android.os.BaseBundle;
import android.os.IInterface;
import android.os.IBinder;
import com.google.android.gms.common.internal.a$c;
import com.google.android.gms.common.internal.a$d;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import android.accounts.Account;
import android.os.RemoteException;
import com.google.android.gms.common.internal.g;
import android.app.PendingIntent;
import android.util.Log;
import f0.d0;
import f0.i;
import android.os.Parcelable;
import d0.f$b;
import d0.f$a;
import android.os.Looper;
import android.content.Context;
import android.os.Bundle;
import f0.b;
import u0.f;
import com.google.android.gms.common.internal.c;

public class a extends c<e> implements f
{
    public static final int M = 0;
    private final boolean I;
    private final b J;
    private final Bundle K;
    private final Integer L;
    
    public a(final Context context, final Looper looper, final boolean b, final b j, final Bundle k, final f$a f$a, final f$b f$b) {
        super(context, looper, 44, j, f$a, f$b);
        this.I = true;
        this.J = j;
        this.K = k;
        this.L = j.i();
    }
    
    public static Bundle k0(final b b) {
        b.h();
        final Integer i = b.i();
        final Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", (Parcelable)b.a());
        if (i != null) {
            ((BaseBundle)bundle).putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", (int)i);
        }
        bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
        bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
        ((BaseBundle)bundle).putString("com.google.android.gms.signin.internal.serverClientId", (String)null);
        bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
        bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
        ((BaseBundle)bundle).putString("com.google.android.gms.signin.internal.hostedDomain", (String)null);
        ((BaseBundle)bundle).putString("com.google.android.gms.signin.internal.logSessionId", (String)null);
        bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
        return bundle;
    }
    
    protected final String D() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }
    
    protected final String E() {
        return "com.google.android.gms.signin.service.START";
    }
    
    public final void f(final d d) {
        i.j((Object)d, (Object)"Expecting a valid ISignInCallbacks");
        try {
            final Account c = this.J.c();
            GoogleSignInAccount c2;
            if ("<<default account>>".equals((Object)c.name)) {
                c2 = a0.c.b(((com.google.android.gms.common.internal.a)this).x()).c();
            }
            else {
                c2 = null;
            }
            ((e)((com.google.android.gms.common.internal.a)this).C()).Z0(new h(1, new d0(c, (int)i.i((Object)this.L), c2)), d);
        }
        catch (final RemoteException ex) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                d.U(new j(1, new c0.b(8, (PendingIntent)null), null));
            }
            catch (final RemoteException ex2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", (Throwable)ex);
            }
        }
    }
    
    public final int h() {
        return 12451000;
    }
    
    public final boolean o() {
        return this.I;
    }
    
    public final void p() {
        ((com.google.android.gms.common.internal.a)this).m((a$c)new a$d((com.google.android.gms.common.internal.a)this));
    }
    
    protected final Bundle z() {
        if (!((com.google.android.gms.common.internal.a)this).x().getPackageName().equals((Object)this.J.f())) {
            ((BaseBundle)this.K).putString("com.google.android.gms.signin.internal.realClientPackageName", this.J.f());
        }
        return this.K;
    }
}
