package t1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.nio.ByteBuffer;

public final class g implements l
{
    public static final g a;
    
    static {
        a = new g();
    }
    
    private g() {
    }
    
    public ByteBuffer a(final j j) {
        try {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("method", (Object)j.a);
            jsonObject.put("args", h.a(j.b));
            return f.a.a(jsonObject);
        }
        catch (final JSONException ex) {
            throw new IllegalArgumentException("Invalid JSON", (Throwable)ex);
        }
    }
    
    public ByteBuffer b(final Object o) {
        return f.a.a(new JSONArray().put(h.a(o)));
    }
    
    public ByteBuffer c(final String s, final String s2, final Object o, final String s3) {
        return f.a.a(new JSONArray().put((Object)s).put(h.a((Object)s2)).put(h.a(o)).put(h.a((Object)s3)));
    }
    
    public ByteBuffer d(final String s, final String s2, final Object o) {
        return f.a.a(new JSONArray().put((Object)s).put(h.a((Object)s2)).put(h.a(o)));
    }
    
    public j e(final ByteBuffer byteBuffer) {
        try {
            final Object b = f.a.b(byteBuffer);
            if (b instanceof JSONObject) {
                final JSONObject jsonObject = (JSONObject)b;
                final Object value = jsonObject.get("method");
                final Object g = this.g(jsonObject.opt("args"));
                if (value instanceof String) {
                    return new j((String)value, g);
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid method call: ");
            sb.append(b);
            throw new IllegalArgumentException(sb.toString());
        }
        catch (final JSONException ex) {
            throw new IllegalArgumentException("Invalid JSON", (Throwable)ex);
        }
    }
    
    public Object f(final ByteBuffer byteBuffer) {
        try {
            final Object b = f.a.b(byteBuffer);
            if (b instanceof JSONArray) {
                final JSONArray jsonArray = (JSONArray)b;
                if (jsonArray.length() == 1) {
                    return this.g(jsonArray.opt(0));
                }
                if (jsonArray.length() == 3) {
                    final Object value = jsonArray.get(0);
                    final Object g = this.g(jsonArray.opt(1));
                    final Object g2 = this.g(jsonArray.opt(2));
                    if (value instanceof String && (g == null || g instanceof String)) {
                        throw new e((String)value, (String)g, g2);
                    }
                }
            }
            final StringBuilder sb = new StringBuilder();
            sb.append("Invalid envelope: ");
            sb.append(b);
            throw new IllegalArgumentException(sb.toString());
        }
        catch (final JSONException ex) {
            throw new IllegalArgumentException("Invalid JSON", (Throwable)ex);
        }
    }
    
    Object g(final Object o) {
        Object o2 = o;
        if (o == JSONObject.NULL) {
            o2 = null;
        }
        return o2;
    }
}
