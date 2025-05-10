package t1;

import org.json.JSONObject;
import java.util.Map;

public final class j
{
    public final String a;
    public final Object b;
    
    public j(final String a, final Object b) {
        this.a = a;
        this.b = b;
    }
    
    public <T> T a(final String s) {
        final Object b = this.b;
        if (b == null) {
            return null;
        }
        if (b instanceof Map) {
            return (T)((Map)b).get((Object)s);
        }
        if (b instanceof JSONObject) {
            return (T)((JSONObject)b).opt(s);
        }
        throw new ClassCastException();
    }
    
    public <T> T b() {
        return (T)this.b;
    }
    
    public boolean c(final String s) {
        final Object b = this.b;
        if (b == null) {
            return false;
        }
        if (b instanceof Map) {
            return ((Map)b).containsKey((Object)s);
        }
        if (b instanceof JSONObject) {
            return ((JSONObject)b).has(s);
        }
        throw new ClassCastException();
    }
}
