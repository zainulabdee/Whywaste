package io.sentry.android.core;

import java.util.Iterator;
import java.util.List;
import android.app.ActivityManager$RunningAppProcessInfo;
import android.os.Process;
import d1.a;
import java.util.Map;
import android.content.pm.PackageManager$PackageInfoFlags;
import android.content.pm.PackageInfo;
import android.app.ActivityManager;
import android.app.ActivityManager$MemoryInfo;
import java.io.IOException;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import android.util.DisplayMetrics;
import android.provider.Settings$Global;
import android.os.Build;
import io.sentry.l4;
import io.sentry.n0;
import android.content.pm.PackageManager$ApplicationInfoFlags;
import android.content.pm.ApplicationInfo;
import android.content.Context;

final class m0
{
    static ApplicationInfo a(final Context context, final long n, final l0 l0) {
        if (l0.d() >= 33) {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager$ApplicationInfoFlags.of(n));
        }
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
    }
    
    static String b(final Context context, final n0 n0) {
        try {
            final ApplicationInfo applicationInfo = context.getApplicationInfo();
            final int labelRes = applicationInfo.labelRes;
            if (labelRes != 0) {
                return context.getString(labelRes);
            }
            final CharSequence nonLocalizedLabel = applicationInfo.nonLocalizedLabel;
            if (nonLocalizedLabel != null) {
                return nonLocalizedLabel.toString();
            }
            return context.getPackageManager().getApplicationLabel(applicationInfo).toString();
        }
        finally {
            final Throwable t;
            n0.d(l4.ERROR, "Error getting application name.", t);
            return null;
        }
    }
    
    static String[] c(final l0 l0) {
        String[] supported_ABIS;
        if (l0.d() >= 21) {
            supported_ABIS = Build.SUPPORTED_ABIS;
        }
        else {
            supported_ABIS = new String[] { Build.CPU_ABI, Build.CPU_ABI2 };
        }
        return supported_ABIS;
    }
    
    static String d(final Context context, final l0 l0) {
        if (l0.d() >= 17) {
            return Settings$Global.getString(context.getContentResolver(), "device_name");
        }
        return null;
    }
    
    static DisplayMetrics e(final Context context, final n0 n0) {
        try {
            return context.getResources().getDisplayMetrics();
        }
        finally {
            final Throwable t;
            n0.d(l4.ERROR, "Error getting DisplayMetrics.", t);
            return null;
        }
    }
    
    static String f(final n0 n0) {
        try {
            return Build.MODEL.split(" ", -1)[0];
        }
        finally {
            final Throwable t;
            n0.d(l4.ERROR, "Error getting device family.", t);
            return null;
        }
    }
    
    static String g(final n0 n0) {
        final String property = System.getProperty("os.version");
        final File file = new File("/proc/version");
        if (!file.canRead()) {
            return property;
        }
        try {
            final BufferedReader bufferedReader = new BufferedReader((Reader)new FileReader(file));
            try {
                final String line = bufferedReader.readLine();
                bufferedReader.close();
                return line;
            }
            finally {
                try {
                    bufferedReader.close();
                }
                finally {
                    final Throwable t;
                    final Throwable t2;
                    t.addSuppressed(t2);
                }
            }
        }
        catch (final IOException ex) {
            n0.d(l4.ERROR, "Exception while attempting to read kernel information", (Throwable)ex);
            return property;
        }
    }
    
    static ActivityManager$MemoryInfo h(final Context context, final n0 n0) {
        try {
            final ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
            final ActivityManager$MemoryInfo activityManager$MemoryInfo = new ActivityManager$MemoryInfo();
            if (activityManager != null) {
                activityManager.getMemoryInfo(activityManager$MemoryInfo);
                return activityManager$MemoryInfo;
            }
            n0.a(l4.INFO, "Error getting MemoryInfo.", new Object[0]);
            return null;
        }
        finally {
            final Throwable t;
            n0.d(l4.ERROR, "Error getting MemoryInfo.", t);
            return null;
        }
    }
    
    static PackageInfo i(final Context context, final int n, final n0 n2, final l0 l0) {
        try {
            if (l0.d() >= 33) {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager$PackageInfoFlags.of((long)n));
            }
            return context.getPackageManager().getPackageInfo(context.getPackageName(), n);
        }
        finally {
            final Throwable t;
            n2.d(l4.ERROR, "Error getting package info.", t);
            return null;
        }
    }
    
    static PackageInfo j(final Context context, final n0 n0, final l0 l0) {
        return i(context, 0, n0, l0);
    }
    
    static Map<String, String> k(final Context p0, final n0 p1, final l0 p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: aload_2        
        //     3: invokestatic    io/sentry/android/core/m0.j:(Landroid/content/Context;Lio/sentry/n0;Lio/sentry/android/core/l0;)Landroid/content/pm/PackageInfo;
        //     6: astore_2       
        //     7: aload_0        
        //     8: invokevirtual   android/content/Context.getPackageManager:()Landroid/content/pm/PackageManager;
        //    11: astore_3       
        //    12: aload_2        
        //    13: ifnull          105
        //    16: aload_3        
        //    17: ifnull          105
        //    20: aload_2        
        //    21: getfield        android/content/pm/PackageInfo.packageName:Ljava/lang/String;
        //    24: astore_0       
        //    25: aload_3        
        //    26: aload_0        
        //    27: invokevirtual   android/content/pm/PackageManager.getInstallerPackageName:(Ljava/lang/String;)Ljava/lang/String;
        //    30: astore_3       
        //    31: new             Ljava/util/HashMap;
        //    34: astore_2       
        //    35: aload_2        
        //    36: invokespecial   java/util/HashMap.<init>:()V
        //    39: aload_3        
        //    40: ifnull          68
        //    43: aload_2        
        //    44: ldc             "isSideLoaded"
        //    46: ldc             "false"
        //    48: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    53: pop            
        //    54: aload_2        
        //    55: ldc_w           "installerStore"
        //    58: aload_3        
        //    59: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    64: pop            
        //    65: goto            80
        //    68: aload_2        
        //    69: ldc             "isSideLoaded"
        //    71: ldc_w           "true"
        //    74: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    79: pop            
        //    80: aload_2        
        //    81: areturn        
        //    82: astore_0       
        //    83: aconst_null    
        //    84: astore_0       
        //    85: aload_1        
        //    86: getstatic       io/sentry/l4.DEBUG:Lio/sentry/l4;
        //    89: ldc_w           "%s package isn't installed."
        //    92: iconst_1       
        //    93: anewarray       Ljava/lang/Object;
        //    96: dup            
        //    97: iconst_0       
        //    98: aload_0        
        //    99: aastore        
        //   100: invokeinterface io/sentry/n0.a:(Lio/sentry/l4;Ljava/lang/String;[Ljava/lang/Object;)V
        //   105: aconst_null    
        //   106: areturn        
        //   107: astore_2       
        //   108: goto            85
        //    Signature:
        //  (Landroid/content/Context;Lio/sentry/n0;Lio/sentry/android/core/l0;)Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                
        //  -----  -----  -----  -----  ------------------------------------
        //  0      12     82     85     Ljava/lang/IllegalArgumentException;
        //  20     25     82     85     Ljava/lang/IllegalArgumentException;
        //  25     39     107    111    Ljava/lang/IllegalArgumentException;
        //  43     65     107    111    Ljava/lang/IllegalArgumentException;
        //  68     80     107    111    Ljava/lang/IllegalArgumentException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0068:
        //     at w5.m.a(SourceFile:20)
        //     at w5.f.o(SourceFile:122)
        //     at w5.f.r(SourceFile:571)
        //     at w5.f.q(SourceFile:3)
        //     at a6.j.j(SourceFile:32)
        //     at a6.j.i(SourceFile:28)
        //     at a6.i.n(SourceFile:7)
        //     at a6.i.m(SourceFile:174)
        //     at a6.i.c(SourceFile:67)
        //     at a6.i.r(SourceFile:328)
        //     at a6.i.s(SourceFile:17)
        //     at a6.i.q(SourceFile:29)
        //     at a6.i.b(SourceFile:33)
        //     at y5.d.e(SourceFile:6)
        //     at y5.d.b(SourceFile:1)
        //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.decompileWithProcyon(SourceFile:306)
        //     at com.thesourceofcode.jadec.decompilers.JavaExtractionWorker.doWork(SourceFile:131)
        //     at com.thesourceofcode.jadec.decompilers.BaseDecompiler.withAttempt(SourceFile:3)
        //     at com.thesourceofcode.jadec.workers.DecompilerWorker.d(SourceFile:53)
        //     at com.thesourceofcode.jadec.workers.DecompilerWorker.b(SourceFile:1)
        //     at e7.a.run(SourceFile:1)
        //     at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1167)
        //     at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:641)
        //     at java.lang.Thread.run(Thread.java:923)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    static String l(final PackageInfo packageInfo, final l0 l0) {
        if (l0.d() >= 28) {
            return Long.toString(a.a(packageInfo));
        }
        return m(packageInfo);
    }
    
    private static String m(final PackageInfo packageInfo) {
        return Integer.toString(packageInfo.versionCode);
    }
    
    static boolean n(final Context context) {
        try {
            final Object systemService = context.getSystemService("activity");
            if (systemService instanceof ActivityManager) {
                final List runningAppProcesses = ((ActivityManager)systemService).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    final int myPid = Process.myPid();
                    for (final ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfo : runningAppProcesses) {
                        if (activityManager$RunningAppProcessInfo.pid == myPid) {
                            if (activityManager$RunningAppProcessInfo.importance == 100) {
                                return true;
                            }
                        }
                    }
                }
            }
            return false;
        }
        catch (final SecurityException ex) {}
        finally {
            return false;
        }
    }
}
