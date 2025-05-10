package io.flutter.embedding.android;

import java.io.UnsupportedEncodingException;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;

public class u
{
    long a;
    a b;
    long c;
    long d;
    boolean e;
    String f;
    
    ByteBuffer a() {
        try {
            final String f = this.f;
            byte[] bytes;
            if (f == null) {
                bytes = null;
            }
            else {
                bytes = f.getBytes("UTF-8");
            }
            int length;
            if (bytes == null) {
                length = 0;
            }
            else {
                length = bytes.length;
            }
            final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length + 48);
            allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            allocateDirect.putLong((long)length);
            allocateDirect.putLong(this.a);
            allocateDirect.putLong(this.b.d());
            allocateDirect.putLong(this.c);
            allocateDirect.putLong(this.d);
            long n;
            if (this.e) {
                n = 1L;
            }
            else {
                n = 0L;
            }
            allocateDirect.putLong(n);
            if (bytes != null) {
                allocateDirect.put(bytes);
            }
            return allocateDirect;
        }
        catch (final UnsupportedEncodingException ex) {
            throw new AssertionError((Object)"UTF-8 not supported");
        }
    }
    
    public enum a
    {
        f(0L), 
        g(1L), 
        h(2L);
        
        private static final a[] i;
        private long e;
        
        private a(final long e) {
            this.e = e;
        }
        
        public long d() {
            return this.e;
        }
    }
}
