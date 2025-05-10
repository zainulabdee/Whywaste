package f0;

import c0.k;
import androidx.core.os.f;
import android.util.Log;
import c0.n;
import android.content.res.Resources;
import b0.b;
import android.content.pm.PackageManager$NameNotFoundException;
import android.text.TextUtils;
import n0.d;
import android.content.Context;
import java.util.Locale;
import f.e;

public final class t
{
    private static final e<String, String> a;
    private static Locale b;
    
    static {
        a = new e<String, String>();
    }
    
    public static String a(final Context context) {
        final String packageName = context.getPackageName();
        try {
            return d.a(context).b(packageName).toString();
        }
        catch (final PackageManager$NameNotFoundException | NullPointerException ex) {
            final String name = context.getApplicationInfo().name;
            if (TextUtils.isEmpty((CharSequence)name)) {
                return packageName;
            }
            return name;
        }
    }
    
    public static String b(final Context context) {
        return context.getResources().getString(b0.b.g);
    }
    
    public static String c(final Context context, final int n) {
        final Resources resources = context.getResources();
        if (n == 1) {
            return resources.getString(b0.b.d);
        }
        if (n == 2) {
            return resources.getString(b0.b.j);
        }
        if (n != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(b0.b.a);
    }
    
    public static String d(final Context context, final int n) {
        final Resources resources = context.getResources();
        final String a = a(context);
        if (n == 1) {
            return resources.getString(b0.b.e, new Object[] { a });
        }
        if (n != 2) {
            if (n == 3) {
                return resources.getString(b0.b.b, new Object[] { a });
            }
            if (n == 5) {
                return h(context, "common_google_play_services_invalid_account_text", a);
            }
            if (n == 7) {
                return h(context, "common_google_play_services_network_error_text", a);
            }
            if (n == 9) {
                return resources.getString(b0.b.i, new Object[] { a });
            }
            if (n == 20) {
                return h(context, "common_google_play_services_restricted_profile_text", a);
            }
            switch (n) {
                default: {
                    return resources.getString(n.a, new Object[] { a });
                }
                case 18: {
                    return resources.getString(b0.b.m, new Object[] { a });
                }
                case 17: {
                    return h(context, "common_google_play_services_sign_in_failed_text", a);
                }
                case 16: {
                    return h(context, "common_google_play_services_api_unavailable_text", a);
                }
            }
        }
        else {
            if (m0.e.d(context)) {
                return resources.getString(b0.b.n);
            }
            return resources.getString(b0.b.k, new Object[] { a });
        }
    }
    
    public static String e(final Context context, final int n) {
        if (n != 6 && n != 19) {
            return d(context, n);
        }
        return h(context, "common_google_play_services_resolution_required_text", a(context));
    }
    
    public static String f(final Context context, final int n) {
        String s;
        if (n == 6) {
            s = i(context, "common_google_play_services_resolution_required_title");
        }
        else {
            s = g(context, n);
        }
        if (s == null) {
            return context.getResources().getString(b0.b.h);
        }
        return s;
    }
    
    public static String g(final Context context, final int n) {
        final Resources resources = context.getResources();
        switch (n) {
            default: {
                final StringBuilder sb = new StringBuilder(33);
                sb.append("Unexpected error code ");
                sb.append(n);
                Log.e("GoogleApiAvailability", sb.toString());
                return null;
            }
            case 20: {
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return i(context, "common_google_play_services_restricted_profile_title");
            }
            case 17: {
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return i(context, "common_google_play_services_sign_in_failed_title");
            }
            case 16: {
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            }
            case 11: {
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            }
            case 10: {
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            }
            case 9: {
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            }
            case 8: {
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            }
            case 7: {
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return i(context, "common_google_play_services_network_error_title");
            }
            case 5: {
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return i(context, "common_google_play_services_invalid_account_title");
            }
            case 4:
            case 6:
            case 18: {
                return null;
            }
            case 3: {
                return resources.getString(b0.b.c);
            }
            case 2: {
                return resources.getString(b0.b.l);
            }
            case 1: {
                return resources.getString(b0.b.f);
            }
        }
    }
    
    private static String h(final Context context, String s, final String s2) {
        final Resources resources = context.getResources();
        String s3;
        s = (s3 = i(context, s));
        if (s == null) {
            s3 = resources.getString(n.a);
        }
        return String.format(resources.getConfiguration().locale, s3, new Object[] { s2 });
    }
    
    private static String i(final Context context, final String s) {
        final e<String, String> a = t.a;
        synchronized (a) {
            final Locale c = f.a(context.getResources().getConfiguration()).c(0);
            if (!c.equals((Object)t.b)) {
                a.clear();
                t.b = c;
            }
            final String s2 = a.get(s);
            if (s2 != null) {
                return s2;
            }
            final Resources c2 = k.c(context);
            if (c2 == null) {
                return null;
            }
            final int identifier = c2.getIdentifier(s, "string", "com.google.android.gms");
            if (identifier == 0) {
                String concat;
                if (s.length() != 0) {
                    concat = "Missing resource: ".concat(s);
                }
                else {
                    concat = new String("Missing resource: ");
                }
                Log.w("GoogleApiAvailability", concat);
                return null;
            }
            final String string = c2.getString(identifier);
            if (TextUtils.isEmpty((CharSequence)string)) {
                String concat2;
                if (s.length() != 0) {
                    concat2 = "Got empty resource: ".concat(s);
                }
                else {
                    concat2 = new String("Got empty resource: ");
                }
                Log.w("GoogleApiAvailability", concat2);
                return null;
            }
            a.put(s, string);
            return string;
        }
    }
}
