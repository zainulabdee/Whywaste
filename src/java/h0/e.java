package h0;

import com.google.android.gms.common.api.internal.d$a;
import e0.k;
import q0.c;
import w0.g;
import f0.l;
import d0.a$d;
import d0.e$a;
import android.content.Context;
import d0.a;
import f0.n;
import f0.o;

public final class e extends d0.e<o> implements n
{
    private static final a.g<f> k;
    private static final a.a<f, o> l;
    private static final a<o> m;
    public static final int n = 0;
    
    static {
        m = new a("ClientTelemetry.API", l = (a.a)new d(), k = new a.g());
    }
    
    public e(final Context context, final o o) {
        super(context, (a)e.m, (a$d)o, e$a.c);
    }
    
    public final g<Void> b(final l l) {
        final d$a a = com.google.android.gms.common.api.internal.d.a();
        a.d(new c0.d[] { c.a });
        a.c(false);
        a.b((k)new h0.c(l));
        return this.f(a.a());
    }
}
