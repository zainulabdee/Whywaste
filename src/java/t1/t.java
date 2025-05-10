package t1;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class t implements i<String>
{
    private static final Charset a;
    public static final t b;
    
    static {
        a = Charset.forName("UTF8");
        b = new t();
    }
    
    private t() {
    }
    
    public String c(final ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        final int remaining = ((Buffer)byteBuffer).remaining();
        int arrayOffset;
        byte[] array2;
        if (byteBuffer.hasArray()) {
            final byte[] array = byteBuffer.array();
            arrayOffset = byteBuffer.arrayOffset();
            array2 = array;
        }
        else {
            final byte[] array3 = new byte[remaining];
            byteBuffer.get(array3);
            arrayOffset = 0;
            array2 = array3;
        }
        return new String(array2, arrayOffset, remaining, t.a);
    }
    
    public ByteBuffer d(final String s) {
        if (s == null) {
            return null;
        }
        final byte[] bytes = s.getBytes(t.a);
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bytes.length);
        allocateDirect.put(bytes);
        return allocateDirect;
    }
}
