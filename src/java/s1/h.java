package s1;

import java.util.Map;
import java.util.HashMap;
import f1.b;
import t1.l;
import t1.c;
import t1.g;
import g1.a;
import t1.k;

public class h
{
    public final k a;
    private final k.c b;
    
    public h(final a a) {
        final h$a b = new h$a(this);
        this.b = (k.c)b;
        (this.a = new k(a, "flutter/navigation", (l)g.a)).e((k.c)b);
    }
    
    public void a() {
        f1.b.f("NavigationChannel", "Sending message to pop route.");
        this.a.c("popRoute", null);
    }
    
    public void b(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Sending message to push route information '");
        sb.append(s);
        sb.append("'");
        f1.b.f("NavigationChannel", sb.toString());
        final HashMap hashMap = new HashMap();
        ((Map)hashMap).put((Object)"location", (Object)s);
        this.a.c("pushRouteInformation", hashMap);
    }
    
    public void c(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("Sending message to set initial route to '");
        sb.append(s);
        sb.append("'");
        f1.b.f("NavigationChannel", sb.toString());
        this.a.c("setInitialRoute", s);
    }
}
