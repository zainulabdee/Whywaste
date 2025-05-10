package a1;

import android.database.sqlite.SQLiteClosable;
import c1.f;
import java.util.Iterator;
import c1.c;
import t1.k$d;
import t1.j;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase$CursorFactory;
import android.database.SQLException;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import java.io.File;
import java.util.Arrays;
import android.util.Log;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$ApplicationInfoFlags;
import android.os.Build$VERSION;
import c1.e;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteProgram;
import android.database.Cursor;
import android.database.sqlite.SQLiteQuery;
import android.database.sqlite.SQLiteCursorDriver;
import java.util.HashMap;
import java.util.ArrayList;
import android.database.sqlite.SQLiteDatabase;
import java.util.Map;
import c1.g;
import java.util.List;
import android.content.Context;

class i
{
    private static Boolean n;
    final boolean a;
    final String b;
    final int c;
    final int d;
    final Context e;
    final List<g> f;
    final Map<Integer, t> g;
    public o h;
    SQLiteDatabase i;
    private int j;
    private int k;
    private Integer l;
    private int m;
    
    i(final Context e, final String b, final int c, final boolean a, final int d) {
        this.f = (List<g>)new ArrayList();
        this.g = (Map<Integer, t>)new HashMap();
        this.j = 0;
        this.k = 0;
        this.m = 0;
        this.e = e;
        this.b = b;
        this.a = a;
        this.c = c;
        this.d = d;
    }
    
    private void Q() {
        while (!this.f.isEmpty() && this.l == null) {
            ((g)this.f.get(0)).a();
            this.f.remove(0);
        }
    }
    
    private void S(final e e, final Runnable runnable) {
        final Integer g = e.g();
        final Integer l = this.l;
        if (l == null) {
            runnable.run();
        }
        else if (g != null && (g.equals((Object)l) || g == -1)) {
            runnable.run();
            if (this.l == null && !this.f.isEmpty()) {
                this.h.a(this, (Runnable)new h(this));
            }
        }
        else {
            this.f.add((Object)new g(e, runnable));
        }
    }
    
    protected static boolean i(final Context context, final String s, final boolean b) {
        try {
            final String packageName = context.getPackageName();
            ApplicationInfo applicationInfo;
            if (Build$VERSION.SDK_INT >= 33) {
                applicationInfo = context.getPackageManager().getApplicationInfo(packageName, PackageManager$ApplicationInfoFlags.of(128L));
            }
            else {
                applicationInfo = y(context, packageName, 128);
            }
            if (applicationInfo.metaData.getBoolean(s, b)) {
                return true;
            }
        }
        catch (final Exception ex) {
            ((Throwable)ex).printStackTrace();
        }
        return false;
    }
    
    protected static boolean j(final Context context) {
        return i(context, "com.tekartik.sqflite.wal_enabled", false);
    }
    
    private void l(final int n) {
        final t t = (t)this.g.get((Object)n);
        if (t != null) {
            this.m(t);
        }
    }
    
    private void m(final t t) {
        try {
            final int a = t.a;
            if (r.c(this.d)) {
                final StringBuilder sb = new StringBuilder();
                sb.append(this.A());
                sb.append("closing cursor ");
                sb.append(a);
                Log.d("Sqflite", sb.toString());
            }
            this.g.remove((Object)a);
            t.c.close();
        }
        catch (final Exception ex) {}
    }
    
    private Map<String, Object> n(final Cursor cursor, final Integer n) {
        Map map = null;
        List list = null;
        int n2 = 0;
        Object o;
        while (true) {
            o = map;
            if (!cursor.moveToNext()) {
                break;
            }
            o = map;
            Object o2 = list;
            int columnCount = n2;
            if (map == null) {
                o2 = new ArrayList();
                o = new HashMap();
                columnCount = cursor.getColumnCount();
                ((Map)o).put((Object)"columns", (Object)Arrays.asList((Object[])cursor.getColumnNames()));
                ((Map)o).put((Object)"rows", o2);
            }
            ((List)o2).add((Object)e0.a(cursor, columnCount));
            map = (Map)o;
            list = (List)o2;
            n2 = columnCount;
            if (n == null) {
                continue;
            }
            map = (Map)o;
            list = (List)o2;
            n2 = columnCount;
            if (((List)o2).size() >= n) {
                break;
            }
        }
        Object o3;
        if ((o3 = o) == null) {
            o3 = new HashMap();
        }
        return (Map<String, Object>)o3;
    }
    
    static void o(final String s) {
        SQLiteDatabase.deleteDatabase(new File(s));
    }
    
    private boolean p(final e e) {
        if (!this.w(e)) {
            return false;
        }
        ((f)e).a(null);
        return true;
    }
    
    private boolean q(final e p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1        
        //     2: invokespecial   a1/i.w:(Lc1/e;)Z
        //     5: ifne            10
        //     8: iconst_0       
        //     9: ireturn        
        //    10: aload_1        
        //    11: invokeinterface c1/e.e:()Z
        //    16: istore_2       
        //    17: aconst_null    
        //    18: astore          5
        //    20: iload_2        
        //    21: ifeq            33
        //    24: aload_1        
        //    25: aconst_null    
        //    26: invokeinterface c1/f.a:(Ljava/lang/Object;)V
        //    31: iconst_1       
        //    32: ireturn        
        //    33: aload_0        
        //    34: invokevirtual   a1/i.C:()Landroid/database/sqlite/SQLiteDatabase;
        //    37: ldc_w           "SELECT changes(), last_insert_rowid()"
        //    40: aconst_null    
        //    41: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQuery:(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
        //    44: astore          6
        //    46: aload           6
        //    48: ifnull          347
        //    51: aload           6
        //    53: astore          5
        //    55: aload           6
        //    57: invokeinterface android/database/Cursor.getCount:()I
        //    62: ifle            347
        //    65: aload           6
        //    67: astore          5
        //    69: aload           6
        //    71: invokeinterface android/database/Cursor.moveToFirst:()Z
        //    76: ifeq            347
        //    79: aload           6
        //    81: astore          5
        //    83: aload           6
        //    85: iconst_0       
        //    86: invokeinterface android/database/Cursor.getInt:(I)I
        //    91: ifne            220
        //    94: aload           6
        //    96: astore          5
        //    98: aload_0        
        //    99: getfield        a1/i.d:I
        //   102: invokestatic    a1/r.b:(I)Z
        //   105: ifeq            200
        //   108: aload           6
        //   110: astore          5
        //   112: new             Ljava/lang/StringBuilder;
        //   115: astore          7
        //   117: aload           6
        //   119: astore          5
        //   121: aload           7
        //   123: invokespecial   java/lang/StringBuilder.<init>:()V
        //   126: aload           6
        //   128: astore          5
        //   130: aload           7
        //   132: aload_0        
        //   133: invokevirtual   a1/i.A:()Ljava/lang/String;
        //   136: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   139: pop            
        //   140: aload           6
        //   142: astore          5
        //   144: aload           7
        //   146: ldc_w           "no changes (id was "
        //   149: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   152: pop            
        //   153: aload           6
        //   155: astore          5
        //   157: aload           7
        //   159: aload           6
        //   161: iconst_1       
        //   162: invokeinterface android/database/Cursor.getLong:(I)J
        //   167: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   170: pop            
        //   171: aload           6
        //   173: astore          5
        //   175: aload           7
        //   177: ldc_w           ")"
        //   180: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   183: pop            
        //   184: aload           6
        //   186: astore          5
        //   188: ldc_w           "Sqflite"
        //   191: aload           7
        //   193: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   196: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   199: pop            
        //   200: aload           6
        //   202: astore          5
        //   204: aload_1        
        //   205: aconst_null    
        //   206: invokeinterface c1/f.a:(Ljava/lang/Object;)V
        //   211: aload           6
        //   213: invokeinterface android/database/Cursor.close:()V
        //   218: iconst_1       
        //   219: ireturn        
        //   220: aload           6
        //   222: astore          5
        //   224: aload           6
        //   226: iconst_1       
        //   227: invokeinterface android/database/Cursor.getLong:(I)J
        //   232: lstore_3       
        //   233: aload           6
        //   235: astore          5
        //   237: aload_0        
        //   238: getfield        a1/i.d:I
        //   241: invokestatic    a1/r.b:(I)Z
        //   244: ifeq            319
        //   247: aload           6
        //   249: astore          5
        //   251: new             Ljava/lang/StringBuilder;
        //   254: astore          7
        //   256: aload           6
        //   258: astore          5
        //   260: aload           7
        //   262: invokespecial   java/lang/StringBuilder.<init>:()V
        //   265: aload           6
        //   267: astore          5
        //   269: aload           7
        //   271: aload_0        
        //   272: invokevirtual   a1/i.A:()Ljava/lang/String;
        //   275: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   278: pop            
        //   279: aload           6
        //   281: astore          5
        //   283: aload           7
        //   285: ldc_w           "inserted "
        //   288: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   291: pop            
        //   292: aload           6
        //   294: astore          5
        //   296: aload           7
        //   298: lload_3        
        //   299: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
        //   302: pop            
        //   303: aload           6
        //   305: astore          5
        //   307: ldc_w           "Sqflite"
        //   310: aload           7
        //   312: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   315: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   318: pop            
        //   319: aload           6
        //   321: astore          5
        //   323: aload_1        
        //   324: lload_3        
        //   325: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
        //   328: invokeinterface c1/f.a:(Ljava/lang/Object;)V
        //   333: aload           6
        //   335: invokeinterface android/database/Cursor.close:()V
        //   340: iconst_1       
        //   341: ireturn        
        //   342: astore          7
        //   344: goto            442
        //   347: aload           6
        //   349: astore          5
        //   351: new             Ljava/lang/StringBuilder;
        //   354: astore          7
        //   356: aload           6
        //   358: astore          5
        //   360: aload           7
        //   362: invokespecial   java/lang/StringBuilder.<init>:()V
        //   365: aload           6
        //   367: astore          5
        //   369: aload           7
        //   371: aload_0        
        //   372: invokevirtual   a1/i.A:()Ljava/lang/String;
        //   375: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   378: pop            
        //   379: aload           6
        //   381: astore          5
        //   383: aload           7
        //   385: ldc_w           "fail to read changes for Insert"
        //   388: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   391: pop            
        //   392: aload           6
        //   394: astore          5
        //   396: ldc_w           "Sqflite"
        //   399: aload           7
        //   401: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   404: invokestatic    android/util/Log.e:(Ljava/lang/String;Ljava/lang/String;)I
        //   407: pop            
        //   408: aload           6
        //   410: astore          5
        //   412: aload_1        
        //   413: aconst_null    
        //   414: invokeinterface c1/f.a:(Ljava/lang/Object;)V
        //   419: aload           6
        //   421: ifnull          431
        //   424: aload           6
        //   426: invokeinterface android/database/Cursor.close:()V
        //   431: iconst_1       
        //   432: ireturn        
        //   433: astore_1       
        //   434: goto            468
        //   437: astore          7
        //   439: aconst_null    
        //   440: astore          6
        //   442: aload           6
        //   444: astore          5
        //   446: aload_0        
        //   447: aload           7
        //   449: aload_1        
        //   450: invokevirtual   a1/i.D:(Ljava/lang/Exception;Lc1/e;)V
        //   453: aload           6
        //   455: ifnull          465
        //   458: aload           6
        //   460: invokeinterface android/database/Cursor.close:()V
        //   465: iconst_0       
        //   466: ireturn        
        //   467: astore_1       
        //   468: aload           5
        //   470: ifnull          480
        //   473: aload           5
        //   475: invokeinterface android/database/Cursor.close:()V
        //   480: aload_1        
        //   481: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  33     46     437    442    Ljava/lang/Exception;
        //  33     46     433    437    Any
        //  55     65     342    347    Ljava/lang/Exception;
        //  55     65     467    468    Any
        //  69     79     342    347    Ljava/lang/Exception;
        //  69     79     467    468    Any
        //  83     94     342    347    Ljava/lang/Exception;
        //  83     94     467    468    Any
        //  98     108    342    347    Ljava/lang/Exception;
        //  98     108    467    468    Any
        //  112    117    342    347    Ljava/lang/Exception;
        //  112    117    467    468    Any
        //  121    126    342    347    Ljava/lang/Exception;
        //  121    126    467    468    Any
        //  130    140    342    347    Ljava/lang/Exception;
        //  130    140    467    468    Any
        //  144    153    342    347    Ljava/lang/Exception;
        //  144    153    467    468    Any
        //  157    171    342    347    Ljava/lang/Exception;
        //  157    171    467    468    Any
        //  175    184    342    347    Ljava/lang/Exception;
        //  175    184    467    468    Any
        //  188    200    342    347    Ljava/lang/Exception;
        //  188    200    467    468    Any
        //  204    211    342    347    Ljava/lang/Exception;
        //  204    211    467    468    Any
        //  224    233    342    347    Ljava/lang/Exception;
        //  224    233    467    468    Any
        //  237    247    342    347    Ljava/lang/Exception;
        //  237    247    467    468    Any
        //  251    256    342    347    Ljava/lang/Exception;
        //  251    256    467    468    Any
        //  260    265    342    347    Ljava/lang/Exception;
        //  260    265    467    468    Any
        //  269    279    342    347    Ljava/lang/Exception;
        //  269    279    467    468    Any
        //  283    292    342    347    Ljava/lang/Exception;
        //  283    292    467    468    Any
        //  296    303    342    347    Ljava/lang/Exception;
        //  296    303    467    468    Any
        //  307    319    342    347    Ljava/lang/Exception;
        //  307    319    467    468    Any
        //  323    333    342    347    Ljava/lang/Exception;
        //  323    333    467    468    Any
        //  351    356    342    347    Ljava/lang/Exception;
        //  351    356    467    468    Any
        //  360    365    342    347    Ljava/lang/Exception;
        //  360    365    467    468    Any
        //  369    379    342    347    Ljava/lang/Exception;
        //  369    379    467    468    Any
        //  383    392    342    347    Ljava/lang/Exception;
        //  383    392    467    468    Any
        //  396    408    342    347    Ljava/lang/Exception;
        //  396    408    467    468    Any
        //  412    419    342    347    Ljava/lang/Exception;
        //  412    419    467    468    Any
        //  446    453    467    468    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0200:
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
    
    private boolean r(final e p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "cursorPageSize"
        //     4: invokeinterface c1/e.c:(Ljava/lang/String;)Ljava/lang/Object;
        //     9: checkcast       Ljava/lang/Integer;
        //    12: astore          10
        //    14: aload_1        
        //    15: invokeinterface c1/e.d:()La1/d0;
        //    20: astore          5
        //    22: aload_0        
        //    23: getfield        a1/i.d:I
        //    26: invokestatic    a1/r.b:(I)Z
        //    29: ifeq            67
        //    32: new             Ljava/lang/StringBuilder;
        //    35: dup            
        //    36: invokespecial   java/lang/StringBuilder.<init>:()V
        //    39: astore_3       
        //    40: aload_3        
        //    41: aload_0        
        //    42: invokevirtual   a1/i.A:()Ljava/lang/String;
        //    45: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    48: pop            
        //    49: aload_3        
        //    50: aload           5
        //    52: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //    55: pop            
        //    56: ldc_w           "Sqflite"
        //    59: aload_3        
        //    60: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    63: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //    66: pop            
        //    67: aconst_null    
        //    68: astore          9
        //    70: aconst_null    
        //    71: astore          6
        //    73: aconst_null    
        //    74: astore          8
        //    76: aconst_null    
        //    77: astore_3       
        //    78: aconst_null    
        //    79: astore          4
        //    81: aload_0        
        //    82: invokevirtual   a1/i.z:()Landroid/database/sqlite/SQLiteDatabase;
        //    85: astore          11
        //    87: new             La1/f;
        //    90: astore          7
        //    92: aload           7
        //    94: aload           5
        //    96: invokespecial   a1/f.<init>:(La1/d0;)V
        //    99: aload           11
        //   101: aload           7
        //   103: aload           5
        //   105: invokevirtual   a1/d0.c:()Ljava/lang/String;
        //   108: getstatic       a1/a.a:[Ljava/lang/String;
        //   111: aconst_null    
        //   112: invokevirtual   android/database/sqlite/SQLiteDatabase.rawQueryWithFactory:(Landroid/database/sqlite/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
        //   115: astore          5
        //   117: aload           9
        //   119: astore          7
        //   121: aload           5
        //   123: astore          6
        //   125: aload           8
        //   127: astore_3       
        //   128: aload_0        
        //   129: aload           5
        //   131: aload           10
        //   133: invokespecial   a1/i.n:(Landroid/database/Cursor;Ljava/lang/Integer;)Ljava/util/Map;
        //   136: astore          11
        //   138: aload           10
        //   140: ifnull          190
        //   143: aload           9
        //   145: astore          7
        //   147: aload           5
        //   149: astore          6
        //   151: aload           8
        //   153: astore_3       
        //   154: aload           5
        //   156: invokeinterface android/database/Cursor.isLast:()Z
        //   161: ifne            190
        //   164: aload           9
        //   166: astore          7
        //   168: aload           5
        //   170: astore          6
        //   172: aload           8
        //   174: astore_3       
        //   175: aload           5
        //   177: invokeinterface android/database/Cursor.isAfterLast:()Z
        //   182: ifne            190
        //   185: iconst_1       
        //   186: istore_2       
        //   187: goto            192
        //   190: iconst_0       
        //   191: istore_2       
        //   192: iload_2        
        //   193: ifeq            327
        //   196: aload           9
        //   198: astore          7
        //   200: aload           5
        //   202: astore          6
        //   204: aload           8
        //   206: astore_3       
        //   207: aload_0        
        //   208: getfield        a1/i.m:I
        //   211: iconst_1       
        //   212: iadd           
        //   213: istore_2       
        //   214: aload           9
        //   216: astore          7
        //   218: aload           5
        //   220: astore          6
        //   222: aload           8
        //   224: astore_3       
        //   225: aload_0        
        //   226: iload_2        
        //   227: putfield        a1/i.m:I
        //   230: aload           9
        //   232: astore          7
        //   234: aload           5
        //   236: astore          6
        //   238: aload           8
        //   240: astore_3       
        //   241: aload           11
        //   243: ldc_w           "cursorId"
        //   246: iload_2        
        //   247: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   250: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   255: pop            
        //   256: aload           9
        //   258: astore          7
        //   260: aload           5
        //   262: astore          6
        //   264: aload           8
        //   266: astore_3       
        //   267: new             La1/t;
        //   270: astore          4
        //   272: aload           9
        //   274: astore          7
        //   276: aload           5
        //   278: astore          6
        //   280: aload           8
        //   282: astore_3       
        //   283: aload           4
        //   285: iload_2        
        //   286: aload           10
        //   288: invokevirtual   java/lang/Integer.intValue:()I
        //   291: aload           5
        //   293: invokespecial   a1/t.<init>:(IILandroid/database/Cursor;)V
        //   296: aload_0        
        //   297: getfield        a1/i.g:Ljava/util/Map;
        //   300: iload_2        
        //   301: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   304: aload           4
        //   306: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   311: pop            
        //   312: goto            327
        //   315: astore_1       
        //   316: aload           4
        //   318: astore_3       
        //   319: goto            446
        //   322: astore          8
        //   324: goto            390
        //   327: aload           4
        //   329: astore          7
        //   331: aload           5
        //   333: astore          6
        //   335: aload           4
        //   337: astore_3       
        //   338: aload_1        
        //   339: aload           11
        //   341: invokeinterface c1/f.a:(Ljava/lang/Object;)V
        //   346: aload           4
        //   348: ifnonnull       363
        //   351: aload           5
        //   353: ifnull          363
        //   356: aload           5
        //   358: invokeinterface android/database/Cursor.close:()V
        //   363: iconst_1       
        //   364: ireturn        
        //   365: astore          8
        //   367: aload           7
        //   369: astore          4
        //   371: goto            390
        //   374: astore_1       
        //   375: aconst_null    
        //   376: astore          5
        //   378: goto            446
        //   381: astore          8
        //   383: aconst_null    
        //   384: astore          5
        //   386: aload           6
        //   388: astore          4
        //   390: aload           5
        //   392: astore          6
        //   394: aload           4
        //   396: astore_3       
        //   397: aload_0        
        //   398: aload           8
        //   400: aload_1        
        //   401: invokevirtual   a1/i.D:(Ljava/lang/Exception;Lc1/e;)V
        //   404: aload           4
        //   406: ifnull          422
        //   409: aload           5
        //   411: astore          6
        //   413: aload           4
        //   415: astore_3       
        //   416: aload_0        
        //   417: aload           4
        //   419: invokespecial   a1/i.m:(La1/t;)V
        //   422: aload           4
        //   424: ifnonnull       439
        //   427: aload           5
        //   429: ifnull          439
        //   432: aload           5
        //   434: invokeinterface android/database/Cursor.close:()V
        //   439: iconst_0       
        //   440: ireturn        
        //   441: astore_1       
        //   442: aload           6
        //   444: astore          5
        //   446: aload_3        
        //   447: ifnonnull       462
        //   450: aload           5
        //   452: ifnull          462
        //   455: aload           5
        //   457: invokeinterface android/database/Cursor.close:()V
        //   462: aload_1        
        //   463: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  81     117    381    390    Ljava/lang/Exception;
        //  81     117    374    381    Any
        //  128    138    365    374    Ljava/lang/Exception;
        //  128    138    441    446    Any
        //  154    164    365    374    Ljava/lang/Exception;
        //  154    164    441    446    Any
        //  175    185    365    374    Ljava/lang/Exception;
        //  175    185    441    446    Any
        //  207    214    365    374    Ljava/lang/Exception;
        //  207    214    441    446    Any
        //  225    230    365    374    Ljava/lang/Exception;
        //  225    230    441    446    Any
        //  241    256    365    374    Ljava/lang/Exception;
        //  241    256    441    446    Any
        //  267    272    365    374    Ljava/lang/Exception;
        //  267    272    441    446    Any
        //  283    296    365    374    Ljava/lang/Exception;
        //  283    296    441    446    Any
        //  296    312    322    327    Ljava/lang/Exception;
        //  296    312    315    322    Any
        //  338    346    365    374    Ljava/lang/Exception;
        //  338    346    441    446    Any
        //  397    404    441    446    Any
        //  416    422    441    446    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0190:
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
    
    private boolean s(final e p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "cursorId"
        //     4: invokeinterface c1/e.c:(Ljava/lang/String;)Ljava/lang/Object;
        //     9: checkcast       Ljava/lang/Integer;
        //    12: invokevirtual   java/lang/Integer.intValue:()I
        //    15: istore          4
        //    17: getstatic       java/lang/Boolean.TRUE:Ljava/lang/Boolean;
        //    20: aload_1        
        //    21: ldc_w           "cancel"
        //    24: invokeinterface c1/e.c:(Ljava/lang/String;)Ljava/lang/Object;
        //    29: invokevirtual   java/lang/Boolean.equals:(Ljava/lang/Object;)Z
        //    32: istore          5
        //    34: aload_0        
        //    35: getfield        a1/i.d:I
        //    38: invokestatic    a1/r.c:(I)Z
        //    41: ifeq            118
        //    44: new             Ljava/lang/StringBuilder;
        //    47: dup            
        //    48: invokespecial   java/lang/StringBuilder.<init>:()V
        //    51: astore          7
        //    53: aload           7
        //    55: aload_0        
        //    56: invokevirtual   a1/i.A:()Ljava/lang/String;
        //    59: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    62: pop            
        //    63: aload           7
        //    65: ldc_w           "cursor "
        //    68: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    71: pop            
        //    72: aload           7
        //    74: iload           4
        //    76: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    79: pop            
        //    80: iload           5
        //    82: ifeq            93
        //    85: ldc_w           " cancel"
        //    88: astore          6
        //    90: goto            98
        //    93: ldc_w           " next"
        //    96: astore          6
        //    98: aload           7
        //   100: aload           6
        //   102: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   105: pop            
        //   106: ldc_w           "Sqflite"
        //   109: aload           7
        //   111: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   114: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
        //   117: pop            
        //   118: aconst_null    
        //   119: astore          8
        //   121: iload           5
        //   123: ifeq            141
        //   126: aload_0        
        //   127: iload           4
        //   129: invokespecial   a1/i.l:(I)V
        //   132: aload_1        
        //   133: aconst_null    
        //   134: invokeinterface c1/f.a:(Ljava/lang/Object;)V
        //   139: iconst_1       
        //   140: ireturn        
        //   141: aload_0        
        //   142: getfield        a1/i.g:Ljava/util/Map;
        //   145: iload           4
        //   147: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   150: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   155: checkcast       La1/t;
        //   158: astore          7
        //   160: iconst_0       
        //   161: istore_2       
        //   162: aload           7
        //   164: ifnull          281
        //   167: aload           7
        //   169: getfield        a1/t.c:Landroid/database/Cursor;
        //   172: astore          9
        //   174: aload_0        
        //   175: aload           9
        //   177: aload           7
        //   179: getfield        a1/t.b:I
        //   182: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   185: invokespecial   a1/i.n:(Landroid/database/Cursor;Ljava/lang/Integer;)Ljava/util/Map;
        //   188: astore          6
        //   190: aload           9
        //   192: invokeinterface android/database/Cursor.isLast:()Z
        //   197: ifne            219
        //   200: aload           9
        //   202: invokeinterface android/database/Cursor.isAfterLast:()Z
        //   207: istore          5
        //   209: iload           5
        //   211: ifne            219
        //   214: iconst_1       
        //   215: istore_2       
        //   216: goto            221
        //   219: iconst_0       
        //   220: istore_2       
        //   221: iload_2        
        //   222: ifeq            243
        //   225: iload_2        
        //   226: istore_3       
        //   227: aload           6
        //   229: ldc_w           "cursorId"
        //   232: iload           4
        //   234: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   237: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   242: pop            
        //   243: iload_2        
        //   244: istore_3       
        //   245: aload_1        
        //   246: aload           6
        //   248: invokeinterface c1/f.a:(Ljava/lang/Object;)V
        //   253: iload_2        
        //   254: ifne            263
        //   257: aload_0        
        //   258: aload           7
        //   260: invokespecial   a1/i.m:(La1/t;)V
        //   263: iconst_1       
        //   264: ireturn        
        //   265: astore          6
        //   267: goto            335
        //   270: astore_1       
        //   271: goto            384
        //   274: astore          6
        //   276: iconst_0       
        //   277: istore_2       
        //   278: goto            335
        //   281: new             Ljava/lang/IllegalStateException;
        //   284: astore          9
        //   286: new             Ljava/lang/StringBuilder;
        //   289: astore          6
        //   291: aload           6
        //   293: invokespecial   java/lang/StringBuilder.<init>:()V
        //   296: aload           6
        //   298: ldc_w           "Cursor "
        //   301: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   304: pop            
        //   305: aload           6
        //   307: iload           4
        //   309: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   312: pop            
        //   313: aload           6
        //   315: ldc_w           " not found"
        //   318: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   321: pop            
        //   322: aload           9
        //   324: aload           6
        //   326: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   329: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   332: aload           9
        //   334: athrow         
        //   335: iload_2        
        //   336: istore_3       
        //   337: aload_0        
        //   338: aload           6
        //   340: aload_1        
        //   341: invokevirtual   a1/i.D:(Ljava/lang/Exception;Lc1/e;)V
        //   344: aload           7
        //   346: ifnull          363
        //   349: iload_2        
        //   350: istore_3       
        //   351: aload_0        
        //   352: aload           7
        //   354: invokespecial   a1/i.m:(La1/t;)V
        //   357: aload           8
        //   359: astore_1       
        //   360: goto            366
        //   363: aload           7
        //   365: astore_1       
        //   366: iload_2        
        //   367: ifne            379
        //   370: aload_1        
        //   371: ifnull          379
        //   374: aload_0        
        //   375: aload_1        
        //   376: invokespecial   a1/i.m:(La1/t;)V
        //   379: iconst_0       
        //   380: ireturn        
        //   381: astore_1       
        //   382: iload_3        
        //   383: istore_2       
        //   384: iload_2        
        //   385: ifne            399
        //   388: aload           7
        //   390: ifnull          399
        //   393: aload_0        
        //   394: aload           7
        //   396: invokespecial   a1/i.m:(La1/t;)V
        //   399: aload_1        
        //   400: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  167    209    274    281    Ljava/lang/Exception;
        //  167    209    270    274    Any
        //  227    243    265    270    Ljava/lang/Exception;
        //  227    243    381    384    Any
        //  245    253    265    270    Ljava/lang/Exception;
        //  245    253    381    384    Any
        //  281    335    274    281    Ljava/lang/Exception;
        //  281    335    270    274    Any
        //  337    344    381    384    Any
        //  351    357    381    384    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0243:
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
    
    private boolean t(final e e) {
        if (!this.w(e)) {
            return false;
        }
        final boolean e2 = e.e();
        final StringBuilder sb = null;
        Object o = null;
        if (e2) {
            ((f)e).a(null);
            return true;
        }
        Label_0270: {
            Object rawQuery;
            try {
                try {
                    rawQuery = this.C().rawQuery("SELECT changes()", (String[])null);
                    if (rawQuery != null) {
                        try {
                            if (((Cursor)rawQuery).getCount() > 0 && ((Cursor)rawQuery).moveToFirst()) {
                                final int int1 = ((Cursor)rawQuery).getInt(0);
                                if (r.b(this.d)) {
                                    o = new StringBuilder();
                                    ((StringBuilder)o).append(this.A());
                                    ((StringBuilder)o).append("changed ");
                                    ((StringBuilder)o).append(int1);
                                    Log.d("Sqflite", ((StringBuilder)o).toString());
                                }
                                ((f)e).a(int1);
                                ((Cursor)rawQuery).close();
                                return true;
                            }
                        }
                        catch (final Exception ex) {}
                        finally {
                            o = rawQuery;
                            break Label_0270;
                        }
                    }
                    o = new StringBuilder();
                    ((StringBuilder)o).append(this.A());
                    ((StringBuilder)o).append("fail to read changes for Update/Delete");
                    Log.e("Sqflite", ((StringBuilder)o).toString());
                    ((f)e).a(null);
                    if (rawQuery != null) {
                        ((Cursor)rawQuery).close();
                    }
                    return true;
                }
                finally {}
            }
            catch (final Exception ex) {
                rawQuery = sb;
            }
            final Exception ex;
            this.D(ex, e);
            if (rawQuery != null) {
                ((Cursor)rawQuery).close();
            }
            return false;
        }
        if (o != null) {
            ((Cursor)o).close();
        }
    }
    
    private boolean w(final e e) {
        final d0 d = e.d();
        if (r.b(this.d)) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.A());
            sb.append((Object)d);
            Log.d("Sqflite", sb.toString());
        }
        final Boolean f = e.f();
        try {
            this.C().execSQL(d.c(), d.d());
            this.u(f);
            return true;
        }
        catch (final Exception ex) {
            this.D(ex, e);
            return false;
        }
    }
    
    public static boolean x(final String s) {
        boolean exists;
        try {
            exists = new File(s).exists();
        }
        catch (final Exception ex) {
            exists = false;
        }
        return exists;
    }
    
    static ApplicationInfo y(final Context context, final String s, final int n) {
        return context.getPackageManager().getApplicationInfo(s, n);
    }
    
    String A() {
        final StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(this.B());
        sb.append("] ");
        return sb.toString();
    }
    
    String B() {
        final Thread currentThread = Thread.currentThread();
        final StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.c);
        sb.append(",");
        sb.append(currentThread.getName());
        sb.append("(");
        sb.append(currentThread.getId());
        sb.append(")");
        return sb.toString();
    }
    
    public SQLiteDatabase C() {
        return this.i;
    }
    
    void D(final Exception ex, final e e) {
        if (ex instanceof SQLiteCantOpenDatabaseException) {
            final StringBuilder sb = new StringBuilder();
            sb.append("open_failed ");
            sb.append(this.b);
            ((f)e).b("sqlite_error", sb.toString(), null);
            return;
        }
        if (ex instanceof SQLException) {
            ((f)e).b("sqlite_error", ((Throwable)ex).getMessage(), c1.h.a(e));
            return;
        }
        ((f)e).b("sqlite_error", ((Throwable)ex).getMessage(), c1.h.a(e));
    }
    
    public void E(final e e) {
        this.S(e, (Runnable)new d(this, e));
    }
    
    boolean F() {
        synchronized (this) {
            return this.j > 0;
        }
    }
    
    public void M() {
        if (a1.i.n == null && (a1.i.n = j(this.e)) && r.c(this.d)) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.A());
            sb.append("[sqflite] WAL enabled");
            Log.d("Sqflite", sb.toString());
        }
        int n;
        if (a1.i.n) {
            n = 805306368;
        }
        else {
            n = 268435456;
        }
        this.i = SQLiteDatabase.openDatabase(this.b, (SQLiteDatabase$CursorFactory)null, n);
    }
    
    public void N() {
        this.i = SQLiteDatabase.openDatabase(this.b, (SQLiteDatabase$CursorFactory)null, 1, (DatabaseErrorHandler)new DatabaseErrorHandler(this) {
            final i a;
            
            public void onCorruption(final SQLiteDatabase sqLiteDatabase) {
            }
        });
    }
    
    public void O(final e e) {
        this.S(e, (Runnable)new a1.e(this, e));
    }
    
    public void P(final e e) {
        this.S(e, (Runnable)new b(this, e));
    }
    
    public void R(final e e) {
        this.S(e, (Runnable)new a1.g(this, e));
    }
    
    void h(final j j, final k$d k$d) {
        final c1.d d = new c1.d(j, k$d);
        final boolean e = ((c1.b)d).e();
        final boolean k = ((c1.b)d).k();
        final List list = (List)d.c("operations");
        final ArrayList list2 = new ArrayList();
        final Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            final c c = new c((Map)iterator.next(), e);
            final String method = c.getMethod();
            method.hashCode();
            int n = -1;
            switch (method.hashCode()) {
                case 107944136: {
                    if (!method.equals((Object)"query")) {
                        break;
                    }
                    n = 3;
                    break;
                }
                case -838846263: {
                    if (!method.equals((Object)"update")) {
                        break;
                    }
                    n = 2;
                    break;
                }
                case -1183792455: {
                    if (!method.equals((Object)"insert")) {
                        break;
                    }
                    n = 1;
                    break;
                }
                case -1319569547: {
                    if (!method.equals((Object)"execute")) {
                        break;
                    }
                    n = 0;
                    break;
                }
            }
            switch (n) {
                default: {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Batch method '");
                    sb.append(method);
                    sb.append("' not supported");
                    k$d.b("bad_param", sb.toString(), (Object)null);
                    return;
                }
                case 3: {
                    if (this.r((e)c)) {
                        c.s((List)list2);
                        continue;
                    }
                    if (k) {
                        c.r((List)list2);
                        continue;
                    }
                    c.q(k$d);
                    return;
                }
                case 2: {
                    if (this.t((e)c)) {
                        c.s((List)list2);
                        continue;
                    }
                    if (k) {
                        c.r((List)list2);
                        continue;
                    }
                    c.q(k$d);
                    return;
                }
                case 1: {
                    if (this.q((e)c)) {
                        c.s((List)list2);
                        continue;
                    }
                    if (k) {
                        c.r((List)list2);
                        continue;
                    }
                    c.q(k$d);
                    return;
                }
                case 0: {
                    if (this.p((e)c)) {
                        c.s((List)list2);
                        continue;
                    }
                    if (k) {
                        c.r((List)list2);
                        continue;
                    }
                    c.q(k$d);
                    return;
                }
            }
        }
        if (e) {
            k$d.a((Object)null);
        }
        else {
            k$d.a((Object)list2);
        }
    }
    
    public void k() {
        if (!this.g.isEmpty() && r.b(this.d)) {
            final StringBuilder sb = new StringBuilder();
            sb.append(this.A());
            sb.append(this.g.size());
            sb.append(" cursor(s) are left opened");
            Log.d("Sqflite", sb.toString());
        }
        ((SQLiteClosable)this.i).close();
    }
    
    void u(final Boolean b) {
        synchronized (this) {
            if (Boolean.TRUE.equals((Object)b)) {
                ++this.j;
            }
            else if (Boolean.FALSE.equals((Object)b)) {
                --this.j;
            }
        }
    }
    
    public void v(final e e) {
        this.S(e, (Runnable)new a1.c(this, e));
    }
    
    public SQLiteDatabase z() {
        return this.i;
    }
}
