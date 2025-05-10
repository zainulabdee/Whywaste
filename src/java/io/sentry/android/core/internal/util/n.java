package io.sentry.android.core.internal.util;

import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.PackageManager$PackageInfoFlags;
import io.sentry.l4;
import java.io.File;
import io.sentry.n0;
import io.sentry.android.core.l0;
import android.content.Context;
import java.nio.charset.Charset;

public final class n
{
    private static final Charset g;
    private final Context a;
    private final l0 b;
    private final n0 c;
    private final String[] d;
    private final String[] e;
    private final Runtime f;
    
    static {
        g = Charset.forName("UTF-8");
    }
    
    public n(final Context context, final l0 l0, final n0 n0) {
        this(context, l0, n0, new String[] { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su", "/su/bin", "/system/xbin/daemonsu" }, new String[] { "com.devadvance.rootcloak", "com.devadvance.rootcloakplus", "com.koushikdutta.superuser", "com.thirdparty.superuser", "eu.chainfire.supersu", "com.noshufou.android.su" }, Runtime.getRuntime());
    }
    
    n(final Context context, final l0 l0, final n0 n0, final String[] array, final String[] array2, final Runtime runtime) {
        this.a = io.sentry.util.n.c(context, "The application context is required.");
        this.b = io.sentry.util.n.c(l0, "The BuildInfoProvider is required.");
        this.c = io.sentry.util.n.c(n0, "The Logger is required.");
        this.d = io.sentry.util.n.c(array, "The root Files are required.");
        this.e = io.sentry.util.n.c(array2, "The root packages are required.");
        this.f = io.sentry.util.n.c(runtime, "The Runtime is required.");
    }
    
    private boolean a() {
        for (final String s : this.d) {
            try {
                if (new File(s).exists()) {
                    return true;
                }
            }
            catch (final RuntimeException ex) {
                this.c.c(l4.ERROR, (Throwable)ex, "Error when trying to check if root file %s exists.", s);
            }
        }
        return false;
    }
    
    private boolean b(n0 n0) {
        n0 = (n0)new l0(n0);
        final PackageManager packageManager = this.a.getPackageManager();
        if (packageManager != null) {
            final String[] e = this.e;
            final int length = e.length;
            int i = 0;
            while (i < length) {
                final String s = e[i];
                try {
                    if (((l0)n0).d() >= 33) {
                        packageManager.getPackageInfo(s, PackageManager$PackageInfoFlags.of(0L));
                    }
                    else {
                        packageManager.getPackageInfo(s, 0);
                    }
                    return true;
                }
                catch (final PackageManager$NameNotFoundException ex) {
                    ++i;
                    continue;
                }
                break;
            }
        }
        return false;
    }
    
    private boolean c() {
        Object o = null;
        Object o2 = null;
        Object o3;
        try {
            o3 = (o = (o2 = (o = (o2 = (o = (o2 = this.f.exec(new String[] { "/system/xbin/which", "su" })))))));
            final InputStreamReader inputStreamReader = new InputStreamReader(((Process)o3).getInputStream(), n.g);
            o2 = o3;
            o = o3;
            final BufferedReader bufferedReader = new BufferedReader((Reader)inputStreamReader);
            try {
                o2 = bufferedReader.readLine();
                final boolean b = o2 != null;
                o2 = o3;
                o = o3;
                bufferedReader.close();
                ((Process)o3).destroy();
                return b;
            }
            finally {
                try {
                    bufferedReader.close();
                }
                finally {
                    o2 = o3;
                    o = o3;
                    final Throwable t;
                    final Throwable t2;
                    t.addSuppressed(t2);
                }
                o2 = o3;
                o = o3;
            }
        }
        catch (IOException o2) {
            o3 = o;
            this.c.a(l4.DEBUG, "SU isn't found on this Device.", new Object[0]);
            if (o == null) {
                return false;
            }
            final Process process = (Process)(o2 = o);
        }
        finally {
            o3 = o2;
            final Throwable t3;
            this.c.d(l4.DEBUG, "Error when trying to check if SU exists.", t3);
            if (o2 == null) {
                return false;
            }
        }
        try {
            while (true) {
                ((Process)o2).destroy();
                return false;
                o2 = o;
                continue;
            }
        }
        finally {
            if (o3 != null) {
                ((Process)o3).destroy();
            }
        }
    }
    
    private boolean d() {
        final String a = this.b.a();
        return a != null && a.contains((CharSequence)"test-keys");
    }
    
    public boolean e() {
        return this.d() || this.a() || this.c() || this.b(this.c);
    }
}
