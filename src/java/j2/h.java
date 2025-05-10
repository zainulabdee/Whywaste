package j2;

import java.io.Closeable;
import c2.q;
import java.io.FileOutputStream;
import kotlin.jvm.internal.i;
import java.io.File;

class h extends g
{
    public static void a(File file, final byte[] array) {
        i.e((Object)file, "<this>");
        i.e((Object)array, "array");
        file = (File)new FileOutputStream(file);
        try {
            ((FileOutputStream)file).write(array);
            final q a = q.a;
            b.a((Closeable)file, (Throwable)null);
        }
        finally {
            try {}
            finally {
                b.a((Closeable)file, (Throwable)(Object)array);
            }
        }
    }
}
