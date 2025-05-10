package io.flutter.embedding.engine;

import java.util.HashMap;
import java.util.Map;

public class b
{
    private static b b;
    private final Map<String, a> a;
    
    b() {
        this.a = (Map<String, a>)new HashMap();
    }
    
    public static b b() {
        if (io.flutter.embedding.engine.b.b == null) {
            io.flutter.embedding.engine.b.b = new b();
        }
        return io.flutter.embedding.engine.b.b;
    }
    
    public a a(final String s) {
        return (a)this.a.get((Object)s);
    }
    
    public void c(final String s, final a a) {
        if (a != null) {
            this.a.put((Object)s, (Object)a);
        }
        else {
            this.a.remove((Object)s);
        }
    }
    
    public void d(final String s) {
        this.c(s, null);
    }
}
