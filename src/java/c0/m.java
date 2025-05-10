package c0;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.util.Log;
import android.content.pm.PackageInfo;
import f0.i;
import android.content.Context;
import com.google.errorprone.annotations.RestrictedInheritance;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class m
{
    private static m b;
    private final Context a;
    
    public m(final Context context) {
        this.a = context.getApplicationContext();
    }
    
    public static m a(final Context context) {
        i.i(context);
        synchronized (m.class) {
            if (m.b == null) {
                b0.a(context);
                m.b = new m(context);
            }
            return m.b;
        }
    }
    
    static final x c(final PackageInfo packageInfo, final x... array) {
        final Signature[] signatures = packageInfo.signatures;
        if (signatures == null) {
            return null;
        }
        if (signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        final Signature[] signatures2 = packageInfo.signatures;
        int i = 0;
        final y y = new y(signatures2[0].toByteArray());
        while (i < array.length) {
            if (array[i].equals((Object)y)) {
                return array[i];
            }
            ++i;
        }
        return null;
    }
    
    public static final boolean d(final PackageInfo packageInfo, final boolean b) {
        boolean b2 = b;
        Label_0065: {
            if (b) {
                b2 = b;
                if (packageInfo != null) {
                    if (!"com.android.vending".equals((Object)packageInfo.packageName)) {
                        b2 = b;
                        if (!"com.google.android.gms".equals((Object)packageInfo.packageName)) {
                            break Label_0065;
                        }
                    }
                    final ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                    b2 = (applicationInfo != null && (applicationInfo.flags & 0x81) != 0x0);
                }
            }
        }
        if (packageInfo != null && packageInfo.signatures != null) {
            x x;
            if (b2) {
                x = c(packageInfo, a0.a);
            }
            else {
                x = c(packageInfo, a0.a[0]);
            }
            if (x != null) {
                return true;
            }
        }
        return false;
    }
    
    public boolean b(final PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (d(packageInfo, false)) {
            return true;
        }
        if (d(packageInfo, true)) {
            if (l.d(this.a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }
}
