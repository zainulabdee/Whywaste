package y1;

import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import b2.c;
import android.content.Context;
import k1.a;

public class i implements a, a$b
{
    private Context a;
    
    private String g() {
        return c.d(this.a);
    }
    
    private String h() {
        return c.c(this.a);
    }
    
    private List<String> i() {
        final ArrayList list = new ArrayList();
        for (final File file : this.a.getExternalCacheDirs()) {
            if (file != null) {
                ((List)list).add((Object)file.getAbsolutePath());
            }
        }
        return (List<String>)list;
    }
    
    private List<String> j(final a$c a$c) {
        final ArrayList list = new ArrayList();
        for (final File file : this.a.getExternalFilesDirs(this.m(a$c))) {
            if (file != null) {
                ((List)list).add((Object)file.getAbsolutePath());
            }
        }
        return (List<String>)list;
    }
    
    private String k() {
        final File externalFilesDir = this.a.getExternalFilesDir((String)null);
        if (externalFilesDir == null) {
            return null;
        }
        return externalFilesDir.getAbsolutePath();
    }
    
    private String l() {
        return this.a.getCacheDir().getPath();
    }
    
    private String m(final a$c a$c) {
        switch (i$a.a[((Enum)a$c).ordinal()]) {
            default: {
                final StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized directory: ");
                sb.append((Object)a$c);
                throw new RuntimeException(sb.toString());
            }
            case 11: {
                return "documents";
            }
            case 10: {
                return "dcim";
            }
            case 9: {
                return "downloads";
            }
            case 8: {
                return "movies";
            }
            case 7: {
                return "pictures";
            }
            case 6: {
                return "notifications";
            }
            case 5: {
                return "alarms";
            }
            case 4: {
                return "ringtones";
            }
            case 3: {
                return "podcasts";
            }
            case 2: {
                return "music";
            }
            case 1: {
                return null;
            }
        }
    }
    
    private void n(final t1.c c, final Context a) {
        try {
            h.h(c, (a$b)this);
        }
        catch (final Exception ex) {
            Log.e("PathProviderPlugin", "Received exception while setting up PathProviderPlugin", (Throwable)ex);
        }
        this.a = a;
    }
    
    public List<String> a(final a$c a$c) {
        return this.j(a$c);
    }
    
    public String b() {
        return this.l();
    }
    
    public String c() {
        return this.h();
    }
    
    public List<String> d() {
        return this.i();
    }
    
    public String e() {
        return this.g();
    }
    
    public String f() {
        return this.k();
    }
    
    public void onAttachedToEngine(final k1.a$b a$b) {
        this.n(a$b.b(), a$b.a());
    }
    
    public void onDetachedFromEngine(final k1.a$b a$b) {
        h.h(a$b.b(), (a$b)null);
    }
}
