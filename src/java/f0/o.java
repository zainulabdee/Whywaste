package f0;

import android.os.BaseBundle;
import android.os.Bundle;
import d0.a$d;

public class o implements a$d
{
    public static final o f;
    private final String e = e;
    
    static {
        f = a().a();
    }
    
    public static o.o$a a() {
        return new o.o$a((q)null);
    }
    
    public final Bundle c() {
        final Bundle bundle = new Bundle();
        final String e = this.e;
        if (e != null) {
            ((BaseBundle)bundle).putString("api", e);
        }
        return bundle;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o == this || (o instanceof o && g.b((Object)this.e, (Object)((o)o).e));
    }
    
    @Override
    public final int hashCode() {
        return g.c(new Object[] { this.e });
    }
}
