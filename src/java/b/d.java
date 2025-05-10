package b;

import d2.k;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import kotlin.jvm.internal.i;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.e;
import android.net.Uri;

public class d extends a<d, Uri>
{
    public static final d$a a;
    
    static {
        a = new d$a((kotlin.jvm.internal.e)null);
    }
    
    public Intent b(final Context context, final d d) {
        i.e((Object)context, "context");
        i.e((Object)d, "input");
        final d$a a = d.a;
        Intent intent;
        if (a.f()) {
            intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(a.c(d.a()));
        }
        else if (a.e(context)) {
            final ResolveInfo b = a.b(context);
            if (b == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            final ActivityInfo activityInfo = b.activityInfo;
            intent = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            intent.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent.setType(a.c(d.a()));
        }
        else if (a.d(context)) {
            final ResolveInfo a2 = a.a(context);
            if (a2 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            final ActivityInfo activityInfo2 = a2.activityInfo;
            intent = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
            intent.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
            intent.setType(a.c(d.a()));
        }
        else {
            final Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent2.setType(a.c(d.a()));
            intent = intent2;
            if (intent2.getType() == null) {
                intent2.setType("*/*");
                intent2.putExtra("android.intent.extra.MIME_TYPES", new String[] { "image/*", "video/*" });
                intent = intent2;
            }
        }
        return intent;
    }
    
    public final Uri c(int n, final Intent intent) {
        if (n == -1) {
            n = 1;
        }
        else {
            n = 0;
        }
        final Uri uri = null;
        Intent intent2;
        if (n != 0) {
            intent2 = intent;
        }
        else {
            intent2 = null;
        }
        Uri data = uri;
        if (intent2 != null && (data = intent2.getData()) == null) {
            data = (Uri)k.j(b.b.a.a(intent2));
        }
        return data;
    }
    
    public static final class b implements d$f
    {
        public static final b a;
        
        static {
            a = new b();
        }
        
        private b() {
        }
    }
    
    public static final class c implements d$f
    {
        public static final c a;
        
        static {
            a = new c();
        }
        
        private c() {
        }
    }
    
    public static final class d implements d$f
    {
        private final String a;
        
        public final String a() {
            return this.a;
        }
    }
    
    public static final class e implements d$f
    {
        public static final e a;
        
        static {
            a = new e();
        }
        
        private e() {
        }
    }
}
