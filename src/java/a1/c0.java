package a1;

import android.os.Build$VERSION;
import k1.a$b;
import t1.l;
import t1.s;
import t1.c;
import c1.e;
import c1.d;
import java.util.Iterator;
import java.util.Map$Entry;
import android.util.Log;
import t1.j;
import java.util.HashMap;
import android.content.Context;
import java.util.Map;
import t1.k;
import k1.a;

public class c0 implements a, c
{
    static final Map<String, Integer> c;
    static final Map<Integer, i> d;
    private static final Object e;
    private static final Object f;
    static int g;
    static String h;
    private static int i;
    private static int j;
    private static int k;
    private static o l;
    private Context a;
    private k b;
    
    static {
        c = (Map)new HashMap();
        d = (Map)new HashMap();
        e = new Object();
        f = new Object();
        c0.g = 0;
        c0.i = 0;
        c0.j = 1;
        c0.k = 0;
    }
    
    private void A(final j j, final d d) {
        final int intValue = j.a("id");
        final i n = this.n(j, d);
        if (n == null) {
            return;
        }
        if (r.b(n.d)) {
            final StringBuilder sb = new StringBuilder();
            sb.append(n.A());
            sb.append("closing ");
            sb.append(intValue);
            sb.append(" ");
            sb.append(n.b);
            Log.d("Sqflite", sb.toString());
        }
        final String b = n.b;
        final Object e = c0.e;
        synchronized (e) {
            c0.d.remove((Object)intValue);
            if (n.a) {
                c0.c.remove((Object)b);
            }
            monitorexit(e);
            c0.l.a(n, (Runnable)new c0$a(this, n, d));
        }
    }
    
    private void B(final j j, final d d) {
        d.a(a1.i.x((String)j.a("path")));
    }
    
    private void C(final j j, final d d) {
        final String s = j.a("cmd");
        final HashMap hashMap = new HashMap();
        if ("get".equals((Object)s)) {
            final int g = c0.g;
            if (g > 0) {
                ((Map)hashMap).put((Object)"logLevel", (Object)g);
            }
            final Map<Integer, i> d2 = c0.d;
            if (!d2.isEmpty()) {
                final HashMap hashMap2 = new HashMap();
                for (final Map$Entry map$Entry : d2.entrySet()) {
                    final i i = (i)map$Entry.getValue();
                    final HashMap hashMap3 = new HashMap();
                    ((Map)hashMap3).put((Object)"path", (Object)i.b);
                    ((Map)hashMap3).put((Object)"singleInstance", (Object)i.a);
                    final int d3 = i.d;
                    if (d3 > 0) {
                        ((Map)hashMap3).put((Object)"logLevel", (Object)d3);
                    }
                    ((Map)hashMap2).put((Object)((Integer)map$Entry.getKey()).toString(), (Object)hashMap3);
                }
                ((Map)hashMap).put((Object)"databases", (Object)hashMap2);
            }
        }
        d.a(hashMap);
    }
    
    private void D(final j j, final d d) {
        b1.a.a = Boolean.TRUE.equals(j.b());
        b1.a.c = (b1.a.b && b1.a.a);
        if (b1.a.a) {
            if (b1.a.c) {
                c0.g = 2;
            }
            else if (b1.a.a) {
                c0.g = 1;
            }
        }
        else {
            c0.g = 0;
        }
        d.a(null);
    }
    
    private void E(final j j, final d d) {
        final String s = j.a("path");
        final Object e = c0.e;
        synchronized (e) {
            if (r.c(c0.g)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Look for ");
                sb.append(s);
                sb.append(" in ");
                sb.append((Object)c0.c.keySet());
                Log.d("Sqflite", sb.toString());
            }
            final Map<String, Integer> c = c0.c;
            final Integer n = (Integer)c.get((Object)s);
            i k = null;
            Label_0261: {
                if (n != null) {
                    final Map<Integer, i> d2 = c0.d;
                    final i i = (i)d2.get((Object)n);
                    if (i != null && i.i.isOpen()) {
                        if (r.c(c0.g)) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(i.A());
                            sb2.append("found single instance ");
                            String s2;
                            if (i.F()) {
                                s2 = "(in transaction) ";
                            }
                            else {
                                s2 = "";
                            }
                            sb2.append(s2);
                            sb2.append((Object)n);
                            sb2.append(" ");
                            sb2.append(s);
                            Log.d("Sqflite", sb2.toString());
                        }
                        d2.remove((Object)n);
                        c.remove((Object)s);
                        k = i;
                        break Label_0261;
                    }
                }
                k = null;
            }
            monitorexit(e);
            final c0$b c0$b = new c0$b(this, k, s, d);
            final o l = c0.l;
            if (l != null) {
                l.a(k, (Runnable)c0$b);
            }
            else {
                ((Runnable)c0$b).run();
            }
        }
    }
    
    private void F(final j j, final d d) {
        final i n = this.n(j, d);
        if (n == null) {
            return;
        }
        c0.l.a(n, (Runnable)new x(j, d, n));
    }
    
    private void H(final j j, final d d) {
        final i n = this.n(j, d);
        if (n == null) {
            return;
        }
        c0.l.a(n, (Runnable)new u(j, d, n));
    }
    
    private void I(final j j, final d d) {
        final String s = j.a("path");
        Object o = j.a("readOnly");
        final boolean o2 = o(s);
        final boolean b = !Boolean.FALSE.equals(j.a("singleInstance")) && !o2;
        if (b) {
            final Object e = c0.e;
            synchronized (e) {
                if (r.c(c0.g)) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("Look for ");
                    sb.append(s);
                    sb.append(" in ");
                    sb.append((Object)c0.c.keySet());
                    Log.d("Sqflite", sb.toString());
                }
                final Integer n = (Integer)c0.c.get((Object)s);
                if (n != null) {
                    final i i = (i)c0.d.get((Object)n);
                    if (i != null) {
                        if (i.i.isOpen()) {
                            if (r.c(c0.g)) {
                                o = new StringBuilder();
                                ((StringBuilder)o).append(i.A());
                                ((StringBuilder)o).append("re-opened single instance ");
                                String s2;
                                if (i.F()) {
                                    s2 = "(in transaction) ";
                                }
                                else {
                                    s2 = "";
                                }
                                ((StringBuilder)o).append(s2);
                                ((StringBuilder)o).append((Object)n);
                                ((StringBuilder)o).append(" ");
                                ((StringBuilder)o).append(s);
                                Log.d("Sqflite", ((StringBuilder)o).toString());
                            }
                            d.a(x(n, true, i.F()));
                            return;
                        }
                        if (r.c(c0.g)) {
                            final StringBuilder sb2 = new StringBuilder();
                            sb2.append(i.A());
                            sb2.append("single instance database of ");
                            sb2.append(s);
                            sb2.append(" not opened");
                            Log.d("Sqflite", sb2.toString());
                        }
                    }
                }
            }
        }
        final Object e2 = c0.e;
        synchronized (e2) {
            final int n2 = ++c0.k;
            monitorexit(e2);
            final i k = new i(this.a, s, n2, b, c0.g);
            synchronized (e2) {
                if (c0.l == null) {
                    (c0.l = n.b("Sqflite", c0.j, c0.i)).start();
                    if (r.b(k.d)) {
                        final StringBuilder sb3 = new StringBuilder();
                        sb3.append(k.A());
                        sb3.append("starting worker pool with priority ");
                        sb3.append(c0.i);
                        Log.d("Sqflite", sb3.toString());
                    }
                }
                k.h = c0.l;
                if (r.b(k.d)) {
                    final StringBuilder sb4 = new StringBuilder();
                    sb4.append(k.A());
                    sb4.append("opened ");
                    sb4.append(n2);
                    sb4.append(" ");
                    sb4.append(s);
                    Log.d("Sqflite", sb4.toString());
                }
                c0.l.a(k, (Runnable)new z(o2, s, d, (Boolean)o, k, j, b, n2));
            }
        }
    }
    
    private void K(final j j, final d d) {
        final i n = this.n(j, d);
        if (n == null) {
            return;
        }
        c0.l.a(n, (Runnable)new y(j, d, n));
    }
    
    private void L(final j j, final d d) {
        final i n = this.n(j, d);
        if (n == null) {
            return;
        }
        c0.l.a(n, (Runnable)new v(j, d, n));
    }
    
    private void M(final j j, final d d) {
        final i n = this.n(j, d);
        if (n == null) {
            return;
        }
        c0.l.a(n, (Runnable)new a0(j, n, d));
    }
    
    private void N(final j j, final d d) {
        final i n = this.n(j, d);
        if (n == null) {
            return;
        }
        c0.l.a(n, (Runnable)new w(j, d, n));
    }
    
    private void l(final i i) {
        try {
            if (r.b(i.d)) {
                final StringBuilder sb = new StringBuilder();
                sb.append(i.A());
                sb.append("closing database ");
                Log.d("Sqflite", sb.toString());
            }
            i.k();
        }
        catch (final Exception ex) {
            final StringBuilder sb2 = new StringBuilder();
            sb2.append("error ");
            sb2.append((Object)ex);
            sb2.append(" while closing database ");
            sb2.append(c0.k);
            Log.e("Sqflite", sb2.toString());
        }
        final Object e = c0.e;
        synchronized (e) {
            if (c0.d.isEmpty() && c0.l != null) {
                if (r.b(i.d)) {
                    final StringBuilder sb3 = new StringBuilder();
                    sb3.append(i.A());
                    sb3.append("stopping thread");
                    Log.d("Sqflite", sb3.toString());
                }
                c0.l.b();
                c0.l = null;
            }
        }
    }
    
    private i m(final int n) {
        return (i)c0.d.get((Object)n);
    }
    
    private i n(final j j, final d d) {
        final int intValue = j.a("id");
        final i m = this.m(intValue);
        if (m != null) {
            return m;
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("database_closed ");
        sb.append(intValue);
        d.b("sqlite_error", sb.toString(), null);
        return null;
    }
    
    static boolean o(final String s) {
        return s == null || s.equals((Object)":memory:");
    }
    
    static Map x(final int n, final boolean b, final boolean b2) {
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"id", (Object)n);
        if (b) {
            ((Map)hashMap).put((Object)"recovered", (Object)Boolean.TRUE);
        }
        if (b2) {
            ((Map)hashMap).put((Object)"recoveredInTransaction", (Object)Boolean.TRUE);
        }
        return (Map)hashMap;
    }
    
    private void y(final Context a, final t1.c c) {
        this.a = a;
        (this.b = new k(c, "com.tekartik.sqflite", (l)s.b, c.d())).e((k.c)this);
    }
    
    private void z(final j j, final d d) {
        final i n = this.n(j, d);
        if (n == null) {
            return;
        }
        c0.l.a(n, (Runnable)new b0(n, j, d));
    }
    
    void G(final j j, final d d) {
        if (c0.h == null) {
            c0.h = this.a.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        d.a(c0.h);
    }
    
    void J(final j j, final d d) {
        final Integer a = j.a("androidThreadPriority");
        if (a != null) {
            c0.i = a;
        }
        final Integer a2 = j.a("androidThreadCount");
        if (a2 != null && !a2.equals(c0.j)) {
            c0.j = a2;
            final o l = c0.l;
            if (l != null) {
                l.b();
                c0.l = null;
            }
        }
        final Integer a3 = r.a(j);
        if (a3 != null) {
            c0.g = a3;
        }
        d.a(null);
    }
    
    public void onAttachedToEngine(final a$b a$b) {
        this.y(a$b.a(), a$b.b());
    }
    
    public void onDetachedFromEngine(final a$b a$b) {
        this.a = null;
        this.b.e(null);
        this.b = null;
    }
    
    public void onMethodCall(final j j, final d d) {
        final String a = j.a;
        a.hashCode();
        final int hashCode = a.hashCode();
        int n = -1;
        switch (hashCode) {
            case 1863829223: {
                if (!a.equals((Object)"getDatabasesPath")) {
                    break;
                }
                n = 15;
                break;
            }
            case 1385449135: {
                if (!a.equals((Object)"getPlatformVersion")) {
                    break;
                }
                n = 14;
                break;
            }
            case 1193546321: {
                if (!a.equals((Object)"queryCursorNext")) {
                    break;
                }
                n = 13;
                break;
            }
            case 956410295: {
                if (!a.equals((Object)"databaseExists")) {
                    break;
                }
                n = 12;
                break;
            }
            case 107944136: {
                if (!a.equals((Object)"query")) {
                    break;
                }
                n = 11;
                break;
            }
            case 95458899: {
                if (!a.equals((Object)"debug")) {
                    break;
                }
                n = 10;
                break;
            }
            case 93509434: {
                if (!a.equals((Object)"batch")) {
                    break;
                }
                n = 9;
                break;
            }
            case -17190427: {
                if (!a.equals((Object)"openDatabase")) {
                    break;
                }
                n = 8;
                break;
            }
            case -198450538: {
                if (!a.equals((Object)"debugMode")) {
                    break;
                }
                n = 7;
                break;
            }
            case -263511994: {
                if (!a.equals((Object)"deleteDatabase")) {
                    break;
                }
                n = 6;
                break;
            }
            case -396289107: {
                if (!a.equals((Object)"androidSetLocale")) {
                    break;
                }
                n = 5;
                break;
            }
            case -838846263: {
                if (!a.equals((Object)"update")) {
                    break;
                }
                n = 4;
                break;
            }
            case -1183792455: {
                if (!a.equals((Object)"insert")) {
                    break;
                }
                n = 3;
                break;
            }
            case -1249474914: {
                if (!a.equals((Object)"options")) {
                    break;
                }
                n = 2;
                break;
            }
            case -1253581933: {
                if (!a.equals((Object)"closeDatabase")) {
                    break;
                }
                n = 1;
                break;
            }
            case -1319569547: {
                if (!a.equals((Object)"execute")) {
                    break;
                }
                n = 0;
                break;
            }
        }
        switch (n) {
            default: {
                d.c();
                break;
            }
            case 15: {
                this.G(j, d);
                break;
            }
            case 14: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Android ");
                sb.append(Build$VERSION.RELEASE);
                d.a(sb.toString());
                break;
            }
            case 13: {
                this.L(j, d);
                break;
            }
            case 12: {
                this.B(j, d);
                break;
            }
            case 11: {
                this.K(j, d);
                break;
            }
            case 10: {
                this.C(j, d);
                break;
            }
            case 9: {
                this.z(j, d);
                break;
            }
            case 8: {
                this.I(j, d);
                break;
            }
            case 7: {
                this.D(j, d);
                break;
            }
            case 6: {
                this.E(j, d);
                break;
            }
            case 5: {
                this.M(j, d);
                break;
            }
            case 4: {
                this.N(j, d);
                break;
            }
            case 3: {
                this.H(j, d);
                break;
            }
            case 2: {
                this.J(j, d);
                break;
            }
            case 1: {
                this.A(j, d);
                break;
            }
            case 0: {
                this.F(j, d);
                break;
            }
        }
    }
}
