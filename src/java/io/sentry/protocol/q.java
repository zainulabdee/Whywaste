package io.sentry.protocol;

import io.sentry.i1;
import io.sentry.c1;
import io.sentry.n0;
import io.sentry.k1;
import io.sentry.util.r;
import java.util.UUID;
import io.sentry.m1;

public final class q implements m1
{
    public static final q f;
    private final UUID e;
    
    static {
        f = new q(new UUID(0L, 0L));
    }
    
    public q() {
        this((UUID)null);
    }
    
    public q(final String s) {
        this.e = this.a(r.d(s));
    }
    
    public q(final UUID uuid) {
        UUID randomUUID = uuid;
        if (uuid == null) {
            randomUUID = UUID.randomUUID();
        }
        this.e = randomUUID;
    }
    
    private UUID a(final String s) {
        String string = s;
        if (s.length() == 32) {
            string = new StringBuilder(s).insert(8, "-").insert(13, "-").insert(18, "-").insert(23, "-").toString();
        }
        if (string.length() == 36) {
            return UUID.fromString(string);
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: ");
        sb.append(string);
        throw new IllegalArgumentException(sb.toString());
    }
    
    @Override
    public boolean equals(final Object o) {
        boolean b = true;
        if (this == o) {
            return true;
        }
        if (o != null && q.class == o.getClass()) {
            if (this.e.compareTo(((q)o).e) != 0) {
                b = false;
            }
            return b;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.e.hashCode();
    }
    
    public void serialize(final k1 k1, final n0 n0) {
        k1.v(this.toString());
    }
    
    @Override
    public String toString() {
        return r.d(this.e.toString()).replace((CharSequence)"-", (CharSequence)"");
    }
    
    public static final class a implements c1<q>
    {
        public q b(final i1 i1, final n0 n0) {
            return new q(i1.v());
        }
    }
}
