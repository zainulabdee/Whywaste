package a0;

import android.os.IInterface;
import android.os.IBinder;
import java.util.Iterator;
import com.google.android.gms.common.api.Scope;
import o0.g;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions$a;
import d0.f$b;
import d0.f$a;
import f0.b;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.c;

public final class h extends c
{
    private final GoogleSignInOptions I;
    
    public h(final Context context, final Looper looper, final b b, final GoogleSignInOptions googleSignInOptions, final f$a f$a, final f$b f$b) {
        super(context, looper, 91, b, f$a, f$b);
        GoogleSignInOptions$a googleSignInOptions$a;
        if (googleSignInOptions != null) {
            googleSignInOptions$a = new GoogleSignInOptions$a(googleSignInOptions);
        }
        else {
            googleSignInOptions$a = new GoogleSignInOptions$a();
        }
        googleSignInOptions$a.j(g.a());
        if (!b.d().isEmpty()) {
            final Iterator iterator = b.d().iterator();
            while (iterator.hasNext()) {
                googleSignInOptions$a.f((Scope)iterator.next(), new Scope[0]);
            }
        }
        this.I = googleSignInOptions$a.a();
    }
    
    protected final String D() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }
    
    protected final String E() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }
    
    public final int h() {
        return 12451000;
    }
    
    public final GoogleSignInOptions k0() {
        return this.I;
    }
}
