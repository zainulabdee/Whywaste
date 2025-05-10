package q;

import java.util.HashSet;
import java.util.Set;

public abstract class y
{
    private static final Set<y> c;
    private final String a;
    private final String b;
    
    static {
        c = (Set)new HashSet();
    }
    
    y(final String a, final String b) {
        this.a = a;
        this.b = b;
        y.c.add((Object)this);
    }
}
