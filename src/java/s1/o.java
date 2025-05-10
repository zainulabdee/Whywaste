package s1;

import java.util.Map;
import java.util.HashMap;
import f1.b;
import t1.i;
import t1.c;
import t1.f;
import t1.a;

public class o
{
    public final a<Object> a;
    
    public o(final g1.a a) {
        this.a = new a<Object>(a, "flutter/system", (i<Object>)f.a);
    }
    
    public void a() {
        b.f("SystemChannel", "Sending memory pressure warning to Flutter.");
        final HashMap hashMap = new HashMap(1);
        ((Map)hashMap).put((Object)"type", (Object)"memoryPressure");
        this.a.c(hashMap);
    }
}
