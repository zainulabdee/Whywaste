package io.sentry;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;

public final class r implements j0
{
    private static final Charset b;
    private final t0 a;
    
    static {
        b = Charset.forName("UTF-8");
    }
    
    public r(final t0 a) {
        this.a = a;
    }
    
    private m3 b(final byte[] array, final int n, final int n2) {
        return (m3)this.a.a((Reader)new StringReader(new String(array, n, n2, r.b)), (Class)m3.class);
    }
    
    private d4 c(final byte[] array, final int n, final int n2) {
        return (d4)this.a.a((Reader)new StringReader(new String(array, n, n2, r.b)), (Class)d4.class);
    }
    
    public l3 a(final InputStream inputStream) {
        final byte[] array = new byte[1024];
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n = -1;
        int n2 = 0;
        try {
            while (true) {
                final int read = inputStream.read(array);
                if (read <= 0) {
                    break;
                }
                int n3 = 0;
                int n4;
                while (true) {
                    n4 = n;
                    if (n != -1) {
                        break;
                    }
                    n4 = n;
                    if (n3 >= read) {
                        break;
                    }
                    if (array[n3] == 10) {
                        n4 = n2 + n3;
                        break;
                    }
                    ++n3;
                }
                byteArrayOutputStream.write(array, 0, read);
                n2 += read;
                n = n4;
            }
            final byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray.length == 0) {
                throw new IllegalArgumentException("Empty stream.");
            }
            if (n == -1) {
                throw new IllegalArgumentException("Envelope contains no header.");
            }
            final m3 b = this.b(byteArray, 0, n);
            if (b == null) {
                throw new IllegalArgumentException("Envelope header is null.");
            }
            int n5 = n + 1;
            final ArrayList list = new ArrayList();
        Label_0269:
            while (true) {
                int n6;
                do {
                    int i = n5;
                    while (true) {
                        while (i < byteArray.length) {
                            if (byteArray[i] == 10) {
                                if (i == -1) {
                                    final StringBuilder sb = new StringBuilder();
                                    sb.append("Invalid envelope. Item at index '");
                                    sb.append(((List)list).size());
                                    sb.append("'. has no header delimiter.");
                                    throw new IllegalArgumentException(sb.toString());
                                }
                                final d4 c = this.c(byteArray, n5, i - n5);
                                if (c == null || c.a() <= 0) {
                                    final StringBuilder sb2 = new StringBuilder();
                                    sb2.append("Item header at index '");
                                    sb2.append(((List)list).size());
                                    sb2.append("' is null or empty.");
                                    throw new IllegalArgumentException(sb2.toString());
                                }
                                n6 = c.a() + i + 1;
                                if (n6 > byteArray.length) {
                                    final StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Invalid length for item at index '");
                                    sb3.append(((List)list).size());
                                    sb3.append("'. Item is '");
                                    sb3.append(n6);
                                    sb3.append("' bytes. There are '");
                                    sb3.append(byteArray.length);
                                    sb3.append("' in the buffer.");
                                    throw new IllegalArgumentException(sb3.toString());
                                }
                                ((List)list).add((Object)new c4(c, Arrays.copyOfRange(byteArray, i + 1, n6)));
                                if (n6 == byteArray.length) {
                                    final l3 l3 = new l3(b, (Iterable)list);
                                    byteArrayOutputStream.close();
                                    return l3;
                                }
                                continue Label_0269;
                            }
                            else {
                                ++i;
                            }
                        }
                        i = -1;
                        continue;
                    }
                } while ((n5 = n6 + 1) != byteArray.length);
                if (byteArray[n6] == 10) {
                    continue;
                }
                break;
            }
            throw new IllegalArgumentException("Envelope has invalid data following an item.");
        }
        finally {
            try {
                byteArrayOutputStream.close();
            }
            finally {
                final Throwable t;
                ((Throwable)inputStream).addSuppressed(t);
            }
        }
    }
}
