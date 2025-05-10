package j2;

import kotlin.jvm.internal.i;
import java.io.OutputStream;
import java.io.InputStream;

public final class a
{
    public static final long a(final InputStream inputStream, final OutputStream outputStream, int i) {
        i.e((Object)inputStream, "<this>");
        i.e((Object)outputStream, "out");
        final byte[] array = new byte[i];
        i = inputStream.read(array);
        long n = 0L;
        while (i >= 0) {
            outputStream.write(array, 0, i);
            n += i;
            i = inputStream.read(array);
        }
        return n;
    }
}
