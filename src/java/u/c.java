package u;

import android.os.Bundle;
import d0.a$d;

public final class c implements a$d
{
    public static final c f;
    private final Bundle e = e;
    
    static {
        f = new c(new Bundle(), null);
    }
    
    public final Bundle a() {
        return new Bundle(this.e);
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o == this || (o instanceof c && f0.g.a(this.e, ((c)o).e));
    }
    
    @Override
    public final int hashCode() {
        return f0.g.c(new Object[] { this.e });
    }
}
