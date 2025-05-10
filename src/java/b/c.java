package b;

import d2.k;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.provider.MediaStore;
import kotlin.jvm.internal.i;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.e;
import android.net.Uri;
import java.util.List;
import androidx.activity.result.d;

public class c extends a<d, List<Uri>>
{
    public static final c.c$a b;
    private final int a;
    
    static {
        b = new c.c$a((e)null);
    }
    
    public c() {
        this(0, 1, null);
    }
    
    public c(int a) {
        this.a = a;
        final int n = 1;
        if (a > 1) {
            a = n;
        }
        else {
            a = 0;
        }
        if (a != 0) {
            return;
        }
        throw new IllegalArgumentException("Max items must be higher than 1".toString());
    }
    
    public Intent b(final Context context, final d d) {
        i.e((Object)context, "context");
        i.e((Object)d, "input");
        final b.d.d$a a = d.a;
        final boolean f = a.f();
        boolean b = true;
        Intent intent;
        if (f) {
            intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(a.c(d.a()));
            if (this.a > MediaStore.getPickImagesMaxLimit()) {
                b = false;
            }
            if (!b) {
                throw new IllegalArgumentException("Max items must be less or equals MediaStore.getPickImagesMaxLimit()".toString());
            }
            intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", this.a);
        }
        else if (a.e(context)) {
            final ResolveInfo b2 = a.b(context);
            if (b2 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            final ActivityInfo activityInfo = b2.activityInfo;
            intent = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
            intent.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
            intent.setType(a.c(d.a()));
            intent.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.a);
        }
        else if (a.d(context)) {
            final ResolveInfo a2 = a.a(context);
            if (a2 == null) {
                throw new IllegalStateException("Required value was null.".toString());
            }
            final ActivityInfo activityInfo2 = a2.activityInfo;
            intent = new Intent("com.google.android.gms.provider.action.PICK_IMAGES");
            intent.setClassName(activityInfo2.applicationInfo.packageName, activityInfo2.name);
            intent.putExtra("com.google.android.gms.provider.extra.PICK_IMAGES_MAX", this.a);
        }
        else {
            final Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent2.setType(a.c(d.a()));
            intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            intent = intent2;
            if (intent2.getType() == null) {
                intent2.setType("*/*");
                intent2.putExtra("android.intent.extra.MIME_TYPES", new String[] { "image/*", "video/*" });
                intent = intent2;
            }
        }
        return intent;
    }
    
    public final List<Uri> c(int n, Intent intent) {
        if (n == -1) {
            n = 1;
        }
        else {
            n = 0;
        }
        if (n == 0) {
            intent = null;
        }
        if (intent != null) {
            final List list = b.b.a.a(intent);
            if (list != null) {
                return (List<Uri>)list;
            }
        }
        final List list = k.b();
        return (List<Uri>)list;
    }
}
