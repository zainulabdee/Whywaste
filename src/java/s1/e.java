package s1;

import f1.b;
import t1.i;
import t1.c;
import t1.t;
import t1.a;

public class e
{
    public final a<String> a;
    
    public e(final g1.a a) {
        this.a = new a<String>(a, "flutter/lifecycle", (i<String>)t.b);
    }
    
    public void a() {
        b.f("LifecycleChannel", "Sending AppLifecycleState.detached message.");
        this.a.c("AppLifecycleState.detached");
    }
    
    public void b() {
        b.f("LifecycleChannel", "Sending AppLifecycleState.inactive message.");
        this.a.c("AppLifecycleState.inactive");
    }
    
    public void c() {
        b.f("LifecycleChannel", "Sending AppLifecycleState.paused message.");
        this.a.c("AppLifecycleState.paused");
    }
    
    public void d() {
        b.f("LifecycleChannel", "Sending AppLifecycleState.resumed message.");
        this.a.c("AppLifecycleState.resumed");
    }
}
