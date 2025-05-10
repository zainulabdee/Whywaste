package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

public class e
{
    private static volatile e b;
    private final Map<String, d> a;
    
    e() {
        this.a = (Map<String, d>)new HashMap();
    }
    
    public static e b() {
        if (e.b == null) {
            synchronized (e.class) {
                if (e.b == null) {
                    e.b = new e();
                }
            }
        }
        return e.b;
    }
    
    public d a(final String s) {
        return (d)this.a.get((Object)s);
    }
}
