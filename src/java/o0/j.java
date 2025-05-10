package o0;

import android.os.Bundle;
import android.os.IInterface;
import android.os.IBinder;
import u.a$a$a;
import d0.f$b;
import d0.f$a;
import f0.b;
import android.os.Looper;
import android.content.Context;
import u.a;
import com.google.android.gms.common.internal.c;

public final class j extends c
{
    private final a.a I;
    
    public j(final Context context, final Looper looper, final b b, final a.a a, final f$a f$a, final f$b f$b) {
        super(context, looper, 68, b, f$a, f$b);
        Object h = a;
        if (a == null) {
            h = a.a.h;
        }
        final a$a$a a$a$a = new a$a$a((a.a)h);
        a$a$a.a(g.a());
        this.I = new a.a(a$a$a);
    }
    
    protected final String D() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }
    
    protected final String E() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }
    
    public final int h() {
        return 12800000;
    }
    
    protected final Bundle z() {
        return this.I.a();
    }
}
