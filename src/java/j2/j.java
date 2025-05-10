package j2;

import java.io.Closeable;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;

class j extends i
{
    public static final File b(File file, final File file2, final boolean b, final int n) {
        kotlin.jvm.internal.i.e((Object)file, "<this>");
        kotlin.jvm.internal.i.e((Object)file2, "target");
        if (file.exists()) {
            if (file2.exists()) {
                if (!b) {
                    throw new d(file, file2, "The destination file already exists.");
                }
                if (!file2.delete()) {
                    throw new d(file, file2, "Tried to overwrite the destination, but failed to delete it.");
                }
            }
            if (file.isDirectory()) {
                if (file2.mkdirs()) {
                    return file2;
                }
                throw new e(file, file2, "Failed to create target directory.");
            }
            else {
                final File parentFile = file2.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
            }
            file = (File)new FileInputStream(file);
            try {
                final FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    a.a((InputStream)file, (OutputStream)fileOutputStream, n);
                    b.a((Closeable)fileOutputStream, (Throwable)null);
                    b.a((Closeable)file, (Throwable)null);
                    return file2;
                }
                finally {
                    try {}
                    finally {
                        final Throwable t;
                        b.a((Closeable)fileOutputStream, t);
                    }
                }
            }
            finally {
                try {}
                finally {
                    b.a((Closeable)file, (Throwable)file2);
                }
            }
        }
        throw new k(file, (File)null, "The source file doesn't exist.", 2, (kotlin.jvm.internal.e)null);
    }
}
