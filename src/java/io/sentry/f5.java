package io.sentry;

import io.sentry.util.r;
import io.sentry.util.n;
import java.util.UUID;

public final class f5 implements m1
{
    public static final f5 f;
    private final String e;
    
    static {
        f = new f5(new UUID(0L, 0L));
    }
    
    public f5() {
        this(UUID.randomUUID());
    }
    
    public f5(final String s) {
        this.e = (String)n.c((Object)s, "value is required");
    }
    
    private f5(final UUID uuid) {
        this(r.d(uuid.toString()).replace((CharSequence)"-", (CharSequence)"").substring(0, 16));
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o != null && f5.class == o.getClass() && this.e.equals((Object)((f5)o).e));
    }
    
    @Override
    public int hashCode() {
        return this.e.hashCode();
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.v(this.e);
    }
    
    @Override
    public String toString() {
        return this.e;
    }
    
    public static final class a implements c1<f5>
    {
        public f5 b(final i1 i1, final n0 n0) {
            return new f5(i1.v());
        }
    }
}
