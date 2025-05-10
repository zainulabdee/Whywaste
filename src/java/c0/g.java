package c0;

import com.google.android.gms.common.api.GoogleApiActivity;
import android.app.Notification;
import android.content.res.Resources;
import android.app.NotificationChannel;
import b0.a;
import m0.e;
import androidx.core.app.p$e;
import androidx.core.app.p$b;
import androidx.core.app.p$d;
import android.app.NotificationManager;
import android.app.FragmentManager;
import androidx.fragment.app.i;
import androidx.fragment.app.d;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import e0.u;
import android.app.AlertDialog;
import android.view.View;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import android.util.Log;
import android.content.DialogInterface$OnClickListener;
import f0.t;
import android.app.AlertDialog$Builder;
import android.util.TypedValue;
import f0.w;
import android.app.Dialog;
import android.content.DialogInterface$OnCancelListener;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;

public class g extends h
{
    public static final int d;
    private static final Object e;
    private static final g f;
    private String c;
    
    static {
        e = new Object();
        f = new g();
        d = h.a;
    }
    
    public static g l() {
        return g.f;
    }
    
    public Intent a(final Context context, final int n, final String s) {
        return super.a(context, n, s);
    }
    
    public PendingIntent b(final Context context, final int n, final int n2) {
        return super.b(context, n, n2);
    }
    
    public final String d(final int n) {
        return super.d(n);
    }
    
    public int f(final Context context) {
        return super.f(context);
    }
    
    public int g(final Context context, final int n) {
        return super.g(context, n);
    }
    
    public final boolean i(final int n) {
        return super.i(n);
    }
    
    public Dialog j(final Activity activity, final int n, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        return this.o((Context)activity, n, w.b(activity, this.a((Context)activity, n, "d"), n2), dialogInterface$OnCancelListener);
    }
    
    public PendingIntent k(final Context context, final b b) {
        if (b.h()) {
            return b.g();
        }
        return this.b(context, b.e(), 0);
    }
    
    public boolean m(final Activity activity, final int n, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        final Dialog j = this.j(activity, n, n2, dialogInterface$OnCancelListener);
        if (j == null) {
            return false;
        }
        this.r(activity, j, "GooglePlayServicesErrorDialog", dialogInterface$OnCancelListener);
        return true;
    }
    
    public void n(final Context context, final int n) {
        this.s(context, n, null, this.c(context, n, 0, "n"));
    }
    
    final Dialog o(final Context context, final int n, final w w, final DialogInterface$OnCancelListener onCancelListener) {
        AlertDialog$Builder alertDialog$Builder = null;
        if (n == 0) {
            return null;
        }
        final TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals((Object)context.getResources().getResourceEntryName(typedValue.resourceId))) {
            alertDialog$Builder = new AlertDialog$Builder(context, 5);
        }
        AlertDialog$Builder alertDialog$Builder2;
        if ((alertDialog$Builder2 = alertDialog$Builder) == null) {
            alertDialog$Builder2 = new AlertDialog$Builder(context);
        }
        alertDialog$Builder2.setMessage((CharSequence)t.d(context, n));
        if (onCancelListener != null) {
            alertDialog$Builder2.setOnCancelListener(onCancelListener);
        }
        final String c = t.c(context, n);
        if (c != null) {
            alertDialog$Builder2.setPositiveButton((CharSequence)c, (DialogInterface$OnClickListener)w);
        }
        final String g = t.g(context, n);
        if (g != null) {
            alertDialog$Builder2.setTitle((CharSequence)g);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", new Object[] { n }), (Throwable)new IllegalArgumentException());
        return (Dialog)alertDialog$Builder2.create();
    }
    
    public final Dialog p(final Activity activity, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        final ProgressBar view = new ProgressBar((Context)activity, (AttributeSet)null, 16842874);
        view.setIndeterminate(true);
        ((View)view).setVisibility(0);
        final AlertDialog$Builder alertDialog$Builder = new AlertDialog$Builder((Context)activity);
        alertDialog$Builder.setView((View)view);
        alertDialog$Builder.setMessage((CharSequence)t.d((Context)activity, 18));
        alertDialog$Builder.setPositiveButton((CharSequence)"", (DialogInterface$OnClickListener)null);
        final AlertDialog create = alertDialog$Builder.create();
        this.r(activity, (Dialog)create, "GooglePlayServicesUpdatingDialog", dialogInterface$OnCancelListener);
        return (Dialog)create;
    }
    
    public final u q(final Context context, final e0.t t) {
        final IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        final u u = new u(t);
        context.registerReceiver((BroadcastReceiver)u, intentFilter);
        u.a(context);
        if (!this.h(context, "com.google.android.gms")) {
            t.a();
            u.b();
            return null;
        }
        return u;
    }
    
    final void r(Activity activity, final Dialog dialog, final String s, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        while (true) {
            try {
                if (activity instanceof d) {
                    activity = (Activity)((d)activity).x();
                    o.N1(dialog, dialogInterface$OnCancelListener).M1((i)activity, s);
                    return;
                }
                activity = (Activity)activity.getFragmentManager();
                c0.c.a(dialog, dialogInterface$OnCancelListener).show((FragmentManager)activity, s);
            }
            catch (final NoClassDefFoundError noClassDefFoundError) {
                continue;
            }
            break;
        }
    }
    
    final void s(final Context context, int n, String s, final PendingIntent pendingIntent) {
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[] { n, null }), (Throwable)new IllegalArgumentException());
        if (n == 18) {
            this.t(context);
            return;
        }
        if (pendingIntent == null) {
            if (n == 6) {
                Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
            }
            return;
        }
        final String f = t.f(context, n);
        final String e = t.e(context, n);
        final Resources resources = context.getResources();
        final NotificationManager notificationManager = (NotificationManager)f0.i.i(context.getSystemService("notification"));
        final p$d n2 = new p$d(context).k(true).e(true).i((CharSequence)f).n((p$e)new p$b().h((CharSequence)e));
        if (m0.e.c(context)) {
            f0.i.k(m0.h.d());
            n2.m(context.getApplicationInfo().icon).l(2);
            if (m0.e.d(context)) {
                n2.a(a.a, (CharSequence)resources.getString(b0.b.o), pendingIntent);
            }
            else {
                n2.g(pendingIntent);
            }
        }
        else {
            n2.m(17301642).o((CharSequence)resources.getString(b0.b.h)).p(System.currentTimeMillis()).g(pendingIntent).h((CharSequence)e);
        }
        Label_0370: {
            if (!m0.h.g()) {
                break Label_0370;
            }
            f0.i.k(m0.h.g());
            final Object e2 = g.e;
            synchronized (e2) {
                final String c = this.c;
                monitorexit(e2);
                s = c;
                if (c == null) {
                    final String s2 = "com.google.android.gms.availability";
                    final NotificationChannel a = c0.e.a(notificationManager, "com.google.android.gms.availability");
                    final String b = t.b(context);
                    if (a == null) {
                        c0.f.a(notificationManager, new NotificationChannel("com.google.android.gms.availability", (CharSequence)b, 4));
                        s = s2;
                    }
                    else {
                        s = s2;
                        if (!b.contentEquals(a.getName())) {
                            a.setName((CharSequence)b);
                            c0.f.a(notificationManager, a);
                            s = s2;
                        }
                    }
                }
                n2.f(s);
                final Notification b2 = n2.b();
                if (n != 1 && n != 2 && n != 3) {
                    n = 39789;
                }
                else {
                    l.b.set(false);
                    n = 10436;
                }
                notificationManager.notify(n, b2);
            }
        }
    }
    
    final void t(final Context context) {
        new q(this, context).sendEmptyMessageDelayed(1, 120000L);
    }
    
    public final boolean u(final Activity activity, final e0.f f, final int n, final int n2, final DialogInterface$OnCancelListener dialogInterface$OnCancelListener) {
        final Dialog o = this.o((Context)activity, n, w.c(f, this.a((Context)activity, n, "d"), 2), dialogInterface$OnCancelListener);
        if (o == null) {
            return false;
        }
        this.r(activity, o, "GooglePlayServicesErrorDialog", dialogInterface$OnCancelListener);
        return true;
    }
    
    public final boolean v(final Context context, final b b, final int n) {
        if (n0.b.a(context)) {
            return false;
        }
        final PendingIntent k = this.k(context, b);
        if (k != null) {
            this.s(context, b.e(), null, q0.d.a(context, 0, GoogleApiActivity.a(context, k, n, true), q0.d.a | 0x8000000));
            return true;
        }
        return false;
    }
}
