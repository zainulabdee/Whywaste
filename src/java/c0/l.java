package c0;

import android.os.BaseBundle;
import java.util.Iterator;
import android.content.pm.PackageInstaller$SessionInfo;
import android.os.Bundle;
import android.os.UserManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException;
import com.google.android.gms.common.GooglePlayServicesMissingManifestValueException;
import f0.h0;
import android.content.pm.PackageInfo;
import m0.e;
import n0.d;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.res.Resources;
import android.content.Intent;
import android.util.Log;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

public class l
{
    @Deprecated
    public static final int a = 12451000;
    @Deprecated
    static final AtomicBoolean b;
    private static boolean c;
    static boolean d;
    private static final AtomicBoolean e;
    
    static {
        b = new AtomicBoolean();
        e = new AtomicBoolean();
    }
    
    @Deprecated
    public static void a(final Context context, int g) {
        g = h.e().g(context, g);
        if (g == 0) {
            return;
        }
        final Intent a = h.e().a(context, g, "e");
        final StringBuilder sb = new StringBuilder();
        sb.append("GooglePlayServices not available due to error ");
        sb.append(g);
        Log.e("GooglePlayServicesUtil", sb.toString());
        if (a == null) {
            throw new i(g);
        }
        throw new j(g, "Google Play Services not available", a);
    }
    
    @Deprecated
    public static String b(final int n) {
        return c0.b.j(n);
    }
    
    public static Resources c(final Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        }
        catch (final PackageManager$NameNotFoundException ex) {
            return null;
        }
    }
    
    public static boolean d(final Context context) {
        if (!l.d) {
            try {
                try {
                    final PackageInfo c = n0.d.a(context).c("com.google.android.gms", 64);
                    m.a(context);
                    if (c != null && !m.d(c, false) && m.d(c, true)) {
                        l.c = true;
                    }
                    else {
                        l.c = false;
                    }
                    l.d = true;
                }
                finally {}
            }
            catch (final PackageManager$NameNotFoundException ex) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", (Throwable)ex);
                l.d = true;
                return l.c || !m0.e.b();
            }
            l.d = true;
        }
        return l.c || !m0.e.b();
    }
    
    @Deprecated
    public static int e(final Context context, int n) {
        try {
            context.getResources().getString(n.a);
        }
        finally {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals((Object)context.getPackageName())) {
            if (!l.e.get()) {
                final int a = h0.a(context);
                if (a == 0) {
                    throw new GooglePlayServicesMissingManifestValueException();
                }
                if (a != l.a) {
                    throw new GooglePlayServicesIncorrectManifestValueException(a);
                }
            }
        }
        final boolean d = m0.e.d(context);
        final int n2 = 1;
        final boolean b = !d && !m0.e.f(context);
        f0.i.a(n >= 0);
        final String packageName = context.getPackageName();
        final PackageManager packageManager = context.getPackageManager();
        Label_0186: {
            PackageInfo packageInfo = null;
            Block_9: {
                if (!b) {
                    packageInfo = null;
                    break Block_9;
                }
                try {
                    packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
                    break Label_0186;
                }
                catch (final PackageManager$NameNotFoundException ex) {
                    Log.w("GooglePlayServicesUtil", String.valueOf((Object)packageName).concat(" requires the Google Play Store, but it is missing."));
                }
                n = 9;
                return n;
            }
            try {
                final PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
                m.a(context);
                if (!m.d(packageInfo2, true)) {
                    Log.w("GooglePlayServicesUtil", String.valueOf((Object)packageName).concat(" requires Google Play services, but their signature is invalid."));
                    return 9;
                }
                if (b) {
                    f0.i.i(packageInfo);
                    if (!m.d(packageInfo, true)) {
                        Log.w("GooglePlayServicesUtil", String.valueOf((Object)packageName).concat(" requires Google Play Store, but its signature is invalid."));
                        return 9;
                    }
                }
                if (b && packageInfo != null && !packageInfo.signatures[0].equals((Object)packageInfo2.signatures[0])) {
                    Log.w("GooglePlayServicesUtil", String.valueOf((Object)packageName).concat(" requires Google Play Store, but its signature doesn't match that of Google Play services."));
                    return 9;
                }
                if (m0.j.a(packageInfo2.versionCode) < m0.j.a(n)) {
                    final int versionCode = packageInfo2.versionCode;
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Google Play services out of date for ");
                    sb.append(packageName);
                    sb.append(".  Requires ");
                    sb.append(n);
                    sb.append(" but found ");
                    sb.append(versionCode);
                    Log.w("GooglePlayServicesUtil", sb.toString());
                    n = 2;
                }
                else {
                    ApplicationInfo applicationInfo;
                    if ((applicationInfo = packageInfo2.applicationInfo) == null) {
                        try {
                            applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                        }
                        catch (final PackageManager$NameNotFoundException ex2) {
                            Log.wtf("GooglePlayServicesUtil", String.valueOf((Object)packageName).concat(" requires Google Play services, but they're missing when getting application info."), (Throwable)ex2);
                            n = n2;
                            return n;
                        }
                    }
                    if (applicationInfo.enabled) {
                        return 0;
                    }
                    n = 3;
                }
            }
            catch (final PackageManager$NameNotFoundException ex3) {
                Log.w("GooglePlayServicesUtil", String.valueOf((Object)packageName).concat(" requires Google Play services, but they are missing."));
                n = n2;
            }
        }
        return n;
    }
    
    @Deprecated
    public static boolean f(final Context context, final int n) {
        return n == 18 || (n == 1 && i(context, "com.google.android.gms"));
    }
    
    public static boolean g(final Context context) {
        if (m0.h.b()) {
            final Object systemService = context.getSystemService("user");
            f0.i.i(systemService);
            final Bundle applicationRestrictions = ((UserManager)systemService).getApplicationRestrictions(context.getPackageName());
            if (applicationRestrictions != null && "true".equals((Object)((BaseBundle)applicationRestrictions).getString("restricted_profile"))) {
                return true;
            }
        }
        return false;
    }
    
    @Deprecated
    public static boolean h(final int n) {
        return n == 1 || n == 2 || n == 3 || n == 9;
    }
    
    static boolean i(final Context context, final String s) {
        final boolean equals = s.equals((Object)"com.google.android.gms");
        if (m0.h.e()) {
            try {
                final Iterator iterator = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (iterator.hasNext()) {
                    if (s.equals((Object)((PackageInstaller$SessionInfo)iterator.next()).getAppPackageName())) {
                        return true;
                    }
                }
            }
            catch (final Exception ex) {
                return false;
            }
        }
        final PackageManager packageManager = context.getPackageManager();
        try {
            final ApplicationInfo applicationInfo = packageManager.getApplicationInfo(s, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            if (applicationInfo.enabled && !g(context)) {
                return true;
            }
            return false;
        }
        catch (final PackageManager$NameNotFoundException ex2) {
            return false;
        }
    }
}
