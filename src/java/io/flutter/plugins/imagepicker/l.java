package io.flutter.plugins.imagepicker;

import java.util.concurrent.Executor;
import java.util.Map;
import java.util.Iterator;
import android.content.pm.ResolveInfo;
import java.io.IOException;
import java.util.UUID;
import android.os.Build$VERSION;
import android.content.ActivityNotFoundException;
import android.os.Parcelable;
import b.d$e;
import java.io.Serializable;
import b.d$b;
import b.d;
import b.d$f;
import b.d$c;
import androidx.activity.result.d$a;
import java.util.ArrayList;
import android.content.Intent;
import java.util.List;
import java.util.concurrent.Executors;
import android.media.MediaScannerConnection$OnScanCompletedListener;
import android.media.MediaScannerConnection;
import java.io.File;
import androidx.core.app.a;
import android.content.Context;
import android.net.Uri;
import java.util.concurrent.ExecutorService;
import android.app.Activity;
import t1.p;
import t1.m;

public class l implements m, p
{
    final String a;
    private final Activity b;
    private final o c;
    private final c d;
    private final l$h e;
    private final l$d f;
    private final b g;
    private final ExecutorService h;
    private l.l$c i;
    private Uri j;
    private l.l$g k;
    private final Object l;
    
    public l(final Activity activity, final o o, final c c) {
        this(activity, o, null, null, null, c, (l$h)new l$h(activity) {
            final Activity a;
            
            public boolean a() {
                return n.b((Context)this.a);
            }
            
            public void b(final String s, final int n) {
                androidx.core.app.a.f(this.a, new String[] { s }, n);
            }
            
            public boolean c(final String s) {
                return androidx.core.content.a.a((Context)this.a, s) == 0;
            }
        }, (l$d)new l$d(activity) {
            final Activity a;
            
            public Uri a(final String s, final File file) {
                return androidx.core.content.c.f((Context)this.a, s, file);
            }
            
            public void b(final Uri uri, final l$f l$f) {
                final Activity a = this.a;
                String path;
                if (uri != null) {
                    path = uri.getPath();
                }
                else {
                    path = "";
                }
                MediaScannerConnection.scanFile((Context)a, new String[] { path }, (String[])null, (MediaScannerConnection$OnScanCompletedListener)new io.flutter.plugins.imagepicker.m(l$f));
            }
        }, new b(), Executors.newSingleThreadExecutor());
    }
    
    l(final Activity b, final o c, final p$h p$h, final p$n p$n, final p$j<List<String>> p$j, final c d, final l$h e, final l$d f, final b g, final ExecutorService h) {
        this.l = new Object();
        this.b = b;
        this.c = c;
        final StringBuilder sb = new StringBuilder();
        sb.append(((Context)b).getPackageName());
        sb.append(".flutter.image_provider");
        this.a = sb.toString();
        if (p$j != null) {
            this.k = new l.l$g(p$h, p$n, (p$j)p$j);
        }
        this.e = e;
        this.f = f;
        this.g = g;
        this.d = d;
        this.h = h;
    }
    
    private void A(int i, final Intent intent) {
        if (i == -1 && intent != null) {
            final ArrayList list = new ArrayList();
            if (intent.getClipData() != null) {
                for (i = 0; i < intent.getClipData().getItemCount(); ++i) {
                    list.add((Object)new l.l$e(this, this.g.e((Context)this.b, intent.getClipData().getItemAt(i).getUri()), (String)null));
                }
            }
            else {
                list.add((Object)new l.l$e(this, this.g.e((Context)this.b, intent.getData()), (String)null));
            }
            this.D((ArrayList<l.l$e>)list);
            return;
        }
        this.t(null);
    }
    
    private void B(final int n, final Intent intent) {
        if (n == -1 && intent != null) {
            this.E(this.g.e((Context)this.b, intent.getData()));
            return;
        }
        this.t(null);
    }
    
    private void D(final ArrayList<l.l$e> list) {
        final Object l = this.l;
        synchronized (l) {
            final l.l$g k = this.k;
            p$h a;
            if (k != null) {
                a = k.a;
            }
            else {
                a = null;
            }
            monitorexit(l);
            final ArrayList list2 = new ArrayList();
            int i = 0;
            final int n = 0;
            if (a != null) {
                for (int j = n; j < list.size(); ++j) {
                    final l.l$e l$e = (l.l$e)list.get(j);
                    String s = l$e.a;
                    final String b = l$e.b;
                    if (b == null || !b.startsWith("video/")) {
                        s = this.u(l$e.a, a);
                    }
                    list2.add((Object)s);
                }
                this.s((ArrayList<String>)list2);
            }
            else {
                while (i < list.size()) {
                    list2.add((Object)((l.l$e)list.get(i)).a);
                    ++i;
                }
                this.s((ArrayList<String>)list2);
            }
        }
    }
    
    private void E(final String s) {
        this.t(s);
    }
    
    private void M(final Boolean b) {
        Intent b2;
        if (b) {
            b2 = new b.c().b((Context)this.b, new d$a().b((d$f)d$c.a).a());
        }
        else {
            b2 = new Intent("android.intent.action.GET_CONTENT");
            b2.setType("image/*");
            b2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        }
        this.b.startActivityForResult(b2, 2346);
    }
    
    private void N(final Boolean b) {
        Intent b2;
        if (b) {
            b2 = new d().b((Context)this.b, new d$a().b((d$f)d$c.a).a());
        }
        else {
            b2 = new Intent("android.intent.action.GET_CONTENT");
            b2.setType("image/*");
        }
        this.b.startActivityForResult(b2, 2342);
    }
    
    private void O(final p$e p$e) {
        Intent intent;
        if (p$e.c()) {
            if (p$e.b()) {
                intent = new b.c().b((Context)this.b, new d$a().b((d$f)d$b.a).a());
            }
            else {
                intent = new d().b((Context)this.b, new d$a().b((d$f)d$b.a).a());
            }
        }
        else {
            final Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
            intent2.setType("*/*");
            intent2.putExtra("CONTENT_TYPE", new String[] { "video/*", "image/*" });
            intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", (Serializable)p$e.b());
            intent = intent2;
        }
        this.b.startActivityForResult(intent, 2347);
    }
    
    private void P(final Boolean b) {
        Intent b2;
        if (b) {
            b2 = new d().b((Context)this.b, new d$a().b((d$f)d$e.a).a());
        }
        else {
            b2 = new Intent("android.intent.action.GET_CONTENT");
            b2.setType("video/*");
        }
        this.b.startActivityForResult(b2, 2352);
    }
    
    private void Q() {
        final Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (this.i == io.flutter.plugins.imagepicker.l.l$c.f) {
            this.Z(intent);
        }
        final File o = this.o();
        final StringBuilder sb = new StringBuilder();
        sb.append("file:");
        sb.append(o.getAbsolutePath());
        this.j = Uri.parse(sb.toString());
        final Uri a = this.f.a(this.a, o);
        intent.putExtra("output", (Parcelable)a);
        this.v(intent, a);
        try {
            this.b.startActivityForResult(intent, 2343);
        }
        catch (final ActivityNotFoundException ex) {
            try {
                o.delete();
            }
            catch (final SecurityException ex2) {
                ((Throwable)ex2).printStackTrace();
            }
            this.r("no_available_camera", "No cameras available for taking pictures.");
        }
    }
    
    private void R() {
        final Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        final Object l = this.l;
        synchronized (l) {
            final l.l$g k = this.k;
            p$n b;
            if (k != null) {
                b = k.b;
            }
            else {
                b = null;
            }
            monitorexit(l);
            if (b != null && b.b() != null) {
                intent.putExtra("android.intent.extra.durationLimit", b.b().intValue());
            }
            if (this.i == io.flutter.plugins.imagepicker.l.l$c.f) {
                this.Z(intent);
            }
            final File p = this.p();
            final StringBuilder sb = new StringBuilder();
            sb.append("file:");
            sb.append(p.getAbsolutePath());
            this.j = Uri.parse(sb.toString());
            final Uri a = this.f.a(this.a, p);
            intent.putExtra("output", (Parcelable)a);
            this.v(intent, a);
            try {
                this.b.startActivityForResult(intent, 2353);
            }
            catch (final ActivityNotFoundException ex) {
                try {
                    p.delete();
                }
                catch (final SecurityException ex2) {
                    ((Throwable)ex2).printStackTrace();
                }
                this.r("no_available_camera", "No cameras available for taking pictures.");
            }
        }
    }
    
    private boolean S() {
        final l$h e = this.e;
        return e != null && e.a();
    }
    
    private boolean W(final p$h p$h, final p$n p$n, final p$j<List<String>> p$j) {
        final Object l = this.l;
        synchronized (l) {
            if (this.k != null) {
                return false;
            }
            this.k = new l.l$g(p$h, p$n, (p$j)p$j);
            monitorexit(l);
            this.d.a();
            return true;
        }
    }
    
    private void Z(final Intent intent) {
        final int sdk_INT = Build$VERSION.SDK_INT;
        if (sdk_INT >= 22) {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            if (sdk_INT >= 26) {
                intent.putExtra("android.intent.extra.USE_FRONT_CAMERA", true);
            }
        }
        else {
            intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
        }
    }
    
    private File n(final String s) {
        final String string = UUID.randomUUID().toString();
        final File cacheDir = ((Context)this.b).getCacheDir();
        try {
            cacheDir.mkdirs();
            return File.createTempFile(string, s, cacheDir);
        }
        catch (final IOException ex) {
            throw new RuntimeException((Throwable)ex);
        }
    }
    
    private File o() {
        return this.n(".jpg");
    }
    
    private File p() {
        return this.n(".mp4");
    }
    
    private void q(final p$j<List<String>> p$j) {
        p$j.b((Throwable)new p$d("already_active", "Image picker is already active", (Object)null));
    }
    
    private void r(final String s, final String s2) {
        final Object l = this.l;
        synchronized (l) {
            final l.l$g k = this.k;
            p$j c;
            if (k != null) {
                c = k.c;
            }
            else {
                c = null;
            }
            this.k = null;
            monitorexit(l);
            if (c == null) {
                this.d.f((ArrayList)null, s, s2);
            }
            else {
                c.b((Throwable)new p$d(s, s2, (Object)null));
            }
        }
    }
    
    private void s(final ArrayList<String> list) {
        final Object l = this.l;
        synchronized (l) {
            final l.l$g k = this.k;
            p$j c;
            if (k != null) {
                c = k.c;
            }
            else {
                c = null;
            }
            this.k = null;
            monitorexit(l);
            if (c == null) {
                this.d.f((ArrayList)list, (String)null, (String)null);
            }
            else {
                c.a((Object)list);
            }
        }
    }
    
    private void t(final String s) {
        final ArrayList list = new ArrayList();
        if (s != null) {
            list.add((Object)s);
        }
        final Object l = this.l;
        synchronized (l) {
            final l.l$g k = this.k;
            p$j c;
            if (k != null) {
                c = k.c;
            }
            else {
                c = null;
            }
            this.k = null;
            monitorexit(l);
            if (c == null) {
                if (!list.isEmpty()) {
                    this.d.f(list, (String)null, (String)null);
                }
            }
            else {
                c.a((Object)list);
            }
        }
    }
    
    private String u(final String s, final p$h p$h) {
        return this.c.j(s, p$h.c(), p$h.b(), p$h.d().intValue());
    }
    
    private void v(final Intent intent, final Uri uri) {
        final Iterator iterator = ((Context)this.b).getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (iterator.hasNext()) {
            ((Context)this.b).grantUriPermission(((ResolveInfo)iterator.next()).activityInfo.packageName, uri, 3);
        }
    }
    
    private void w(final int n) {
        if (n == -1) {
            Uri uri = this.j;
            final l$d f = this.f;
            if (uri == null) {
                uri = Uri.parse(this.d.c());
            }
            f.b(uri, (l$f)new j(this));
            return;
        }
        this.t(null);
    }
    
    private void x(final int n) {
        if (n == -1) {
            Uri uri = this.j;
            final l$d f = this.f;
            if (uri == null) {
                uri = Uri.parse(this.d.c());
            }
            f.b(uri, (l$f)new k(this));
            return;
        }
        this.t(null);
    }
    
    private void y(final int n, final Intent intent) {
        if (n == -1 && intent != null) {
            this.C(this.g.e((Context)this.b, intent.getData()), false);
            return;
        }
        this.t(null);
    }
    
    private void z(int i, final Intent intent) {
        if (i == -1 && intent != null) {
            final ArrayList list = new ArrayList();
            if (intent.getClipData() != null) {
                Uri uri;
                for (i = 0; i < intent.getClipData().getItemCount(); ++i) {
                    uri = intent.getClipData().getItemAt(i).getUri();
                    list.add((Object)new l.l$e(this, this.g.e((Context)this.b, uri), ((Context)this.b).getContentResolver().getType(uri)));
                }
            }
            else {
                list.add((Object)new l.l$e(this, this.g.e((Context)this.b, intent.getData()), (String)null));
            }
            this.D((ArrayList<l.l$e>)list);
            return;
        }
        this.t(null);
    }
    
    void C(final String s, final boolean b) {
        final Object l = this.l;
        synchronized (l) {
            final l.l$g k = this.k;
            p$h a;
            if (k != null) {
                a = k.a;
            }
            else {
                a = null;
            }
            monitorexit(l);
            if (a != null) {
                final String u = this.u(s, a);
                if (u != null && !u.equals((Object)s) && b) {
                    new File(s).delete();
                }
                this.t(u);
            }
            else {
                this.t(s);
            }
        }
    }
    
    p$b T() {
        final Map b = this.d.b();
        if (b.isEmpty()) {
            return null;
        }
        final p$b$a p$b$a = new p$b$a();
        final p$c p$c = (p$c)b.get((Object)"type");
        if (p$c != null) {
            p$b$a.d(p$c);
        }
        p$b$a.b((p$a)b.get((Object)"error"));
        final ArrayList list = (ArrayList)b.get((Object)"pathList");
        if (list != null) {
            final ArrayList list2 = new ArrayList();
            for (final String s : list) {
                final Double n = (Double)b.get((Object)"maxWidth");
                final Double n2 = (Double)b.get((Object)"maxHeight");
                final Integer n3 = (Integer)b.get((Object)"imageQuality");
                int intValue;
                if (n3 == null) {
                    intValue = 100;
                }
                else {
                    intValue = n3;
                }
                list2.add((Object)this.c.j(s, n, n2, intValue));
            }
            p$b$a.c((List)list2);
        }
        this.d.a();
        return p$b$a.a();
    }
    
    void U() {
        final Object l = this.l;
        synchronized (l) {
            final l.l$g k = this.k;
            if (k == null) {
                return;
            }
            final p$h a = k.a;
            monitorexit(l);
            final c d = this.d;
            c$b c$b;
            if (a != null) {
                c$b = io.flutter.plugins.imagepicker.c$b.e;
            }
            else {
                c$b = io.flutter.plugins.imagepicker.c$b.f;
            }
            d.g(c$b);
            if (a != null) {
                this.d.d(a);
            }
            final Uri j = this.j;
            if (j != null) {
                this.d.e(j);
            }
        }
    }
    
    void V(final l.l$c i) {
        this.i = i;
    }
    
    public void X(final p$h p$h, final p$j<List<String>> p$j) {
        if (!this.W(p$h, null, p$j)) {
            this.q(p$j);
            return;
        }
        if (this.S() && !this.e.c("android.permission.CAMERA")) {
            this.e.b("android.permission.CAMERA", 2345);
            return;
        }
        this.Q();
    }
    
    public void Y(final p$n p$n, final p$j<List<String>> p$j) {
        if (!this.W(null, p$n, p$j)) {
            this.q(p$j);
            return;
        }
        if (this.S() && !this.e.c("android.permission.CAMERA")) {
            this.e.b("android.permission.CAMERA", 2355);
            return;
        }
        this.R();
    }
    
    public boolean a(final int n, final int n2, final Intent intent) {
        Object o;
        if (n != 2342) {
            if (n != 2343) {
                if (n != 2346) {
                    if (n != 2347) {
                        if (n != 2352) {
                            if (n != 2353) {
                                return false;
                            }
                            o = new i(this, n2);
                        }
                        else {
                            o = new h(this, n2, intent);
                        }
                    }
                    else {
                        o = new g(this, n2, intent);
                    }
                }
                else {
                    o = new e(this, n2, intent);
                }
            }
            else {
                o = new f(this, n2);
            }
        }
        else {
            o = new io.flutter.plugins.imagepicker.d(this, n2, intent);
        }
        ((Executor)this.h).execute((Runnable)o);
        return true;
    }
    
    public void j(final p$h p$h, final boolean b, final p$j<List<String>> p$j) {
        if (!this.W(p$h, null, p$j)) {
            this.q(p$j);
            return;
        }
        this.N(b);
    }
    
    public void k(final p$i p$i, final p$e p$e, final p$j<List<String>> p$j) {
        if (!this.W(p$i.b(), null, p$j)) {
            this.q(p$j);
            return;
        }
        this.O(p$e);
    }
    
    public void l(final p$h p$h, final boolean b, final p$j<List<String>> p$j) {
        if (!this.W(p$h, null, p$j)) {
            this.q(p$j);
            return;
        }
        this.M(b);
    }
    
    public void m(final p$n p$n, final boolean b, final p$j<List<String>> p$j) {
        if (!this.W(null, p$n, p$j)) {
            this.q(p$j);
            return;
        }
        this.P(b);
    }
    
    public boolean onRequestPermissionsResult(final int n, final String[] array, final int[] array2) {
        final boolean b = array2.length > 0 && array2[0] == 0;
        if (n != 2345) {
            if (n != 2355) {
                return false;
            }
            if (b) {
                this.R();
            }
        }
        else if (b) {
            this.Q();
        }
        if (!b) {
            if (n == 2345 || n == 2355) {
                this.r("camera_access_denied", "The user did not allow camera access.");
            }
        }
        return true;
    }
}
