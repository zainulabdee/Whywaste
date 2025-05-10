package d1;

import android.content.pm.PackageItemInfo;
import java.util.HashMap;
import t1.j;
import k1.a$b;
import java.security.MessageDigest;
import android.content.pm.PackageInfo;
import android.content.pm.SigningInfo;
import java.security.NoSuchAlgorithmException;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.pm.Signature;
import kotlin.jvm.internal.i;
import android.os.Build$VERSION;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.e;
import android.content.Context;
import k1.a;
import t1.k;

public final class c implements k.c, a
{
    public static final c.c$a c;
    private Context a;
    private k b;
    
    static {
        c = new c.c$a((e)null);
    }
    
    private final String a(final byte[] array) {
        final char[] array3;
        final char[] array2 = array3 = new char[16];
        array3[0] = '0';
        array3[1] = '1';
        array3[2] = '2';
        array3[3] = '3';
        array3[4] = '4';
        array3[5] = '5';
        array3[6] = '6';
        array3[7] = '7';
        array3[8] = '8';
        array3[9] = '9';
        array3[10] = 'A';
        array3[11] = 'B';
        array3[12] = 'C';
        array3[13] = 'D';
        array3[14] = 'E';
        array3[15] = 'F';
        final char[] array4 = new char[array.length * 2];
        for (int length = array.length, i = 0; i < length; ++i) {
            final int n = array[i] & 0xFF;
            final int n2 = i * 2;
            array4[n2] = array2[n >>> 4];
            array4[n2 + 1] = array2[n & 0xF];
        }
        return new String(array4);
    }
    
    private final String b(final PackageManager packageManager) {
        final String s = null;
        try {
            String s2;
            if (Build$VERSION.SDK_INT >= 28) {
                final Context a = this.a;
                i.b((Object)a);
                final SigningInfo signingInfo = packageManager.getPackageInfo(a.getPackageName(), 134217728).signingInfo;
                if (signingInfo == null) {
                    return null;
                }
                if (signingInfo.hasMultipleSigners()) {
                    final Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
                    i.d((Object)apkContentsSigners, "signingInfo.apkContentsSigners");
                    final byte[] byteArray = ((Signature)d2.e.g((Object[])apkContentsSigners)).toByteArray();
                    i.d((Object)byteArray, "signingInfo.apkContentsS\u2026ers.first().toByteArray()");
                    s2 = this.e(byteArray);
                }
                else {
                    final Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                    i.d((Object)signingCertificateHistory, "signingInfo.signingCertificateHistory");
                    final byte[] byteArray2 = ((Signature)d2.e.g((Object[])signingCertificateHistory)).toByteArray();
                    i.d((Object)byteArray2, "signingInfo.signingCerti\u2026ory.first().toByteArray()");
                    s2 = this.e(byteArray2);
                }
            }
            else {
                final Context a2 = this.a;
                i.b((Object)a2);
                final Signature[] signatures = packageManager.getPackageInfo(a2.getPackageName(), 64).signatures;
                boolean b = false;
                if (signatures == null || signatures.length == 0) {
                    b = true;
                }
                s2 = s;
                if (!b) {
                    i.d((Object)signatures, "packageInfo.signatures");
                    if (d2.e.g((Object[])signatures) == null) {
                        s2 = s;
                    }
                    else {
                        i.d((Object)signatures, "signatures");
                        final byte[] byteArray3 = ((Signature)d2.e.g((Object[])signatures)).toByteArray();
                        i.d((Object)byteArray3, "signatures.first().toByteArray()");
                        s2 = this.e(byteArray3);
                    }
                }
            }
            return s2;
        }
        catch (final PackageManager$NameNotFoundException | NoSuchAlgorithmException ex) {
            return s;
        }
    }
    
    private final String c() {
        final Context a = this.a;
        i.b((Object)a);
        final PackageManager packageManager = a.getPackageManager();
        final Context a2 = this.a;
        i.b((Object)a2);
        final String packageName = a2.getPackageName();
        String s;
        if (Build$VERSION.SDK_INT >= 30) {
            s = d1.b.a(packageManager, packageName).getInitiatingPackageName();
        }
        else {
            s = packageManager.getInstallerPackageName(packageName);
        }
        return s;
    }
    
    private final long d(final PackageInfo packageInfo) {
        long a;
        if (Build$VERSION.SDK_INT >= 28) {
            a = d1.a.a(packageInfo);
        }
        else {
            a = packageInfo.versionCode;
        }
        return a;
    }
    
    private final String e(byte[] digest) {
        final MessageDigest instance = MessageDigest.getInstance("SHA1");
        instance.update(digest);
        digest = instance.digest();
        i.d((Object)digest, "hashText");
        return this.a(digest);
    }
    
    public void onAttachedToEngine(final a$b a$b) {
        i.e((Object)a$b, "binding");
        this.a = a$b.a();
        final k b = new k(a$b.b(), "dev.fluttercommunity.plus/package_info");
        i.b((Object)(this.b = b));
        b.e((k.c)this);
    }
    
    public void onDetachedFromEngine(final a$b a$b) {
        i.e((Object)a$b, "binding");
        this.a = null;
        final k b = this.b;
        i.b((Object)b);
        b.e(null);
        this.b = null;
    }
    
    @Override
    public void onMethodCall(final j j, final d d) {
        i.e((Object)j, "call");
        i.e((Object)d, "result");
        try {
            if (i.a((Object)j.a, (Object)"getAll")) {
                final Context a = this.a;
                i.b((Object)a);
                final PackageManager packageManager = a.getPackageManager();
                final Context a2 = this.a;
                i.b((Object)a2);
                final PackageInfo packageInfo = packageManager.getPackageInfo(a2.getPackageName(), 0);
                i.d((Object)packageManager, "packageManager");
                final String b = this.b(packageManager);
                final String c = this.c();
                final HashMap hashMap = new HashMap();
                hashMap.put((Object)"appName", (Object)((PackageItemInfo)packageInfo.applicationInfo).loadLabel(packageManager).toString());
                final Context a3 = this.a;
                i.b((Object)a3);
                hashMap.put((Object)"packageName", (Object)a3.getPackageName());
                hashMap.put((Object)"version", (Object)packageInfo.versionName);
                i.d((Object)packageInfo, "info");
                hashMap.put((Object)"buildNumber", (Object)String.valueOf(this.d(packageInfo)));
                if (b != null) {
                    hashMap.put((Object)"buildSignature", (Object)b);
                }
                if (c != null) {
                    hashMap.put((Object)"installerStore", (Object)c);
                }
                d.a(hashMap);
            }
            else {
                d.c();
            }
        }
        catch (final PackageManager$NameNotFoundException ex) {
            d.b("Name not found", ((Throwable)ex).getMessage(), null);
        }
    }
}
