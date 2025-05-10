package n0;

import android.app.AppOpsManager;
import m0.h;
import android.content.pm.PackageInfo;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import android.content.pm.ApplicationInfo;
import android.content.Context;

public class c
{
    protected final Context a;
    
    public c(final Context a) {
        this.a = a;
    }
    
    @ResultIgnorabilityUnspecified
    public ApplicationInfo a(final String s, final int n) {
        return this.a.getPackageManager().getApplicationInfo(s, n);
    }
    
    public CharSequence b(final String s) {
        return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(s, 0));
    }
    
    @ResultIgnorabilityUnspecified
    public PackageInfo c(final String s, final int n) {
        return this.a.getPackageManager().getPackageInfo(s, n);
    }
    
    public final boolean d(int i, final String s) {
        if (h.c()) {
            try {
                final AppOpsManager appOpsManager = (AppOpsManager)this.a.getSystemService("appops");
                if (appOpsManager != null) {
                    appOpsManager.checkPackage(i, s);
                    return true;
                }
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            }
            catch (final SecurityException ex) {
                return false;
            }
        }
        final String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i);
        if (s != null && packagesForUid != null) {
            for (i = 0; i < packagesForUid.length; ++i) {
                if (s.equals((Object)packagesForUid[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
