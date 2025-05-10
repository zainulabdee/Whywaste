package b2;

import android.os.Build$VERSION;
import java.io.File;
import android.content.Context;

public final class c
{
    public static String a(final Context context) {
        File file;
        if ((file = context.getCodeCacheDir()) == null) {
            file = context.getCacheDir();
        }
        File file2;
        if ((file2 = file) == null) {
            file2 = new File(b(context), "cache");
        }
        return file2.getPath();
    }
    
    private static String b(final Context context) {
        if (Build$VERSION.SDK_INT >= 24) {
            return b.a(context).getPath();
        }
        return context.getApplicationInfo().dataDir;
    }
    
    public static String c(final Context context) {
        File dir;
        if ((dir = context.getDir("flutter", 0)) == null) {
            dir = new File(b(context), "app_flutter");
        }
        return dir.getPath();
    }
    
    public static String d(final Context context) {
        File filesDir;
        if ((filesDir = context.getFilesDir()) == null) {
            filesDir = new File(b(context), "files");
        }
        return filesDir.getPath();
    }
}
