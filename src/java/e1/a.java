package e1;

import java.io.IOException;
import java.util.List;
import android.os.Build$VERSION;
import r2.d;
import java.util.Map;
import t1.j;
import kotlin.jvm.internal.i;
import t1.k;

public final class a implements c
{
    private final e1.c a;
    private final e b;
    
    public a(final e1.c a, final e b) {
        i.e((Object)a, "share");
        i.e((Object)b, "manager");
        this.a = a;
        this.b = b;
    }
    
    private final void a(final j j) {
        if (j.b instanceof Map) {
            return;
        }
        throw new IllegalArgumentException("Map arguments expected".toString());
    }
    
    @Override
    public void onMethodCall(final j j, final d d) {
        i.e((Object)j, "call");
        i.e((Object)d, "result");
        final String a = j.a;
        i.d((Object)a, "call.method");
        final boolean i = d.i(a, "WithResult", false, 2, (Object)null);
        final boolean b = i && Build$VERSION.SDK_INT >= 22;
        final String a2 = j.a;
        Label_0458: {
            if (a2 != null) {
                Label_0333: {
                    switch (a2.hashCode()) {
                        default: {
                            break Label_0458;
                        }
                        case 109400031: {
                            if (!a2.equals((Object)"share")) {
                                break Label_0458;
                            }
                            break;
                        }
                        case -743768819: {
                            if (!a2.equals((Object)"shareUri")) {
                                break Label_0458;
                            }
                            this.a(j);
                            final e1.c a3 = this.a;
                            final String a4 = j.a("uri");
                            kotlin.jvm.internal.i.c((Object)a4, "null cannot be cast to non-null type kotlin.String");
                            a3.m((String)a4, (String)null, false);
                            if (!b) {
                                d.a(null);
                            }
                            return;
                        }
                        case -1212337029: {
                            if (!a2.equals((Object)"shareFilesWithResult")) {
                                break Label_0458;
                            }
                            break Label_0333;
                        }
                        case -1594861118: {
                            if (!a2.equals((Object)"shareWithResult")) {
                                break Label_0458;
                            }
                            break;
                        }
                        case -1811378728: {
                            if (!a2.equals((Object)"shareFiles")) {
                                break Label_0458;
                            }
                            break Label_0333;
                        }
                    }
                    this.a(j);
                    if (b && !this.b.c(d)) {
                        return;
                    }
                    final e1.c a5 = this.a;
                    final String a6 = j.a("text");
                    kotlin.jvm.internal.i.c((Object)a6, "null cannot be cast to non-null type kotlin.String");
                    a5.m((String)a6, (String)j.a("subject"), b);
                    if (b) {
                        return;
                    }
                    if (i) {
                        d.a("dev.fluttercommunity.plus/share/unavailable");
                        return;
                    }
                    d.a(null);
                    return;
                }
                this.a(j);
                if (b && !this.b.c(d)) {
                    return;
                }
                try {
                    final e1.c a7 = this.a;
                    final List a8 = j.a("paths");
                    kotlin.jvm.internal.i.b((Object)a8);
                    a7.n((List)a8, (List)j.a("mimeTypes"), (String)j.a("text"), (String)j.a("subject"), b);
                    if (!b) {
                        if (i) {
                            d.a("dev.fluttercommunity.plus/share/unavailable");
                        }
                        else {
                            d.a(null);
                        }
                    }
                }
                catch (final IOException ex) {
                    d.b("Share failed", ((Throwable)ex).getMessage(), null);
                }
                return;
            }
        }
        d.c();
    }
}
