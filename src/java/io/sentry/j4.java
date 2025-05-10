package io.sentry;

import io.sentry.util.n;
import java.util.concurrent.CopyOnWriteArraySet;
import io.sentry.protocol.r;
import java.util.Set;

public final class j4
{
    private static volatile j4 c;
    private final Set<String> a;
    private final Set<r> b;
    
    private j4() {
        this.a = (Set<String>)new CopyOnWriteArraySet();
        this.b = (Set<r>)new CopyOnWriteArraySet();
    }
    
    public static j4 c() {
        if (j4.c == null) {
            synchronized (j4.class) {
                if (j4.c == null) {
                    j4.c = new j4();
                }
            }
        }
        return j4.c;
    }
    
    public void a(final String s) {
        n.c(s, "integration is required.");
        this.a.add((Object)s);
    }
    
    public void b(final String s, final String s2) {
        n.c(s, "name is required.");
        n.c(s2, "version is required.");
        this.b.add((Object)new r(s, s2));
    }
    
    public Set<String> d() {
        return this.a;
    }
    
    public Set<r> e() {
        return this.b;
    }
}
