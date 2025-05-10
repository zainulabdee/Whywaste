package c0;

import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import r0.c;
import android.app.PendingIntent;
import android.net.Uri$Builder;
import android.content.pm.PackageManager$NameNotFoundException;
import n0.d;
import android.text.TextUtils;
import m0.e;
import android.net.Uri;
import android.content.Intent;
import android.content.Context;

public class h
{
    public static final int a;
    private static final h b;
    
    static {
        a = l.a;
        b = new h();
    }
    
    h() {
    }
    
    public static h e() {
        return h.b;
    }
    
    public Intent a(final Context context, final int n, final String s) {
        if (n != 1 && n != 2) {
            if (n != 3) {
                return null;
            }
            final Uri fromParts = Uri.fromParts("package", "com.google.android.gms", (String)null);
            final Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(fromParts);
            return intent;
        }
        else {
            if (context != null && e.d(context)) {
                final Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
                intent2.setPackage("com.google.android.wearable.app");
                return intent2;
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("gcore_");
            sb.append(h.a);
            sb.append("-");
            if (!TextUtils.isEmpty((CharSequence)s)) {
                sb.append(s);
            }
            sb.append("-");
            if (context != null) {
                sb.append(context.getPackageName());
            }
            sb.append("-");
            if (context != null) {
                try {
                    sb.append(d.a(context).c(context.getPackageName(), 0).versionCode);
                }
                catch (final PackageManager$NameNotFoundException ex) {}
            }
            final String string = sb.toString();
            final Intent intent3 = new Intent("android.intent.action.VIEW");
            final Uri$Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
            if (!TextUtils.isEmpty((CharSequence)string)) {
                appendQueryParameter.appendQueryParameter("pcampaignid", string);
            }
            intent3.setData(appendQueryParameter.build());
            intent3.setPackage("com.android.vending");
            intent3.addFlags(524288);
            return intent3;
        }
    }
    
    public PendingIntent b(final Context context, final int n, final int n2) {
        return this.c(context, n, n2, null);
    }
    
    public PendingIntent c(final Context context, final int n, final int n2, final String s) {
        final Intent a = this.a(context, n, s);
        if (a == null) {
            return null;
        }
        return PendingIntent.getActivity(context, n2, a, c.a | 0x8000000);
    }
    
    public String d(final int n) {
        return l.b(n);
    }
    
    @ResultIgnorabilityUnspecified
    public int f(final Context context) {
        return this.g(context, h.a);
    }
    
    public int g(final Context context, int e) {
        e = l.e(context, e);
        if (l.f(context, e)) {
            return 18;
        }
        return e;
    }
    
    public boolean h(final Context context, final String s) {
        return l.i(context, s);
    }
    
    public boolean i(final int n) {
        return l.h(n);
    }
}
