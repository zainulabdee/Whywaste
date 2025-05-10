package s;

import android.os.BaseBundle;
import java.util.Iterator;
import java.util.List;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.CancellationException;
import android.util.Log;
import java.util.concurrent.TimeoutException;
import android.os.RemoteException;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.d;
import android.os.Parcelable$Creator;
import com.google.android.gms.auth.UserRecoverableAuthException;
import android.content.Intent;
import com.google.android.gms.internal.auth.n3;
import java.io.IOException;
import com.google.android.gms.internal.auth.zze;
import android.os.IBinder;
import w0.g;
import d0.b;
import com.google.android.gms.internal.auth.o4;
import com.google.android.gms.internal.auth.h5;
import com.google.android.gms.internal.auth.r0;
import f0.i;
import com.google.android.gms.auth.TokenData;
import android.os.Bundle;
import android.accounts.Account;
import android.content.Context;
import i0.a;
import android.content.ComponentName;

public class m
{
    public static final String[] a;
    public static final String b;
    private static final ComponentName c;
    private static final a d;
    
    static {
        a = new String[] { "com.google", "com.google.work", "cn.google" };
        b = "androidPackageName";
        c = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        d = h.a("GoogleAuthUtil");
    }
    
    public static void a(final Context context, final String s) {
        g(context, s, 0L);
    }
    
    public static String b(final Context context, final Account account, final String s) {
        return c(context, account, s, new Bundle());
    }
    
    public static String c(final Context context, final Account account, final String s, final Bundle bundle) {
        o(account);
        return d(context, account, s, bundle).e();
    }
    
    public static TokenData d(final Context context, final Account account, final String s, Bundle bundle) {
        i.h("Calling this from your main thread can lead to deadlock");
        i.f(s, (Object)"Scope cannot be empty or null.");
        o(account);
        l(context, 8400000);
        if (bundle == null) {
            bundle = new Bundle();
        }
        else {
            bundle = new Bundle(bundle);
        }
        n(context, bundle);
        r0.e(context);
        if (h5.d() && p(context)) {
            final g a = o4.a(context).a(account, s, bundle);
            try {
                final Bundle bundle2 = (Bundle)j(a, "token retrieval");
                k(bundle2);
                return h(bundle2);
            }
            catch (final b b) {
                m(b, "token retrieval");
            }
        }
        return (TokenData)i(context, m.c, (l)new j(account, s, bundle), 0L);
    }
    
    public static void g(final Context context, final String s, final long n) {
        i.h("Calling this from your main thread can lead to deadlock");
        l(context, 8400000);
        final Bundle bundle = new Bundle();
        n(context, bundle);
        r0.e(context);
        if (h5.d() && p(context)) {
            final n3 a = o4.a(context);
            final com.google.android.gms.internal.auth.h h = new com.google.android.gms.internal.auth.h();
            h.e(s);
            final g c = a.c(h);
            try {
                j(c, "clear token");
                return;
            }
            catch (final b b) {
                m(b, "clear token");
            }
        }
        i(context, m.c, (l)new k(s, bundle), 0L);
    }
    
    private static TokenData h(final Bundle bundle) {
        final Parcelable$Creator creator = TokenData.CREATOR;
        final ClassLoader classLoader = TokenData.class.getClassLoader();
        if (classLoader != null) {
            bundle.setClassLoader(classLoader);
        }
        final Bundle bundle2 = bundle.getBundle("tokenDetails");
        TokenData tokenData;
        if (bundle2 == null) {
            tokenData = null;
        }
        else {
            if (classLoader != null) {
                bundle2.setClassLoader(classLoader);
            }
            tokenData = (TokenData)bundle2.getParcelable("TokenData");
        }
        if (tokenData != null) {
            return tokenData;
        }
        final String string = ((BaseBundle)bundle).getString("Error");
        i.i((Object)string);
        final Intent intent = (Intent)bundle.getParcelable("userRecoveryIntent");
        final com.google.android.gms.internal.auth.j d = com.google.android.gms.internal.auth.j.d(string);
        if (com.google.android.gms.internal.auth.j.e(d)) {
            m.d.e("isUserRecoverableError status: ".concat(String.valueOf((Object)d)), new Object[0]);
            throw new UserRecoverableAuthException(string, intent);
        }
        if (!com.google.android.gms.internal.auth.j.j.equals(d) && !com.google.android.gms.internal.auth.j.k.equals(d) && !com.google.android.gms.internal.auth.j.l.equals(d) && !com.google.android.gms.internal.auth.j.k0.equals(d) && !com.google.android.gms.internal.auth.j.m0.equals(d)) {
            throw new c(string);
        }
        throw new IOException(string);
    }
    
    private static Object i(final Context ex, final ComponentName componentName, final l l, final long n) {
        final c0.a a = new c0.a();
        final d c = com.google.android.gms.common.internal.d.c((Context)ex);
        try {
            if (!c.a(componentName, (ServiceConnection)a, "GoogleAuthUtil")) {
                throw new IOException("Could not bind to service.");
            }
            try {
                try {
                    final Object a2 = l.a(a.a());
                    c.e(componentName, (ServiceConnection)a, "GoogleAuthUtil");
                    return a2;
                }
                finally {}
            }
            catch (final InterruptedException ex) {}
            catch (final RemoteException ex) {}
            catch (final TimeoutException ex2) {}
            Log.i("GoogleAuthUtil", "Error on service connection.", (Throwable)ex);
            throw new IOException("Error on service connection.", (Throwable)ex);
            c.e(componentName, (ServiceConnection)a, "GoogleAuthUtil");
        }
        catch (final SecurityException ex3) {
            Log.w("GoogleAuthUtil", String.format("SecurityException while bind to auth service: %s", new Object[] { ((Throwable)ex3).getMessage() }));
            throw new IOException("SecurityException while binding to Auth service.", (Throwable)ex3);
        }
    }
    
    private static Object j(final g g, String s) {
        try {
            return w0.j.a((g<Object>)g);
        }
        catch (final CancellationException ex) {
            s = String.format("Canceled while waiting for the task of %s to finish.", new Object[] { s });
            m.d.e(s, new Object[0]);
            throw new IOException(s, (Throwable)ex);
        }
        catch (final InterruptedException ex2) {
            s = String.format("Interrupted while waiting for the task of %s to finish.", new Object[] { s });
            m.d.e(s, new Object[0]);
            throw new IOException(s, (Throwable)ex2);
        }
        catch (final ExecutionException ex3) {
            final Throwable cause = ((Throwable)ex3).getCause();
            if (cause instanceof b) {
                throw (b)cause;
            }
            s = String.format("Unable to get a result for %s due to ExecutionException.", new Object[] { s });
            m.d.e(s, new Object[0]);
            throw new IOException(s, (Throwable)ex3);
        }
    }
    
    private static Object k(final Object o) {
        if (o != null) {
            return o;
        }
        m.d.e("Service call returned null.", new Object[0]);
        throw new IOException("Service unavailable.");
    }
    
    private static void l(final Context ex, final int n) {
        try {
            c0.l.a(((Context)ex).getApplicationContext(), n);
        }
        catch (final GooglePlayServicesIncorrectManifestValueException ex) {
            goto Label_0014;
        }
        catch (final c0.i i) {}
        catch (final c0.j j) {
            throw new e(j.b(), ((Throwable)j).getMessage(), j.a());
        }
    }
    
    private static void m(final b b, final String s) {
        m.d.e("%s failed via GoogleAuthServiceClient, falling back to previous approach:\n%s", new Object[] { s, Log.getStackTraceString((Throwable)b) });
    }
    
    private static void n(final Context context, final Bundle bundle) {
        final String packageName = context.getApplicationInfo().packageName;
        ((BaseBundle)bundle).putString("clientPackageName", packageName);
        final String b = m.b;
        if (TextUtils.isEmpty((CharSequence)((BaseBundle)bundle).getString(b))) {
            ((BaseBundle)bundle).putString(b, packageName);
        }
        ((BaseBundle)bundle).putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
    }
    
    private static void o(final Account account) {
        if (account == null) {
            throw new IllegalArgumentException("Account cannot be null");
        }
        if (!TextUtils.isEmpty((CharSequence)account.name)) {
            final String[] a = m.a;
            for (int i = 0; i < 3; ++i) {
                if (a[i].equals((Object)account.type)) {
                    return;
                }
            }
            throw new IllegalArgumentException("Account type not supported");
        }
        throw new IllegalArgumentException("Account name cannot be empty!");
    }
    
    private static boolean p(final Context context) {
        final int g = c0.g.l().g(context, 17895000);
        boolean b = false;
        if (g != 0) {
            return false;
        }
        final List o = h5.b().o();
        final String packageName = context.getApplicationInfo().packageName;
        final Iterator iterator = o.iterator();
        while (iterator.hasNext()) {
            if (((String)iterator.next()).equals((Object)packageName)) {
                return b;
            }
        }
        b = true;
        return b;
    }
}
