package t1;

import org.json.JSONException;
import org.json.JSONTokener;
import org.json.JSONObject;
import java.nio.ByteBuffer;

public final class f implements i<Object>
{
    public static final f a;
    
    static {
        a = new f();
    }
    
    private f() {
    }
    
    public ByteBuffer a(Object a) {
        if (a == null) {
            return null;
        }
        a = h.a(a);
        if (a instanceof String) {
            return t.b.d(JSONObject.quote((String)a));
        }
        return t.b.d(a.toString());
    }
    
    public Object b(final ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        try {
            final JSONTokener jsonTokener = new JSONTokener(t.b.c(byteBuffer));
            final Object nextValue = jsonTokener.nextValue();
            if (!jsonTokener.more()) {
                return nextValue;
            }
            throw new IllegalArgumentException("Invalid JSON");
        }
        catch (final JSONException ex) {
            throw new IllegalArgumentException("Invalid JSON", (Throwable)ex);
        }
    }
}
