package io.sentry.android.core;

import java.util.AbstractMap;
import android.os.LocaleList;
import java.util.Calendar;
import java.util.TimeZone;
import android.os.Build$VERSION;
import android.util.DisplayMetrics;
import java.util.Collection;
import java.util.Collections;
import android.os.Build;
import android.os.SystemClock;
import java.util.Date;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import io.sentry.android.core.internal.util.b;
import io.sentry.protocol.w;
import io.sentry.e4;
import java.util.Iterator;
import java.util.Map$Entry;
import java.io.File;
import android.app.ActivityManager$MemoryInfo;
import io.sentry.android.core.internal.util.f;
import io.sentry.protocol.e;
import android.content.pm.PackageInfo;
import io.sentry.j;
import io.sentry.protocol.a;
import io.sentry.protocol.a0;
import io.sentry.protocol.k;
import java.util.Locale;
import io.sentry.e3;
import java.util.HashMap;
import io.sentry.android.core.internal.util.h;
import java.util.List;
import android.os.Environment;
import android.content.Intent;
import io.sentry.l4;
import android.os.StatFs;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import io.sentry.android.core.internal.util.n;
import java.util.Map;
import java.util.concurrent.Future;
import android.content.Context;
import io.sentry.x;

final class q0 implements x
{
    final Context e;
    final Future<Map<String, Object>> f;
    private final l0 g;
    private final n h;
    private final SentryAndroidOptions i;
    
    public q0(final Context context, final l0 l0, final SentryAndroidOptions sentryAndroidOptions) {
        this(context, l0, new n(context, l0, sentryAndroidOptions.getLogger()), sentryAndroidOptions);
    }
    
    q0(final Context context, final l0 l0, final n n, final SentryAndroidOptions sentryAndroidOptions) {
        this.e = (Context)io.sentry.util.n.c((Object)context, "The application context is required.");
        this.g = (l0)io.sentry.util.n.c((Object)l0, "The BuildInfoProvider is required.");
        this.h = (n)io.sentry.util.n.c((Object)n, "The RootChecker is required.");
        this.i = (SentryAndroidOptions)io.sentry.util.n.c((Object)sentryAndroidOptions, "The options object is required.");
        final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        this.f = (Future<Map<String, Object>>)singleThreadExecutor.submit((Callable)new o0(this));
        singleThreadExecutor.submit((Callable)new p0());
        singleThreadExecutor.shutdown();
    }
    
    private Long A(final StatFs statFs) {
        try {
            return this.f(statFs) * this.m(statFs);
        }
        finally {
            final Throwable t;
            this.i.getLogger().d(l4.ERROR, "Error getting unused external storage amount.", t);
            return null;
        }
    }
    
    private Long B(final StatFs statFs) {
        try {
            return this.f(statFs) * this.m(statFs);
        }
        finally {
            final Throwable t;
            this.i.getLogger().d(l4.ERROR, "Error getting unused internal storage amount.", t);
            return null;
        }
    }
    
    private Boolean C(final Intent intent) {
        try {
            final int intExtra = intent.getIntExtra("plugged", -1);
            boolean b = true;
            if (intExtra != 1) {
                b = (intExtra == 2 && b);
            }
            return b;
        }
        finally {
            final Throwable t;
            this.i.getLogger().d(l4.ERROR, "Error getting device charging state.", t);
            return null;
        }
    }
    
    private boolean D() {
        final String externalStorageState = Environment.getExternalStorageState();
        return ("mounted".equals((Object)externalStorageState) || "mounted_ro".equals((Object)externalStorageState)) && !Environment.isExternalStorageEmulated();
    }
    
    private Map<String, Object> G() {
        final HashMap hashMap = new HashMap();
        if (this.i.isEnableRootCheck()) {
            ((Map)hashMap).put((Object)"rooted", (Object)this.h.e());
        }
        final String g = m0.g(this.i.getLogger());
        if (g != null) {
            ((Map)hashMap).put((Object)"kernelVersion", (Object)g);
        }
        ((Map)hashMap).put((Object)"emulator", (Object)this.g.f());
        final Map k = m0.k(this.e, this.i.getLogger(), this.g);
        if (k != null) {
            ((Map)hashMap).put((Object)"sideLoaded", (Object)k);
        }
        return (Map<String, Object>)hashMap;
    }
    
    private void H(final e3 e3) {
        final k c = e3.C().c();
        e3.C().j(this.v());
        if (c != null) {
            final String g = c.g();
            String string;
            if (g != null && !g.isEmpty()) {
                final StringBuilder sb = new StringBuilder();
                sb.append("os_");
                sb.append(g.trim().toLowerCase(Locale.ROOT));
                string = sb.toString();
            }
            else {
                string = "os_1";
            }
            ((AbstractMap)e3.C()).put((Object)string, (Object)c);
        }
    }
    
    private void I(final e3 e3) {
        final a0 q = e3.Q();
        if (q == null) {
            e3.e0(this.o());
        }
        else if (q.m() == null) {
            q.q(this.q());
        }
    }
    
    private void J(final e3 e3, final io.sentry.a0 a0) {
        a a2;
        if ((a2 = e3.C().a()) == null) {
            a2 = new a();
        }
        this.K(a2, a0);
        this.Q(e3, a2);
        e3.C().f(a2);
    }
    
    private void K(final a a, final io.sentry.a0 a2) {
        a.m(m0.b(this.e, this.i.getLogger()));
        a.n(j.n(j0.e().d()));
        if (!io.sentry.util.j.h(a2) && a.j() == null) {
            final Boolean b = k0.a().b();
            if (b != null) {
                a.p(b ^ true);
            }
        }
    }
    
    private void L(final a a, final PackageInfo packageInfo) {
        a.l(packageInfo.packageName);
        a.o(packageInfo.versionName);
        a.k(m0.l(packageInfo, this.g));
        if (this.g.d() >= 16) {
            final HashMap hashMap = new HashMap();
            final String[] requestedPermissions = packageInfo.requestedPermissions;
            final int[] requestedPermissionsFlags = packageInfo.requestedPermissionsFlags;
            if (requestedPermissions != null && requestedPermissions.length > 0 && requestedPermissionsFlags != null && requestedPermissionsFlags.length > 0) {
                for (int i = 0; i < requestedPermissions.length; ++i) {
                    final String s = requestedPermissions[i];
                    final int lastIndex = s.lastIndexOf(46);
                    boolean b = true;
                    final String substring = s.substring(lastIndex + 1);
                    if ((requestedPermissionsFlags[i] & 0x2) != 0x2) {
                        b = false;
                    }
                    String s2;
                    if (b) {
                        s2 = "granted";
                    }
                    else {
                        s2 = "not_granted";
                    }
                    ((Map)hashMap).put((Object)substring, (Object)s2);
                }
            }
            a.q((Map<String, String>)hashMap);
        }
    }
    
    private void M(final e3 e3, final boolean b, final boolean b2) {
        this.I(e3);
        this.N(e3, b, b2);
        this.H(e3);
        this.R(e3);
    }
    
    private void N(final e3 e3, final boolean b, final boolean b2) {
        if (e3.C().b() == null) {
            e3.C().h(this.p(b, b2));
        }
    }
    
    private void O(final e e, final boolean b) {
        final Intent g = this.g();
        if (g != null) {
            e.N(this.h(g));
            e.R(this.C(g));
            e.O(this.i(g));
        }
        final int n = q0$a.a[((Enum)io.sentry.android.core.internal.util.f.b(this.e, this.i.getLogger())).ordinal()];
        Boolean b2;
        if (n != 1) {
            if (n != 2) {
                b2 = null;
            }
            else {
                b2 = Boolean.TRUE;
            }
        }
        else {
            b2 = Boolean.FALSE;
        }
        e.h0(b2);
        final ActivityManager$MemoryInfo h = m0.h(this.e, this.i.getLogger());
        if (h != null) {
            e.d0(this.u(h));
            if (b) {
                e.W(h.availMem);
                e.b0(h.lowMemory);
            }
        }
        final File externalFilesDir = this.e.getExternalFilesDir((String)null);
        if (externalFilesDir != null) {
            final StatFs statFs = new StatFs(externalFilesDir.getPath());
            e.q0(this.z(statFs));
            e.X(this.B(statFs));
        }
        final StatFs t = this.t(externalFilesDir);
        if (t != null) {
            e.U(this.y(t));
            e.T(this.A(t));
        }
        if (e.I() == null) {
            e.S(io.sentry.android.core.internal.util.f.c(this.e, this.i.getLogger(), this.g));
        }
    }
    
    private void P(final e3 e3, final String s) {
        if (e3.E() == null) {
            e3.T(s);
        }
    }
    
    private void Q(final e3 e3, final a a) {
        final PackageInfo i = m0.i(this.e, 4096, this.i.getLogger(), this.g);
        if (i != null) {
            this.P(e3, m0.l(i, this.g));
            this.L(a, i);
        }
    }
    
    private void R(final e3 e3) {
        try {
            final Object value = ((Map)this.f.get()).get((Object)"sideLoaded");
            if (value instanceof Map) {
                for (final Map$Entry map$Entry : ((Map)value).entrySet()) {
                    e3.c0((String)map$Entry.getKey(), (String)map$Entry.getValue());
                }
            }
        }
        finally {
            final Throwable t;
            this.i.getLogger().d(l4.ERROR, "Error getting side loaded info.", t);
        }
    }
    
    private void S(final e4 e4, final io.sentry.a0 a0) {
        if (e4.s0() != null) {
            final boolean h = io.sentry.util.j.h(a0);
            for (final w w : e4.s0()) {
                final boolean e5 = b.d().e(w);
                if (w.o() == null) {
                    w.r(e5);
                }
                if (!h && w.p() == null) {
                    w.v(e5);
                }
            }
        }
    }
    
    private boolean T(final e3 e3, final io.sentry.a0 a0) {
        if (io.sentry.util.j.s(a0)) {
            return true;
        }
        this.i.getLogger().a(l4.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", new Object[] { e3.G() });
        return false;
    }
    
    private int e(final StatFs statFs) {
        return statFs.getAvailableBlocks();
    }
    
    private long f(final StatFs statFs) {
        if (this.g.d() >= 18) {
            return statFs.getAvailableBlocksLong();
        }
        return this.e(statFs);
    }
    
    private Intent g() {
        return this.e.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
    }
    
    private Float h(final Intent intent) {
        try {
            final int intExtra = intent.getIntExtra("level", -1);
            final int intExtra2 = intent.getIntExtra("scale", -1);
            if (intExtra != -1 && intExtra2 != -1) {
                return intExtra / (float)intExtra2 * 100.0f;
            }
            return null;
        }
        finally {
            final Throwable t;
            this.i.getLogger().d(l4.ERROR, "Error getting device battery level.", t);
            return null;
        }
    }
    
    private Float i(final Intent intent) {
        try {
            final int intExtra = intent.getIntExtra("temperature", -1);
            if (intExtra != -1) {
                return intExtra / 10.0f;
            }
        }
        finally {
            final Throwable t;
            this.i.getLogger().d(l4.ERROR, "Error getting battery temperature.", t);
        }
        return null;
    }
    
    private int j(final StatFs statFs) {
        return statFs.getBlockCount();
    }
    
    private long k(final StatFs statFs) {
        if (this.g.d() >= 18) {
            return statFs.getBlockCountLong();
        }
        return this.j(statFs);
    }
    
    private int l(final StatFs statFs) {
        return statFs.getBlockSize();
    }
    
    private long m(final StatFs statFs) {
        if (this.g.d() >= 18) {
            return statFs.getBlockSizeLong();
        }
        return this.l(statFs);
    }
    
    private Date n() {
        try {
            return j.d(System.currentTimeMillis() - SystemClock.elapsedRealtime());
        }
        catch (final IllegalArgumentException ex) {
            this.i.getLogger().c(l4.ERROR, (Throwable)ex, "Error getting the device's boot time.", new Object[0]);
            return null;
        }
    }
    
    private e p(final boolean b, final boolean b2) {
        final e e = new e();
        if (this.i.isSendDefaultPii()) {
            e.g0(m0.d(this.e, this.g));
        }
        e.c0(Build.MANUFACTURER);
        e.Q(Build.BRAND);
        e.V(m0.f(this.i.getLogger()));
        e.e0(Build.MODEL);
        e.f0(Build.ID);
        e.M(m0.c(this.g));
        if (b && this.i.isCollectAdditionalContext()) {
            this.O(e, b2);
        }
        e.i0(this.w());
        try {
            final Object value = ((Map)this.f.get()).get((Object)"emulator");
            if (value != null) {
                e.p0((Boolean)value);
            }
        }
        finally {
            final Throwable t;
            this.i.getLogger().d(l4.ERROR, "Error getting emulator.", t);
        }
        final DisplayMetrics e2 = m0.e(this.e, this.i.getLogger());
        if (e2 != null) {
            e.o0(e2.widthPixels);
            e.n0(e2.heightPixels);
            e.l0(e2.density);
            e.m0(e2.densityDpi);
        }
        e.P(this.n());
        e.r0(this.x());
        if (e.J() == null) {
            e.Y(this.q());
        }
        final Locale default1 = Locale.getDefault();
        if (e.K() == null) {
            e.Z(default1.getLanguage());
        }
        if (e.L() == null) {
            e.a0(default1.toString());
        }
        final List c = io.sentry.android.core.internal.util.h.a().c();
        if (!c.isEmpty()) {
            e.k0((double)Collections.max((Collection)c));
            e.j0(c.size());
        }
        return e;
    }
    
    private String q() {
        try {
            return u0.a(this.e);
        }
        finally {
            final Throwable t;
            this.i.getLogger().d(l4.ERROR, "Error getting installationId.", t);
            return null;
        }
    }
    
    private File[] r() {
        final int d = this.g.d();
        File[] array = null;
        if (d >= 19) {
            return this.e.getExternalFilesDirs((String)null);
        }
        final File externalFilesDir = this.e.getExternalFilesDir((String)null);
        if (externalFilesDir != null) {
            array = new File[] { externalFilesDir };
        }
        return array;
    }
    
    private File s(final File file) {
        final File[] r = this.r();
        int i = 0;
        if (r != null) {
            String absolutePath;
            if (file != null) {
                absolutePath = file.getAbsolutePath();
            }
            else {
                absolutePath = null;
            }
            while (i < r.length) {
                final File file2 = r[i];
                Label_0076: {
                    if (file2 != null) {
                        if (absolutePath != null) {
                            if (!absolutePath.isEmpty()) {
                                if (file2.getAbsolutePath().contains((CharSequence)absolutePath)) {
                                    break Label_0076;
                                }
                            }
                        }
                        return file2;
                    }
                }
                ++i;
            }
        }
        else {
            this.i.getLogger().a(l4.INFO, "Not possible to read getExternalFilesDirs", new Object[0]);
        }
        return null;
    }
    
    private StatFs t(File s) {
        if (this.D()) {
            this.i.getLogger().a(l4.INFO, "External storage is not mounted or emulated.", new Object[0]);
            return null;
        }
        s = this.s(s);
        if (s != null) {
            return new StatFs(s.getPath());
        }
        this.i.getLogger().a(l4.INFO, "Not possible to read external files directory", new Object[0]);
        return null;
    }
    
    private Long u(final ActivityManager$MemoryInfo activityManager$MemoryInfo) {
        if (this.g.d() >= 16) {
            return activityManager$MemoryInfo.totalMem;
        }
        return Runtime.getRuntime().totalMemory();
    }
    
    private k v() {
        final k k = new k();
        k.j("Android");
        k.m(Build$VERSION.RELEASE);
        k.h(Build.DISPLAY);
        try {
            final Object value = ((Map)this.f.get()).get((Object)"kernelVersion");
            if (value != null) {
                k.i((String)value);
            }
            final Object value2 = ((Map)this.f.get()).get((Object)"rooted");
            if (value2 != null) {
                k.k((Boolean)value2);
            }
        }
        finally {
            final Throwable t;
            this.i.getLogger().d(l4.ERROR, "Error getting OperatingSystem.", t);
        }
        return k;
    }
    
    private e.b w() {
        final Throwable t;
        Throwable t2;
        try {
            if (io.sentry.android.core.internal.util.j.a(this.e.getResources().getConfiguration().orientation) != null) {
                return (e.b)t;
            }
            try {
                this.i.getLogger().a(l4.INFO, "No device orientation available (ORIENTATION_SQUARE|ORIENTATION_UNDEFINED)", new Object[0]);
                return null;
            }
            finally {}
        }
        finally {
            t2 = null;
        }
        this.i.getLogger().d(l4.ERROR, "Error getting device orientation.", t);
        t = t2;
        return (e.b)t;
    }
    
    private TimeZone x() {
        if (this.g.d() >= 24) {
            final LocaleList a = androidx.core.os.e.a(this.e.getResources().getConfiguration());
            if (!a.isEmpty()) {
                return Calendar.getInstance(a.get(0)).getTimeZone();
            }
        }
        return Calendar.getInstance().getTimeZone();
    }
    
    private Long y(final StatFs statFs) {
        try {
            return this.k(statFs) * this.m(statFs);
        }
        finally {
            final Throwable t;
            this.i.getLogger().d(l4.ERROR, "Error getting total external storage amount.", t);
            return null;
        }
    }
    
    private Long z(final StatFs statFs) {
        try {
            return this.k(statFs) * this.m(statFs);
        }
        finally {
            final Throwable t;
            this.i.getLogger().d(l4.ERROR, "Error getting total internal storage amount.", t);
            return null;
        }
    }
    
    public io.sentry.protocol.x b(final io.sentry.protocol.x x, final io.sentry.a0 a0) {
        final boolean t = this.T(x, a0);
        if (t) {
            this.J(x, a0);
        }
        this.M(x, false, t);
        return x;
    }
    
    public e4 c(final e4 e4, final io.sentry.a0 a0) {
        final boolean t = this.T(e4, a0);
        if (t) {
            this.J(e4, a0);
            this.S(e4, a0);
        }
        this.M(e4, true, t);
        return e4;
    }
    
    public a0 o() {
        final a0 a0 = new a0();
        a0.q(this.q());
        return a0;
    }
}
