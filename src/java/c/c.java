package c;

import java.util.concurrent.Executor;

public class c extends f
{
    private static volatile c c;
    private static final Executor d;
    private static final Executor e;
    private f a;
    private final f b;
    
    static {
        d = (Executor)new a();
        e = (Executor)new b();
    }
    
    private c() {
        final d d = new d();
        this.b = d;
        this.a = d;
    }
    
    public static c f() {
        if (c.c.c != null) {
            return c.c.c;
        }
        synchronized (c.class) {
            if (c.c.c == null) {
                c.c.c = new c();
            }
            return c.c.c;
        }
    }
    
    public void a(final Runnable runnable) {
        this.a.a(runnable);
    }
    
    public boolean b() {
        return this.a.b();
    }
    
    public void c(final Runnable runnable) {
        this.a.c(runnable);
    }
}
