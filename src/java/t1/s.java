package t1;

import java.nio.Buffer;
import java.io.OutputStream;
import java.nio.ByteOrder;
import f1.b;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class s implements l
{
    public static final s b;
    private final r a;
    
    static {
        b = new s(r.a);
    }
    
    public s(final r a) {
        this.a = a;
    }
    
    public ByteBuffer a(final j j) {
        final r$a r$a = new r$a();
        this.a.p((ByteArrayOutputStream)r$a, j.a);
        this.a.p((ByteArrayOutputStream)r$a, j.b);
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((ByteArrayOutputStream)r$a).size());
        allocateDirect.put(r$a.a(), 0, ((ByteArrayOutputStream)r$a).size());
        return allocateDirect;
    }
    
    public ByteBuffer b(final Object o) {
        final r$a r$a = new r$a();
        ((OutputStream)r$a).write(0);
        this.a.p((ByteArrayOutputStream)r$a, o);
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((ByteArrayOutputStream)r$a).size());
        allocateDirect.put(r$a.a(), 0, ((ByteArrayOutputStream)r$a).size());
        return allocateDirect;
    }
    
    public ByteBuffer c(final String s, final String s2, final Object o, final String s3) {
        final r$a r$a = new r$a();
        ((OutputStream)r$a).write(1);
        this.a.p((ByteArrayOutputStream)r$a, s);
        this.a.p((ByteArrayOutputStream)r$a, s2);
        if (o instanceof Throwable) {
            this.a.p((ByteArrayOutputStream)r$a, f1.b.d((Throwable)o));
        }
        else {
            this.a.p((ByteArrayOutputStream)r$a, o);
        }
        this.a.p((ByteArrayOutputStream)r$a, s3);
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((ByteArrayOutputStream)r$a).size());
        allocateDirect.put(r$a.a(), 0, ((ByteArrayOutputStream)r$a).size());
        return allocateDirect;
    }
    
    public ByteBuffer d(final String s, final String s2, final Object o) {
        final r$a r$a = new r$a();
        ((OutputStream)r$a).write(1);
        this.a.p((ByteArrayOutputStream)r$a, s);
        this.a.p((ByteArrayOutputStream)r$a, s2);
        if (o instanceof Throwable) {
            this.a.p((ByteArrayOutputStream)r$a, f1.b.d((Throwable)o));
        }
        else {
            this.a.p((ByteArrayOutputStream)r$a, o);
        }
        final ByteBuffer allocateDirect = ByteBuffer.allocateDirect(((ByteArrayOutputStream)r$a).size());
        allocateDirect.put(r$a.a(), 0, ((ByteArrayOutputStream)r$a).size());
        return allocateDirect;
    }
    
    public j e(final ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        final Object f = this.a.f(byteBuffer);
        final Object f2 = this.a.f(byteBuffer);
        if (f instanceof String && !((Buffer)byteBuffer).hasRemaining()) {
            return new j((String)f, f2);
        }
        throw new IllegalArgumentException("Method call corrupted");
    }
    
    public Object f(final ByteBuffer byteBuffer) {
        byteBuffer.order(ByteOrder.nativeOrder());
        final byte value = byteBuffer.get();
        if (value != 0) {
            if (value != 1) {
                throw new IllegalArgumentException("Envelope corrupted");
            }
        }
        else {
            final Object f = this.a.f(byteBuffer);
            if (!((Buffer)byteBuffer).hasRemaining()) {
                return f;
            }
        }
        final Object f2 = this.a.f(byteBuffer);
        final Object f3 = this.a.f(byteBuffer);
        final Object f4 = this.a.f(byteBuffer);
        if (f2 instanceof String && (f3 == null || f3 instanceof String) && !((Buffer)byteBuffer).hasRemaining()) {
            throw new e((String)f2, (String)f3, f4);
        }
        throw new IllegalArgumentException("Envelope corrupted");
    }
}
