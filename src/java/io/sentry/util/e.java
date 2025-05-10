package io.sentry.util;

import java.io.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;

public final class e
{
    public static boolean a(final File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        final File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (int length = listFiles.length, i = 0; i < length; ++i) {
            if (!a(listFiles[i])) {
                return false;
            }
        }
        return file.delete();
    }
    
    public static String b(File file) {
        if (file != null && file.exists() && file.isFile()) {
            if (file.canRead()) {
                final StringBuilder sb = new StringBuilder();
                file = (File)new BufferedReader((Reader)new FileReader(file));
                try {
                    final String line = ((BufferedReader)file).readLine();
                    if (line != null) {
                        sb.append(line);
                    }
                    while (true) {
                        final String line2 = ((BufferedReader)file).readLine();
                        if (line2 == null) {
                            break;
                        }
                        sb.append("\n");
                        sb.append(line2);
                    }
                    ((BufferedReader)file).close();
                    return sb.toString();
                }
                finally {
                    try {
                        ((BufferedReader)file).close();
                    }
                    finally {
                        final Throwable t;
                        final Throwable t2;
                        t.addSuppressed(t2);
                    }
                }
            }
        }
        return null;
    }
}
