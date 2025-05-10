package t1;

import java.nio.Buffer;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.List;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class r implements i<Object>
{
    public static final r a;
    private static final boolean b;
    private static final Charset c;
    
    static {
        a = new r();
        b = (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN);
        c = Charset.forName("UTF8");
    }
    
    protected static final void c(final ByteBuffer byteBuffer, final int n) {
        final int n2 = ((Buffer)byteBuffer).position() % n;
        if (n2 != 0) {
            byteBuffer.position(((Buffer)byteBuffer).position() + n - n2);
        }
    }
    
    protected static final byte[] d(final ByteBuffer byteBuffer) {
        final byte[] array = new byte[e(byteBuffer)];
        byteBuffer.get(array);
        return array;
    }
    
    protected static final int e(final ByteBuffer byteBuffer) {
        if (!((Buffer)byteBuffer).hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        final int n = byteBuffer.get() & 0xFF;
        if (n < 254) {
            return n;
        }
        if (n == 254) {
            return byteBuffer.getChar();
        }
        return byteBuffer.getInt();
    }
    
    protected static final void h(final ByteArrayOutputStream byteArrayOutputStream, final int n) {
        final int n2 = byteArrayOutputStream.size() % n;
        if (n2 != 0) {
            for (int i = 0; i < n - n2; ++i) {
                byteArrayOutputStream.write(0);
            }
        }
    }
    
    protected static final void i(final ByteArrayOutputStream byteArrayOutputStream, final byte[] array) {
        o(byteArrayOutputStream, array.length);
        byteArrayOutputStream.write(array, 0, array.length);
    }
    
    protected static final void j(final ByteArrayOutputStream byteArrayOutputStream, final int n) {
        if (r.b) {
            byteArrayOutputStream.write(n);
            byteArrayOutputStream.write(n >>> 8);
        }
        else {
            byteArrayOutputStream.write(n >>> 8);
            byteArrayOutputStream.write(n);
        }
    }
    
    protected static final void k(final ByteArrayOutputStream byteArrayOutputStream, final double n) {
        n(byteArrayOutputStream, Double.doubleToLongBits(n));
    }
    
    protected static final void l(final ByteArrayOutputStream byteArrayOutputStream, final float n) {
        m(byteArrayOutputStream, Float.floatToIntBits(n));
    }
    
    protected static final void m(final ByteArrayOutputStream byteArrayOutputStream, final int n) {
        if (r.b) {
            byteArrayOutputStream.write(n);
            byteArrayOutputStream.write(n >>> 8);
            byteArrayOutputStream.write(n >>> 16);
            byteArrayOutputStream.write(n >>> 24);
        }
        else {
            byteArrayOutputStream.write(n >>> 24);
            byteArrayOutputStream.write(n >>> 16);
            byteArrayOutputStream.write(n >>> 8);
            byteArrayOutputStream.write(n);
        }
    }
    
    protected static final void n(final ByteArrayOutputStream byteArrayOutputStream, final long n) {
        if (r.b) {
            byteArrayOutputStream.write((int)(byte)n);
            byteArrayOutputStream.write((int)(byte)(n >>> 8));
            byteArrayOutputStream.write((int)(byte)(n >>> 16));
            byteArrayOutputStream.write((int)(byte)(n >>> 24));
            byteArrayOutputStream.write((int)(byte)(n >>> 32));
            byteArrayOutputStream.write((int)(byte)(n >>> 40));
            byteArrayOutputStream.write((int)(byte)(n >>> 48));
            byteArrayOutputStream.write((int)(byte)(n >>> 56));
        }
        else {
            byteArrayOutputStream.write((int)(byte)(n >>> 56));
            byteArrayOutputStream.write((int)(byte)(n >>> 48));
            byteArrayOutputStream.write((int)(byte)(n >>> 40));
            byteArrayOutputStream.write((int)(byte)(n >>> 32));
            byteArrayOutputStream.write((int)(byte)(n >>> 24));
            byteArrayOutputStream.write((int)(byte)(n >>> 16));
            byteArrayOutputStream.write((int)(byte)(n >>> 8));
            byteArrayOutputStream.write((int)(byte)n);
        }
    }
    
    protected static final void o(final ByteArrayOutputStream byteArrayOutputStream, final int n) {
        if (n < 254) {
            byteArrayOutputStream.write(n);
        }
        else if (n <= 65535) {
            byteArrayOutputStream.write(254);
            j(byteArrayOutputStream, n);
        }
        else {
            byteArrayOutputStream.write(255);
            m(byteArrayOutputStream, n);
        }
    }
    
    public ByteBuffer a(final Object o) {
        if (o == null) {
            return null;
        }
        final r.r$a r$a = new r.r$a();
        this.p((ByteArrayOutputStream)r$a, o);
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((ByteArrayOutputStream)r$a).size());
        allocateDirect.put(r$a.a(), 0, ((ByteArrayOutputStream)r$a).size());
        return allocateDirect;
    }
    
    public Object b(final ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        final Object f = this.f(byteBuffer);
        if (!((Buffer)byteBuffer).hasRemaining()) {
            return f;
        }
        throw new IllegalArgumentException("Message corrupted");
    }
    
    protected final Object f(final ByteBuffer byteBuffer) {
        if (((Buffer)byteBuffer).hasRemaining()) {
            return this.g(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }
    
    protected Object g(final byte b, final ByteBuffer byteBuffer) {
        final int n = 0;
        final int n2 = 0;
        Object o2 = null;
        Label_0232: {
            switch (b) {
                default: {
                    throw new IllegalArgumentException("Message corrupted");
                }
                case 14: {
                    final int e = e(byteBuffer);
                    final float[] array = new float[e];
                    c(byteBuffer, 4);
                    byteBuffer.asFloatBuffer().get(array);
                    byteBuffer.position(((Buffer)byteBuffer).position() + e * 4);
                    return array;
                }
                case 13: {
                    final int e2 = e(byteBuffer);
                    final float[] array2 = (Object)new HashMap();
                    int n3 = n2;
                    while (true) {
                        o2 = array2;
                        if (n3 >= e2) {
                            break Label_0232;
                        }
                        ((Map)(Object)array2).put(this.f(byteBuffer), this.f(byteBuffer));
                        ++n3;
                    }
                    break;
                }
                case 12: {
                    final int e3 = e(byteBuffer);
                    final ArrayList list = new ArrayList(e3);
                    int n4 = n;
                    while (true) {
                        o2 = list;
                        if (n4 >= e3) {
                            break Label_0232;
                        }
                        ((List)list).add(this.f(byteBuffer));
                        ++n4;
                    }
                    break;
                }
                case 11: {
                    final int e4 = e(byteBuffer);
                    final double[] array3 = new double[e4];
                    c(byteBuffer, 8);
                    byteBuffer.asDoubleBuffer().get(array3);
                    byteBuffer.position(((Buffer)byteBuffer).position() + e4 * 8);
                    return array3;
                }
                case 10: {
                    final int e5 = e(byteBuffer);
                    final long[] array4 = new long[e5];
                    c(byteBuffer, 8);
                    byteBuffer.asLongBuffer().get(array4);
                    byteBuffer.position(((Buffer)byteBuffer).position() + e5 * 8);
                    return array4;
                }
                case 9: {
                    final int e6 = e(byteBuffer);
                    final int[] array5 = new int[e6];
                    c(byteBuffer, 4);
                    byteBuffer.asIntBuffer().get(array5);
                    byteBuffer.position(((Buffer)byteBuffer).position() + e6 * 4);
                    return array5;
                }
                case 8: {
                    return d(byteBuffer);
                }
                case 7: {
                    return new String(d(byteBuffer), r.c);
                }
                case 6: {
                    c(byteBuffer, 8);
                    return byteBuffer.getDouble();
                }
                case 5: {
                    return new BigInteger(new String(d(byteBuffer), r.c), 16);
                }
                case 4: {
                    return byteBuffer.getLong();
                }
                case 3: {
                    return byteBuffer.getInt();
                }
                case 2: {
                    return Boolean.FALSE;
                }
                case 1: {
                    return Boolean.TRUE;
                }
                case 0: {
                    return null;
                }
            }
        }
        return o2;
    }
    
    protected void p(final ByteArrayOutputStream byteArrayOutputStream, final Object o) {
        final int n = 0;
        int i = 0;
        final int n2 = 0;
        final int n3 = 0;
        if (o != null && !o.equals(null)) {
            if (o instanceof Boolean) {
                int n4;
                if (o) {
                    n4 = 1;
                }
                else {
                    n4 = 2;
                }
                byteArrayOutputStream.write(n4);
            }
            else if (o instanceof Number) {
                if (!(o instanceof Integer) && !(o instanceof Short) && !(o instanceof Byte)) {
                    if (o instanceof Long) {
                        byteArrayOutputStream.write(4);
                        n(byteArrayOutputStream, (long)o);
                    }
                    else if (!(o instanceof Float) && !(o instanceof Double)) {
                        if (!(o instanceof BigInteger)) {
                            final StringBuilder sb = new StringBuilder();
                            sb.append("Unsupported Number type: ");
                            sb.append((Object)o.getClass());
                            throw new IllegalArgumentException(sb.toString());
                        }
                        byteArrayOutputStream.write(5);
                        i(byteArrayOutputStream, ((BigInteger)o).toString(16).getBytes(r.c));
                    }
                    else {
                        byteArrayOutputStream.write(6);
                        h(byteArrayOutputStream, 8);
                        k(byteArrayOutputStream, ((Number)o).doubleValue());
                    }
                }
                else {
                    byteArrayOutputStream.write(3);
                    m(byteArrayOutputStream, ((Number)o).intValue());
                }
            }
            else if (o instanceof CharSequence) {
                byteArrayOutputStream.write(7);
                i(byteArrayOutputStream, o.toString().getBytes(r.c));
            }
            else if (o instanceof byte[]) {
                byteArrayOutputStream.write(8);
                i(byteArrayOutputStream, (byte[])o);
            }
            else if (o instanceof int[]) {
                byteArrayOutputStream.write(9);
                final int[] array = (int[])o;
                o(byteArrayOutputStream, array.length);
                h(byteArrayOutputStream, 4);
                for (int length = array.length, j = n3; j < length; ++j) {
                    m(byteArrayOutputStream, array[j]);
                }
            }
            else if (o instanceof long[]) {
                byteArrayOutputStream.write(10);
                final long[] array2 = (long[])o;
                o(byteArrayOutputStream, array2.length);
                h(byteArrayOutputStream, 8);
                for (int length2 = array2.length, k = n; k < length2; ++k) {
                    n(byteArrayOutputStream, array2[k]);
                }
            }
            else if (o instanceof double[]) {
                byteArrayOutputStream.write(11);
                final double[] array3 = (double[])o;
                o(byteArrayOutputStream, array3.length);
                h(byteArrayOutputStream, 8);
                while (i < array3.length) {
                    k(byteArrayOutputStream, array3[i]);
                    ++i;
                }
            }
            else if (o instanceof List) {
                byteArrayOutputStream.write(12);
                final List list = (List)o;
                o(byteArrayOutputStream, list.size());
                final Iterator iterator = list.iterator();
                while (iterator.hasNext()) {
                    this.p(byteArrayOutputStream, iterator.next());
                }
            }
            else if (o instanceof Map) {
                byteArrayOutputStream.write(13);
                final Map map = (Map)o;
                o(byteArrayOutputStream, map.size());
                for (final Map$Entry map$Entry : map.entrySet()) {
                    this.p(byteArrayOutputStream, map$Entry.getKey());
                    this.p(byteArrayOutputStream, map$Entry.getValue());
                }
            }
            else {
                if (!(o instanceof float[])) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unsupported value: '");
                    sb2.append(o);
                    sb2.append("' of type '");
                    sb2.append((Object)o.getClass());
                    sb2.append("'");
                    throw new IllegalArgumentException(sb2.toString());
                }
                byteArrayOutputStream.write(14);
                final float[] array4 = (float[])o;
                o(byteArrayOutputStream, array4.length);
                h(byteArrayOutputStream, 4);
                for (int length3 = array4.length, l = n2; l < length3; ++l) {
                    l(byteArrayOutputStream, array4[l]);
                }
            }
        }
        else {
            byteArrayOutputStream.write(0);
        }
    }
}
