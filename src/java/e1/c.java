package e1;

import java.util.Collection;
import android.content.pm.ResolveInfo;
import android.os.Parcelable;
import android.app.PendingIntent;
import dev.fluttercommunity.plus.share.SharePlusPendingIntent;
import android.content.Intent;
import d2.k;
import java.util.Iterator;
import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import r2.d;
import java.io.File;
import l2.a;
import c2.f;
import kotlin.jvm.internal.i;
import android.app.Activity;
import android.content.Context;

public final class c
{
    private final Context a;
    private Activity b;
    private final e c;
    private final c2.e d;
    private final c2.e e;
    
    public c(final Context a, final Activity b, final e c) {
        i.e((Object)a, "context");
        i.e((Object)c, "manager");
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = f.a((a)new c$b(this));
        this.e = f.a((a)c$a.e);
    }
    
    private final void b() {
        final File i = this.i();
        final File[] listFiles = i.listFiles();
        if (i.exists()) {
            final int n = 0;
            int n2 = 1;
            if (listFiles != null) {
                if (listFiles.length == 0) {
                    n2 = n2;
                }
                else {
                    n2 = 0;
                }
            }
            if (n2 == 0) {
                kotlin.jvm.internal.i.d((Object)listFiles, "files");
                for (int length = listFiles.length, j = n; j < length; ++j) {
                    listFiles[j].delete();
                }
                i.delete();
            }
        }
    }
    
    private final File c(final File file) {
        final File i = this.i();
        if (!i.exists()) {
            i.mkdirs();
        }
        final File file2 = new File(i, file.getName());
        j2.f.c(file, file2, true, 0, 4, (Object)null);
        return file2;
    }
    
    private final boolean d(final File file) {
        boolean o = false;
        try {
            final String canonicalPath = file.getCanonicalPath();
            i.d((Object)canonicalPath, "filePath");
            final String canonicalPath2 = this.i().getCanonicalPath();
            i.d((Object)canonicalPath2, "shareCacheFolder.canonicalPath");
            o = r2.d.o(canonicalPath, canonicalPath2, false, 2, (Object)null);
            return o;
        }
        catch (final IOException ex) {
            return o;
        }
    }
    
    private final Context e() {
        Object o = this.b;
        if (o != null) {
            i.b(o);
        }
        else {
            o = this.a;
        }
        return (Context)o;
    }
    
    private final int f() {
        return this.e.getValue().intValue();
    }
    
    private final String g(String substring) {
        if (substring != null && r2.d.r((CharSequence)substring, (CharSequence)"/", false, 2, (Object)null)) {
            substring = substring.substring(0, r2.d.A((CharSequence)substring, "/", 0, false, 6, (Object)null));
            i.d((Object)substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
        }
        else {
            substring = "*";
        }
        return substring;
    }
    
    private final String h() {
        return this.d.getValue();
    }
    
    private final File i() {
        return new File(this.e().getCacheDir(), "share_plus");
    }
    
    private final ArrayList<Uri> j(final List<String> list) {
        final ArrayList list2 = new ArrayList(list.size());
        final Iterator iterator = ((Iterable)list).iterator();
        while (iterator.hasNext()) {
            final File file = new File((String)iterator.next());
            if (this.d(file)) {
                final StringBuilder sb = new StringBuilder();
                sb.append("Shared file can not be located in '");
                sb.append(this.i().getCanonicalPath());
                sb.append('\'');
                throw new IOException(sb.toString());
            }
            list2.add((Object)androidx.core.content.c.f(this.e(), this.h(), this.c(file)));
        }
        return (ArrayList<Uri>)list2;
    }
    
    private final String k(final List<String> list) {
        int n = 1;
        final boolean b = list == null || list.isEmpty();
        final String s = "*/*";
        if (b) {
            return "*/*";
        }
        i.b((Object)list);
        if (list.size() == 1) {
            return (String)k.i((List)list);
        }
        final String s2 = (String)k.i((List)list);
        final int c = k.c((List)list);
        String s3 = s2;
        if (1 <= c) {
            String s4 = s2;
            while (true) {
                String string = s4;
                if (!i.a((Object)s4, list.get(n))) {
                    final String s5 = s;
                    if (!i.a((Object)this.g(s4), (Object)this.g((String)list.get(n)))) {
                        return s5;
                    }
                    final StringBuilder sb = new StringBuilder();
                    sb.append(this.g((String)list.get(n)));
                    sb.append("/*");
                    string = sb.toString();
                }
                s3 = string;
                if (n == c) {
                    break;
                }
                ++n;
                s4 = string;
            }
        }
        return s3;
    }
    
    private final void o(final Intent intent, final boolean b) {
        final Activity b2 = this.b;
        if (b2 != null) {
            if (b) {
                i.b((Object)b2);
                b2.startActivityForResult(intent, 22643);
            }
            else {
                i.b((Object)b2);
                b2.startActivity(intent);
            }
        }
        else {
            intent.addFlags(268435456);
            if (b) {
                this.c.d();
            }
            this.a.startActivity(intent);
        }
    }
    
    public final void l(final Activity b) {
        this.b = b;
    }
    
    public final void m(final String s, final String s2, final boolean b) {
        i.e((Object)s, "text");
        final Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", s);
        intent.putExtra("android.intent.extra.SUBJECT", s2);
        Intent intent2;
        if (b) {
            intent2 = b.a(intent, (CharSequence)null, PendingIntent.getBroadcast(this.a, 0, new Intent(this.a, (Class)SharePlusPendingIntent.class), 0x8000000 | this.f()).getIntentSender());
        }
        else {
            intent2 = Intent.createChooser(intent, (CharSequence)null);
        }
        i.d((Object)intent2, "chooserIntent");
        this.o(intent2, b);
    }
    
    public final void n(final List<String> list, final List<String> list2, final String s, String packageName, final boolean b) {
        i.e((Object)list, "paths");
        this.b();
        final ArrayList<Uri> j = this.j(list);
        final Intent intent = new Intent();
        if (j.isEmpty() && s != null && !r2.d.j((CharSequence)s)) {
            this.m(s, packageName, b);
            return;
        }
        if (j.size() == 1) {
            String type;
            if (list2 != null && !((Collection)list2).isEmpty()) {
                type = (String)k.i((List)list2);
            }
            else {
                type = "*/*";
            }
            intent.setAction("android.intent.action.SEND");
            intent.setType(type);
            intent.putExtra("android.intent.extra.STREAM", (Parcelable)k.i((List)j));
        }
        else {
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.setType(this.k(list2));
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", (ArrayList)j);
        }
        if (s != null) {
            intent.putExtra("android.intent.extra.TEXT", s);
        }
        if (packageName != null) {
            intent.putExtra("android.intent.extra.SUBJECT", packageName);
        }
        intent.addFlags(1);
        Intent intent2;
        if (b) {
            intent2 = b.a(intent, (CharSequence)null, PendingIntent.getBroadcast(this.a, 0, new Intent(this.a, (Class)SharePlusPendingIntent.class), 0x8000000 | this.f()).getIntentSender());
        }
        else {
            intent2 = Intent.createChooser(intent, (CharSequence)null);
        }
        final List queryIntentActivities = this.e().getPackageManager().queryIntentActivities(intent2, 65536);
        i.d((Object)queryIntentActivities, "getContext().packageMana\u2026CH_DEFAULT_ONLY\n        )");
        final Iterator iterator = ((Iterable)queryIntentActivities).iterator();
        while (iterator.hasNext()) {
            packageName = ((ResolveInfo)iterator.next()).activityInfo.packageName;
            final Iterator iterator2 = ((Iterable)j).iterator();
            while (iterator2.hasNext()) {
                this.e().grantUriPermission(packageName, (Uri)iterator2.next(), 3);
            }
        }
        i.d((Object)intent2, "chooserIntent");
        this.o(intent2, b);
    }
}
