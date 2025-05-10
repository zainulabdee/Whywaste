package d0;

import com.google.android.gms.common.api.internal.BasePendingResult;
import e0.n;
import com.google.android.gms.common.api.Status;
import e0.j;

public final class i
{
    public static <R extends l> h<R> a(final R r, final f f) {
        f0.i.j(r, "Result must not be null");
        f0.i.b(r.a().i() ^ true, "Status code must not be SUCCESS");
        final q q = new q(f, (l)r);
        ((BasePendingResult)q).g((l)r);
        return (h<R>)q;
    }
    
    public static <R extends l> g<R> b(final R r, final f f) {
        f0.i.j(r, "Result must not be null");
        final r r2 = new r(f);
        ((BasePendingResult)r2).g((l)r);
        return (g<R>)new j((h)r2);
    }
    
    public static h<Status> c(final Status status, final f f) {
        f0.i.j(status, "Result must not be null");
        final n n = new n(f);
        ((BasePendingResult)n).g((l)status);
        return (h<Status>)n;
    }
}
