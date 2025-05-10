package u0;

import com.google.android.gms.common.api.Scope;
import d0.a;

public final class e
{
    public static final a.g<v0.a> a;
    public static final a.g<v0.a> b;
    public static final a.a<v0.a, u0.a> c;
    static final a.a<v0.a, d> d;
    public static final Scope e;
    public static final Scope f;
    public static final a<u0.a> g;
    public static final a<d> h;
    
    static {
        final a.g<v0.a> g2 = a = new a.g();
        final a.g<v0.a> g3 = b = new a.g();
        final a.a<v0.a, u0.a> a2 = c = (a.a)new b();
        final a.a<v0.a, d> a3 = d = (a.a)new c();
        e = new Scope("profile");
        f = new Scope("email");
        g = new a("SignIn.API", (a.a)a2, (a.g)g2);
        h = new a("SignIn.INTERNAL_API", (a.a)a3, (a.g)g3);
    }
}
