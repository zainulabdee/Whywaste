package c1;

import a1.d0;
import java.util.HashMap;
import java.util.Map;

public class h
{
    public static Map<String, Object> a(final e e) {
        final d0 d = e.d();
        Object o;
        if (d != null) {
            o = new HashMap();
            ((Map)o).put((Object)"sql", (Object)d.c());
            ((Map)o).put((Object)"arguments", (Object)d.b());
        }
        else {
            o = null;
        }
        return (Map<String, Object>)o;
    }
}
