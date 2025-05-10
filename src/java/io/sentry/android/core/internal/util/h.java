package io.sentry.android.core.internal.util;

import java.util.ArrayList;
import java.util.List;

public final class h
{
    private static final h b;
    private final List<Integer> a;
    
    static {
        b = new h();
    }
    
    private h() {
        this.a = (List<Integer>)new ArrayList();
    }
    
    public static h a() {
        return h.b;
    }
    
    String b() {
        return "/sys/devices/system/cpu";
    }
    
    public List<Integer> c() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: dup            
        //     2: astore          9
        //     4: monitorenter   
        //     5: aload_0        
        //     6: getfield        io/sentry/android/core/internal/util/h.a:Ljava/util/List;
        //     9: invokeinterface java/util/List.isEmpty:()Z
        //    14: ifne            29
        //    17: aload_0        
        //    18: getfield        io/sentry/android/core/internal/util/h.a:Ljava/util/List;
        //    21: astore          6
        //    23: aload           9
        //    25: monitorexit    
        //    26: aload           6
        //    28: areturn        
        //    29: new             Ljava/io/File;
        //    32: astore          6
        //    34: aload           6
        //    36: aload_0        
        //    37: invokevirtual   io/sentry/android/core/internal/util/h.b:()Ljava/lang/String;
        //    40: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //    43: aload           6
        //    45: invokevirtual   java/io/File.listFiles:()[Ljava/io/File;
        //    48: astore          6
        //    50: aload           6
        //    52: ifnonnull       70
        //    55: new             Ljava/util/ArrayList;
        //    58: dup            
        //    59: invokespecial   java/util/ArrayList.<init>:()V
        //    62: astore          6
        //    64: aload           9
        //    66: monitorexit    
        //    67: aload           6
        //    69: areturn        
        //    70: aload           6
        //    72: arraylength    
        //    73: istore_2       
        //    74: iconst_0       
        //    75: istore_1       
        //    76: iload_1        
        //    77: iload_2        
        //    78: if_icmpge       189
        //    81: aload           6
        //    83: iload_1        
        //    84: aaload         
        //    85: astore          7
        //    87: aload           7
        //    89: invokevirtual   java/io/File.getName:()Ljava/lang/String;
        //    92: ldc             "cpu[0-9]+"
        //    94: invokevirtual   java/lang/String.matches:(Ljava/lang/String;)Z
        //    97: ifne            103
        //   100: goto            183
        //   103: new             Ljava/io/File;
        //   106: astore          8
        //   108: aload           8
        //   110: aload           7
        //   112: ldc             "cpufreq/cpuinfo_max_freq"
        //   114: invokespecial   java/io/File.<init>:(Ljava/io/File;Ljava/lang/String;)V
        //   117: aload           8
        //   119: invokevirtual   java/io/File.exists:()Z
        //   122: ifeq            183
        //   125: aload           8
        //   127: invokevirtual   java/io/File.canRead:()Z
        //   130: istore_3       
        //   131: iload_3        
        //   132: ifne            138
        //   135: goto            183
        //   138: aload           8
        //   140: invokestatic    io/sentry/util/e.b:(Ljava/io/File;)Ljava/lang/String;
        //   143: astore          7
        //   145: aload           7
        //   147: ifnonnull       153
        //   150: goto            183
        //   153: aload           7
        //   155: invokevirtual   java/lang/String.trim:()Ljava/lang/String;
        //   158: invokestatic    java/lang/Long.parseLong:(Ljava/lang/String;)J
        //   161: lstore          4
        //   163: aload_0        
        //   164: getfield        io/sentry/android/core/internal/util/h.a:Ljava/util/List;
        //   167: lload           4
        //   169: ldc2_w          1000
        //   172: ldiv           
        //   173: l2i            
        //   174: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //   177: invokeinterface java/util/List.add:(Ljava/lang/Object;)Z
        //   182: pop            
        //   183: iinc            1, 1
        //   186: goto            76
        //   189: aload_0        
        //   190: getfield        io/sentry/android/core/internal/util/h.a:Ljava/util/List;
        //   193: astore          6
        //   195: aload           9
        //   197: monitorexit    
        //   198: aload           6
        //   200: areturn        
        //   201: astore          6
        //   203: aload           9
        //   205: monitorexit    
        //   206: aload           6
        //   208: athrow         
        //   209: astore          7
        //   211: goto            183
        //    Signature:
        //  ()Ljava/util/List<Ljava/lang/Integer;>;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                             
        //  -----  -----  -----  -----  ---------------------------------
        //  5      23     201    209    Any
        //  29     50     201    209    Any
        //  55     64     201    209    Any
        //  70     74     201    209    Any
        //  87     100    201    209    Any
        //  103    131    201    209    Any
        //  138    145    209    214    Ljava/lang/NumberFormatException;
        //  138    145    209    214    Ljava/io/IOException;
        //  138    145    201    209    Any
        //  153    163    209    214    Ljava/lang/NumberFormatException;
        //  153    163    209    214    Ljava/io/IOException;
        //  153    163    201    209    Any
        //  163    183    201    209    Any
        //  189    195    201    209    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException: Attempt to invoke virtual method 'm5.p0 m5.v1.S()' on a null object reference
        //     at k5.v.o(SourceFile:28)
        //     at k5.v$b.t(SourceFile:103)
        //     at k5.v$b.a(SourceFile:11)
        //     at w5.a.P(SourceFile:168)
        //     at w5.a.j(SourceFile:193)
        //     at a6.j.j(SourceFile:23)
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
}
