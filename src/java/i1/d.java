package i1;

import java.util.concurrent.Executor;
import android.os.BaseBundle;
import java.util.List;
import java.util.concurrent.Callable;
import io.flutter.view.t;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.os.SystemClock;
import android.app.ActivityManager$MemoryInfo;
import android.app.ActivityManager;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import b2.f;
import android.os.Looper;
import android.os.Bundle;
import java.io.File;
import android.content.Context;
import f1.a;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;
import io.flutter.embedding.engine.FlutterJNI;

public class d
{
    private boolean a;
    private c b;
    private long c;
    private i1.b d;
    private FlutterJNI e;
    private ExecutorService f;
    Future<b> g;
    
    public d() {
        this(f1.a.e().d().a());
    }
    
    public d(final FlutterJNI flutterJNI) {
        this(flutterJNI, f1.a.e().b());
    }
    
    public d(final FlutterJNI e, final ExecutorService f) {
        this.a = false;
        this.e = e;
        this.f = f;
    }
    
    static /* synthetic */ e a(final d d, final Context context) {
        d.i(context);
        return null;
    }
    
    private String g(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append(this.d.d);
        sb.append(File.separator);
        sb.append(s);
        return sb.toString();
    }
    
    private e i(final Context context) {
        return null;
    }
    
    private static boolean k(final Bundle bundle) {
        return bundle == null || bundle.getBoolean("io.flutter.embedding.android.LeakVM", true);
    }
    
    public boolean d() {
        return this.d.g;
    }
    
    public void e(final Context context, final String[] array) {
        if (this.a) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        b2.f.a("FlutterLoader#ensureInitializationComplete");
        try {
            try {
                final b b = (b)this.g.get();
                final ArrayList list = new ArrayList();
                ((List)list).add((Object)"--icu-symbol-prefix=_binary_icudtl_dat");
                final StringBuilder sb = new StringBuilder();
                sb.append("--icu-native-lib-path=");
                sb.append(this.d.f);
                final String separator = File.separator;
                sb.append(separator);
                sb.append("libflutter.so");
                ((List)list).add((Object)sb.toString());
                if (array != null) {
                    Collections.addAll((Collection)list, (Object[])array);
                }
                final StringBuilder sb2 = new StringBuilder();
                sb2.append("--aot-shared-library-name=");
                sb2.append(this.d.a);
                ((List)list).add((Object)sb2.toString());
                final StringBuilder sb3 = new StringBuilder();
                sb3.append("--aot-shared-library-name=");
                sb3.append(this.d.f);
                sb3.append(separator);
                sb3.append(this.d.a);
                ((List)list).add((Object)sb3.toString());
                final StringBuilder sb4 = new StringBuilder();
                sb4.append("--cache-dir-path=");
                sb4.append(b.b);
                ((List)list).add((Object)sb4.toString());
                if (this.d.e != null) {
                    final StringBuilder sb5 = new StringBuilder();
                    sb5.append("--domain-network-policy=");
                    sb5.append(this.d.e);
                    ((List)list).add((Object)sb5.toString());
                }
                if (this.b.a() != null) {
                    final StringBuilder sb6 = new StringBuilder();
                    sb6.append("--log-tag=");
                    sb6.append(this.b.a());
                    ((List)list).add((Object)sb6.toString());
                }
                final Bundle metaData = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                int int1;
                if (metaData != null) {
                    int1 = ((BaseBundle)metaData).getInt("io.flutter.embedding.android.OldGenHeapSize");
                }
                else {
                    int1 = 0;
                }
                int n = int1;
                if (int1 == 0) {
                    final ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
                    final ActivityManager$MemoryInfo activityManager$MemoryInfo = new ActivityManager$MemoryInfo();
                    activityManager.getMemoryInfo(activityManager$MemoryInfo);
                    n = (int)(activityManager$MemoryInfo.totalMem / 1000000.0 / 2.0);
                }
                final StringBuilder sb7 = new StringBuilder();
                sb7.append("--old-gen-heap-size=");
                sb7.append(n);
                ((List)list).add((Object)sb7.toString());
                final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                final int widthPixels = displayMetrics.widthPixels;
                final int heightPixels = displayMetrics.heightPixels;
                final StringBuilder sb8 = new StringBuilder();
                sb8.append("--resource-cache-max-bytes-threshold=");
                sb8.append(widthPixels * heightPixels * 12 * 4);
                ((List)list).add((Object)sb8.toString());
                ((List)list).add((Object)"--prefetched-default-font-manager");
                if (metaData != null && metaData.getBoolean("io.flutter.embedding.android.EnableImpeller", false)) {
                    ((List)list).add((Object)"--enable-impeller");
                }
                String s;
                if (k(metaData)) {
                    s = "true";
                }
                else {
                    s = "false";
                }
                final StringBuilder sb9 = new StringBuilder();
                sb9.append("--leak-vm=");
                sb9.append(s);
                ((List)list).add((Object)sb9.toString());
                this.e.init(context, (String[])((List)list).toArray((Object[])new String[0]), null, b.a, b.b, SystemClock.uptimeMillis() - this.c);
                this.a = true;
                b2.f.d();
                return;
            }
            finally {}
        }
        catch (final Exception ex) {
            f1.b.c("FlutterLoader", "Flutter initialization failed.", (Throwable)ex);
            throw new RuntimeException((Throwable)ex);
        }
        b2.f.d();
    }
    
    public String f() {
        return this.d.d;
    }
    
    public String h(final String s) {
        return this.g(s);
    }
    
    public boolean j() {
        return this.a;
    }
    
    public void l(final Context context) {
        this.m(context, new c());
    }
    
    public void m(Context applicationContext, final c b) {
        if (this.b != null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b2.f.a("FlutterLoader#startInitialization");
            try {
                applicationContext = applicationContext.getApplicationContext();
                this.b = b;
                this.c = SystemClock.uptimeMillis();
                this.d = i1.a.e(applicationContext);
                t.f((DisplayManager)applicationContext.getSystemService("display"), this.e).g();
                this.g = (Future<b>)this.f.submit((Callable)new Callable<b>(this, applicationContext) {
                    final Context a;
                    final d b;
                    
                    public b b() {
                        b2.f.a("FlutterLoader initTask");
                        try {
                            i1.d.a(this.b, this.a);
                            this.b.e.loadLibrary();
                            this.b.e.updateRefreshRate();
                            ((Executor)this.b.f).execute((Runnable)new i1.c(this));
                            return new b(b2.c.d(this.a), b2.c.a(this.a), b2.c.c(this.a));
                        }
                        finally {
                            b2.f.d();
                        }
                    }
                });
                return;
            }
            finally {
                b2.f.d();
            }
        }
        throw new IllegalStateException("startInitialization must be called on the main thread");
    }
    
    private static class b
    {
        final String a;
        final String b;
        final String c;
        
        private b(final String a, final String b, final String c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    
    public static class c
    {
        private String a;
        
        public String a() {
            return this.a;
        }
    }
}
