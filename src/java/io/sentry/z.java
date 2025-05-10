package io.sentry;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public final class z
{
    private static final z b;
    private final List<a> a;
    
    static {
        b = new z();
    }
    
    private z() {
        this.a = (List<a>)new CopyOnWriteArrayList();
    }
    
    public static z a() {
        return z.b;
    }
    
    public void b(final a a) {
        this.a.add((Object)a);
    }
    
    public interface a
    {
    }
}
