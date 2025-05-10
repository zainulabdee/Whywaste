package io.sentry.android.core;

import java.io.OutputStream;
import java.util.UUID;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.io.File;
import android.content.Context;
import java.nio.charset.Charset;

final class u0
{
    static String a;
    private static final Charset b;
    
    static {
        b = Charset.forName("UTF-8");
    }
    
    public static String a(final Context context) {
        synchronized (u0.class) {
            if (u0.a == null) {
                final File file = new File(context.getFilesDir(), "INSTALLATION");
                try {
                    if (!file.exists()) {
                        return u0.a = c(file);
                    }
                    u0.a = b(file);
                }
                finally {
                    final Throwable t;
                    throw new RuntimeException(t);
                }
            }
            return u0.a;
        }
    }
    
    static String b(File file) {
        file = (File)new RandomAccessFile(file, "r");
        try {
            final byte[] array = new byte[(int)((RandomAccessFile)file).length()];
            ((RandomAccessFile)file).readFully(array);
            final String s = new String(array, u0.b);
            ((RandomAccessFile)file).close();
            return s;
        }
        finally {
            try {
                ((RandomAccessFile)file).close();
            }
            finally {
                final Throwable t;
                final Throwable t2;
                t.addSuppressed(t2);
            }
        }
    }
    
    static String c(final File file) {
        final FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            final String string = UUID.randomUUID().toString();
            ((OutputStream)fileOutputStream).write(string.getBytes(u0.b));
            ((OutputStream)fileOutputStream).flush();
            ((OutputStream)fileOutputStream).close();
            return string;
        }
        finally {
            try {
                ((OutputStream)fileOutputStream).close();
            }
            finally {
                final Throwable t;
                ((Throwable)file).addSuppressed(t);
            }
        }
    }
}
